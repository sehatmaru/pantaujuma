package teknodesa.devlops.pantaujuma.dependencies.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.components.alsintan.GetAlsintanController;
import teknodesa.devlops.pantaujuma.components.harga.CRUHargaFragment;
import teknodesa.devlops.pantaujuma.components.harga.GetHargaController;
import teknodesa.devlops.pantaujuma.components.home.HomeController;
import teknodesa.devlops.pantaujuma.components.home.HomeFragment;
import teknodesa.devlops.pantaujuma.components.komoditas.CRUKomoditasFragment;
import teknodesa.devlops.pantaujuma.components.komoditas.KomoditasController;
import teknodesa.devlops.pantaujuma.components.komoditas.KomoditasFragment;
import teknodesa.devlops.pantaujuma.components.lahan.CRULahanFragment;
import teknodesa.devlops.pantaujuma.components.lahan.GetLahanController;
import teknodesa.devlops.pantaujuma.components.lahan.ListLahanKomoditasController;
import teknodesa.devlops.pantaujuma.components.penduduk.form.AlamatFragment;
import teknodesa.devlops.pantaujuma.components.penduduk.form.BiodataFragment;
import teknodesa.devlops.pantaujuma.components.penduduk.form.CRUPendudukFragment;
import teknodesa.devlops.pantaujuma.components.penduduk.GetPendudukController;
import teknodesa.devlops.pantaujuma.components.petani.CRUPetaniFragment;
import teknodesa.devlops.pantaujuma.components.petani.GetPetaniController;
import teknodesa.devlops.pantaujuma.components.petugas.CRUTargetPetugasFragment;
import teknodesa.devlops.pantaujuma.components.petugas.GetTargetController;
import teknodesa.devlops.pantaujuma.components.poktan.CRUIdentitasPoktanFragment;
import teknodesa.devlops.pantaujuma.components.poktan.CRUPengurusPoktanFragment;
import teknodesa.devlops.pantaujuma.components.poktan.GetAnggotaPoktanController;
import teknodesa.devlops.pantaujuma.components.poktan.GetPengurusPoktanController;
import teknodesa.devlops.pantaujuma.components.poktan.GetPoktanController;
import teknodesa.devlops.pantaujuma.components.poktan.CRUAnggotaPoktanFragment;
import teknodesa.devlops.pantaujuma.components.post.CRUPostFragment;
import teknodesa.devlops.pantaujuma.components.post.GetKomentarController;
import teknodesa.devlops.pantaujuma.components.post.GetPostController;
import teknodesa.devlops.pantaujuma.components.post.KomentarController;
import teknodesa.devlops.pantaujuma.components.post.KomentarRepository;
import teknodesa.devlops.pantaujuma.components.post.PostFragment;
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
import teknodesa.devlops.pantaujuma.components.signin.UserRealmController;
import teknodesa.devlops.pantaujuma.components.splashscreen.SplashscreenController;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.GetAlsintanService;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.GetAnggotaPoktanService;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.GetHargaService;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.GetKomentarService;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.GetLahanService;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.GetPendudukService;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.GetPengurusPoktanService;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.GetPetaniService;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.GetPoktanService;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.GetPostService;
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

    //Services
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
    GetAnggotaPoktanService getAnggotaPoktanService() {
        return new GetAnggotaPoktanService(app.getComponent());
    }

    @Provides
    @Singleton
    GetKomentarService getKomentarService() {
        return new GetKomentarService(app.getComponent());
    }

    @Provides
    @Singleton
    GetPengurusPoktanService getPengurusPoktanService() {
        return new GetPengurusPoktanService(app.getComponent());
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
    GetAlsintanService getAlsintanService() {
        return new GetAlsintanService(app.getComponent());
    }

    @Provides
    @Singleton
    GetLahanService getLahanService() {
        return new GetLahanService(app.getComponent());
    }

    @Provides
    @Singleton
    GetHargaService getHargaService() {
        return new GetHargaService(app.getComponent());
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

    @Provides
    @Singleton
    GetPostService getPostService() {
        return new GetPostService(app.getComponent());
    }

    //Controllers
    @Provides
    @Singleton
    KomoditasController komoditasController() {
        return new KomoditasController(app.getComponent());
    }

    @Provides
    @Singleton
    GetKomentarController getKomentarController() {
        return new GetKomentarController(app.getComponent());
    }

    @Provides
    @Singleton
    GetPendudukController getPendudukController() {
        return new GetPendudukController(app.getComponent());
    }

    @Provides
    @Singleton
    KomentarController komentarController() {
        return new KomentarController(app.getComponent());
    }

    @Provides
    @Singleton
    GetPostController getPostController() {
        return new GetPostController(app.getComponent());
    }


    @Provides
    @Singleton
    GetAnggotaPoktanController getAnggotaPoktanController() {
        return new GetAnggotaPoktanController(app.getComponent());
    }

    @Provides
    @Singleton
    GetPengurusPoktanController getPengurusPoktanController() {
        return new GetPengurusPoktanController(app.getComponent());
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
    GetHargaController getHargaController() {
        return new GetHargaController(app.getComponent());
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
    GetLahanController getLahanController() {
        return new GetLahanController(app.getComponent());
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
    GetAlsintanController getAlsintanController() {
        return new GetAlsintanController(app.getComponent());
    }

    @Provides
    @Singleton
    ListLahanKomoditasController listLahanKomoditasController() {
        return new ListLahanKomoditasController(app.getComponent());
    }

    //Repository
    @Provides
    @Singleton
    KomentarRepository komentarRepository() {
        return new KomentarRepository(app.getComponent());
    }

    //Activities

    //Fragments
    @Provides
    @Singleton
    KomoditasFragment komoditasFragment(){return new KomoditasFragment();}

    @Provides
    @Singleton
    HomeFragment provideHomeFragment(){return new HomeFragment();}

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
    CRUPostFragment provideCRUPostFragment(){return new CRUPostFragment();}

    @Provides
    @Singleton
    PostFragment providePostFragment(){return new PostFragment();}

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
    CRUIdentitasPoktanFragment provideIdentitasPoktanFragment(){return new CRUIdentitasPoktanFragment();}

    @Provides
    @Singleton
    CRUAnggotaPoktanFragment provideAnggotaPoktanFragment(){return new CRUAnggotaPoktanFragment();}

    @Provides
    @Singleton
    CRUPengurusPoktanFragment providePengurusPoktanFragment(){return new CRUPengurusPoktanFragment();}

    @Provides
    @Singleton
    CRULahanFragment provideCRULahanFragment(){return new CRULahanFragment();}

    @Provides
    @Singleton
    CRUKomoditasFragment provideCRUKomoditasFragment(){return new CRUKomoditasFragment();}

    @Provides
    @Singleton
    CRUHargaFragment provideCRUHargaFragment(){return new CRUHargaFragment();}

    @Provides
    @Singleton
    UserRealmController userRealmController(){return new UserRealmController(app.getComponent());}

}
