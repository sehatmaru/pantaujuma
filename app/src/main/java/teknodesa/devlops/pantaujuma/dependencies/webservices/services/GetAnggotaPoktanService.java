package teknodesa.devlops.pantaujuma.dependencies.webservices.services;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teknodesa.devlops.pantaujuma.components.poktan.GetAnggotaPoktanContract;
import teknodesa.devlops.pantaujuma.components.poktan.GetPengurusPoktanController;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.AnggotaPoktanBody;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.AnggotaPoktanRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.PoktanRealm;
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

    @Inject
    GetPengurusPoktanController pController;

    public GetAnggotaPoktanService(AppComponent appComponent) {
        appComponent.inject(this);
    }

    public GetAnggotaPoktanContract.Controller controller;

    public void instanceClass(GetAnggotaPoktanContract.Controller controller){
        this.controller = controller;
    }

    private String idPoktan;
    private PoktanRealm dataPoktan;
    private boolean insertAnggota = true;

    @Override
    public void getAllAnggotaPoktan(int idDesa){
        Call<ResponseAnggotaPoktan> call = sisApi.getAllAnggotaPoktan(WebServiceModule.ACCESS_TOKEN_TEMP,idDesa);
        call.enqueue(new Callback<ResponseAnggotaPoktan>() {
            @Override
            public void onResponse(Call<ResponseAnggotaPoktan> call, Response<ResponseAnggotaPoktan> response) {
                if(response.isSuccessful()){
                    if(response.body().isSuccess()){
                        realm.beginTransaction();
                        RealmResults<AnggotaPoktanRealm> allAnggotas = realm.where(AnggotaPoktanRealm.class).equalTo("isSync",1).findAll();
                        allAnggotas.deleteAllFromRealm();
                        realm.commitTransaction();

                        realm.beginTransaction();
                        realm.executeTransactionAsync(realmkelompok -> realmkelompok.insertOrUpdate(response.body().getData()));
                        realm.commitTransaction();
                        controller.getAllAnggotaPoktanSuccess(response.body().getData());
                    }else{
                        controller.getAllAnggotaPoktanFailed("Error "+response.message());
                    }
                }else{
                    controller.getAllAnggotaPoktanFailed("Server Error "+response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseAnggotaPoktan> call, Throwable t) {
                controller.getAllAnggotaPoktanFailed(t.getMessage());
                t.printStackTrace();
            }
        });
    }

    @Override
    public void saveData(List<AnggotaPoktanRealm> allAng) {
        for(int i=0; i < allAng.size();i++ ){
            AnggotaPoktanRealm anggotaTempRealm = allAng.get(i);
            realm.beginTransaction();
            idPoktan = anggotaTempRealm.getPoktanAnggota();
            dataPoktan = realm.where(PoktanRealm.class).equalTo("hashId", idPoktan).findFirst();
            dataPoktan.setIsSync(1);
            realm.commitTransaction();
            AnggotaPoktanBody anggotaBody = new AnggotaPoktanBody(anggotaTempRealm);
            final int dataLoop = i;
            Call<ResponseSaveData> call = sisApi.insertAnggotaPoktan(WebServiceModule.ACCESS_TOKEN_TEMP,anggotaBody);
            call.enqueue(new Callback<ResponseSaveData>() {
                @Override
                public void onResponse(Call<ResponseSaveData> call, Response<ResponseSaveData> response) {
                    if(response.isSuccessful()){
                        if(response.body().isSuccess()){
                            if (dataLoop == allAng.size()-1) {
                                controller.saveDataSuccess("Success");
                            }
                            insertAnggota =true;
                        }else {
                            insertAnggota =false;
                        }

                    }else{
                        insertAnggota =false;
                        controller.saveDataFailed("Server Error "+ response.message());
                    }
                }

                @Override
                public void onFailure(Call<ResponseSaveData> call, Throwable t) {
                    insertAnggota =false;
                    controller.saveDataFailed("Failed" + t.getMessage());
                    t.printStackTrace();
                }
            });
            if (!insertAnggota){
                break;
            }
        }
    }

}