package teknodesa.devlops.pantaujuma.components.penduduk;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.CRUActivity;
import teknodesa.devlops.pantaujuma.dependencies.models.enums.Agama;
import teknodesa.devlops.pantaujuma.dependencies.models.enums.GolonganDarah;
import teknodesa.devlops.pantaujuma.dependencies.models.enums.JenisKelamin;
import teknodesa.devlops.pantaujuma.dependencies.models.enums.Pekerjaan;
import teknodesa.devlops.pantaujuma.dependencies.models.enums.Pendidikan;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.Penduduk;

public class BiodataFragment extends Fragment implements PendudukContract.ViewController<Penduduk> {
    Calendar myCalendar;

    DatePickerDialog.OnDateSetListener date;

    @BindView(R.id.input_golongandarah)
    Spinner input_golongandarah;

    @BindView(R.id.input_agama)
    Spinner input_agama;

    @BindView(R.id.input_jeniskelamin)
    Spinner input_jeniskelamin;

    @BindView(R.id.input_pendidikan)
    Spinner input_pendidikan;

    @BindView(R.id.input_pekerjaan)
    Spinner input_pekerjaan;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myCalendar = Calendar.getInstance();

        View v = inflater.inflate(R.layout.fragment_biopenduduk, container, false);
        ButterKnife.bind(this, v);

        input_golongandarah.setAdapter(new ArrayAdapter<GolonganDarah>(getActivity(), R.layout.spinner_item, GolonganDarah.values()) {
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

        input_agama.setAdapter(new ArrayAdapter<Agama>(getActivity(), R.layout.spinner_item, Agama.values()) {
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

        input_jeniskelamin.setAdapter(new ArrayAdapter<JenisKelamin>(getActivity(), R.layout.spinner_item, JenisKelamin.values()) {
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

        input_pendidikan.setAdapter(new ArrayAdapter<Pendidikan>(getActivity(), R.layout.spinner_item, Pendidikan.values()) {
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

        input_pekerjaan.setAdapter(new ArrayAdapter<Pekerjaan>(getActivity(), R.layout.spinner_item, Pekerjaan.values()) {
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

        date = (view, year, monthOfYear, dayOfMonth) -> {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        };

        input_tanggallahir.setOnClickListener(view -> {
            new DatePickerDialog(getContext(), date, myCalendar
                    .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH)).show();
        });

        return v;
    }

    private void updateLabel() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        input_tanggallahir.setText(sdf.format(myCalendar.getTime()));
    }

    @Override
    public Penduduk getUIData() {
        String strNIK = input_nik.getText().toString();
        String strFoto = "-";
        String strNamaDepan = input_namadepan.getText().toString();
        String strNamaBelakang = input_namabelakang.getText().toString();
        String strJenisKelamin = input_jeniskelamin.getSelectedItem().toString();
        String strTempatLahir = input_tempatlahir.getText().toString();
        String strTanggalLahir = input_tanggallahir.getText().toString();
        String strAgama = input_agama.getSelectedItem().toString();
        String strGolonganDarah = input_golongandarah.getSelectedItem().toString();
        String strPekerjaan = input_pekerjaan.getSelectedItem().toString();
        String strPendidikan = input_pendidikan.getSelectedItem().toString();
        String strStatus = "aktif";
        boolean isDeleted = false;

        Penduduk newItem = new Penduduk(strNIK, strFoto, strNamaDepan, strNamaBelakang, strJenisKelamin, strTempatLahir, strTanggalLahir, strAgama, strGolonganDarah, strPekerjaan, strPendidikan, strStatus, isDeleted);

        return newItem;
    }

    @Override
    public void setUIData() {
        Penduduk theUIData = (Penduduk) CRUActivity.mData;
        input_nik.setText (theUIData.getNIK()+ "");

        input_namadepan.setText  (theUIData.getNamaDepan()+ "");
        input_namabelakang.setText  (theUIData.getNamaBelakang()+ "");

        ArrayAdapter<JenisKelamin> aJK = new ArrayAdapter<JenisKelamin>(CRUActivity.mContext.getApplicationContext(), R.layout.spinner_item, JenisKelamin.values());
        input_jeniskelamin.setAdapter(aJK);
        String valJK = theUIData.getJenisKelamin();
        if (valJK != null) {
            int spinnerPosition = aJK.getPosition(JenisKelamin.valueFor(valJK));
            input_jeniskelamin.setSelection(spinnerPosition);
        }

        input_tempatlahir.setText  (theUIData.getTempatLahir()+ "");
        input_tanggallahir.setText  (theUIData.getTanggalLahir()+ "");

        ArrayAdapter<Agama> aAgama = new ArrayAdapter<Agama>(CRUActivity.mContext.getApplicationContext(), R.layout.spinner_item, Agama.values());
        input_agama.setAdapter(aAgama);
        String valAgama = theUIData.getAgama();
        if (valAgama != null) {
            int spinnerPosition = aAgama.getPosition(Agama.valueFor(valAgama));
            input_agama.setSelection(spinnerPosition);
        }

        ArrayAdapter<GolonganDarah> aGolonganDarah = new ArrayAdapter<GolonganDarah>(CRUActivity.mContext.getApplicationContext(), R.layout.spinner_item, GolonganDarah.values());
        input_golongandarah.setAdapter(aGolonganDarah);
        String valGolDarah = theUIData.getGolonganDarah();
        if (valGolDarah != null) {
            int spinnerPosition = aGolonganDarah.getPosition(GolonganDarah.valueFor(valGolDarah));
            input_golongandarah.setSelection(spinnerPosition);
        }

        ArrayAdapter<Pekerjaan> aPekerjaan = new ArrayAdapter<Pekerjaan>(CRUActivity.mContext.getApplicationContext(), R.layout.spinner_item, Pekerjaan.values());
        input_pekerjaan.setAdapter(aPekerjaan);
        String valPekerjaan = theUIData.getPekerjaan();
        if (valPekerjaan != null) {
            int spinnerPosition = aPekerjaan.getPosition(Pekerjaan.valueFor(valPekerjaan));
            input_pekerjaan.setSelection(spinnerPosition);
        }

        ArrayAdapter<Pendidikan> aPendidikan = new ArrayAdapter<Pendidikan>(CRUActivity.mContext.getApplicationContext(), R.layout.spinner_item, Pendidikan.values());
        input_pendidikan.setAdapter(aPendidikan);
        String valPendidikan = theUIData.getGolonganDarah();
        if (valPendidikan != null) {
            int spinnerPosition = aPendidikan.getPosition(Pendidikan.valueFor(valPendidikan));
            input_pendidikan.setSelection(spinnerPosition);
        }
    }

    @Override
    public void saveData(String tipe, Parcelable itemData) {
        //not implemented yet
    }
}
