package teknodesa.devlops.pantaujuma.components.searchkomoditas;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;
import com.joanzapata.iconify.widget.IconTextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.Sort;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.adapter.FragmentKomoditasAdapter;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.KomoditasRealm;

public class SearchTargetKomoditasFragment extends DialogFragment implements FragmentKomoditasAdapter.OnClickKomoditasListener {

    public static List<KomoditasRealm> listtarget = Collections.EMPTY_LIST;
    public static int keterangan;
    private static OnClickKomoditasListener onClicKomoditas;
    private final String LAYOUT_ERROR = "error";
    private final String LAYOUT_LOADING = "loading";
    private final String LAYOUT_SUCCESS = "success";
    private final String LAYOUT_EMPTY = "emptyList";
    RecyclerView recyclerView;
    IconTextView spinner;
    SearchView searchViewListKomoditas;
    @Inject
    Realm realm;
    RecyclerView.LayoutManager linearLayoutManager;
    FragmentKomoditasAdapter komoditasAdapter;
    private ScaleInAnimationAdapter scaleInAnimationAdapter;

    public SearchTargetKomoditasFragment() {

    }

    public static SearchTargetKomoditasFragment newInstance(OnClickKomoditasListener onClicKomoditass) {
        SearchTargetKomoditasFragment.onClicKomoditas = onClicKomoditass;
        SearchTargetKomoditasFragment fragment = new SearchTargetKomoditasFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = getActivity().getLayoutInflater().inflate(R.layout.content_komoditas_fragment, null);
        ((MainApplication) getActivity().getApplication())
                .getComponent()
                .inject(this);


        MaterialDialog builder = new MaterialDialog.Builder(getActivity())
                .title("Cari Komoditas")
                .customView(v, false)
                .build();

        spinner = (IconTextView) v.findViewById(R.id.spinnerIcon);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);

        searchViewListKomoditas = (SearchView) v.findViewById(R.id.searchView);
        linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        spinner.setVisibility(View.VISIBLE);
        populateInitialData();
        setSearchFunction();

        builder.show();
        return builder;
    }

    private void updateLayout(String status) {
        switch (status) {
            case LAYOUT_SUCCESS:
                spinner.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
                break;
            case LAYOUT_EMPTY:
                spinner.setText("{fa-info 200%}  No data found");
                break;
            case LAYOUT_ERROR:
                spinner.setText("{fa-info 200%} Error");
                break;
            case LAYOUT_LOADING:
                recyclerView.setVisibility(View.GONE);
                spinner.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }

    private void populateInitialData() {
        realm.executeTransactionAsync(realm1 -> {
            listtarget = realm1.copyFromRealm(realm1.where(KomoditasRealm.class).findAll().sort("namaDepan", Sort.ASCENDING));
        }, () -> {
            if (!listtarget.isEmpty()) {
                komoditasAdapter = new FragmentKomoditasAdapter(getActivity().getApplicationContext(), listtarget, this);
                scaleInAnimationAdapter = new ScaleInAnimationAdapter(komoditasAdapter);
                recyclerView.setAdapter(scaleInAnimationAdapter);
                recyclerView.setLayoutManager(linearLayoutManager);
                updateLayout(LAYOUT_SUCCESS);
            } else {
                updateLayout(LAYOUT_EMPTY);
            }
        });
    }

    private void setSearchFunction() {
        searchViewListKomoditas.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                List<KomoditasRealm> filteredList = filter(newText);
                komoditasAdapter.animateTo(filteredList);
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

    @Override
    public void OnClickKomoditas(String idKomoditas, String nama, String deskripsi) {
        onClicKomoditas.OnClickKomoditas(keterangan, idKomoditas, nama, deskripsi);
        dismiss();
    }

    public interface OnClickKomoditasListener {
        void OnClickKomoditas(int keterangan, String idKomoditas, String nama, String deskripsi);
    }
}
