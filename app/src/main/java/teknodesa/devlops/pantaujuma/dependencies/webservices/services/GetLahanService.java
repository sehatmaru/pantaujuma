package teknodesa.devlops.pantaujuma.dependencies.webservices.services;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teknodesa.devlops.pantaujuma.components.lahan.GetLahanContract;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.lahan.LahanBody;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.lahan.LahanRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseLahan;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseSaveData;
import teknodesa.devlops.pantaujuma.dependencies.modules.WebServiceModule;
import teknodesa.devlops.pantaujuma.dependencies.webservices.PantauJumaAPI;

public class GetLahanService implements GetLahanContract.Repository {
    @Inject
    PantauJumaAPI sisApi;

    @Inject
    Realm realm;

    public GetLahanService(AppComponent appComponent) {
        appComponent.inject(this);
    }

    public GetLahanContract.Controller controller;

    public void instanceClass(GetLahanContract.Controller controller){
        this.controller = controller;
    }


    private boolean res = false;
    @Override
    public void getAllLahan(int idDesa) {
        Log.e("send","data comehere"+idDesa);
        Call<ResponseLahan> call = sisApi.getAllLahan(WebServiceModule.ACCESS_TOKEN_TEMP,idDesa);
        call.enqueue(new Callback<ResponseLahan>() {
            @Override
            public void onResponse(Call<ResponseLahan> call, Response<ResponseLahan> response) {
                if(response.isSuccessful()){
                    if(response.body().isSuccess()){
                        Log.e("hasillahan",response.body().getData().size()+" ini");
                        realm.executeTransactionAsync(bgRealm -> bgRealm.insertOrUpdate(response.body().getData()), () -> {
                            controller.getAllLahanSuccess(response.body().getData());
                        }, error -> {
                            Log.e("getlahaneror",error.getMessage());
                        });
                    }else
                        controller.getAllLahanFailed(response.body().getMessage());
                }else{
                    controller.getAllLahanFailed("Server Error");
                }
            }

            @Override
            public void onFailure(Call<ResponseLahan> call, Throwable t) {
                Log.e("Failure", "onFailure");
                controller.getAllLahanFailed(t.getMessage());
                t.printStackTrace();
            }
        });
    }

    @Override
    public void saveData(List<LahanRealm> allPen) {
        for(int i=0; i < allPen.size();i++ ){
            LahanRealm lahanTempRealm = allPen.get(i);
            realm.beginTransaction();
            lahanTempRealm.setIsSync(1);
            realm.commitTransaction();
            LahanBody lahanBody = new LahanBody(lahanTempRealm.getHashId(),
                    lahanTempRealm.getHashId(),
                    lahanTempRealm.getIdDesa(),
                    lahanTempRealm.getPemilik(),
                    lahanTempRealm.getNamaPemilikLahan(),
                    lahanTempRealm.getAlamat(),
                    lahanTempRealm.getRt(),
                    lahanTempRealm.getRw(),
                    lahanTempRealm.getDusun(),
                    lahanTempRealm.getDesa(),
                    lahanTempRealm.getNamaKecamatan(),
                    lahanTempRealm.getDatiII(),
                    lahanTempRealm.getProvinsi(),
                    lahanTempRealm.getLongitude(),
                    lahanTempRealm.getLatitude(),
                    lahanTempRealm.getLuas(),
                    lahanTempRealm.getBatasTimur(),
                    lahanTempRealm.getBatasBarat(),
                    lahanTempRealm.getBatasSelatan(),
                    lahanTempRealm.getBatasUtara(),
                    lahanTempRealm.getDeskripsi(),
                    lahanTempRealm.getStatus());

            Log.e("lahan service",lahanBody.toString());
            Call<ResponseSaveData> call = sisApi.insertLahan(WebServiceModule.ACCESS_TOKEN_TEMP,lahanBody);
            call.enqueue(new Callback<ResponseSaveData>() {
                @Override
                public void onResponse(Call<ResponseSaveData> call, Response<ResponseSaveData> response) {
                    if(response.isSuccessful()){
                        if(response.body().isSuccess()){

                            controller.saveDataSuccess("Success",lahanTempRealm);
                        }else {
                            controller.saveDataFailed("Failed"+response.body().getMessage());
                        }

                    }else{
                        Log.e("lahan service","Error3"+response.toString());
                        controller.saveDataFailed("Failed");
                    }
                }

                @Override
                public void onFailure(Call<ResponseSaveData> call, Throwable t) {
                    Log.e("lahan service","error server"+t.getMessage());
                    controller.saveDataFailed("Failed"+t.getMessage());
                    t.printStackTrace();
                }
            });
        }
    }
}
