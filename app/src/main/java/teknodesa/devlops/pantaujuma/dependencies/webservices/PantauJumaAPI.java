package teknodesa.devlops.pantaujuma.dependencies.webservices;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.LoginModel;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.RegisterModel;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.UpdateUserModel;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseLogin;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseRegister;

/**
 * Created by Marthin on 2/21/2018.
 */

public interface PantauJumaAPI {
    @POST("user/register")
    Call<ResponseRegister> registerUser(@Header("Authorization") String token, @Body RegisterModel registerModel);

    @POST("user/login")
    Call<ResponseLogin> loginUser(@Header("Authorization") String token, @Body LoginModel loginModel);

    @POST("user/updateUser")
    Call<ResponseLogin> updateUser(@Header("Authorization") String token, @Body UpdateUserModel updateUserModel);
}
