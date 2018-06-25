package com.developnerz.internship.delinternship;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.dependencies.models.enums.Status;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.petani.PetaniRealm;


public class HomeJumaFragment extends Fragment implements PetaniContract.ViewController<PetaniRealm>, PetaniContract.View{

    @BindView(R.id.btnPenduduk)
    Button btnPenduduk;

    @BindView(R.id.tvPenduduk)
    TextView tvPenduduk;

    @BindView(R.id.btnPetani)
    Button btnPetani;

    @BindView(R.id.tvPetani)
    TextView tvPetani;

    @BindView(R.id.btnPoktan)
    Button btnPoktan;

    @BindView(R.id.tvPoktan)
    TextView tvPoktan;

    @BindView(R.id.btnRDK)
    Button btnRDK;

    @BindView(R.id.tvRDK)
    TextView tvRDK;

    @BindView(R.id.btnRDKK)
    Button btnRDKK;

    @BindView(R.id.tvRDKK)
    TextView tvRDKK;

    @BindView(R.id.btnRKTP)
    Button btnRKTP;

    @BindView(R.id.tvRKTP)
    TextView tvRKTP;

    @BindView(R.id.btnTarget)
    Button btnTarget;

    @BindView(R.id.tvTarget)
    TextView tvTarget;

    @BindView(R.id.btnLahan)
    Button btnLahan;

    @BindView(R.id.tvLahan)
    TextView tvLahan;

    @BindView(R.id.btnKomoditas)
    Button btnKomoditas;

    @BindView(R.id.tvKomoditas)
    TextView tvKomoditas;

    @BindView(R.id.btnAlsintan)
    Button btnAlsintan;

    @BindView(R.id.tvAlsintan)
    TextView tvAlsintan;

    @BindView(R.id.btnHarga)
    Button btnHarga;

    @BindView(R.id.tvHarga)
    TextView tvHarga;

    @BindView(R.id.btnSurvei)
    Button btnSurvei;

    @BindView(R.id.tvSurvei)
    TextView tvSurvei;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_crupetani, container, false);
        ButterKnife.bind(this, v);

        input_status.setAdapter(new ArrayAdapter<Status>(getActivity(), R.layout.spinner_item, Status.values()) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        });

        btnPenduduk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getContext(), "Penduduk", Toast.LENGTH_SHORT).show();
                //switch (mJenisCRU){
                    //case "penduduk": cruPendudukFragment.getUIData(); break;
                   // case "petani": cruPetaniFragment.getUIData(); break;
                //}
                // Code here executes on main thread after user presses button
            }
        });

        return v;
    }

    @Override
    public PetaniRealm getUIData() {
        String strNIK = input_nik.getText().toString();
        String strNamaDepan = input_namadepan.getText().toString();
        String strNamaBelakang = input_namabelakang.getText().toString();
        String strDeskripsi = input_deskripsi.getText().toString();
        String strStatus = input_status.getSelectedItem().toString();

        PetaniRealm uiItem = new PetaniRealm();
        return null;
    }

    @Override
    public void saveData(String tipe) {
        PetaniContract.Controller<PetaniRealm> mController = new PetaniController(this);
        PetaniRealm uiItem = getUIData();

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
