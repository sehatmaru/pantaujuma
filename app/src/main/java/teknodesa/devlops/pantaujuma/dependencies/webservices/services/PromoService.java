package teknodesa.devlops.pantaujuma.dependencies.webservices.services;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;
import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teknodesa.devlops.pantaujuma.components.splashscreen.SplashscreenContract;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.Promotion;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.alsintan.PupukRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.pasar.PasarRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseGetPasar;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseGetPupuk;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseInitializeData;
import teknodesa.devlops.pantaujuma.dependencies.modules.WebServiceModule;
import teknodesa.devlops.pantaujuma.dependencies.webservices.PantauJumaAPI;

/**
 * Created by Marthin on 2/23/2018.
 */

public class PromoService implements SplashscreenContract.Repository {
    @Inject
    PantauJumaAPI mApi;

    @Inject
    Realm realm;

    public PromoService(AppComponent appComponent) {
        appComponent.inject(this);
    }

    public SplashscreenContract.Controller controller;

    public void instanceClass(SplashscreenContract.Controller controller){
        this.controller = controller;
    }



    @Override
    public void getInitializeData() {
        realm.beginTransaction();
        RealmResults<Promotion> slider =realm.where(Promotion.class).findAll();
        RealmResults<PupukRealm> pupuks =realm.where(PupukRealm.class).findAll();
        RealmResults<PasarRealm> pasars =realm.where(PasarRealm.class).findAll();
        pasars.deleteAllFromRealm();
        pupuks.deleteAllFromRealm();
        slider.deleteAllFromRealm();
        realm.commitTransaction();
        Call<ResponseInitializeData> call = mApi.getInitializeData(WebServiceModule.ACCESS_TOKEN_TEMP);
        call.enqueue(new Callback<ResponseInitializeData>() {
            @Override
            public void onResponse(Call<ResponseInitializeData> call, Response<ResponseInitializeData> response) {
                if(response.isSuccessful()){
                    if(response.body().isSuccess()){
                        if(response.body().getSlider().size() > 0){
                            realm.beginTransaction();
                            realm.executeTransactionAsync(realmuser -> {
                                realmuser.insertOrUpdate(response.body().getSlider());
                            });
                            realm.commitTransaction();
                        }
                        if(response.body().getPasar().size() > 0){
                            realm.beginTransaction();
                            realm.executeTransactionAsync(realmuser -> {
                                realmuser.insertOrUpdate(response.body().getPasar());
                            });
                            realm.commitTransaction();
                        }
                        if(response.body().getPupuk().size() > 0){
                            realm.beginTransaction();
                            realm.executeTransactionAsync(realmuser -> {
                                realmuser.insertOrUpdate(response.body().getPupuk());
                            });
                            realm.commitTransaction();
                        }
                        controller.getInitializeDataSuccess(response.body().getMessage());
                    }else{
                        controller.getInitializeDataFailed("Error:"+response.body().getMessage());
                    }
                }else{
                    controller.getInitializeDataFailed("Server Error "+response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseInitializeData> call, Throwable t) {
                Log.e("Failure", "onFailure");
                controller.getInitializeDataFailed("Fail Access "+t.getMessage());
                t.printStackTrace();
            }
        });
    }
}
