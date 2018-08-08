package teknodesa.devlops.pantaujuma.components.rdkk;

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
import teknodesa.devlops.pantaujuma.components.searchpetani.SearchPetaniFragment;
import teknodesa.devlops.pantaujuma.components.searchpoktan.SearchPoktanFragment;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.rdkk.RDKKPupukSubsidiRealm;

public class CRURDKKPupukSubsidiFragment extends Fragment implements RDKKContract.ViewController<RDKKPupukSubsidiRealm>, RDKKContract.View, SearchPoktanFragment.OnClickPoktanListener, SearchKomoditasFragment.OnClickKomoditasListener, SearchPetaniFragment.OnClickPetaniListener {

    @BindView(R.id.input_poktan)
    EditText input_poktan;

    @BindView(R.id.btnPoktan)
    Button btnPoktan;
    @OnClick(R.id.btnPoktan)
    void clickPilihPoktan() {
        SearchPoktanFragment.keterangan = 1;
        SearchPoktanFragment.newInstance(this).show(getActivity().getFragmentManager(), "");
    }

    @BindView(R.id.input_komoditas)
    EditText input_komoditas;

    @BindView(R.id.btnKomoditas)
    Button btnKomoditas;
    @OnClick(R.id.btnKomoditas)
    void clickPilihKomoditas() {
        SearchKomoditasFragment.newInstance(this).show(getActivity().getFragmentManager(), "");
    }

    @BindView(R.id.input_pupuk)
    EditText input_pupuk;

    @BindView(R.id.btnPupuk)
    Button btnPupuk;
    @OnClick(R.id.btnPupuk)
    void clickPilihPupuk() {
        //SearchPupukFragment.newInstance(this).show(getActivity().getFragmentManager(), "");
    }

    @BindView(R.id.input_petani)
    EditText input_petani;

    @BindView(R.id.btnPetani)
    Button btnPetani;
    @OnClick(R.id.btnPetani)
    void clickPilihPetani() {
        SearchPetaniFragment.newInstance(this).show(getActivity().getFragmentManager(), "");
    }

    @BindView(R.id.input_butuhjanuari)
    EditText input_butuhjanuari;

    @BindView(R.id.input_butuhfebruari)
    EditText input_butuhfebruari;

    @BindView(R.id.input_butuhmaret)
    EditText input_butuhmaret;

    @BindView(R.id.input_butuhapril)
    EditText input_butuhapril;

    @BindView(R.id.input_butuhmei)
    EditText input_butuhmei;

    @BindView(R.id.input_butuhjuni)
    EditText input_butuhjuni;

    @BindView(R.id.input_butuhjuli)
    EditText input_butuhjuli;

    @BindView(R.id.input_butuhagustus)
    EditText input_butuhagustus;

    @BindView(R.id.input_butuhseptember)
    EditText input_butuhseptember;

    @BindView(R.id.input_butuhoktober)
    EditText input_butuhoktober;

    @BindView(R.id.input_butuhnovember)
    EditText input_butuhnovember;

    @BindView(R.id.input_butuhdesember)
    EditText input_butuhdesember;

    private AppComponent appComponent;
    FragmentActivity activity;

    String poktan;
    String petani;
    String pupuk;
    String komoditas;

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

        View v = inflater.inflate(R.layout.fragment_crurdkkpupuksubsidi, container, false);
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
    public RDKKPupukSubsidiRealm getUIData() {;

        String strJan = input_butuhjanuari.getText().toString();
        String strFeb = input_butuhfebruari.getText().toString();
        String strMar = input_butuhmaret.getText().toString();
        String strApr = input_butuhapril.getText().toString();
        String strMei = input_butuhmei.getText().toString();
        String strJun = input_butuhjuni.getText().toString();
        String strJul = input_butuhjuli.getText().toString();
        String strAug = input_butuhagustus.getText().toString();
        String strSep = input_butuhseptember.getText().toString();
        String strOkt = input_butuhoktober.getText().toString();
        String strNov = input_butuhnovember.getText().toString();
        String strDes = input_butuhdesember.getText().toString();

        RDKKPupukSubsidiRealm newRealmItem = new RDKKPupukSubsidiRealm();
        newRealmItem.setHashId(getSaltString());
        newRealmItem.setPoktan(poktan);
        newRealmItem.setPetani(petani);
        newRealmItem.setKomoditas(komoditas);
        newRealmItem.setPupuk(pupuk);
        newRealmItem.setButuhJanuari(Float.parseFloat(strJan));
        newRealmItem.setButuhFebruari(Float.parseFloat(strFeb));
        newRealmItem.setButuhMaret(Float.parseFloat(strMar));
        newRealmItem.setButuhApril(Float.parseFloat(strApr));
        newRealmItem.setButuhMei(Float.parseFloat(strMei));
        newRealmItem.setButuhJuni(Float.parseFloat(strJun));
        newRealmItem.setButuhJuli(Float.parseFloat(strJul));
        newRealmItem.setButuhAgustus(Float.parseFloat(strAug));
        newRealmItem.setButuhSeptember(Float.parseFloat(strSep));
        newRealmItem.setButuhOktober(Float.parseFloat(strOkt));
        newRealmItem.setButuhNovember(Float.parseFloat(strNov));
        newRealmItem.setButuhDesember(Float.parseFloat(strDes));

        return newRealmItem;
    }

    @Override
    public void setUIData() {

    }

    @Override
    public void saveData(String tipe, Parcelable itemData) {
        RDKKContract.Controller<RDKKPupukSubsidiRealm> mController = new RDKKController(this, appComponent);
        RDKKPupukSubsidiRealm uiItem = getUIData();

        if (tipe.equals("insert")) {
            mController.addItem(uiItem);
        } else {
            if (tipe.equals("update")) {
                String idItem = ((RDKKPupukSubsidiRealm) itemData).getHashId();
                mController.updateItem(idItem, uiItem);
            }
        }
    }

    @Override
    public void showNotification(String title, String header, String message) {
        Toast.makeText(CRUActivity.mContext, message, Toast.LENGTH_SHORT).show();
        startActivity(ListRDKKActivity.createIntent(CRUActivity.mContext));
    }

    @Override
    public void OnClickPoktan(String idPoktan, String nama, String deskripsi) {
        input_poktan.setText(nama);
        poktan = idPoktan;
    }

    @Override
    public void OnClickPetani(String idPetani, String namaDepan, String namaBelakang, String nik) {
        input_petani.setText(namaDepan);
        petani = idPetani;
    }

    @Override
    public void OnClickKomoditas(String idKomoditas, String nama, String deskripsi) {
        input_komoditas.setText(nama);
        komoditas = idKomoditas;
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
