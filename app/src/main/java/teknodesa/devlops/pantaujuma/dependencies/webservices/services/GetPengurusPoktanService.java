package teknodesa.devlops.pantaujuma.dependencies.webservices.services;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teknodesa.devlops.pantaujuma.components.poktan.GetPengurusPoktanContract;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.PengurusPoktanBody;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.PengurusPoktanRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.PoktanRealm;
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

    String idPoktan;
    PoktanRealm dataPoktan;
    private boolean insertPengurus = true;

    @Override
    public void getAllPengurusPoktan(int idDesa) {
        Call<ResponsePengurusPoktan> call = sisApi.getAllPengurusPoktan(WebServiceModule.ACCESS_TOKEN_TEMP,idDesa);
        call.enqueue(new Callback<ResponsePengurusPoktan>() {
            @Override
            public void onResponse(Call<ResponsePengurusPoktan> call, Response<ResponsePengurusPoktan> response) {
                if(response.isSuccessful()){
                    if(response.body().isSuccess()){
                        realm.beginTransaction();
                        RealmResults<PengurusPoktanRealm> allPenguruss = realm.where(PengurusPoktanRealm.class).equalTo("isSync",1).findAll();
                        allPenguruss.deleteAllFromRealm();
                        realm.commitTransaction();

                        realm.beginTransaction();
                        realm.executeTransactionAsync(realmkelompok -> realmkelompok.insertOrUpdate(response.body().getData()));
                        realm.commitTransaction();
                        controller.getAllPengurusPoktanSuccess(response.body().getData());
                    }else{
                        controller.getAllPengurusPoktanFailed("Error "+response.message());
                    }
                }else{
                    controller.getAllPengurusPoktanFailed("Server Error "+response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponsePengurusPoktan> call, Throwable t) {
                controller.getAllPengurusPoktanFailed(t.getMessage());
                t.printStackTrace();
            }
        });
    }

    @Override
    public void saveData(List<PengurusPoktanRealm> allPeng) {
        for(int i=0; i < allPeng.size();i++ ){
            PengurusPoktanRealm pengurusTempRealm = allPeng.get(i);

            realm.beginTransaction();
            idPoktan = pengurusTempRealm.getPoktanPengurus();
            dataPoktan = realm.where(PoktanRealm.class).equalTo("hashId", idPoktan).findFirst();
            dataPoktan.setIsSync(1);
            realm.commitTransaction();

            PengurusPoktanBody pengurusBody = new PengurusPoktanBody(pengurusTempRealm);
            final int dataLoop = i;
            Call<ResponseSaveData> call = sisApi.insertPengurusPoktan(WebServiceModule.ACCESS_TOKEN_TEMP,pengurusBody);
            call.enqueue(new Callback<ResponseSaveData>() {
                @Override
                public void onResponse(Call<ResponseSaveData> call, Response<ResponseSaveData> response) {
                    if(response.isSuccessful()){
                        if(response.body().isSuccess()){
                            if (dataLoop == allPeng.size()-1) {
                                controller.saveDataSuccess("Success");
                            }
                            insertPengurus =true;
                        }else {
                            insertPengurus =false;
                            controller.saveDataFailed("Gagal Sinkronisasi pengurus "+response.body().getMessage());
                        }

                    }else{
                        insertPengurus =false;
                        controller.saveDataFailed("Server Error "+ response.message());
                    }
                }

                @Override
                public void onFailure(Call<ResponseSaveData> call, Throwable t) {
                    insertPengurus =false;
                    controller.saveDataFailed("Failed" + t.getMessage());
                    t.printStackTrace();
                }
            });
            if (!insertPengurus){
                break;
            }
        }
    }

}