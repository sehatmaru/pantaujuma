package teknodesa.devlops.pantaujuma.components.poktan;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.joanzapata.iconify.widget.IconTextView;

import java.text.SimpleDateFormat;
import java.util.Collections;
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
import teknodesa.devlops.pantaujuma.components.adapter.PengurusPoktanAdapter;
import teknodesa.devlops.pantaujuma.components.searchpetani.SearchPetaniFragment;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.UserDB;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.PengurusPoktanRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.PoktanRealm;
import teknodesa.devlops.pantaujuma.utils.Konstanta;

public class CRUPengurusPoktanFragment extends Fragment implements PoktanContract.ViewController<PengurusPoktanRealm>, PoktanContract.View, SearchPetaniFragment.OnClickPetaniListener{

    @Inject
    Realm realm;

    @BindView(R.id.spinnerIcon)
    IconTextView spinner;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    RecyclerView.LayoutManager linearLayoutManager;
    public PengurusPoktanAdapter mAdapter;
    private Context mContext;

    @BindView(R.id.input_nikpengurus)
    EditText input_nikpengurus;

    @BindView(R.id.btnPetaniPengurus)
    Button btnPetaniPengurus;
    @OnClick(R.id.btnPetaniPengurus)
    void clickPilihPetani() {
        SearchPetaniFragment.newInstance(this).show(getActivity().getFragmentManager(), "");
    }

    @BindView(R.id.input_namapengurus)
    EditText input_namapengurus;

    @BindView(R.id.input_jabatan)
    EditText input_jabatan;

    @BindView(R.id.input_periode)
    EditText input_periode;

    PoktanRealm dataPoktan = null;

    public static List<PengurusPoktanRealm> listData = Collections.EMPTY_LIST;
    public static List<PengurusPoktanRealm> listpengurusNotSync = Collections.EMPTY_LIST;

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
        listpengurusNotSync = realm.where(PengurusPoktanRealm.class).equalTo("isSync",0).findAll();
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

        View v = inflater.inflate(R.layout.fragment_crupenguruspoktan, container, false);
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
            listData = realm1.copyFromRealm(realm1.where(PengurusPoktanRealm.class).equalTo("poktanPengurus", DetailPoktanActivity.idPoktan).findAll());
        }, () -> {
            if (!listData.isEmpty()) {
                mAdapter = new PengurusPoktanAdapter(mContext, listData);
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
    public PengurusPoktanRealm getUIData() {
        String strJabatan = (input_jabatan.getText().toString() == null) ? "-" : input_jabatan.getText().toString();
        String strPeriode = (input_periode.getText().toString() == null) ? "-" : input_periode.getText().toString();

        PengurusPoktanRealm newItem = new PengurusPoktanRealm();
        newItem.setHashId(getSaltString());
        newItem.setPoktanPengurus(DetailPoktanActivity.idPoktan);
        newItem.setPetaniPengurus(biodata);
        newItem.setJabatan(strJabatan);
        newItem.setPeriode(strPeriode);
        newItem.setStatusPengurus(0);
        newItem.setIdDesa(getIdDesa());
        newItem.setIsSync(0);

        realm.beginTransaction();
        dataPoktan = realm.where(PoktanRealm.class).equalTo("hashId", DetailPoktanActivity.idPoktan).findFirst();
        dataPoktan.setIsSync(0);
        realm.commitTransaction();

        return newItem;
    }

    @Override
    public void setUIData() {

    }

    @Override
    public void saveData(String tipe, Parcelable itemData) {
        PoktanContract.Controller<PengurusPoktanRealm> mController = new PengurusPoktanController(this, appComponent);
        PengurusPoktanRealm uiItem = getUIData();

        if (tipe.equals("insert")) {
            mController.addItem(uiItem);
        } else {
            if (tipe.equals("update")) {
                String idItem = ((PengurusPoktanRealm) itemData).getHashId();
                mController.updateItem(idItem, uiItem);
            }
        }
    }

    @Override
    public void OnClickPetani(String idPenduduk, String namaDepan, String namaBelakang, String nik) {
        input_nikpengurus.setText(nik);
        input_namapengurus.setText(namaDepan);
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