package teknodesa.devlops.pantaujuma.dependencies.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import teknodesa.devlops.pantaujuma.MainApplication;

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
}
