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

import butterknife.BindView;
import butterknife.ButterKnife;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.LahanRealm;

public class CRUKegiatanPembibitanFragment extends Fragment implements LahanContract.ViewController<LahanRealm>, LahanContract.View{

    @BindView(R.id.input_nik)
    EditText input_nik;

    @BindView(R.id.btnKomoditas)
    Button btnKomoditas;

    @BindView(R.id.input_tanggalmasuk)
    EditText input_tanggalmasuk;

    @BindView(R.id.input_tanggalkeluar)
    EditText input_tanggalkeluar;

    @BindView(R.id.input_masakegiatan)
    EditText input_masakegiatan;

    @BindView(R.id.input_jumlah)
    EditText input_jumlah;

    @BindView(R.id.input_sumber)
    EditText input_sumber;
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

        View v = inflater.inflate(R.layout.fragment_crukegiatanpembibitan, container, false);
        ButterKnife.bind(this, v);

        return v;
    }

    @Override
    public LahanRealm getUIData() {
        String strNIK = input_nik.getText().toString();
        String strTanggalMasuk = input_tanggalmasuk.getText().toString();
        String strTanggalKeluar = input_tanggalkeluar.getText().toString();
        String strMasaKegiatan = input_masakegiatan.getText().toString();
        String strJumlah = input_jumlah.getText().toString();
        String strSumber = input_sumber.getText().toString();

        LahanRealm uiItem = new LahanRealm();
        return null;
    }

    @Override
    public void setUIData() {

    }

    @Override
    public void saveData(String tipe, Parcelable itemData) {
        LahanContract.Controller<LahanRealm> mController = new LahanController(this,appComponent);
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
