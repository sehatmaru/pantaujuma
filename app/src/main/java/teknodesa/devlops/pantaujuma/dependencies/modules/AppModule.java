package teknodesa.devlops.pantaujuma.dependencies.modules;

import android.content.Context;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.components.signin.LoginController;
import teknodesa.devlops.pantaujuma.components.signup.RegisterController;
import teknodesa.devlops.pantaujuma.components.splashscreen.SplashscreenController;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.LoginService;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.RegisterService;

@Module
public class AppModule {
    private MainApplication app;
    public AppModule(MainApplication app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return app;
    }

    @Provides
    @Singleton
    EventBus eventBus() {
        return EventBus.getDefault();
    }

    ///////////////////////Services
    @Provides
    @Singleton
    RegisterService registerService() {
        return new RegisterService(app.getComponent());
    }

    @Provides
    @Singleton
    LoginService loginService() {
        return new LoginService(app.getComponent());
    }

    ///////////////////////Controllers
    @Provides
    @Singleton
    SplashscreenController splashController() {
        return new SplashscreenController(app.getComponent());
    }

    @Provides
    @Singleton
    RegisterController registerController() {
        return new RegisterController(app.getComponent());
    }

    @Provides
    @Singleton
    LoginController loginController() {
        return new LoginController(app.getComponent());
    }


    ///////////////////////Activities

}
