package teknodesa.devlops.pantaujuma.dependencies.webservices.services;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teknodesa.devlops.pantaujuma.components.poktan.GetAnggotaPoktanContract;
import teknodesa.devlops.pantaujuma.components.poktan.GetPoktanContract;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.PoktanBody;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.PoktanRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseAnggotaPoktan;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponsePoktan;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseSaveData;
import teknodesa.devlops.pantaujuma.dependencies.modules.WebServiceModule;
import teknodesa.devlops.pantaujuma.dependencies.webservices.PantauJumaAPI;

/**
 * Created by Marthin on 7/10/2018.
 */

public class GetPoktanService implements GetPoktanContract.Repository {
    @Inject
    PantauJumaAPI sisApi;

    @Inject
    Realm realm;

    public GetPoktanService(AppComponent appComponent) {
        appComponent.inject(this);
    }

    public GetPoktanContract.Controller controller;

    public void instanceClass(GetPoktanContract.Controller controller){
        this.controller = controller;
    }

    private boolean res = false;
    @Override
    public void getAllPoktan(int idDesa) {
        Log.e("send","data comehere "+idDesa);
        Call<ResponsePoktan> call = sisApi.getAllPoktan(WebServiceModule.ACCESS_TOKEN_TEMP, idDesa);
        call.enqueue(new Callback<ResponsePoktan>() {
            @Override
            public void onResponse(Call<ResponsePoktan> call, Response<ResponsePoktan> response) {
                Log.e("ONRESPONSE", "masuk ke onResponse");
                if(response.isSuccessful()){
                    Log.e("ISSUCCESSFULL", "masuk ke isSuccessful");
                    if(response.body().isSuccess()){
                        Log.e("ISSUCCESS", "masuk ke isSuccess");
                        Log.e("hasilpoktan",response.body().getData().size()+" ini");
                        realm.executeTransactionAsync(bgRealm -> bgRealm.insertOrUpdate(response.body().getData()), () -> {
                            controller.getAllPoktanSuccess(response.body().getData());
                            Log.e("executeTransactionAsync", "masuk ke realm");

                        }, error -> {
                            Log.e("getpoktaneror",error.getMessage());
                        });
                    }else
                        controller.getAllPoktanFailed(response.body().getMessage());
                    Log.e("getAllPoktanFailed", "masuk ke getAllPoktanFailed 1");

                }else{
                    controller.getAllPoktanFailed("Server Error");
                    Log.e("getAllPoktanFailed", "masuk ke getAllPoktanFailed 2");

                }
            }

            @Override
            public void onFailure(Call<ResponsePoktan> call, Throwable t) {
                Log.e("FAILUEEEEEEERRRR", "masuk ke FAILUREEE");
                Log.e("Failure", "onFailure");
                controller.getAllPoktanFailed(t.getMessage());
                t.printStackTrace();
            }
        });
    }

    @Override
    public void saveData(List<PoktanRealm> allPen) {
        for(int i=0; i < allPen.size();i++ ){
            PoktanRealm poktanTempRealm = allPen.get(i);
            realm.beginTransaction();
            poktanTempRealm.setIsSync(1);
            realm.commitTransaction();
            PoktanBody poktanBody = new PoktanBody(poktanTempRealm.getHashId(),poktanTempRealm.getNama(),
                    poktanTempRealm.getDesa(),poktanTempRealm.getKecamatan(),poktanTempRealm.getTanggalDidirikan(),
                    poktanTempRealm.getAlamat(), poktanTempRealm.getNoHP(), poktanTempRealm.getNoTelp(),
                    poktanTempRealm.getDeskripsi(), poktanTempRealm.getStatusPoktan(),poktanTempRealm.getIdDesa());

            Log.e("poktan service",poktanBody.toString());
            Call<ResponseSaveData> call = sisApi.insertPoktan(WebServiceModule.ACCESS_TOKEN_TEMP,poktanBody);
            call.enqueue(new Callback<ResponseSaveData>() {
                @Override
                public void onResponse(Call<ResponseSaveData> call, Response<ResponseSaveData> response) {
                    if(response.isSuccessful()){
                        if(response.body().isSuccess()){

                            controller.saveDataSuccess("Success",poktanTempRealm);
                        }else {
                            controller.saveDataFailed("Failed"+response.body().getMessage());
                        }

                    }else{
                        Log.e("poktan service","Error3"+response.toString());
                        controller.saveDataFailed("Failed");
                    }
                }

                @Override
                public void onFailure(Call<ResponseSaveData> call, Throwable t) {
                    Log.e("poktan service","error server"+t.getMessage());
                    controller.saveDataFailed("Failed"+t.getMessage());
                    t.printStackTrace();
                }
            });
        }
    }

    public void getAllAnggotaPoktan(int idDesa){

        Call<ResponseAnggotaPoktan> call = sisApi.getAllAnggotaPoktan(WebServiceModule.ACCESS_TOKEN_TEMP, idDesa);
        call.enqueue(new Callback<ResponseAnggotaPoktan>() {
            @Override
            public void onResponse(Call<ResponseAnggotaPoktan> call, Response<ResponseAnggotaPoktan> response) {
                if(response.isSuccessful()){
                    if(response.body().isSuccess()){
                        realm.beginTransaction();
                        realm.executeTransactionAsync(realmpupuk -> {
                            realmpupuk.insertOrUpdate(response.body().getData());
                        });
                        realm.commitTransaction();

                        Log.e("dataAnggota", " berjumlah " + response.body().getData().size());
                    }
                }else{

                }
            }

            @Override
            public void onFailure(Call<ResponseAnggotaPoktan> call, Throwable t) {

                t.printStackTrace();
            }
        });
    }
}