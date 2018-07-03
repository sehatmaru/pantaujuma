package teknodesa.devlops.pantaujuma.components.rdkk;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import butterknife.BindView;
import butterknife.ButterKnife;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.lahan.LahanContract;
import teknodesa.devlops.pantaujuma.components.lahan.LahanController;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.lahan.LahanRealm;

public class CRURDKKPupukSubsidiFragment extends Fragment implements LahanContract.ViewController<LahanRealm>, LahanContract.View{

    @BindView(R.id.input_poktan)
    Spinner input_poktan;

    @BindView(R.id.btnPoktan)
    Button btnPoktan;

    /*@BindView(R.id.input_lahan)
    EditText input_Lahan;*/

    @BindView(R.id.btnLahan)
    Button btnLahan;

    @BindView(R.id.input_komoditas)
    EditText input_komoditas;

    @BindView(R.id.btnKomoditas)
    Button btnKomoditas;

    @BindView(R.id.input_pupuk)
    EditText input_pupuk;

    @BindView(R.id.btnPupuk)
    Button btnPupuk;

    @BindView(R.id.input_butuhjanuari)
    EditText input_butuhjanuari;

    @BindView(R.id.input_butuhfebruari)
    EditText input_butuhfebruari;

    @BindView(R.id.input_butuhmaret)
    EditText input_butuhmaret;

    @BindView(R.id.input_butuhapril)
    EditText input_butuhapril;

    @BindView(R.id.input_butuhmei)
    EditText input_butuhmei;

    @BindView(R.id.input_butuhjuni)
    EditText input_butuhjuni;

    @BindView(R.id.input_butuhjuli)
    EditText input_butuhjuli;

    @BindView(R.id.input_butuhagustus)
    EditText input_butuhagustus;

    @BindView(R.id.input_butuhseptember)
    EditText input_butuhseptember;

    @BindView(R.id.input_butuhoktober)
    EditText input_butuhoktober;

    @BindView(R.id.input_butuhnovember)
    EditText input_butuhnovember;

    @BindView(R.id.input_butuhdesember)
    EditText input_butuhdesember;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_crurdkkpupuksubsidi, container, false);
        ButterKnife.bind(this, v);

        return v;
    }

    @Override
    public LahanRealm getUIData() {
        /*String strNIK = input_nik.getText().toString();
        String strNamaDepan = input_namadepan.getText().toString();
        String strNamaBelakang = input_namabelakang.getText().toString();
        String strDeskripsi = input_deskripsi.getText().toString();
        String strStatus = input_status.getSelectedItem().toString();*/

        LahanRealm uiItem = new LahanRealm();
        return null;
    }

    @Override
    public void setUIData(Parcelable uiData) {

    }

    @Override
    public void saveData(String tipe, Parcelable itemData) {
        LahanContract.Controller<LahanRealm> mController = new LahanController(this);
        LahanRealm uiItem = getUIData();

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
