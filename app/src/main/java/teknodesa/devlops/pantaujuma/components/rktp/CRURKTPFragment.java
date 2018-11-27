package teknodesa.devlops.pantaujuma.components.rktp;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.CRUActivity;
import teknodesa.devlops.pantaujuma.components.searchpoktan.SearchPoktanFragment;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.RKTP;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.UserDB;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.rktp.RKTPRealm;

public class CRURKTPFragment extends Fragment implements RKTPContract.ViewController<RKTPRealm>, RKTPContract.View, SearchPoktanFragment.OnClickPoktanListener {

    @Inject
    Realm realm;

    @BindView(R.id.input_tahun)
    EditText input_tahun;

    @BindView(R.id.input_tujuan)
    EditText input_tujuan;

    @BindView(R.id.input_masalah)
    EditText input_masalah;

    @BindView(R.id.input_sasaran)
    EditText input_sasaran;

    @BindView(R.id.input_materi)
    EditText input_materi;

    @BindView(R.id.input_metode)
    EditText input_metode;

    @BindView(R.id.input_volume)
    EditText input_volume;

    @BindView(R.id.input_lokasi)
    EditText input_lokasi;

    @BindView(R.id.input_waktu)
    EditText input_waktu;

    @BindView(R.id.input_keterangan)
    EditText input_keterangan;

    @BindView(R.id.btnWaktu)
    Button btnWaktu;
    @OnClick(R.id.btnWaktu)
    void setTanggal() {
        final Calendar calendar = Calendar.getInstance();
        int tanggal = calendar.get(Calendar.DAY_OF_MONTH),
                bulan = calendar.get(Calendar.MONTH),
                tahun = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), (view, year, month, dayOfMonth) -> {
            input_waktu.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
        }, tahun, bulan, tanggal);
        datePickerDialog.show();
    }

    @BindView(R.id.input_sumberbiaya)
    EditText input_sumberbiaya;

    @BindView(R.id.input_penanggungjawab)
    EditText input_penanggungjawab;

    @BindView(R.id.input_poktan)
    EditText input_poktan;

    @BindView(R.id.btnPoktan)
    Button btnPoktan;

    @OnClick(R.id.btnPoktan)
    void clickPilihPoktan() {
        SearchPoktanFragment.keterangan = 1;
        SearchPoktanFragment.newInstance(this).show(getActivity().getFragmentManager(), "");
    }

    private AppComponent appComponent;
    FragmentActivity activity;

    @BindView(R.id.input_pelaksana)
    EditText input_pelaksana;

    private String idPoktan = "";
    private String messageError;

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

        View v = inflater.inflate(R.layout.fragment_crurktp, container, false);
        ButterKnife.bind(this, v);

        if(CRUActivity.mAction == "update"){
            setUIData();
            idPoktan = DetailRKTPActivity.idPoktan;
        }else{

        }

        return v;
    }

    @Override
    public RKTPRealm getUIData() {
        messageError = "";

        String strTahun = input_tahun.getText().toString();
        String strTujuan = input_tujuan.getText().toString();
        String strMasalah = input_masalah.getText().toString();
        String strSasaran = input_sasaran.getText().toString();
        String strMateri = input_materi.getText().toString();
        String strMetode = input_metode.getText().toString();
        String strVolume = input_volume.getText().toString();
        String strLokasi = input_lokasi.getText().toString();
        String strWaktu = input_waktu.getText().toString();
        String strSumberBiaya = input_sumberbiaya.getText().toString();
        String strPenanggungJawab = input_penanggungjawab.getText().toString();
        String strPelaksana = input_pelaksana.getText().toString();
        String strKeterangan = input_keterangan.getText().toString();

        RKTPRealm newRealmItem = new RKTPRealm();

        if(CRUActivity.mAction == "update"){
            newRealmItem.setHashId(DetailRKTPActivity.dataRKTP.getHashId());
        }else{
            newRealmItem.setHashId(getSaltString());
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

        if(idPoktan.compareTo("")==0 || idPoktan == null){
            messageError = messageError+" Poktan";
        }else{
            newRealmItem.setPoktan(idPoktan);
        }

        newRealmItem.setIdDesa(idDes);
        newRealmItem.setIdUser(idUs);
        if(strTujuan == null || strTujuan.compareTo("")==0){
            newRealmItem.setTujuan("");
        }else{
            newRealmItem.setTujuan(strTujuan);
        }
        if(strTahun == null || strTahun.compareTo("")==0){
            newRealmItem.setTahun("");
        }else{
            newRealmItem.setTahun(strTahun);
        }
        if(strPelaksana == null || strPelaksana.compareTo("")==0){
            newRealmItem.setPelaksana("");
        }else{
            newRealmItem.setPelaksana(strPelaksana);
        }
        if(strPenanggungJawab == null || strPenanggungJawab.compareTo("")==0){
            newRealmItem.setPenanggungJawab("");
        }else{
            newRealmItem.setPenanggungJawab(strPenanggungJawab);
        }
        if(strSumberBiaya == null || strSumberBiaya.compareTo("")==0){
            newRealmItem.setSumberBiaya("");
        }else{
            newRealmItem.setSumberBiaya(strSumberBiaya);
        }
        if(strWaktu == null || strWaktu.compareTo("")==0){
            newRealmItem.setWaktu("");
        }else{
            newRealmItem.setWaktu(strWaktu);
        }
        if(strLokasi == null || strLokasi.compareTo("")==0){
            newRealmItem.setLokasi("");
        }else{
            newRealmItem.setLokasi(strLokasi);
        }
        if(strMasalah == null || strMasalah.compareTo("")==0){
            newRealmItem.setMasalah("");
        }else{
            newRealmItem.setMasalah(strMasalah);
        }
        if(strSasaran == null || strSasaran.compareTo("")==0){
            newRealmItem.setSasaran("");
        }else{
            newRealmItem.setSasaran(strSasaran);
        }
        if(strMateri == null || strMateri.compareTo("")==0){
            newRealmItem.setMateri("");
        }else{
            newRealmItem.setMateri(strMateri);
        }
        if(strMetode == null || strMetode.compareTo("")==0){
            newRealmItem.setMetode("");
        }else{
            newRealmItem.setMetode(strMetode);
        }
        if(strVolume == null || strVolume.compareTo("")==0){
            newRealmItem.setVolume("");
        }else{
            newRealmItem.setVolume(strVolume);
        }
        if(strKeterangan == null || strKeterangan.compareTo("")==0){
            newRealmItem.setKeterangan("");
        }else{
            newRealmItem.setKeterangan(strKeterangan);
        }
        newRealmItem.setIsSync(0);

        return newRealmItem;
    }

    @Override
    public void OnClickPoktan(String idKomoditas, String nama, String deskripsi) {
        input_poktan.setText(nama);
        idPoktan = idKomoditas;
    }

    @Override
    public void setUIData() {
        input_poktan.setText(DetailRKTPActivity.dataPoktan.getNama());
        input_tahun.setText(DetailRKTPActivity.dataRKTP.getTahun());
        input_tujuan.setText(DetailRKTPActivity.dataRKTP.getTujuan());
        input_masalah.setText(DetailRKTPActivity.dataRKTP.getMasalah());
        input_sasaran.setText(DetailRKTPActivity.dataRKTP.getSasaran());
        input_materi.setText(DetailRKTPActivity.dataRKTP.getMateri());
        input_metode.setText(DetailRKTPActivity.dataRKTP.getMetode());
        input_volume.setText(DetailRKTPActivity.dataRKTP.getVolume());
        input_lokasi.setText(DetailRKTPActivity.dataRKTP.getLokasi());
        input_waktu.setText(DetailRKTPActivity.dataRKTP.getWaktu());
        input_sumberbiaya.setText(DetailRKTPActivity.dataRKTP.getSumberBiaya());
        input_penanggungjawab.setText(DetailRKTPActivity.dataRKTP.getPenanggungJawab());
        input_pelaksana.setText(DetailRKTPActivity.dataRKTP.getPelaksana());
        input_keterangan.setText(DetailRKTPActivity.dataRKTP.getKeterangan());
    }

    @Override
    public void saveData(String tipe, Parcelable itemData) {
        RKTPContract.Controller<RKTPRealm> mController = new RKTPController(this, appComponent);
        RKTPRealm uiItem = getUIData();

        if(messageError.compareTo("")==0){
            if (tipe.equals("insert")) {
                mController.addItem(uiItem);
            } else {
                if (tipe.equals("update")) {
                    String idItem = ((RKTP) itemData).getHashId();
                    mController.updateItem(idItem, uiItem);
                }
            }
        }else {
            Toast.makeText(activity, "Harap mengisi data "+ messageError, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showNotification(String title, String header, String message) {
        Toast.makeText(CRUActivity.mContext, message, Toast.LENGTH_SHORT).show();
        startActivity(ListRKTPActivity.createIntent(CRUActivity.mContext));
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

}