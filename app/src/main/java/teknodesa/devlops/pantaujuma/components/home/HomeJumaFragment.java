package teknodesa.devlops.pantaujuma.components.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.alsintan.ListAlsintanActivity;
import teknodesa.devlops.pantaujuma.components.harga.ListHargaActivity;
import teknodesa.devlops.pantaujuma.components.komoditas.ListKomoditasActivity;
import teknodesa.devlops.pantaujuma.components.lahan.ListLahanActivity;
import teknodesa.devlops.pantaujuma.components.penduduk.ListPendudukActivity;
import teknodesa.devlops.pantaujuma.components.petani.ListPetaniActivity;
import teknodesa.devlops.pantaujuma.components.petani.ListPoktanActivity;
import teknodesa.devlops.pantaujuma.components.petugas.ListTargetActivity;
import teknodesa.devlops.pantaujuma.components.rdk.ListRDKActivity;
import teknodesa.devlops.pantaujuma.components.rdkk.ListRDKKActivity;
import teknodesa.devlops.pantaujuma.components.rktp.ListRKTPActivity;
import teknodesa.devlops.pantaujuma.components.survei.ListSurveiActivity;

public class HomeJumaFragment extends Fragment {
    FragmentActivity activity;

    @BindView(R.id.btnPenduduk) //Penduduk
    Button btnPenduduk;
    @OnClick(R.id.btnPenduduk)
    void clickListPenduduk(){
        startActivity(ListPendudukActivity.createIntent(getContext()));
    }

    @BindView(R.id.btnPetani) //Petani
    Button btnPetani;
    @OnClick(R.id.btnPetani)
    void clickListPetani(){
        startActivity(ListPetaniActivity.createIntent(getContext()));
    }

    @BindView(R.id.btnPoktan) //Poktan
    Button btnPoktan;
    @OnClick(R.id.btnPoktan)
    void clickListPoktan(){
        startActivity(ListPoktanActivity.createIntent(getContext()));
    }

    @BindView(R.id.btnRDK) //RDK
    Button btnRDK;
    @OnClick(R.id.btnRDK)
    void clickListRDK(){
        startActivity(ListRDKActivity.createIntent(getContext()));
    }

    @BindView(R.id.btnRDKK) //RDKK
    Button btnRDKK;
    @OnClick(R.id.btnRDKK)
    void clickListRDKK(){
        startActivity(ListRDKKActivity.createIntent(getContext()));
    }

    @BindView(R.id.btnRKTP) //RKTP
    Button btnRKTP;
    @OnClick(R.id.btnRKTP)
    void clickListRKTP(){
        startActivity(ListRKTPActivity.createIntent(getContext()));
    }

    @BindView(R.id.btnTarget) //Target
    Button btnTarget;
    @OnClick(R.id.btnTarget)
    void clickListTarget(){
        startActivity(ListTargetActivity.createIntent(getContext()));
    }

    @BindView(R.id.btnLahan) //Lahan
    Button btnLahan;
    @OnClick(R.id.btnLahan)
    void clickListLahan(){
        startActivity(ListLahanActivity.createIntent(getContext()));
    }

    @BindView(R.id.btnKomoditas) //Komoditas
    Button btnKomoditas;
    @OnClick(R.id.btnKomoditas)
    void clickListKomoditas(){
        startActivity(ListKomoditasActivity.createIntent(getContext()));
    }

    @BindView(R.id.btnAlsintan) //Alsintan
    Button btnAlsintan;
    @OnClick(R.id.btnAlsintan)
    void clickListAlsintan(){
        startActivity(ListAlsintanActivity.createIntent(getContext()));
    }

    @BindView(R.id.btnHarga) //Harga
    Button btnHarga;
    @OnClick(R.id.btnHarga)
    void clickListHarga(){
        startActivity(ListHargaActivity.createIntent(getContext()));
    }

    @BindView(R.id.btnSurvei) //Survei
    Button btnSurvei;
    @OnClick(R.id.btnSurvei)
    void clickListSurvei(){
        startActivity(ListSurveiActivity.createIntent(getContext()));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
        ((MainApplication) getActivity().getApplication())
                .getComponent()
                .inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_homejuma, container, false);
        ButterKnife.bind(this, v);

        return v;
    }
}