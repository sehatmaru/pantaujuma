package teknodesa.devlops.pantaujuma.dependencies.webservices.services;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teknodesa.devlops.pantaujuma.components.lahan.GetLahanContract;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.komoditas.LahanBody;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.LahanRealm;
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
    public boolean insertLahan =true;
    @Override
    public void getAllLahan(int idDesa) {
        Call<ResponseLahan> call = sisApi.getAllLahan(WebServiceModule.ACCESS_TOKEN_TEMP,idDesa);
        call.enqueue(new Callback<ResponseLahan>() {
            @Override
            public void onResponse(Call<ResponseLahan> call, Response<ResponseLahan> response) {
                if(response.isSuccessful()){
                    if(response.body().isSuccess()){
                        realm.beginTransaction();
                        RealmResults<LahanRealm> dataLahan = realm.where(LahanRealm.class).equalTo("isSync",1).findAll();
                        dataLahan.deleteAllFromRealm();
                        realm.commitTransaction();

                        realm.executeTransactionAsync(bgRealm -> bgRealm.insertOrUpdate(response.body().getData()), () -> {
                            controller.getAllLahanSuccess(response.body().getData());
                        }, error -> {
                        });
                    }else
                        controller.getAllLahanFailed(response.body().getMessage());
                }else{
                    controller.getAllLahanFailed("Server Error");
                }
            }

            @Override
            public void onFailure(Call<ResponseLahan> call, Throwable t) {
                controller.getAllLahanFailed(t.getMessage());
                t.printStackTrace();
            }
        });
    }

    @Override
    public void saveData(List<LahanRealm> allPen) {
        for(int i=0; i < allPen.size();i++ ){
            final int dataLoop = i;
            LahanRealm lahanTempRealm = allPen.get(i);
            LahanBody lahanBody = new LahanBody(lahanTempRealm);
            Call<ResponseSaveData> call = sisApi.insertLahan(WebServiceModule.ACCESS_TOKEN_TEMP,lahanBody);
            call.enqueue(new Callback<ResponseSaveData>() {
                @Override
                public void onResponse(Call<ResponseSaveData> call, Response<ResponseSaveData> response) {
                    if (response.isSuccessful()) {
                        if (response.body().isSuccess()) {
                            if (dataLoop == allPen.size()-1) {
                                controller.saveDataSuccess("Success",lahanTempRealm);
                            }
                            insertLahan =true;
                        } else {
                            insertLahan =false;
                            controller.saveDataFailed("Gagal Sinkronisasi "+response.body().getMessage());
                        }
                    } else {
                        insertLahan =false;
                        controller.saveDataFailed("Server Error "+ response.message());
                    }
                }

                @Override
                public void onFailure(Call<ResponseSaveData> call, Throwable t) {
                    insertLahan =false;
                    controller.saveDataFailed("Failed"+t.getMessage());
                    t.printStackTrace();
                }
            });
            if (!insertLahan){
                break;
            }
        }
    }
}
