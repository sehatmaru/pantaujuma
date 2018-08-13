package teknodesa.devlops.pantaujuma.dependencies.webservices;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.PendudukBody;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.PetaniBody;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.PoktanBody;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.RDKBody;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.RDKKBody;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.RKTPBody;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.TargetPetugasBody;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.lahan.BodyGetLahan;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.LoginModel;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseGetLahanKomoditas;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseKomoditasService;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseLogin;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponsePenduduk;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponsePetani;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponsePoktan;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponsePromo;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseRDK;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseRDKK;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseRKTP;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseSaveData;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseTarget;

/**
 * Created by Marthin on 2/21/2018.
 */

public interface PantauJumaAPI {

    @POST("user/loginUser")
    Call<ResponseLogin> loginUser(@Header("Authorization") String token, @Body LoginModel loginModel);

    @GET("promo/getPromotion")
    Call<ResponsePromo> getPromotion(@Header("Authorization") String token);

    @GET("penduduk/viewAllPenduduk/{idDesa}")
    Call<ResponsePenduduk> getAllPenduduk(@Header("Authorization") String token, @Path("idDesa") int idDesa);

    @GET("komoditas/getAllKomoditas")
    Call<ResponseKomoditasService> getAllKomoditas(@Header("Authorization") String token);

    @POST("penduduk/insertPenduduk")
    Call<ResponseSaveData> insertPenduduk(@Header("Authorization") String token, @Body PendudukBody pendudukBody);

    @POST("lahan/getAllLahanKomoditas")
    Call<ResponseGetLahanKomoditas> getLahanByKomoditas(@Header("Authorization") String token, @Body BodyGetLahan bodyGetLahan);

    @GET("petani/getPetaniByDesa/{desa}")
    Call<ResponsePetani> getAllPetani(@Header("Authorization") String token, @Path("desa") int idDesa);

    @POST("petani/insertPetani")
    Call<ResponseSaveData> insertPetani(@Header("Authorization") String token, @Body PetaniBody petaniBody);

    @GET("poktan/getPoktanByDesa/{desa}")
    Call<ResponsePoktan> getAllPoktan(@Header("Authorization") String token, @Path("desa") int idDesa);

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

    @GET("rdk/getRDK/{desa}")
    Call<ResponseRDK> getAllRDK(@Header("Authorization") String token, @Path("desa") int idDesa);

    @POST("rdk/insertRdk")
    Call<ResponseSaveData> insertRdk(@Header("Authorization") String token, @Body RDKBody rdkBody);

    @GET("rdkk/getRDKKByDesa/{idDesa}")
    Call<ResponseRDKK> getAllRDKK(@Header("Authorization") String token, @Path("idDesa") int idDesa);

    @POST("rdkk/insertRDKK")
    Call<ResponseSaveData> insertRDKK(@Header("Authorization") String token, @Body RDKKBody rdkkBody);
}
