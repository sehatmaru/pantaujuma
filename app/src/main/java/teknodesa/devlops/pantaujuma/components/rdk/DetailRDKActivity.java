package teknodesa.devlops.pantaujuma.components.rdk;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
import teknodesa.devlops.pantaujuma.components.profile.AkunFragment;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.rdk.RDKParcelable;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.UserDB;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.KomoditasRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.PoktanRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.rdk.RDKRealm;

public class DetailRDKActivity extends AppCompatActivity {
    private AppComponent appComponent;

    @Inject
    Realm realm;

    @BindView(R.id.btnEdit)
    Button btnEdit;

    @BindView(R.id.poktanrdk)
    TextView poktanrdk;

    @BindView(R.id.tanggaldata)
    TextView tanggaldata;

    @BindView(R.id.luassawahdata)
    TextView luassawahdata;

    @BindView(R.id.keterangandata)
    TextView keterangandata;

    @BindView(R.id.namaIrigasi)
    TextView namaIrigasi;

    @BindView(R.id.deskripsiIrigasi)
    TextView deskripsiIrigasi;

    @BindView(R.id.tanggalKegiatan)
    TextView tanggalKegiatan;

    @BindView(R.id.deskripsikegiatan)
    TextView deskripsikegiatan;

    @BindView(R.id.paketteknologi)
    TextView paketteknologi;

    @BindView(R.id.polatanam)
    TextView polatanam;

    @BindView(R.id.jadwaltanam)
    TextView jadwaltanam;

    @BindView(R.id.varietas)
    TextView varietas;

    @BindView(R.id.sumberbenih)
    TextView sumberbenih;

    @BindView(R.id.tabungananggota)
    TextView tabungananggota;

    @BindView(R.id.iurananggota)
    TextView iurananggota;

    @BindView(R.id.modalpemupukan)
    TextView modalpemupukan;

    @BindView(R.id.komoditassi)
    TextView komoditassi;

    @BindView(R.id.target)
    TextView target;

    @BindView(R.id.targethasil)
    TextView targethasil;

    @BindView(R.id.komoditaspb)
    TextView komoditaspb;

    @OnClick(R.id.btnEdit)
    void clickEdit() {
        RDKParcelable rdkParcelable = new RDKParcelable(dataRDK);
        startActivity(CRUActivity.createIntent(getApplicationContext(), "rdk", "update", rdkParcelable));
        finish();
    }

    public static RDKRealm dataRDK;
    public static PoktanRealm dataPoktan;
    public static KomoditasRealm dataKomoditasSI;
    public static KomoditasRealm dataKomoditasRU;

    private static String idRDK;
    private static String idPoktan;
    private static String idKomoditasSI;
    private static String idKomoditasRU;
    public static Intent createIntent(Context context, String id) {
        idRDK =id;
        return new Intent(context, DetailRDKActivity.class);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_rdk);

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
//        Log.e("ini poktan rdk", "" + dataRDK.getPoktan());
        dataRDK = realm.where(RDKRealm.class).equalTo("hashId", idRDK).findFirst();
        idPoktan = dataRDK.getPoktan();
//        Log.e("MISALNYA APA", " ini " + dataRDK.toString());
        idKomoditasSI = dataRDK.getKomoditasSI();
        idKomoditasRU = dataRDK.getKomoditasRU();

        dataPoktan = realm.where(PoktanRealm.class).equalTo("hashId", idPoktan).findFirst();
        dataKomoditasSI = realm.where(KomoditasRealm.class).equalTo("hashId", idKomoditasSI).findFirst();
        dataKomoditasRU = realm.where(KomoditasRealm.class).equalTo("hashId", idKomoditasRU).findFirst();

        realm.commitTransaction();
    }
    private void setdata(){
//        String strPetugasrdk = (getData() == null) ? "-" : getData();
        String strDescIrigasi = (dataRDK.getDeskripsiIrigasi() == null) ? "-" : dataRDK.getDeskripsiIrigasi();
//        String strPoktanrdk = (dataRDK.getPoktan() == null) ? "-" : dataPoktan.getNama();
        String strTanggalData = (dataRDK.getTanggal() == null) ? "-" : dataRDK.getTanggal();
        String strLuasSawah = (dataRDK.getLuasSawah() == null) ? "-" : dataRDK.getLuasSawah();
        String strKeterangan = (dataRDK.getKeterangan() == null) ? "-" : dataRDK.getKeterangan();
        String strNamaIrigasi = (dataRDK.getNama() == null) ? "-" : dataRDK.getNama();
//        String strKegiatan = (dataRDK.getKegiatan() == null) ? "-" : dataRDK.getKegiatan();
        String strTanggalKegiatan = (dataRDK.getTanggalJK() == null) ? "-" : dataRDK.getTanggalJK();
        String strDescKegiatan = (dataRDK.getDeskripsiJK() == null) ? "-" : dataRDK.getDeskripsiJK();
        String strPaketTeknologi = (dataRDK.getPaketTeknologi() == null) ? "-" : dataRDK.getPaketTeknologi();
        String strPolaTanam = (dataRDK.getPolaTanam() == null) ? "-" : dataRDK.getPolaTanam();
        String strJadwalTanam = (dataRDK.getJadwalTanam() == null) ? "-" : dataRDK.getJadwalTanam();
        String strVarietas = (dataRDK.getVarietas() == null) ? "-" : dataRDK.getVarietas();
        String strSumberBenih = (dataRDK.getSumberBenih() == null) ? "-" : dataRDK.getSumberBenih();
        String strTabunganAnggota = (dataRDK.getTabunganAnggota() == null) ? "-" : dataRDK.getTabunganAnggota();
        String strIuranAnggota = (dataRDK.getIuranAnggota() == null) ? "-" : dataRDK.getIuranAnggota();
        String strTarget = (dataRDK.getTarget() == null) ? "-" : dataRDK.getTarget();
        String strTargetHasil = (dataRDK.getTargetHasilPerHa() == null) ? "-" : dataRDK.getTargetHasilPerHa();
        String strModalPemupukan = (dataRDK.getPemupukanModal() == null) ? "-" : dataRDK.getPemupukanModal();
        String strKomoditasSI = (idKomoditasSI == null) ? "-" : dataKomoditasSI.getNama();
        String strKomoditasPB = (idKomoditasRU == null) ? "-" : dataKomoditasRU.getNama();

//        petugasrdk.setText(strPetugasrdk);
        deskripsiIrigasi.setText(strDescIrigasi);
        poktanrdk.setText("-");
        tanggaldata.setText(strTanggalData);
        luassawahdata.setText(strLuasSawah);
        keterangandata.setText(strKeterangan);
        namaIrigasi.setText(strNamaIrigasi);
//        kegiatan.setText(strKegiatan);
        tanggalKegiatan.setText(strTanggalKegiatan);
        deskripsikegiatan.setText(strDescKegiatan);
        paketteknologi.setText(strPaketTeknologi);
        polatanam.setText(strPolaTanam);
        jadwaltanam.setText(strJadwalTanam);
        varietas.setText(strVarietas);
        sumberbenih.setText(strSumberBenih);
        tabungananggota.setText(strTabunganAnggota);
        iurananggota.setText(strIuranAnggota);
        modalpemupukan.setText(strModalPemupukan);
        target.setText(strTarget);
        targethasil.setText(strTargetHasil);
        iurananggota.setText(strIuranAnggota);
        komoditassi.setText(strKomoditasSI);
        komoditaspb.setText(strKomoditasPB);
    }

    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    //Yes button clicked
//                    CRULahanFragment.setDeletedData(itemDetail, appComponent);
                    startActivity(ListRDKActivity.createIntent(getApplicationContext()));
                    break;

                case DialogInterface.BUTTON_NEGATIVE:
                    //No button clicked
                    break;
            }
        }
    };

//    public String getData() {
//        realm.beginTransaction();
//        UserDB user =realm.where(UserDB.class).findFirst();
//        realm.commitTransaction();
//        String res;
//        if(user == null){
//            res = "";
//        }else{
//            try {
//                res = user.getNamaLengkap();
//            }catch (Exception e){
//                res = "";
//            }
//        }
//        return res;
//    }
}
