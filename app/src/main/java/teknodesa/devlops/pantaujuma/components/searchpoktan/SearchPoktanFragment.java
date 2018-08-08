package teknodesa.devlops.pantaujuma.components.searchpoktan;

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
import teknodesa.devlops.pantaujuma.components.adapter.FragmentPoktanAdapter;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.PoktanRealm;

public class SearchPoktanFragment extends DialogFragment implements FragmentPoktanAdapter.OnClickPoktanListener {

    public static List<PoktanRealm> listpoktan = Collections.EMPTY_LIST;
    public static int keterangan;
    private static OnClickPoktanListener onClicPoktan;
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
    FragmentPoktanAdapter poktanAdapter;
    private ScaleInAnimationAdapter scaleInAnimationAdapter;

    public SearchPoktanFragment() {

    }

    public static SearchPoktanFragment newInstance(OnClickPoktanListener onClicPoktans) {
        SearchPoktanFragment.onClicPoktan = onClicPoktans;
        SearchPoktanFragment fragment = new SearchPoktanFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = getActivity().getLayoutInflater().inflate(R.layout.layouts_poktan, null);
        ((MainApplication) getActivity().getApplication())
                .getComponent()
                .inject(this);


        MaterialDialog builder = new MaterialDialog.Builder(getActivity())
                .title("Cari Poktan")
                .customView(v, false)
                .build();

        spinner = (IconTextView) v.findViewById(R.id.spinnerIcon);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerViewListPoktan);

        searchViewListKomoditas = (SearchView) v.findViewById(R.id.searchViewListPoktan);
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
            listpoktan = realm1.copyFromRealm(realm1.where(PoktanRealm.class).findAll().sort("nama", Sort.ASCENDING));
        }, () -> {
            if (!listpoktan.isEmpty()) {
                poktanAdapter = new FragmentPoktanAdapter(getActivity().getApplicationContext(), listpoktan, this);
                scaleInAnimationAdapter = new ScaleInAnimationAdapter(poktanAdapter);
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
                List<PoktanRealm> filteredList = filter(newText);
                poktanAdapter.animateTo(filteredList);
                recyclerView.scrollToPosition(0);

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

    @Override
    public void OnClickPoktan(String idPoktan, String nama, String deskripsi) {
        onClicPoktan.OnClickPoktan(idPoktan, nama, deskripsi);
        dismiss();
    }

    public interface OnClickPoktanListener {
        void OnClickPoktan(String idPoktan, String nama, String deskripsi);
    }
}
