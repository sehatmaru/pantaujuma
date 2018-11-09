package teknodesa.devlops.pantaujuma.dependencies.webservices.services;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;
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

    public boolean insertTarget =true;

    private boolean res = false;
    @Override
    public void getAllTarget(int idDesa) {
        Call<ResponseTarget> call = sisApi.getAllTargetPetugas(WebServiceModule.ACCESS_TOKEN_TEMP,idDesa);
        call.enqueue(new Callback<ResponseTarget>() {
            @Override
            public void onResponse(Call<ResponseTarget> call, Response<ResponseTarget> response) {
                if(response.isSuccessful()){
                    if(response.body().isSuccess()){
                        realm.beginTransaction();
                        RealmResults<TargetPetugas> allTargets = realm.where(TargetPetugas.class).equalTo("isSync",1).findAll();
                        allTargets.deleteAllFromRealm();
                        realm.commitTransaction();

                        realm.beginTransaction();
                        realm.executeTransactionAsync(realmkelompok -> realmkelompok.insertOrUpdate(response.body().getData()));
                        realm.commitTransaction();
                        controller.getAllTargetSuccess(response.body().getData());
                    }else{
                        controller.getAllTargetFailed("Error "+response.message());
                    }
                }else{
                    controller.getAllTargetFailed("Server Error "+response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseTarget> call, Throwable t) {
                controller.getAllTargetFailed(t.getMessage());
                t.printStackTrace();
            }
        });
    }

    @Override
    public void saveData(List<TargetPetugas> allTar) {
        for(int i=0; i < allTar.size();i++ ){
            TargetPetugas targetTempRealm = allTar.get(i);
            TargetPetugasBody targetBody = new TargetPetugasBody(targetTempRealm);
            final int dataLoop = i;
            Call<ResponseSaveData> call = sisApi.insertTargetPetugas(WebServiceModule.ACCESS_TOKEN_TEMP,targetBody);
            call.enqueue(new Callback<ResponseSaveData>() {
                @Override
                public void onResponse(Call<ResponseSaveData> call, Response<ResponseSaveData> response) {
                    if(response.isSuccessful()){
                        if(response.body().isSuccess()){
                            if (dataLoop == allTar.size()-1) {
                                controller.saveDataSuccess("Success");
                            }
                            insertTarget =true;
                        }else {
                            insertTarget =false;
                            controller.saveDataFailed("Gagal Sinkronisasi "+response.body().getMessage());
                        }

                    }else{
                        insertTarget =false;
                        controller.saveDataFailed("Server Error "+ response.message());
                    }
                }

                @Override
                public void onFailure(Call<ResponseSaveData> call, Throwable t) {
                    insertTarget =false;
                    controller.saveDataFailed("Failed" + t.getMessage());
                    t.printStackTrace();
                }
            });
            if (!insertTarget){
                break;
            }
        }
    }

}