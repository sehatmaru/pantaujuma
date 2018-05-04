package teknodesa.devlops.pantaujuma.components;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.petani.CRUPetaniFragment;

public class ListDataActivity extends AppCompatActivity {
    private String mJenisCRU;

    @BindView(R.id.fabTambah)
    FloatingActionButton fabTambah;

    @OnClick(R.id.fabTambah)
    void clickCheckOut() {
        startActivity(CRUActivity.createIntent(getApplicationContext(), "petani", "create", null));
    }

    public static Intent createIntent(Context context, String mJenisCRU) {
        Intent mIntent = new Intent(context, ListDataActivity.class);
        mIntent.putExtra("jenisCRU", mJenisCRU);
        return mIntent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_listdata);
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
            Toast.makeText(getApplicationContext(), "masuk: " + mJenisCRU, Toast.LENGTH_LONG).show();

        } else {
            /**
             * Apabila Bundle tidak ada, ambil dari Intent
             */
            this.mJenisCRU = "-";
            Toast.makeText(getApplicationContext(), "masuk: " + mJenisCRU, Toast.LENGTH_LONG).show();
        }
    }
}
