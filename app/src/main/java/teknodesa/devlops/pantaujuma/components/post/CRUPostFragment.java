package teknodesa.devlops.pantaujuma.components.post;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import io.realm.Realm;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.CRUActivity;
import teknodesa.devlops.pantaujuma.components.profile.AkunFragment;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.PostRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.UserDB;

public class CRUPostFragment extends Fragment implements CRUPostContract.ViewController<PostRealm>, CRUPostContract.View{

    @BindView(R.id.input_judul)
    EditText input_judul;

    @BindView(R.id.input_isi)
    EditText input_isi;

    private AppComponent appComponent;
    FragmentActivity activity;

    @Inject
    Realm realm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();

        appComponent = ((MainApplication) getActivity().getApplication()).getComponent();
        appComponent.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_crupost, container, false);
        ButterKnife.bind(this, v);

        return v;
    }

    @Override
    public PostRealm getUIData() {
        String strJudul = input_judul.getText().toString();
        String strIsi = input_isi.getText().toString();
        String strTanggal = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        String strWaktu = new SimpleDateFormat("HH:mm:ss").format(new Date());

        PostRealm newRealmItem = new PostRealm();
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
            newRealmItem.setIdDesa(idDes);
            newRealmItem.setIdUser(idUs);
            newRealmItem.setNamaUser(userDB.getNamaLengkap());
            newRealmItem.setNama(userDB.getNamaDesa());
        }



        newRealmItem.setHashId(getSaltString());
        newRealmItem.setJudul(strJudul);
        newRealmItem.setIsi(strIsi);
        newRealmItem.setTanggal(strTanggal);
        newRealmItem.setWaktu(strWaktu);
        newRealmItem.setTipePost("post");
        newRealmItem.setThumbnail("0");
        newRealmItem.setViewCount(0);
        newRealmItem.setLikes(0);
        newRealmItem.setDislike(0);
        newRealmItem.setIsSync(0);

        return newRealmItem;
    }

    @Override
    public void setUIData() {

    }

    @Override
    public void saveData(String tipe, Parcelable itemData) {
        CRUPostContract.Controller<PostRealm> mController = new CRUPostController(this, appComponent);
        PostRealm uiItem = getUIData();

        if (tipe.equals("insert")) {
            mController.addItem(uiItem);
        } else {
            if (tipe.equals("update")) {
//                String idItem = ((RKTP) itemData).getHashId();
//                mController.updateItem(idItem, uiItem);
            }
        }
    }

    @Override
    public void showNotification(String title, String header, String message) {
        Toast.makeText(CRUActivity.mContext, message, Toast.LENGTH_SHORT).show();
//        startActivity(ListPostActivity.createIntent(CRUActivity.mContext));
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment) {
            mFragmentList.add(fragment);
        }
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

}
