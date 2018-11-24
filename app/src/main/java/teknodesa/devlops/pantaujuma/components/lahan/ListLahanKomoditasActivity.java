package teknodesa.devlops.pantaujuma.components.lahan;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;
import com.joanzapata.iconify.widget.IconTextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.adapter.LahanKomoditasAdapter;
import teknodesa.devlops.pantaujuma.components.base.BaseActivity;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.BodyGetLahan;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.UserDB;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.KomoditasRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.LahanRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.RiwayatLahanRealm;
import teknodesa.devlops.pantaujuma.utils.Konstanta;

public class ListLahanKomoditasActivity extends BaseActivity implements ListLahanKomoditasContract.View, LahanKomoditasAdapter.OnClickKomoditasListener {

    @Inject
    ListLahanKomoditasController mController;

    @Inject
    Realm realm;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;

    @BindView(R.id.searchView)
    SearchView searchView;

    @BindView(R.id.spinnerIcon)
    IconTextView spinner;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private ProgressDialog progressdialog;
    private List<RiwayatLahanRealm> listData = Collections.EMPTY_LIST;
    private ScaleInAnimationAdapter scaleInAnimationAdapter;
    LahanKomoditasAdapter mAdapter;
    RecyclerView.LayoutManager linearLayoutManager;

    public static KomoditasRealm komoditasRealm;

    public static Intent createIntent(Context context, KomoditasRealm komoditas) {
        komoditasRealm = komoditas;
        return new Intent(context, ListLahanKomoditasActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_lahan_komoditas);
        ((MainApplication) getApplication())
                .getComponent()
                .inject(this);
        ButterKnife.bind(this);
        getDelegate().setSupportActionBar(toolbar);
        progressdialog = new ProgressDialog(this);

        mController.setView(this);
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        updateLayout(Konstanta.LAYOUT_LOADING);
        populateInitialData();
    }

    private void populateInitialData(){
        Log.e("iD Komoditas",komoditasRealm.getHashId()+" data");
        realm.executeTransactionAsync(realm1 -> {
            listData = realm1.copyFromRealm(realm1.where(RiwayatLahanRealm.class).equalTo("idKomoditas",komoditasRealm.getHashId()).findAll());
        }, () -> {
            if (!listData.isEmpty()) {
                Log.e("List Komoditas","ini hasil"+listData.size());
                mAdapter = new LahanKomoditasAdapter(getApplicationContext(), listData,this);
                scaleInAnimationAdapter = new ScaleInAnimationAdapter(mAdapter);
                recyclerView.setAdapter(scaleInAnimationAdapter);
                recyclerView.setLayoutManager(linearLayoutManager);
                updateLayout(Konstanta.LAYOUT_SUCCESS);
                setSearchFunction();
            }else {
                updateLayout(Konstanta.LAYOUT_EMPTY);
            }
        });
    }
    private Snackbar createSnackbar(String message) {
        return Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_INDEFINITE);
    }

    private void updateLayout(String status) {
        switch (status) {
            case Konstanta.LAYOUT_SUCCESS:
                spinner.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
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
                recyclerView.setVisibility(View.GONE);
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
                List<RiwayatLahanRealm> filteredList = filter(newText);
                mAdapter.animateTo(filteredList);
                recyclerView.scrollToPosition(0);

                return true;
            }
        });
    }
    private List<RiwayatLahanRealm> filter(String query) {
        query = query.toLowerCase();
        final List<RiwayatLahanRealm> filteredList = new ArrayList<>();
        for (RiwayatLahanRealm konten : realm.where(RiwayatLahanRealm.class).findAll()) {
            final String text = konten.getNamaPemilikLahan().toLowerCase();
            if (text.contains(query)) {
                filteredList.add(konten);
            }
        }
        return filteredList;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_komoditas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_download){
            if(isNetworkConnected()){
                createDownloadDialog();
            }else {
                createSnackbar("Koneksi Tidak Tersedia").show();
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void createDownloadDialog() {
        MaterialDialog dialog = new MaterialDialog.Builder(this)
                .title(R.string.title_download)
                .content(R.string.content_download)
                .positiveText(R.string.yes)
                .negativeText(R.string.no)
                .onPositive((dialog1, which) -> {
                    mController.getLahanKomoditas(new BodyGetLahan(komoditasRealm.getHashId(), Integer.valueOf(getIdDesa())));
                    updateLayout(Konstanta.LAYOUT_LOADING);
                })
                .onNegative((dialog1, which) -> {

                })
                .build();
        dialog.show();
    }

    @Override
    public void getLahanKomoditasSuccess(List<LahanRealm> lahan) {
        populateInitialData();
    }

    @Override
    public void getLahanKomoditasFailed(String message) {
        createSnackbar(message).show();
    }

    @Override
    public void OnClickKomoditas(RiwayatLahanRealm riwayatLahanRealm) {
    }

    public String getIdDesa() {
        realm.beginTransaction();
        UserDB user =realm.where(UserDB.class).findFirst();
        realm.commitTransaction();
        String res;
        if(user == null){
            res = "";
        }else{
            try {
                res = user.getAttributeValue();
            }catch (Exception e){
                res = "";
            }
        }
        return res;
    }
}
