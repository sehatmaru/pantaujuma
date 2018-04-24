package teknodesa.devlops.pantaujuma.components.signup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.base.BaseActivity;
import teknodesa.devlops.pantaujuma.components.signin.LoginActivity;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.RegisterModel;

public class RegisterActivity extends BaseActivity implements RegisterContract.View{
    @Inject
    RegisterController mUserController;

    @BindView(R.id.idLinear)
    LinearLayout linearLayout;
    @BindView(R.id.retNamaLengkap)
    TextInputEditText retNamaLengkap;
    @BindView(R.id.retPhoneNumber)
    TextInputEditText retPhoneNumber;

    @BindView(R.id.retEmail)
    TextInputEditText retEmail;
    @BindView(R.id.retPassword)
    TextInputEditText retPassword;
    @BindView(R.id.reTypePassword)
    TextInputEditText reTypePassword;
    @BindView(R.id.btnSignup)
    Button btnSignup;
    @OnClick(R.id.btnSignup)
    void registerClicked(){
        if(TextUtils.isEmpty(retEmail.getText().toString())){
            retEmail.setError(getString(R.string.error_email_kosong));
        }else if(TextUtils.isEmpty(retPassword.getText().toString())){
            retPassword.setError(getString(R.string.error_password_kosong));
        }else if(TextUtils.isEmpty(retPhoneNumber.getText().toString())){
            retPhoneNumber.setError("Phone Number tidak boleh Kosong");
        }else if(TextUtils.isEmpty(retNamaLengkap.getText().toString())){
            retNamaLengkap.setError(getString(R.string.error_nama_kosong));
        }else if(retPassword.getText().toString().compareTo(reTypePassword.getText().toString())!= 0){
            reTypePassword.setError(getString(R.string.error_password_tidak_sesuai));
        }else{
            if(isNetworkConnected()){
                showLoading();
                RegisterModel reg =new RegisterModel(retNamaLengkap.getText().toString(),retEmail.getText().toString(),retPassword.getText().toString(),retPhoneNumber.getText().toString());
                mUserController.setView(this,mContext);
                mUserController.registerUser(reg);
            }else{
                onError("No Internet Connection");
            }
        }
    }

    @BindView(R.id.btn_back)
    Button btnBack;
    @OnClick(R.id.btn_back)
    void backClick(){
        finish();
        overridePendingTransition(R.transition.slide_bot, R.transition.transition_do_nothing);
    }

    Context mContext;
    public static Intent createIntent(Context context) {
        return new Intent(context, RegisterActivity.class);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ((MainApplication) getApplication())
                .getComponent()
                .inject(this);
        ButterKnife.bind(this);
        mContext = this;
    }



    @Override
    public void registerSuccess(String message) {
        hideLoading();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        startActivity(LoginActivity.createIntent(getApplicationContext()));
    }

    @Override
    public void registerFailed(String message) {
        hideLoading();
        onError(message);
    }
}
