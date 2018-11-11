package teknodesa.devlops.pantaujuma.components.lahan;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.lahan.LahanModel;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.lahan.LahanRealm;

public class DetailLahanFragment extends Fragment  implements LahanContract.ViewController<LahanModel>, LahanContract.View{
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

    @BindView(R.id.alamat)
    EditText alamat;
    private AppComponent appComponent;
    FragmentActivity activity;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();

        appComponent = ((MainApplication) getActivity().getApplication()).getComponent();
        appComponent.inject(this);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_detaillahan, container, false);
        ButterKnife.bind(this, v);

        return v;
    }

    @Override
    public LahanModel getUIData() {
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
        String salamat = alamat.getText().toString();

        LahanRealm uiItem = new LahanRealm();
        return null;
    }

    @Override
    public void setUIData() {

    }

    @Override
    public void saveData(String tipe, Parcelable itemData) {
        LahanContract.Controller<LahanRealm> mController = new LahanController(this,appComponent);
        LahanRealm uiItem = null;

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

    protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        return timeStamp+""+salt.toString();
    }
}
