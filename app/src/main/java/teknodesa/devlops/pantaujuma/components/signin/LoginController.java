package teknodesa.devlops.pantaujuma.components.signin;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.LoginModel;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.LoginService;


/**
 * Created by Marthin on 2/11/2018.
 */

public class LoginController implements LoginContract.Controller {
    @Inject
    LoginService mService;

    @Inject
    EventBus mBus;

    private LoginContract.View views;

    public LoginController(@NonNull AppComponent appComponent) {
        appComponent.inject(this);
    }

    public void setView(LoginContract.View view){
        views = view;
    }

    @Override
    public void loginUser(LoginModel loginModel) {
        mService.instanceClass(this);
        mService.loginUser(loginModel);
    }

    @Override
    public void loginSuccess(String message) {
        views.loginSuccess(message);
    }

    @Override
    public void loginFailed(String message) {
        views.loginFailed(message);
    }
}
