package teknodesa.devlops.pantaujuma.components.petani;

import android.graphics.Color;
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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
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
import teknodesa.devlops.pantaujuma.components.profile.AkunFragment;
import teknodesa.devlops.pantaujuma.components.searchpenduduk.SearchPendudukFragment;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.enums.Status;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.petani.PetaniParcelable;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.UserDB;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.penduduk.PendudukRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.petani.PetaniRealm;

public class CRUPetaniFragment extends Fragment implements
        PetaniContract.ViewController<PetaniRealm>, PetaniContract.View, SearchPendudukFragment.OnClickPendudukListener {

    @Inject
    Realm realm;

    @BindView(R.id.input_status)
    Spinner input_status;

    @BindView(R.id.input_nik)
    EditText input_nik;

    @BindView(R.id.input_namadepan)
    EditText input_namadepan;

    @BindView(R.id.input_namabelakang)
    EditText input_namabelakang;

    @BindView(R.id.input_deskripsi)
    EditText input_deskripsi;

    @BindView(R.id.btnPenduduk)
    Button btnPenduduk;

    @OnClick(R.id.btnPenduduk)
    void clickPilihPenduduk() {
        SearchPendudukFragment.newInstance(this).show(getActivity().getFragmentManager(), "");
    }

    private String biodata = DetailPetaniActivity.idPenduduk;

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

        View v = inflater.inflate(R.layout.fragment_crupetani, container, false);
        ButterKnife.bind(this, v);


        setAdapter();
        return v;
    }

    private void setAdapter(){
        input_status.setAdapter(new ArrayAdapter<Status>(getActivity(), R.layout.spinner_item, Status.values()) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(CRUActivity.mAction.equals("update")){
            setUIData();
        }
    }

    void setSpinnerSelection(String data, String[] sources, Spinner spinner){
        int i = 0;
        for (String source : sources){
            if (i < sources.length){
                if (source.equals(data)){
                    spinner.setSelection(i);
                }
                i++;
            } else {
                spinner.setSelection(0);
            }
        }
    }

    @Override
    public PetaniRealm getUIData() {
        String strDeskripsi = (input_deskripsi.getText().toString() == null) ? "-" : input_deskripsi.getText().toString();
        String strStatus = input_status.getSelectedItem().toString();

        PetaniRealm newRealmItem = new PetaniRealm();

        if (CRUActivity.mAction.equals("update")) {
            newRealmItem.setHashId(DetailPetaniActivity.idPetani);
        } else {
            newRealmItem.setHashId(getSaltString());
        }
        newRealmItem.setDeskripsi(strDeskripsi);
        newRealmItem.setStatus(strStatus);
        newRealmItem.setBiodata(biodata);
        newRealmItem.setIdDesa(getIdDesa());
        newRealmItem.setFoto("image.jpg");

        return newRealmItem;
    }

    @Override
    public void OnClickPenduduk(String idPenduduk, String namaDepan, String namaBelakang, String nik) {
        input_nik.setText(nik);
        input_namadepan.setText(namaDepan);
        input_namabelakang.setText(namaBelakang);
        biodata = idPenduduk;
    }

    @Override
    public void setUIData() {
        setAdapter();
        input_nik.setText(DetailPetaniActivity.dataPenduduk.getNIK());
        input_namadepan.setText(DetailPetaniActivity.dataPenduduk.getNamaDepan());
        input_namabelakang.setText(DetailPetaniActivity.dataPenduduk.getNamaBelakang());
        input_deskripsi.setText(DetailPetaniActivity.dataPetani.getDeskripsi());
        String[] sourcesStatus= {"Pilih salah satu", "Aktif", "Non-Aktif"};
        setSpinnerSelection(DetailPetaniActivity.dataPetani.getStatus(),sourcesStatus,input_status);

    }

    @Override
    public void saveData(String tipe, Parcelable itemData) {
        PetaniContract.Controller<PetaniRealm> mController = new PetaniController(this, appComponent);
        PetaniRealm uiItem = getUIData();

        if (tipe.equals("insert")) {
            mController.addItem(uiItem);
        } else {
            if (tipe.equals("update")) {
                String idItem = ((PetaniParcelable) itemData).getHashId();
                mController.updateItem(idItem, uiItem);
            }
        }
    }

    @Override
    public void showNotification(String title, String header, String message) {
        Toast.makeText(CRUActivity.mContext, message, Toast.LENGTH_SHORT).show();
        startActivity(ListPetaniActivity.createIntent(CRUActivity.mContext));
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
    public String getIdDesa() {
        realm.beginTransaction();
        UserDB user =realm.where(UserDB.class).findFirst();
        realm.commitTransaction();
        String res;
        if(user == null){
            res = "";
        }else{
            try {
                res = user.getAttributeValue();
            }catch (Exception e){
                res = "";
            }
        }
        return res;
    }
}
