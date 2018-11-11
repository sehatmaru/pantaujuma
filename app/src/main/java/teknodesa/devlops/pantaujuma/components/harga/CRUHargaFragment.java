package teknodesa.devlops.pantaujuma.components.harga;

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
import teknodesa.devlops.pantaujuma.components.searchkomoditas.SearchKomoditasFragment;
import teknodesa.devlops.pantaujuma.components.searchpasar.SearchPasarFragment;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.Harga;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.harga.HargaRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.pasar.PasarRealm;

public class CRUHargaFragment extends Fragment implements HargaContract.ViewController<HargaRealm>, HargaContract.View, SearchKomoditasFragment.OnClickKomoditasListener, SearchPasarFragment.OnClickPasarListener {

    @Inject
    Realm realm;

    @BindView(R.id.input_komoditas)
    EditText input_komoditas;

    @BindView(R.id.input_pasar)
    EditText input_pasar;

    @BindView(R.id.input_tanggal)
    EditText input_tanggal;

    @BindView(R.id.input_harga)
    EditText input_harga;

    @BindView(R.id.input_satuan)
    EditText input_satuan;

    @BindView(R.id.btnKomoditas)
    Button btnKomoditas;
    @OnClick(R.id.btnKomoditas)
    void clickPilihKomoditas() {
        SearchKomoditasFragment.newInstance(this).show(getActivity().getFragmentManager(), "");
    }

    @BindView(R.id.btnPasar)
    Button btnPasar;
    @OnClick(R.id.btnPasar)
    void clickPilihPasar() {
        SearchPasarFragment.newInstance(this).show(getActivity().getFragmentManager(), "");
    }

    @BindView(R.id.btnTanggal)
    Button btnTanggal;
    @OnClick(R.id.btnTanggal)
    void setTanggal() {
        final Calendar calendar = Calendar.getInstance();
        int tanggal = calendar.get(Calendar.DAY_OF_MONTH),
                bulan = calendar.get(Calendar.MONTH),
                tahun = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), (view, year, month, dayOfMonth) -> {
            input_tanggal.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
        }, tahun, bulan, tanggal);
        datePickerDialog.show();
    }

    private String komoditas = "";
    private String strpasar = "";
    private String strnama = "";
    private String stralamat = "";
    private String strkecamatan = "";
    private String strkabupaten = "";
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

        View v = inflater.inflate(R.layout.fragment_cruharga, container, false);
        ButterKnife.bind(this, v);

        if(CRUActivity.mAction.equals("update")){
            setUIData();

            komoditas = DetailHargaActivity.idKomoditas;
            strpasar = DetailHargaActivity.idPasar;
            strnama = DetailHargaActivity.nama;
            stralamat = DetailHargaActivity.alamat;
            strkecamatan = DetailHargaActivity.kecamatan;
            strkabupaten = DetailHargaActivity.kabupaten;
        }

        return v;
    }

    @Override
    public HargaRealm getUIData() {
        messageError = "";

//        String strTanggal = (input_tanggal.getText().toString() == null) ? "-" : input_tanggal.getText().toString();
//        String strHarga = (input_harga.getText().toString() == null) ? "-" : input_harga.getText().toString();
//        String strSatuan = (input_satuan.getText().toString() == null) ? "-" : input_satuan.getText().toString();

        String strTanggal = input_tanggal.getText().toString();
        String strHarga = input_harga.getText().toString();
        String strSatuan = input_satuan.getText().toString();

        HargaRealm newRealmItem = new HargaRealm();

        if(CRUActivity.mAction == "update"){
            newRealmItem.setHashId(DetailHargaActivity.dataHarga.getHashId());
        }else{
            newRealmItem.setHashId(getSaltString());
        }

        if(komoditas.compareTo("")==0 || komoditas == null){
            messageError = messageError+" 'Komoditas'";
        }else{
            newRealmItem.setHashKomoditas(komoditas);
        }

        if(strpasar.compareTo("")==0 || strpasar == null){
            messageError = messageError+" 'Pasar'";
        }else{
            newRealmItem.setHashPasar(strpasar);
        }

        if(strTanggal == null || strTanggal.compareTo("")==0){
            newRealmItem.setTanggal("");
        }else{
            newRealmItem.setTanggal(strTanggal);
        }

        if(strHarga == null || strHarga.compareTo("")==0){
            newRealmItem.setNilai("");
        }else{
            newRealmItem.setNilai(strHarga);
        }

        if(strSatuan == null || strSatuan.compareTo("")==0){
            newRealmItem.setSatuan("");
        }else{
            newRealmItem.setSatuan(strSatuan);
        }

//        newRealmItem.setHashKomoditas(komoditas);
//        newRealmItem.setHashPasar(strpasar);
//        newRealmItem.setTanggal(strTanggal);
//        newRealmItem.setNilai(strHarga);
//        newRealmItem.setSatuan(strSatuan);
        newRealmItem.setNamaPasar(strnama);
        newRealmItem.setAlamat(stralamat);
        newRealmItem.setKecamatan(strkecamatan);
        newRealmItem.setKabupaten(strkabupaten);
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
        input_komoditas.setText(DetailHargaActivity.dataKomoditas.getNama());
        input_pasar.setText(DetailHargaActivity.dataHarga.getNamaPasar());
        input_tanggal.setText(DetailHargaActivity.dataHarga.getTanggal());
        input_harga.setText(DetailHargaActivity.dataHarga.getNilai());
        input_satuan.setText(DetailHargaActivity.dataHarga.getSatuan());
    }

    @Override
    public void saveData(String tipe, Parcelable itemData) {
        HargaContract.Controller<HargaRealm> mController = new HargaController(this, appComponent);
        HargaRealm uiItem = getUIData();

        if(messageError.compareTo("")==0){
            if (tipe.equals("insert")) {
                mController.addItem(uiItem);
            } else {
                if (tipe.equals("update")) {
                    String idItem = ((HargaRealm) itemData).getHashId();
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
        startActivity(ListHargaActivity.createIntent(CRUActivity.mContext));
    }

    @Override
    public void OnClickPasar(String idPasar, String nama, String alamat, String kecamatan, String kabupaten) {
        strpasar = idPasar;
        strnama = nama;
        stralamat = alamat;
        strkecamatan = kecamatan;
        strkabupaten = kabupaten;

        input_pasar.setText(nama);
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
}
