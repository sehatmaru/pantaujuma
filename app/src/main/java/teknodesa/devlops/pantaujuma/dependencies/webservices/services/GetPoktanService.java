package teknodesa.devlops.pantaujuma.dependencies.webservices.services;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teknodesa.devlops.pantaujuma.components.poktan.CRUAnggotaPoktanFragment;
import teknodesa.devlops.pantaujuma.components.poktan.CRUPengurusPoktanFragment;
import teknodesa.devlops.pantaujuma.components.poktan.GetAnggotaPoktanController;
import teknodesa.devlops.pantaujuma.components.poktan.GetPengurusPoktanController;
import teknodesa.devlops.pantaujuma.components.poktan.GetPoktanContract;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.PoktanBody;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.PoktanRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseAnggotaPoktan;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponsePengurusPoktan;
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

    @Inject
    GetAnggotaPoktanController aController;

    @Inject
    GetPengurusPoktanController pController;

    public void instanceClass(GetPoktanContract.Controller controller){
        this.controller = controller;
    }

    private boolean insertPoktan = true;

    @Override
    public void getAllPoktan(int idDesa) {
        Call<ResponsePoktan> call = sisApi.getAllPoktan(WebServiceModule.ACCESS_TOKEN_TEMP,idDesa);
        call.enqueue(new Callback<ResponsePoktan>() {
            @Override
            public void onResponse(Call<ResponsePoktan> call, Response<ResponsePoktan> response) {
                if(response.isSuccessful()){
                    if(response.body().isSuccess()){
                        realm.beginTransaction();
                        RealmResults<PoktanRealm> allPoktans = realm.where(PoktanRealm.class).equalTo("isSync",1).findAll();
                        allPoktans.deleteAllFromRealm();
                        realm.commitTransaction();

                        realm.beginTransaction();
                        realm.executeTransactionAsync(realmkelompok -> realmkelompok.insertOrUpdate(response.body().getData()));
                        realm.commitTransaction();
                        controller.getAllPoktanSuccess(response.body().getData());
                    }else{
                        controller.getAllPoktanFailed("Error "+response.message());
                    }
                }else{
                    controller.getAllPoktanFailed("Server Error "+response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponsePoktan> call, Throwable t) {
                controller.getAllPoktanFailed(t.getMessage());
                t.printStackTrace();
            }
        });
    }

    @Override
    public void saveData(List<PoktanRealm> allPok) {
        for(int i=0; i < allPok.size();i++ ){
            PoktanRealm poktanTempRealm = allPok.get(i);
            PoktanBody poktanBody = new PoktanBody(poktanTempRealm);
            final int dataLoop = i;
            Call<ResponseSaveData> call = sisApi.insertPoktan(WebServiceModule.ACCESS_TOKEN_TEMP,poktanBody);
            call.enqueue(new Callback<ResponseSaveData>() {
                @Override
                public void onResponse(Call<ResponseSaveData> call, Response<ResponseSaveData> response) {
                    if(response.isSuccessful()){
                        if(response.body().isSuccess()){
                            if (dataLoop == allPok.size()-1) {
                                if (CRUAnggotaPoktanFragment.listanggotaNotSync!=null){
                                    aController.saveData(CRUAnggotaPoktanFragment.listanggotaNotSync);
                                }

                                if (CRUPengurusPoktanFragment.listpengurusNotSync!=null){
                                    pController.saveData(CRUPengurusPoktanFragment.listpengurusNotSync);
                                }

                                controller.saveDataSuccess("Success");
                            }
                            insertPoktan =true;
                        }else {
                            insertPoktan =false;
                            controller.saveDataFailed("Gagal Sinkronisasi "+response.body().getMessage());
                        }

                    }else{
                        insertPoktan =false;
                        controller.saveDataFailed("Server Error "+ response.message());
                    }
                }

                @Override
                public void onFailure(Call<ResponseSaveData> call, Throwable t) {
                    insertPoktan =false;
                    controller.saveDataFailed("Failed" + t.getMessage());
                    t.printStackTrace();
                }
            });
            if (!insertPoktan){
                break;
            }
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

    public void getAllPengurusPoktan(int idDesa){

        Call<ResponsePengurusPoktan> call = sisApi.getAllPengurusPoktan(WebServiceModule.ACCESS_TOKEN_TEMP, idDesa);
        call.enqueue(new Callback<ResponsePengurusPoktan>() {
            @Override
            public void onResponse(Call<ResponsePengurusPoktan> call, Response<ResponsePengurusPoktan> response) {
                if(response.isSuccessful()){
                    if(response.body().isSuccess()){
                        realm.beginTransaction();
                        realm.executeTransactionAsync(realmpupuk -> {
                            realmpupuk.insertOrUpdate(response.body().getData());
                        });
                        realm.commitTransaction();
                    }
                }else{

                }
            }

            @Override
            public void onFailure(Call<ResponsePengurusPoktan> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}