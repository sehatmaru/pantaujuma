package teknodesa.devlops.pantaujuma.components.alsintan;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
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
import io.realm.Sort;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.CRUActivity;
import teknodesa.devlops.pantaujuma.components.adapter.AlsintanAdapter;
import teknodesa.devlops.pantaujuma.components.base.BaseActivity;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.alsintan.AlsintanRealm;
import teknodesa.devlops.pantaujuma.utils.Konstanta;

public class ListAlsintanActivity extends BaseActivity implements AlsintanAdapter.OnClickAlsintanListener, GetAlsintanContract.View {
    static int counter;
    static int hasilList = 0;

    private List<AlsintanRealm> listalsintan = Collections.EMPTY_LIST;
//    private List<AlsintanRealm> listalsintanNotSync = Collections.EMPTY_LIST;

    @Inject
    Realm realm;
    AlsintanAdapter alsintanAdapter;
    RecyclerView.LayoutManager linearLayoutManager;

    @Inject
    GetAlsintanController mController;

    @BindView(R.id.coordinatorLayoutAlsintan)
    CoordinatorLayout coordinatorLayout;

    @BindView(R.id.searchViewListAlsintan)
    SearchView searchView;

    @BindView(R.id.spinnerIcon)
    IconTextView spinner;

    @BindView(R.id.rcList)
    RecyclerView rcList;
    private ScaleInAnimationAdapter scaleInAnimationAdapter;
    private ProgressDialog progressdialog;

    public static Intent createIntent(Context context) {
        return new Intent(context, ListAlsintanActivity.class);
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
        mController.setView(this);
        progressdialog = new ProgressDialog(this);

        linearLayoutManager = new LinearLayoutManager(getApplicationContext());

//        realm.beginTransaction();
//        listalsintanNotSync = realm.where(AlsintanRealm.class).equalTo("isSync", 0).findAll();
//        realm.commitTransaction();
//
//        hasilList = listalsintanNotSync.size();
        spinner.setVisibility(View.VISIBLE);

        populateInitialData();

        checkDataRealm();
    }

    private void populateInitialData() {
        realm.executeTransactionAsync(realm1 -> {
            listalsintan = realm1.copyFromRealm(realm1.where(AlsintanRealm.class).sort("hashId", Sort.ASCENDING).findAll());
        }, () -> {
            if (!listalsintan.isEmpty()) {
                Log.e("List Alsintan", "ini hasil" + listalsintan.size());

                alsintanAdapter = new AlsintanAdapter(getApplicationContext(), listalsintan, this);
                scaleInAnimationAdapter = new ScaleInAnimationAdapter(alsintanAdapter);
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
                List<AlsintanRealm> filteredList = filter(newText);
                alsintanAdapter.animateTo(filteredList);
                rcList.scrollToPosition(0);

                return true;
            }
        });
    }

    private List<AlsintanRealm> filter(String query) {
        query = query.toLowerCase();
        final List<AlsintanRealm> filteredList = new ArrayList<>();
        for (AlsintanRealm konten : realm.where(AlsintanRealm.class).findAll()) {
            final String text = konten.getHashId().toLowerCase();
            if (text.contains(query)) {
                filteredList.add(konten);
            }
        }
        return filteredList;
    }

    private Snackbar createSnackbar(String message) {
        return Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_INDEFINITE)
                .setAction("REFRESH", v -> ListAlsintanActivity.this.recreate());
    }

    @Override
    public void OnClickAlsintan(String idAlsintan) {
        startActivity(DetailAlsintanActivity.createIntent(getApplicationContext(), idAlsintan));
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_eidu, menu);
//        return true;
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_komoditas, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_download:
                if(isNetworkConnected()){
                    createDownloadDialog();
                }else {
                    createSnackbar("Koneksi Tidak Tersedia").show();
                }
                break;


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
                    mController.getAllAlsintan();
                    updateLayout(Konstanta.LAYOUT_LOADING);
                })
                .onNegative((dialog1, which) -> {

                })
                .build();
        dialog.show();
    }

//
//    private void syncDialog() {
//        MaterialDialog dialog = new MaterialDialog.Builder(this)
//                .title(R.string.title_sync)
//                .content(R.string.content_sync)
//                .positiveText(R.string.yes)
//                .negativeText(R.string.no)
//                .onPositive((dialog1, which) -> {
//                    progressdialog.show();
//                    progressdialog.setCancelable(false);
//                    progressdialog.setCanceledOnTouchOutside(false);
//                    startSync();
//                })
//                .onNegative((dialog1, which) -> {
//
//                })
//                .build();
//        dialog.show();
//    }
//
//    private void startSync() {
//        counter = 0;
//        mController.saveData(listalsintanNotSync);
//    }

    private void checkDataRealm() {
        if (hasilList > 0) {
            showRealmData("" + hasilList).show();
        }
    }

    private Snackbar showRealmData(String message) {
        return Snackbar.make(coordinatorLayout, "Anda memiliki data alsintan " + message + " yang belum di backup", Snackbar.LENGTH_INDEFINITE);
    }

    @Override
    public void getAllAlsintanSuccess(List<AlsintanRealm> allAlsintan) {
        populateInitialData();
    }

    @Override
    public void getAllAlsintanFailed(String message) {
        createSnackbar(message).show();
        updateLayout(Konstanta.LAYOUT_ERROR);
    }

    @Override
    public void saveDataSuccess(String message) {
        counter++;
        Log.e("hasil", "counter" + counter + " list" + hasilList);
        if (counter == hasilList) {
            progressdialog.dismiss();
            mController.getAllAlsintan();
            updateLayout(Konstanta.LAYOUT_LOADING);
            this.recreate();
        }
    }

    @Override
    public void saveDataFailed(String message) {
        progressdialog.dismiss();
        onError(message);
    }
}