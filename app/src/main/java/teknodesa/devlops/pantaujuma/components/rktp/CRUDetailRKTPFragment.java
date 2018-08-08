package teknodesa.devlops.pantaujuma.components.rktp;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.petani.PetaniContract;
import teknodesa.devlops.pantaujuma.components.petani.PetaniController;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.petani.PetaniRealm;

public class CRUDetailRKTPFragment extends Fragment implements PetaniContract.ViewController<PetaniRealm>, PetaniContract.View{

    @BindView(R.id.input_tujuan)
    EditText input_tujuan;

    @BindView(R.id.input_masalah)
    EditText input_masalah;

    @BindView(R.id.input_sasaran)
    EditText input_sasaran;

    @BindView(R.id.input_materi)
    EditText input_materi;

    @BindView(R.id.input_metode)
    EditText input_metode;

    @BindView(R.id.input_volume)
    EditText input_volume;

    @BindView(R.id.input_lokasi)
    EditText input_lokasi;

    @BindView(R.id.input_waktu)
    EditText input_waktu;

    @BindView(R.id.input_sumberbiaya)
    EditText input_sumberbiaya;

    @BindView(R.id.input_penanggungjawab)
    EditText input_penanggungjawab;

    @BindView(R.id.input_pelaksana)
    EditText input_pelaksana;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_crudetailrktp, container, false);
        ButterKnife.bind(this, v);

        return v;
    }

    @Override
    public PetaniRealm getUIData() {
        String strTujuan = input_tujuan.getText().toString();
        String strMasalah = input_masalah.getText().toString();
        String strSasaran = input_sasaran.getText().toString();
        String strMateri = input_materi.getText().toString();
        String strMetode = input_metode.getText().toString();
        String strVolume = input_volume.getText().toString();
        String strLokasi = input_lokasi.getText().toString();
        String strWaktu = input_waktu.getText().toString();
        String strSumberBiaya = input_sumberbiaya.getText().toString();
        String strPenanggungJawab = input_penanggungjawab.getText().toString();
        String strPelaksana = input_pelaksana.getText().toString();

        PetaniRealm uiItem = new PetaniRealm();
        return null;
    }

    @Override
    public void setUIData() {

    }

    @Override
    public void saveData(String tipe, Parcelable itemData) {
        //PetaniContract.Controller<PetaniRealm> mController = new PetaniController(this);
        PetaniRealm uiItem = getUIData();

        if(tipe.equals("insert")){
            //mController.addItem(uiItem);
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
