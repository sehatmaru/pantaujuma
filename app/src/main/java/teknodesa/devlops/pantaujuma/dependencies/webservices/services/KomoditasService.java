package teknodesa.devlops.pantaujuma.dependencies.webservices.services;

import android.util.Log;

import javax.inject.Inject;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teknodesa.devlops.pantaujuma.components.komoditas.KomoditasContract;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseKomoditasService;
import teknodesa.devlops.pantaujuma.dependencies.modules.WebServiceModule;
import teknodesa.devlops.pantaujuma.dependencies.webservices.PantauJumaAPI;

/**
 * Created by Marthin on 7/30/2018.
 */

public class KomoditasService implements KomoditasContract.Repository {

    @Inject
    PantauJumaAPI pjApi;

    @Inject
    Realm realm;

    public KomoditasService(AppComponent appComponent) {
        appComponent.inject(this);
    }

    public KomoditasContract.Controller controller;

    public void instanceClass(KomoditasContract.Controller controller){
        this.controller = controller;
    }

    @Override
    public void getAllKomoditas() {
        Call<ResponseKomoditasService> call = pjApi.getAllKomoditas(WebServiceModule.ACCESS_TOKEN_TEMP);
        call.enqueue(new Callback<ResponseKomoditasService>() {
            @Override
            public void onResponse(Call<ResponseKomoditasService> call, Response<ResponseKomoditasService> response) {
                if(response.isSuccessful()){
                    if(response.body().isSuccess()){
                        realm.beginTransaction();
                        realm.executeTransactionAsync(realm -> {
                            realm.insertOrUpdate(response.body().getData());
                        });
                        realm.commitTransaction();
                        controller.getAllKomoditasSuccess(response.body().getData());
                    }else
                        controller.getAllKomoditasFailed(response.body().getMessage());
                }else{
                    controller.getAllKomoditasFailed("Something Wrong: "+response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseKomoditasService> call, Throwable t) {
                Log.e("Failure", "onFailure");
                controller.getAllKomoditasFailed(t.getMessage());
                t.printStackTrace();
            }
        });
    }
}
