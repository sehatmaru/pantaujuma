package teknodesa.devlops.pantaujuma.dependencies.webservices.services;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teknodesa.devlops.pantaujuma.components.signin.LoginContract;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
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
        Log.e("send","data comehere"+loginModel.getEmail());
        Call<ResponseLogin> call = pjApi.loginUser(WebServiceModule.ACCESS_TOKEN_TEMP,loginModel);
        call.enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {

                if(response.isSuccessful()){
                    if(response.body().isSuccess()){
                        realm.beginTransaction();
                        realm.executeTransactionAsync(realmuser -> {
                            realmuser.insertOrUpdate(response.body().getData());
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
                Log.e("Failure", "onFailure");
                controller.loginFailed(t.getMessage());
                t.printStackTrace();
            }
        });
    }
}
