package teknodesa.devlops.pantaujuma.components.rdk.form;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.CRUActivity;
import teknodesa.devlops.pantaujuma.components.rdk.DetailRDKActivity;
import teknodesa.devlops.pantaujuma.components.rdk.RDKContract;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.rdk.Irigasi;

public class RDKIrigasiFragment extends Fragment implements RDKContract.ViewController<Irigasi> {
    @BindView(R.id.input_nama)
    EditText input_nama;

    @BindView(R.id.input_deskripsiIrigasi)
    EditText input_deskripsiIrigasi;

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

        View v = inflater.inflate(R.layout.fragment_crurdkirigasi, null);
        ButterKnife.bind(this, v);
        setData();
        return v;
    }

    private void setData(){
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        input_nama = getActivity().findViewById(R.id.input_nama);
        input_deskripsiIrigasi= getActivity().findViewById(R.id.input_deskripsiIrigasi);

        if (CRUActivity.mAction == "update"){
            setLayoutForEdit();
        } else {
            setData();
        }
    }

    private void setLayoutForEdit() {
        input_nama.setText(DetailRDKActivity.dataRDK.getNama());
        input_deskripsiIrigasi.setText(DetailRDKActivity.dataRDK.getDeskripsiIrigasi());
    }

    @Override
    public Irigasi getUIData() {
        String strNama = (input_nama.getText().toString() == null) ? "-" : input_nama.getText().toString();
        String strDeskripsiIrigasi = (input_deskripsiIrigasi.getText().toString() == null) ? "-" : input_deskripsiIrigasi.getText().toString();

        try{
            strNama = (input_nama.getText().toString() == null) ? "-" : input_nama.getText().toString();
            strDeskripsiIrigasi = (input_deskripsiIrigasi.getText().toString() == null) ? "-" : input_deskripsiIrigasi.getText().toString();
        }catch (NullPointerException e){}

        Irigasi newItem = new Irigasi();
        newItem.setNama(strNama);
        newItem.setDeskripsiIrigasi(strDeskripsiIrigasi);

        return newItem;
    }

    @Override
    public void setUIData() {
        Irigasi theUIData = (Irigasi) CRUActivity.mData;
        input_nama.setText(theUIData.getNama()+ "");
        input_deskripsiIrigasi.setText(theUIData.getDeskripsiIrigasi()+ "");
    }

    @Override
    public void saveData(String tipe, Parcelable itemData) {
        //not implemented yet
    }
}
