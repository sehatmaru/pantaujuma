package teknodesa.devlops.pantaujuma.components.lahan.formlahan;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.CRUActivity;
import teknodesa.devlops.pantaujuma.components.lahan.DetailLahanActivity;
import teknodesa.devlops.pantaujuma.components.lahan.LahanContract;
import teknodesa.devlops.pantaujuma.components.searchpenduduk.SearchPendudukFragment;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.lahan.LahanModel;

/**
 * Created by Marthin on 11/11/2018.
 */

public class CRUDataLahanFragment extends Fragment implements LahanContract.ViewController<LahanModel>,
        SearchPendudukFragment.OnClickPendudukListener {


    @BindView(R.id.btnPenduduk)
    Button btnPenduduk;
    @OnClick(R.id.btnPenduduk)
    void clickPilihPenduduk() {
        SearchPendudukFragment.newInstance(this).show(getActivity().getFragmentManager(), "");
    }
    @BindView(R.id.inputNamaPemilik)
    EditText inputNamaPemilik;

    @BindView(R.id.input_namaLahan)
    EditText input_namaLahan;

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

    private String pemilik = "";
    private String namaPemilikLahan = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_cru_data_lahan, container, false);
        ButterKnife.bind(this, v);
        if(CRUActivity.mAction.equals("update")){
            setUIData();
        }
        return v;
    }

    @Override
    public LahanModel getUIData() {
        String strNamaPemilik = inputNamaPemilik.getText().toString();
        String strLuas = input_luas.getText().toString();
        String strBatasTimur = input_batastimur.getText().toString();
        String strBatasBarat = input_batasbarat.getText().toString();
        String strBatasSelatan = input_batasselatan.getText().toString();
        String strBatasUtara = input_batasutara.getText().toString();
        String strDeskripsi = input_deskripsi.getText().toString();
        LahanModel uiItem = new LahanModel(pemilik,strNamaPemilik,strLuas,strBatasTimur,strBatasBarat,strBatasSelatan,strBatasUtara,
                strDeskripsi);
        return uiItem;
    }

    @Override
    public void setUIData() {
        pemilik = DetailLahanActivity.dataLahan.getPemilik();
        namaPemilikLahan = DetailLahanActivity.dataLahan.getNamaPemilikLahan();
        inputNamaPemilik.setText(DetailLahanActivity.dataLahan.getNamaPemilikLahan());
        input_luas.setText(DetailLahanActivity.dataLahan.getLuas());
        input_batastimur.setText(DetailLahanActivity.dataLahan.getBatasTimur());
        input_batasbarat.setText(DetailLahanActivity.dataLahan.getBatasBarat());
        input_batasselatan.setText(DetailLahanActivity.dataLahan.getBatasSelatan());
        input_batasutara.setText(DetailLahanActivity.dataLahan.getBatasUtara());
        input_deskripsi.setText(DetailLahanActivity.dataLahan.getDeskripsi());
    }

    @Override
    public void saveData(String tipe, Parcelable itemData) {

    }

    @Override
    public void OnClickPenduduk(String idPenduduk, String namaDepan, String namaBelakang, String nik) {
        String namaLengkap = namaDepan+" "+namaBelakang;
        pemilik =idPenduduk;
        namaPemilikLahan = namaLengkap;
        inputNamaPemilik.setText(namaLengkap);
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
