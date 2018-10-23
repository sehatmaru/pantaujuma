package teknodesa.devlops.pantaujuma.components.lahan;

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
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.lahan.LahanParcelable;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.lahan.LahanRealm;

public class DetailLahanActivity extends AppCompatActivity {
    private AppComponent appComponent;

    @Inject
    Realm realm;

    @BindView(R.id.btnEdit)
    Button btnEdit;

    @BindView(R.id.namaPemilikLahan)
    TextView namaPemilikLahan;

    @BindView(R.id.luas)
    TextView luas;

    @BindView(R.id.alamat)
    TextView alamat;

    @BindView(R.id.batastimur)
    TextView batastimur;

    @BindView(R.id.batasselatan)
    TextView batasselatan;

    @BindView(R.id.batasbarat)
    TextView batasbarat;

    @BindView(R.id.batasutara)
    TextView batasutara;

    @BindView(R.id.deskripsi)
    TextView deskripsi;

    @OnClick(R.id.btnEdit)
    void clickEdit() {
        LahanParcelable lahanParcelable = new LahanParcelable(dataLahan);
        startActivity(CRUActivity.createIntent(getApplicationContext(), "lahan", "update", lahanParcelable));
        finish();
    }

    private LahanRealm dataLahan;

    private static String idLahan;

    public static Intent createIntent(Context context, String id) {
        idLahan =id;
        return new Intent(context, DetailLahanActivity.class);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_lahan);

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
        dataLahan = realm.where(LahanRealm.class).equalTo("hashId", idLahan).findFirst();
        realm.commitTransaction();
    }
    private void setdata(){
        namaPemilikLahan.setText(dataLahan.getNamaPemilikLahan());
        luas.setText(dataLahan.getLuas());
        alamat.setText(dataLahan.getAlamat());
        batastimur.setText(dataLahan.getBatasTimur());
        batasselatan.setText(dataLahan.getBatasSelatan());
        batasbarat.setText(dataLahan.getBatasBarat());
        batasutara.setText(dataLahan.getBatasUtara());
        deskripsi.setText(dataLahan.getDeskripsi());
    }

    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    //Yes button clicked
//                    CRULahanFragment.setDeletedData(itemDetail, appComponent);
                    startActivity(ListLahanActivity.createIntent(getApplicationContext()));
                    break;

                case DialogInterface.BUTTON_NEGATIVE:
                    //No button clicked
                    break;
            }
        }
    };
}
