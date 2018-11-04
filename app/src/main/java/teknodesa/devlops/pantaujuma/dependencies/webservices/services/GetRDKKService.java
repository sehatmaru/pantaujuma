package teknodesa.devlops.pantaujuma.dependencies.webservices.services;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teknodesa.devlops.pantaujuma.components.rdkk.GetRDKKContract;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.RDKKBody;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.rdkk.RDKKPupukSubsidiRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseRDKK;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseSaveData;
import teknodesa.devlops.pantaujuma.dependencies.modules.WebServiceModule;
import teknodesa.devlops.pantaujuma.dependencies.webservices.PantauJumaAPI;

public class GetRDKKService implements GetRDKKContract.Repository {
    @Inject
    PantauJumaAPI sisApi;

    @Inject
    Realm realm;

    public GetRDKKService(AppComponent appComponent) {
        appComponent.inject(this);
    }

    public GetRDKKContract.Controller controller;

    public void instanceClass(GetRDKKContract.Controller controller){
        this.controller = controller;
    }


    private boolean insertRDKK = true;
    @Override
    public void getAllRDKK(int idDesa) {
        Log.e("send","data comehere"+idDesa);
        Call<ResponseRDKK> call = sisApi.getAllRDKK(WebServiceModule.ACCESS_TOKEN_TEMP,idDesa);
        call.enqueue(new Callback<ResponseRDKK>() {
            @Override
            public void onResponse(Call<ResponseRDKK> call, Response<ResponseRDKK> response) {
                if(response.isSuccessful()){
                    if(response.body().isSuccess()){
                        Log.e("hasilrdkk",response.body().getData().size()+" ini");
                        realm.executeTransactionAsync(bgRealm -> bgRealm.insertOrUpdate(response.body().getData()), () -> {
                            controller.getAllRDKKSuccess(response.body().getData());
                        }, error -> {
                            Log.e("getrdkkeror",error.getMessage());
                        });
                    }else
                        controller.getAllRDKKFailed(response.body().getMessage());
                }else{
                    controller.getAllRDKKFailed("Server Error");
                }
            }

            @Override
            public void onFailure(Call<ResponseRDKK> call, Throwable t) {
                Log.e("Failure", "onFailure");
                controller.getAllRDKKFailed(t.getMessage());
                t.printStackTrace();
            }
        });
    }

    @Override
    public void saveData(List<RDKKPupukSubsidiRealm> allRDKK) {
        for(int i=0; i < allRDKK.size();i++ ){
            RDKKPupukSubsidiRealm rdkkTempRealm = allRDKK.get(i);
            RDKKBody rdkkBody = new RDKKBody(rdkkTempRealm);
            final int dataLoop = i;
            Call<ResponseSaveData> call = sisApi.insertRDKK(WebServiceModule.ACCESS_TOKEN_TEMP,rdkkBody);
            call.enqueue(new Callback<ResponseSaveData>() {
                @Override
                public void onResponse(Call<ResponseSaveData> call, Response<ResponseSaveData> response) {
                    if(response.isSuccessful()){
                        if(response.body().isSuccess()){
                            if (dataLoop == allRDKK.size()-1) {
                                controller.saveDataSuccess("Success");
                            }
                            insertRDKK =true;
                        }else {
                            insertRDKK =false;
                            controller.saveDataFailed("Gagal Sinkronisasi "+response.body().getMessage());
                        }

                    }else{
                        insertRDKK =false;
                        controller.saveDataFailed("Server Error "+ response.message());
                    }
                }

                @Override
                public void onFailure(Call<ResponseSaveData> call, Throwable t) {
                    insertRDKK =false;
                    controller.saveDataFailed("Failed" + t.getMessage());
                    t.printStackTrace();
                }
            });
            if (!insertRDKK){
                break;
            }
        }
    }
}
