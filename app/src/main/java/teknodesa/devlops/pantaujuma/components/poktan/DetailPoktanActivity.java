package teknodesa.devlops.pantaujuma.components.poktan;

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
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.Poktan;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.UserDB;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.PoktanRealm;

public class DetailPoktanActivity extends AppCompatActivity {
    private AppComponent appComponent;

    @Inject
    Realm realm;

    @BindView(R.id.btnEdit)
    Button btnEdit;

    @BindView(R.id.nama)
    TextView nama;

    @BindView(R.id.desa)
    TextView desa;

    @BindView(R.id.kecamatan)
    TextView kecamatan;

    @BindView(R.id.tanggal)
    TextView tanggal;

    @BindView(R.id.alamat)
    TextView alamat;

    @BindView(R.id.nohp)
    TextView nohp;

    @BindView(R.id.notelp)
    TextView notelp;

    @BindView(R.id.deskripsi)
    TextView deskripsi;

    @OnClick(R.id.btnEdit)
    void clickEdit() {
        Poktan poktanObject = new Poktan(dataPoktan);
        startActivity(CRUActivity.createIntent(getApplicationContext(), "poktan", "update", poktanObject));
        finish();
    }

    @OnClick(R.id.btnAnggota)
    void tambahAnggota() {
        startActivity(CRUActivity.createIntent(getApplicationContext(), "anggotapoktan", "insert", null));
        finish();
    }

    @OnClick(R.id.btnPengurus)
    void tambahPengurus() {
        startActivity(CRUActivity.createIntent(getApplicationContext(), "penguruspoktan", "insert", null));
        finish();
    }

    public static PoktanRealm dataPoktan;

    public static String idPoktan;

    public static Intent createIntent(Context context, String id) {
        idPoktan = id;
        return new Intent(context, DetailPoktanActivity.class);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_poktan);

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
        dataPoktan = realm.where(PoktanRealm.class).equalTo("hashId", idPoktan).findFirst();
        realm.commitTransaction();
    }

    private void setdata(){
        nama.setText(dataPoktan.getNama());
        desa.setText(getNamaDesa());
        kecamatan.setText(dataPoktan.getKecamatan());
        tanggal.setText(dataPoktan.getTanggalDidirikan());
        alamat.setText(dataPoktan.getAlamat());
        nohp.setText(dataPoktan.getNoHP());
        notelp.setText(dataPoktan.getNoTelp());
        deskripsi.setText(dataPoktan.getDeskripsi());
    }

    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    //Yes button clicked
                    startActivity(ListPoktanActivity.createIntent(getApplicationContext()));
                    break;

                case DialogInterface.BUTTON_NEGATIVE:
                    //No button clicked
                    break;
            }
        }
    };

    public String getNamaDesa() {
        realm.beginTransaction();
        UserDB user =realm.where(UserDB.class).findFirst();
        realm.commitTransaction();
        String res;
        if(user == null){
            res = "";
        }else{
            try {
                res = user.getNamaDesa();
            }catch (Exception e){
                res = "";
            }
        }
        return res;
    }
}
