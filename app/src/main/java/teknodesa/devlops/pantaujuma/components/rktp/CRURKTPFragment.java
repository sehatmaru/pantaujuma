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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.CRUActivity;
import teknodesa.devlops.pantaujuma.components.petugas.ListTargetActivity;
import teknodesa.devlops.pantaujuma.components.searchpoktan.SearchPoktanFragment;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.UserDB;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.PoktanRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.rktp.RKTPRealm;

public class CRURKTPFragment extends Fragment implements RKTPContract.ViewController<RKTPRealm>, RKTPContract.View, SearchPoktanFragment.OnClickPoktanListener {

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

    @BindView(R.id.btnWaktu)
    Button btnWaktu;
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

    private String komoditas;

    private String idUser;
    private UserDB userDB;

    private AppComponent appComponent;
    FragmentActivity activity;

    @BindView(R.id.input_pelaksana)
    EditText input_pelaksana;

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

        return v;
    }

    @Override
    public RKTPRealm getUIData() {
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


        RKTPRealm newRealmItem = new RKTPRealm();
        PoktanRealm poktanRealm = new PoktanRealm();

        newRealmItem.setHashId(getSaltString());
        newRealmItem.setPoktan(poktanRealm.getHashId());
        newRealmItem.setTujuan(strTujuan);
        newRealmItem.setTahun(strTahun);
        newRealmItem.setPelaksana(strPelaksana);
        newRealmItem.setPenanggungJawab(strPenanggungJawab);
        newRealmItem.setSumberBiaya(strSumberBiaya);
        newRealmItem.setWaktu(strWaktu);
        newRealmItem.setLokasi(strLokasi);
        newRealmItem.setMasalah(strMasalah);
        newRealmItem.setSasaran(strSasaran);
        newRealmItem.setMateri(strMateri);
        newRealmItem.setMetode(strMetode);
        newRealmItem.setVolume(strVolume);
        return newRealmItem;
    }

    @Override
    public void OnClickPoktan(String idKomoditas, String nama, String deskripsi) {
        input_poktan.setText(nama);
    }

    @Override
    public void setUIData() {

    }

    @Override
    public void saveData(String tipe, Parcelable itemData) {
        RKTPContract.Controller<RKTPRealm> mController = new RKTPController(this, appComponent);
        RKTPRealm uiItem = getUIData();

        if (tipe.equals("insert")) {
            mController.addItem(uiItem);
        } else {
            if (tipe.equals("update")) {
                String idItem = ((PoktanRealm) itemData).getHashId();
                mController.updateItem(idItem, uiItem);
            }
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
}