package teknodesa.devlops.pantaujuma.dependencies.component;

import javax.inject.Singleton;

import dagger.Component;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.components.splashscreen.SplashscreenController;
import teknodesa.devlops.pantaujuma.dependencies.modules.AppModule;
import teknodesa.devlops.pantaujuma.dependencies.modules.RealmModule;

@Singleton
@Component(modules = {AppModule.class, RealmModule.class})
public interface AppComponent {
    void inject(MainApplication app);

    //Controllers
    void inject(SplashscreenController controller);
}
