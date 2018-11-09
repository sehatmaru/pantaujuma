package teknodesa.devlops.pantaujuma.components.penduduk.form;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.CRUActivity;
import teknodesa.devlops.pantaujuma.components.penduduk.DetailPendudukActivity;
import teknodesa.devlops.pantaujuma.dependencies.models.enums.Agama;
import teknodesa.devlops.pantaujuma.dependencies.models.enums.GolonganDarah;
import teknodesa.devlops.pantaujuma.dependencies.models.enums.JenisKelamin;
import teknodesa.devlops.pantaujuma.dependencies.models.enums.Pekerjaan;
import teknodesa.devlops.pantaujuma.dependencies.models.enums.Pendidikan;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.penduduk.BiodataPenduduk;

public class BiodataFragment extends Fragment implements PendudukContract.ViewController<BiodataPenduduk> {
    Calendar myCalendar;

    DatePickerDialog.OnDateSetListener date;

    @BindView(R.id.spinnerJK)
    Spinner spinnerJK;

    @BindView(R.id.spinnerAgama)
    Spinner spinnerAgama;

    @BindView(R.id.spinnerGolonganDarah)
    Spinner spinnerGolonganDarah;

    @BindView(R.id.spinnerPendidikan)
    Spinner spinnerPendidikan;

    @BindView(R.id.spinnerPekerjaan)
    Spinner spinnerPekerjaan;

    @BindView(R.id.input_tanggallahir)
    EditText input_tanggallahir;

    @BindView(R.id.input_nik)
    EditText input_nik;

    @BindView(R.id.input_namadepan)
    EditText input_namadepan;

    @BindView(R.id.input_namabelakang)
    EditText input_namabelakang;

    @BindView(R.id.input_tempatlahir)
    EditText input_tempatlahir;


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
        myCalendar = Calendar.getInstance();

        View v = inflater.inflate(R.layout.fragment_biopenduduk, null);
        ButterKnife.bind(this, v);

        setAdapter();
        setDate();

        input_tanggallahir.setOnClickListener(view -> {
            new DatePickerDialog(getContext(), date, myCalendar
                    .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH)).show();
        });


        if(CRUActivity.mAction == "update"){
            textForEdit();
        }else{

        }

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        input_nik = getActivity().findViewById(R.id.input_nik);
        spinnerJK = getActivity().findViewById(R.id.spinnerJK);
        spinnerAgama = getActivity().findViewById(R.id.spinnerAgama);
        spinnerGolonganDarah = getActivity().findViewById(R.id.spinnerGolonganDarah);
        spinnerPendidikan = getActivity().findViewById(R.id.spinnerPendidikan);
        spinnerPekerjaan = getActivity().findViewById(R.id.spinnerPekerjaan);
        input_tanggallahir = getActivity().findViewById(R.id.input_tanggallahir);
        input_namadepan = getActivity().findViewById(R.id.input_namadepan);
        input_namabelakang = getActivity().findViewById(R.id.input_namabelakang);
        input_tempatlahir = getActivity().findViewById(R.id.input_tempatlahir);
    }

    void textForEdit(){
        input_nik.setText(DetailPendudukActivity.dataPenduduk.getNIK());
        input_namadepan.setText(DetailPendudukActivity.dataPenduduk.getNamaDepan());
        input_namabelakang.setText(DetailPendudukActivity.dataPenduduk.getNamaBelakang());

        ArrayAdapter<JenisKelamin> aJK = new ArrayAdapter<JenisKelamin>(CRUActivity.mContext.getApplicationContext(), R.layout.spinner_item, JenisKelamin.values());
        spinnerJK.setAdapter(aJK);
        String valJK = DetailPendudukActivity.dataPenduduk.getJenisKelamin();
        if (valJK != null) {
            int spinnerPosition = aJK.getPosition(JenisKelamin.valueFor(valJK));
            spinnerJK.setSelection(spinnerPosition);
        }

        input_tempatlahir.setText(DetailPendudukActivity.dataPenduduk.getTempatLahir());
        input_tanggallahir.setText(DetailPendudukActivity.dataPenduduk.getTanggalLahir());

        ArrayAdapter<Agama> aAgama = new ArrayAdapter<Agama>(CRUActivity.mContext.getApplicationContext(), R.layout.spinner_item, Agama.values());
        spinnerAgama.setAdapter(aAgama);
        String valAgama = DetailPendudukActivity.dataPenduduk.getAgama();
        if (valAgama != null) {
            int spinnerPosition = aAgama.getPosition(Agama.valueFor(valAgama));
            spinnerAgama.setSelection(spinnerPosition);
        }

        ArrayAdapter<GolonganDarah> aGolonganDarah = new ArrayAdapter<GolonganDarah>(CRUActivity.mContext.getApplicationContext(), R.layout.spinner_item, GolonganDarah.values());
        spinnerGolonganDarah.setAdapter(aGolonganDarah);
        String valGolDarah = DetailPendudukActivity.dataPenduduk.getGolonganDarah();
        if (valGolDarah != null) {
            int spinnerPosition = aGolonganDarah.getPosition(GolonganDarah.valueFor(valGolDarah));
            spinnerGolonganDarah.setSelection(spinnerPosition);
        }

        ArrayAdapter<Pekerjaan> aPekerjaan = new ArrayAdapter<Pekerjaan>(CRUActivity.mContext.getApplicationContext(), R.layout.spinner_item, Pekerjaan.values());
        spinnerPekerjaan.setAdapter(aPekerjaan);
        String valPekerjaan = DetailPendudukActivity.dataPenduduk.getPekerjaan();
        if (valPekerjaan != null) {
            int spinnerPosition = aPekerjaan.getPosition(Pekerjaan.valueFor(valPekerjaan));
            spinnerPekerjaan.setSelection(spinnerPosition);
        }

        ArrayAdapter<Pendidikan> aPendidikan = new ArrayAdapter<Pendidikan>(CRUActivity.mContext.getApplicationContext(), R.layout.spinner_item, Pendidikan.values());
        spinnerPendidikan.setAdapter(aPendidikan);
        String valPendidikan = DetailPendudukActivity.dataPenduduk.getGolonganDarah();
        if (valPendidikan != null) {
            int spinnerPosition = aPendidikan.getPosition(Pendidikan.valueFor(valPendidikan));
            spinnerPendidikan.setSelection(spinnerPosition);
        }

    }

    private void updateLabel() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        input_tanggallahir.setText(sdf.format(myCalendar.getTime()));
    }

    @Override
    public BiodataPenduduk getUIData() {
        String strNIK = input_nik.getText().toString();
        String strFoto = "-";
        String strNamaDepan = input_namadepan.getText().toString();
        String strNamaBelakang = input_namabelakang.getText().toString();
        String strJenisKelamin = spinnerJK.getSelectedItem().toString();
        String strTempatLahir = input_tempatlahir.getText().toString();
        String strTanggalLahir = input_tanggallahir.getText().toString();
        String strAgama = spinnerAgama.getSelectedItem().toString();
        String strGolonganDarah = spinnerGolonganDarah.getSelectedItem().toString();
        String strPekerjaan = spinnerPekerjaan.getSelectedItem().toString();
        String strPendidikan = spinnerPendidikan.getSelectedItem().toString();
        String strStatus = "aktif";

        BiodataPenduduk newItem = new BiodataPenduduk(strNIK, strFoto, strNamaDepan, strNamaBelakang, strJenisKelamin,
                strTempatLahir, strTanggalLahir, strAgama, strGolonganDarah, strPekerjaan, strPendidikan, strStatus);
        return newItem;
    }
    void setSpinnerSelection(String data, List<String> sources, Spinner spinner){
        int i = 0;
        for (String source : sources){
            if (i < sources.size()){
                if (source.equals(data)){
                    spinner.setSelection(i);
                }
                i++;
            } else {
                spinner.setSelection(0);
            }
        }
    }

    @Override
    public void setUIData() {

    }

    @Override
    public void saveData(String tipe, Parcelable itemData) {
        //not implemented yet
    }

    private void setDate(){
        date = (view, year, monthOfYear, dayOfMonth) -> {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        };
    }
    private void setAdapter(){
        spinnerGolonganDarah.setAdapter(new ArrayAdapter<GolonganDarah>(getActivity(), R.layout.spinner_item, GolonganDarah.values()) {
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

        spinnerAgama.setAdapter(new ArrayAdapter<Agama>(getActivity(), R.layout.spinner_item, Agama.values()) {
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

        spinnerJK.setAdapter(new ArrayAdapter<JenisKelamin>(getActivity(), R.layout.spinner_item, JenisKelamin.values()) {
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

        spinnerPendidikan.setAdapter(new ArrayAdapter<Pendidikan>(getActivity(), R.layout.spinner_item, Pendidikan.values()) {
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

        spinnerPekerjaan.setAdapter(new ArrayAdapter<Pekerjaan>(getActivity(), R.layout.spinner_item, Pekerjaan.values()) {
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
    }
}
