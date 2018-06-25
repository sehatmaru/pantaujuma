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


public class CRUKegiatanPenyimpananFragment extends Fragment implements PetaniContract.ViewController<PetaniRealm>, PetaniContract.View{

    @BindView(R.id.input_tanggalmasuk)
    EditText input_tanggalmasuk;

    @BindView(R.id.input_tanggalkeluar)
    EditText input_tanggalkeluar;

    @BindView(R.id.input_masakegiatan)
    EditText input_masakegiatan;

    @BindView(R.id.input_cara)
    EditText input_cara;

    @BindView(R.id.input_jumlah)
    EditText input_jumlah;

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
        String strTanggalMasuk = input_tanggalmasuk.getText().toString();
        String strTanggalKeluar = input_tanggalkeluar.getText().toString();
        String strMasaKegiatan = input_masakegiatan.getText().toString();
        String strCara = input_cara.getText().toString();
        String strJumlah = input_jumlah.getText().toString();

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
