package teknodesa.devlops.pantaujuma.components.splashscreen;

import android.support.annotation.NonNull;
import javax.inject.Inject;
import io.realm.Realm;
import teknodesa.devlops.pantaujuma.components.signin.LoginContract;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.UserDB;
import teknodesa.devlops.pantaujuma.dependencies.webservices.PantauJumaAPI;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.PromoService;

/**
 * Created by Marthin on 2/11/2018.
 */

public class SplashscreenController implements SplashscreenContract.Controller {

    @Inject
    PantauJumaAPI pjApi;

    public LoginContract.Controller controller;

    @Inject
    PromoService mService;

    @Inject
    Realm realm;

    private SplashscreenContract.View views;

    //private FirebaseAuth mAuth;
    public SplashscreenController(@NonNull AppComponent appComponent) {
        appComponent.inject(this);
    }

    public void setView(SplashscreenContract.View view){
        views = view;
    }

    @Override
    public void checkSession() {
        realm.beginTransaction();
        UserDB user =realm.where(UserDB.class).findFirst();
        realm.commitTransaction();
        if(user == null){
            views.sessionUser(false);
        }else{
            views.sessionUser(true);
        }
    }

    @Override
    public void getInitializeData() {
        mService.instanceClass(this);
        mService.getInitializeData();
    }

    @Override
    public void getInitializeDataSuccess(String message) {
        views.getInitializeDataSuccess(message);
    }

    @Override
    public void getInitializeDataFailed(String message) {
        views.getInitializeDataFailed(message);
    }
}
