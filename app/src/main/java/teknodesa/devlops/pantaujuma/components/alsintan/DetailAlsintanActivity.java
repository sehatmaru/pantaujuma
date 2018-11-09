package teknodesa.devlops.pantaujuma.components.alsintan;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.alsintan.AlsintanRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.KomoditasRealm;

public class DetailAlsintanActivity extends AppCompatActivity {
    private AppComponent appComponent;

    @Inject
    Realm realm;

    @BindView(R.id.namaAlat)
    TextView namaAlat;

    @BindView(R.id.deskripsi)
    TextView deskripsi;

    public static AlsintanRealm dataAlsintan;
    public static KomoditasRealm dataKomoditas;

    public static String idAlsintan;

    public static Intent createIntent(Context context, String id) {
        idAlsintan = id;
        return new Intent(context, DetailAlsintanActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_alsintan);

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
        dataAlsintan = realm.where(AlsintanRealm.class).equalTo("hashId", idAlsintan).findFirst();
        realm.commitTransaction();
    }

    private void setdata(){
        namaAlat.setText(dataAlsintan.getNamaAlat());
        deskripsi.setText(dataAlsintan.getDeskripsi());
    }

    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    //Yes button clicked
                    startActivity(ListAlsintanActivity.createIntent(getApplicationContext()));
                    break;

                case DialogInterface.BUTTON_NEGATIVE:
                    //No button clicked
                    break;
            }
        }
    };
}