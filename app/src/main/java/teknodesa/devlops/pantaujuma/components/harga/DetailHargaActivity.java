package teknodesa.devlops.pantaujuma.components.harga;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.CRUActivity;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.Harga;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.harga.HargaRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.KomoditasRealm;

public class DetailHargaActivity extends AppCompatActivity {
    private AppComponent appComponent;

    @Inject
    Realm realm;

    @BindView(R.id.btnEdit)
    Button btnEdit;

    @BindView(R.id.komoditas)
    TextView komoditas;

    @BindView(R.id.pasar)
    TextView pasar;

    @BindView(R.id.tanggal)
    TextView tanggal;

    @BindView(R.id.harga)
    TextView harga;

    @BindView(R.id.satuan)
    TextView satuan;

    @OnClick(R.id.btnEdit)
    void clickEdit() {
        Harga hargaObject = new Harga(dataHarga);
        startActivity(CRUActivity.createIntent(getApplicationContext(), "harga", "update", hargaObject));
        finish();
    }

    public static HargaRealm dataHarga;
    public static KomoditasRealm dataKomoditas;

    public static String idPasar;
    public static String idHarga;
    public static String idKomoditas;
    public static String nama;
    public static String alamat;
    public static String kecamatan;
    public static String kabupaten;

    public static Intent createIntent(Context context, String id) {
        idHarga = id;
        return new Intent(context, DetailHargaActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_harga);

        //TODO: change this to Fragment
        appComponent = ((MainApplication) getApplication()).getComponent();
        ((MainApplication) getApplication())
                .getComponent()
                .inject(this);
        takedata();

        ButterKnife.bind(this);
        setdata();
    }
    private void takedata(){
        realm.beginTransaction();
        dataHarga = realm.where(HargaRealm.class).equalTo("hashId", idHarga).findFirst();

        idPasar = dataHarga.getHashId();
        idKomoditas = dataHarga.getHashKomoditas();

        dataKomoditas = realm.where(KomoditasRealm.class).equalTo("hashId", idKomoditas).findFirst();

        nama = dataHarga.getNamaPasar();
        alamat = dataHarga.getAlamat();
        kecamatan = dataHarga.getKecamatan();
        kabupaten = dataHarga.getKabupaten();

        realm.commitTransaction();
    }

    private void setdata(){
        komoditas.setText(dataKomoditas.getNama());
        pasar.setText(dataHarga.getNamaPasar());
        tanggal.setText(dataHarga.getTanggal());
        harga.setText(dataHarga.getNilai());
        satuan.setText(dataHarga.getSatuan());
    }

    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    //Yes button clicked
                    startActivity(ListHargaActivity.createIntent(getApplicationContext()));
                    break;

                case DialogInterface.BUTTON_NEGATIVE:
                    //No button clicked
                    break;
            }
        }
    };
}
