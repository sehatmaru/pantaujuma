package teknodesa.devlops.pantaujuma.dependencies.webservices.services;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
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


    private boolean res = false;

    @Override
    public void getAllKomentar(String idPost) {
        Log.e("send", "data comehere" + idPost);
        Call<ResponseKomentar> call = sisApi.getAllKomentar(WebServiceModule.ACCESS_TOKEN_TEMP, idPost);
        call.enqueue(new Callback<ResponseKomentar>() {
            @Override
            public void onResponse(Call<ResponseKomentar> call, Response<ResponseKomentar> response) {
                if (response.isSuccessful()) {
                    if (response.body().isSuccess()) {
                        Log.e("hasilkomentar", response.body().getData().size() + " ini");
                        realm.executeTransactionAsync(bgRealm -> bgRealm.insertOrUpdate(response.body().getData()), () -> {
                            controller.getAllKomentarSuccess(response.body().getData());
                        }, error -> {
                            Log.e("getkomentareror", error.getMessage());
                        });
                    } else
                        controller.getAllKomentarFailed(response.body().getMessage());
                } else {
                    controller.getAllKomentarFailed("Server Error");
                }
            }

            @Override
            public void onFailure(Call<ResponseKomentar> call, Throwable t) {
                Log.e("Failure", "onFailure");
                controller.getAllKomentarFailed(t.getMessage());
                t.printStackTrace();
            }
        });
    }

    @Override
    public void saveData(List<KomentarRealm> allTar) {
        for (int i = 0; i < allTar.size(); i++) {
            KomentarRealm komentarTempRealm = allTar.get(i);
            realm.beginTransaction();
            komentarTempRealm.setIsSync(1);
            realm.commitTransaction();
            KomentarBody komentarBody = new KomentarBody(komentarTempRealm.getHashId(), komentarTempRealm.getHashPost(), komentarTempRealm.getIdUser(), komentarTempRealm.getNamaUser(), komentarTempRealm.getWaktu(),
                    komentarTempRealm.getTanggal(), komentarTempRealm.getDeskripsi(), komentarTempRealm.getIdDesa());

            Log.e("komentar service", komentarTempRealm.toString());
            Call<ResponseSaveData> call = sisApi.insertKomentar(WebServiceModule.ACCESS_TOKEN_TEMP, komentarBody);
            call.enqueue(new Callback<ResponseSaveData>() {
                @Override
                public void onResponse(Call<ResponseSaveData> call, Response<ResponseSaveData> response) {
                    if (response.isSuccessful()) {
                        if (response.body().isSuccess()) {

                            controller.saveDataSuccess("Success", komentarTempRealm);
                        } else {
                            controller.saveDataFailed("Failed" + response.body().getMessage());
                        }

                    } else {
                        Log.e("komentar service", "Error3" + response.toString());
                        controller.saveDataFailed("Failed");
                    }
                }

                @Override
                public void onFailure(Call<ResponseSaveData> call, Throwable t) {
                    Log.e("komentar service", "error server" + t.getMessage());
                    controller.saveDataFailed("Failed" + t.getMessage());
                    t.printStackTrace();
                }
            });
        }
    }
}
