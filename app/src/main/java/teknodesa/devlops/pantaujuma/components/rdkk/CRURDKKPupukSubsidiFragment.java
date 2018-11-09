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

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.CRUActivity;
import teknodesa.devlops.pantaujuma.components.searchkomoditas.SearchKomoditasFragment;
import teknodesa.devlops.pantaujuma.components.searchpetani.SearchPetaniFragment;
import teknodesa.devlops.pantaujuma.components.searchpoktan.SearchPoktanFragment;
import teknodesa.devlops.pantaujuma.components.searchpupuk.SearchPupukFragment;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.rdkk.RDKKParcelable;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.UserDB;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.rdkk.RDKKPupukSubsidiRealm;

public class CRURDKKPupukSubsidiFragment extends Fragment implements RDKKContract.ViewController<RDKKPupukSubsidiRealm>, RDKKContract.View, SearchPoktanFragment.OnClickPoktanListener, SearchKomoditasFragment.OnClickKomoditasListener, SearchPetaniFragment.OnClickPetaniListener, SearchPupukFragment.OnClickPupukListener {

    @Inject
    Realm realm;

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
        SearchPupukFragment.newInstance(this).show(getActivity().getFragmentManager(), "");
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
    public RDKKPupukSubsidiRealm getUIData() {
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

        if(CRUActivity.mAction == "update"){
            newRealmItem.setHashId(DetailRDKKActivity.dataRDKK.getHashId());
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
        newRealmItem.setPoktan(poktan);
        newRealmItem.setPetani(petani);
        newRealmItem.setKomoditas(komoditas);
        newRealmItem.setPupuk(pupuk);

        if(strJan == null || strJan.compareTo("")==0){
            newRealmItem.setButuhJanuari(0);
        }else{
            newRealmItem.setButuhJanuari(Integer.parseInt(strJan));
        }

        if(strFeb == null || strFeb.compareTo("")==0){
            newRealmItem.setButuhFebruari(0);
        }else{
            newRealmItem.setButuhFebruari(Integer.parseInt(strFeb));
        }

        if(strMar == null || strMar.compareTo("")==0){
            newRealmItem.setButuhMaret(0);
        }else{
            newRealmItem.setButuhMaret(Integer.parseInt(strMar));
        }

        if(strApr == null || strApr.compareTo("")==0){
            newRealmItem.setButuhApril(0);
        }else{
            newRealmItem.setButuhApril(Integer.parseInt(strApr));
        }

        if(strMei == null || strMei.compareTo("")==0){
            newRealmItem.setButuhMei(0);
        }else{
            newRealmItem.setButuhMei(Integer.parseInt(strMei));
        }

        if(strJun == null || strJun.compareTo("")==0){
            newRealmItem.setButuhJuni(0);
        }else{
            newRealmItem.setButuhJuni(Integer.parseInt(strJun));
        }

        if(strJul == null || strJul.compareTo("")==0){
            newRealmItem.setButuhJuli(0);
        }else{
            newRealmItem.setButuhJuli(Integer.parseInt(strJul));
        }

        if(strAug == null || strAug.compareTo("")==0){
            newRealmItem.setButuhAgustus(0);
        }else{
            newRealmItem.setButuhAgustus(Integer.parseInt(strAug));
        }

        if(strSep == null || strSep.compareTo("")==0){
            newRealmItem.setButuhSeptember(0);
        }else{
            newRealmItem.setButuhSeptember(Integer.parseInt(strSep));
        }

        if(strOkt == null || strOkt.compareTo("")==0){
            newRealmItem.setButuhOktober(0);
        }else{
            newRealmItem.setButuhOktober(Integer.parseInt(strOkt));
        }

        if(strNov == null || strNov.compareTo("")==0){
            newRealmItem.setButuhNovember(0);
        }else{
            newRealmItem.setButuhNovember(Integer.parseInt(strNov));
        }

        if(strDes == null || strDes.compareTo("")==0){
            newRealmItem.setButuhDesember(0);
        }else{
            newRealmItem.setButuhDesember(Integer.parseInt(strDes));
        }

        newRealmItem.setIsSync(0);

        return newRealmItem;
    }

    @Override
    public void setUIData() {
        input_poktan.setText(DetailRDKKActivity.dataPoktan.getNama());
        input_petani.setText(DetailRDKKActivity.dataPenduduk.getNamaDepan() + " " + DetailRDKKActivity.dataPenduduk.getNamaBelakang());
        input_komoditas.setText(DetailRDKKActivity.dataKomoditas.getNama());
        input_pupuk.setText(DetailRDKKActivity.dataPupuk.getNama());
        input_butuhjanuari.setText(String.valueOf(DetailRDKKActivity.dataRDKK.getButuhJanuari()));
        input_butuhfebruari.setText(String.valueOf(DetailRDKKActivity.dataRDKK.getButuhFebruari()));
        input_butuhmaret.setText(String.valueOf(DetailRDKKActivity.dataRDKK.getButuhMaret()));
        input_butuhapril.setText(String.valueOf(DetailRDKKActivity.dataRDKK.getButuhApril()));
        input_butuhmei.setText(String.valueOf(DetailRDKKActivity.dataRDKK.getButuhMei()));
        input_butuhjuni.setText(String.valueOf(DetailRDKKActivity.dataRDKK.getButuhJuni()));
        input_butuhjuli.setText(String.valueOf(DetailRDKKActivity.dataRDKK.getButuhJuli()));
        input_butuhagustus.setText(String.valueOf(DetailRDKKActivity.dataRDKK.getButuhAgustus()));
        input_butuhseptember.setText(String.valueOf(DetailRDKKActivity.dataRDKK.getButuhSeptember()));
        input_butuhoktober.setText(String.valueOf(DetailRDKKActivity.dataRDKK.getButuhOktober()));
        input_butuhnovember.setText(String.valueOf(DetailRDKKActivity.dataRDKK.getButuhNovember()));
        input_butuhdesember.setText(String.valueOf(DetailRDKKActivity.dataRDKK.getButuhDesember()));
    }

    @Override
    public void saveData(String tipe, Parcelable itemData) {
        RDKKContract.Controller<RDKKPupukSubsidiRealm> mController = new RDKKController(this, appComponent);
        RDKKPupukSubsidiRealm uiItem = getUIData();
        if (tipe.equals("insert")) {
            mController.addItem(uiItem);
        } else {
            if (tipe.equals("update")) {
                String idItem = ((RDKKParcelable) itemData).getHashId();
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

    @Override
    public void OnClickPupuk(String idPupuk, String nama, String jenis, String deskripsi) {
        pupuk = idPupuk;
        input_pupuk.setText(nama);
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