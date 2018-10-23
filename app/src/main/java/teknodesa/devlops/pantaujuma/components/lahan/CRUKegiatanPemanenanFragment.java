package teknodesa.devlops.pantaujuma.components.lahan;

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
import teknodesa.devlops.pantaujuma.dependencies.models.realms.lahan.LahanRealm;

public class CRUKegiatanPemanenanFragment extends Fragment implements LahanContract.ViewController<LahanRealm>, LahanContract.View {

    @BindView(R.id.input_komoditas)
    EditText input_komoditas;

    @BindView(R.id.btnKomoditas)
    Button btnKomoditas;

    @BindView(R.id.input_tanggalmasuk)
    EditText input_tanggalmasuk;

    @BindView(R.id.input_tanggalkeluar)
    EditText input_tanggalkeluar;

    @BindView(R.id.input_masakegiatan)
    EditText input_masakegiatan;

    @BindView(R.id.input_cara)
    EditText input_cara;

    @BindView(R.id.input_luas)
    EditText input_luas;

    @BindView(R.id.input_hasil)
    EditText input_hasil;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_crukegiatanpemanenan, container, false);
        ButterKnife.bind(this, v);

        return v;
    }

    @Override
    public LahanRealm getUIData() {
        String strKomoditas = input_komoditas.getText().toString();
        String strTanggalMasuk = input_tanggalmasuk.getText().toString();
        String strTanggalKeluar = input_tanggalkeluar.getText().toString();
        String strMasaKegiatan = input_masakegiatan.getText().toString();
        String strCara = input_cara.getText().toString();
        String strLuas = input_luas.getText().toString();
        String strHasil = input_hasil.getText().toString();

        LahanRealm uiItem = new LahanRealm();
        return null;
    }

    @Override
    public void setUIData() {

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
