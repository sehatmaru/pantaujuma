package teknodesa.devlops.pantaujuma.components.rdk.form;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.CRUActivity;
import teknodesa.devlops.pantaujuma.components.rdk.DetailRDKActivity;
import teknodesa.devlops.pantaujuma.components.rdk.ListRDKActivity;
import teknodesa.devlops.pantaujuma.components.rdk.RDKContract;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.rdk.JadwalKegiatan;

public class RDKJadwalKegiatanFragment extends Fragment implements RDKContract.ViewController<JadwalKegiatan> {

    Calendar myCalendar;

    @BindView(R.id.input_kegiatan)
    EditText input_kegiatan;

    @BindView(R.id.input_tanggalJK)
    EditText input_tanggalJK;

    @BindView(R.id.input_deskripsiJK)
    EditText input_deskripsiJK;

    @BindView(R.id.btnTanggalJK)
    Button btnTanggalJK;
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

    public static boolean isOpen = false;

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

        if(CRUActivity.mAction == "update"){
            textForEdit();
        }
        isOpen = true;
        return v;
    }

    void textForEdit(){
        input_kegiatan.setText(DetailRDKActivity.dataRDK.getKegiatanJK());
        input_tanggalJK.setText(DetailRDKActivity.dataRDK.getTanggalJK());
        input_deskripsiJK.setText(DetailRDKActivity.dataRDK.getDeskripsiJK());
    }

    @Override
    public JadwalKegiatan getUIData() {
        String strKegiatan;
        String strTanggal;
        String strDeskripsi;

//        String strKegiatan = input_kegiatan.getText().toString();
//        String strTanggal = input_tanggalJK.getText().toString();
//        String strDeskripsi = input_deskripsiJK.getText().toString();

        JadwalKegiatan newItem = new JadwalKegiatan();

        try{
            strKegiatan = input_kegiatan.getText().toString();
            strTanggal = input_tanggalJK.getText().toString();
            strDeskripsi = input_deskripsiJK.getText().toString();
        } catch (NullPointerException e){
            strKegiatan = "";
            strTanggal = "";
            strDeskripsi = "";
        }

        if(strKegiatan == null || strKegiatan.compareTo("")==0){
            newItem.setKegiatanJK("");
        }else{
            newItem.setKegiatanJK(strKegiatan);
        }

//        if(input_kegiatan.getText().toString() == null || input_kegiatan.getText().toString().compareTo("")==0){
//            newItem.setKegiatanJK("");
//        }else{
//            newItem.setKegiatanJK(strKegiatan);
//        }

//        if(input_tanggalJK.getText().toString() == null || input_tanggalJK.getText().toString().compareTo("")==0){
//            newItem.setTanggalJK("");
//        }else{
//            newItem.setTanggalJK(strTanggal);
//        }
//
//        if(input_deskripsiJK.getText().toString() == null || input_deskripsiJK.getText().toString().compareTo("")==0){
//            newItem.setDeskripsiJK("");
//        }else{
//            newItem.setDeskripsiJK(strDeskripsi);
//        }

        if(strTanggal == null || strTanggal.compareTo("")==0){
            newItem.setTanggalJK("");
        }else{
            newItem.setTanggalJK(strTanggal);
        }

        if(strDeskripsi == null || strDeskripsi.compareTo("")==0){
            newItem.setDeskripsiJK("");
        }else{
            newItem.setDeskripsiJK(strDeskripsi);
        }

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
}