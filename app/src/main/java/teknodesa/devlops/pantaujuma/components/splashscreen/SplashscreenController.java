package teknodesa.devlops.pantaujuma.components.splashscreen;

import android.support.annotation.NonNull;
import org.greenrobot.eventbus.EventBus;
import javax.inject.Inject;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;

/**
 * Created by Marthin on 2/11/2018.
 */

public class SplashscreenController implements SplashscreenContract.Controller {
    @Inject
    EventBus mBus;

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
    public void isLogin() {

    }
}
