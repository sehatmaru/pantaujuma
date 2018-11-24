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
import android.view.MenuItem;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;
import com.joanzapata.iconify.widget.IconTextView;

import java.lang.annotation.Target;
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
import teknodesa.devlops.pantaujuma.dependencies.models.realms.petugas.TargetPetugas;
import teknodesa.devlops.pantaujuma.utils.Konstanta;

public class ListTargetActivity extends BaseActivity implements TargetAdapter.OnClickTargetListener, GetTargetContract.View {
    private final String mJenisCRU = "target";

    private List<TargetPetugas> listtarget = Collections.EMPTY_LIST;
    private List<TargetPetugas> listtargetNotSync = Collections.EMPTY_LIST;

    @Inject
    Realm realm;
    TargetAdapter targetAdapter;
    RecyclerView.LayoutManager linearLayoutManager;

    @Inject
    GetTargetController mController;

    @BindView(R.id.coordinatorLayoutTarget)
    CoordinatorLayout coordinatorLayout;

    @BindView(R.id.searchViewListTarget)
    SearchView searchView;

    @BindView(R.id.spinnerIcon)
    IconTextView spinner;

    @BindView(R.id.fabTambah)
    FloatingActionButton fabTambah;
    @OnClick(R.id.fabTambah)
    void clickCheckOut() {
        startActivity(CRUActivity.createIntent(getApplicationContext(), mJenisCRU, "insert", null));
        finish();
    }

    @BindView(R.id.rcList)
    RecyclerView rcList;
    private ScaleInAnimationAdapter scaleInAnimationAdapter;

    private ProgressDialog progressdialog;
    private Snackbar snackbar;
    static int counter;
    public static Intent createIntent(Context context) {
        return new Intent(context, ListTargetActivity.class);
    }
    static int hasilList =0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((MainApplication) getApplication())
                .getComponent()
                .inject(this);

        setContentView(R.layout.activity_listtarget);
        ButterKnife.bind(this);
        counter=0;
        mController.setView(this);
        progressdialog = new ProgressDialog(this);

        linearLayoutManager = new LinearLayoutManager(getApplicationContext());

        getNotSync();
        spinner.setVisibility(View.VISIBLE);

        populateInitialData();
    }

    private void getNotSync(){
        realm.beginTransaction();
        listtargetNotSync = realm.where(TargetPetugas.class).equalTo("isSync",0).findAll();
        realm.commitTransaction();
        hasilList = listtargetNotSync.size();
        Log.e("hasil", "" + hasilList);
    }

    private void populateInitialData(){
        realm.executeTransactionAsync(realm1 -> {
            listtarget = realm1.copyFromRealm(realm1.where(TargetPetugas.class).sort("isSync",Sort.ASCENDING).findAll());
        }, () -> {
            if (!listtarget.isEmpty()) {
                targetAdapter = new TargetAdapter(getApplicationContext(), listtarget,this);
                scaleInAnimationAdapter = new ScaleInAnimationAdapter(targetAdapter);
                rcList.setAdapter(scaleInAnimationAdapter);
                rcList.setLayoutManager(linearLayoutManager);
                getNotSync();
                checkDataRealm();
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
            final String text = konten.getHashId().toLowerCase();
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
        startActivity(DetailTargetActivity.createIntent(getApplicationContext(),idTarget));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_eidu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_sync){
            if(isNetworkConnected()){
                syncDialog();
            }else {
                createSnackbar("Koneksi Tidak Tersedia").show();
            }
            return true;
        }
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
                    mController.getAllTarget();
                    updateLayout(Konstanta.LAYOUT_LOADING);
                })
                .onNegative((dialog1, which) -> {

                })
                .build();
        dialog.show();
    }

    private void syncDialog() {
        MaterialDialog dialog = new MaterialDialog.Builder(this)
                .title(R.string.title_sync)
                .content(R.string.content_sync)
                .positiveText(R.string.yes)
                .negativeText(R.string.no)
                .onPositive((dialog1, which) -> {
                    progressdialog.show();
                    progressdialog.setCancelable(false);
                    progressdialog.setCanceledOnTouchOutside(false);
                    startSync();
                })
                .onNegative((dialog1, which) -> {

                })
                .build();
        dialog.show();
    }

    private void startSync(){
        counter=0;
        mController.saveData(listtargetNotSync);
    }

    private void checkDataRealm(){
        if(hasilList > 0){
            showRealmData(""+hasilList).show();
        }
    }

    private Snackbar showRealmData(String message) {
        snackbar = Snackbar.make(coordinatorLayout, "Anda memiliki " +message+ " data target yang belum di backup", Snackbar.LENGTH_INDEFINITE);

        return snackbar;
    }

    @Override
    public void getAllTargetSuccess(List<TargetPetugas> allTarget) {
        populateInitialData();
    }

    @Override
    public void getAllTargetFailed(String message) {
        createSnackbar(message).show();
        updateLayout(Konstanta.LAYOUT_ERROR);
    }

    @Override
    public void saveDataSuccess(String message) {
        progressdialog.dismiss();
        mController.getAllTarget();
        updateLayout(Konstanta.LAYOUT_LOADING);
        snackbar.dismiss();
//        this.recreate();
    }

    @Override
    public void saveDataFailed(String message) {
        progressdialog.dismiss();
        onError(message);
    }
}