package teknodesa.devlops.pantaujuma.components.post;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.Sort;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.CRUActivity;
import teknodesa.devlops.pantaujuma.components.adapter.PostAdapter;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.KomentarRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.PostRealm;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.GetKomentarService;
import teknodesa.devlops.pantaujuma.utils.Konstanta;
import teknodesa.devlops.pantaujuma.utils.NetworkUtils;

public class PostFragment extends Fragment implements GetPostContract.View, GetKomentarContract.View, PostAdapter.OnClickPostListener{

    FragmentActivity activity;
    private final String mJenisCRU = "post";

    @BindView(R.id.fabTambah)
    FloatingActionButton fabTambah;

    @OnClick(R.id.fabTambah)
    void clickCheckOut() {
        if (isNetworkConnected()){
            startActivity(CRUActivity.createIntent(getContext(), mJenisCRU, "insert", null));
        }else{
            createSnackbar("Koneksi tidak tersedia").show();
        }
    }

    @Inject
    GetPostController mController;

    @Inject
    GetKomentarController kController;

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
    private Snackbar snackbar;
    static int counter;
    private List<PostRealm> listpostNotSync = Collections.EMPTY_LIST;
    static int hasilList =0;

    private List<PostRealm> listData = Collections.EMPTY_LIST;
    private ScaleInAnimationAdapter scaleInAnimationAdapter;
    PostAdapter postAdapter;
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
        View v = inflater.inflate(R.layout.fragment_post, container, false);
        ButterKnife.bind(this, v);
        ((AppCompatActivity) getActivity()).getDelegate().setSupportActionBar(toolbar);
        setHasOptionsMenu(true);
        progressdialog = new ProgressDialog(getActivity());

        mController.setView(this);
        kController.setView(this);

        linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());

        realm.beginTransaction();
        listpostNotSync = realm.where(PostRealm.class).equalTo("isSync",0).findAll();
        realm.commitTransaction();

        hasilList = listpostNotSync.size();

        Log.e("hasil", "" + hasilList);
        Log.e("list", listpostNotSync.toString());

        updateLayout(Konstanta.LAYOUT_LOADING);
        populateInitialData();
        checkDataRealm();
        return v;
    }

    private void populateInitialData(){
        realm.executeTransactionAsync(realm1 -> {
            listData = realm1.copyFromRealm(realm1.where(PostRealm.class).sort("tanggal", Sort.ASCENDING, "waktu", Sort.ASCENDING).findAll());
        }, () -> {
            if (!listData.isEmpty()) {
                postAdapter = new PostAdapter(getActivity().getApplicationContext(), listData,this);
                scaleInAnimationAdapter = new ScaleInAnimationAdapter(postAdapter);
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
                List<PostRealm> filteredList = filter(newText);
                postAdapter.animateTo(filteredList);
                recyclerView.scrollToPosition(0);

                return true;
            }
        });
    }

    private void checkDataRealm(){
        if(hasilList > 0){
            showRealmData(""+hasilList).show();
        }
    }

    private Snackbar showRealmData(String message) {
        snackbar = Snackbar.make(coordinatorLayout, "Anda memiliki data post "+message+ " yang belum di backup", 5000);
        return snackbar;
    }

    private List<PostRealm> filter(String query) {
        query = query.toLowerCase();
        final List<PostRealm> filteredList = new ArrayList<>();
        for (PostRealm konten : realm.where(PostRealm.class).findAll()) {
            final String text = konten.getJudul().toLowerCase();
            if (text.contains(query)) {
                filteredList.add(konten);
            }
        }
        return filteredList;
    }

    private Snackbar createSnackbar(String message) {
        snackbar = Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_INDEFINITE);
        return snackbar;
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
        menuInflater.inflate(R.menu.menu_eidu, menu);
        super.onCreateOptionsMenu(menu,menuInflater);

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

        MaterialDialog dialog = new MaterialDialog.Builder(getActivity())
                .title(R.string.title_download)
                .content(R.string.content_download)
                .positiveText(R.string.yes)
                .negativeText(R.string.no)
                .onPositive((dialog1, which) -> {
                    mController.getAllPost();
                    updateLayout(Konstanta.LAYOUT_LOADING);
                })
                .onNegative((dialog1, which) -> {

                })
                .build();
        dialog.show();
    }


    private void syncDialog() {
        MaterialDialog dialog = new MaterialDialog.Builder(getActivity())
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
        mController.saveData(listpostNotSync);
    }

    @Override
    public void getAllPostSuccess(List<PostRealm> allPost) {
        populateInitialData();
        snackbar.dismiss();
    }

    @Override
    public void getAllPostFailed(String message) {
        updateLayout(Konstanta.LAYOUT_ERROR);
        createSnackbar(message).show();
    }

    @Override
    public void getAllKomentarSuccess(List<KomentarRealm> allKomentar) {

    }

    @Override
    public void getAllKomentarFailed(String message) {

    }

    @Override
    public void saveDataSuccess(String message) {
        counter++;
        if(counter == hasilList){
            progressdialog.dismiss();
            mController.getAllPost();
            updateLayout(Konstanta.LAYOUT_LOADING);
            getActivity().recreate();
            snackbar.dismiss();
        }
    }

    @Override
    public void saveDataFailed(String message) {
        progressdialog.dismiss();
    }

    @Override
    public void OnClickPost(String idPost) {
        startActivity(DetailPostActivity.createIntent(getContext(),idPost));
    }
    public boolean isNetworkConnected() {
        boolean result = NetworkUtils.isNetworkConnected(getContext());
        return result;
    }
}
