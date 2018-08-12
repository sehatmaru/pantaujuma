package teknodesa.devlops.pantaujuma.components.profile;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import io.realm.Realm;
import io.realm.RealmResults;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.signin.LoginActivity;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.UserDB;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class AkunFragment extends Fragment implements ProfileContract.View{

    @Inject
    ProfileController controller;

    @Inject
    Realm realm;

    @BindView(R.id.edit)
    ImageView edit;
    @OnClick(R.id.edit)
    void clickEdit(){
//        startActivity(UpdateProfileActivity.createIntent(getActivity().getApplicationContext()));
//        getActivity().overridePendingTransition(R.transition.slide_up, R.transition.transition_do_nothing);
    }
    @BindView(R.id.buttonLogOut)
    Button buttonLogout;
    @OnClick(R.id.buttonLogOut)
    void clickSignOut(){
        syncDialog();
    }

    @BindView(R.id.profile)
    CircleImageView profileImage;
    @OnClick(R.id.profile)
    void clickProfilePhoto(){
//        startActivity(PreviewActivity.createIntent(getActivity().getApplicationContext(),userDB.getProfileImage()));
    }

    @BindView(R.id.fullNameDetail)
    TextView fullNameDetail;

    @BindView(R.id.emailUser)
    TextView emailUser;

    @BindView(R.id.nameUser)
    TextView nameUser;

    @BindView(R.id.progressOnanPay)
    ProgressBar progressOnanPay;

    @BindView(R.id.desa)
    TextView desa;

    @BindView(R.id.progressOnanPoint)
    ProgressBar progressOnanPoint;

    @BindView(R.id.resultPhone)
    TextView phoneNumber;

    Context mContext;
    //private String idUser;
    private UserDB userDB;

    public static String idUser;
    public static String namaUser;
    public static String kecamatanUser;
    public static String kabupatenKotaUser;
    public static String desaUser;
    public static String provinsiUser;
    public static int idDesa;
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

        View rootView = inflater.inflate(R.layout.fragment_akun, null);
        ButterKnife.bind(this,rootView);
        setHasOptionsMenu(true);

        return rootView;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mContext = getActivity().getApplicationContext();
        controller.setView(this);
        controller.getProfileUser();

    }
    private void signOut(){

        realm.beginTransaction();
        RealmResults<UserDB> users =realm.where(UserDB.class).findAll();
        users.deleteAllFromRealm();
        realm.commitTransaction();

        this.getActivity().finish();
        startActivity(LoginActivity.createIntent(getActivity().getApplicationContext()));
        Toast.makeText(getActivity().getApplicationContext(), "Logout Successfully", Toast.LENGTH_LONG).show();
    }
    private void syncDialog() {
        MaterialDialog dialog = new MaterialDialog.Builder(getActivity())
                .title(R.string.title_logout)
                .content(R.string.content_logout)
                .positiveText(R.string.yes)
                .negativeText(R.string.no)
                .onPositive((dialog1, which) -> {
                    signOut();
                })
                .onNegative((dialog1, which) -> {

                })
                .build();
        dialog.show();
    }

    @Override
    public void getProfileUserSuccess(UserDB userRealm) {
        this.userDB = userRealm;
        emailUser.setText(userDB.getEmail());
        nameUser.setText(userDB.getNamaLengkap());
        fullNameDetail.setText(userDB.getNamaLengkap());
        phoneNumber.setText(userDB.getPhoneNumber());
        desa.setText(userDB.getNamaDesa());
    }

    @Override
    public void getProfileUserFailed(String message) {
        Toast.makeText(mContext, "Something Wrong :"+message, Toast.LENGTH_SHORT).show();
    }
}
