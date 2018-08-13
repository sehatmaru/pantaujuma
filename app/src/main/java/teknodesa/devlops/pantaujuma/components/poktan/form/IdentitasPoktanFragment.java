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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.CRUActivity;
import teknodesa.devlops.pantaujuma.components.poktan.PoktanContract;
import teknodesa.devlops.pantaujuma.components.profile.AkunFragment;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.poktan.IdentitasPoktan;

public class IdentitasPoktanFragment extends Fragment implements PoktanContract.ViewController<IdentitasPoktan>{

    @BindView(R.id.input_nama)
    EditText input_namapoktan;

    @BindView(R.id.input_desa)
    EditText input_desa;

    @BindView(R.id.input_kecamatan)
    EditText input_kecamatan;

    @BindView(R.id.input_tanggaldidirikan)
    EditText input_tanggaldidirikan;

    @BindView(R.id.btnTanggalDidirikan)
    Button btnTanggalDidirikan;
    @OnClick(R.id.btnTanggalDidirikan)
    void setTanggal() {
        final Calendar calendar = Calendar.getInstance();
        int tanggal = calendar.get(Calendar.DAY_OF_MONTH),
                bulan = calendar.get(Calendar.MONTH),
                tahun = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), (view, year, month, dayOfMonth) -> {
            input_tanggaldidirikan.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
        }, tahun, bulan, tanggal);
        datePickerDialog.show();
    }

    @BindView(R.id.input_alamat)
    EditText input_alamat;

    @BindView(R.id.input_deskripsi)
    EditText input_deskripsi;

    @BindView(R.id.input_hp)
    EditText input_hp;

    @BindView(R.id.input_telp)
    EditText input_telp;

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

        View v = inflater.inflate(R.layout.fragment_cruidentitaspoktan, container, false);
        ButterKnife.bind(this, v);

        setData();

        return v;
    }

    private void setData(){
        input_desa.setText(AkunFragment.desaUser);
        input_kecamatan.setText(AkunFragment.kecamatanUser);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        input_desa = getActivity().findViewById(R.id.input_desa);
        input_kecamatan = getActivity().findViewById(R.id.input_kecamatan);
        input_tanggaldidirikan= getActivity().findViewById(R.id.input_tanggaldidirikan);
        input_alamat = getActivity().findViewById(R.id.input_alamat);
        input_deskripsi= getActivity().findViewById(R.id.input_deskripsi);
        input_hp= getActivity().findViewById(R.id.input_hp);
        input_telp= getActivity().findViewById(R.id.input_telp);

        setData();
    }

    @Override
    public IdentitasPoktan getUIData() {
        String strAlamat = (input_alamat.getText().toString() == null) ? "-" : input_alamat.getText().toString();
        String strTanggalDidirikan = (input_tanggaldidirikan.getText().toString() == null) ? "-" : input_tanggaldidirikan.getText().toString();
        String strDeskripsi = (input_deskripsi.getText().toString() == null) ? "-" : input_deskripsi.getText().toString();
        String strNamaPoktan = (input_namapoktan.getText().toString() == null) ? "-" : input_namapoktan.getText().toString();
        String strDesa = (input_desa.getText().toString() == null) ? "-" : input_desa.getText().toString();
        String strKecamatan = (input_kecamatan.getText().toString() == null) ? "-" : input_kecamatan.getText().toString();
        String strNoHP = (input_hp.getText().toString() == null) ? "-" : input_hp.getText().toString();
        String strNoTelp = (input_telp.getText().toString() == null) ? "-" : input_telp.getText().toString();
        String strStatus = "aktif";

        IdentitasPoktan newItem = new IdentitasPoktan(strNamaPoktan, strDesa, strKecamatan, strTanggalDidirikan, strAlamat, strNoHP, strNoTelp, strDeskripsi, strStatus);

        return newItem;
    }

    @Override
    public void setUIData() {
        IdentitasPoktan theUIData = (IdentitasPoktan) CRUActivity.mData;
        input_alamat.setText(theUIData.getAlamat()+ "");
        input_namapoktan.setText(theUIData.getNama()+ "");
        input_tanggaldidirikan.setText(theUIData.getTanggalDidirikan()+ "");
        input_deskripsi.setText(theUIData.getDeskripsi()+ "");
        input_desa.setText(theUIData.getDesa()+ "");
        input_kecamatan.setText(theUIData.getKecamatan()+ "");
        input_hp.setText(theUIData.getNoHp()+ "");
        input_telp.setText(theUIData.getNoTelp()+ "");
    }

    @Override
    public void saveData(String tipe, Parcelable itemData) {
        //not implemented yet
    }
}