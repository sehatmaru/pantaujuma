package teknodesa.devlops.pantaujuma.components.rdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.CRUActivity;

public class ListRDKActivity extends AppCompatActivity {
    private final String mJenisCRU = "rdk";

    @BindView(R.id.fabTambah)
    FloatingActionButton fabTambah;

    @OnClick(R.id.fabTambah)
    void clickCheckOut() {
        startActivity(CRUActivity.createIntent(getApplicationContext(), mJenisCRU, "create", null));
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, ListRDKActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_listpetani);
        ButterKnife.bind(this);
    }
}
