package teknodesa.devlops.pantaujuma.components.penduduk;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.Alamat;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.Penduduk;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.PendudukRealm;

public class CRUPendudukFragment extends Fragment implements PendudukContract.ViewController<PendudukRealm>, PendudukContract.View{
    FragmentActivity activity;

    BiodataFragment biodataFragment;
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

        //Penduduk newItem = new Penduduk(strNIK, strFoto, strNamaDepan, strNamaBelakang, strJenisKelamin, strTempatLahir, strTanggalLahir, strAgama, strGolonganDarah, strPekerjaan, strPendidikan, strAlamat, strRt, strRw, strDusun, strDesa, strKecamatan, strDatiII, strProvinsi, strNoHP, strNoTelp, strStatus);

        return v;
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
        biodataFragment = new BiodataFragment();
        alamatFragment = new AlamatFragment();

        adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());

        adapter.addFragment(biodataFragment);
        adapter.addFragment(alamatFragment);

        viewPager.setAdapter(adapter);

        tabs.setupWithViewPager(viewPager);
    }

    @Override
    public PendudukRealm getUIData() {
        Penduduk newPenduduk = biodataFragment.getUIData();
        Alamat newAlamat = alamatFragment.getUIData();

        PendudukRealm newRealmItem = new PendudukRealm();

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

        String hh = newPenduduk.toString();
        Toast.makeText(getContext(), hh, Toast.LENGTH_SHORT).show();
        return null;
    }

    @Override
    public void saveData(String tipe) {
        PendudukContract.Controller<PendudukRealm> mController = new PendudukController(this);
        PendudukRealm uiItem = getUIData();

        if(tipe.equals("insert")){
            mController.addItem(uiItem);
        }else{
            if(tipe.equals("update")){
                //TODO: implement this
            }
        }
    }

    @Override
    public void showNotification(String title, String header, String message) {

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

    public void replaceFragment(Fragment fragment) {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.viewPager, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }
}
