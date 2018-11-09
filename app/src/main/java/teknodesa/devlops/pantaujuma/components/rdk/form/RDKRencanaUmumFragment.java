package teknodesa.devlops.pantaujuma.components.rdk.form;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
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
import teknodesa.devlops.pantaujuma.components.rdk.DetailRDKActivity;
import teknodesa.devlops.pantaujuma.components.rdk.RDKContract;
import teknodesa.devlops.pantaujuma.components.searchkomoditas.SearchKomoditasFragment;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.rdk.RencanaUmum;

public class RDKRencanaUmumFragment extends Fragment implements RDKContract.ViewController<RencanaUmum>, SearchKomoditasFragment.OnClickKomoditasListener {
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
        setData();
        return v;
    }

    private void setData(){

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        input_paketteknologi = getActivity().findViewById(R.id.input_paketteknologi);
        input_polatanam= getActivity().findViewById(R.id.input_polatanam);
        input_jadwaltanam = getActivity().findViewById(R.id.input_jadwaltanam);
        input_komoditas = getActivity().findViewById(R.id.input_komoditas);
        input_varietas = getActivity().findViewById(R.id.input_varietas);
        input_sumberbenih= getActivity().findViewById(R.id.input_sumberbenih);
        input_tabungananggota = getActivity().findViewById(R.id.input_tabungananggota);
        input_iurananggota= getActivity().findViewById(R.id.input_iurananggota);
        input_pemupukanmodal = getActivity().findViewById(R.id.input_pemupukanmodal);

        if (CRUActivity.mAction == "update"){
            setLayoutForEdit();
        } else {
            setData();
        }

    }

    private void setLayoutForEdit() {
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
        String paketTeknologi = (input_paketteknologi.getText().toString() == null) ? "-" : input_paketteknologi.getText().toString();;
        String polaTanam = (input_polatanam.getText().toString() == null) ? "-" : input_polatanam.getText().toString();;
        String jadwalTanam = (input_jadwaltanam.getText().toString() == null) ? "-" : input_jadwaltanam.getText().toString();;
        String varietas = (input_varietas.getText().toString() == null) ? "-" : input_varietas.getText().toString();;
        String iuranAnggota = (input_iurananggota.getText().toString() == null) ? "-" : input_iurananggota.getText().toString();;
        String sumberBenih = (input_sumberbenih.getText().toString() == null) ? "-" : input_sumberbenih.getText().toString();;
        String tabunganAnggota = (input_tabungananggota.getText().toString() == null) ? "-" : input_tabungananggota.getText().toString();;
        String pemupukanModal = (input_pemupukanmodal.getText().toString() == null) ? "-" : input_pemupukanmodal.getText().toString();;

//        paketTeknologi = (input_paketteknologi.getText().toString() == null) ? "-" : input_paketteknologi.getText().toString();
//        polaTanam = (input_polatanam.getText().toString() == null) ? "-" : input_polatanam.getText().toString();
//        jadwalTanam = (input_jadwaltanam.getText().toString() == null) ? "-" : input_jadwaltanam.getText().toString();
//        iuranAnggota = (input_iurananggota.getText().toString() == null) ? "-" : input_iurananggota.getText().toString();
//        sumberBenih = (input_sumberbenih.getText().toString() == null) ? "-" : input_sumberbenih.getText().toString();
//        tabunganAnggota = (input_tabungananggota.getText().toString() == null) ? "-" : input_tabungananggota.getText().toString();
//        pemupukanModal = (input_pemupukanmodal.getText().toString() == null) ? "-" : input_pemupukanmodal.getText().toString();
//        varietas = (input_varietas.getText().toString() == null) ? "-" : input_varietas.getText().toString();
//
////        String strKomoditas = "";
//
//        try{
//            paketTeknologi = (input_paketteknologi.getText().toString() == null) ? "-" : input_paketteknologi.getText().toString();
//            polaTanam = (input_polatanam.getText().toString() == null) ? "-" : input_polatanam.getText().toString();
//            jadwalTanam = (input_jadwaltanam.getText().toString() == null) ? "-" : input_jadwaltanam.getText().toString();
//            varietas = (input_varietas.getText().toString() == null) ? "-" : input_varietas.getText().toString();
//            iuranAnggota = (input_iurananggota.getText().toString() == null) ? "-" : input_iurananggota.getText().toString();
//            sumberBenih = (input_sumberbenih.getText().toString() == null) ? "-" : input_sumberbenih.getText().toString();
//            tabunganAnggota = (input_tabungananggota.getText().toString() == null) ? "-" : input_tabungananggota.getText().toString();
//            pemupukanModal = (input_pemupukanmodal.getText().toString() == null) ? "-" : input_pemupukanmodal.getText().toString();
////            strKomoditas = (komoditas == null) ? "-" : komoditas;
//        }catch (NullPointerException e){}


        RencanaUmum newItem = new RencanaUmum();

        newItem.setPaketTeknologi(paketTeknologi);
        newItem.setPolaTanam(polaTanam);
        newItem.setJadwalTanam(jadwalTanam);
        newItem.setKomoditasRU(komoditas);
        newItem.setVarietas(varietas);
        newItem.setSumberBenih(sumberBenih);
        newItem.setTabunganAnggota(tabunganAnggota);
        newItem.setIuranAnggota(iuranAnggota);
        newItem.setPemupukanModal(pemupukanModal);

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
    public void OnClickKomoditas(String idKomoditas, String nama, String deskripsi) {
        input_komoditas.setText(nama);
        komoditas = idKomoditas;
    }
}
