package teknodesa.devlops.pantaujuma.components.petani;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import butterknife.BindView;
import butterknife.ButterKnife;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.lahan.LahanContract;
import teknodesa.devlops.pantaujuma.components.lahan.LahanController;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.lahan.LahanRealm;

public class CRUPoktanFragment extends Fragment implements LahanContract.ViewController<LahanRealm>, LahanContract.View{

    @BindView(R.id.input_nama)
    EditText input_nama;

    @BindView(R.id.input_desa)
    EditText input_desa;

    @BindView(R.id.input_kecamatan)
    EditText input_kecamatan;

    @BindView(R.id.input_tanggaldidirikan)
    EditText input_tanggaldidirikan;

    @BindView(R.id.input_alamat)
    EditText input_alamat;

    @BindView(R.id.input_nohp)
    EditText input_nohp;

    @BindView(R.id.input_notelp)
    EditText input_notelp;

    @BindView(R.id.input_deskripsi)
    EditText input_deskripsi;

    @BindView(R.id.input_status)
    EditText input_status;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_crupoktan, container, false);
        ButterKnife.bind(this, v);

        return v;
    }

    @Override
    public LahanRealm getUIData() {
        String strNama = input_nama.getText().toString();
        String strDesa = input_desa.getText().toString();
        String strKecamatan = input_kecamatan.getText().toString();
        String strTanggalDidirikan = input_tanggaldidirikan.getText().toString();
        String strAlamat = input_alamat.getText().toString();
        String strNoHp = input_nohp.getText().toString();
        String strNoTelp = input_notelp.getText().toString();
        String strDeskripsi = input_deskripsi.getText().toString();
        String strStatus = input_status.getText().toString();

        LahanRealm uiItem = new LahanRealm();
        return null;
    }

    @Override
    public void saveData(String tipe) {
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
