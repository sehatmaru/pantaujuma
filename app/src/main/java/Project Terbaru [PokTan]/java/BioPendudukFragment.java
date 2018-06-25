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


public class BioPendudukFragment extends Fragment implements PetaniContract.ViewController<PetaniRealm>, PetaniContract.View{

    @BindView(R.id.input_nik)
    EditText input_nik;

    @BindView(R.id.input_namadepan)
    EditText input_namadepan;

    @BindView(R.id.input_namabelakang)
    EditText input_namabelakang;

    @BindView(R.id.input_jeniskelamin)
    Spinner input_jeniskelamin;

    @BindView(R.id.input_tempatlahir)
    EditText input_tempatlahir;

    @BindView(R.id.input_tanggallahir)
    EditText input_tanggallahir;

    @BindView(R.id.input_agama)
    Spinner input_agama;

    @BindView(R.id.input_golongandarah)
    Spinner input_golongandarah;

    @BindView(R.id.input_pendidikan)
    Spinner input_pendidikan;

    @BindView(R.id.input_pekerjaan)
    Spinner input_pekerjaan;

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
        String strJenisKelamin = input_jeniskelamin.getSelectedItem().toString();
        String strTempatLahir = input_tempatlahir.getText().toString();
        String strTanggalLahir = input_tanggallahir.getText().toString();
        String strAgama = input_agama.getSelectedItem().toString();
        String strGolonganDarah = input_golongandarah.getSelectedItem().toString();
        String strPendidikan = input_pendidikan.getSelectedItem().toString();
        String strPekerjaan = input_pekerjaan.getSelectedItem().toString();

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
