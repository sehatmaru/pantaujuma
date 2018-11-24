package teknodesa.devlops.pantaujuma.components.rdk.form;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

    private String komoditas = "";
    private String messageError;
    public static boolean isOpen = false;
    public static boolean check;

    FragmentActivity activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
        ((MainApplication) getActivity().getApplication())
                .getComponent()
                .inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_crurdksaranaintensifikasi, null);
        ButterKnife.bind(this, v);
        isOpen = true;
        if (CRUActivity.mAction == "update"){
            setLayoutForEdit();
            komoditas = DetailRDKActivity.idKomoditasSI;
        }
        return v;
    }


    public void setLayoutForEdit() {
        input_komoditasSI.setText(DetailRDKActivity.dataKomoditasSI.getNama());
        input_target.setText(DetailRDKActivity.dataRDK.getTarget());
        input_targethasilperha.setText(DetailRDKActivity.dataRDK.getTargetHasilPerHa());
        Log.e("check point", "reached");
    }

    @Override
    public SasaranIntensifikasi getUIData() {
        String targetHasil = input_targethasilperha.getText().toString();
        String target = input_target.getText().toString();

        SasaranIntensifikasi newItem = new SasaranIntensifikasi();

        if(komoditas.compareTo("")==0 || komoditas == null){
            check = true;
            checkData();
        }else{
            newItem.setKomoditasSI(komoditas);
        }

        if(targetHasil == null || targetHasil.compareTo("")==0){
            newItem.setTargetHasilPerHa("");
        }else{
            newItem.setTargetHasilPerHa(targetHasil);
        }

        if(target == null || target.compareTo("")==0){
            newItem.setTarget("");
        }else{
            newItem.setTarget(target);
        }

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

    public void checkData(){

    }

    @Override
    public void OnClickKomoditas(String idKomoditas, String nama, String deskripsi) {
        input_komoditasSI.setText(nama);
        komoditas = idKomoditas;
    }

}
