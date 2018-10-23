package teknodesa.devlops.pantaujuma.dependencies.webservices.services;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teknodesa.devlops.pantaujuma.components.poktan.GetPengurusPoktanContract;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.PengurusPoktanBody;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.PengurusPoktanRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponsePengurusPoktan;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseSaveData;
import teknodesa.devlops.pantaujuma.dependencies.modules.WebServiceModule;
import teknodesa.devlops.pantaujuma.dependencies.webservices.PantauJumaAPI;

/**
 * Created by Marthin on 7/10/2018.
 */

public class GetPengurusPoktanService implements GetPengurusPoktanContract.Repository {
    @Inject
    PantauJumaAPI sisApi;

    @Inject
    Realm realm;

    public GetPengurusPoktanService(AppComponent appComponent) {
        appComponent.inject(this);
    }

    public GetPengurusPoktanContract.Controller controller;

    public void instanceClass(GetPengurusPoktanContract.Controller controller){
        this.controller = controller;
    }


    private boolean res = false;
    @Override
    public void getAllPengurusPoktan(int idDesa) {
        Log.e("send","data comehere "+idDesa);
        Call<ResponsePengurusPoktan> call = sisApi.getAllPengurusPoktan(WebServiceModule.ACCESS_TOKEN_TEMP, idDesa);
        call.enqueue(new Callback<ResponsePengurusPoktan>() {
            @Override
            public void onResponse(Call<ResponsePengurusPoktan> call, Response<ResponsePengurusPoktan> response) {
                Log.e("ONRESPONSE", "masuk ke onResponse");
                if(response.isSuccessful()){
                    Log.e("ISSUCCESSFULL", "masuk ke isSuccessful");
                    if(response.body().isSuccess()){
                        Log.e("ISSUCCESS", "masuk ke isSuccess");
                        Log.e("hasilpengurusPoktan",response.body().getData().size()+" ini");
                        realm.executeTransactionAsync(bgRealm -> bgRealm.insertOrUpdate(response.body().getData()), () -> {
                            controller.getAllPengurusPoktanSuccess(response.body().getData());
                            Log.e("executeTransactionAsync", "masuk ke realm");

                        }, error -> {
                            Log.e("getpengurusPoktaneror",error.getMessage());
                        });
                    }else
                        controller.getAllPengurusPoktanFailed(response.body().getMessage());
                    Log.e("getPengurusPoktanFailed", "masuk ke getAllPengurusPoktanFailed 1");

                }else{
                    controller.getAllPengurusPoktanFailed("Server Error");
                    Log.e("getPengurusPoktanFailed", "masuk ke getAllPengurusPoktanFailed 2");
                }
            }

            @Override
            public void onFailure(Call<ResponsePengurusPoktan> call, Throwable t) {
                Log.e("FAILUEEEEEEERRRR", "masuk ke FAILUREEE");
                Log.e("Failure", "onFailure");
                controller.getAllPengurusPoktanFailed(t.getMessage());
                t.printStackTrace();
            }
        });
    }

    @Override
    public void saveData(List<PengurusPoktanRealm> allPen) {
        for(int i=0; i < allPen.size();i++ ){
            PengurusPoktanRealm pengurusPoktanTempRealm = allPen.get(i);
            realm.beginTransaction();
            pengurusPoktanTempRealm.setIsSync(1);
            realm.commitTransaction();
            PengurusPoktanBody pengurusPoktanBody = new PengurusPoktanBody(pengurusPoktanTempRealm.getHashId(),pengurusPoktanTempRealm.getPoktanPengurus(),
                    pengurusPoktanTempRealm.getPetaniPengurus(),pengurusPoktanTempRealm.getJabatan(),pengurusPoktanTempRealm.getPeriode(),
                    pengurusPoktanTempRealm.getStatusPengurus(), pengurusPoktanTempRealm.getIdDesa());

            Log.e("pengurusPoktan service",pengurusPoktanBody.toString());
            Call<ResponseSaveData> call = sisApi.insertPengurusPoktan(WebServiceModule.ACCESS_TOKEN_TEMP,pengurusPoktanBody);
            call.enqueue(new Callback<ResponseSaveData>() {
                @Override
                public void onResponse(Call<ResponseSaveData> call, Response<ResponseSaveData> response) {
                    if(response.isSuccessful()){
                        if(response.body().isSuccess()){

                            controller.saveDataSuccess("Success",pengurusPoktanTempRealm);
                        }else {
                            controller.saveDataFailed("Failed"+response.body().getMessage());
                        }

                    }else{
                        Log.e("pengurusPoktan service","Error3"+response.toString());
                        controller.saveDataFailed("Failed");
                    }
                }

                @Override
                public void onFailure(Call<ResponseSaveData> call, Throwable t) {
                    Log.e("pengurusPoktan service","error server"+t.getMessage());
                    controller.saveDataFailed("Failed"+t.getMessage());
                    t.printStackTrace();
                }
            });
        }
    }

}