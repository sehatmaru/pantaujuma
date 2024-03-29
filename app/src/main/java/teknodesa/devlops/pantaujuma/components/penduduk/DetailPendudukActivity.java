package teknodesa.devlops.pantaujuma.components.penduduk;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.PendudukParcelable;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.penduduk.PendudukRealm;

public class DetailPendudukActivity extends AppCompatActivity {
    private AppComponent appComponent;

    @Inject
    Realm realm;

    @BindView(R.id.btnEdit)
    Button btnEdit;


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

    @OnClick(R.id.btnEdit)
    void clickEdit() {
        PendudukParcelable itemDetail = new PendudukParcelable(dataPenduduk);
        startActivity(CRUActivity.createIntent(getApplicationContext(), "penduduk", "update", itemDetail));
        finish();
    }

    public static PendudukRealm dataPenduduk;

    private static String idPenduduk;
    public static Intent createIntent(Context context, String id) {
        idPenduduk =id;
        return new Intent(context, DetailPendudukActivity.class);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_penduduk);

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
        dataPenduduk = realm.where(PendudukRealm.class).equalTo("hashId", idPenduduk).findFirst();
        realm.commitTransaction();
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

    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    //Yes button clicked
                    startActivity(ListPendudukActivity.createIntent(getApplicationContext()));
                    break;

                case DialogInterface.BUTTON_NEGATIVE:
                    //No button clicked
                    break;
            }
        }
    };
}
