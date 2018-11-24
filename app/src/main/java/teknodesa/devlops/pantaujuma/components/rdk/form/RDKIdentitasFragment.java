package teknodesa.devlops.pantaujuma.components.rdk.form;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.CRUActivity;
import teknodesa.devlops.pantaujuma.components.rdk.DetailRDKActivity;
import teknodesa.devlops.pantaujuma.components.rdk.ListRDKActivity;
import teknodesa.devlops.pantaujuma.components.rdk.RDKContract;
import teknodesa.devlops.pantaujuma.components.searchpoktan.SearchPoktanFragment;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.rdk.Identitas;

public class RDKIdentitasFragment extends Fragment implements RDKContract.ViewController<Identitas>, RDKContract.View, SearchPoktanFragment.OnClickPoktanListener {

    @Inject
    Realm realm;

    Calendar myCalendar;

    @BindView(R.id.input_poktan)
    EditText input_poktan;

    @BindView(R.id.btnPoktan)
    Button btnPoktan;

    @BindView(R.id.input_tanggal)
    EditText input_tanggal;

    @BindView(R.id.btnTanggal)
    Button btnTanggal;
    @OnClick(R.id.btnTanggal)
    void setTanggal() {
        final Calendar calendar = Calendar.getInstance();
        int tanggal = calendar.get(Calendar.DAY_OF_MONTH),
                bulan = calendar.get(Calendar.MONTH),
                tahun = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), (view, year, month, dayOfMonth) -> {
            input_tanggal.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
        }, tahun, bulan, tanggal);
        datePickerDialog.show();
    }

    @BindView(R.id.input_luasSawah)
    EditText input_luasSawah;

    @BindView(R.id.input_keterangan)
    EditText input_keterangan;

    public String poktan = "";
    public static boolean isOpen=false;
    public static boolean check;

    FragmentActivity activity;

    @OnClick(R.id.btnPoktan)
    void clickPilihPoktan() {
        SearchPoktanFragment.keterangan = 1;
        SearchPoktanFragment.newInstance(this).show(getActivity().getFragmentManager(), "");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
        ((MainApplication) getActivity().getApplication())
                .getComponent()
                .inject(SearchPoktanFragment.newInstance(this));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myCalendar = Calendar.getInstance();
        isOpen = true;
        View v = inflater.inflate(R.layout.fragment_crurdkidentitas, null);
        ButterKnife.bind(this, v);
        if (CRUActivity.mAction == "update"){
            setLayoutForEdit();
            poktan = DetailRDKActivity.idPoktan;
        }
        return v;
    }


    public void setLayoutForEdit(){
        input_poktan.setText(DetailRDKActivity.dataPoktan.getNama());
        input_tanggal.setText(DetailRDKActivity.dataRDK.getTanggal());
        input_luasSawah.setText(DetailRDKActivity.dataRDK.getLuasSawah());
        input_keterangan.setText(DetailRDKActivity.dataRDK.getKeterangan());
    }

    @Override
    public Identitas getUIData() {
        String strTanggal = input_tanggal.getText().toString();
        String strLuasSawah = input_luasSawah.getText().toString();
        String strKeterangan = input_keterangan.getText().toString();

        Identitas newItem = new Identitas();

        if(poktan.compareTo("")==0 || poktan == null){
            check=true;
            checkData();
        }else{
            newItem.setPoktan(poktan);
        }

        if(strTanggal == null || strTanggal.compareTo("")==0){
            newItem.setTanggal("");
        }else{
            newItem.setTanggal(strTanggal);
        }

        if(strLuasSawah == null || strLuasSawah.compareTo("")==0){
            newItem.setLuasSawah("");
        }else{
            newItem.setLuasSawah(strLuasSawah);
        }

        if(strKeterangan == null || strKeterangan.compareTo("")==0){
            newItem.setKeterangan("");
        }else{
            newItem.setKeterangan(strKeterangan);
        }

        return newItem;
    }

    @Override
    public void setUIData() {
        Identitas theUIData = (Identitas) CRUActivity.mData;
        input_poktan.setText(theUIData.getPoktan()+ "");
        input_tanggal.setText(theUIData.getTanggal()+ "");
        input_luasSawah.setText(theUIData.getLuasSawah()+ "");
        input_keterangan.setText(theUIData.getKeterangan()+ "");
    }

    @Override
    public void saveData(String tipe, Parcelable itemData) {

    }

    public void checkData(){

    }

    @Override
    public void showNotification(String title, String header, String message) {
        Toast.makeText(CRUActivity.mContext, message, Toast.LENGTH_SHORT).show();
        startActivity(ListRDKActivity.createIntent(CRUActivity.mContext));
    }

    @Override
    public void OnClickPoktan(String idPoktan, String nama, String deskripsi) {
        input_poktan.setText(nama);
        poktan = idPoktan;
    }

}
