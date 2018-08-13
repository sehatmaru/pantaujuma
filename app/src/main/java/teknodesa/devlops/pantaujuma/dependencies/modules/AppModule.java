package teknodesa.devlops.pantaujuma.dependencies.modules;

import android.content.Context;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.components.alsintan.CRUAlsintanFragment;
import teknodesa.devlops.pantaujuma.components.harga.CRUHargaFragment;
import teknodesa.devlops.pantaujuma.components.home.HomeController;
import teknodesa.devlops.pantaujuma.components.home.HomeFragment;
import teknodesa.devlops.pantaujuma.components.komoditas.CRUKomoditasFragment;
import teknodesa.devlops.pantaujuma.components.komoditas.KomoditasController;
import teknodesa.devlops.pantaujuma.components.komoditas.KomoditasFragment;
import teknodesa.devlops.pantaujuma.components.lahan.CRULahanFragment;
import teknodesa.devlops.pantaujuma.components.lahan.ListLahanKomoditasController;
import teknodesa.devlops.pantaujuma.components.penduduk.AlamatFragment;
import teknodesa.devlops.pantaujuma.components.penduduk.BiodataFragment;
import teknodesa.devlops.pantaujuma.components.penduduk.CRUPendudukFragment;
import teknodesa.devlops.pantaujuma.components.penduduk.GetPendudukController;
import teknodesa.devlops.pantaujuma.components.penduduk.PendudukFragment;
import teknodesa.devlops.pantaujuma.components.petani.CRUPetaniFragment;
import teknodesa.devlops.pantaujuma.components.petani.GetPetaniController;
import teknodesa.devlops.pantaujuma.components.petugas.CRUTargetPetugasFragment;
import teknodesa.devlops.pantaujuma.components.petugas.GetTargetController;
import teknodesa.devlops.pantaujuma.components.poktan.CRUPoktanFragment;
import teknodesa.devlops.pantaujuma.components.poktan.GetPoktanController;
import teknodesa.devlops.pantaujuma.components.poktan.form.AnggotaPoktanFragment;
import teknodesa.devlops.pantaujuma.components.poktan.form.IdentitasPoktanFragment;
import teknodesa.devlops.pantaujuma.components.poktan.form.PengurusPoktanFragment;
import teknodesa.devlops.pantaujuma.components.profile.AkunFragment;
import teknodesa.devlops.pantaujuma.components.profile.ProfileController;
import teknodesa.devlops.pantaujuma.components.rdk.CRURDKFragment;
import teknodesa.devlops.pantaujuma.components.rdk.GetRDKController;
import teknodesa.devlops.pantaujuma.components.rdk.form.RDKIdentitasFragment;
import teknodesa.devlops.pantaujuma.components.rdk.form.RDKIrigasiFragment;
import teknodesa.devlops.pantaujuma.components.rdk.form.RDKJadwalKegiatanFragment;
import teknodesa.devlops.pantaujuma.components.rdk.form.RDKRencanaUmumFragment;
import teknodesa.devlops.pantaujuma.components.rdk.form.RDKSasaranIntensifikasiFragment;
import teknodesa.devlops.pantaujuma.components.rdkk.CRURDKKPupukSubsidiFragment;
import teknodesa.devlops.pantaujuma.components.rdkk.GetRDKKController;
import teknodesa.devlops.pantaujuma.components.rktp.CRURKTPFragment;
import teknodesa.devlops.pantaujuma.components.rktp.GetRKTPController;
import teknodesa.devlops.pantaujuma.components.signin.LoginController;
import teknodesa.devlops.pantaujuma.components.splashscreen.SplashscreenController;
import teknodesa.devlops.pantaujuma.components.survei.CRUSurveiFragment;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.GetPendudukService;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.GetPetaniService;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.GetPoktanService;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.GetRDKKService;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.GetRDKService;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.GetRKTPService;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.GetTargetService;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.KomoditasService;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.ListLahanKomoditasService;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.LoginService;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.PromoService;

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
    ListLahanKomoditasService listLahanKomoditasService() {
        return new ListLahanKomoditasService(app.getComponent());
    }

    @Provides
    @Singleton
    LoginService loginService() {
        return new LoginService(app.getComponent());
    }

    @Provides
    @Singleton
    PromoService promoService() {
        return new PromoService(app.getComponent());
    }

    @Provides
    @Singleton
    GetPendudukService getPendudukService() {
        return new GetPendudukService(app.getComponent());
    }

    @Provides
    @Singleton
    GetPetaniService getPetaniService() {
        return new GetPetaniService(app.getComponent());
    }

    @Provides
    @Singleton
    GetPoktanService getPoktanService() {
        return new GetPoktanService(app.getComponent());
    }

    @Provides
    @Singleton
    GetRKTPService getRKTPService() {
        return new GetRKTPService(app.getComponent());
    }

    @Provides
    @Singleton
    GetTargetService getTargetService() {
        return new GetTargetService(app.getComponent());
    }

    @Provides
    @Singleton
    GetRDKService getRDKService() {
        return new GetRDKService(app.getComponent());
    }

    @Provides
    @Singleton
    GetRDKKService getRDKKService() {
        return new GetRDKKService(app.getComponent());
    }

    @Provides
    @Singleton
    KomoditasService komoditasService() {
        return new KomoditasService(app.getComponent());
    }

    ///////////////////////Controllers
    @Provides
    @Singleton
    KomoditasController komoditasController() {
        return new KomoditasController(app.getComponent());
    }

    @Provides
    @Singleton
    GetPendudukController getPendudukController() {
        return new GetPendudukController(app.getComponent());
    }

    @Provides
    @Singleton
    GetRDKController getRDKController() {
        return new GetRDKController(app.getComponent());
    }

    @Provides
    @Singleton
    GetRDKKController getRDKKController() {
        return new GetRDKKController(app.getComponent());
    }

    @Provides
    @Singleton
    GetPoktanController getPoktanController() {
        return new GetPoktanController(app.getComponent());
    }

    @Provides
    @Singleton
    GetRKTPController getRKTPController() {
        return new GetRKTPController(app.getComponent());
    }

    @Provides
    @Singleton
    GetTargetController getTargetController() {
        return new GetTargetController(app.getComponent());
    }

    @Provides
    @Singleton
    SplashscreenController splashController() {
        return new SplashscreenController(app.getComponent());
    }

    @Provides
    @Singleton
    ProfileController profileController() {
        return new ProfileController(app.getComponent());
    }


    @Provides
    @Singleton
    LoginController loginController() {
        return new LoginController(app.getComponent());
    }

    @Provides
    @Singleton
    HomeController homeController() {
        return new HomeController(app.getComponent());
    }

    @Provides
    @Singleton
    GetPetaniController getPetaniController() {
        return new GetPetaniController(app.getComponent());
    }

    @Provides
    @Singleton
    ListLahanKomoditasController listLahanKomoditasController() {
        return new ListLahanKomoditasController(app.getComponent());
    }

    ///////////////////////Activities///

    /////Fragments
    @Provides
    @Singleton
    KomoditasFragment komoditasFragment(){return new KomoditasFragment();}

    @Provides
    @Singleton
    HomeFragment provideHomeFragment(){return new HomeFragment();}


    @Provides
    @Singleton
    PendudukFragment providePendudukFragment(){return new PendudukFragment();}

    @Provides
    @Singleton
    AkunFragment akunFragment(){return new AkunFragment();}
    @Provides
    @Singleton
    BiodataFragment provideBiodataFragment(){return new BiodataFragment();}

    @Provides
    @Singleton
    AlamatFragment provideAlamatFragment(){return new AlamatFragment();}

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
    RDKIdentitasFragment provideRDKIdentitasFragment(){return new RDKIdentitasFragment();}

    @Provides
    @Singleton
    RDKIrigasiFragment provideRDKIrigasiFragment(){return new RDKIrigasiFragment();}

    @Provides
    @Singleton
    RDKJadwalKegiatanFragment provideRDKJadwalKegiatanFragment(){return new RDKJadwalKegiatanFragment();}

    @Provides
    @Singleton
    RDKRencanaUmumFragment provideRDKRencanaUmumFragment(){return new RDKRencanaUmumFragment();}

    @Provides
    @Singleton
    RDKSasaranIntensifikasiFragment provideRDKSaranaIntensifikasiFragment(){return new RDKSasaranIntensifikasiFragment();}

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
    IdentitasPoktanFragment provideIdentitasPoktanFragment(){return new IdentitasPoktanFragment();}

    @Provides
    @Singleton
    AnggotaPoktanFragment provideAnggotaPoktanFragment(){return new AnggotaPoktanFragment();}

    @Provides
    @Singleton
    PengurusPoktanFragment providePengurusPoktanFragment(){return new PengurusPoktanFragment();}

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
