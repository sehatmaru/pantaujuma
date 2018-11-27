package teknodesa.devlops.pantaujuma.components.alsintan;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

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
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.base.BaseActivity;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.alsintan.TokoAlsintanRealm;

public class TokoMapsActivity extends BaseActivity implements OnMapReadyCallback {

    private GoogleMap googleMap;

    private static String idToko;

    @BindView(R.id.coordinatorLayoutLahan)
    CoordinatorLayout coordinatorLayout;

    @Inject
    Realm realm;

    private List<TokoAlsintanRealm> listData = Collections.EMPTY_LIST;
    private TokoAlsintanRealm toko;

    private Double Latitude = 0.00;
    private Double Longitude = 0.00;
    ArrayList<HashMap<String, String>> location = new ArrayList<HashMap<String, String>>();
    HashMap<String, String> map;

    public static Intent createIntent(Context context, String id) {
        idToko = id;
        return new Intent(context, TokoMapsActivity.class);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_lahan);

        ((MainApplication) this.getApplication())
                .getComponent()
                .inject(this);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        populateInitialData();
    }

    public void onMapReady(GoogleMap googleMap) {
        map = new HashMap<String, String>();
        map.put("LocationID", String.valueOf(toko.getId()));
        map.put("Latitude", String.valueOf(toko.getLatitude()));
        map.put("Longitude", String.valueOf(toko.getLongitude()));
        map.put("LocationName", toko.getNama_contact());
        map.put("Address", toko.getAlamat());

        location.add(map);

        Latitude = Double.parseDouble(location.get(0).get("Latitude"));
        Longitude = Double.parseDouble(location.get(0).get("Longitude"));
        LatLng coordinate = new LatLng(Longitude, Latitude);
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(coordinate, 17));

        Latitude = Double.parseDouble(location.get(0).get("Latitude"));
        Longitude = Double.parseDouble(location.get(0).get("Longitude"));
        MarkerOptions marker = new MarkerOptions().position(new LatLng(Longitude, Latitude));
        googleMap.addMarker(marker);

        googleMap.setOnMarkerClickListener(marker1 -> {
            showDetail();

            return false;
        });
    }

    private void populateInitialData(){
        realm.executeTransactionAsync(realm1 -> {
            toko = realm1.copyFromRealm(realm1.where(TokoAlsintanRealm.class).equalTo("id", idToko).findFirst());
        });
    }

    private void showDetail(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.window_toko, null);
        dialogBuilder.setView(dialogView);

        String strName;

        if (toko != null) {
            strName = toko.getNama_contact();
        } else{
            strName = "-";
        }

        String strAlamat;

        if (toko != null) {
            strAlamat = toko.getAlamat();
        } else{
            strAlamat = "";
        }

        String strHarga;

        if (toko != null) {
            strHarga = toko.getHarga();
        } else{
            strHarga = "";
        }

        String strStock;

        if (toko != null) {
            strStock = String.valueOf(toko.getStok());
        } else{
            strStock = "";
        }

        String strHP;

        if (toko != null) {
            strHP = toko.getNo_hp();
        } else{
            strHP = "";
        }

        String strDes;

        if (toko != null) {
            strDes = toko.getDeskripsi_toko();
        } else{
            strDes = "";
        }

        final TextView textNama = dialogView.findViewById(R.id.nama);
        final TextView textAlamat = dialogView.findViewById(R.id.alamat);
        final TextView textHarga = dialogView.findViewById(R.id.harga);
        final TextView textStock = dialogView.findViewById(R.id.stock);
        final TextView textHP = dialogView.findViewById(R.id.hp);
        final TextView textDeskripsi = dialogView.findViewById(R.id.deskripsi);

        textNama.setText(strName);
        textAlamat.setText(strAlamat);
        textHarga.setText(strHarga);
        textStock.setText(strStock);
        textHP.setText(strHP);
        textDeskripsi.setText(strDes);

        final AlertDialog b = dialogBuilder.create();
        b.show();
    }
}
