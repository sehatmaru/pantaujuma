package teknodesa.devlops.pantaujuma.dependencies.webservices.services;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teknodesa.devlops.pantaujuma.components.splashscreen.SplashscreenContract;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponsePromo;
import teknodesa.devlops.pantaujuma.dependencies.modules.WebServiceModule;
import teknodesa.devlops.pantaujuma.dependencies.webservices.PantauJumaAPI;

/**
 * Created by Marthin on 2/23/2018.
 */

public class PromoService implements SplashscreenContract.Repository {
    @Inject
    PantauJumaAPI mApi;

    @Inject
    EventBus mBus;

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
    public void getPromotion() {
        Log.e("send","data comehere promo service");
        Call<ResponsePromo> call = mApi.getPromotion(WebServiceModule.ACCESS_TOKEN_TEMP);
        call.enqueue(new Callback<ResponsePromo>() {
            @Override
            public void onResponse(Call<ResponsePromo> call, Response<ResponsePromo> response) {

                if(response.isSuccessful()){
                    if(response.body().isSuccess()){
                        realm.beginTransaction();
                        realm.executeTransactionAsync(realmuser -> {
                            realmuser.insertOrUpdate(response.body().getData());
                        });
                        Log.e("result promo",response.body().getData().size()+"result");
                        realm.commitTransaction();
                        String result="";
                        controller.resultPromotion(result);
                    }else
                        controller.resultPromotion(response.body().getMessage());
                }else{
                    String a="";
                    controller.resultPromotion(a);
                }
            }

            @Override
            public void onFailure(Call<ResponsePromo> call, Throwable t) {
                Log.e("Failure", "onFailure");
                controller.resultPromotion(t.getMessage());
                t.printStackTrace();
            }
        });
    }
}
