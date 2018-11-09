package teknodesa.devlops.pantaujuma.components.komoditas;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

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
import teknodesa.devlops.pantaujuma.components.adapter.KomoditasAdapter;
import teknodesa.devlops.pantaujuma.components.lahan.ListLahanKomoditasActivity;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.KomoditasRealm;
import teknodesa.devlops.pantaujuma.utils.Konstanta;

public class KomoditasFragment extends Fragment implements KomoditasContract.View , KomoditasAdapter.OnClickKomoditasListener{

    FragmentActivity activity;

    @Inject
    KomoditasController mController;

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

    private List<KomoditasRealm> listData = Collections.EMPTY_LIST;
    private ScaleInAnimationAdapter scaleInAnimationAdapter;
    KomoditasAdapter pendudukAdapter;
    RecyclerView.LayoutManager linearLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
        ((MainApplication) getActivity().getApplication())
                .getComponent()
                .inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_komoditas, container, false);
        ButterKnife.bind(this, v);
        ((AppCompatActivity) getActivity()).getDelegate().setSupportActionBar(toolbar);
        setHasOptionsMenu(true);
        progressdialog = new ProgressDialog(getActivity());

        mController.setView(this);
        linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        updateLayout(Konstanta.LAYOUT_LOADING);
        populateInitialData();
        return v;
    }

    private void populateInitialData(){
        realm.executeTransactionAsync(realm1 -> {
            listData = realm1.copyFromRealm(realm1.where(KomoditasRealm.class).sort("nama", Sort.ASCENDING).findAll());
        }, () -> {
            if (!listData.isEmpty()) {
                pendudukAdapter = new KomoditasAdapter(getActivity().getApplicationContext(), listData,this);
                scaleInAnimationAdapter = new ScaleInAnimationAdapter(pendudukAdapter);
                recyclerView.setAdapter(scaleInAnimationAdapter);
                recyclerView.setLayoutManager(linearLayoutManager);
                updateLayout(Konstanta.LAYOUT_SUCCESS);
                setSearchFunction();
            }else {
                updateLayout(Konstanta.LAYOUT_EMPTY);
            }
        });
    }

    private void setSearchFunction() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                List<KomoditasRealm> filteredList = filter(newText);
                pendudukAdapter.animateTo(filteredList);
                recyclerView.scrollToPosition(0);

                return true;
            }
        });
    }
    private List<KomoditasRealm> filter(String query) {
        query = query.toLowerCase();
        final List<KomoditasRealm> filteredList = new ArrayList<>();
        for (KomoditasRealm konten : realm.where(KomoditasRealm.class).findAll()) {
            final String text = konten.getNama().toLowerCase();
            if (text.contains(query)) {
                filteredList.add(konten);
            }
        }
        return filteredList;
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



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.menu_komoditas, menu);
        super.onCreateOptionsMenu(menu,menuInflater);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_download:
                if(isNetworkAvailable()){
                    createDownloadDialog();
                }else {
                    createSnackbar("Koneksi Tidak Tersedia").show();
                }
                break;


        }
        return super.onOptionsItemSelected(item);
    }
    private void createDownloadDialog() {

        MaterialDialog dialog = new MaterialDialog.Builder(getActivity())
                .title(R.string.title_download)
                .content(R.string.content_download)
                .positiveText(R.string.yes)
                .negativeText(R.string.no)
                .onPositive((dialog1, which) -> {
                    mController.getAllKomoditas();
                    updateLayout(Konstanta.LAYOUT_LOADING);
                })
                .onNegative((dialog1, which) -> {

                })
                .build();
        dialog.show();
    }



    @Override
    public void getAllKomoditasSuccess(List<KomoditasRealm> allKomoditas) {
        populateInitialData();
    }

    @Override
    public void getAllKomoditasFailed(String message) {
        updateLayout(Konstanta.LAYOUT_ERROR);
        createSnackbar(message).show();
    }

    @Override
    public void OnClickKomoditas(KomoditasRealm komoditasRealm) {
        startActivity(ListLahanKomoditasActivity.createIntent(getActivity().getApplicationContext(),komoditasRealm));
    }
    private Boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }
}
