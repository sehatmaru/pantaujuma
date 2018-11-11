package teknodesa.devlops.pantaujuma.components.lahan.formlahan;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ShareCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.CRUActivity;
import teknodesa.devlops.pantaujuma.components.lahan.DetailLahanActivity;
import teknodesa.devlops.pantaujuma.components.lahan.LahanContract;
import teknodesa.devlops.pantaujuma.components.maps.GPSTracker;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.lahan.AlamatLahanModel;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.UserDB;

/**
 * Created by Marthin on 11/11/2018.
 */

public class CRUAlamatLahanFragment extends Fragment implements LahanContract.ViewController<AlamatLahanModel>{

    @BindView(R.id.input_alamat)
    EditText input_alamat;

    @BindView(R.id.input_rt)
    EditText input_rt;

    @BindView(R.id.input_rw)
    EditText input_rw;

    @BindView(R.id.input_dusun)
    EditText input_dusun;

    @BindView(R.id.input_desa)
    EditText input_desa;

    @BindView(R.id.input_kecamatan)
    EditText input_kecamatan;

    @BindView(R.id.input_datiii)
    EditText input_datiii;

    @BindView(R.id.input_provinsi)
    EditText input_provinsi;


    @Inject
    Realm realm;

    private static final int RESPONSE_PICKER = 1;
    private static final int REQUEST_PICKER = 1;
    private double latitudeAdd=0.0;
    private double longitudeAdd=0.0;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MainApplication) getActivity().getApplication()).getComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cru_alamat_lahan, null);
        ButterKnife.bind(this, v);
        if(CRUActivity.mAction == "update"){
            setUIData();
        }
        setData();
        input_alamat.setOnClickListener(view -> {
            PlacePicker.IntentBuilder intentBuilder = new PlacePicker.IntentBuilder();
            Intent intent = null;
            try {
                intent = intentBuilder.build(getActivity());
                startActivityForResult(intent, REQUEST_PICKER);
            } catch (GooglePlayServicesRepairableException e) {
                e.printStackTrace();
            } catch (GooglePlayServicesNotAvailableException e) {
                e.printStackTrace();
            }
        });
        return v;
    }

    private void setData(){
        UserDB userDB = getData();
        if(userDB != null){
            input_desa.setText(userDB.getNamaDesa());
            input_kecamatan.setText(userDB.getKecamatan());
            input_datiii.setText(userDB.getKabupatenKota());
            input_provinsi.setText(userDB.getProvinsi());
        }else{
            input_desa.setText("-");
            input_kecamatan.setText("-");
            input_datiii.setText("-");
            input_provinsi.setText("-");
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        input_alamat = getActivity().findViewById(R.id.input_alamat);
        input_rt= getActivity().findViewById(R.id.input_rt);
        input_rw= getActivity().findViewById(R.id.input_rw);
        input_dusun= getActivity().findViewById(R.id.input_dusun);
        input_desa= getActivity().findViewById(R.id.input_desa);
        input_kecamatan= getActivity().findViewById(R.id.input_kecamatan);
        input_datiii= getActivity().findViewById(R.id.input_datiii);
        input_provinsi= getActivity().findViewById(R.id.input_provinsi);
        setData();
    }

    @Override
    public AlamatLahanModel getUIData() {
        String strAlamat = input_alamat.getText().toString();
        String strRt = input_rt.getText().toString();
        String strRw = input_rw.getText().toString();
        String strDusun = input_dusun.getText().toString();
        String strDesa = input_desa.getText().toString();
        String strKecamatan = input_kecamatan.getText().toString();
        String strDatiII = input_datiii.getText().toString();
        String strProvinsi = input_provinsi.getText().toString();
        Log.e("Hasil latitude",latitudeAdd+" itu");
        Log.e("Hasil latitude",longitudeAdd+" itu");
        AlamatLahanModel newItem = new AlamatLahanModel(strAlamat, strRt,strRw,strDusun,strDesa,strKecamatan,
                strDatiII,strProvinsi,longitudeAdd,latitudeAdd);
        return newItem;
    }

    @Override
    public void setUIData() {
        input_alamat.setText(DetailLahanActivity.dataLahan.getAlamat());
        input_rt.setText(DetailLahanActivity.dataLahan.getRt());
        input_rw.setText(DetailLahanActivity.dataLahan.getRw());
        input_dusun.setText(DetailLahanActivity.dataLahan.getDusun());
        input_desa.setText(DetailLahanActivity.dataLahan.getDesa());
        input_kecamatan.setText(DetailLahanActivity.dataLahan.getNamaKecamatan());
        input_datiii.setText(DetailLahanActivity.dataLahan.getDatiII());
        input_provinsi.setText(DetailLahanActivity.dataLahan.getProvinsi());
    }

    @Override
    public void saveData(String tipe, Parcelable itemData) {
        //not implemented yet
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
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("hasil request code",requestCode+" ");
        if(requestCode == RESPONSE_PICKER){
            try{
                final Place place = PlacePicker.getPlace(data, getActivity().getApplicationContext());
                final CharSequence address = place.getAddress();
                input_alamat.setText(address.toString());
                latitudeAdd = place.getLatLng().latitude;
                longitudeAdd = place.getLatLng().longitude;
                Log.e("Hasil latitude",latitudeAdd+" ini");
                Log.e("Hasil latitude",longitudeAdd+" ini");
            }catch (NullPointerException nx)
            {
                Log.e("null","back pressed");
            }

        }
    }
}
