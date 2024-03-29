package teknodesa.devlops.pantaujuma.components.petugas;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
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
import teknodesa.devlops.pantaujuma.components.searchkomoditas.SearchKomoditasFragment;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.TargetParcelable;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.UserDB;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.petugas.TargetPetugas;

public class CRUTargetPetugasFragment extends Fragment implements TargetContract.ViewController<TargetPetugas>, TargetContract.View, SearchKomoditasFragment.OnClickKomoditasListener {

    @Inject
    Realm realm;

    @BindView(R.id.input_komoditas)
    EditText input_komoditas;

    @BindView(R.id.input_tahun)
    EditText input_tahun;

    @BindView(R.id.input_luastanam)
    EditText input_luastanam;

    @BindView(R.id.input_luaspanen)
    EditText input_luaspanen;

    @BindView(R.id.input_sasaranproduksi)
    EditText input_sasaranproduksi;

    @BindView(R.id.input_sasaranproduktifitas)
    EditText input_sasaranproduktifitas;

    @BindView(R.id.input_keterangan)
    EditText input_keterangan;

    @BindView(R.id.btnKomoditas)
    Button btnKomoditas;
    @OnClick(R.id.btnKomoditas)
    void clickPilihKomoditas() {
        SearchKomoditasFragment.keterangan = 1;
        SearchKomoditasFragment.newInstance(this).show(getActivity().getFragmentManager(), "");
    }

    private String komoditas = "";
    private String messageError;

    private AppComponent appComponent;
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

        View v = inflater.inflate(R.layout.fragment_crutargetpetugas, container, false);
        ButterKnife.bind(this, v);

        if(CRUActivity.mAction.equals("update")){
            setUIData();
            komoditas = DetailTargetActivity.idKomoditas;
        }

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public TargetPetugas getUIData() {
        String strTahun = input_tahun.getText().toString();
        String strLuasTanam = input_luastanam.getText().toString();
        String strLuasPanen = input_luaspanen.getText().toString();
        String strSasaranProduksi = input_sasaranproduksi.getText().toString();
        String strSasaranProduktifitas = input_sasaranproduktifitas.getText().toString();
        String strKeterangan = input_keterangan.getText().toString();

        TargetPetugas newRealmItem = new TargetPetugas();
        if(CRUActivity.mAction == "update"){
            newRealmItem.setHashId(DetailTargetActivity.dataTarget.getHashId());
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
        newRealmItem.setIdDesa(idDes);
        newRealmItem.setIdUser(idUs);

        if(komoditas.compareTo("")==0 || komoditas == null){
            messageError = messageError+" 'Komoditas'";
        }else{
            newRealmItem.setKomoditas(komoditas);
        }

        if(strTahun == null || strTahun.compareTo("")==0){
            newRealmItem.setTahun(0);
        }else{
            newRealmItem.setTahun(Integer.valueOf(strTahun));
        }

        if(strLuasTanam == null || strLuasTanam.compareTo("")==0){
            newRealmItem.setLuasTanam(0);
        }else{
            newRealmItem.setLuasTanam(Float.valueOf(strLuasTanam));
        }

        if(strLuasPanen == null || strLuasPanen.compareTo("")==0){
            newRealmItem.setLuasPanen(0);
        }else{
            newRealmItem.setLuasPanen(Float.valueOf(strLuasPanen));
        }

        if(strSasaranProduksi == null || strSasaranProduksi.compareTo("")==0){
            newRealmItem.setSasaranProduksi(0);
        }else{
            newRealmItem.setSasaranProduksi(Float.valueOf(strLuasPanen));
        }

        if(strSasaranProduktifitas == null || strSasaranProduktifitas.compareTo("")==0){
            newRealmItem.setSasaranProduktifitas(0);
        }else{
            newRealmItem.setSasaranProduktifitas(Float.valueOf(strSasaranProduktifitas));
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
    public void OnClickKomoditas(String idKomoditas, String nama, String deskripsi) {
        input_komoditas.setText(nama);
        komoditas = idKomoditas;
    }

    @Override
    public void setUIData() {
        input_komoditas.setText(DetailTargetActivity.dataKomoditas.getNama());
        input_tahun.setText(String.valueOf(DetailTargetActivity.dataTarget.getTahun()));
        input_luastanam.setText(String.valueOf(DetailTargetActivity.dataTarget.getLuasTanam()));
        input_luaspanen.setText(String.valueOf(DetailTargetActivity.dataTarget.getLuasPanen()));
        input_sasaranproduksi.setText(String.valueOf(DetailTargetActivity.dataTarget.getSasaranProduksi()));
        input_sasaranproduktifitas.setText(String.valueOf(DetailTargetActivity.dataTarget.getSasaranProduktifitas()));
        input_keterangan.setText(DetailTargetActivity.dataTarget.getKeterangan());
    }

    @Override
    public void saveData(String tipe, Parcelable itemData) {
        TargetContract.Controller<TargetPetugas> mController = new TargetController(this, appComponent);
        TargetPetugas uiItem = getUIData();

        if (tipe.equals("insert")) {
            mController.addItem(uiItem);
        } else {
            if (tipe.equals("update")) {
                String idItem = ((TargetParcelable) itemData).getHashId();
                mController.updateItem(idItem, uiItem);
            }
        }
    }

    @Override
    public void showNotification(String title, String header, String message) {
        Toast.makeText(CRUActivity.mContext, message, Toast.LENGTH_SHORT).show();
        startActivity(ListTargetActivity.createIntent(CRUActivity.mContext));
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
