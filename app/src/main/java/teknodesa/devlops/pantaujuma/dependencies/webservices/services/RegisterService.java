package teknodesa.devlops.pantaujuma.dependencies.webservices.services;

import android.content.Context;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teknodesa.devlops.pantaujuma.components.signup.RegisterContract;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.RegisterModel;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseRegister;
import teknodesa.devlops.pantaujuma.dependencies.modules.WebServiceModule;
import teknodesa.devlops.pantaujuma.dependencies.webservices.PantauJumaAPI;

/**
 * Created by Marthin on 2/23/2018.
 */

public class RegisterService implements RegisterContract.Repository{
    @Inject
    PantauJumaAPI pjApi;

    public RegisterService(AppComponent appComponent) {
        appComponent.inject(this);
    }
    public RegisterContract.Controller controller;

    public void instanceClass(RegisterContract.Controller controller){
        this.controller = controller;
    }

    @Override
    public void registerUser(RegisterModel registerModel) {
        Log.e("send","data comehere"+registerModel.getEmail());
        Call<ResponseRegister> call = pjApi.registerUser(WebServiceModule.ACCESS_TOKEN_TEMP,registerModel);
        call.enqueue(new Callback<ResponseRegister>() {
            @Override
            public void onResponse(Call<ResponseRegister> call, Response<ResponseRegister> response) {

                if(response.isSuccessful()){
                    if(response.body().isSuccess())
                        controller.registerSuccess("Register Success");
                    else
                        controller.registerFailed(response.body().getMessage());
                }else{
                    controller.registerFailed("Server Error");
                }
            }

            @Override
            public void onFailure(Call<ResponseRegister> call, Throwable t) {
                Log.e("Failure", "onFailure");
                controller.registerFailed(t.getMessage());
                t.printStackTrace();
            }
        });
    }
}
