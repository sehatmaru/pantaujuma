package teknodesa.devlops.pantaujuma.dependencies.component;

import javax.inject.Singleton;

import dagger.Component;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.components.CRUActivity;
import teknodesa.devlops.pantaujuma.components.MainActivity;
import teknodesa.devlops.pantaujuma.components.adapter.AlsintanPengecerPupukAdapter;
import teknodesa.devlops.pantaujuma.components.adapter.AnggotaPoktanAdapter;
import teknodesa.devlops.pantaujuma.components.adapter.FragmentPetaniAdapter;
import teknodesa.devlops.pantaujuma.components.adapter.FragmentPoktanAdapter;
import teknodesa.devlops.pantaujuma.components.adapter.HargaAdapter;
import teknodesa.devlops.pantaujuma.components.adapter.PengurusPoktanAdapter;
import teknodesa.devlops.pantaujuma.components.adapter.PetaniAdapter;
import teknodesa.devlops.pantaujuma.components.adapter.PoktanAdapter;
import teknodesa.devlops.pantaujuma.components.adapter.RDKAdapter;
import teknodesa.devlops.pantaujuma.components.adapter.RDKKAdapter;
import teknodesa.devlops.pantaujuma.components.adapter.RKTPAdapter;
import teknodesa.devlops.pantaujuma.components.adapter.TargetAdapter;
import teknodesa.devlops.pantaujuma.components.alsintan.AlsintanController;
import teknodesa.devlops.pantaujuma.components.alsintan.AlsintanRepository;
import teknodesa.devlops.pantaujuma.components.alsintan.DetailAlsintanActivity;
import teknodesa.devlops.pantaujuma.components.alsintan.GetAlsintanController;
import teknodesa.devlops.pantaujuma.components.alsintan.ListAlsintanActivity;
import teknodesa.devlops.pantaujuma.components.harga.CRUHargaFragment;
import teknodesa.devlops.pantaujuma.components.harga.DetailHargaActivity;
import teknodesa.devlops.pantaujuma.components.harga.GetHargaController;
import teknodesa.devlops.pantaujuma.components.harga.HargaController;
import teknodesa.devlops.pantaujuma.components.harga.HargaRepository;
import teknodesa.devlops.pantaujuma.components.harga.ListHargaActivity;
import teknodesa.devlops.pantaujuma.components.home.HomeController;
import teknodesa.devlops.pantaujuma.components.home.HomeFragment;
import teknodesa.devlops.pantaujuma.components.komoditas.CRUKomoditasFragment;
import teknodesa.devlops.pantaujuma.components.komoditas.KomoditasController;
import teknodesa.devlops.pantaujuma.components.komoditas.KomoditasFragment;
import teknodesa.devlops.pantaujuma.components.komoditas.ListKomoditasActivity;
import teknodesa.devlops.pantaujuma.components.lahan.CRULahanFragment;
import teknodesa.devlops.pantaujuma.components.lahan.DetailLahanActivity;
import teknodesa.devlops.pantaujuma.components.lahan.GetLahanController;
import teknodesa.devlops.pantaujuma.components.lahan.LahanController;
import teknodesa.devlops.pantaujuma.components.lahan.LahanRepository;
import teknodesa.devlops.pantaujuma.components.lahan.ListLahanActivity;
import teknodesa.devlops.pantaujuma.components.lahan.ListLahanKomoditasActivity;
import teknodesa.devlops.pantaujuma.components.lahan.ListLahanKomoditasController;
import teknodesa.devlops.pantaujuma.components.penduduk.form.AlamatFragment;
import teknodesa.devlops.pantaujuma.components.penduduk.form.BiodataFragment;
import teknodesa.devlops.pantaujuma.components.penduduk.form.CRUPendudukFragment;
import teknodesa.devlops.pantaujuma.components.penduduk.DetailPendudukActivity;
import teknodesa.devlops.pantaujuma.components.penduduk.GetPendudukController;
import teknodesa.devlops.pantaujuma.components.penduduk.ListPendudukActivity;
import teknodesa.devlops.pantaujuma.components.penduduk.form.PendudukController;
import teknodesa.devlops.pantaujuma.components.penduduk.form.PendudukRepository;
import teknodesa.devlops.pantaujuma.components.petani.CRUPetaniFragment;
import teknodesa.devlops.pantaujuma.components.petani.DetailPetaniActivity;
import teknodesa.devlops.pantaujuma.components.petani.GetPetaniController;
import teknodesa.devlops.pantaujuma.components.petani.ListPetaniActivity;
import teknodesa.devlops.pantaujuma.components.petani.PetaniController;
import teknodesa.devlops.pantaujuma.components.petani.PetaniRepository;
import teknodesa.devlops.pantaujuma.components.petugas.CRUTargetPetugasFragment;
import teknodesa.devlops.pantaujuma.components.petugas.DetailTargetActivity;
import teknodesa.devlops.pantaujuma.components.petugas.GetTargetController;
import teknodesa.devlops.pantaujuma.components.petugas.ListTargetActivity;
import teknodesa.devlops.pantaujuma.components.petugas.TargetController;
import teknodesa.devlops.pantaujuma.components.petugas.TargetRepository;
import teknodesa.devlops.pantaujuma.components.poktan.AnggotaPoktanController;
import teknodesa.devlops.pantaujuma.components.poktan.AnggotaPoktanRepository;
import teknodesa.devlops.pantaujuma.components.poktan.CRUPengurusPoktanFragment;
import teknodesa.devlops.pantaujuma.components.poktan.DetailPoktanActivity;
import teknodesa.devlops.pantaujuma.components.poktan.GetAnggotaPoktanController;
import teknodesa.devlops.pantaujuma.components.poktan.GetPengurusPoktanController;
import teknodesa.devlops.pantaujuma.components.poktan.GetPoktanController;
import teknodesa.devlops.pantaujuma.components.poktan.ListPoktanActivity;
import teknodesa.devlops.pantaujuma.components.poktan.PengurusPoktanController;
import teknodesa.devlops.pantaujuma.components.poktan.PengurusPoktanRepository;
import teknodesa.devlops.pantaujuma.components.poktan.PoktanController;
import teknodesa.devlops.pantaujuma.components.poktan.PoktanRepository;
import teknodesa.devlops.pantaujuma.components.poktan.CRUAnggotaPoktanFragment;
import teknodesa.devlops.pantaujuma.components.poktan.CRUIdentitasPoktanFragment;
import teknodesa.devlops.pantaujuma.components.post.CRUPostController;
import teknodesa.devlops.pantaujuma.components.post.CRUPostFragment;
import teknodesa.devlops.pantaujuma.components.post.DetailPostActivity;
import teknodesa.devlops.pantaujuma.components.post.GetKomentarController;
import teknodesa.devlops.pantaujuma.components.post.GetPostController;
import teknodesa.devlops.pantaujuma.components.post.KomentarController;
import teknodesa.devlops.pantaujuma.components.post.KomentarRepository;
import teknodesa.devlops.pantaujuma.components.post.PostFragment;
import teknodesa.devlops.pantaujuma.components.post.PostRepository;
import teknodesa.devlops.pantaujuma.components.profile.AkunFragment;
import teknodesa.devlops.pantaujuma.components.profile.ProfileController;
import teknodesa.devlops.pantaujuma.components.rdk.CRURDKFragment;
import teknodesa.devlops.pantaujuma.components.rdk.DetailRDKActivity;
import teknodesa.devlops.pantaujuma.components.rdk.GetRDKController;
import teknodesa.devlops.pantaujuma.components.rdk.ListRDKActivity;
import teknodesa.devlops.pantaujuma.components.rdk.RDKController;
import teknodesa.devlops.pantaujuma.components.rdk.RDKRepository;
import teknodesa.devlops.pantaujuma.components.rdk.form.RDKIrigasiFragment;
import teknodesa.devlops.pantaujuma.components.rdk.form.RDKJadwalKegiatanFragment;
import teknodesa.devlops.pantaujuma.components.rdk.form.RDKRencanaUmumFragment;
import teknodesa.devlops.pantaujuma.components.rdk.form.RDKSasaranIntensifikasiFragment;
import teknodesa.devlops.pantaujuma.components.rdkk.CRURDKKPupukSubsidiFragment;
import teknodesa.devlops.pantaujuma.components.rdkk.DetailRDKKActivity;
import teknodesa.devlops.pantaujuma.components.rdkk.GetRDKKController;
import teknodesa.devlops.pantaujuma.components.rdkk.ListRDKKActivity;
import teknodesa.devlops.pantaujuma.components.rdkk.RDKKController;
import teknodesa.devlops.pantaujuma.components.rdkk.RDKKRepository;
import teknodesa.devlops.pantaujuma.components.rktp.CRURKTPFragment;
import teknodesa.devlops.pantaujuma.components.rktp.DetailRKTPActivity;
import teknodesa.devlops.pantaujuma.components.rktp.GetRKTPController;
import teknodesa.devlops.pantaujuma.components.rktp.ListRKTPActivity;
import teknodesa.devlops.pantaujuma.components.rktp.RKTPController;
import teknodesa.devlops.pantaujuma.components.rktp.RKTPRepository;
import teknodesa.devlops.pantaujuma.components.searchkomoditas.SearchKomoditasFragment;
import teknodesa.devlops.pantaujuma.components.searchkomoditas.SearchTargetKomoditasFragment;
import teknodesa.devlops.pantaujuma.components.searchpasar.SearchPasarFragment;
import teknodesa.devlops.pantaujuma.components.searchpenduduk.SearchPendudukFragment;
import teknodesa.devlops.pantaujuma.components.searchpenduduk.SearchPendudukPengurusFragment;
import teknodesa.devlops.pantaujuma.components.searchpetani.SearchPetaniFragment;
import teknodesa.devlops.pantaujuma.components.searchpoktan.SearchPoktanFragment;
import teknodesa.devlops.pantaujuma.components.searchpupuk.SearchPupukFragment;
import teknodesa.devlops.pantaujuma.components.signin.LoginActivity;
import teknodesa.devlops.pantaujuma.components.signin.LoginController;
import teknodesa.devlops.pantaujuma.components.signin.UserRealmController;
import teknodesa.devlops.pantaujuma.components.splashscreen.SplashscreenActivity;
import teknodesa.devlops.pantaujuma.components.splashscreen.SplashscreenController;
import teknodesa.devlops.pantaujuma.dependencies.modules.AppModule;
import teknodesa.devlops.pantaujuma.dependencies.modules.RealmModule;
import teknodesa.devlops.pantaujuma.dependencies.modules.WebServiceModule;
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
    void inject(UserRealmController controller);

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
    void inject(ListHargaActivity activity);
    void inject(DetailPendudukActivity activity);
    void inject(ListLahanKomoditasActivity activity);

    //fragment
    void inject(HomeFragment fragment);
    void inject(CRUPendudukFragment fragment);
    void inject(CRUPetaniFragment fragment);
    void inject(CRURDKFragment fragment);
    void inject(CRURDKKPupukSubsidiFragment fragment);
    void inject(CRURKTPFragment fragment);
    void inject(CRUTargetPetugasFragment fragment);
    void inject(CRULahanFragment fragment);
    void inject(CRUKomoditasFragment fragment);
    void inject(CRUHargaFragment fragment);
    void inject(BiodataFragment fragment);
    void inject(AlamatFragment fragment);
    void inject(AkunFragment fragment);
    void inject(KomoditasFragment fragment);

    void inject(TargetAdapter targetAdapter);

    void inject(PetaniController petaniController);

    void inject(CRUAnggotaPoktanFragment cruAnggotaPoktanFragment);

    void inject(CRUPengurusPoktanFragment cruPengurusPoktanFragment);

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

    void inject(CRUIdentitasPoktanFragment CRUIdentitasPoktanFragment);

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

    void inject(RKTPRepository rktpRepository);

    void inject(RKTPController rktpController);

    void inject(DetailRKTPActivity detailRKTPActivity);

    void inject(RDKIrigasiFragment rdkIrigasiFragment);

    void inject(RDKJadwalKegiatanFragment rdkJadwalKegiatanFragment);

    void inject(RDKRencanaUmumFragment rdkRencanaUmumFragment);

    void inject(RDKSasaranIntensifikasiFragment rdkSasaranIntensifikasiFragment);

    void inject(DetailRDKActivity detailRDKActivity);

    void inject(RDKController rdkController);

    void inject(RDKRepository rdkRepository);

    void inject(GetPoktanService getPoktanService);

    void inject(GetPoktanController getPoktanController);

    void inject(GetTargetService getTargetService);

    void inject(GetRKTPService getRKTPService);

    void inject(GetRKTPController getRKTPController);

    void inject(GetTargetController getTargetController);

    void inject(GetRDKController getRDKController);

    void inject(GetRDKService getRDKService);

    void inject(RDKAdapter rdkAdapter);

    void inject(GetRDKKService getRDKKService);

    void inject(GetRDKKController getRDKKController);

    void inject(FragmentPoktanAdapter fragmentPoktanAdapter);

    void inject(GetAlsintanService getAlsintanService);

    void inject(GetAlsintanController getAlsintanController);

    void inject(DetailHargaActivity detailHargaActivity);

    void inject(GetHargaController getHargaController);

    void inject(HargaController hargaController);

    void inject(HargaRepository hargaRepository);

    void inject(GetHargaService getHargaService);

    void inject(HargaAdapter hargaAdapter);

    void inject(AnggotaPoktanAdapter anggotaPoktanAdapter);

    void inject(AnggotaPoktanRepository anggotaPoktanRepository);

    void inject(AnggotaPoktanController anggotaPoktanController);

    void inject(SearchPupukFragment searchPupukFragment);

    void inject(SearchPasarFragment searchPasarFragment);

    void inject(RKTPAdapter rktpAdapter);

    void inject(AlsintanPengecerPupukAdapter alsintanPengecerPupukAdapter);

    void inject(AlsintanRepository alsintanRepository);

    void inject(AlsintanController alsintanController);

    void inject(GetAnggotaPoktanController getAnggotaPoktanController);

    void inject(GetAnggotaPoktanService getAnggotaPoktanService);

    void inject(GetPengurusPoktanService getPengurusPoktanService);

    void inject(GetPengurusPoktanController getPengurusPoktanController);

    void inject(PengurusPoktanAdapter pengurusPoktanAdapter);

    void inject(PengurusPoktanRepository pengurusPoktanRepository);

    void inject(PengurusPoktanController pengurusPoktanController);

    void inject(CRUPostFragment cruPostFragment);

    void inject(GetKomentarService getKomentarService);

    void inject(KomentarController komentarController);

    void inject(GetPostController getPostController);

    void inject(GetPostService getPostService);

    void inject(KomentarRepository komentarRepository);

    void inject(PostRepository postRepository);

    void inject(PostFragment postFragment);

    void inject(GetKomentarController getKomentarController);

    void inject(CRUPostController cruPostController);

    void inject(DetailPostActivity detailPostActivity);

    void inject(LahanController lahanController);

    void inject(LahanRepository lahanRepository);

    void inject(DetailLahanActivity detailLahanActivity);

    void inject(GetLahanController getLahanController);

    void inject(GetLahanService getLahanService);

    void inject(ListAlsintanActivity listAlsintanActivity);

    void inject(DetailAlsintanActivity detailAlsintanActivity);
}
