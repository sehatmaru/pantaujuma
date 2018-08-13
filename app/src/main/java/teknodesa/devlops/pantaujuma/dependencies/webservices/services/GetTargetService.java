package teknodesa.devlops.pantaujuma.dependencies.webservices.services;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teknodesa.devlops.pantaujuma.components.petugas.GetTargetContract;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.TargetPetugasBody;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.petugas.TargetPetugas;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseSaveData;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseTarget;
import teknodesa.devlops.pantaujuma.dependencies.modules.WebServiceModule;
import teknodesa.devlops.pantaujuma.dependencies.webservices.PantauJumaAPI;

public class GetTargetService implements GetTargetContract.Repository {
    @Inject
    PantauJumaAPI sisApi;

    @Inject
    Realm realm;

    public GetTargetService(AppComponent appComponent) {
        appComponent.inject(this);
    }

    public GetTargetContract.Controller controller;

    public void instanceClass(GetTargetContract.Controller controller){
        this.controller = controller;
    }


    private boolean res = false;
    @Override
    public void getAllTarget(int idDesa) {
        Log.e("send","data comehere"+idDesa);
        Call<ResponseTarget> call = sisApi.getAllTargetPetugas(WebServiceModule.ACCESS_TOKEN_TEMP,idDesa);
        call.enqueue(new Callback<ResponseTarget>() {
            @Override
            public void onResponse(Call<ResponseTarget> call, Response<ResponseTarget> response) {
                if(response.isSuccessful()){
                    if(response.body().isSuccess()){
                        Log.e("hasiltarget",response.body().getData().size()+" ini");
                        realm.executeTransactionAsync(bgRealm -> bgRealm.insertOrUpdate(response.body().getData()), () -> {
                            controller.getAllTargetSuccess(response.body().getData());
                        }, error -> {
                            Log.e("gettargeteror",error.getMessage());
                        });
                    }else
                        controller.getAllTargetFailed(response.body().getMessage());
                }else{
                    controller.getAllTargetFailed("Server Error");
                }
            }

            @Override
            public void onFailure(Call<ResponseTarget> call, Throwable t) {
                Log.e("Failure", "onFailure");
                controller.getAllTargetFailed(t.getMessage());
                t.printStackTrace();
            }
        });
    }

    @Override
    public void saveData(List<TargetPetugas> allTar) {
        for(int i=0; i < allTar.size();i++ ){
            TargetPetugas targetTempRealm = allTar.get(i);
            realm.beginTransaction();
            targetTempRealm.setIsSync(1);
            realm.commitTransaction();
            TargetPetugasBody targetPetugasBody = new TargetPetugasBody(targetTempRealm.getHashId(),targetTempRealm.getPetugas(),
                    targetTempRealm.getIdDesa(),targetTempRealm.getTahun(),targetTempRealm.getKomoditas(),targetTempRealm.getLuasTanam(),
                    targetTempRealm.getLuasPanen(),targetTempRealm.getSasaranProduksi(),targetTempRealm.getSasaranProduktifitas(),targetTempRealm.getKeterangan());

            Log.e("target service",targetPetugasBody.toString());
            Call<ResponseSaveData> call = sisApi.insertTargetPetugas(WebServiceModule.ACCESS_TOKEN_TEMP,targetPetugasBody);
            call.enqueue(new Callback<ResponseSaveData>() {
                @Override
                public void onResponse(Call<ResponseSaveData> call, Response<ResponseSaveData> response) {
                    if(response.isSuccessful()){
                        if(response.body().isSuccess()){

                            controller.saveDataSuccess("Success",targetTempRealm);
                        }else {
                            controller.saveDataFailed("Failed"+response.body().getMessage());
                        }

                    }else{
                        Log.e("target service","Error3"+response.toString());
                        controller.saveDataFailed("Failed");
                    }
                }

                @Override
                public void onFailure(Call<ResponseSaveData> call, Throwable t) {
                    Log.e("target service","error server"+t.getMessage());
                    controller.saveDataFailed("Failed"+t.getMessage());
                    t.printStackTrace();
                }
            });
        }
    }

}