package teknodesa.devlops.pantaujuma.components.lahan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.CRUActivity;
import teknodesa.devlops.pantaujuma.components.base.BaseActivity;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.komoditas.LahanParcelable;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.LahanRealm;

public class DetailLahanActivity extends BaseActivity {
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

    public static LahanRealm dataLahan;


    public static Intent createIntent(Context context, LahanRealm id) {
        dataLahan =id;
        return new Intent(context, DetailLahanActivity.class);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_lahan);
        ButterKnife.bind(this);
        setdata();
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

}
