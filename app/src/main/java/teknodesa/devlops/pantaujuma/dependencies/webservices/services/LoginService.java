package teknodesa.devlops.pantaujuma.dependencies.webservices.services;

import javax.inject.Inject;
import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teknodesa.devlops.pantaujuma.components.signin.LoginContract;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.UserDB;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.LoginModel;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseLogin;
import teknodesa.devlops.pantaujuma.dependencies.modules.WebServiceModule;
import teknodesa.devlops.pantaujuma.dependencies.webservices.PantauJumaAPI;

/**
 * Created by Marthin on 2/23/2018.
 */

public class LoginService implements LoginContract.Repository {
    @Inject
    PantauJumaAPI pjApi;

    @Inject
    Realm realm;

    public LoginService(AppComponent appComponent) {
        appComponent.inject(this);
    }

    public LoginContract.Controller controller;

    public void instanceClass(LoginContract.Controller controller){
        this.controller = controller;
    }

    @Override
    public void loginUser(LoginModel loginModel) {
        Call<ResponseLogin> call = pjApi.loginUser(WebServiceModule.ACCESS_TOKEN_TEMP,loginModel);
        call.enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {

                if(response.isSuccessful()){
                    if(response.body().isSuccess()){
                        UserDB userDB = new UserDB(response.body().getId(),response.body().getUsername(),response.body().getNamaLengkap(),
                                response.body().getPhoneNumber(),response.body().getProfilImage(),response.body().getNamaDesa(),
                                response.body().getKecamatan(),response.body().getProvinsi(),response.body().getKabupatenKota(),
                                response.body().getEmail(),response.body().getRoleName(),response.body().getKeyRole(),
                                response.body().getAttributeTable(),response.body().getAttributeValue());

                        realm.beginTransaction();
                        realm.executeTransactionAsync(realmuser -> {
                            realmuser.insertOrUpdate(userDB);
                        });
                        realm.commitTransaction();
                        controller.loginSuccess("Welcome");
                    }else
                        controller.loginFailed(response.body().getMessage());
                }else{
                    controller.loginFailed("Server Error");
                }
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                controller.loginFailed(t.getMessage());
                t.printStackTrace();
            }
        });
    }
}
