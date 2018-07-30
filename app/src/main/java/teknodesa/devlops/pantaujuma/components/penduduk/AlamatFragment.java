package teknodesa.devlops.pantaujuma.components.penduduk;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.CRUActivity;
import teknodesa.devlops.pantaujuma.components.profile.AkunFragment;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.penduduk.Alamat;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.penduduk.BiodataPenduduk;

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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MainApplication) getActivity().getApplication())
                .getComponent()
                .inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_alamat, null);
        ButterKnife.bind(this, v);
        setData();
        return v;
    }

    private void setData(){
        input_desa.setText(AkunFragment.desaUser);
        input_kecamatan.setText(AkunFragment.kecamatanUser);
        input_datiii.setText(AkunFragment.kabupatenKotaUser);
        input_provinsi.setText(AkunFragment.provinsiUser);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        input_alamat = getActivity().findViewById(R.id.input_alamat);
        input_rt= getActivity().findViewById(R.id.input_rt);
        input_rw= getActivity().findViewById(R.id.input_rw);
        input_dusun= getActivity().findViewById(R.id.input_dusun);
        input_desa= getActivity().findViewById(R.id.input_desa);
        input_kecamatan= getActivity().findViewById(R.id.input_kecamatan);
        input_datiii= getActivity().findViewById(R.id.input_datiii);
        input_provinsi= getActivity().findViewById(R.id.input_provinsi);
        input_kodepos= getActivity().findViewById(R.id.input_kodepos);
        input_email= getActivity().findViewById(R.id.input_email);
        input_hp= getActivity().findViewById(R.id.input_hp);
        input_telp= getActivity().findViewById(R.id.input_telp);
        setData();

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
    public void setUIData() {
        Alamat theUIData = (Alamat) CRUActivity.mData;
        input_alamat.setText(theUIData.getAlamat()+ "");
        input_rt.setText(theUIData.getRt()+ "");
        input_rw.setText(theUIData.getRw()+ "");
        input_dusun.setText(theUIData.getDusun()+ "");
        input_desa.setText(theUIData.getDesa()+ "");
        input_kecamatan.setText(theUIData.getKecamatan()+ "");
        input_datiii.setText(theUIData.getDatiII()+ "");
        input_provinsi.setText(theUIData.getProvinsi()+ "");
        input_kodepos.setText(theUIData.getKodePos()+ "");
        input_email.setText(theUIData.getEmail()+ "");
        input_hp.setText(theUIData.getNoHP()+ "");
        input_telp.setText(theUIData.getNoTelp()+ "");
    }

    @Override
    public void saveData(String tipe, Parcelable itemData) {
        //not implemented yet
    }
}
