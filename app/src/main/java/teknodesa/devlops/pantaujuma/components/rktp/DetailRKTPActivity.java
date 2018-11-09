package teknodesa.devlops.pantaujuma.components.rktp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
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
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.RKTP;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.PoktanRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.rktp.RKTPRealm;

public class DetailRKTPActivity extends AppCompatActivity {

    @Inject
    Realm realm;

    @BindView(R.id.btnEdit)
    Button btnEdit;

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

    @BindView(R.id.metode)
    TextView metode;

    @BindView(R.id.volume)
    TextView volume;

    @BindView(R.id.lokasi)
    TextView lokasi;

    @BindView(R.id.waktu)
    TextView waktu;

    @BindView(R.id.sumberBiaya)
    TextView sumberBiaya;

    @BindView(R.id.penanggungjawab)
    TextView penanggungjawab;

    @BindView(R.id.pelaksana)
    TextView pelaksana;

    @BindView(R.id.keterangan)
    TextView keterangan;

    @OnClick(R.id.btnEdit)
    void clickEdit() {
        RKTP rktpObject = new RKTP(dataRKTP);
        startActivity(CRUActivity.createIntent(getApplicationContext(), "rktp", "update", rktpObject));
        finish();
    }

    public static RKTPRealm dataRKTP;
    public static PoktanRealm dataPoktan;

    private static String idRKTP;
    static String idPoktan;

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
        if(dataRKTP.getPoktan() == null || dataRKTP.getPoktan().compareTo("")==0){
            poktan.setText("-");
        }else{
            poktan.setText(dataPoktan.getNama());
        }

        tahun.setText(dataRKTP.getTahun());
        tujuan.setText(dataRKTP.getTujuan());
        masalah.setText(dataRKTP.getMasalah());
        sasaran.setText(dataRKTP.getSasaran());
        materi.setText(dataRKTP.getMateri());
        metode.setText(dataRKTP.getMetode());
        volume.setText(dataRKTP.getVolume());
        lokasi.setText(dataRKTP.getLokasi());
        waktu.setText(dataRKTP.getWaktu());
        sumberBiaya.setText(dataRKTP.getSumberBiaya());
        penanggungjawab.setText(dataRKTP.getPenanggungJawab());
        pelaksana.setText(dataRKTP.getPelaksana());
        keterangan.setText(dataRKTP.getKeterangan());
    }

    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    //Yes button clicked
                    startActivity(ListRKTPActivity.createIntent(getApplicationContext()));
                    break;

                case DialogInterface.BUTTON_NEGATIVE:
                    //No button clicked
                    break;
            }
        }
    };
}