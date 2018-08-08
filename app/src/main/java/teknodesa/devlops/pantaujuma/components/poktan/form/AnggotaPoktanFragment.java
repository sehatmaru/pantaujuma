package teknodesa.devlops.pantaujuma.components.poktan.form;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.CRUActivity;
import teknodesa.devlops.pantaujuma.components.poktan.PoktanContract;
import teknodesa.devlops.pantaujuma.components.searchpetani.SearchPetaniFragment;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.poktan.AnggotaPoktan;

public class AnggotaPoktanFragment extends Fragment implements PoktanContract.ViewController<AnggotaPoktan>, SearchPetaniFragment.OnClickPetaniListener{

    @Inject
    Realm realm;

    @BindView(R.id.input_nikanggota)
    EditText input_nikanggota;

    @BindView(R.id.btnPetaniAnggota)
    Button btnPetaniAnggota;
    @OnClick(R.id.btnPetaniAnggota)
    void clickPilihPetani() {
        SearchPetaniFragment.newInstance(this).show(getActivity().getFragmentManager(), "");
    }

    @BindView(R.id.input_namadepananggota)
    EditText input_namadepananggota;

    @BindView(R.id.input_namabelakanganggota)
    EditText input_namabelakanganggota;

    @BindView(R.id.input_tanggalmasuk)
    EditText input_tanggalmasuk;

    @BindView(R.id.btnTanggalMasuk)
    Button btnTanggalMasuk;
    @OnClick(R.id.btnTanggalMasuk)
    void setTanggal() {
        final Calendar calendar = Calendar.getInstance();
        int tanggal = calendar.get(Calendar.DAY_OF_MONTH),
                bulan = calendar.get(Calendar.MONTH),
                tahun = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), (view, year, month, dayOfMonth) -> {
            input_tanggalmasuk.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
        }, tahun, bulan, tanggal);
        datePickerDialog.show();
    }

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

        View v = inflater.inflate(R.layout.fragment_cruanggotapoktan, container, false);
        ButterKnife.bind(this, v);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        input_nikanggota = getActivity().findViewById(R.id.input_nikanggota);
        input_namadepananggota = getActivity().findViewById(R.id.input_namadepananggota);
        input_namabelakanganggota = getActivity().findViewById(R.id.input_namabelakanganggota);
        input_tanggalmasuk = getActivity().findViewById(R.id.input_tanggalmasuk);
    }

    @Override
    public AnggotaPoktan getUIData() {
        String strTanggalMasuk = (input_tanggalmasuk.getText().toString() == null) ? "-" : input_tanggalmasuk.getText().toString();
        String nik = (input_nikanggota.getText().toString() == null) ? "-" : input_nikanggota.getText().toString();

        AnggotaPoktan newItem = new AnggotaPoktan(nik, strTanggalMasuk);

        return newItem;
    }

    @Override
    public void setUIData() {
        AnggotaPoktan theUIData = (AnggotaPoktan) CRUActivity.mData;

        input_tanggalmasuk.setText(theUIData.getTanggalMasuk()+ "");
    }

    @Override
    public void saveData(String tipe, Parcelable itemData) {
        //not implemented yet
    }

    @Override
    public void OnClickPetani(String idPenduduk, String namaDepan, String namaBelakang, String nik) {
        input_nikanggota.setText(nik);
        input_namadepananggota.setText(namaDepan);
        input_namabelakanganggota.setText(namaBelakang);
    }
}