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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.CRUActivity;
import teknodesa.devlops.pantaujuma.components.searchkomoditas.SearchKomoditasFragment;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.UserDB;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.KomoditasRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.petugas.TargetPetugas;

public class CRUTargetPetugasFragment extends Fragment implements TargetContract.ViewController<TargetPetugas>, TargetContract.View, SearchKomoditasFragment.OnClickKomoditasListener {

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

    private String komoditas;

    private String idUser;
    private UserDB userDB;

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

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(CRUActivity.mAction.equals("update")){
            setUIData();
        }
    }

    @Override
    public TargetPetugas getUIData() {
        String strTahun = "";
        String strLuasTanam = "";
        String strLuasPanen = "";
        String strSasaranProduksi = "";
        String strSasaranProduktifitas = "";
        String strKeterangan = "";

        try{
            strTahun = (input_tahun.getText().toString() == null) ? "-" : input_tahun.getText().toString();
            strLuasTanam = (input_luastanam.getText().toString() == null) ? "-" : input_luastanam.getText().toString();
            strLuasPanen = (input_luaspanen.getText().toString() == null) ? "-" : input_luaspanen.getText().toString();
            strSasaranProduksi = (input_sasaranproduksi.getText().toString() == null) ? "-" : input_sasaranproduksi.getText().toString();
            strSasaranProduktifitas = (input_sasaranproduktifitas.getText().toString() == null) ? "-" : input_sasaranproduktifitas.getText().toString();
            strKeterangan = (input_keterangan.getText().toString() == null) ? "-" : input_keterangan.getText().toString();
        } catch (NullPointerException e){}

        TargetPetugas newRealmItem = new TargetPetugas();
        newRealmItem.setHashId(getSaltString());
        newRealmItem.setKomoditas(komoditas);
        newRealmItem.setTahun(Integer.parseInt(strTahun));
        newRealmItem.setLuasTanam(Float.parseFloat(strLuasTanam));
        newRealmItem.setLuasPanen(Float.parseFloat(strLuasPanen));
        newRealmItem.setSasaranProduksi(Float.parseFloat(strSasaranProduksi));
        newRealmItem.setSasaranProduktifitas(Float.parseFloat(strSasaranProduktifitas));
        newRealmItem.setKeterangan(strKeterangan);

        return newRealmItem;
    }

    @Override
    public void OnClickKomoditas(String idKomoditas, String nama, String deskripsi) {
        input_komoditas.setText(nama);
        komoditas = idKomoditas;
    }

    @Override
    public void setUIData() {

    }

    @Override
    public void saveData(String tipe, Parcelable itemData) {
        TargetContract.Controller<TargetPetugas> mController = new TargetController(this, appComponent);
        TargetPetugas uiItem = getUIData();

        if (tipe.equals("insert")) {
            mController.addItem(uiItem);
        } else {
            if (tipe.equals("update")) {
                String idItem = ((KomoditasRealm) itemData).getHashId();
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
}
