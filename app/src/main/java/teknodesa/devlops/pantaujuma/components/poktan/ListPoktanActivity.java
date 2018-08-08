package teknodesa.devlops.pantaujuma.components.poktan;

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
import teknodesa.devlops.pantaujuma.components.adapter.PoktanAdapter;
import teknodesa.devlops.pantaujuma.components.base.BaseActivity;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.PoktanRealm;
import teknodesa.devlops.pantaujuma.utils.Konstanta;

public class ListPoktanActivity extends BaseActivity implements PoktanAdapter.OnClickPoktanListener {
    @Inject
    Realm realm;

    private final String mJenisCRU = "poktan";

    private List<PoktanRealm> listpoktan = Collections.EMPTY_LIST;

    private ScaleInAnimationAdapter scaleInAnimationAdapter;
    PoktanAdapter poktanAdapter;
    RecyclerView.LayoutManager linearLayoutManager;

    @BindView(R.id.coordinatorLayoutPoktan)
    CoordinatorLayout coordinatorLayout;

    @BindView(R.id.searchViewListPoktan)
    SearchView searchView;

    @BindView(R.id.spinnerIcon)
    IconTextView spinner;

    @BindView(R.id.fabTambah)
    FloatingActionButton fabTambah;

    @BindView(R.id.rcList)
    RecyclerView rcList;

    @OnClick(R.id.fabTambah)
    void clickCheckOut() {
        startActivity(CRUActivity.createIntent(getApplicationContext(), mJenisCRU, "insert", null));
        finish();
    }

    private ProgressDialog progressdialog;
    static int counter;
    public static Intent createIntent(Context context) {
        return new Intent(context, ListPoktanActivity.class);
    }
    static int hasilList =0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((MainApplication) getApplication())
                .getComponent()
                .inject(this);

        setContentView(R.layout.activity_listpoktan);
        ButterKnife.bind(this);
        counter=0;

        linearLayoutManager = new LinearLayoutManager(getApplicationContext());

        spinner.setVisibility(View.VISIBLE);

        populateInitialData();
    }

    private void populateInitialData(){
        realm.executeTransactionAsync(realm1 -> {
            listpoktan = realm1.copyFromRealm(realm1.where(PoktanRealm.class).sort("nama", Sort.ASCENDING).findAll());
        }, () -> {
            if (!listpoktan.isEmpty()) {
                Log.e("List Poktan","ini hasil"+listpoktan.size());

                poktanAdapter = new PoktanAdapter(getApplicationContext(), listpoktan,this);
                scaleInAnimationAdapter = new ScaleInAnimationAdapter(poktanAdapter);
                rcList.setAdapter(scaleInAnimationAdapter);
                rcList.setLayoutManager(linearLayoutManager);
                updateLayout(Konstanta.LAYOUT_SUCCESS);
                setSearchFunction();
            }else {
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
                List<PoktanRealm> filteredList = filter(newText);
                poktanAdapter.animateTo(filteredList);
                rcList.scrollToPosition(0);

                return true;
            }
        });
    }

    private List<PoktanRealm> filter(String query) {
        query = query.toLowerCase();
        final List<PoktanRealm> filteredList = new ArrayList<>();
        for (PoktanRealm konten : realm.where(PoktanRealm.class).findAll()) {
            final String text = konten.getNama().toLowerCase();
            if (text.contains(query)) {
                filteredList.add(konten);
            }
        }
        return filteredList;
    }

    private Snackbar createSnackbar(String message) {
        return Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_INDEFINITE)
                .setAction("REFRESH", v -> ListPoktanActivity.this.recreate());
    }

    @Override
    public void OnClickPoktan(String idPoktan) {
        startActivity(DetailPoktanActivity.createIntent(getApplicationContext(),idPoktan));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_eidu, menu);
        return true;
    }
}
