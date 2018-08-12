package teknodesa.devlops.pantaujuma.components.petugas;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import com.joanzapata.iconify.widget.IconTextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.Sort;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.CRUActivity;
import teknodesa.devlops.pantaujuma.components.adapter.TargetAdapter;
import teknodesa.devlops.pantaujuma.components.base.BaseActivity;
import teknodesa.devlops.pantaujuma.components.profile.AkunFragment;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.petugas.TargetPetugas;
import teknodesa.devlops.pantaujuma.utils.Konstanta;

public class ListTargetActivity extends BaseActivity implements TargetAdapter.OnClickTargetListener {
    static int counter;
    static int hasilList = 0;
    private final String mJenisCRU = "target";
    @Inject
    Realm realm;
    TargetAdapter targetAdapter;
    RecyclerView.LayoutManager linearLayoutManager;

    @BindView(R.id.coordinatorLayoutTarget)
    CoordinatorLayout coordinatorLayout;

    @BindView(R.id.searchViewListTarget)
    SearchView searchView;

    @BindView(R.id.spinnerIcon)
    IconTextView spinner;

    @BindView(R.id.fabTambah)
    FloatingActionButton fabTambah;

    @BindView(R.id.rcList)
    RecyclerView rcList;
    private List<TargetPetugas> listtarget = Collections.EMPTY_LIST;
    private ScaleInAnimationAdapter scaleInAnimationAdapter;
    private ProgressDialog progressdialog;

    public static Intent createIntent(Context context) {
        return new Intent(context, ListTargetActivity.class);
    }

    @OnClick(R.id.fabTambah)
    void clickCheckOut() {
        startActivity(CRUActivity.createIntent(getApplicationContext(), mJenisCRU, "insert", null));
        finish();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((MainApplication) getApplication())
                .getComponent()
                .inject(this);

        setContentView(R.layout.activity_listtarget);
        ButterKnife.bind(this);
        counter = 0;

        linearLayoutManager = new LinearLayoutManager(getApplicationContext());

        spinner.setVisibility(View.VISIBLE);

        populateInitialData();
    }

    private void populateInitialData() {
        realm.executeTransactionAsync(realm1 -> {
            listtarget = realm1.copyFromRealm(realm1.where(TargetPetugas.class).sort("komoditas", Sort.ASCENDING).findAll());
        }, () -> {
            if (!listtarget.isEmpty()) {
                Log.e("List Target", "ini hasil" + listtarget.size());

                targetAdapter = new TargetAdapter(getApplicationContext(), listtarget, this);
                scaleInAnimationAdapter = new ScaleInAnimationAdapter(targetAdapter);
                rcList.setAdapter(scaleInAnimationAdapter);
                rcList.setLayoutManager(linearLayoutManager);
                updateLayout(Konstanta.LAYOUT_SUCCESS);
                setSearchFunction();
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

    private void setSearchFunction() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                List<TargetPetugas> filteredList = filter(newText);
                targetAdapter.animateTo(filteredList);
                rcList.scrollToPosition(0);

                return true;
            }
        });
    }

    private List<TargetPetugas> filter(String query) {
        query = query.toLowerCase();
        final List<TargetPetugas> filteredList = new ArrayList<>();
        for (TargetPetugas konten : realm.where(TargetPetugas.class).findAll()) {
            final String text = konten.getKomoditas().toLowerCase();
            if (text.contains(query)) {
                filteredList.add(konten);
            }
        }
        return filteredList;
    }

    private Snackbar createSnackbar(String message) {
        return Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_INDEFINITE)
                .setAction("REFRESH", v -> ListTargetActivity.this.recreate());
    }

    @Override
    public void OnClickTarget(String idTarget) {
        startActivity(DetailTargetActivity.createIntent(getApplicationContext(), idTarget));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_eidu, menu);
        return true;
    }
}
