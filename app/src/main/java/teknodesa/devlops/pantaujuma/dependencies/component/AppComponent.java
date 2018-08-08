package teknodesa.devlops.pantaujuma.dependencies.component;

import javax.inject.Singleton;

import dagger.Component;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.components.CRUActivity;
import teknodesa.devlops.pantaujuma.components.MainActivity;
import teknodesa.devlops.pantaujuma.components.adapter.FragmentPetaniAdapter;
import teknodesa.devlops.pantaujuma.components.adapter.PetaniAdapter;
import teknodesa.devlops.pantaujuma.components.adapter.PoktanAdapter;
import teknodesa.devlops.pantaujuma.components.adapter.RDKKAdapter;
import teknodesa.devlops.pantaujuma.components.adapter.TargetAdapter;
import teknodesa.devlops.pantaujuma.components.alsintan.CRUAlsintanFragment;
import teknodesa.devlops.pantaujuma.components.alsintan.ListAlsintanActivity;
import teknodesa.devlops.pantaujuma.components.harga.CRUHargaFragment;
import teknodesa.devlops.pantaujuma.components.harga.ListHargaActivity;
import teknodesa.devlops.pantaujuma.components.home.HomeController;
import teknodesa.devlops.pantaujuma.components.home.HomeFragment;
import teknodesa.devlops.pantaujuma.components.komoditas.CRUKomoditasFragment;
import teknodesa.devlops.pantaujuma.components.komoditas.KomoditasController;
import teknodesa.devlops.pantaujuma.components.komoditas.KomoditasFragment;
import teknodesa.devlops.pantaujuma.components.komoditas.ListKomoditasActivity;
import teknodesa.devlops.pantaujuma.components.lahan.CRULahanFragment;
import teknodesa.devlops.pantaujuma.components.lahan.ListLahanActivity;
import teknodesa.devlops.pantaujuma.components.lahan.ListLahanKomoditasActivity;
import teknodesa.devlops.pantaujuma.components.lahan.ListLahanKomoditasController;
import teknodesa.devlops.pantaujuma.components.penduduk.AlamatFragment;
import teknodesa.devlops.pantaujuma.components.penduduk.BiodataFragment;
import teknodesa.devlops.pantaujuma.components.penduduk.CRUPendudukFragment;
import teknodesa.devlops.pantaujuma.components.penduduk.DetailPendudukActivity;
import teknodesa.devlops.pantaujuma.components.penduduk.GetPendudukController;
import teknodesa.devlops.pantaujuma.components.penduduk.ListPendudukActivity;
import teknodesa.devlops.pantaujuma.components.penduduk.PendudukController;
import teknodesa.devlops.pantaujuma.components.penduduk.PendudukFragment;
import teknodesa.devlops.pantaujuma.components.penduduk.PendudukRepository;
import teknodesa.devlops.pantaujuma.components.petani.CRUPetaniFragment;
import teknodesa.devlops.pantaujuma.components.petani.DetailPetaniActivity;
import teknodesa.devlops.pantaujuma.components.petani.GetPetaniController;
import teknodesa.devlops.pantaujuma.components.petani.ListPetaniActivity;
import teknodesa.devlops.pantaujuma.components.petani.PetaniController;
import teknodesa.devlops.pantaujuma.components.petani.PetaniRepository;
import teknodesa.devlops.pantaujuma.components.petugas.CRUTargetPetugasFragment;
import teknodesa.devlops.pantaujuma.components.petugas.DetailTargetActivity;
import teknodesa.devlops.pantaujuma.components.petugas.ListTargetActivity;
import teknodesa.devlops.pantaujuma.components.petugas.TargetController;
import teknodesa.devlops.pantaujuma.components.petugas.TargetRepository;
import teknodesa.devlops.pantaujuma.components.poktan.CRUPoktanFragment;
import teknodesa.devlops.pantaujuma.components.poktan.DetailPoktanActivity;
import teknodesa.devlops.pantaujuma.components.poktan.ListPoktanActivity;
import teknodesa.devlops.pantaujuma.components.poktan.PoktanController;
import teknodesa.devlops.pantaujuma.components.poktan.PoktanRepository;
import teknodesa.devlops.pantaujuma.components.poktan.form.AnggotaPoktanFragment;
import teknodesa.devlops.pantaujuma.components.poktan.form.IdentitasPoktanFragment;
import teknodesa.devlops.pantaujuma.components.poktan.form.PengurusPoktanFragment;
import teknodesa.devlops.pantaujuma.components.profile.AkunFragment;
import teknodesa.devlops.pantaujuma.components.profile.ProfileController;
import teknodesa.devlops.pantaujuma.components.rdk.CRURDKFragment;
import teknodesa.devlops.pantaujuma.components.rdk.ListRDKActivity;
import teknodesa.devlops.pantaujuma.components.rdkk.CRURDKKPupukSubsidiFragment;
import teknodesa.devlops.pantaujuma.components.rdkk.DetailRDKKActivity;
import teknodesa.devlops.pantaujuma.components.rdkk.ListRDKKActivity;
import teknodesa.devlops.pantaujuma.components.rdkk.RDKKController;
import teknodesa.devlops.pantaujuma.components.rdkk.RDKKRepository;
import teknodesa.devlops.pantaujuma.components.rktp.CRURKTPFragment;
import teknodesa.devlops.pantaujuma.components.rktp.ListRKTPActivity;
import teknodesa.devlops.pantaujuma.components.searchkomoditas.SearchKomoditasFragment;
import teknodesa.devlops.pantaujuma.components.searchkomoditas.SearchTargetKomoditasFragment;
import teknodesa.devlops.pantaujuma.components.searchpenduduk.SearchPendudukFragment;
import teknodesa.devlops.pantaujuma.components.searchpenduduk.SearchPendudukPengurusFragment;
import teknodesa.devlops.pantaujuma.components.searchpetani.SearchPetaniFragment;
import teknodesa.devlops.pantaujuma.components.searchpoktan.SearchPoktanFragment;
import teknodesa.devlops.pantaujuma.components.signin.LoginActivity;
import teknodesa.devlops.pantaujuma.components.signin.LoginController;
import teknodesa.devlops.pantaujuma.components.splashscreen.SplashscreenActivity;
import teknodesa.devlops.pantaujuma.components.splashscreen.SplashscreenController;
import teknodesa.devlops.pantaujuma.components.survei.CRUSurveiFragment;
import teknodesa.devlops.pantaujuma.components.survei.ListSurveiActivity;
import teknodesa.devlops.pantaujuma.dependencies.modules.AppModule;
import teknodesa.devlops.pantaujuma.dependencies.modules.RealmModule;
import teknodesa.devlops.pantaujuma.dependencies.modules.WebServiceModule;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.GetPendudukService;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.GetPetaniService;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.KomoditasService;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.ListLahanKomoditasService;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.LoginService;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.PromoService;

@Singleton
@Component(modules = {AppModule.class, RealmModule.class, WebServiceModule.class})
public interface AppComponent {
    void inject(MainApplication app);

    //Service
    void inject(LoginService service);
    void inject(GetPendudukService service);

    //Controllers
    void inject(SplashscreenController controller);
    void inject(LoginController controller);
    void inject(PendudukController controller);
    void inject(ProfileController controller);
    void inject(HomeController controller);
    void inject(GetPendudukController controller);
    void inject(KomoditasController controller);
    void inject(ListLahanKomoditasController controller);

    //Repository
    void inject(PendudukRepository repository);
    void inject(PromoService repository);
    void inject(KomoditasService repository);
    void inject(ListLahanKomoditasService repository);

    //Activity
    void inject(SplashscreenActivity activity);
    void inject(LoginActivity activity);
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
    void inject(ListLahanKomoditasActivity activity);

    //fragment
    void inject(HomeFragment fragment);
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
    void inject(BiodataFragment fragment);
    void inject(AlamatFragment fragment);
    void inject(PendudukFragment fragment);
    void inject(AkunFragment fragment);
    void inject(KomoditasFragment fragment);

    void inject(TargetAdapter targetAdapter);

    void inject(PetaniController petaniController);

    void inject(AnggotaPoktanFragment anggotaPoktanFragment);

    void inject(SearchTargetKomoditasFragment searchTargetKomoditasFragment);

    void inject(FragmentPetaniAdapter fragmentPetaniAdapter);

    void inject(PetaniAdapter petaniAdapter);

    void inject(PoktanAdapter poktanAdapter);

    void inject(RDKKAdapter rdkkAdapter);

    void inject(SearchPendudukFragment searchPendudukFragment);

    void inject(SearchPendudukPengurusFragment searchPendudukPengurusFragment);

    void inject(SearchPetaniFragment searchPetaniFragment);

    void inject(SearchPoktanFragment searchPoktanFragment);

    void inject(SearchKomoditasFragment searchKomoditasFragment);

    void inject(IdentitasPoktanFragment identitasPoktanFragment);

    void inject(PengurusPoktanFragment pengurusPoktanFragment);

    void inject(DetailPetaniActivity detailPetaniActivity);

    void inject(PetaniRepository petaniRepository);

    void inject(DetailTargetActivity detailTargetActivity);

    void inject(DetailRDKKActivity detailRDKKActivity);

    void inject(TargetController targetController);

    void inject(RDKKController rdkkController);

    void inject(PoktanController poktanController);

    void inject(TargetRepository targetRepository);

    void inject(PoktanRepository poktanRepository);

    void inject(RDKKRepository rdkkRepository);

    void inject(DetailPoktanActivity detailPoktanActivity);

    void inject(GetPetaniService getPetaniService);

    void inject(GetPetaniController getPetaniController);
}
