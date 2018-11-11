package teknodesa.devlops.pantaujuma.components.rdk.form;

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
import android.widget.Toast;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.CRUActivity;
import teknodesa.devlops.pantaujuma.components.rdk.DetailRDKActivity;
import teknodesa.devlops.pantaujuma.components.rdk.ListRDKActivity;
import teknodesa.devlops.pantaujuma.components.rdk.RDKContract;
import teknodesa.devlops.pantaujuma.components.searchkomoditas.SearchKomoditasFragment;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.rdk.RencanaUmum;

public class RDKRencanaUmumFragment extends Fragment implements RDKContract.ViewController<RencanaUmum>, RDKContract.View, SearchKomoditasFragment.OnClickKomoditasListener {

    @BindView(R.id.input_komoditas)
    EditText input_komoditas;

    @BindView(R.id.btnKomoditas)
    Button btnKomoditas;
    @OnClick(R.id.btnKomoditas)
    void clickPilihKomoditas() {
        SearchKomoditasFragment.newInstance(this).show(getActivity().getFragmentManager(), "");
    }

    @BindView(R.id.input_paketteknologi)
    EditText input_paketteknologi;

    @BindView(R.id.input_polatanam)
    EditText input_polatanam;

    @BindView(R.id.input_jadwaltanam)
    EditText input_jadwaltanam;
    public static boolean isOpen = false;
    @BindView(R.id.btnJadwalTanam)
    Button btnJadwalTanam;
    @OnClick(R.id.btnJadwalTanam)
    void setTanggal() {
        final Calendar calendar = Calendar.getInstance();
        int tanggal = calendar.get(Calendar.DAY_OF_MONTH),
                bulan = calendar.get(Calendar.MONTH),
                tahun = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), (view, year, month, dayOfMonth) -> {
            input_jadwaltanam.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
        }, tahun, bulan, tanggal);
        datePickerDialog.show();
    }

    @BindView(R.id.input_varietas)
    EditText input_varietas;

    @BindView(R.id.input_sumberbenih)
    EditText input_sumberbenih;

    @BindView(R.id.input_tabungananggota)
    EditText input_tabungananggota;

    @BindView(R.id.input_iurananggota)
    EditText input_iurananggota;

    @BindView(R.id.input_pemupukanmodal)
    EditText input_pemupukanmodal;

    String komoditas;

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

        View v = inflater.inflate(R.layout.fragment_crurdkrencanaumum, null);
        ButterKnife.bind(this, v);
        isOpen = true;
        if (CRUActivity.mAction == "update"){
            setLayoutForEdit();
            komoditas = DetailRDKActivity.idKomoditasRU;
        }
        return v;
    }

    public void setLayoutForEdit() {
        input_paketteknologi.setText(DetailRDKActivity.dataRDK.getPaketTeknologi());
        input_polatanam.setText(DetailRDKActivity.dataRDK.getPolaTanam());
        input_jadwaltanam.setText(DetailRDKActivity.dataRDK.getJadwalTanam());
        input_komoditas.setText(DetailRDKActivity.dataKomoditasRU.getNama());
        input_varietas.setText(DetailRDKActivity.dataRDK.getVarietas());
        input_sumberbenih.setText(DetailRDKActivity.dataRDK.getSumberBenih());
        input_tabungananggota.setText(DetailRDKActivity.dataRDK.getTabunganAnggota());
        input_iurananggota.setText(DetailRDKActivity.dataRDK.getIuranAnggota());
        input_pemupukanmodal.setText(DetailRDKActivity.dataRDK.getPemupukanModal());
    }

    @Override
    public RencanaUmum getUIData() {
        String paketTeknologi = "";
        String polaTanam = "";
        String jadwalTanam = "";
        String varietas = "";
        String iuranAnggota = "";
        String sumberBenih = "";
        String tabunganAnggota = "";
        String pemupukanModal = "";
        String strKomoditas = "";

        try{
            paketTeknologi = (input_paketteknologi.getText().toString() == null) ? "-" : input_paketteknologi.getText().toString();
            polaTanam = (input_polatanam.getText().toString() == null) ? "-" : input_polatanam.getText().toString();
            jadwalTanam = (input_jadwaltanam.getText().toString() == null) ? "-" : input_jadwaltanam.getText().toString();
            varietas = (input_varietas.getText().toString() == null) ? "-" : input_varietas.getText().toString();
            iuranAnggota = (input_iurananggota.getText().toString() == null) ? "-" : input_iurananggota.getText().toString();
            sumberBenih = (input_sumberbenih.getText().toString() == null) ? "-" : input_sumberbenih.getText().toString();
            tabunganAnggota = (input_tabungananggota.getText().toString() == null) ? "-" : input_tabungananggota.getText().toString();
            pemupukanModal = (input_pemupukanmodal.getText().toString() == null) ? "-" : input_pemupukanmodal.getText().toString();
            strKomoditas = (komoditas == null) ? "-" : komoditas;
        }catch (NullPointerException e){}

        RencanaUmum newItem = new RencanaUmum(paketTeknologi, polaTanam, jadwalTanam, strKomoditas, varietas,
                sumberBenih, tabunganAnggota, iuranAnggota, pemupukanModal);

        return newItem;
    }

    @Override
    public void setUIData() {
        RencanaUmum theUIData = (RencanaUmum) CRUActivity.mData;
        input_paketteknologi.setText(theUIData.getPaketTeknologi()+ "");
        input_polatanam.setText(theUIData.getPolaTanam()+ "");
        input_jadwaltanam.setText(theUIData.getJadwalTanam()+ "");
        input_komoditas.setText(theUIData.getKomoditasRU()+ "");
        input_varietas.setText(theUIData.getVarietas()+ "");
        input_sumberbenih.setText(theUIData.getSumberBenih()+ "");
        input_tabungananggota.setText(theUIData.getTabunganAnggota()+ "");
        input_iurananggota.setText(theUIData.getIuranAnggota()+ "");
        input_pemupukanmodal.setText(theUIData.getPemupukanModal()+ "");
    }

    @Override
    public void saveData(String tipe, Parcelable itemData) {
        //not implemented yet
    }

    @Override
    public void showNotification(String title, String header, String message) {
        Toast.makeText(CRUActivity.mContext, message, Toast.LENGTH_SHORT).show();
        startActivity(ListRDKActivity.createIntent(CRUActivity.mContext));
    }

    @Override
    public void OnClickKomoditas(String idKomoditas, String nama, String deskripsi) {
        input_komoditas.setText(nama);
        komoditas = idKomoditas;
    }
}
