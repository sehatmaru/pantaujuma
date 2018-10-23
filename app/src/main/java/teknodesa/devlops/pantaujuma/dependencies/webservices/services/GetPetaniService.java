package teknodesa.devlops.pantaujuma.dependencies.webservices.services;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;
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


    public boolean insertData =true;
    @Override
    public void getAllPetani(int idDesa) {
        Call<ResponsePetani> call = sisApi.getAllPetani(WebServiceModule.ACCESS_TOKEN_TEMP, idDesa);
        call.enqueue(new Callback<ResponsePetani>() {
            @Override
            public void onResponse(Call<ResponsePetani> call, Response<ResponsePetani> response) {
                if(response.isSuccessful()){
                    if(response.body().isSuccess()){
                        realm.beginTransaction();
                        RealmResults<PetaniRealm> allPetani = realm.where(PetaniRealm.class).equalTo("isSync",1).findAll();
                        allPetani.deleteAllFromRealm();
                        realm.commitTransaction();

                        realm.beginTransaction();
                        realm.executeTransactionAsync(realmkelompok -> realmkelompok.insertOrUpdate(response.body().getData()));
                        realm.commitTransaction();
                        controller.getAllPetaniSuccess(response.body().getData());
                    }else{
                        controller.getAllPetaniFailed("Error "+response.body().getMessage());
                    }
                }else{
                    controller.getAllPetaniFailed("Server Error "+response.message());
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
    public void saveData(List<PetaniRealm> allPen) {
        for(int i=0; i < allPen.size();i++ ){
            PetaniRealm petaniTempRealm = allPen.get(i);
            PetaniBody petaniBody = new PetaniBody(petaniTempRealm);
            Log.e("petani service",petaniBody.toString());
            final int dataLoop = i;
            Call<ResponseSaveData> call = sisApi.insertPetani(WebServiceModule.ACCESS_TOKEN_TEMP,petaniBody);
            call.enqueue(new Callback<ResponseSaveData>() {
                @Override
                public void onResponse(Call<ResponseSaveData> call, Response<ResponseSaveData> response) {
                    if(response.isSuccessful()){
                        if(response.body().isSuccess()){
                            if (dataLoop == allPen.size()-1) {
                                controller.saveDataSuccess("Success");
                            }
                            insertData =true;
                        }else {
                            insertData =false;
                            controller.saveDataFailed("Gagal Sinkronisasi "+response.body().getMessage());
                        }
                    }else{
                        insertData =false;
                        controller.saveDataFailed("Server Error "+ response.message());
                    }
                }

                @Override
                public void onFailure(Call<ResponseSaveData> call, Throwable t) {
                    insertData =false;
                    controller.saveDataFailed("Failed" + t.getMessage());
                    t.printStackTrace();
                }
            });
            if (!insertData){
                break;
            }
        }
    }

}