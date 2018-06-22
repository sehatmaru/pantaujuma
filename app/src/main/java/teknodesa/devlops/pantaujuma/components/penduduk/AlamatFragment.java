package teknodesa.devlops.pantaujuma.components.penduduk;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.Alamat;

public class AlamatFragment extends Fragment implements PendudukContract.ViewController<Alamat>{
    @BindView(R.id.input_alamat)
    EditText input_alamat;

    @BindView(R.id.input_rt)
    EditText input_rt;

    @BindView(R.id.input_rw)
    EditText input_rw;

    @BindView(R.id.input_dusun)
    EditText input_dusun;

    @BindView(R.id.input_desa)
    EditText input_desa;

    @BindView(R.id.input_kecamatan)
    EditText input_kecamatan;

    @BindView(R.id.input_datiii)
    EditText input_datiii;

    @BindView(R.id.input_provinsi)
    EditText input_provinsi;

    @BindView(R.id.input_kodepos)
    EditText input_kodepos;

    @BindView(R.id.input_email)
    EditText input_email;

    @BindView(R.id.input_hp)
    EditText input_hp;

    @BindView(R.id.input_telp)
    EditText input_telp;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_alamat, container, false);
        ButterKnife.bind(this, v);

        return v;
    }

    @Override
    public Alamat getUIData() {
        String strAlamat = input_alamat.getText().toString();
        String strRt = input_rt.getText().toString();
        String strRw = input_rw.getText().toString();
        String strDusun = input_dusun.getText().toString();
        String strDesa = input_desa.getText().toString();
        String strKecamatan = input_kecamatan.getText().toString();
        String strDatiII = input_datiii.getText().toString();
        String strProvinsi = input_provinsi.getText().toString();
        int strKodePos = input_kodepos.getText().toString().equals("")? 0:Integer.parseInt(input_kodepos.getText().toString());
        String strEmail = input_email.getText().toString();
        String strNoHP = input_hp.getText().toString();
        String strNoTelp = input_telp.getText().toString();

        Alamat newItem = new Alamat(strAlamat, strRt, strRw, strDusun, strDesa, strKecamatan, strDatiII, strProvinsi, strKodePos, strEmail, strNoHP, strNoTelp);

        return newItem;
    }

    @Override
    public void saveData(String tipe) {
        //not implemented yet
    }
}
