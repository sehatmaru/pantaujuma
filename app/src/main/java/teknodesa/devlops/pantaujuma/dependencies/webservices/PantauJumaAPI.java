package teknodesa.devlops.pantaujuma.dependencies.webservices;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.AlsintanBody;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.AnggotaPoktanBody;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.HargaBody;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.KomentarBody;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.PendudukBody;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.PengurusPoktanBody;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.PetaniBody;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.PoktanBody;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.PostBody;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.RDKBody;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.RKTPBody;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.TargetPetugasBody;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.BodyGetLahan;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.komoditas.LahanBody;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.rdkk.RDKKBody;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.LoginModel;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseAnggotaPoktan;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseGetAlsintan;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseGetLahanKomoditas;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseGetPasar;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseGetPupuk;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseHarga;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseKomentar;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseKomoditasService;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseLogin;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponsePenduduk;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponsePengurusPoktan;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponsePetani;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponsePoktan;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponsePost;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseInitializeData;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseRDK;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseRDKK;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseRKTP;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseSaveData;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseTarget;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseLahan;

/**
 * Created by Marthin on 2/21/2018.
 */

public interface PantauJumaAPI {

    @POST("user/loginUser")
    Call<ResponseLogin> loginUser(@Header("Authorization") String token, @Body LoginModel loginModel);

    @GET("data/getInitializeData")
    Call<ResponseInitializeData> getInitializeData(@Header("Authorization") String token);

    @GET("penduduk/getPendudukByDesa/{idDesa}")
    Call<ResponsePenduduk> getAllPenduduk(@Header("Authorization") String token, @Path("idDesa") int idDesa);

    @GET("komoditas/getAllKomoditas")
    Call<ResponseKomoditasService> getAllKomoditas(@Header("Authorization") String token);

    @POST("penduduk/insertPenduduk")
    Call<ResponseSaveData> insertPenduduk(@Header("Authorization") String token, @Body PendudukBody pendudukBody);

    @GET("lahan/getLahanByDesa/{idDesa}")
    Call<ResponseLahan> getAllLahan(@Header("Authorization") String token, @Path("idDesa") int idDesa);

    @POST("lahan/insertLahan")
    Call<ResponseSaveData> insertLahan(@Header("Authorization") String token, @Body LahanBody lahankBody);

    @POST("lahan/getLahanByKomoditas")
    Call<ResponseGetLahanKomoditas> getLahanByKomoditas(@Header("Authorization") String token, @Body BodyGetLahan bodyGetLahan);

    @GET("petani/getPetaniByDesa/{idDesa}")
    Call<ResponsePetani> getAllPetani(@Header("Authorization") String token, @Path("idDesa") int idDesa);

    @POST("petani/insertPetani")
    Call<ResponseSaveData> insertPetani(@Header("Authorization") String token, @Body PetaniBody petaniBody);

    @GET("poktan/getPoktanByDesa/{idDesa}")
    Call<ResponsePoktan> getAllPoktan(@Header("Authorization") String token, @Path("idDesa") int idDesa);

    @GET("poktan/getAnggotaPoktanByDesa/{idDesa}")
    Call<ResponseAnggotaPoktan> getAllAnggotaPoktan(@Header("Authorization") String token, @Path("idDesa") int idDesa);

    @GET("poktan/getPengurusPoktanByDesa/{idDesa}")
    Call<ResponsePengurusPoktan> getAllPengurusPoktan(@Header("Authorization") String token, @Path("idDesa") int idDesa);

    @POST("poktan/insertAnggotaPoktan")
    Call<ResponseSaveData> insertAnggotaPoktan(@Header("Authorization") String token, @Body AnggotaPoktanBody anggotaPoktanBody);

    @POST("poktan/insertPengurusPoktan")
    Call<ResponseSaveData> insertPengurusPoktan(@Header("Authorization") String token, @Body PengurusPoktanBody pengurusPoktanBody);

    @POST("poktan/insertPoktan")
    Call<ResponseSaveData> insertPoktan(@Header("Authorization") String token, @Body PoktanBody poktanBody);

    @GET("petugas/getTargetPetugasByDesa/{idDesa}")
    Call<ResponseTarget> getAllTargetPetugas(@Header("Authorization") String token, @Path("idDesa") int idDesa);

    @POST("petugas/insertTargetPetugas")
    Call<ResponseSaveData> insertTargetPetugas(@Header("Authorization") String token, @Body TargetPetugasBody targetPetugasBody);

    @GET("rktp/getRKTPByDesa/{idDesa}")
    Call<ResponseRKTP> getAllRKTP(@Header("Authorization") String token, @Path("idDesa") int idDesa);

    @POST("rktp/insertRktp")
    Call<ResponseSaveData> insertRktp(@Header("Authorization") String token, @Body RKTPBody rktpBody);

    @GET("rdk/viewAllRDK/{idDesa}")
    Call<ResponseRDK> getAllRDK(@Header("Authorization") String token, @Path("idDesa") int idDesa);

    @GET("rdkk/viewAllRDKK/{idDesa}")
    Call<ResponseRDKK> getAllRDKK(@Header("Authorization") String token, @Path("idDesa") int idDesa);

    @POST("rdkk/insertRDKK")
    Call<ResponseSaveData> insertRDKK(@Header("Authorization") String token, @Body RDKKBody rdkkBody);

    @POST("rdk/insertRDK")
    Call<ResponseSaveData> insertRDK(@Header("Authorization") String token, @Body RDKBody rdkBody);

    @POST("alsintan/insertAlatPertanian")
    Call<ResponseSaveData> insertAlsintan(@Header("Authorization") String token, @Body AlsintanBody alsintanBody);

    @GET("harga/getAllHarga")
    Call<ResponseHarga> getAllHarga(@Header("Authorization") String token);

    @POST("harga/insertHarga")
    Call<ResponseSaveData> insertHarga(@Header("Authorization") String token, @Body HargaBody hargaBody);

    @GET("harga/getAllPasar")
    Call<ResponseGetPasar> getPasar(@Header("Authorization") String token);

    @GET("alsintan/getAllPupuk")
    Call<ResponseGetPupuk> getPupuk(@Header("Authorization") String token);

    @GET("alsintan/getAllAlsintan")
    Call<ResponseGetAlsintan> getAlsintan(@Header("Authorization") String token);

    @GET("post/getAllPost")
    Call<ResponsePost> getAllPost(@Header("Authorization") String token);

    @POST("post/insertPost")
    Call<ResponseSaveData> insertPost(@Header("Authorization") String token, @Body PostBody postBody);

    @GET("post/getAllKomentar/{idPost}")
    Call<ResponseKomentar> getAllKomentar(@Header("Authorization") String token, @Path("idPost") String idPost);

    @POST("post/insertKomentar")
    Call<ResponseSaveData> insertKomentar(@Header("Authorization") String token, @Body KomentarBody komentarBody);
}
