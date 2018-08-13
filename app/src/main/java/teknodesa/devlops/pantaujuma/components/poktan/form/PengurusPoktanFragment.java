package teknodesa.devlops.pantaujuma.components.poktan.form;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.CRUActivity;
import teknodesa.devlops.pantaujuma.components.poktan.PoktanContract;
import teknodesa.devlops.pantaujuma.components.searchpetani.SearchPetaniFragment;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.poktan.PengurusPoktan;

public class PengurusPoktanFragment extends Fragment implements PoktanContract.ViewController<PengurusPoktan>, SearchPetaniFragment.OnClickPetaniListener{

    @BindView(R.id.input_nikpengurus)
    EditText input_nikpengurus;

    @BindView(R.id.btnPetaniPengurus)
    Button btnPetaniPengurus;
    @OnClick(R.id.btnPetaniPengurus)
    void clickPilihPetani() {
        SearchPetaniFragment.newInstance(this).show(getActivity().getFragmentManager(), "");
    }

    @BindView(R.id.input_namadepanpengurus)
    EditText input_namadepanpengurus;

    @BindView(R.id.input_namabelakangpengurus)
    EditText input_namabelakangpengurus;

    @BindView(R.id.input_jabatan)
    EditText input_jabatan;

    @BindView(R.id.input_periode)
    EditText input_periode;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MainApplication) getActivity().getApplication())
                .getComponent()
                .inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_crupenguruspoktan, container, false);
        ButterKnife.bind(this, v);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        input_nikpengurus = getActivity().findViewById(R.id.input_nikpengurus);
        input_namadepanpengurus = getActivity().findViewById(R.id.input_namadepanpengurus);
        input_namabelakangpengurus = getActivity().findViewById(R.id.input_namabelakangpengurus);
        input_jabatan = getActivity().findViewById(R.id.input_jabatan);
        input_periode = getActivity().findViewById(R.id.input_periode);
    }

    @Override
    public PengurusPoktan getUIData() {
        String strJabatan = "";
        String strPeriode = "";
        String nik = "";
        String status = "aktif";

        try {
            strJabatan = (input_jabatan.getText().toString() == null) ? "-" : input_jabatan.getText().toString();
            strPeriode = (input_periode.getText().toString() == null) ? "-" : input_periode.getText().toString();
            nik = (input_nikpengurus.getText().toString() == null) ? "-" : input_nikpengurus.getText().toString();
        } catch (NullPointerException e){

        }

        PengurusPoktan newItem = new PengurusPoktan(nik, strJabatan, strPeriode, status);

        return newItem;
    }

    @Override
    public void setUIData() {
        PengurusPoktan theUIData = (PengurusPoktan) CRUActivity.mData;

        input_jabatan.setText(theUIData.getJabatan()+ "");
        input_periode.setText(theUIData.getPeriode()+ "");
    }

    @Override
    public void saveData(String tipe, Parcelable itemData) {
        //not implemented yet
    }

    @Override
    public void OnClickPetani(String idPenduduk, String namaDepan, String namaBelakang, String nik) {
        input_nikpengurus.setText(nik);
        input_namadepanpengurus.setText(namaDepan);
        input_namabelakangpengurus.setText(namaBelakang);
    }
}