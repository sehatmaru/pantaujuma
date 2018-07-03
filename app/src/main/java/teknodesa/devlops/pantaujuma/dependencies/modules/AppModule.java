package teknodesa.devlops.pantaujuma.dependencies.modules;

import android.content.Context;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.components.alsintan.CRUAlsintanFragment;
import teknodesa.devlops.pantaujuma.components.harga.CRUHargaFragment;
import teknodesa.devlops.pantaujuma.components.home.HomeFragment;
import teknodesa.devlops.pantaujuma.components.home.HomeJumaFragment;
import teknodesa.devlops.pantaujuma.components.komoditas.CRUKomoditasFragment;
import teknodesa.devlops.pantaujuma.components.lahan.CRULahanFragment;
import teknodesa.devlops.pantaujuma.components.penduduk.CRUPendudukFragment;
import teknodesa.devlops.pantaujuma.components.petani.CRUPetaniFragment;
import teknodesa.devlops.pantaujuma.components.petani.CRUPoktanFragment;
import teknodesa.devlops.pantaujuma.components.petugas.CRUTargetPetugasFragment;
import teknodesa.devlops.pantaujuma.components.rdk.CRURDKFragment;
import teknodesa.devlops.pantaujuma.components.rdkk.CRURDKKPupukSubsidiFragment;
import teknodesa.devlops.pantaujuma.components.rktp.CRURKTPFragment;
import teknodesa.devlops.pantaujuma.components.signin.LoginController;
import teknodesa.devlops.pantaujuma.components.splashscreen.SplashscreenController;
import teknodesa.devlops.pantaujuma.components.survei.CRUSurveiFragment;
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
    LoginController loginController() {
        return new LoginController(app.getComponent());
    }


    ///////////////////////Activities


    /////Fragments
    @Provides
    @Singleton
    HomeFragment provideHomeFragment(){return new HomeFragment();}

    @Provides
    @Singleton
    HomeJumaFragment provideHomeJumaFragment(){return new HomeJumaFragment();}

    @Provides
    @Singleton
    CRUPendudukFragment provideCRUPendudukFragment(){return new CRUPendudukFragment();}

    @Provides
    @Singleton
    CRUPetaniFragment provideCRUPetaniFragment(){return new CRUPetaniFragment();}

    @Provides
    @Singleton
    CRUPoktanFragment provideCRUPoktanFragment(){return new CRUPoktanFragment();}

    @Provides
    @Singleton
    CRURDKFragment provideCRURDKFragment(){return new CRURDKFragment();}

    @Provides
    @Singleton
    CRURDKKPupukSubsidiFragment provideCRURDKKPupukSubsidiFragment(){return new CRURDKKPupukSubsidiFragment();}

    @Provides
    @Singleton
    CRURKTPFragment provideCRURKTPFragment(){return new CRURKTPFragment();}

    @Provides
    @Singleton
    CRUTargetPetugasFragment provideCRUTargetPetugasFragment(){return new CRUTargetPetugasFragment();}

    @Provides
    @Singleton
    CRULahanFragment provideCRULahanFragment(){return new CRULahanFragment();}

    @Provides
    @Singleton
    CRUKomoditasFragment provideCRUKomoditasFragment(){return new CRUKomoditasFragment();}

    @Provides
    @Singleton
    CRUAlsintanFragment provideCRUAlsintanFragment(){return new CRUAlsintanFragment();}

    @Provides
    @Singleton
    CRUHargaFragment provideCRUHargaFragment(){return new CRUHargaFragment();}

    @Provides
    @Singleton
    CRUSurveiFragment provideCRUSurveiFragment(){return new CRUSurveiFragment();}

}
