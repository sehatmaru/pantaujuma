package teknodesa.devlops.pantaujuma.components.penduduk.form;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.CRUActivity;
import teknodesa.devlops.pantaujuma.components.penduduk.DetailPendudukActivity;
import teknodesa.devlops.pantaujuma.components.penduduk.ListPendudukActivity;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.PendudukParcelable;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.penduduk.Alamat;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.penduduk.BiodataPenduduk;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.UserDB;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.penduduk.PendudukRealm;

public class CRUPendudukFragment extends Fragment implements PendudukContract.ViewController<PendudukRealm>, PendudukContract.View {

    BiodataPenduduk biodataPenduduk = null;
    Alamat newAlamat = null;

    @Inject
    Realm realm;

    private AppComponent appComponent;
    FragmentActivity activity;

    @Inject
    BiodataFragment biodataFragment;

    @Inject
    AlamatFragment alamatFragment;

    ViewPagerAdapter adapter;

    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.viewPager)
    ViewPager viewPager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();

        appComponent = ((MainApplication) getActivity().getApplication()).getComponent();
        appComponent.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_crupenduduk, container, false);
        ButterKnife.bind(this, v);
        biodataFragment = new BiodataFragment();
        alamatFragment = new AlamatFragment();
        setViewpager();
        setupTabIcons();
        viewPager.setCurrentItem(0);
        //viewPager.getCurrentItem();

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



        if(CRUActivity.mAction.equals("update")){
            setUIData();
        }
    }

    private void setupTabIcons() {
        //Pager Biodata
        TextView tabPenduduk = (TextView) LayoutInflater.from(getActivity().getApplicationContext()).inflate(R.layout.tab_layout_item, null);
        tabPenduduk.setText("Biodata");
        tabPenduduk.setTextColor(getResources().getColor(R.color.black));
        tabs.getTabAt(0).setCustomView(tabPenduduk).setIcon(R.drawable.penduduk);

        //Pager Alamat
        TextView tabAlamat = (TextView) LayoutInflater.from(getActivity().getApplicationContext()).inflate(R.layout.tab_layout_item, null);
        tabAlamat.setText("Alamat");
        tabAlamat.setTextColor(getResources().getColor(R.color.black));
        tabs.getTabAt(1).setCustomView(tabAlamat).setIcon(R.drawable.alamat);
    }

    private void setViewpager() {
        adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());

        adapter.addFragment(biodataFragment);
        adapter.addFragment(alamatFragment);

        viewPager.setAdapter(adapter);

        tabs.setupWithViewPager(viewPager);
    }

    @Override
    public PendudukRealm getUIData() {

        biodataPenduduk = biodataFragment.getUIData();
        newAlamat = alamatFragment.getUIData();
        PendudukRealm newRealmItem = new PendudukRealm();
        if(CRUActivity.mAction == "update"){
            newRealmItem.setHashId(DetailPendudukActivity.dataPenduduk.getHashId());
        }else{
            newRealmItem.setHashId(getSaltString());
        }
        newRealmItem.setNIK(biodataPenduduk.getNIK());
        newRealmItem.setNamaDepan(biodataPenduduk.getNamaDepan());
        newRealmItem.setNamaBelakang(biodataPenduduk.getNamaBelakang());
        newRealmItem.setJenisKelamin(biodataPenduduk.getJenisKelamin());
        newRealmItem.setTempatLahir(biodataPenduduk.getTempatLahir());
        newRealmItem.setTanggalLahir(biodataPenduduk.getTanggalLahir());
        newRealmItem.setAgama(biodataPenduduk.getAgama());
        newRealmItem.setGolonganDarah(biodataPenduduk.getGolonganDarah());
        newRealmItem.setPekerjaan(biodataPenduduk.getPekerjaan());
        newRealmItem.setPendidikan(biodataPenduduk.getPendidikan());
        newRealmItem.setStatus(biodataPenduduk.getStatus());
        newRealmItem.setAlamat(newAlamat.getAlamat());
        newRealmItem.setRt(newAlamat.getRt());
        newRealmItem.setRw(newAlamat.getRw());
        newRealmItem.setDusun(newAlamat.getDusun());
        newRealmItem.setDesa(newAlamat.getDesa());
        newRealmItem.setKecamatan(newAlamat.getKecamatan());
        newRealmItem.setDatiII(newAlamat.getDatiII());
        newRealmItem.setProvinsi(newAlamat.getProvinsi());
        newRealmItem.setKodePos(newAlamat.getKodePos());
        newRealmItem.setEmail(newAlamat.getEmail());
        newRealmItem.setNoHP(newAlamat.getNoHP());
        newRealmItem.setNoTelp(newAlamat.getNoTelp());
        newRealmItem.setIsSync(0);
        newRealmItem.setIdDesa(getIdDesa());


        Log.e("penduduk",newRealmItem.toString());
        return newRealmItem;
    }

    @Override
    public void setUIData() {

    }

    public static void setDeletedData(Parcelable itemData, AppComponent appComp) {
        PendudukContract.Controller<PendudukRealm> mController = new PendudukController(new CRUPendudukFragment(), appComp);
        String idItem = ((PendudukRealm) itemData).getHashId();
        mController.setItemDeleted(idItem);
    }

    @Override
    public void saveData(String tipe, Parcelable itemData) {
        PendudukContract.Controller<PendudukRealm> mController = new PendudukController(this, appComponent);
        PendudukRealm uiItem = getUIData();

        if (tipe.equals("insert")) {
            mController.addItem(uiItem);
        } else {
            if (tipe.equals("update")) {
                String idItem = ((PendudukParcelable) itemData).getHashId();
                mController.updateItem(idItem, uiItem);
            }
        }
    }

    @Override
    public void showNotification(String title, String header, String message) {
        Toast.makeText(CRUActivity.mContext, message, Toast.LENGTH_SHORT).show();
        startActivity(ListPendudukActivity.createIntent(CRUActivity.mContext));
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment) {
            mFragmentList.add(fragment);
        }
    }
    protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        return timeStamp + "" + salt.toString();
    }
    public int getIdDesa() {
        realm.beginTransaction();
        UserDB user =realm.where(UserDB.class).findFirst();
        realm.commitTransaction();
        int res;
        if(user == null){
            res = 0;
        }else{
            try {
                res = Integer.valueOf(user.getAttributeValue());
            }catch (Exception e){
                res = 0;
            }
        }
        return res;
    }
}
