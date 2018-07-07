package teknodesa.devlops.pantaujuma.components.penduduk;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmModel;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.CRUActivity;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.Alamat;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.Penduduk;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.PendudukRealm;

public class CRUPendudukFragment extends Fragment implements PendudukContract.ViewController<Penduduk>, PendudukContract.View {
    Penduduk newPenduduk = null;
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
        ((MainApplication) getActivity().getApplication())
                .getComponent()
                .inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_crupenduduk, container, false);
        ButterKnife.bind(this, v);

        setViewpager();
        setupTabIcons();
        viewPager.setCurrentItem(0);
        //viewPager.getCurrentItem();

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        biodataFragment = new BiodataFragment();
        alamatFragment = new AlamatFragment();

        if(CRUActivity.mAction.equals("insert")){
            newPenduduk = biodataFragment.getUIData();
            newAlamat = alamatFragment.getUIData();

            getUIData();
        }else {
            if(CRUActivity.mAction.equals("update")){
                setUIData();
            }
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
    public Penduduk getUIData() {

        Penduduk newRealmItem = new Penduduk();

        newRealmItem.setNIK(newPenduduk.getNIK());
        newRealmItem.setNamaDepan(newPenduduk.getNamaDepan());
        newRealmItem.setNamaBelakang(newPenduduk.getNamaBelakang());
        newRealmItem.setJenisKelamin(newPenduduk.getJenisKelamin());
        newRealmItem.setTempatLahir(newPenduduk.getTempatLahir());
        newRealmItem.setTanggalLahir(newPenduduk.getTanggalLahir());
        newRealmItem.setAgama(newPenduduk.getAgama());
        newRealmItem.setGolonganDarah(newPenduduk.getGolonganDarah());
        newRealmItem.setPekerjaan(newPenduduk.getPekerjaan());
        newRealmItem.setPendidikan(newPenduduk.getPendidikan());
        newRealmItem.setStatus(newPenduduk.getStatus());

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

        newRealmItem.setDeleted(false);

        String hh = newPenduduk.toString();
        hh = hh + " - " + newAlamat.toString();
        //Toast.makeText(getContext(), hh, Toast.LENGTH_SHORT).show();
        return newRealmItem;
    }

    @Override
    public void setUIData() {
        /*if (biodataFragment != null) {
            biodataFragment.setUIData();
        } else {
            Toast.makeText(CRUActivity.mContext, "biodata", Toast.LENGTH_SHORT).show();
        }

        if (alamatFragment != null) {
            alamatFragment.setUIData();
        } else {
            Toast.makeText(CRUActivity.mContext, "alamat", Toast.LENGTH_SHORT).show();
        }*/
    }

    public static void setDeletedData(Parcelable itemData, AppComponent appComp) {
        PendudukContract.Controller<Penduduk> mController = new PendudukController(new CRUPendudukFragment(), appComp);
        int idItem = ((Penduduk) itemData).getIdPenduduk();
        mController.setItemDeleted(idItem);
    }

    @Override
    public void saveData(String tipe, Parcelable itemData) {
        PendudukContract.Controller<Penduduk> mController = new PendudukController(this, appComponent);
        Penduduk uiItem = getUIData();

        if (tipe.equals("insert")) {
            mController.addItem(uiItem);
        } else {
            if (tipe.equals("update")) {
                int idItem = ((Penduduk) itemData).getIdPenduduk();
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
}
