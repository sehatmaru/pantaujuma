package teknodesa.devlops.pantaujuma.dependencies.webservices.services;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teknodesa.devlops.pantaujuma.components.alsintan.GetTokoAlsintanContract;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.alsintan.TokoAlsintanRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseGetTokoAlsintan;
import teknodesa.devlops.pantaujuma.dependencies.modules.WebServiceModule;
import teknodesa.devlops.pantaujuma.dependencies.webservices.PantauJumaAPI;

/**
 * Created by Marthin on 8/2/2018.
 */

public class GetTokoAlsintanService implements GetTokoAlsintanContract.Repository {

    @Inject
    PantauJumaAPI pjApi;

    @Inject
    Realm realm;

    public GetTokoAlsintanService(AppComponent appComponent) {
        appComponent.inject(this);
    }

    public GetTokoAlsintanContract.Controller controller;

    public void instanceClass(GetTokoAlsintanContract.Controller controller){
        this.controller = controller;
    }

    @Override
    public void getAllTokoAlsintan(){
        Call<ResponseGetTokoAlsintan> call = pjApi.getTokoAlsintan(WebServiceModule.ACCESS_TOKEN_TEMP);
        call.enqueue(new Callback<ResponseGetTokoAlsintan>() {
            @Override
            public void onResponse(Call<ResponseGetTokoAlsintan> call, Response<ResponseGetTokoAlsintan> response) {
                if(response.isSuccessful()){
                    if(response.body().isSuccess()){
                        realm.beginTransaction();
                        RealmResults<TokoAlsintanRealm> allTokoAlsintans = realm.where(TokoAlsintanRealm.class).findAll();
                        allTokoAlsintans.deleteAllFromRealm();
                        realm.commitTransaction();

                        realm.beginTransaction();
                        realm.executeTransactionAsync(realmkelompok -> realmkelompok.insertOrUpdate(response.body().getData()));
                        realm.commitTransaction();
                        controller.getAllTokoAlsintanSuccess(response.body().getData());
                    }else{
                        controller.getAllTokoAlsintanFailed("Error "+response.message());
                    }
                }else{
                    controller.getAllTokoAlsintanFailed("Server Error "+response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseGetTokoAlsintan> call, Throwable t) {
                controller.getAllTokoAlsintanFailed(t.getMessage());
                t.printStackTrace();
            }
        });
    }
}
