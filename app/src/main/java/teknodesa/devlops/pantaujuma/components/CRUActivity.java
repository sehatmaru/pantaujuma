package teknodesa.devlops.pantaujuma.components;

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
import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.harga.CRUHargaFragment;
import teknodesa.devlops.pantaujuma.components.komoditas.CRUKomoditasFragment;
import teknodesa.devlops.pantaujuma.components.lahan.formlahan.CRULahanFragment;
import teknodesa.devlops.pantaujuma.components.penduduk.form.CRUPendudukFragment;
import teknodesa.devlops.pantaujuma.components.petani.CRUPetaniFragment;
import teknodesa.devlops.pantaujuma.components.petugas.CRUTargetPetugasFragment;
import teknodesa.devlops.pantaujuma.components.poktan.CRUAnggotaPoktanFragment;
import teknodesa.devlops.pantaujuma.components.poktan.CRUIdentitasPoktanFragment;
import teknodesa.devlops.pantaujuma.components.poktan.CRUPengurusPoktanFragment;
import teknodesa.devlops.pantaujuma.components.post.CRUPostFragment;
import teknodesa.devlops.pantaujuma.components.rdk.CRURDKFragment;
import teknodesa.devlops.pantaujuma.components.rdkk.CRURDKKPupukSubsidiFragment;
import teknodesa.devlops.pantaujuma.components.rktp.CRURKTPFragment;

public class CRUActivity extends AppCompatActivity {
    public static String mJenisCRU;
    public static String mAction;
    public static Parcelable mData;
    public static Context mContext;

    @Inject
    CRUPendudukFragment cruPendudukFragment;
    @Inject
    CRUPetaniFragment cruPetaniFragment;
    @Inject
    CRUIdentitasPoktanFragment cruIdentitasPoktanFragment;
    @Inject
    CRUAnggotaPoktanFragment cruAnggotaPoktanFragment;
    @Inject
    CRUPengurusPoktanFragment cruPengurusPoktanFragment;
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
    CRUHargaFragment cruHargaFragment;
    @Inject
    CRUPostFragment cruPostFragment;

    @BindView(R.id.content)
    FrameLayout content;

    @BindView(R.id.btnAction)
    Button btnAction;

    public static Intent createIntent(Context context, String mJenisCRU, String mAction, Parcelable mData) {
        CRUActivity.mJenisCRU = mJenisCRU;
        CRUActivity.mAction = mAction;
        CRUActivity.mData = mData;
        CRUActivity.mContext = context;

        return new Intent(context, CRUActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MainApplication) getApplication())
                .getComponent()
                .inject(this);

        setContentView(R.layout.activity_cru);

        ButterKnife.bind(this);

        switch (CRUActivity.mJenisCRU) {
            case "penduduk":
                replaceFragment(cruPendudukFragment);
                break;
            case "petani":
                replaceFragment(cruPetaniFragment);
                break;
            case "poktan":
                replaceFragment(cruIdentitasPoktanFragment);
                break;
            case "anggotapoktan":
                replaceFragment(cruAnggotaPoktanFragment);
                break;
            case "penguruspoktan":
                replaceFragment(cruPengurusPoktanFragment);
                break;
            case "rdk":
                replaceFragment(cruRDKFragment);
                break;
            case "rdkk":
                replaceFragment(cruRDKKPupukSubsidiFragment);
                break;
            case "rktp":
                replaceFragment(cruRKTPFragment);
                break;
            case "target":
                replaceFragment(cruTargetPetugasFragment);
                break;
            case "lahan":
                replaceFragment(cruLahanFragment);
                break;
            case "komoditas":
                replaceFragment(cruKomoditasFragment);
                break;
            case "harga":
                replaceFragment(cruHargaFragment);
                break;
            case "post":
                replaceFragment(cruPostFragment);
                break;
        }


        btnAction.setOnClickListener(v -> {
            switch (CRUActivity.mJenisCRU) {
                case "penduduk":
                    cruPendudukFragment.saveData(mAction, mData);
                    break;
                case "petani":
                    cruPetaniFragment.saveData(mAction, mData);
                    break;
                case "poktan":
                    cruIdentitasPoktanFragment.saveData(mAction, mData);
                    break;
                case "anggotapoktan":
                    cruAnggotaPoktanFragment.saveData(mAction, mData);
                    break;
                case "penguruspoktan":
                    cruPengurusPoktanFragment.saveData(mAction, mData);
                    break;
                case "target":
                    cruTargetPetugasFragment.saveData(mAction, mData);
                    break;
                case "rdkk":
                    cruRDKKPupukSubsidiFragment.saveData(mAction, mData);
                    break;
                case "rktp":
                    cruRKTPFragment.saveData(mAction, mData);
                    break;
                case "rdk":
                    cruRDKFragment.saveData(mAction, mData);
                    break;
                case "lahan":
                    cruLahanFragment.saveData(mAction, mData);
                    break;
                case "harga":
                    cruHargaFragment.saveData(mAction, mData);
                    break;
                case "post":
                    cruPostFragment.saveData(mAction, mData);
                    break;
            }
            // Code here executes on main thread after user presses button
            finish();
        });

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
