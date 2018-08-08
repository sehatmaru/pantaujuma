package teknodesa.devlops.pantaujuma.components.petugas;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.KomoditasRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.petugas.TargetPetugas;

public class DetailTargetActivity extends AppCompatActivity {

    @Inject
    Realm realm;

    @BindView(R.id.btnEdit)
    Button btnEdit;

    @BindView(R.id.btnHapus)
    Button btnHapus;

    @BindView(R.id.komoditas)
    TextView komoditas;

    @BindView(R.id.luasTanam)
    TextView luasTanam;

    @BindView(R.id.luasPanen)
    TextView luasPanen;

    @BindView(R.id.sasaranProduksi)
    TextView sasaranProduksi;

    @BindView(R.id.sasaranProduktifitas)
    TextView sasaranProduktifitas;

    @BindView(R.id.keterangan)
    TextView keterangan;

    @OnClick(R.id.btnEdit)
    void clickEdit() {
//        startActivity(CRUActivity.createIntent(getApplicationContext(), "petani", "update", itemDetail));
        finish();
    }

    private TargetPetugas dataTarget;
    KomoditasRealm dataKomoditas;

    private static String idTarget;
    static String idKomoditas;

    @OnClick(R.id.btnHapus)
    void clickHapus() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Apakah Anda yakin ingin menghapus data ini?").setPositiveButton("Iya", dialogClickListener);
        builder.setNegativeButton("Tidak", dialogClickListener).show();
    }

    public static Intent createIntent(Context context, String id) {
        idTarget =id;
        return new Intent(context, DetailTargetActivity.class);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_target);

        //TODO: change this to Fragment
        ((MainApplication) getApplication())
                .getComponent()
                .inject(this);
        takedata();

        ButterKnife.bind(this);
        setdata();
    }

    private void takedata(){
        realm.beginTransaction();
        dataTarget = realm.where(TargetPetugas.class).equalTo("hashId", idTarget).findFirst();
        idKomoditas = dataTarget.getKomoditas();
        dataKomoditas = realm.where(KomoditasRealm.class).equalTo("hashId", idKomoditas).findFirst();
        realm.commitTransaction();
    }
    private void setdata(){
        komoditas.setText(dataKomoditas.getNama());
        luasTanam.setText(String.valueOf(dataTarget.getLuasTanam()));
        luasPanen.setText(String.valueOf(dataTarget.getLuasPanen()));
        sasaranProduksi.setText(String.valueOf(dataTarget.getSasaranProduksi()));
        sasaranProduktifitas.setText(String.valueOf(dataTarget.getSasaranProduktifitas()));
        keterangan.setText(dataTarget.getKeterangan());
    }

    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    //Yes button clicked
//                    CRUPetaniFragment.setDeletedData(itemDetail, appComponent);
                    startActivity(ListTargetActivity.createIntent(getApplicationContext()));
                    break;

                case DialogInterface.BUTTON_NEGATIVE:
                    //No button clicked
                    break;
            }
        }
    };
}
