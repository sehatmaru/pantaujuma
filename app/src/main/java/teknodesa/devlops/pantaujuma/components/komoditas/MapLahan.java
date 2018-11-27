package teknodesa.devlops.pantaujuma.components.komoditas;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import io.realm.Realm;
import io.realm.RealmResults;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.base.BaseActivity;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.BodyGetLahan;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.UserDB;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.LahanRealm;

public class MapLahan extends BaseActivity implements GetLahanByKomoditasContract.View, OnMapReadyCallback {

    private GoogleMap googleMap;

    private static String idKomoditas;

    @Inject
    GetLahanByKomoditasController mController;

    @BindView(R.id.coordinatorLayoutLahan)
    CoordinatorLayout coordinatorLayout;

    @Inject
    Realm realm;

    private List<LahanRealm> listData = Collections.EMPTY_LIST;
    BodyGetLahan getLahan;

    private LahanRealm[] riwayatArray;
    private Double Latitude = 0.00;
    private Double Longitude = 0.00;
    ArrayList<HashMap<String, String>> location = new ArrayList<HashMap<String, String>>();
    HashMap<String, String> map;

    public static Intent createIntent(Context context, String id) {
        idKomoditas = id;
        return new Intent(context, MapLahan.class);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_lahan);

        ((MainApplication) this.getApplication())
                .getComponent()
                .inject(this);
        mController.setView(this);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        setBody();
        getAllLahan();
    }

    public void onMapReady(GoogleMap googleMap) {
        riwayatArray = new LahanRealm[listData.size()];

        if (listData.size() > 0){
            setLocation(googleMap);
        } else{
            Toast.makeText(this, "Tidak ada lahan", Toast.LENGTH_SHORT).show();
        }
    }

    private void setLocation(GoogleMap googleMap){
        for(int i = 0; i < listData.size(); i++){
            riwayatArray[i] = listData.get(i);

            map = new HashMap<String, String>();
            map.put("LocationID", String.valueOf(riwayatArray[i].getHashId()));
            map.put("Latitude", String.valueOf(riwayatArray[i].getLatitude()));
            map.put("Longitude", String.valueOf(riwayatArray[i].getLongitude()));
            map.put("LocationName", riwayatArray[i].getNamaPemilikLahan());
            map.put("Address", riwayatArray[i].getAlamat());

            location.add(map);
        }

        Latitude = Double.parseDouble(location.get(0).get("Latitude"));
        Longitude = Double.parseDouble(location.get(0).get("Longitude"));
        LatLng coordinate = new LatLng(Longitude, Latitude);
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(coordinate, 17));

        for (int i = 0; i < location.size(); i++) {
            Latitude = Double.parseDouble(location.get(i).get("Latitude"));
            Longitude = Double.parseDouble(location.get(i).get("Longitude"));
            String hashId = location.get(i).get("LocationID");
            MarkerOptions marker = new MarkerOptions().position(new LatLng(Longitude, Latitude));
            googleMap.addMarker(marker);

            googleMap.setOnMarkerClickListener(marker1 -> {
                showDetail(hashId);

                return false;
            });
        }
    }

    @Override
    public void getAllLahanByKomoditasSuccess(List<LahanRealm> lahan) {
        populateInitialData();
    }

    @Override
    public void getAllLahanByKomoditasFailed(String message) {

    }

    private void populateInitialData(){
        RealmResults<LahanRealm> allLahan = realm.where(LahanRealm.class).findAll();
        allLahan.deleteAllFromRealm();

        realm.executeTransactionAsync(realm1 -> {
            listData = realm1.copyFromRealm(realm1.where(LahanRealm.class).equalTo("isSync", 1).findAll());
        });
    }

    private void setBody(){
        UserDB userDB = getData();
        int idDes;
        try {
            idDes =  Integer.valueOf(userDB.getAttributeValue());
        }catch (Exception e){
            idDes = 0;
        }

        getLahan = new BodyGetLahan(idKomoditas, idDes);
    }

    private void getAllLahan(){
        if (idKomoditas != null) {
            realm.executeTransactionAsync(realm1 -> {
                listData = realm1.copyFromRealm(realm1.where(LahanRealm.class).equalTo("hashId", idKomoditas).findAll());
            });
        }
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

    private void showDetail(String hashId){
        realm.beginTransaction();
        LahanRealm lahan = realm.where(LahanRealm.class).equalTo("hashId", hashId).findFirst();
        realm.commitTransaction();

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.window_lahan, null);
        dialogBuilder.setView(dialogView);

        String strName;

        if (lahan != null) {
            strName = lahan.getNamaPemilikLahan();
        } else{
            strName = "-";
        }

        String strAlamat;

        if (lahan != null) {
            strAlamat = lahan.getAlamat();
        } else{
            strAlamat = "";
        }

        String strDesa;

        if (lahan != null) {
            strDesa = lahan.getDesa();
        } else{
            strDesa = "";
        }

        String strKec;

        if (lahan != null) {
            strKec = lahan.getNamaKecamatan();
        } else{
            strKec = "";
        }

        String strKab;

        if (lahan != null) {
            strKab = lahan.getDatiII();
        } else{
            strKab = "";
        }

        final TextView textNama = dialogView.findViewById(R.id.nama);
        final TextView textAlamat = dialogView.findViewById(R.id.alamat);

        textNama.setText(strName);
        textAlamat.setText(strAlamat + ", " + strDesa + ", " + strKec + ", " + strKab);

        final AlertDialog b = dialogBuilder.create();
        b.show();
    }
}
