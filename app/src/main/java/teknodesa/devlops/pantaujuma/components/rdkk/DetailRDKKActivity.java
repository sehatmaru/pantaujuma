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
import teknodesa.devlops.pantaujuma.dependencies.models.realms.alsintan.PupukRealm;
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

    @BindView(R.id.poktan)
    TextView poktan;

    @BindView(R.id.petani)
    TextView petani;

    @BindView(R.id.komoditas)
    TextView komoditas;

    @BindView(R.id.pupuk)
    TextView pupuk;

    @BindView(R.id.jan)
    TextView jan;

    @BindView(R.id.feb)
    TextView feb;

    @BindView(R.id.mar)
    TextView mar;

    @BindView(R.id.apr)
    TextView apr;

    @BindView(R.id.mei)
    TextView mei;

    @BindView(R.id.jun)
    TextView jun;

    @BindView(R.id.jul)
    TextView jul;

    @BindView(R.id.agus)
    TextView agus;

    @BindView(R.id.sep)
    TextView sep;

    @BindView(R.id.okt)
    TextView okt;

    @BindView(R.id.nov)
    TextView nov;

    @BindView(R.id.des)
    TextView des;

    public static RDKKPupukSubsidiRealm dataRDKK;

    @OnClick(R.id.btnEdit)
    void clickEdit() {
        RDKKParcelable rdkkParcelable = new RDKKParcelable(dataRDKK);
        startActivity(CRUActivity.createIntent(getApplicationContext(), "rdkk", "update", rdkkParcelable));
        finish();
    }

    public static PoktanRealm dataPoktan;
    public static KomoditasRealm dataKomoditas;
    public static PetaniRealm dataPetani;
    public static PendudukRealm dataPenduduk;
    public static PupukRealm dataPupuk;

    public static String idRDKK;
    static String idPoktan;
    static String idPetani;
    static String biodata;
    static String idKomoditas;
    static String idPupuk;

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
        idPetani = dataRDKK.getPetani();
        idKomoditas = dataRDKK.getKomoditas();
        idPupuk = dataRDKK.getPupuk();
        dataKomoditas = realm.where(KomoditasRealm.class).equalTo("hashId", idKomoditas).findFirst();
        dataPoktan = realm.where(PoktanRealm.class).equalTo("hashId", idPoktan).findFirst();
        dataPetani = realm.where(PetaniRealm.class).equalTo("hashId", idPetani).findFirst();
        biodata = dataPetani.getBiodata();
        dataPenduduk = realm.where(PendudukRealm.class).equalTo("hashId", biodata).findFirst();
        dataPupuk = realm.where(PupukRealm.class).equalTo("hashId", idPupuk).findFirst();
        realm.commitTransaction();
    }

    private void setdata(){
        if(dataRDKK.getPoktan() == null || dataRDKK.getPoktan().compareTo("")==0){
            poktan.setText("-");
        }else{
            poktan.setText(dataPoktan.getNama());
        }

        if(dataRDKK.getPetani() == null || dataRDKK.getPetani().compareTo("")==0){
            petani.setText("-");
        }else{
            petani.setText(dataPenduduk.getNamaBelakang() + " " + dataPenduduk.getNamaBelakang());
        }

        if(dataRDKK.getKomoditas() == null || dataRDKK.getKomoditas().compareTo("")==0){
            komoditas.setText("-");
        }else{
            komoditas.setText(dataKomoditas.getNama());
        }

        if(dataRDKK.getPupuk() == null || dataRDKK.getPupuk().compareTo("")==0){
            pupuk.setText("-");
        }else{
            pupuk.setText(dataPupuk.getNama());
        }

        jan.setText(Float.toString(dataRDKK.getButuhJanuari()));
        feb.setText(Float.toString(dataRDKK.getButuhFebruari()));
        mar.setText(Float.toString(dataRDKK.getButuhMaret()));
        apr.setText(Float.toString(dataRDKK.getButuhApril()));
        mei.setText(Float.toString(dataRDKK.getButuhMei()));
        jun.setText(Float.toString(dataRDKK.getButuhJuni()));
        jul.setText(Float.toString(dataRDKK.getButuhJuli()));
        agus.setText(Float.toString(dataRDKK.getButuhAgustus()));
        sep.setText(Float.toString(dataRDKK.getButuhSeptember()));
        okt.setText(Float.toString(dataRDKK.getButuhOktober()));
        nov.setText(Float.toString(dataRDKK.getButuhNovember()));
        des.setText(Float.toString(dataRDKK.getButuhDesember()));
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
