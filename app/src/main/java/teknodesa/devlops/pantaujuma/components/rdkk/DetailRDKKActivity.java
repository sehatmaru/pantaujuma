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
import teknodesa.devlops.pantaujuma.components.profile.AkunFragment;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.KomoditasRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.penduduk.PendudukRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.petani.PetaniRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.PoktanRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.rdkk.RDKKPupukSubsidiRealm;

public class DetailRDKKActivity extends AppCompatActivity {
    private AppComponent appComponent;

    @Inject
    Realm realm;

    @BindView(R.id.btnEdit)
    Button btnEdit;

    @BindView(R.id.btnHapus)
    Button btnHapus;

    @BindView(R.id.poktan)
    TextView poktan;

    @BindView(R.id.petani)
    TextView petani;

    @BindView(R.id.komoditas)
    TextView komoditas;

    @BindView(R.id.pupuk)
    TextView pupuk;

    @BindView(R.id.januari)
    TextView januari;

    @BindView(R.id.februari)
    TextView februari;

    @BindView(R.id.maret)
    TextView maret;

    @BindView(R.id.april)
    TextView april;

    @BindView(R.id.mei)
    TextView mei;

    @BindView(R.id.juni)
    TextView juni;

    @BindView(R.id.juli)
    TextView juli;

    @BindView(R.id.agustus)
    TextView agustus;

    @BindView(R.id.september)
    TextView september;

    @BindView(R.id.oktober)
    TextView oktober;

    @BindView(R.id.november)
    TextView november;

    @BindView(R.id.desember)
    TextView desember;

    @OnClick(R.id.btnEdit)

    void clickEdit() {
//        startActivity(CRUActivity.createIntent(getApplicationContext(), "rdkk", "update", itemDetail));
        finish();
    }

    @OnClick(R.id.btnHapus)
    void clickHapus() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Apakah Anda yakin ingin menghapus data ini?").setPositiveButton("Iya", dialogClickListener);
        builder.setNegativeButton("Tidak", dialogClickListener).show();
    }

    private RDKKPupukSubsidiRealm dataRDKK;
    PoktanRealm dataPoktan;
    PetaniRealm dataPetani;
    PendudukRealm dataPenduduk;
    KomoditasRealm dataKomoditas;

    private static String idRDKK;
    static String idPoktan;
    static String idKomoditas;
    static String idPetani;
    static String idPenduduk;

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
        idPetani = dataRDKK.getPetani();
        dataKomoditas = realm.where(KomoditasRealm.class).equalTo("hashId", idKomoditas).findFirst();
        dataPoktan = realm.where(PoktanRealm.class).equalTo("hashId", idPoktan).findFirst();
        dataPetani = realm.where(PetaniRealm.class).equalTo("hashId", idKomoditas).findFirst();
        idPenduduk = dataPetani.getBiodata();
        dataPenduduk = realm.where(PendudukRealm.class).equalTo("hashId", idPenduduk).findFirst();
        realm.commitTransaction();
    }

    private void setdata(){
        poktan.setText(dataPoktan.getNama());
        petani.setText(dataPenduduk.getNamaDepan()+" "+ dataPenduduk.getNamaBelakang());
        komoditas.setText(dataKomoditas.getNama());
        pupuk.setText(dataRDKK.getPupuk());
        januari.setText(Float.toString(dataRDKK.getButuhJanuari()));
        februari.setText(Float.toString(dataRDKK.getButuhFebruari()));
        maret.setText(Float.toString(dataRDKK.getButuhMaret()));
        april.setText(Float.toString(dataRDKK.getButuhApril()));
        mei.setText(Float.toString(dataRDKK.getButuhMei()));
        juni.setText(Float.toString(dataRDKK.getButuhJuni()));
        juli.setText(Float.toString(dataRDKK.getButuhJuli()));
        agustus.setText(Float.toString(dataRDKK.getButuhAgustus()));
        september.setText(Float.toString(dataRDKK.getButuhSeptember()));
        oktober.setText(Float.toString(dataRDKK.getButuhOktober()));
        november.setText(Float.toString(dataRDKK.getButuhNovember()));
        desember.setText(Float.toString(dataRDKK.getButuhDesember()));
    }

    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    //Yes button clicked
//                   CRURDKKPupukSubsidiFragment.setDeletedData(itemDetail, appComponent);
                    startActivity(ListRDKKActivity.createIntent(getApplicationContext()));
                    break;

                case DialogInterface.BUTTON_NEGATIVE:
                    //No button clicked
                    break;
            }
        }
    };
}
