package teknodesa.devlops.pantaujuma.components.searchpetani;

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
import teknodesa.devlops.pantaujuma.components.adapter.FragmentPetaniAdapter;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.petani.PetaniRealm;

/**
 * Created by Marthin on 10/14/2017.
 */

public class SearchPetaniFragment extends DialogFragment implements FragmentPetaniAdapter.OnClickPetaniListener {

    public static List<PetaniRealm> listpetani = Collections.EMPTY_LIST;
    public static int keterangan;
    private static OnClickPetaniListener onClicPetani;
    private final String LAYOUT_ERROR = "error";
    private final String LAYOUT_LOADING = "loading";
    private final String LAYOUT_SUCCESS = "success";
    private final String LAYOUT_EMPTY = "emptyList";
    RecyclerView recyclerView;
    IconTextView spinner;
    SearchView searchViewListPetani;
    @Inject
    Realm realm;
    RecyclerView.LayoutManager linearLayoutManager;
    FragmentPetaniAdapter petaniAdapter;
    private ScaleInAnimationAdapter scaleInAnimationAdapter;

    public SearchPetaniFragment() {

    }

    public static SearchPetaniFragment newInstance(OnClickPetaniListener onClicPetanis) {
        SearchPetaniFragment.onClicPetani = onClicPetanis;
        SearchPetaniFragment fragment = new SearchPetaniFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = getActivity().getLayoutInflater().inflate(R.layout.layout_petani, null);
        ((MainApplication) getActivity().getApplication())
                .getComponent()
                .inject(this);

        MaterialDialog builder = new MaterialDialog.Builder(getActivity())
                .title("Cari Petani")
                .customView(v, false)
                .build();

        spinner = (IconTextView) v.findViewById(R.id.spinnerIcon);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerViewlistPetani);

        searchViewListPetani = (SearchView) v.findViewById(R.id.searchViewListPetani);
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
            listpetani = realm1.copyFromRealm(realm1.where(PetaniRealm.class).findAll().sort("biodata", Sort.ASCENDING));
        }, () -> {
            if (!listpetani.isEmpty()) {
                petaniAdapter = new FragmentPetaniAdapter(getActivity().getApplicationContext(), listpetani, this);
                scaleInAnimationAdapter = new ScaleInAnimationAdapter(petaniAdapter);
                recyclerView.setAdapter(scaleInAnimationAdapter);
                recyclerView.setLayoutManager(linearLayoutManager);
                updateLayout(LAYOUT_SUCCESS);
            } else {
                updateLayout(LAYOUT_EMPTY);
            }
        });
    }

    private void setSearchFunction() {
        searchViewListPetani.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                List<PetaniRealm> filteredList = filter(newText);
                petaniAdapter.animateTo(filteredList);
                recyclerView.scrollToPosition(0);

                return true;
            }
        });
    }

    private List<PetaniRealm> filter(String query) {
        query = query.toLowerCase();
        final List<PetaniRealm> filteredList = new ArrayList<>();
        for (PetaniRealm konten : realm.where(PetaniRealm.class).findAll()) {
            final String text = konten.getBiodata().toLowerCase();
            if (text.contains(query)) {
                filteredList.add(konten);
            }
        }
        return filteredList;
    }

    @Override
    public void OnClickPetani(String idPetani, String namaDepan, String namaBelakang, String nik) {
        onClicPetani.OnClickPetani(idPetani, namaDepan, namaBelakang, nik);
        dismiss();
    }

    public interface OnClickPetaniListener {
        void OnClickPetani(String idPetani, String biodata, String deskripsi, String status);
    }
}
