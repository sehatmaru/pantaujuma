package teknodesa.devlops.pantaujuma.components.poktan;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.CRUActivity;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.Poktan;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.UserDB;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.PoktanRealm;

public class CRUIdentitasPoktanFragment extends Fragment implements PoktanContract.ViewController<PoktanRealm>, PoktanContract.View{

    @BindView(R.id.input_nama)
    EditText input_namapoktan;

    @BindView(R.id.input_desa)
    EditText input_desa;

    @BindView(R.id.input_kecamatan)
    EditText input_kecamatan;

    @BindView(R.id.input_tanggaldidirikan)
    EditText input_tanggaldidirikan;

    @BindView(R.id.btnTanggalDidirikan)
    Button btnTanggalDidirikan;
    @OnClick(R.id.btnTanggalDidirikan)
    void setTanggal() {
        final Calendar calendar = Calendar.getInstance();
        int tanggal = calendar.get(Calendar.DAY_OF_MONTH),
                bulan = calendar.get(Calendar.MONTH),
                tahun = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), (view, year, month, dayOfMonth) -> {
            input_tanggaldidirikan.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
        }, tahun, bulan, tanggal);
        datePickerDialog.show();
    }

    @BindView(R.id.input_alamat)
    EditText input_alamat;

    @BindView(R.id.input_deskripsi)
    EditText input_deskripsi;

    @BindView(R.id.input_hp)
    EditText input_hp;

    @BindView(R.id.input_telp)
    EditText input_telp;

    private AppComponent appComponent;
    FragmentActivity activity;

    private String idPoktan = "";

    @Inject
    Realm realm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MainApplication) getActivity().getApplication())
                .getComponent()
                .inject(this);

        appComponent = ((MainApplication) getActivity().getApplication()).getComponent();
        appComponent.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_cruidentitaspoktan, container, false);
        ButterKnife.bind(this, v);
        
        if(CRUActivity.mAction == "update"){
            textForEdit();
            idPoktan = DetailPoktanActivity.idPoktan;
        }else{

        }

        setData();

        return v;
    }

    private void setData(){
        UserDB userDB = getData();
        if(userDB != null){
            input_desa.setText(userDB.getNamaDesa());
            input_kecamatan.setText(userDB.getKecamatan());
        }else{
            input_desa.setText("-");
            input_kecamatan.setText("-");
        }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        if(CRUActivity.mAction.equals("update")){
            setUIData();
        }
    }

    @Override
    public PoktanRealm getUIData() {
        String strAlamat = input_alamat.getText().toString();
        String strTanggalDidirikan = input_tanggaldidirikan.getText().toString();
        String strDeskripsi = input_deskripsi.getText().toString();
        String strNamaPoktan = input_namapoktan.getText().toString();
        String strDesa = input_desa.getText().toString();
        String strKecamatan = input_kecamatan.getText().toString();
        String strNoHP = input_hp.getText().toString();
        String strNoTelp = input_telp.getText().toString();

        PoktanRealm newItem = new PoktanRealm();

        if(CRUActivity.mAction == "update"){
            newItem.setHashId(DetailPoktanActivity.dataPoktan.getHashId());
        }else{
            newItem.setHashId(getSaltString());
        }

        if(strAlamat == null || strAlamat.compareTo("")==0){
            newItem.setAlamat("");
        }else{
            newItem.setAlamat(strAlamat);
        }

        if(strTanggalDidirikan == null || strTanggalDidirikan.compareTo("")==0){
            newItem.setTanggalDidirikan("");
        }else{
            newItem.setTanggalDidirikan(strTanggalDidirikan);
        }

        if(strDeskripsi == null || strDeskripsi.compareTo("")==0){
            newItem.setDeskripsi("");
        }else{
            newItem.setDeskripsi(strDeskripsi);
        }

        if(strNamaPoktan == null || strNamaPoktan.compareTo("")==0){
            newItem.setNama("");
        }else{
            newItem.setNama(strNamaPoktan);
        }

        if(strDesa == null || strDesa.compareTo("")==0){
            newItem.setDesa("");
        }else{
            newItem.setDesa(strDesa);
        }

        if(strKecamatan == null || strKecamatan.compareTo("")==0){
            newItem.setKecamatan("");
        }else{
            newItem.setKecamatan(strKecamatan);
        }

        if(strNoHP == null || strNoHP.compareTo("")==0){
            newItem.setNoHP("");
        }else{
            newItem.setNoHP(strNoHP);
        }

        if(strNoTelp == null || strNoTelp.compareTo("")==0){
            newItem.setNoTelp("");
        }else{
            newItem.setNoTelp(strNoTelp);
        }

//        newItem.setNama(strNamaPoktan);
//        newItem.setAlamat(strAlamat);
//        newItem.setTanggalDidirikan(strTanggalDidirikan);
//        newItem.setDeskripsi(strDeskripsi);
//        newItem.setDesa(strDesa);
//        newItem.setKecamatan(strKecamatan);
//        newItem.setNoHP(strNoHP);
//        newItem.setNoTelp(strNoTelp);
//        newItem.setStatusPoktan(0);
//        newItem.setIdDesa(getIdDesa());
        newItem.setIsSync(0);

        return newItem;
    }

    @Override
    public void setUIData() {

    }

    void textForEdit(){
        try{
            input_namapoktan.setText(DetailPoktanActivity.dataPoktan.getNama());
            input_desa.setText(DetailPoktanActivity.dataPoktan.getDesa());
            input_kecamatan.setText(DetailPoktanActivity.dataPoktan.getKecamatan());
            input_tanggaldidirikan.setText(DetailPoktanActivity.dataPoktan.getTanggalDidirikan());
            input_alamat.setText(DetailPoktanActivity.dataPoktan.getAlamat());
            input_hp.setText(DetailPoktanActivity.dataPoktan.getNoHP());
            input_telp.setText(DetailPoktanActivity.dataPoktan.getNoTelp());
            input_deskripsi.setText(DetailPoktanActivity.dataPoktan.getDeskripsi());
        } catch (NullPointerException e){

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

    @Override
    public void saveData(String tipe, Parcelable itemData) {
        PoktanContract.Controller<PoktanRealm> mController = new PoktanController(this, appComponent);
        PoktanRealm uiItem = getUIData();

        if (tipe.equals("insert")) {
            mController.addItem(uiItem);
        } else {
            if (tipe.equals("update")) {
                String idItem = ((Poktan) itemData).getHashId();
                mController.updateItem(idItem, uiItem);
            }
        }
    }

    @Override
    public void showNotification(String title, String header, String message) {
        Toast.makeText(CRUActivity.mContext, message, Toast.LENGTH_SHORT).show();
        startActivity(ListPoktanActivity.createIntent(CRUActivity.mContext));
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