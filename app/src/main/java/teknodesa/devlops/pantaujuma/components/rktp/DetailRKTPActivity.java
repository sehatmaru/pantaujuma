package teknodesa.devlops.pantaujuma.components.rktp;

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
import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.PoktanRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.rktp.RKTPRealm;

public class DetailRKTPActivity extends AppCompatActivity {

    @Inject
    Realm realm;

    @BindView(R.id.btnEdit)
    Button btnEdit;

    @BindView(R.id.btnHapus)
    Button btnHapus;

    @BindView(R.id.poktan)
    TextView poktan;

    @BindView(R.id.tahun)
    TextView tahun;

    @BindView(R.id.tujuan)
    TextView tujuan;

    @BindView(R.id.masalah)
    TextView masalah;

    @BindView(R.id.sasaran)
    TextView sasaran;

    @BindView(R.id.materi)
    TextView materi;

    @OnClick(R.id.btnEdit)
    void clickEdit() {
//        startActivity(CRUActivity.createIntent(getApplicationContext(), "petani", "update", itemDetail));
        finish();
    }

    private RKTPRealm dataRKTP;
    PoktanRealm dataPoktan;

    private static String idRKTP;
    static String idPoktan;

    @OnClick(R.id.btnHapus)
    void clickHapus() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Apakah Anda yakin ingin menghapus data ini?").setPositiveButton("Iya", dialogClickListener);
        builder.setNegativeButton("Tidak", dialogClickListener).show();
    }

    public static Intent createIntent(Context context, String id) {
        idRKTP =id;
        return new Intent(context, DetailRKTPActivity.class);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_rktp);

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
        dataRKTP = realm.where(RKTPRealm.class).equalTo("hashId", idRKTP).findFirst();
        idPoktan = dataRKTP.getPoktan();
        dataPoktan = realm.where(PoktanRealm.class).equalTo("hashId", idPoktan).findFirst();
        realm.commitTransaction();
    }
    private void setdata(){
        String strPoktan = (dataPoktan.getNama() == null) ? "-" : dataPoktan.getNama();
        String strTahun = (dataRKTP.getTahun() == null) ? "-" : dataRKTP.getTahun();
        String strTujuan = (dataRKTP.getTujuan() == null) ? "-" : dataRKTP.getTujuan();
        String strMasalah = (dataRKTP.getMasalah() == null) ? "-" : dataRKTP.getMasalah();
        String strSasaran = (dataRKTP.getSasaran() == null) ? "-" : dataRKTP.getSasaran();
        String strMateri = (dataRKTP.getMateri() == null) ? "-" : dataRKTP.getMateri();

        poktan.setText(strPoktan);
        tahun.setText(strTahun);
        tujuan.setText(strTujuan);
        masalah.setText(strMasalah);
        sasaran.setText(strSasaran);
        materi.setText(strMateri);
    }

    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    //Yes button clicked
//                    CRUPetaniFragment.setDeletedData(itemDetail, appComponent);
                    startActivity(ListRKTPActivity.createIntent(getApplicationContext()));
                    break;

                case DialogInterface.BUTTON_NEGATIVE:
                    //No button clicked
                    break;
            }
        }
    };
}
