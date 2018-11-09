package teknodesa.devlops.pantaujuma.components.post;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.joanzapata.iconify.widget.IconTextView;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.adapter.KomentarAdapter;
import teknodesa.devlops.pantaujuma.components.base.BaseActivity;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.KomentarRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.PostRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.UserDB;
import teknodesa.devlops.pantaujuma.utils.Konstanta;

public class DetailPostActivity extends BaseActivity implements KomentarContract.View, GetKomentarContract.View {
    @Inject
    Realm realm;

    @Inject
    KomentarController mController;

    @Inject
    GetKomentarController gController;

    private AppComponent appComponent;

    List<KomentarRealm> listData = Collections.EMPTY_LIST;

    @BindView(R.id.namaPetugas)
    TextView namaPetugas;

    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;

    @BindView(R.id.namaDesa)
    TextView namaDesa;

    @BindView(R.id.judul)
    TextView judul;

    @BindView(R.id.isi)
    TextView isi;

    @BindView(R.id.tanggal)
    TextView tanggal;

    @BindView(R.id.waktu)
    TextView waktu;

    @BindView(R.id.textKomentar)
    EditText textKomentar;

    @BindView(R.id.btnKomentar)
    Button btnKomentar;

    @BindView(R.id.tampungKomentar)
    RecyclerView tampungKomentar;

    @BindView(R.id.spinnerIcon)
    IconTextView spinner;

    RecyclerView.LayoutManager linearLayoutManager;
    public KomentarAdapter mAdapter;
    private Context mContext;

    private ProgressDialog progressdialog;
    static int counter;
    private List<KomentarRealm> listkomentarNotSync = Collections.EMPTY_LIST;
    static int hasilList;

    KomentarRealm komentarRealm;

    @OnClick(R.id.btnKomentar)
    void saveDataToRealm(){
        komentarRealm = this.getUIData();
        if (komentarRealm == null) {
            Toast.makeText(this, "Silahkan isi data untuk menyimpan", Toast.LENGTH_SHORT).show();
        } else {
            this.saveData("insert");
        }
    }

    public static PostRealm dataPost;
    public static String idPost;

    public static Intent createIntent(Context context, String id) {
        idPost =id;
        return new Intent(context, DetailPostActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_post);

        //TODO: change this to Fragment
        ((MainApplication) getApplication())
                .getComponent()
                .inject(this);
        takedata();
        mController.setView(this);
        gController.setView(this);
        progressdialog = new ProgressDialog(this);

        mContext = this;
        linearLayoutManager = new LinearLayoutManager(mContext);

        realm.beginTransaction();
        listkomentarNotSync = realm.where(KomentarRealm.class).equalTo("isSync",0).findAll();
        realm.commitTransaction();

        hasilList = listkomentarNotSync.size();

        populateInitialData();

        ButterKnife.bind(this);
        setdata();
        checkDataRealm();
    }

    private void updateLayout(String status) {
        switch (status) {
            case Konstanta.LAYOUT_SUCCESS:
                spinner.setVisibility(View.GONE);
                tampungKomentar.setVisibility(View.VISIBLE);
                break;
            case Konstanta.LAYOUT_EMPTY:
                spinner.setText("No Data :( ");
                break;
            case Konstanta.LAYOUT_ERROR:
                spinner.setText("{fa-info 200%} Error");
                break;
            case Konstanta.LAYOUT_LOADING:
                tampungKomentar.setVisibility(View.GONE);
                spinner.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }

    private void populateInitialData(){
        realm.executeTransactionAsync(realm1 -> {
            listData = realm1.copyFromRealm(realm1.where(KomentarRealm.class)
                    .equalTo("hashPost", idPost)
                    .findAll());
        }, () -> {
            if (!listData.isEmpty()) {
                mAdapter = new KomentarAdapter(mContext, listData);
                tampungKomentar.setAdapter(mAdapter);
                tampungKomentar.setHasFixedSize(true);
                tampungKomentar.setLayoutManager(linearLayoutManager);
                updateLayout(Konstanta.LAYOUT_SUCCESS);
            }else {
                updateLayout(Konstanta.LAYOUT_EMPTY);
            }
        });
    }

    public KomentarRealm getUIData(){
        String strKomentar = textKomentar.getText().toString();
        String strTanggal = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        String strWaktu = new SimpleDateFormat("HH:mm:ss").format(new Date());

        KomentarRealm komentarRealm = new KomentarRealm();
        UserDB userDB = getData();
        if(userDB != null){
            int idDes;
            try {
                idDes =  Integer.valueOf(userDB.getAttributeValue());
            }catch (Exception e){
                idDes = 0;
            }
            String idUs;
            try {
                idUs =  userDB.getId();
            }catch (Exception e){
                idUs = "";
            }
            komentarRealm.setIdDesa(idDes);
            komentarRealm.setIdUser(idUs);
            komentarRealm.setNamaUser(userDB.getNamaLengkap());
            komentarRealm.setNama(userDB.getNamaDesa());
        }
        komentarRealm.setHashId(getSaltString());
        komentarRealm.setHashPost(DetailPostActivity.idPost);
        komentarRealm.setWaktu(strWaktu);
        komentarRealm.setTanggal(strTanggal);
        komentarRealm.setDeskripsi(strKomentar);
        komentarRealm.setIsSync(0);


        return komentarRealm;
    }

    public void saveData(String tipe) {
        if (tipe.equals("insert")) {
            mController.addItem(komentarRealm);
        } else {
            if (tipe.equals("update")) {

            }
        }
    }
    public UserDB getData() {
        realm.beginTransaction();
        UserDB user =realm.where(UserDB.class).findFirst();
        realm.commitTransaction();
        if(user == null){
            return null;
        }else{
            return user;
        }
    }
    private void takedata(){
        realm.beginTransaction();
        dataPost = realm.where(PostRealm.class).equalTo("hashId", idPost).findFirst();
        realm.commitTransaction();
    }
    private void setdata(){
        namaPetugas.setText(dataPost.getNamaUser());
        namaDesa.setText(dataPost.getNama());
        judul.setText(dataPost.getJudul());
        isi.setText(dataPost.getIsi());
        tanggal.setText(dataPost.getTanggal());
        waktu.setText(dataPost.getWaktu());
    }

    protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        return timeStamp + "" + salt.toString();
    }

    @Override
    public void showNotification(String title, String header, String message) {
        populateInitialData();
        Toast.makeText(mContext,"Komentar berhasil dimasukkan",Toast.LENGTH_LONG).show();
        textKomentar.setText("");
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private Snackbar createSnackbar(String message) {
        return Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_INDEFINITE)
                .setAction("REFRESH", v -> DetailPostActivity.this.recreate());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_eidu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_sync){
            if(isNetworkConnected()){
                syncDialog();
            }else {
                createSnackbar("Koneksi Tidak Tersedia").show();
            }
            return true;
        }
        if (id == R.id.action_download){
            if(isNetworkConnected()){
                createDownloadDialog();
            }else {
                createSnackbar("Koneksi Tidak Tersedia").show();
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void createDownloadDialog() {

        MaterialDialog dialog = new MaterialDialog.Builder(this)
                .title(R.string.title_download)
                .content(R.string.content_download)
                .positiveText(R.string.yes)
                .negativeText(R.string.no)
                .onPositive((dialog1, which) -> {
                    gController.getAllKomentar(idPost);
                    updateLayout(Konstanta.LAYOUT_LOADING);
                })
                .onNegative((dialog1, which) -> {

                })
                .build();
        dialog.show();
    }


    private void syncDialog() {
        MaterialDialog dialog = new MaterialDialog.Builder(this)
                .title(R.string.title_sync)
                .content(R.string.content_sync)
                .positiveText(R.string.yes)
                .negativeText(R.string.no)
                .onPositive((dialog1, which) -> {
                    progressdialog.show();
                    progressdialog.setCancelable(false);
                    progressdialog.setCanceledOnTouchOutside(false);
                    startSync();
                })
                .onNegative((dialog1, which) -> {

                })
                .build();
        dialog.show();
    }

    private void startSync(){
        counter=0;
        gController.saveData(listkomentarNotSync);
    }

    private void checkDataRealm(){
        if(hasilList > 0){
            showRealmData(""+hasilList).show();
        }
    }

    private Snackbar showRealmData(String message) {
        return Snackbar.make(coordinatorLayout, "Anda memiliki data target "+message+ " yang belum di backup", Snackbar.LENGTH_INDEFINITE);
    }

    @Override
    public void getAllKomentarSuccess(List<KomentarRealm> allKomentar) {
        populateInitialData();
    }

    @Override
    public void getAllKomentarFailed(String message) {
        createSnackbar(message).show();
        updateLayout(Konstanta.LAYOUT_ERROR);
    }

    @Override
    public void saveDataSuccess(String message) {
        counter++;
        if(counter == hasilList){
            progressdialog.dismiss();
            gController.getAllKomentar(idPost);
            updateLayout(Konstanta.LAYOUT_LOADING);
            this.recreate();
        }
    }

    @Override
    public void saveDataFailed(String message) {
        progressdialog.dismiss();
        onError(message);
    }
}
