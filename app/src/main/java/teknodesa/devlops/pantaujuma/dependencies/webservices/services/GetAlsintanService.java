package teknodesa.devlops.pantaujuma.dependencies.webservices.services;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teknodesa.devlops.pantaujuma.components.alsintan.GetAlsintanContract;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.alsintan.AlsintanRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseGetAlsintan;
import teknodesa.devlops.pantaujuma.dependencies.modules.WebServiceModule;
import teknodesa.devlops.pantaujuma.dependencies.webservices.PantauJumaAPI;

/**
 * Created by Marthin on 8/2/2018.
 */

public class GetAlsintanService implements GetAlsintanContract.Repository {

    @Inject
    PantauJumaAPI pjApi;

    @Inject
    Realm realm;

    public GetAlsintanService(AppComponent appComponent) {
        appComponent.inject(this);
    }

    public GetAlsintanContract.Controller controller;

    public void instanceClass(GetAlsintanContract.Controller controller){
        this.controller = controller;
    }

    @Override
    public void getAllAlsintan(){
        Call<ResponseGetAlsintan> call = pjApi.getAlsintan(WebServiceModule.ACCESS_TOKEN_TEMP);
        call.enqueue(new Callback<ResponseGetAlsintan>() {
            @Override
            public void onResponse(Call<ResponseGetAlsintan> call, Response<ResponseGetAlsintan> response) {
                if(response.isSuccessful()){
                    if(response.body().isSuccess()){
                        realm.beginTransaction();
                        RealmResults<AlsintanRealm> allAlsintans = realm.where(AlsintanRealm.class).equalTo("isSync",1).findAll();
                        allAlsintans.deleteAllFromRealm();
                        realm.commitTransaction();

                        realm.beginTransaction();
                        realm.executeTransactionAsync(realmkelompok -> realmkelompok.insertOrUpdate(response.body().getData()));
                        realm.commitTransaction();
                        controller.getAllAlsintanSuccess(response.body().getData());
                    }else{
                        controller.getAllAlsintanFailed("Error "+response.message());
                    }
                }else{
                    controller.getAllAlsintanFailed("Server Error "+response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseGetAlsintan> call, Throwable t) {
                Log.e("Failure", "onFailure");
                controller.getAllAlsintanFailed(t.getMessage());
                t.printStackTrace();
            }
        });
    }

    @Override
    public void saveData(List<AlsintanRealm> allPen) {

    }
}
