package teknodesa.devlops.pantaujuma.dependencies.webservices.services;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teknodesa.devlops.pantaujuma.components.rktp.GetRKTPContract;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.RKTPBody;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.rktp.RKTPRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseRKTP;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseSaveData;
import teknodesa.devlops.pantaujuma.dependencies.modules.WebServiceModule;
import teknodesa.devlops.pantaujuma.dependencies.webservices.PantauJumaAPI;

public class GetRKTPService implements GetRKTPContract.Repository {
    @Inject
    PantauJumaAPI sisApi;

    @Inject
    Realm realm;

    public GetRKTPService(AppComponent appComponent) {
        appComponent.inject(this);
    }

    public GetRKTPContract.Controller controller;

    public void instanceClass(GetRKTPContract.Controller controller) {
        this.controller = controller;
    }

    private boolean insertRKTP = true;

    @Override
    public void getAllRKTP(int idDesa) {
        Log.e("send", "data comehere" + idDesa);
        Call<ResponseRKTP> call = sisApi.getAllRKTP(WebServiceModule.ACCESS_TOKEN_TEMP, idDesa);
        call.enqueue(new Callback<ResponseRKTP>() {
            @Override
            public void onResponse(Call<ResponseRKTP> call, Response<ResponseRKTP> response) {
                if (response.isSuccessful()) {
                    if (response.body().isSuccess()) {
                        Log.e("hasiltarget", response.body().getData().size() + " ini");
                        realm.executeTransactionAsync(bgRealm -> bgRealm.insertOrUpdate(response.body().getData()), () -> {
                            controller.getAllRKTPSuccess(response.body().getData());
                        }, error -> {
                            Log.e("gettargeteror", error.getMessage());
                        });
                    } else
                        controller.getAllRKTPFailed(response.body().getMessage());
                } else {
                    controller.getAllRKTPFailed("Server Error");
                }
            }

            @Override
            public void onFailure(Call<ResponseRKTP> call, Throwable t) {
                Log.e("Failure", "onFailure");
                controller.getAllRKTPFailed(t.getMessage());
                t.printStackTrace();
            }
        });
    }

    @Override
    public void saveData(List<RKTPRealm> allRKTP) {
        for(int i=0; i < allRKTP.size();i++ ){
            RKTPRealm rktpTempRealm = allRKTP.get(i);
            RKTPBody rktpBody = new RKTPBody(rktpTempRealm);
            Log.e("rktp service",rktpBody.toString());
            final int dataLoop = i;
            Call<ResponseSaveData> call = sisApi.insertRktp(WebServiceModule.ACCESS_TOKEN_TEMP,rktpBody);
            call.enqueue(new Callback<ResponseSaveData>() {
                @Override
                public void onResponse(Call<ResponseSaveData> call, Response<ResponseSaveData> response) {
                    if(response.isSuccessful()){
                        if(response.body().isSuccess()){
                            if (dataLoop == allRKTP.size()-1) {
                                controller.saveDataSuccess("Success");
                            }
                            insertRKTP =true;
                        }else {
                            insertRKTP =false;
                            controller.saveDataFailed("Gagal Sinkronisasi "+response.body().getMessage());
                        }

                    }else{
                        insertRKTP =false;
                        controller.saveDataFailed("Server Error "+ response.message());
                    }
                }

                @Override
                public void onFailure(Call<ResponseSaveData> call, Throwable t) {
                    insertRKTP =false;
                    controller.saveDataFailed("Failed" + t.getMessage());
                    t.printStackTrace();
                }
            });
            if (!insertRKTP){
                break;
            }
        }
    }
}
