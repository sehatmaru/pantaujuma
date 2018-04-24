package teknodesa.devlops.pantaujuma.components.signin;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.MainActivity;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.components.base.BaseActivity;
import teknodesa.devlops.pantaujuma.components.resetpassword.ResetPasswordActivity;
import teknodesa.devlops.pantaujuma.components.signup.RegisterActivity;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.LoginModel;

public class LoginActivity extends BaseActivity implements LoginContract.View{
    @Inject
    LoginController loginController;

    @BindView(R.id.etEmail)
    TextInputEditText etEmail;
    @BindView(R.id.etPassword)
    TextInputEditText etPassword;
    @BindView(R.id.btn_reset_password)
    Button btnReset;
    @OnClick(R.id.btn_reset_password)
    void resetClicked(){
        startActivity(ResetPasswordActivity.createIntent(getApplicationContext()));
    }
    @BindView(R.id.btnLogin)
    Button btnLogin;
    @OnClick(R.id.btnLogin)
    void loginClicked(){
        if(TextUtils.isEmpty(etEmail.getText().toString())){
            etEmail.setError(getString(R.string.error_email));
        }else{
            if(isNetworkConnected()){
                showLoading();
                LoginModel loginModel = new LoginModel(etEmail.getText().toString(),etPassword.getText().toString());
                loginController.setView(this,this);
                loginController.loginUser(loginModel);
            }else {
                onError("No Internet Connection");
            }
        }

    }

    @BindView(R.id.btnRegister)
    Button btnRegister;
    @OnClick(R.id.btnRegister)
    void registerClicked(){
        startActivity(RegisterActivity.createIntent(getApplicationContext()));
        overridePendingTransition(R.transition.fade_in, R.transition.transition_do_nothing);
    }
    public static Intent createIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ((MainApplication) getApplication())
                .getComponent()
                .inject(this);
        ButterKnife.bind(this);
    }

    @Override
    public void loginSuccess(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        startActivity(MainActivity.createIntent(getApplicationContext()));
        overridePendingTransition(R.transition.fade_out, R.transition.transition_do_nothing);
    }

    @Override
    public void loginFailed(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        hideLoading();
    }
}
