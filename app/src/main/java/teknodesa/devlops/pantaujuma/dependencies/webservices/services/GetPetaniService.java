package teknodesa.devlops.pantaujuma.dependencies.webservices.services;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teknodesa.devlops.pantaujuma.components.petani.GetPetaniContract;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.PetaniBody;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.petani.PetaniRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponsePetani;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseSaveData;
import teknodesa.devlops.pantaujuma.dependencies.modules.WebServiceModule;
import teknodesa.devlops.pantaujuma.dependencies.webservices.PantauJumaAPI;

/**
 * Created by Marthin on 7/10/2018.
 */

public class GetPetaniService implements GetPetaniContract.Repository {
    @Inject
    PantauJumaAPI sisApi;

    @Inject
    Realm realm;

    public GetPetaniService(AppComponent appComponent) {
        appComponent.inject(this);
    }

    public GetPetaniContract.Controller controller;

    public void instanceClass(GetPetaniContract.Controller controller){
        this.controller = controller;
    }


    private boolean res = false;
    @Override
    public void getAllPetani(int idDesa) {
        Log.e("send","data comehere"+idDesa);
        Call<ResponsePetani> call = sisApi.getAllPetani(WebServiceModule.ACCESS_TOKEN_TEMP,idDesa);
        call.enqueue(new Callback<ResponsePetani>() {
            @Override
            public void onResponse(Call<ResponsePetani> call, Response<ResponsePetani> response) {
                if(response.isSuccessful()){
                    if(response.body().isSuccess()){
                        Log.e("hasilpetani",response.body().getData().size()+" ini");
                        realm.executeTransactionAsync(bgRealm -> bgRealm.insertOrUpdate(response.body().getData()), () -> {
                            controller.getAllPetaniSuccess(response.body().getData());
                        }, error -> {
                            Log.e("getpetanieror",error.getMessage());
                        });
                    }else
                        controller.getAllPetaniFailed(response.body().getMessage());
                }else{
                    controller.getAllPetaniFailed("Server Error");
                }
            }

            @Override
            public void onFailure(Call<ResponsePetani> call, Throwable t) {
                Log.e("Failure", "onFailure");
                controller.getAllPetaniFailed(t.getMessage());
                t.printStackTrace();
            }
        });
    }

    @Override
    public void saveData(List<PetaniRealm> allTar) {
        for(int i=0; i < allTar.size();i++ ){
            PetaniRealm petaniTempRealm = allTar.get(i);
            realm.beginTransaction();
            petaniTempRealm.setIsSync(1);
            realm.commitTransaction();
            PetaniBody petaniBody = new PetaniBody(petaniTempRealm.getHashId(),petaniTempRealm.getBiodata(),
                    petaniTempRealm.getDeskripsi(),petaniTempRealm.getStatus(),petaniTempRealm.getDeskripsi());

            Log.e("petani service",petaniBody.toString());
            Call<ResponseSaveData> call = sisApi.insertPetani(WebServiceModule.ACCESS_TOKEN_TEMP,petaniBody);
            call.enqueue(new Callback<ResponseSaveData>() {
                @Override
                public void onResponse(Call<ResponseSaveData> call, Response<ResponseSaveData> response) {
                    if(response.isSuccessful()){
                        if(response.body().isSuccess()){

                            controller.saveDataSuccess("Success",petaniTempRealm);
                        }else {
                            controller.saveDataFailed("Failed"+response.body().getMessage());
                        }

                    }else{
                        Log.e("petani service","Error3"+response.toString());
                        controller.saveDataFailed("Failed");
                    }
                }

                @Override
                public void onFailure(Call<ResponseSaveData> call, Throwable t) {
                    Log.e("petani service","error server"+t.getMessage());
                    controller.saveDataFailed("Failed"+t.getMessage());
                    t.printStackTrace();
                }
            });
        }
    }

}