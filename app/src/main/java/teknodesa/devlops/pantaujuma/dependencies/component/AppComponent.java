package teknodesa.devlops.pantaujuma.dependencies.component;

import javax.inject.Singleton;

import dagger.Component;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.components.home.HomeFragment;
import teknodesa.devlops.pantaujuma.components.home.HomeJumaFragment;
import teknodesa.devlops.pantaujuma.components.signin.LoginActivity;
import teknodesa.devlops.pantaujuma.components.signin.LoginController;
import teknodesa.devlops.pantaujuma.components.signup.RegisterActivity;
import teknodesa.devlops.pantaujuma.components.signup.RegisterController;
import teknodesa.devlops.pantaujuma.components.splashscreen.SplashscreenActivity;
import teknodesa.devlops.pantaujuma.components.splashscreen.SplashscreenController;
import teknodesa.devlops.pantaujuma.dependencies.modules.AppModule;
import teknodesa.devlops.pantaujuma.dependencies.modules.RealmModule;
import teknodesa.devlops.pantaujuma.dependencies.modules.WebServiceModule;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.LoginService;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.RegisterService;

@Singleton
@Component(modules = {AppModule.class, RealmModule.class, WebServiceModule.class})
public interface AppComponent {
    void inject(MainApplication app);

    //Service
    void inject(LoginService service);
    void inject(RegisterService service);

    //Controllers
    void inject(SplashscreenController controller);
    void inject(RegisterController controller);
    void inject(LoginController controller);

    //Activity
    void inject(SplashscreenActivity activity);
    void inject(LoginActivity activity);
    void inject(RegisterActivity activity);

    //fragment
    void inject(HomeFragment fragment);
    void inject(HomeJumaFragment fragment);
}
