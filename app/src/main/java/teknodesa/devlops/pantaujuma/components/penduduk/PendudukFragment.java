package teknodesa.devlops.pantaujuma.components.penduduk;

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
import teknodesa.devlops.pantaujuma.dependencies.models.realms.PendudukRealm;

/**
 * Created by Marthin on 10/14/2017.
 */

public class PendudukFragment extends DialogFragment implements FragmentPendudukAdapter.OnClickPendudukListener {
    RecyclerView recyclerView;
    IconTextView spinner;
    SearchView searchViewListPenduduk;
    @Inject
    Realm realm;
    private final String LAYOUT_ERROR = "error";
    private final String LAYOUT_LOADING = "loading";
    private final String LAYOUT_SUCCESS = "success";
    private final String LAYOUT_EMPTY = "emptyList";
    public static int ket;
    RecyclerView.LayoutManager linearLayoutManager;
    private ScaleInAnimationAdapter scaleInAnimationAdapter;
    FragmentPendudukAdapter pendudukAdapter;

    public static List<PendudukRealm> listpenduduk = Collections.EMPTY_LIST;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = getActivity().getLayoutInflater().inflate(R.layout.layout_penduduk, null);
        //MainApplication.get(getActivity().getApplicationContext()).getInjector().inject(this);
        ((MainApplication) getActivity().getApplication())
                .getComponent()
                .inject(this);

        MaterialDialog builder = new MaterialDialog.Builder(getActivity())
                .title("Cari Penduduk")
                .customView(v,false)
                .build();

        spinner = (IconTextView)v.findViewById(R.id.spinnerIcon);
        recyclerView = (RecyclerView)v.findViewById(R.id.recyclerViewlistPenduduk);

        searchViewListPenduduk = (SearchView)v.findViewById(R.id.searchViewListPenduduk);
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
    private void populateInitialData(){
        realm.executeTransactionAsync(realm1 -> {
            listpenduduk = realm1.copyFromRealm(realm1.where(PendudukRealm.class).findAll().sort("namaDepan", Sort.ASCENDING));
        }, () -> {
            if (!listpenduduk.isEmpty()) {
                pendudukAdapter = new FragmentPendudukAdapter(getActivity().getApplicationContext(), listpenduduk,this);
                scaleInAnimationAdapter = new ScaleInAnimationAdapter(pendudukAdapter);
                recyclerView.setAdapter(scaleInAnimationAdapter);
                recyclerView.setLayoutManager(linearLayoutManager);
                updateLayout(LAYOUT_SUCCESS);
            }else {
                updateLayout(LAYOUT_EMPTY);
            }
        });
    }
    private void setSearchFunction() {
        searchViewListPenduduk.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                List<PendudukRealm> filteredList = filter(newText);
                pendudukAdapter.animateTo(filteredList);
                recyclerView.scrollToPosition(0);

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

    @Override
    public void OnClickPenduduk(int idPenduduk, String nama) {
        /*TambahPendudukActivity callingActivity = (TambahPendudukActivity)getActivity();

        callingActivity.onUserSelectValue(ket,idPenduduk,nama);
        dismiss();*/
    }
}
