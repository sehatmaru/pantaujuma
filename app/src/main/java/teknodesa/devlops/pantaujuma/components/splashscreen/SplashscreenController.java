package teknodesa.devlops.pantaujuma.components.splashscreen;

import android.support.annotation.NonNull;
import org.greenrobot.eventbus.EventBus;
import javax.inject.Inject;

import io.realm.Realm;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.UserDB;

/**
 * Created by Marthin on 2/11/2018.
 */

public class SplashscreenController implements SplashscreenContract.Controller {
    @Inject
    EventBus mBus;

    @Inject
    Realm realm;

    private SplashscreenContract.View views;

    //private FirebaseAuth mAuth;
    public SplashscreenController(@NonNull AppComponent appComponent) {
        appComponent.inject(this);
       // mAuth = FirebaseAuth.getInstance();
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
            views.sessionUser(true);
        }else{
            views.sessionUser(false);
        }
    }
}
