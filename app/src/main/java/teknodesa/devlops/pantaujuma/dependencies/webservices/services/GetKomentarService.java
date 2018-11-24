package teknodesa.devlops.pantaujuma.dependencies.webservices.services;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teknodesa.devlops.pantaujuma.components.post.GetKomentarContract;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.KomentarBody;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.KomentarRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseKomentar;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseSaveData;
import teknodesa.devlops.pantaujuma.dependencies.modules.WebServiceModule;
import teknodesa.devlops.pantaujuma.dependencies.webservices.PantauJumaAPI;

public class GetKomentarService implements GetKomentarContract.Repository {
    @Inject
    PantauJumaAPI sisApi;

    @Inject
    Realm realm;

    public GetKomentarService(AppComponent appComponent) {
        appComponent.inject(this);
    }

    public GetKomentarContract.Controller controller;

    public void instanceClass(GetKomentarContract.Controller controller) {
        this.controller = controller;
    }

    private boolean insertKomentar = false;

    @Override
    public void getAllKomentar(String idPost) {
        Call<ResponseKomentar> call = sisApi.getAllKomentar(WebServiceModule.ACCESS_TOKEN_TEMP,idPost);
        call.enqueue(new Callback<ResponseKomentar>() {
            @Override
            public void onResponse(Call<ResponseKomentar> call, Response<ResponseKomentar> response) {
                if(response.isSuccessful()){
                    if(response.body().isSuccess()){
                        realm.beginTransaction();
                        RealmResults<KomentarRealm> allKomentars = realm.where(KomentarRealm.class).equalTo("hashPost",idPost).findAll();
                        allKomentars.deleteAllFromRealm();
                        realm.commitTransaction();

                        realm.beginTransaction();
                        realm.executeTransactionAsync(realmkelompok -> realmkelompok.insertOrUpdate(response.body().getData()));
                        realm.commitTransaction();
                        controller.getAllKomentarSuccess(response.body().getData());
                    }else{
                        controller.getAllKomentarFailed("Error "+response.message());
                    }
                }else{
                    controller.getAllKomentarFailed("Server Error "+response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseKomentar> call, Throwable t) {
                controller.getAllKomentarFailed(t.getMessage());
                t.printStackTrace();
            }
        });
    }

    @Override
    public void saveData(KomentarRealm kom) {
        KomentarBody komentarBody = new KomentarBody(kom);
        Call<ResponseSaveData> call = sisApi.insertKomentar(WebServiceModule.ACCESS_TOKEN_TEMP,komentarBody);
        call.enqueue(new Callback<ResponseSaveData>() {
            @Override
            public void onResponse(Call<ResponseSaveData> call, Response<ResponseSaveData> response) {
                if(response.isSuccessful()){
                    if(response.body().isSuccess()){
                        controller.saveDataSuccess("Success");
                        insertKomentar =true;
                    }else {
                        insertKomentar =false;
                        controller.saveDataFailed("Gagal Sinkronisasi "+response.body().getMessage());
                    }

                }else{
                    insertKomentar =false;
                    controller.saveDataFailed("Server Error "+ response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseSaveData> call, Throwable t) {
                insertKomentar =false;
                controller.saveDataFailed("Failed" + t.getMessage());
                t.printStackTrace();
            }
        });
    }

}
