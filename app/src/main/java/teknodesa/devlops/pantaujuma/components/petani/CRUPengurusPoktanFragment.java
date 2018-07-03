package teknodesa.devlops.pantaujuma.components.petani;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.petani.PetaniRealm;

public class CRUPengurusPoktanFragment extends Fragment implements PetaniContract.ViewController<PetaniRealm>, PetaniContract.View{

    @BindView(R.id.input_nik)
    EditText input_nik;

    @BindView(R.id.btnPetani)
    Button btnPetani;

    @BindView(R.id.input_namadepan)
    EditText input_namadepan;

    @BindView(R.id.input_namabelakang)
    EditText input_namabelakang;

    @BindView(R.id.input_jabatan)
    EditText input_jabatan;

    @BindView(R.id.input_periode)
    EditText input_periode;

    @BindView(R.id.input_status)
    EditText input_status;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_crupenguruspoktan, container, false);
        ButterKnife.bind(this, v);

        return v;
    }

    @Override
    public PetaniRealm getUIData() {
        String strNIK = input_nik.getText().toString();
        String strNamaDepan = input_namadepan.getText().toString();
        String strNamaBelakang = input_namabelakang.getText().toString();
        String strJabatan = input_jabatan.getText().toString();
        String strPeriode = input_periode.getText().toString();
        String strStatus = input_status.getText().toString();

        PetaniRealm uiItem = new PetaniRealm();
        return null;
    }

    @Override
    public void setUIData() {

    }

    @Override
    public void saveData(String tipe, Parcelable itemData) {
        PetaniContract.Controller<PetaniRealm> mController = new PetaniController(this);
        PetaniRealm uiItem = getUIData();

        if(tipe.equals("insert")){
            mController.addItem(uiItem);
        }else{
            if(tipe.equals("update")){
                //TODO: implement this
            }
        }
    }

    @Override
    public void showNotification(String title, String header, String message) {
        //TODO: implement this
    }
}