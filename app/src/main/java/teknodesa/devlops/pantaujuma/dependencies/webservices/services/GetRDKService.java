package teknodesa.devlops.pantaujuma.dependencies.webservices.services;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teknodesa.devlops.pantaujuma.components.rdk.GetRDKContract;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.RDKBody;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.rdk.RDKRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseRDK;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseSaveData;
import teknodesa.devlops.pantaujuma.dependencies.modules.WebServiceModule;
import teknodesa.devlops.pantaujuma.dependencies.webservices.PantauJumaAPI;

public class GetRDKService implements GetRDKContract.Repository {
    @Inject
    PantauJumaAPI sisApi;

    @Inject
    Realm realm;

    public GetRDKService(AppComponent appComponent) {
        appComponent.inject(this);
    }

    public GetRDKContract.Controller controller;

    public void instanceClass(GetRDKContract.Controller controller){
        this.controller = controller;
    }
    
    private boolean insertRDK = true;
    
    @Override
    public void getAllRDK(int idDesa) {
        Log.e("send","data comehere"+idDesa);
        Call<ResponseRDK> call = sisApi.getAllRDK(WebServiceModule.ACCESS_TOKEN_TEMP,idDesa);
        call.enqueue(new Callback<ResponseRDK>() {
            @Override
            public void onResponse(Call<ResponseRDK> call, Response<ResponseRDK> response) {
                if(response.isSuccessful()){
                    if(response.body().isSuccess()){
                        Log.e("hasilrdk",response.body().getData().size()+" ini");
                        realm.executeTransactionAsync(bgRealm -> bgRealm.insertOrUpdate(response.body().getData()), () -> {
                            controller.getAllRDKSuccess(response.body().getData());
                        }, error -> {
                            Log.e("getrdkeror",error.getMessage());
                        });
                    }else
                        controller.getAllRDKFailed(response.body().getMessage());
                }else{
                    controller.getAllRDKFailed("Server Error");
                }
            }

            @Override
            public void onFailure(Call<ResponseRDK> call, Throwable t) {
                Log.e("Failure", "onFailure");
                controller.getAllRDKFailed(t.getMessage());
                t.printStackTrace();
            }
        });
    }

    @Override
    public void saveData(List<RDKRealm> allRDK) {
        for(int i=0; i < allRDK.size();i++ ){
            RDKRealm rdkTempRealm = allRDK.get(i);
            RDKBody rdkBody = new RDKBody(rdkTempRealm);
//            Log.e("body rdk",rdkBody.toString());
//            Log.e("realm rdk",rdkTempRealm.toString());
            final int dataLoop = i;
            Call<ResponseSaveData> call = sisApi.insertRDK(WebServiceModule.ACCESS_TOKEN_TEMP,rdkBody);
            call.enqueue(new Callback<ResponseSaveData>() {
                @Override
                public void onResponse(Call<ResponseSaveData> call, Response<ResponseSaveData> response) {
                    if(response.isSuccessful()){
                        if(response.body().isSuccess()){
                            if (dataLoop == allRDK.size()-1) {
                                controller.saveDataSuccess("Success");
                            }
                            insertRDK =true;
                        }else {
                            insertRDK =false;
                            controller.saveDataFailed("Gagal Sinkronisasi "+response.body().getMessage());
                        }

                    }else{
                        insertRDK =false;
                        controller.saveDataFailed("Server Error "+ response.message());
                    }
                }

                @Override
                public void onFailure(Call<ResponseSaveData> call, Throwable t) {
                    insertRDK =false;
                    controller.saveDataFailed("Failed" + t.getMessage());
                    t.printStackTrace();
                }
            });
            if (!insertRDK){
                break;
            }
        }
    }

}
