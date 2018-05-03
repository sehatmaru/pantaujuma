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
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.petani.CRUPetaniFragment;

public class CRUActivity extends AppCompatActivity {
    private String mJenisCRU;
    private String mAction;
    private Parcelable mData;

    CRUPetaniFragment cruPetaniFragment = new CRUPetaniFragment();

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

            if (mJenisCRU.equals("petani")) {
                replaceFragment(cruPetaniFragment);
            }else{
                replaceFragment(cruPetaniFragment);
            }

        } else {
            /**
             * Apabila Bundle tidak ada, ambil dari Intent
             */
            this.mJenisCRU = "-";
            this.mAction = "-";
            this.mData = null;
            Toast.makeText(getApplicationContext(),"masuk: "+mJenisCRU,Toast.LENGTH_LONG).show();
        }
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.content, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }
}
