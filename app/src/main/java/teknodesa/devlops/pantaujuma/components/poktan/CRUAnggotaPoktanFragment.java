package teknodesa.devlops.pantaujuma.components.poktan;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.joanzapata.iconify.widget.IconTextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.Sort;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.CRUActivity;
import teknodesa.devlops.pantaujuma.components.adapter.AnggotaPoktanAdapter;
import teknodesa.devlops.pantaujuma.components.profile.AkunFragment;
import teknodesa.devlops.pantaujuma.components.searchpetani.SearchPetaniFragment;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.AnggotaPoktan;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.UserDB;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.AnggotaPoktanRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.PoktanRealm;
import teknodesa.devlops.pantaujuma.utils.Konstanta;

public class CRUAnggotaPoktanFragment extends Fragment implements PoktanContract.ViewController<AnggotaPoktanRealm>, PoktanContract.View, SearchPetaniFragment.OnClickPetaniListener{

    @Inject
    Realm realm;

    @BindView(R.id.spinnerIcon)
    IconTextView spinner;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    RecyclerView.LayoutManager linearLayoutManager;
    public AnggotaPoktanAdapter mAdapter;
    private Context mContext;

    @BindView(R.id.input_nikanggota)
    EditText input_nikanggota;

    @BindView(R.id.btnPetaniAnggota)
    Button btnPetaniAnggota;
    @OnClick(R.id.btnPetaniAnggota)
    void clickPilihPetani() {
        SearchPetaniFragment.newInstance(this).show(getActivity().getFragmentManager(), "");
    }

    @BindView(R.id.input_namaanggota)
    EditText input_namaanggota;

    @BindView(R.id.input_tanggalmasuk)
    EditText input_tanggalmasuk;

    @BindView(R.id.btnTanggalMasuk)
    Button btnTanggalMasuk;
    @OnClick(R.id.btnTanggalMasuk)
    void setTanggal() {
        final Calendar calendar = Calendar.getInstance();
        int tanggal = calendar.get(Calendar.DAY_OF_MONTH),
                bulan = calendar.get(Calendar.MONTH),
                tahun = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), (view, year, month, dayOfMonth) -> {
            input_tanggalmasuk.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
        }, tahun, bulan, tanggal);
        datePickerDialog.show();
    }

    public static List<AnggotaPoktanRealm> listData = Collections.EMPTY_LIST;
    public static List<AnggotaPoktanRealm> listanggotaNotSync = Collections.EMPTY_LIST;
    PoktanRealm dataPoktan = null;

    private AppComponent appComponent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MainApplication) getActivity().getApplication())
                .getComponent()
                .inject(this);

        appComponent = ((MainApplication) getActivity().getApplication()).getComponent();
        appComponent.inject(this);

        realm.beginTransaction();
        listanggotaNotSync = realm.where(AnggotaPoktanRealm.class).equalTo("isSync",0).findAll();
        Log.e("ini list anggota", "" + listanggotaNotSync.toString());
        realm.commitTransaction();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(CRUActivity.mAction.equals("update")){
            setUIData();
        }
    }

    public static boolean isOpen= false;
    private String biodata;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_cruanggotapoktan, container, false);
        ButterKnife.bind(this, v);
        isOpen = true;
        populateInitialData();

        mContext = getActivity().getApplicationContext();

        return v;
    }

    private void updateLayout(String status) {
        switch (status) {
            case Konstanta.LAYOUT_SUCCESS:
                spinner.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
                break;
            case Konstanta.LAYOUT_EMPTY:
                spinner.setText("");
                break;
            case Konstanta.LAYOUT_ERROR:
                spinner.setText("{fa-info 200%} Error");
                break;
            case Konstanta.LAYOUT_LOADING:
                recyclerView.setVisibility(View.GONE);
                spinner.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }

    private void populateInitialData(){
        realm.executeTransactionAsync(realm1 -> {
            listData = realm1.copyFromRealm(realm1.where(AnggotaPoktanRealm.class).equalTo("poktanAnggota", DetailPoktanActivity.idPoktan).sort("tanggalMasuk", Sort.DESCENDING).findAll());
        }, () -> {
            if (!listData.isEmpty()) {
                Log.e("List Anggota","ini hasil"+listData.size());
                mAdapter = new AnggotaPoktanAdapter(mContext, listData);
//                recyclerView.setAdapter(mAdapter);
//                recyclerView.setLayoutManager(linearLayoutManager);
                LinearLayoutManager manager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(manager);
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(mAdapter);
                updateLayout(Konstanta.LAYOUT_SUCCESS);
            }else {
                updateLayout(Konstanta.LAYOUT_EMPTY);
            }
        });
    }

    @Override
    public AnggotaPoktanRealm getUIData() {
        String strTanggalMasuk = (input_tanggalmasuk.getText().toString() == null) ? "-" : input_tanggalmasuk.getText().toString();

        AnggotaPoktanRealm newItem = new AnggotaPoktanRealm();
        newItem.setHashId(getSaltString());
        newItem.setPoktanAnggota(DetailPoktanActivity.idPoktan);
        newItem.setPetaniAnggota(biodata);
        newItem.setTanggalMasuk(strTanggalMasuk);
        newItem.setStatusAnggota(0);
        newItem.setIdDesa(getIdDesa());
        newItem.setIsSync(0);

        realm.beginTransaction();
        dataPoktan = realm.where(PoktanRealm.class).equalTo("hashId", DetailPoktanActivity.idPoktan).findFirst();
        dataPoktan.setIsSync(0);
        realm.commitTransaction();

        Log.e("data anggota" , "" + newItem.toString());

        return newItem;
    }

    @Override
    public void setUIData() {

    }

    @Override
    public void saveData(String tipe, Parcelable itemData) {
        PoktanContract.Controller<AnggotaPoktanRealm> mController = new AnggotaPoktanController(this, appComponent);
        AnggotaPoktanRealm uiItem = getUIData();

        if (tipe.equals("insert")) {
            mController.addItem(uiItem);
        } else {
            if (tipe.equals("update")) {
                String idItem = ((AnggotaPoktanRealm) itemData).getHashId();
                mController.updateItem(idItem, uiItem);
            }
        }
    }

    @Override
    public void OnClickPetani(String idPenduduk, String namaDepan, String namaBelakang, String nik) {
        input_nikanggota.setText(nik);
        input_namaanggota.setText(namaDepan);
        biodata = idPenduduk;
    }

    @Override
    public void showNotification(String title, String header, String message) {
        Toast.makeText(CRUActivity.mContext, message, Toast.LENGTH_SHORT).show();
        startActivity(ListPoktanActivity.createIntent(CRUActivity.mContext));
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