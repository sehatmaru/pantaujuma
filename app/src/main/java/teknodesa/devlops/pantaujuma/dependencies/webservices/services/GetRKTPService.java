package teknodesa.devlops.pantaujuma.dependencies.webservices.services;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teknodesa.devlops.pantaujuma.components.rktp.GetRKTPContract;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.RKTPBody;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.rktp.RKTPRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseRKTP;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseSaveData;
import teknodesa.devlops.pantaujuma.dependencies.modules.WebServiceModule;
import teknodesa.devlops.pantaujuma.dependencies.webservices.PantauJumaAPI;

public class GetRKTPService implements GetRKTPContract.Repository {
    @Inject
    PantauJumaAPI sisApi;

    @Inject
    Realm realm;

    public GetRKTPService(AppComponent appComponent) {
        appComponent.inject(this);
    }

    public GetRKTPContract.Controller controller;

    public void instanceClass(GetRKTPContract.Controller controller) {
        this.controller = controller;
    }

    private boolean insertRKTP = true;

    @Override
    public void getAllRKTP(int idDesa) {
        Call<ResponseRKTP> call = sisApi.getAllRKTP(WebServiceModule.ACCESS_TOKEN_TEMP,idDesa);
        call.enqueue(new Callback<ResponseRKTP>() {
            @Override
            public void onResponse(Call<ResponseRKTP> call, Response<ResponseRKTP> response) {
                if(response.isSuccessful()){
                    if(response.body().isSuccess()){
                        realm.beginTransaction();
                        RealmResults<RKTPRealm> allRKTPs = realm.where(RKTPRealm.class).equalTo("isSync",1).findAll();
                        allRKTPs.deleteAllFromRealm();
                        realm.commitTransaction();

                        realm.beginTransaction();
                        realm.executeTransactionAsync(realmkelompok -> realmkelompok.insertOrUpdate(response.body().getData()));
                        realm.commitTransaction();
                        controller.getAllRKTPSuccess(response.body().getData());
                    }else{
                        controller.getAllRKTPFailed("Error "+response.message());
                    }
                }else{
                    controller.getAllRKTPFailed("Server Error "+response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseRKTP> call, Throwable t) {
                controller.getAllRKTPFailed(t.getMessage());
                t.printStackTrace();
            }
        });
    }

    @Override
    public void saveData(List<RKTPRealm> allRKTP) {
        for(int i=0; i < allRKTP.size();i++ ){
            RKTPRealm rktpTempRealm = allRKTP.get(i);
            RKTPBody rktpBody = new RKTPBody(rktpTempRealm);
            final int dataLoop = i;
            Call<ResponseSaveData> call = sisApi.insertRktp(WebServiceModule.ACCESS_TOKEN_TEMP,rktpBody);
            call.enqueue(new Callback<ResponseSaveData>() {
                @Override
                public void onResponse(Call<ResponseSaveData> call, Response<ResponseSaveData> response) {
                    if(response.isSuccessful()){
                        if(response.body().isSuccess()){
                            if (dataLoop == allRKTP.size()-1) {
                                controller.saveDataSuccess("Success");
                            }
                            insertRKTP =true;
                        }else {
                            insertRKTP =false;
                            controller.saveDataFailed("Gagal Sinkronisasi "+response.body().getMessage());
                        }

                    }else{
                        insertRKTP =false;
                        controller.saveDataFailed("Server Error "+ response.message());
                    }
                }

                @Override
                public void onFailure(Call<ResponseSaveData> call, Throwable t) {
                    insertRKTP =false;
                    controller.saveDataFailed("Failed" + t.getMessage());
                    t.printStackTrace();
                }
            });
            if (!insertRKTP){
                break;
            }
        }
    }
}
