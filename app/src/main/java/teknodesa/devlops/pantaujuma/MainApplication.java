package teknodesa.devlops.pantaujuma;

import android.app.Application;

import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.joanzapata.iconify.fonts.IoniconsModule;
import com.joanzapata.iconify.fonts.TypiconsModule;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.component.DaggerAppComponent;
import teknodesa.devlops.pantaujuma.dependencies.modules.AppModule;

public class MainApplication extends Application {
    private AppComponent mComponent;
    private final static int SCHEMA_VERSION = 1;

    @Override public void onCreate() {
        super.onCreate();
        initRealmConfiguration();
        initIconConfiguration();
        mComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    private void initIconConfiguration(){
        Iconify
                .with(new FontAwesomeModule())
                .with(new TypiconsModule())
                .with(new IoniconsModule());
    }
    private void initRealmConfiguration() {
        Realm.init(this);
        RealmConfiguration realmConfig = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .schemaVersion(SCHEMA_VERSION)
                .build();
        Realm.setDefaultConfiguration(realmConfig);
    }
}
