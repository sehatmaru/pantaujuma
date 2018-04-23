package teknodesa.devlops.pantaujuma.components.signup;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import onanteam.devlops.onan.di.component.AppComponent;
import onanteam.devlops.onan.di.models.RegisterModel;
import onanteam.devlops.onan.di.models.firebase.Saldo;
import onanteam.devlops.onan.di.models.firebase.user.User;
import onanteam.devlops.onan.service.RegisterService;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.firebase.RegisterModel;

/**
 * Created by Marthin on 2/10/2018.
 */

public class RegisterController implements RegisterContract.Controller {
    @Inject
    RegisterService mService;

    @Inject
    EventBus mBus;

    private RegisterContract.View views;

    private FirebaseAuth mAuth;
    private Context mContext;

    public RegisterController(@NonNull AppComponent appComponent) {
        appComponent.inject(this);
        mAuth = FirebaseAuth.getInstance();
    }


    public void onResume() {
        mBus.register(this);
    }
    public void onPause(){
        mBus.unregister(this);
    }

    public void setView(RegisterContract.View view,Context mContext){
        views = view;
        this.mContext =mContext;
    }




    @Override
    public void registerUser(RegisterModel registerModel) {
        mAuth.createUserWithEmailAndPassword(registerModel.getEmail(),registerModel.getPassword())
                .addOnCompleteListener((Activity)mContext, task -> {
                    if (task.isSuccessful()) {

                        mAuth.getCurrentUser().sendEmailVerification()
                                .addOnCompleteListener((Activity)mContext, (OnCompleteListener) task1 -> {
                                    if (task1.isSuccessful()) {
                                        RegisterModel re = new RegisterModel();
                                        re.setEmail(registerModel.getEmail());
                                        re.setNamaLengkap(registerModel.getNamaLengkap());
                                        re.setPassword(mAuth.getCurrentUser().getUid());
                                        mService.instanceClass(this);
                                        mService.registerUser(re);
                                        Log.e("Here","Success");
                                    } else {
                                        Log.e("error","error occured");
                                        views.registerFailed("Error Occured for sending mail. Please Contact Administrator for continue");
                                    }
                                });
                    } else {
                        views.registerFailed(task.getException().getMessage());
                    }
                });
    }

    @Override
    public void registerSuccess(String message) {
        views.registerSuccess("Please check email for confirmation Account");
    }

    @Override
    public void registerFailed(String message) {
        views.registerFailed(message);
    }
}
