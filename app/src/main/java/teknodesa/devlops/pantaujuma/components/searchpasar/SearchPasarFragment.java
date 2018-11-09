package teknodesa.devlops.pantaujuma.components.searchpasar;

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
import teknodesa.devlops.pantaujuma.components.adapter.FragmentPasarAdapter;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.pasar.PasarRealm;

public class SearchPasarFragment extends DialogFragment implements FragmentPasarAdapter.OnClickPasarListener {

    public static List<PasarRealm> listpasar = Collections.EMPTY_LIST;
    public static int keterangan;
    private static OnClickPasarListener onClicPasar;
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
    FragmentPasarAdapter pasarAdapter;
    private ScaleInAnimationAdapter scaleInAnimationAdapter;

    public SearchPasarFragment() {

    }

    public static SearchPasarFragment newInstance(OnClickPasarListener onClicPasars) {
        SearchPasarFragment.onClicPasar = onClicPasars;
        SearchPasarFragment fragment = new SearchPasarFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = getActivity().getLayoutInflater().inflate(R.layout.layouts_pasar, null);
        ((MainApplication) getActivity().getApplication())
                .getComponent()
                .inject(this);


        MaterialDialog builder = new MaterialDialog.Builder(getActivity())
                .title("Cari Pasar")
                .customView(v, false)
                .build();

        spinner = (IconTextView) v.findViewById(R.id.spinnerIcon);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerViewListPasar);

        searchViewListKomoditas = (SearchView) v.findViewById(R.id.searchViewListPasar);
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
            listpasar = realm1.copyFromRealm(realm1.where(PasarRealm.class).findAll().sort("namaPasar", Sort.ASCENDING));
        }, () -> {
            if (!listpasar.isEmpty()) {
                pasarAdapter = new FragmentPasarAdapter(getActivity().getApplicationContext(), listpasar, this);
                scaleInAnimationAdapter = new ScaleInAnimationAdapter(pasarAdapter);
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
                List<PasarRealm> filteredList = filter(newText);
                pasarAdapter.animateTo(filteredList);
                recyclerView.scrollToPosition(0);

                return true;
            }
        });
    }

    private List<PasarRealm> filter(String query) {
        query = query.toLowerCase();
        final List<PasarRealm> filteredList = new ArrayList<>();
        for (PasarRealm konten : realm.where(PasarRealm.class).findAll()) {
            final String text = konten.getNamaPasar().toLowerCase();
            if (text.contains(query)) {
                filteredList.add(konten);
            }
        }
        return filteredList;
    }

    @Override
    public void OnClickPasar(String idPasar, String nama, String alamat, String kecamatan, String kabupaten) {
        onClicPasar.OnClickPasar(idPasar, nama, alamat, kecamatan, kabupaten);
        dismiss();
    }

    public interface OnClickPasarListener {
        void OnClickPasar(String idPasar, String nama, String alamat, String jenis, String deskripsi);
    }
}
