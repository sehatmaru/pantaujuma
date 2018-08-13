package teknodesa.devlops.pantaujuma.dependencies.webservices.services;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
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


    private boolean res = false;

    @Override
    public void getAllRKTP(int idDesa) {
        Log.e("send", "data comehere" + idDesa);
        Call<ResponseRKTP> call = sisApi.getAllRKTP(WebServiceModule.ACCESS_TOKEN_TEMP, idDesa);
        call.enqueue(new Callback<ResponseRKTP>() {
            @Override
            public void onResponse(Call<ResponseRKTP> call, Response<ResponseRKTP> response) {
                if (response.isSuccessful()) {
                    if (response.body().isSuccess()) {
                        Log.e("hasiltarget", response.body().getData().size() + " ini");
                        realm.executeTransactionAsync(bgRealm -> bgRealm.insertOrUpdate(response.body().getData()), () -> {
                            controller.getAllRKTPSuccess(response.body().getData());
                        }, error -> {
                            Log.e("gettargeteror", error.getMessage());
                        });
                    } else
                        controller.getAllRKTPFailed(response.body().getMessage());
                } else {
                    controller.getAllRKTPFailed("Server Error");
                }
            }

            @Override
            public void onFailure(Call<ResponseRKTP> call, Throwable t) {
                Log.e("Failure", "onFailure");
                controller.getAllRKTPFailed(t.getMessage());
                t.printStackTrace();
            }
        });
    }

    @Override
    public void saveData(List<RKTPRealm> allTar) {
        for (int i = 0; i < allTar.size(); i++) {
            RKTPRealm rktpTempRealm = allTar.get(i);
            realm.beginTransaction();
            rktpTempRealm.setIsSync(1);
            realm.commitTransaction();
            RKTPBody targetPetugasBody = new RKTPBody(rktpTempRealm.getHashId(), rktpTempRealm.getPetugas(),
                    rktpTempRealm.getIdDesa(), rktpTempRealm.getPoktan(), rktpTempRealm.getTahun(), rktpTempRealm.getTujuan(), rktpTempRealm.getMasalah(),
                    rktpTempRealm.getSasaran(), rktpTempRealm.getMateri(), rktpTempRealm.getMetode(), rktpTempRealm.getVolume(), rktpTempRealm.getLokasi(), rktpTempRealm.getWaktu(),
                    rktpTempRealm.getSumberBiaya(), rktpTempRealm.getPenanggungJawab(), rktpTempRealm.getPelaksana(), rktpTempRealm.getKeterangan());

            Log.e("target service", targetPetugasBody.toString());
            Call<ResponseSaveData> call = sisApi.insertRktp(WebServiceModule.ACCESS_TOKEN_TEMP, targetPetugasBody);
            call.enqueue(new Callback<ResponseSaveData>() {
                @Override
                public void onResponse(Call<ResponseSaveData> call, Response<ResponseSaveData> response) {
                    if (response.isSuccessful()) {
                        if (response.body().isSuccess()) {

                            controller.saveDataSuccess("Success", rktpTempRealm);
                        } else {
                            controller.saveDataFailed("Failed" + response.body().getMessage());
                        }

                    } else {
                        Log.e("target service", "Error3" + response.toString());
                        controller.saveDataFailed("Failed");
                    }
                }

                @Override
                public void onFailure(Call<ResponseSaveData> call, Throwable t) {
                    Log.e("target service", "error server" + t.getMessage());
                    controller.saveDataFailed("Failed" + t.getMessage());
                    t.printStackTrace();
                }
            });
        }
    }
}
