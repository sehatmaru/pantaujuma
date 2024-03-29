package teknodesa.devlops.pantaujuma.components.rdk.form;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

    public static boolean isOpen = false;
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
        isOpen = true;
        if (CRUActivity.mAction == "update"){
            setLayoutForEdit();
        }
        return v;
    }

    public void setLayoutForEdit() {
        input_nama.setText(DetailRDKActivity.dataRDK.getNama());
        input_deskripsiIrigasi.setText(DetailRDKActivity.dataRDK.getDeskripsiIrigasi());
    }

    @Override
    public Irigasi getUIData() {
        String strNama = input_nama.getText().toString();
        String strDeskripsiIrigasi = input_deskripsiIrigasi.getText().toString();

        Irigasi newItem = new Irigasi();

        if(strNama == null || strNama.compareTo("")==0){
            newItem.setNama("");
        }else{
            newItem.setNama(strNama);
        }

        if(strDeskripsiIrigasi == null || strDeskripsiIrigasi.compareTo("")==0){
            newItem.setDeskripsiIrigasi("");
        }else{
            newItem.setDeskripsiIrigasi(strDeskripsiIrigasi);
        }

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
