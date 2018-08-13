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


    private boolean res = false;
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
    public void saveData(List<RDKKPupukSubsidiRealm> allPen) {
        for(int i=0; i < allPen.size();i++ ){
            RDKKPupukSubsidiRealm rdkkTempRealm = allPen.get(i);
            realm.beginTransaction();
            rdkkTempRealm.setIsSync(1);
            realm.commitTransaction();
            RDKKBody rdkkBody = new RDKKBody(
                    rdkkTempRealm.getHashId(),
                    rdkkTempRealm.getIdDesa(),
                    rdkkTempRealm.getPetugas(),
                    rdkkTempRealm.getPoktan(),
                    rdkkTempRealm.getPetani(),
                    rdkkTempRealm.getKomoditas(),
                    rdkkTempRealm.getPupuk(),
                    rdkkTempRealm.getButuhJanuari(),
                    rdkkTempRealm.getButuhFebruari(),
                    rdkkTempRealm.getButuhMaret(),
                    rdkkTempRealm.getButuhApril(),
                    rdkkTempRealm.getButuhMei(),
                    rdkkTempRealm.getButuhJuni(),
                    rdkkTempRealm.getButuhJuli(),
                    rdkkTempRealm.getButuhAgustus(),
                    rdkkTempRealm.getButuhSeptember(),
                    rdkkTempRealm.getButuhOktober(),
                    rdkkTempRealm.getButuhNovember(),
                    rdkkTempRealm.getButuhDesember());

            Log.e("rdkk service",rdkkBody.toString());
            Call<ResponseSaveData> call = sisApi.insertRDKK(WebServiceModule.ACCESS_TOKEN_TEMP,rdkkBody);
            call.enqueue(new Callback<ResponseSaveData>() {
                @Override
                public void onResponse(Call<ResponseSaveData> call, Response<ResponseSaveData> response) {
                    if(response.isSuccessful()){
                        if(response.body().isSuccess()){

                            controller.saveDataSuccess("Success",rdkkTempRealm);
                        }else {
                            controller.saveDataFailed("Failed"+response.body().getMessage());
                        }

                    }else{
                        Log.e("rdkk service","Error3"+response.toString());
                        controller.saveDataFailed("Failed");
                    }
                }

                @Override
                public void onFailure(Call<ResponseSaveData> call, Throwable t) {
                    Log.e("rdkk service","error server"+t.getMessage());
                    controller.saveDataFailed("Failed"+t.getMessage());
                    t.printStackTrace();
                }
            });
        }
    }
}
