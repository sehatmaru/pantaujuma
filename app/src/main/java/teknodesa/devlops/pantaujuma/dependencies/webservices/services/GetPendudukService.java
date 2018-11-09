package teknodesa.devlops.pantaujuma.dependencies.webservices.services;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teknodesa.devlops.pantaujuma.components.penduduk.GetPendudukContract;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.PendudukBody;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.penduduk.PendudukRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponsePenduduk;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseSaveData;
import teknodesa.devlops.pantaujuma.dependencies.modules.WebServiceModule;
import teknodesa.devlops.pantaujuma.dependencies.webservices.PantauJumaAPI;

/**
 * Created by Marthin on 7/10/2018.
 */

public class GetPendudukService implements GetPendudukContract.Repository {
    @Inject
    PantauJumaAPI sisApi;

    @Inject
    Realm realm;

    public GetPendudukService(AppComponent appComponent) {
        appComponent.inject(this);
    }

    public GetPendudukContract.Controller controller;

    public void instanceClass(GetPendudukContract.Controller controller){
        this.controller = controller;
    }

    public boolean insertPenduduk =true;

    @Override
    public void getAllPenduduk(int idDesa) {
        Call<ResponsePenduduk> call = sisApi.getAllPenduduk(WebServiceModule.ACCESS_TOKEN_TEMP,idDesa);
        call.enqueue(new Callback<ResponsePenduduk>() {
            @Override
            public void onResponse(Call<ResponsePenduduk> call, Response<ResponsePenduduk> response) {
                if(response.isSuccessful()){
                    if(response.body().isSuccess()){
                        realm.beginTransaction();
                        RealmResults<PendudukRealm> allPenduduks = realm.where(PendudukRealm.class).equalTo("isSync",1).findAll();
                        allPenduduks.deleteAllFromRealm();
                        realm.commitTransaction();

                        realm.beginTransaction();
                        realm.executeTransactionAsync(realmkelompok -> realmkelompok.insertOrUpdate(response.body().getData()));
                        realm.commitTransaction();
                        controller.getAllPendudukSuccess(response.body().getData());
                    }else{
                        controller.getAllPendudukFailed("Error "+response.message());
                    }
                }else{
                    controller.getAllPendudukFailed("Server Error "+response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponsePenduduk> call, Throwable t) {
                controller.getAllPendudukFailed(t.getMessage());
                t.printStackTrace();
            }
        });
    }

    @Override
    public void saveData(List<PendudukRealm> allPen) {
        for(int i=0; i < allPen.size();i++ ){
            PendudukRealm pendudukTempRealm = allPen.get(i);
            PendudukBody pendudukBody = new PendudukBody(pendudukTempRealm);
            final int dataLoop = i;
            Call<ResponseSaveData> call = sisApi.insertPenduduk(WebServiceModule.ACCESS_TOKEN_TEMP,pendudukBody);
            call.enqueue(new Callback<ResponseSaveData>() {
                @Override
                public void onResponse(Call<ResponseSaveData> call, Response<ResponseSaveData> response) {
                    if(response.isSuccessful()){
                        if(response.body().isSuccess()){
                            if (dataLoop == allPen.size()-1) {
                                controller.saveDataSuccess("Success");
                            }
                            insertPenduduk =true;
                        }else {
                            insertPenduduk =false;
                            controller.saveDataFailed("Gagal Sinkronisasi "+response.body().getMessage());
                        }

                    }else{
                        insertPenduduk =false;
                        controller.saveDataFailed("Server Error "+ response.message());
                    }
                }

                @Override
                public void onFailure(Call<ResponseSaveData> call, Throwable t) {
                    insertPenduduk =false;
                    controller.saveDataFailed("Failed" + t.getMessage());
                    t.printStackTrace();
                }
            });
            if (!insertPenduduk){
                break;
            }
        }
    }

}