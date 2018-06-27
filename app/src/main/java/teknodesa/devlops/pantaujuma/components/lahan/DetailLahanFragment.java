package teknodesa.devlops.pantaujuma.components.lahan;

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
import teknodesa.devlops.pantaujuma.dependencies.models.realms.lahan.LahanRealm;

public class DetailLahanFragment extends Fragment  implements LahanContract.ViewController<LahanRealm>, LahanContract.View{
    @BindView(R.id.input_nik)
    EditText input_nik;

    @BindView(R.id.btnPenduduk)
    Button btnPenduduk;

    @BindView(R.id.input_namadepan)
    EditText input_namadepan;

    @BindView(R.id.input_namabelakang)
    EditText input_namabelakang;

    @BindView(R.id.input_nama)
    EditText input_nama;

    @BindView(R.id.input_lintang)
    EditText input_lintang;

    @BindView(R.id.input_bujur)
    EditText input_bujur;

    @BindView(R.id.input_luas)
    EditText input_luas;

    @BindView(R.id.input_batastimur)
    EditText input_batastimur;

    @BindView(R.id.input_batasbarat)
    EditText input_batasbarat;

    @BindView(R.id.input_batasselatan)
    EditText input_batasselatan;

    @BindView(R.id.input_batasutara)
    EditText input_batasutara;

    @BindView(R.id.input_deskripsi)
    EditText input_deskripsi;

    @BindView(R.id.input_status)
    Spinner input_status;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_detaillahan, container, false);
        ButterKnife.bind(this, v);

        return v;
    }

    @Override
    public LahanRealm getUIData() {
        String strNIK = input_nik.getText().toString();
        String strNamaDepan = input_namadepan.getText().toString();
        String strNamaBelakang = input_namabelakang.getText().toString();
        String strNama = input_nama.getText().toString();
        String strLintang = input_lintang.getText().toString();
        String strBujur = input_bujur.getText().toString();
        String strLuas = input_luas.getText().toString();
        String strBatasTimur = input_batastimur.getText().toString();
        String strBatasBarat = input_batasbarat.getText().toString();
        String strBatasSelatan = input_batasselatan.getText().toString();
        String strBatasUtara = input_batasutara.getText().toString();
        String strDeskripsi = input_deskripsi.getText().toString();
        String strStatus = input_status.getSelectedItem().toString();

        LahanRealm uiItem = new LahanRealm();
        return null;
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
