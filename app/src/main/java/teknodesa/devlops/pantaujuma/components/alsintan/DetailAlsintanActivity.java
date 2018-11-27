package teknodesa.devlops.pantaujuma.components.alsintan;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.joanzapata.iconify.widget.IconTextView;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.adapter.TokoAlsintanAdapter;
import teknodesa.devlops.pantaujuma.components.base.BaseActivity;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.alsintan.TokoAlsintanRealm;
import teknodesa.devlops.pantaujuma.utils.Konstanta;

public class DetailAlsintanActivity extends BaseActivity implements TokoAlsintanAdapter.OnClickTokoAlsintanListener {
    static int counter;
    static int hasilList = 0;

    private List<TokoAlsintanRealm> listtoko = Collections.EMPTY_LIST;

    @Inject
    Realm realm;
    TokoAlsintanAdapter tokoAdapter;
    RecyclerView.LayoutManager linearLayoutManager;

    @BindView(R.id.coordinatorLayoutAlsintan)
    CoordinatorLayout coordinatorLayout;

    @BindView(R.id.spinnerIcon)
    IconTextView spinner;

    @BindView(R.id.rcList)
    RecyclerView rcList;
    private ScaleInAnimationAdapter scaleInAnimationAdapter;
    private ProgressDialog progressdialog;

    static String idAlsintan = "";

    public static Intent createIntent(Context context, String id) {
        idAlsintan = id;
        return new Intent(context, DetailAlsintanActivity.class);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((MainApplication) getApplication())
                .getComponent()
                .inject(this);

        setContentView(R.layout.activity_listalsintan);
        ButterKnife.bind(this);
        counter = 0;
        progressdialog = new ProgressDialog(this);

        linearLayoutManager = new LinearLayoutManager(getApplicationContext());

        spinner.setVisibility(View.VISIBLE);

        populateInitialData();
    }

    private void populateInitialData() {
        realm.executeTransactionAsync(realm1 -> {
            listtoko = realm1.copyFromRealm(realm1.where(TokoAlsintanRealm.class).equalTo("id_alat", idAlsintan).findAll());
        }, () -> {
            if (!listtoko.isEmpty()) {
                tokoAdapter = new TokoAlsintanAdapter(getApplicationContext(), listtoko, this);
                scaleInAnimationAdapter = new ScaleInAnimationAdapter(tokoAdapter);
                rcList.setAdapter(scaleInAnimationAdapter);
                rcList.setLayoutManager(linearLayoutManager);
                updateLayout(Konstanta.LAYOUT_SUCCESS);
            } else {
                updateLayout(Konstanta.LAYOUT_EMPTY);
            }
        });
    }

    private void updateLayout(String status) {
        switch (status) {
            case Konstanta.LAYOUT_SUCCESS:
                spinner.setVisibility(View.GONE);
                rcList.setVisibility(View.VISIBLE);
                break;
            case Konstanta.LAYOUT_EMPTY:
                onError(Konstanta.LAYOUT_EMPTY);
                spinner.setText("{fa-info 200%}  No data found");
                break;
            case Konstanta.LAYOUT_ERROR:
                onError(Konstanta.LAYOUT_ERROR);
                spinner.setText("{fa-info 200%} Error");
                break;
            case Konstanta.LAYOUT_LOADING:
                rcList.setVisibility(View.GONE);
                spinner.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }

    @Override
    public void OnClickTokoAlsintan(String idToko) {
        startActivity(TokoMapsActivity.createIntent(getApplicationContext(), idToko));
    }

}
