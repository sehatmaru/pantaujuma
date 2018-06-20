package teknodesa.devlops.pantaujuma.components.penduduk;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.PendudukRealm;

public class DetailPendudukActivity extends AppCompatActivity {

    @Inject
    Realm realm;

    @BindView(R.id.nik)
    TextView nik;

    @BindView(R.id.nama)
    TextView nama;

    @BindView(R.id.ttl)
    TextView ttl;

    @BindView(R.id.jk)
    TextView jk;

    @BindView(R.id.gd)
    TextView gd;

    @BindView(R.id.agama)
    TextView agama;

    @BindView(R.id.sp)
    TextView sp;

    @BindView(R.id.alamat)
    TextView alamat;

    @BindView(R.id.rtrw)
    TextView rtrw;

    @BindView(R.id.kelurahan)
    TextView kelurahan;

    private PendudukRealm dataPenduduk;

    private static int idPenduduk;
    public static Intent createIntent(Context context, int id) {
        idPenduduk =id;
        return new Intent(context, DetailPendudukActivity.class);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_penduduk);

        ((MainApplication) getApplication())
                .getComponent()
                .inject(this);

        ButterKnife.bind(this);
        takedata();
    }
    private void takedata(){
        realm.beginTransaction();
        dataPenduduk = realm.where(PendudukRealm.class).equalTo("id", idPenduduk).findFirst();
        realm.commitTransaction();


        setdata();
    }
    private void setdata(){
        nik.setText(dataPenduduk.getNIK());
        nama.setText(dataPenduduk.getNamaDepan()+" "+dataPenduduk.getNamaBelakang());
        ttl.setText(dataPenduduk.getTempatLahir()+" / "+ dataPenduduk.getTanggalLahir());
        jk.setText(dataPenduduk.getJenisKelamin());
        gd.setText(dataPenduduk.getGolonganDarah());
        agama.setText(dataPenduduk.getAgama());
        sp.setText(dataPenduduk.getPekerjaan());

        if(dataPenduduk.getAlamat() == null){
            alamat.setText(" - ");
            rtrw.setText(" - ");
            kelurahan.setText(" - ");
        }else{
            alamat.setText(dataPenduduk.getAlamat());
            rtrw.setText("-");
            kelurahan.setText("-");
        }

    }
}
