package teknodesa.devlops.pantaujuma.dependencies.webservices.services;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teknodesa.devlops.pantaujuma.components.alsintan.GetAlsintanContract;
import teknodesa.devlops.pantaujuma.components.lahan.ListLahanKomoditasContract;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.lahan.BodyGetLahan;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.alsintan.AlsintanRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseGetAlsintan;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseGetLahanKomoditas;
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

//    @Override
//    public void getAllAlsintan() {
//        Call<ResponseGetAlsintan> call = pjApi.getAlsintan(WebServiceModule.ACCESS_TOKEN_TEMP);
//        call.enqueue(new Callback<ResponseGetAlsintan>() {
//            @Override
//            public void onResponse(Call<ResponseGetAlsintan> call, Response<ResponseGetAlsintan> response) {
//                if(response.isSuccessful()){
//                    if(response.body().isSuccess()){
//
//                        realm.beginTransaction();
//                        realm.executeTransactionAsync(realm -> {
//                            realm.insertOrUpdate(response.body().getAlat_pertanian());
//                        });
//                        realm.commitTransaction();
//
//                        realm.beginTransaction();
//                        realm.executeTransactionAsync(realm -> {
//                            realm.insertOrUpdate(response.body().getPengecer());
//                        });
//                        realm.commitTransaction();
//
//                        realm.beginTransaction();
//                        realm.executeTransactionAsync(realm -> {
//                            realm.insertOrUpdate(response.body().getPengecer_pupuk());
//                        });
//                        realm.commitTransaction();
//
//                        realm.beginTransaction();
//                        realm.executeTransactionAsync(realm -> {
//                            realm.insertOrUpdate(response.body().getPupuk());
//                        });
//                        realm.commitTransaction();
//                        controller.getAllAlsintanSuccess(response.body().getAlat_pertanian());
//                    }else
//                        controller.getAllAlsintanFailed(response.body().getMessage());
//                }else{
//                    controller.getAllAlsintanFailed("Something Wrong: "+response.message());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseGetAlsintan> call, Throwable t) {
//                Log.e("Failure", "onFailure");
//                controller.getAllAlsintanFailed(t.getMessage());
//                t.printStackTrace();
//            }
//        });
//    }

    @Override
    public void getAllAlsintan(){
        Log.e("send","data comehere");
        Call<ResponseGetAlsintan> call = pjApi.getAlsintan(WebServiceModule.ACCESS_TOKEN_TEMP);
        call.enqueue(new Callback<ResponseGetAlsintan>() {
            @Override
            public void onResponse(Call<ResponseGetAlsintan> call, Response<ResponseGetAlsintan> response) {
                if(response.isSuccessful()){
                    if(response.body().isSuccess()){
                        Log.e("hasilalsintan",response.body().getData().size()+" ini");
                        realm.executeTransactionAsync(bgRealm -> bgRealm.insertOrUpdate(response.body().getData()), () -> {
                            controller.getAllAlsintanSuccess(response.body().getData());
                        }, error -> {
                            Log.e("getalsintanerror",error.getMessage());
                        });
                    }else
                        controller.getAllAlsintanFailed(response.body().getMessage());
                }else{
                    controller.getAllAlsintanFailed("Server Error");
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
