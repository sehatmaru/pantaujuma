package teknodesa.devlops.pantaujuma.dependencies.component;

import javax.inject.Singleton;

import dagger.Component;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.components.CRUActivity;
import teknodesa.devlops.pantaujuma.components.MainActivity;
import teknodesa.devlops.pantaujuma.components.alsintan.CRUAlsintanFragment;
import teknodesa.devlops.pantaujuma.components.alsintan.ListAlsintanActivity;
import teknodesa.devlops.pantaujuma.components.harga.CRUHargaFragment;
import teknodesa.devlops.pantaujuma.components.harga.ListHargaActivity;
import teknodesa.devlops.pantaujuma.components.home.HomeFragment;
import teknodesa.devlops.pantaujuma.components.home.HomeJumaFragment;
import teknodesa.devlops.pantaujuma.components.komoditas.CRUKomoditasFragment;
import teknodesa.devlops.pantaujuma.components.komoditas.ListKomoditasActivity;
import teknodesa.devlops.pantaujuma.components.lahan.CRULahanFragment;
import teknodesa.devlops.pantaujuma.components.lahan.ListLahanActivity;
import teknodesa.devlops.pantaujuma.components.penduduk.CRUPendudukFragment;
import teknodesa.devlops.pantaujuma.components.penduduk.DetailPendudukActivity;
import teknodesa.devlops.pantaujuma.components.penduduk.ListPendudukActivity;
import teknodesa.devlops.pantaujuma.components.penduduk.PendudukController;
import teknodesa.devlops.pantaujuma.components.penduduk.PendudukRepository;
import teknodesa.devlops.pantaujuma.components.petani.CRUPetaniFragment;
import teknodesa.devlops.pantaujuma.components.petani.CRUPoktanFragment;
import teknodesa.devlops.pantaujuma.components.petani.ListPetaniActivity;
import teknodesa.devlops.pantaujuma.components.petani.ListPetaniRepository;
import teknodesa.devlops.pantaujuma.components.petani.ListPoktanActivity;
import teknodesa.devlops.pantaujuma.components.petugas.CRUTargetPetugasFragment;
import teknodesa.devlops.pantaujuma.components.petugas.ListTargetActivity;
import teknodesa.devlops.pantaujuma.components.rdk.CRURDKFragment;
import teknodesa.devlops.pantaujuma.components.rdk.ListRDKActivity;
import teknodesa.devlops.pantaujuma.components.rdkk.CRURDKKPupukSubsidiFragment;
import teknodesa.devlops.pantaujuma.components.rdkk.ListRDKKActivity;
import teknodesa.devlops.pantaujuma.components.rktp.CRURKTPFragment;
import teknodesa.devlops.pantaujuma.components.rktp.ListRKTPActivity;
import teknodesa.devlops.pantaujuma.components.signin.LoginActivity;
import teknodesa.devlops.pantaujuma.components.signin.LoginController;
import teknodesa.devlops.pantaujuma.components.signup.RegisterActivity;
import teknodesa.devlops.pantaujuma.components.signup.RegisterController;
import teknodesa.devlops.pantaujuma.components.splashscreen.SplashscreenActivity;
import teknodesa.devlops.pantaujuma.components.splashscreen.SplashscreenController;
import teknodesa.devlops.pantaujuma.components.survei.CRUSurveiFragment;
import teknodesa.devlops.pantaujuma.components.survei.ListSurveiActivity;
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
    void inject(PendudukController controller);

    //Repository
    void inject(ListPetaniRepository repository);
    void inject(PendudukRepository repository);

    //Activity
    void inject(SplashscreenActivity activity);
    void inject(LoginActivity activity);
    void inject(RegisterActivity activity);
    void inject(MainActivity activity);
    void inject(CRUActivity activity);
    void inject(ListPendudukActivity activity);
    void inject(ListPetaniActivity activity);
    void inject(ListPoktanActivity activity);
    void inject(ListRDKActivity activity);
    void inject(ListRDKKActivity activity);
    void inject(ListRKTPActivity activity);
    void inject(ListTargetActivity activity);
    void inject(ListLahanActivity activity);
    void inject(ListKomoditasActivity activity);
    void inject(ListAlsintanActivity activity);
    void inject(ListHargaActivity activity);
    void inject(ListSurveiActivity activity);
    void inject(DetailPendudukActivity activity);

    //fragment
    void inject(HomeFragment fragment);
    void inject(HomeJumaFragment fragment);
    void inject(CRUPendudukFragment fragment);
    void inject(CRUPetaniFragment fragment);
    void inject(CRUPoktanFragment fragment);
    void inject(CRURDKFragment fragment);
    void inject(CRURDKKPupukSubsidiFragment fragment);
    void inject(CRURKTPFragment fragment);
    void inject(CRUTargetPetugasFragment fragment);
    void inject(CRULahanFragment fragment);
    void inject(CRUKomoditasFragment fragment);
    void inject(CRUAlsintanFragment fragment);
    void inject(CRUHargaFragment fragment);
    void inject(CRUSurveiFragment fragment);
}
