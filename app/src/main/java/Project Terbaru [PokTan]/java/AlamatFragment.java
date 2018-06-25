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


public class AlamatFragment extends Fragment implements PetaniContract.ViewController<PetaniRealm>, PetaniContract.View{
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
        String strAlamat = input_alamat.getText().toString();
        String strRT = input_rt.getText().toString();
        String strRW = input_rw.getText().toString();
        String strDusun = input_dusun.getText().toString();
        String strDesa = input_desa.getText().toString();
        String strKecamatan = input_kecamatan.getText().toString();
        String strDatiii = input_datiii.getText().toString();
        String strProvinsi = input_provinsi.getText().toString();
        String strKodePos = input_kodepos.getText().toString();
        String strEmail = input_email.getText().toString();
        String strHP = input_hp.getText().toString();
        String strTelp = input_telp.getText().toString();

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
