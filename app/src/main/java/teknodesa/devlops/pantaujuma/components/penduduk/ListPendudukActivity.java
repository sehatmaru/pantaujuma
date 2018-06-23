package teknodesa.devlops.pantaujuma.components.penduduk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

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
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.Penduduk;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.PendudukRealm;
import teknodesa.devlops.pantaujuma.utils.Konstanta;

public class ListPendudukActivity extends AppCompatActivity  implements PendudukAdapter.OnClickPendudukListener{
    @Inject
    Realm realm;

    private final String mJenisCRU = "penduduk";

    private List<PendudukRealm> listpenduduk = Collections.EMPTY_LIST;
    List<Penduduk> listPendudukRealm = Collections.EMPTY_LIST;

    private ScaleInAnimationAdapter scaleInAnimationAdapter;
    PendudukAdapter pendudukAdapter;
    RecyclerView.LayoutManager linearLayoutManager;
    private static int lakiLaki =0;
    private static int perempuan =0;

    @BindView(R.id.totalLaki)
    TextView totalLaki;

    @BindView(R.id.totalPerempuan)
    TextView totalPerempuan;

    @BindView(R.id.coordinatorLayoutPenduduk)
    CoordinatorLayout coordinatorLayout;

    @BindView(R.id.searchViewListPenduduk)
    SearchView searchView;

    @BindView(R.id.spinnerIcon)
    IconTextView spinner;

    @BindView(R.id.fabTambah)
    FloatingActionButton fabTambah;

    @BindView(R.id.rcList)
    RecyclerView rcList;

    @OnClick(R.id.fabTambah)
    void clickCheckOut() {
        startActivity(CRUActivity.createIntent(getApplicationContext(), mJenisCRU, "create", null));
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, ListPendudukActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((MainApplication) getApplication())
                .getComponent()
                .inject(this);

        setContentView(R.layout.activity_listpenduduk);
        ButterKnife.bind(this);

        linearLayoutManager = new LinearLayoutManager(getApplicationContext());

        realm.beginTransaction();
        listPendudukRealm = realm.where(Penduduk.class).findAll();
        realm.commitTransaction();

        realm.beginTransaction();
        lakiLaki = realm.where(PendudukRealm.class).equalTo("jenisKelamin","Laki-Laki").findAll().size();
        perempuan = realm.where(PendudukRealm.class).equalTo("jenisKelamin","Perempuan").findAll().size();
        realm.commitTransaction();
        spinner.setVisibility(View.VISIBLE);

        populateInitialData();

        checkDataRealm();
        setDataPenduduk();

    }

    private void populateInitialData(){
        realm.executeTransactionAsync(realm1 -> {
            listpenduduk = realm1.copyFromRealm(realm1.where(PendudukRealm.class).sort("namaDepan", Sort.ASCENDING).findAll());
        }, () -> {
            if (!listpenduduk.isEmpty()) {
                Log.e("List Penduduk","ini hasil"+listpenduduk.size());

                pendudukAdapter = new PendudukAdapter(getApplicationContext(), listpenduduk,this);
                scaleInAnimationAdapter = new ScaleInAnimationAdapter(pendudukAdapter);
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
                createSnackbar(Konstanta.LAYOUT_EMPTY).show();
                spinner.setText("{fa-info 200%}  No data found");
                break;
            case Konstanta.LAYOUT_ERROR:
                createSnackbar(Konstanta.LAYOUT_ERROR).show();
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
                List<PendudukRealm> filteredList = filter(newText);
                pendudukAdapter.animateTo(filteredList);
                rcList.scrollToPosition(0);

                return true;
            }
        });
    }

    private List<PendudukRealm> filter(String query) {
        query = query.toLowerCase();
        final List<PendudukRealm> filteredList = new ArrayList<>();
        for (PendudukRealm konten : realm.where(PendudukRealm.class).findAll()) {
            final String text = konten.getNamaDepan().toLowerCase();
            if (text.contains(query)) {
                filteredList.add(konten);
            }
        }
        return filteredList;
    }

    private Snackbar createSnackbar(String message) {
        return Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_INDEFINITE)
                .setAction("REFRESH", v -> ListPendudukActivity.this.recreate());
    }

    @Override
    public void OnClickPenduduk(int idPenduduk) {
        startActivity(DetailPendudukActivity.createIntent(getApplicationContext(),idPenduduk));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_eidu, menu);
        return true;

    }

    private void setDataPenduduk(){
        totalPerempuan.setText("Perempuan :"+ perempuan);
        totalLaki.setText("Laki-Laki :"+ lakiLaki);
    }

    private void checkDataRealm(){
        if(listPendudukRealm.size() > 0){
            Log.e("list penduduk ",listPendudukRealm.get(0).toString());
            showRealmData(""+listPendudukRealm.size()).show();
        }
    }

    private Snackbar showRealmData(String message) {
        return Snackbar.make(coordinatorLayout, "Anda memiliki data penduduk "+message+ " yang belum di backup", Snackbar.LENGTH_INDEFINITE);
    }
}
