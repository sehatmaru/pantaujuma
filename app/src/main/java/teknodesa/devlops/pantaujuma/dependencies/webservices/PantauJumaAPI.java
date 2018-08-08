package teknodesa.devlops.pantaujuma.dependencies.webservices;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.PendudukBody;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.PetaniBody;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.lahan.BodyGetLahan;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.LoginModel;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseGetLahanKomoditas;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseKomoditasService;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseLogin;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponsePenduduk;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponsePetani;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponsePromo;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseSaveData;

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

    @GET("petani/viewAllPetani/{idDesa}")
    Call<ResponsePetani> getAllPetani(@Header("Authorization") String token, @Path("idDesa") int idDesa);

    @POST("petani/insertPetani")
    Call<ResponseSaveData> insertPetani(@Header("Authorization") String token, @Body PetaniBody petaniBody);

}
