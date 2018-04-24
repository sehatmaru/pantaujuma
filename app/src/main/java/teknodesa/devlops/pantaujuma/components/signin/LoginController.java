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

    private FirebaseAuth mAuth;
    private Context mContext;
    public LoginController(@NonNull AppComponent appComponent) {
        appComponent.inject(this);
        mAuth = FirebaseAuth.getInstance();
    }


    public void onResume() {
        mBus.register(this);
    }
    public void onPause(){
        mBus.unregister(this);
    }

    public void setView(LoginContract.View view,Context mContext){
        views = view;
        this.mContext =mContext;
    }

    @Override
    public void loginUser(LoginModel loginModel) {
        mAuth.signInWithEmailAndPassword(loginModel.getEmail(),loginModel.getPassword())
                .addOnCompleteListener((Activity) mContext, task -> {

                    if (!task.isSuccessful()) {
                        views.loginFailed("Error :"+task.getException().getMessage());
                    } else {
                        LoginModel log = new LoginModel(loginModel.getEmail(), mAuth.getCurrentUser().getUid());
                        mService.instanceClass(this);
                        mService.loginUser(log);
                    }
                });
    }

    @Override
    public void loginSuccess(String message) {
        views.loginSuccess(message);
    }

    @Override
    public void loginFailed(String message) {
        mAuth.signOut();
        views.loginFailed(message);
    }
}
