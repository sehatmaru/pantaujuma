package teknodesa.devlops.pantaujuma.components.rdk;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
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
import teknodesa.devlops.pantaujuma.components.rdk.form.RDKIdentitasFragment;
import teknodesa.devlops.pantaujuma.components.rdk.form.RDKIrigasiFragment;
import teknodesa.devlops.pantaujuma.components.rdk.form.RDKJadwalKegiatanFragment;
import teknodesa.devlops.pantaujuma.components.rdk.form.RDKRencanaUmumFragment;
import teknodesa.devlops.pantaujuma.components.rdk.form.RDKSasaranIntensifikasiFragment;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.rdk.Identitas;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.rdk.Irigasi;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.rdk.JadwalKegiatan;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.rdk.RencanaUmum;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.rdk.SasaranIntensifikasi;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.UserDB;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.rdk.RDKRealm;

public class CRURDKFragment extends Fragment implements RDKContract.ViewController<RDKRealm>, RDKContract.View {

    Identitas identitas = null;
    Irigasi irigasi = null;
    JadwalKegiatan jadwalKegiatan = null;
    RencanaUmum rencanaUmum = null;
    SasaranIntensifikasi sasaranIntensifikasi = null;

    @Inject
    Realm realm;

    private AppComponent appComponent;
    FragmentActivity activity;

    @Inject
    RDKIdentitasFragment rdkIdentitasFragment;

    @Inject
    RDKIrigasiFragment rdkIrigasiFragment;

    @Inject
    RDKJadwalKegiatanFragment rdkJadwalKegiatanFragment;

    @Inject
    RDKRencanaUmumFragment rdkRencanaUmumFragment;

    @Inject
    RDKSasaranIntensifikasiFragment rdkSasaranIntensifikasiFragment;

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

        View v = inflater.inflate(R.layout.fragment_crurdk, container, false);
        ButterKnife.bind(this, v);
        rdkIdentitasFragment = new RDKIdentitasFragment();
        rdkIrigasiFragment = new RDKIrigasiFragment();
        rdkJadwalKegiatanFragment = new RDKJadwalKegiatanFragment();
        rdkRencanaUmumFragment = new RDKRencanaUmumFragment();
        rdkSasaranIntensifikasiFragment = new RDKSasaranIntensifikasiFragment();
        setViewpager();
        setupTabIcons();
        viewPager.setCurrentItem(0);

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
        //Pager Identitas
        TextView tabIdentitas = (TextView) LayoutInflater.from(getActivity().getApplicationContext()).inflate(R.layout.tab_layout_item, null);
        tabIdentitas.setText("Identitas");
        tabIdentitas.setTextColor(getResources().getColor(R.color.black));
        tabs.getTabAt(0).setCustomView(tabIdentitas).setIcon(R.drawable.penduduk);

        //Pager Irigasi
        TextView tabIrigasi = (TextView) LayoutInflater.from(getActivity().getApplicationContext()).inflate(R.layout.tab_layout_item, null);
        tabIrigasi.setText("Irigasi");
        tabIrigasi.setTextColor(getResources().getColor(R.color.black));
        tabs.getTabAt(1).setCustomView(tabIrigasi).setIcon(R.drawable.penduduk);

        //Pager Jadwal Kegiatan
        TextView tabJadwalKegiatan = (TextView) LayoutInflater.from(getActivity().getApplicationContext()).inflate(R.layout.tab_layout_item, null);
        tabJadwalKegiatan.setText("Jadwal Kegiatan");
        tabJadwalKegiatan.setTextColor(getResources().getColor(R.color.black));
        tabs.getTabAt(2).setCustomView(tabJadwalKegiatan).setIcon(R.drawable.alamat);

        //Pager Rencana Umum
        TextView tabRencanaUmum = (TextView) LayoutInflater.from(getActivity().getApplicationContext()).inflate(R.layout.tab_layout_item, null);
        tabRencanaUmum.setText("Rencana Umum");
        tabRencanaUmum.setTextColor(getResources().getColor(R.color.black));
        tabs.getTabAt(3).setCustomView(tabRencanaUmum).setIcon(R.drawable.penduduk);

        //Pager Sasaran Intensifikasi
        TextView tabSaranaIntensifikasi = (TextView) LayoutInflater.from(getActivity().getApplicationContext()).inflate(R.layout.tab_layout_item, null);
        tabSaranaIntensifikasi.setText("Sarana Intensifikasi");
        tabSaranaIntensifikasi.setTextColor(getResources().getColor(R.color.black));
        tabs.getTabAt(4).setCustomView(tabSaranaIntensifikasi).setIcon(R.drawable.alamat);
    }

    private void setViewpager() {
        adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(rdkIdentitasFragment);
        adapter.addFragment(rdkIrigasiFragment);
        adapter.addFragment(rdkJadwalKegiatanFragment);
        adapter.addFragment(rdkRencanaUmumFragment);
        adapter.addFragment(rdkSasaranIntensifikasiFragment);

        viewPager.setAdapter(adapter);

        tabs.setupWithViewPager(viewPager);
    }

    @Override
    public RDKRealm getUIData() {
        RDKRealm newRealmItem = new RDKRealm();

        if (CRUActivity.mAction.equals("update")){
            RDKRealm dataRealm = getDataRDK(DetailRDKActivity.dataRDK.getHashId());
            newRealmItem.setHashId(DetailRDKActivity.dataRDK.getHashId());
            newRealmItem.setHashIdIrigasi(DetailRDKActivity.dataRDK.getHashIdIrigasi());
            newRealmItem.setHashIdRencana(DetailRDKActivity.dataRDK.getHashIdRencana());
            newRealmItem.setHashIdJadwal(DetailRDKActivity.dataRDK.getHashIdJadwal());
            newRealmItem.setHashIdSasaran(DetailRDKActivity.dataRDK.getHashIdSasaran());
            newRealmItem.setIrigasi(DetailRDKActivity.dataRDK.getIrigasi());
            newRealmItem.setRencana(DetailRDKActivity.dataRDK.getRencana());
            newRealmItem.setKegiatan(DetailRDKActivity.dataRDK.getKegiatan());
            newRealmItem.setIntensifikasi(DetailRDKActivity.dataRDK.getIntensifikasi());
            newRealmItem.setPoktan(dataRealm.getPoktan());
            newRealmItem.setTanggal(dataRealm.getTanggal());
            newRealmItem.setLuasSawah(dataRealm.getLuasSawah());
            newRealmItem.setKeterangan(dataRealm.getKeterangan());
            newRealmItem.setNama(dataRealm.getNama());
            newRealmItem.setDeskripsiIrigasi(dataRealm.getDeskripsiIrigasi());
            newRealmItem.setKegiatanJK(dataRealm.getKegiatanJK());
            newRealmItem.setTanggalJK(dataRealm.getTanggalJK());
            newRealmItem.setDeskripsiJK(dataRealm.getDeskripsiJK());
            newRealmItem.setPaketTeknologi(dataRealm.getPaketTeknologi());
            newRealmItem.setPolaTanam(dataRealm.getPolaTanam());
            newRealmItem.setJadwalTanam(dataRealm.getJadwalTanam());
            newRealmItem.setKomoditasRU(dataRealm.getKomoditasRU());
            newRealmItem.setVarietas(dataRealm.getVarietas());
            newRealmItem.setSumberBenih(dataRealm.getSumberBenih());
            newRealmItem.setTabunganAnggota(dataRealm.getTabunganAnggota());
            newRealmItem.setIuranAnggota(dataRealm.getIuranAnggota());
            newRealmItem.setPemupukanModal(dataRealm.getPemupukanModal());
            newRealmItem.setKomoditasSI(dataRealm.getKomoditasSI());
            newRealmItem.setTarget(dataRealm.getTarget());
            newRealmItem.setTargetHasilPerHa(dataRealm.getTargetHasilPerHa());

        } else {
            String hashIdIrigasi = getSaltString();
            String hashIdJadwal = getSaltString();
            String hashIdRencana = getSaltString();
            String hashIdSasaran = getSaltString();

            newRealmItem.setIrigasi(hashIdIrigasi);
            newRealmItem.setRencana(hashIdRencana);
            newRealmItem.setKegiatan(hashIdJadwal);
            newRealmItem.setIntensifikasi(hashIdSasaran);
            newRealmItem.setHashId(getSaltString());
            newRealmItem.setHashIdIrigasi(hashIdIrigasi);
            newRealmItem.setHashIdRencana(hashIdRencana);
            newRealmItem.setHashIdJadwal(hashIdJadwal);
            newRealmItem.setHashIdSasaran(hashIdSasaran);
        }

        if(RDKIdentitasFragment.isOpen){
            identitas = rdkIdentitasFragment.getUIData();
            newRealmItem.setPoktan(identitas.getPoktan());
            newRealmItem.setTanggal(identitas.getTanggal());
            newRealmItem.setLuasSawah(identitas.getLuasSawah());
            newRealmItem.setKeterangan(identitas.getKeterangan());
        }
        if(RDKIrigasiFragment.isOpen){
            irigasi = rdkIrigasiFragment.getUIData();
            newRealmItem.setNama(irigasi.getNama());
            newRealmItem.setDeskripsiIrigasi(irigasi.getDeskripsiIrigasi());
        }
        if(RDKJadwalKegiatanFragment.isOpen){
            jadwalKegiatan = rdkJadwalKegiatanFragment.getUIData();
            newRealmItem.setKegiatanJK(jadwalKegiatan.getKegiatanJK());
            newRealmItem.setTanggalJK(jadwalKegiatan.getTanggalJK());
            newRealmItem.setDeskripsiJK(jadwalKegiatan.getDeskripsiJK());
        }
        if(RDKRencanaUmumFragment.isOpen){
            rencanaUmum = rdkRencanaUmumFragment.getUIData();
            newRealmItem.setPaketTeknologi(rencanaUmum.getPaketTeknologi());
            newRealmItem.setPolaTanam(rencanaUmum.getPolaTanam());
            newRealmItem.setJadwalTanam(rencanaUmum.getJadwalTanam());
            newRealmItem.setKomoditasRU(rencanaUmum.getKomoditasRU());
            newRealmItem.setVarietas(rencanaUmum.getVarietas());
            newRealmItem.setSumberBenih(rencanaUmum.getSumberBenih());
            newRealmItem.setTabunganAnggota(rencanaUmum.getTabunganAnggota());
            newRealmItem.setIuranAnggota(rencanaUmum.getIuranAnggota());
            newRealmItem.setPemupukanModal(rencanaUmum.getPemupukanModal());
        }
        if(RDKSasaranIntensifikasiFragment.isOpen){
            sasaranIntensifikasi = rdkSasaranIntensifikasiFragment.getUIData();
            newRealmItem.setKomoditasSI(sasaranIntensifikasi.getKomoditasSI());
            newRealmItem.setTarget(sasaranIntensifikasi.getTarget());
            newRealmItem.setTargetHasilPerHa(sasaranIntensifikasi.getTargetHasilPerHa());
        }
        UserDB userDB = getData();
        int idDes;
        try {
            idDes =  Integer.valueOf(userDB.getAttributeValue());
        }catch (Exception e){
            idDes = 0;
        }
        String idUs;
        try {
            idUs =  userDB.getId();
        }catch (Exception e){
            idUs = "";
        }
        newRealmItem.setIdDesa(idDes);
        newRealmItem.setIdUser(idUs);
        newRealmItem.setIsSync(0);
        return newRealmItem;
    }

    @Override
    public void setUIData() {

    }

    @Override
    public void saveData(String tipe, Parcelable itemData) {
        RDKContract.Controller<RDKRealm> mController = new RDKController(this, appComponent);
        RDKRealm uiItem = getUIData();

        if(RDKIdentitasFragment.isOpen){
            identitas = rdkIdentitasFragment.getUIData();
        }
        if(RDKRencanaUmumFragment.isOpen){
            rencanaUmum = rdkRencanaUmumFragment.getUIData();
        }
        if(RDKSasaranIntensifikasiFragment.isOpen){
            sasaranIntensifikasi = rdkSasaranIntensifikasiFragment.getUIData();
        }

        if(tipe.equals("insert")){
            if (identitas.getPoktan() == null || rencanaUmum.getKomoditasRU() == null || sasaranIntensifikasi.getKomoditasSI() == null){
                Toast.makeText(activity, "Harap mengisi Poktan dan Komoditas", Toast.LENGTH_SHORT).show();
            } else {
                mController.addItem(uiItem);
            }
        }

        if (tipe.equals("update")) {
            RDKRealm dataRealm = getDataRDK(DetailRDKActivity.dataRDK.getHashId());
            if (dataRealm.getKomoditasRU() == null || dataRealm.getPoktan() == null || dataRealm.getKomoditasSI() == null){
                Toast.makeText(activity, "Harap mengisi Poktan dan Komoditas", Toast.LENGTH_SHORT).show();
            } else{
                mController.updateItem(uiItem.getHashId(), uiItem);
            }
        }
    }

    @Override
    public void showNotification(String title, String header, String message) {
        Toast.makeText(CRUActivity.mContext, message, Toast.LENGTH_SHORT).show();
        startActivity(ListRDKActivity.createIntent(CRUActivity.mContext));
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

    public UserDB getData() {
        realm.beginTransaction();
        UserDB user =realm.where(UserDB.class).findFirst();
        realm.commitTransaction();
        if(user == null){
            return null;
        }else{
            return user;
        }
    }

    public RDKRealm getDataRDK(String id) {
        realm.beginTransaction();
        RDKRealm data =realm.where(RDKRealm.class).equalTo("hashId",id).findFirst();
        realm.commitTransaction();
        if(data == null){
            return null;
        }else{
            return data;
        }
    }

}

