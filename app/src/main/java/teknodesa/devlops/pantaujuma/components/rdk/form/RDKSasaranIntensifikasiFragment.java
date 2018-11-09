package teknodesa.devlops.pantaujuma.components.rdk.form;

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
import teknodesa.devlops.pantaujuma.components.rdk.DetailRDKActivity;
import teknodesa.devlops.pantaujuma.components.rdk.RDKContract;
import teknodesa.devlops.pantaujuma.components.searchkomoditas.SearchKomoditasFragment;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.rdk.SasaranIntensifikasi;

public class RDKSasaranIntensifikasiFragment extends Fragment implements RDKContract.ViewController<SasaranIntensifikasi>, SearchKomoditasFragment.OnClickKomoditasListener {
    @BindView(R.id.input_komoditasSI)
    EditText input_komoditasSI;

    @BindView(R.id.btnKomoditas)
    Button btnKomoditas;
    @OnClick(R.id.btnKomoditas)
    void clickPilihKomoditas() {
        SearchKomoditasFragment.newInstance(this).show(getActivity().getFragmentManager(), "");
    }

    @BindView(R.id.input_target)
    EditText input_target;

    @BindView(R.id.input_targethasilperha)
    EditText input_targethasilperha;

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

        View v = inflater.inflate(R.layout.fragment_crurdksaranaintensifikasi, null);
        ButterKnife.bind(this, v);
        setData();
        return v;
    }

    private void setData(){
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        input_komoditasSI = getActivity().findViewById(R.id.input_komoditasSI);
        input_target = getActivity().findViewById(R.id.input_target);
        input_targethasilperha= getActivity().findViewById(R.id.input_targethasilperha);

        if (CRUActivity.mAction == "update"){
            setLayoutForEdit();
        } else {
            setData();
        }
    }

    private void setLayoutForEdit() {
        input_komoditasSI.setText(DetailRDKActivity.dataKomoditasSI.getNama());
        input_target.setText(DetailRDKActivity.dataRDK.getTarget());
        input_targethasilperha.setText(DetailRDKActivity.dataRDK.getTargetHasilPerHa());
    }

    @Override
    public SasaranIntensifikasi getUIData() {
        String target = input_target.getText().toString();
        String targetHasil = input_targethasilperha.getText().toString();
//        String strKomoditas = "";
//
//        try{
//            target = (input_target.getText().toString() == null) ? "-" : input_target.getText().toString();
//            targetHasil = (input_targethasilperha.getText().toString() == null) ? "-" : input_targethasilperha.getText().toString();
//            strKomoditas = (komoditas == null) ? "-" : komoditas;
//        }catch (NullPointerException e){}

        SasaranIntensifikasi newItem = new SasaranIntensifikasi();

        newItem.setKomoditasSI(komoditas);
        newItem.setTarget(target);
        newItem.setTargetHasilPerHa(targetHasil);

        return newItem;
    }

    @Override
    public void setUIData() {
        SasaranIntensifikasi theUIData = (SasaranIntensifikasi) CRUActivity.mData;
        input_komoditasSI.setText(theUIData.getKomoditasSI()+ "");
        input_target.setText(theUIData.getTarget()+ "");
        input_targethasilperha.setText(theUIData.getTargetHasilPerHa()+ "");
    }

    @Override
    public void saveData(String tipe, Parcelable itemData) {
        //not implemented yet
    }

    @Override
    public void OnClickKomoditas(String idKomoditas, String nama, String deskripsi) {
        input_komoditasSI.setText(nama);
        komoditas = idKomoditas;
    }

}
