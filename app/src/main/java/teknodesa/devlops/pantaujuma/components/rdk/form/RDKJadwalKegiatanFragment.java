package teknodesa.devlops.pantaujuma.components.rdk.form;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.CRUActivity;
import teknodesa.devlops.pantaujuma.components.rdk.DetailRDKActivity;
import teknodesa.devlops.pantaujuma.components.rdk.RDKContract;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.rdk.JadwalKegiatan;

public class RDKJadwalKegiatanFragment extends Fragment implements RDKContract.ViewController<JadwalKegiatan> {

    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener date;

    @BindView(R.id.input_kegiatan)
    EditText input_kegiatan;

    @BindView(R.id.input_tanggalJK)
    EditText input_tanggalJK;

    @OnClick(R.id.btnTanggalJK)
    void setTanggal() {
        final Calendar calendar = Calendar.getInstance();
        int tanggal = calendar.get(Calendar.DAY_OF_MONTH),
                bulan = calendar.get(Calendar.MONTH),
                tahun = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), (view, year, month, dayOfMonth) -> {
            input_tanggalJK.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
        }, tahun, bulan, tanggal);
        datePickerDialog.show();
    }

    @BindView(R.id.input_deskripsiJK)
    EditText input_deskripsiJK;

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

        View v = inflater.inflate(R.layout.fragment_crurdkjadwalkegiatan, null);
        ButterKnife.bind(this, v);
        setDate();

        return v;
    }

    private void setData(){
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        input_kegiatan = getActivity().findViewById(R.id.input_kegiatan);
        input_tanggalJK = getActivity().findViewById(R.id.input_tanggalJK);
        input_deskripsiJK= getActivity().findViewById(R.id.input_deskripsiJK);

        if (CRUActivity.mAction == "update"){
            setLayoutForEdit();
        } else {
            setData();
        }
    }

    private void setLayoutForEdit() {
        input_kegiatan.setText(DetailRDKActivity.dataRDK.getKegiatanJK());
        input_tanggalJK.setText(DetailRDKActivity.dataRDK.getTanggalJK());
        input_deskripsiJK.setText(DetailRDKActivity.dataRDK.getDeskripsiJK());
    }

    @Override
    public JadwalKegiatan getUIData() {
        String kegiatanJK = "";
        String tanggalJK = "";
        String deskripsiJK = "";

        try{
            kegiatanJK = (input_kegiatan.getText().toString() == null) ? "-" : input_kegiatan.getText().toString();
            tanggalJK = (input_tanggalJK.getText().toString() == null) ? "-" : input_tanggalJK.getText().toString();
            deskripsiJK = (input_deskripsiJK.getText().toString() == null) ? "-" : input_deskripsiJK.getText().toString();
        }catch (NullPointerException e){}

        JadwalKegiatan newItem = new JadwalKegiatan();
        newItem.setKegiatanJK(kegiatanJK);
        newItem.setTanggalJK(tanggalJK);
        newItem.setDeskripsiJK(deskripsiJK);

        return newItem;
    }

    @Override
    public void setUIData() {
        JadwalKegiatan theUIData = (JadwalKegiatan) CRUActivity.mData;
        input_kegiatan.setText(theUIData.getKegiatanJK()+ "");
        input_tanggalJK.setText(theUIData.getTanggalJK()+ "");
        input_deskripsiJK.setText(theUIData.getDeskripsiJK()+ "");
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
        };
    }
}