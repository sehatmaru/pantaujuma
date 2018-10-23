package teknodesa.devlops.pantaujuma.components.rdkk;

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
import teknodesa.devlops.pantaujuma.components.CRUActivity;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.rdkk.RDKKParcelable;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.KomoditasRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.PoktanRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.rdkk.RDKKPupukSubsidiRealm;

public class DetailRDKKActivity extends AppCompatActivity {
    private AppComponent appComponent;

    @Inject
    Realm realm;

    @BindView(R.id.btnEdit)
    Button btnEdit;

    @BindView(R.id.nama)
    TextView nama;

    @BindView(R.id.desa)
    TextView desa;

    @BindView(R.id.komoditas)
    TextView komoditas;

    @BindView(R.id.deskripsi)
    TextView deskripsi;

    public static RDKKPupukSubsidiRealm dataRDKK;

    @OnClick(R.id.btnEdit)
    void clickEdit() {
        RDKKParcelable rdkkParcelable = new RDKKParcelable(dataRDKK);
        startActivity(CRUActivity.createIntent(getApplicationContext(), "rdkk", "update", rdkkParcelable));
        finish();
    }

    public static PoktanRealm dataPoktan;
    public static KomoditasRealm dataKomoditas;

    public static String idRDKK;
    static String idPoktan;
    static String idKomoditas;

    public static Intent createIntent(Context context, String id) {
        idRDKK = id;
        return new Intent(context, DetailRDKKActivity.class);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_rdkk);

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
        dataRDKK = realm.where(RDKKPupukSubsidiRealm.class).equalTo("hashId", idRDKK).findFirst();
        idPoktan = dataRDKK.getPoktan();
        idKomoditas = dataRDKK.getKomoditas();
        dataKomoditas = realm.where(KomoditasRealm.class).equalTo("hashId", idKomoditas).findFirst();
        dataPoktan = realm.where(PoktanRealm.class).equalTo("hashId", idPoktan).findFirst();
        realm.commitTransaction();
    }

    private void setdata(){
        nama.setText(dataPoktan.getNama());
        desa.setText(dataPoktan.getDesa());
//        komoditas.setText(dataKomoditas.getNama());
        deskripsi.setText(dataPoktan.getDeskripsi());
    }

    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    //Yes button clicked
//                   CRULahanFragment.setDeletedData(itemDetail, appComponent);
                    startActivity(ListRDKKActivity.createIntent(getApplicationContext()));
                    break;

                case DialogInterface.BUTTON_NEGATIVE:
                    //No button clicked
                    break;
            }
        }
    };
}
