package teknodesa.devlops.pantaujuma.components;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.alsintan.CRUAlsintanFragment;
import teknodesa.devlops.pantaujuma.components.harga.CRUHargaFragment;
import teknodesa.devlops.pantaujuma.components.komoditas.CRUKomoditasFragment;
import teknodesa.devlops.pantaujuma.components.lahan.CRULahanFragment;
import teknodesa.devlops.pantaujuma.components.penduduk.CRUPendudukFragment;
import teknodesa.devlops.pantaujuma.components.petani.CRUPengurusPoktanFragment;
import teknodesa.devlops.pantaujuma.components.petani.CRUPetaniFragment;
import teknodesa.devlops.pantaujuma.components.petani.CRUPoktanFragment;
import teknodesa.devlops.pantaujuma.components.petugas.CRUTargetPetugasFragment;
import teknodesa.devlops.pantaujuma.components.rdk.CRURDKFragment;
import teknodesa.devlops.pantaujuma.components.rdkk.CRURDKKPupukSubsidiFragment;
import teknodesa.devlops.pantaujuma.components.rktp.CRURKTPFragment;
import teknodesa.devlops.pantaujuma.components.survei.CRUSurveiFragment;

public class CRUActivity extends AppCompatActivity {
    private String mJenisCRU;
    private String mAction;
    private Parcelable mData;

    @Inject
    CRUPendudukFragment cruPendudukFragment;
    @Inject
    CRUPetaniFragment cruPetaniFragment;
    @Inject
    CRUPoktanFragment cruPoktanFragment;
    @Inject
    CRURDKFragment cruRDKFragment;
    @Inject
    CRURDKKPupukSubsidiFragment cruRDKKPupukSubsidiFragment;
    @Inject
    CRURKTPFragment cruRKTPFragment;
    @Inject
    CRUTargetPetugasFragment cruTargetPetugasFragment;
    @Inject
    CRULahanFragment cruLahanFragment;
    @Inject
    CRUKomoditasFragment cruKomoditasFragment;
    @Inject
    CRUAlsintanFragment cruAlsintanFragment;
    @Inject
    CRUHargaFragment cruHargaFragment;
    @Inject
    CRUSurveiFragment cruSurveiFragment;

    @BindView(R.id.content)
    FrameLayout content;
    @BindView(R.id.btnAction)
    Button btnAction;

    public static Intent createIntent(Context context, String mJenisCRU, String mAction, Parcelable mData) {
        Intent mIntent = new Intent(context, CRUActivity.class);
        mIntent.putExtra("jenisCRU", mJenisCRU);
        mIntent.putExtra("action", mAction);
        mIntent.putExtra("data", mData);
        return mIntent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MainApplication) getApplication())
                .getComponent()
                .inject(this);

        setContentView(R.layout.activity_cru);

        ButterKnife.bind(this);

        /**
         * Kita cek apakah ada Bundle atau tidak
         */
        if (getIntent().getExtras() != null) {
            /**
             * Jika Bundle ada, ambil data dari Bundle
             */
            Bundle bundle = getIntent().getExtras();
            this.mJenisCRU = bundle.getString("jenisCRU");
            this.mAction = bundle.getString("action");
            this.mData = mData;
            Toast.makeText(getApplicationContext(),"masuk: "+mJenisCRU,Toast.LENGTH_LONG).show();

            switch (mJenisCRU){
                case "penduduk": replaceFragment(cruPendudukFragment); break;
                case "petani": replaceFragment(cruPetaniFragment); break;
                case "poktan": replaceFragment(cruPoktanFragment); break;
                case "rdk": replaceFragment(cruRDKFragment); break;
                case "rdkk": replaceFragment(cruRDKKPupukSubsidiFragment); break;
                case "rktp": replaceFragment(cruRKTPFragment); break;
                case "target": replaceFragment(cruTargetPetugasFragment); break;
                case "lahan": replaceFragment(cruLahanFragment); break;
                case "komoditas": replaceFragment(cruKomoditasFragment); break;
                case "alsintan": replaceFragment(cruAlsintanFragment); break;
                case "harga": replaceFragment(cruHargaFragment); break;
                case "survei": replaceFragment(cruSurveiFragment); break;
            }
        } else {
            /**
             * Apabila Bundle tidak ada, ambil dari Intent
             */
            this.mJenisCRU = "-";
            this.mAction = "-";
            this.mData = null;
            //Toast.makeText(getApplicationContext(),"masuk: "+mJenisCRU,Toast.LENGTH_LONG).show();
        }

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.content, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }
}
