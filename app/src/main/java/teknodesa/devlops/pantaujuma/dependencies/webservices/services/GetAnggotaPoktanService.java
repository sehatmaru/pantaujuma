package teknodesa.devlops.pantaujuma.dependencies.webservices.services;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teknodesa.devlops.pantaujuma.components.poktan.GetAnggotaPoktanContract;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.AnggotaPoktanBody;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.AnggotaPoktanRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseAnggotaPoktan;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseSaveData;
import teknodesa.devlops.pantaujuma.dependencies.modules.WebServiceModule;
import teknodesa.devlops.pantaujuma.dependencies.webservices.PantauJumaAPI;

/**
 * Created by Marthin on 7/10/2018.
 */

public class GetAnggotaPoktanService implements GetAnggotaPoktanContract.Repository {
    @Inject
    PantauJumaAPI sisApi;

    @Inject
    Realm realm;

    public GetAnggotaPoktanService(AppComponent appComponent) {
        appComponent.inject(this);
    }

    public GetAnggotaPoktanContract.Controller controller;

    public void instanceClass(GetAnggotaPoktanContract.Controller controller){
        this.controller = controller;
    }


    private boolean res = false;
    @Override
    public void getAllAnggotaPoktan(int idDesa) {
        Log.e("send","data comehere "+idDesa);
        Call<ResponseAnggotaPoktan> call = sisApi.getAllAnggotaPoktan(WebServiceModule.ACCESS_TOKEN_TEMP, idDesa);
        call.enqueue(new Callback<ResponseAnggotaPoktan>() {
            @Override
            public void onResponse(Call<ResponseAnggotaPoktan> call, Response<ResponseAnggotaPoktan> response) {
                Log.e("ONRESPONSE", "masuk ke onResponse");
                if(response.isSuccessful()){
                    Log.e("ISSUCCESSFULL", "masuk ke isSuccessful");
                    if(response.body().isSuccess()){
                        Log.e("ISSUCCESS", "masuk ke isSuccess");
                        Log.e("hasilanggotaPoktan",response.body().getData().size()+" ini");
                        realm.executeTransactionAsync(bgRealm -> bgRealm.insertOrUpdate(response.body().getData()), () -> {
                            controller.getAllAnggotaPoktanSuccess(response.body().getData());
                            Log.e("executeTransactionAsync", "masuk ke realm");

                        }, error -> {
                            Log.e("getanggotaPoktaneror",error.getMessage());
                        });
                    }else
                        controller.getAllAnggotaPoktanFailed(response.body().getMessage());
                    Log.e("getAnggotaPoktanFailed", "masuk ke getAllAnggotaPoktanFailed 1");

                }else{
                    controller.getAllAnggotaPoktanFailed("Server Error");
                    Log.e("getAnggotaPoktanFailed", "masuk ke getAllAnggotaPoktanFailed 2");
                }
            }

            @Override
            public void onFailure(Call<ResponseAnggotaPoktan> call, Throwable t) {
                Log.e("FAILUEEEEEEERRRR", "masuk ke FAILUREEE");
                Log.e("Failure", "onFailure");
                controller.getAllAnggotaPoktanFailed(t.getMessage());
                t.printStackTrace();
            }
        });
    }

    @Override
    public void saveData(List<AnggotaPoktanRealm> allPen) {
        for(int i=0; i < allPen.size();i++ ){
            AnggotaPoktanRealm anggotaPoktanTempRealm = allPen.get(i);
            realm.beginTransaction();
            anggotaPoktanTempRealm.setIsSync(1);
            realm.commitTransaction();
            AnggotaPoktanBody anggotaPoktanBody = new AnggotaPoktanBody(anggotaPoktanTempRealm.getHashId(),anggotaPoktanTempRealm.getPoktanAnggota(),
                    anggotaPoktanTempRealm.getPetaniAnggota(),anggotaPoktanTempRealm.getTanggalMasuk(),anggotaPoktanTempRealm.getStatusAnggota(),
                    anggotaPoktanTempRealm.getIdDesa());

            Log.e("anggotaPoktan service",anggotaPoktanBody.toString());
            Call<ResponseSaveData> call = sisApi.insertAnggotaPoktan(WebServiceModule.ACCESS_TOKEN_TEMP,anggotaPoktanBody);
            call.enqueue(new Callback<ResponseSaveData>() {
                @Override
                public void onResponse(Call<ResponseSaveData> call, Response<ResponseSaveData> response) {
                    if(response.isSuccessful()){
                        if(response.body().isSuccess()){

                            controller.saveDataSuccess("Success",anggotaPoktanTempRealm);
                        }else {
                            controller.saveDataFailed("Failed"+response.body().getMessage());
                        }

                    }else{
                        Log.e("anggotaPoktan service","Error3"+response.toString());
                        controller.saveDataFailed("Failed");
                    }
                }

                @Override
                public void onFailure(Call<ResponseSaveData> call, Throwable t) {
                    Log.e("anggotaPoktan service","error server"+t.getMessage());
                    controller.saveDataFailed("Failed"+t.getMessage());
                    t.printStackTrace();
                }
            });
        }
    }

}