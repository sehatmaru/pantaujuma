package teknodesa.devlops.pantaujuma.components.lahan.formlahan;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
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
import teknodesa.devlops.pantaujuma.components.lahan.DetailLahanActivity;
import teknodesa.devlops.pantaujuma.components.lahan.LahanContract;
import teknodesa.devlops.pantaujuma.components.lahan.LahanController;
import teknodesa.devlops.pantaujuma.components.lahan.ListLahanActivity;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.lahan.AlamatLahanModel;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.lahan.LahanModel;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.UserDB;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.LahanRealm;


public class CRULahanFragment extends Fragment implements LahanContract.ViewController<LahanRealm>,LahanContract.View{

    LahanModel lahanModel = null;
    AlamatLahanModel alamatLahanModel = null;

    CRUDataLahanFragment cruDataLahanFragment;
    CRUAlamatLahanFragment cruAlamatLahanFragment;

    ViewPagerAdapter adapter;

    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    private AppComponent appComponent;
    @Inject
    Realm realm;
    private String messageEror;
    FragmentActivity activity;
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

        View v = inflater.inflate(R.layout.fragment_crulahan, container, false);
        ButterKnife.bind(this, v);

        setViewpager();
        setupTabIcons();
        viewPager.setCurrentItem(0);
        return v;
    }

    private void setupTabIcons() {
        //Pager Detail Lahan
        TextView tabPenduduk = (TextView) LayoutInflater.from(getActivity().getApplicationContext()).inflate(R.layout.tab_layout_item, null);
        tabPenduduk.setText("Detail Lahan");
        tabPenduduk.setTextColor(getResources().getColor(R.color.black));
        tabs.getTabAt(0).setCustomView(tabPenduduk).setIcon(R.drawable.penduduk);

        //Pager Alamat
        TextView tabAlamat = (TextView) LayoutInflater.from(getActivity().getApplicationContext()).inflate(R.layout.tab_layout_item, null);
        tabAlamat.setText("Alamat");
        tabAlamat.setTextColor(getResources().getColor(R.color.black));
        tabs.getTabAt(1).setCustomView(tabAlamat).setIcon(R.drawable.alamat);
    }
    private void setViewpager() {
        cruDataLahanFragment = new CRUDataLahanFragment();
        cruAlamatLahanFragment = new CRUAlamatLahanFragment();
        adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(cruDataLahanFragment);
        adapter.addFragment(cruAlamatLahanFragment);
        viewPager.setAdapter(adapter);
        tabs.setupWithViewPager(viewPager);
    }

    @Override
    public void showNotification(String title, String header, String message) {
        getActivity().finish();
        Toast.makeText(getActivity().getApplicationContext(), "Data berhasil di update", Toast.LENGTH_SHORT).show();
        startActivity(ListLahanActivity.createIntent(getActivity().getApplicationContext()));
    }

    @Override
    public LahanRealm getUIData() {
        messageEror="";

        LahanRealm data = new LahanRealm();
        if(CRUActivity.mAction.equals("update")){
            data.setHashId(DetailLahanActivity.dataLahan.getHashId());
        }else{
            data.setHashId(getSaltString());
        }
        lahanModel = cruDataLahanFragment.getUIData();
        data.setPemilik(lahanModel.getPemilik());
        data.setNamaPemilikLahan(lahanModel.getNamaPemilikLahan());
        data.setLuas(lahanModel.getLuas());
        data.setBatasBarat(lahanModel.getBatasBarat());
        data.setBatasSelatan(lahanModel.getBatasSelatan());
        data.setBatasTimur(lahanModel.getBatasTimur());
        data.setBatasUtara(lahanModel.getBatasUtara());
        data.setDeskripsi(lahanModel.getDeskripsi());

        alamatLahanModel = cruAlamatLahanFragment.getUIData();
        data.setAlamat(alamatLahanModel.getAlamat());
        data.setRt(alamatLahanModel.getRt());
        data.setRw(alamatLahanModel.getRw());
        data.setDusun(alamatLahanModel.getDusun());
        data.setDesa(alamatLahanModel.getDesa());
        data.setNamaKecamatan(alamatLahanModel.getNamaKecamatan());
        data.setDatiII(alamatLahanModel.getDatiII());
        data.setProvinsi(alamatLahanModel.getProvinsi());
        data.setLatitude(alamatLahanModel.getLatitude());
        data.setLongitude(alamatLahanModel.getLongitude());
        try {
            data.setIsSync(0);
            return data;
        }catch (Exception e){
            return  null;
        }
    }

    @Override
    public void setUIData() {

    }

    @Override
    public void saveData(String tipe, Parcelable itemData) {
        LahanContract.Controller<LahanRealm> mController = new LahanController(this,appComponent);
        LahanRealm uiItem = getUIData();
        if(uiItem == null){
            Toast.makeText(activity, "Silahkan Login Kembali, terjadi kesalahan server" + messageEror, Toast.LENGTH_SHORT).show();
        }else{
            if(messageEror.compareTo("")==0){
                if (tipe.equals("insert")) {
                    mController.addItem(uiItem);
                } else {
                    if (tipe.equals("update")) {
                        String idItem = uiItem.getHashId();
                        mController.updateItem(idItem, uiItem);
                    }
                }
            }else {
                Toast.makeText(activity, "Harap mengisi data "+ messageEror, Toast.LENGTH_SHORT).show();
            }
        }

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
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 16) { // length of the random string.
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
