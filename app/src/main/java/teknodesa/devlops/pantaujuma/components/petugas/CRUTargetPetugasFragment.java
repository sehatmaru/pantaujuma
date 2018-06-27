package teknodesa.devlops.pantaujuma.components.petugas;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.lahan.LahanContract;
import teknodesa.devlops.pantaujuma.components.lahan.LahanController;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.lahan.LahanRealm;

public class CRUTargetPetugasFragment extends Fragment implements LahanContract.ViewController<LahanRealm>, LahanContract.View{

    @BindView(R.id.input_komoditas)
    EditText input_komoditas;

    @BindView(R.id.btnKomoditas)
    Button btnKomoditas;

    @BindView(R.id.input_tahun)
    EditText input_tahun;

    @BindView(R.id.input_luastanam)
    EditText input_luastanam;

    @BindView(R.id.input_luaspanen)
    EditText input_luaspanen;

    @BindView(R.id.input_sasaranproduksi)
    EditText input_sasaranproduksi;

    @BindView(R.id.input_sasaranproduktifitas)
    EditText input_sasaranproduktifitas;

    @BindView(R.id.input_keterangan)
    EditText input_keterangan;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_crutargetpetugas, container, false);
        ButterKnife.bind(this, v);

        return v;
    }

    @Override
    public LahanRealm getUIData() {
        String strKomoditas = input_komoditas.getText().toString();
        String strTahun = input_tahun.getText().toString();
        String strLuasTanam = input_luastanam.getText().toString();
        String strLuasPanen = input_luaspanen.getText().toString();
        String strSasaranProduksi = input_sasaranproduksi.getText().toString();
        String strSasaranProduktifitas = input_sasaranproduktifitas.getText().toString();
        String strKeterangan = input_keterangan.getText().toString();

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