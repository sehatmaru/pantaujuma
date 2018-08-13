package teknodesa.devlops.pantaujuma.dependencies.webservices.services;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teknodesa.devlops.pantaujuma.components.rdk.GetRDKContract;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.RDKBody;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.rdk.RDKRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseRDK;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseSaveData;
import teknodesa.devlops.pantaujuma.dependencies.modules.WebServiceModule;
import teknodesa.devlops.pantaujuma.dependencies.webservices.PantauJumaAPI;

/**
 * Created by Marthin on 7/10/2018.
 */

public class GetRDKService implements GetRDKContract.Repository {
    @Inject
    PantauJumaAPI sisApi;

    @Inject
    Realm realm;

    public GetRDKService(AppComponent appComponent) {
        appComponent.inject(this);
    }

    public GetRDKContract.Controller controller;

    public void instanceClass(GetRDKContract.Controller controller){
        this.controller = controller;
    }


    private boolean res = false;
    @Override
    public void getAllRDK(int idDesa) {
        Log.e("send","data comehere"+idDesa);
        Call<ResponseRDK> call = sisApi.getAllRDK(WebServiceModule.ACCESS_TOKEN_TEMP,idDesa);
        call.enqueue(new Callback<ResponseRDK>() {
            @Override
            public void onResponse(Call<ResponseRDK> call, Response<ResponseRDK> response) {
                if(response.isSuccessful()){
                    if(response.body().isSuccess()){
                        Log.e("hasilrdk",response.body().getData().size()+" ini");
                        realm.executeTransactionAsync(bgRealm -> bgRealm.insertOrUpdate(response.body().getData()), () -> {
                            controller.getAllRDKSuccess(response.body().getData());
                        }, error -> {
                            Log.e("getrdkeror",error.getMessage());
                        });
                    }else
                        controller.getAllRDKFailed(response.body().getMessage());
                }else{
                    controller.getAllRDKFailed("Server Error");
                }
            }

            @Override
            public void onFailure(Call<ResponseRDK> call, Throwable t) {
                Log.e("Failure", "onFailure");
                controller.getAllRDKFailed(t.getMessage());
                t.printStackTrace();
            }
        });
    }

    @Override
    public void saveData(List<RDKRealm> allTar) {
        for(int i=0; i < allTar.size();i++ ){
            RDKRealm rdkTempRealm = allTar.get(i);
            realm.beginTransaction();
            rdkTempRealm.setIsSync(1);
            realm.commitTransaction();
            RDKBody rdkBody = new RDKBody(rdkTempRealm.getHashId(),rdkTempRealm.getHashIdIdentitas(),
                    rdkTempRealm.getPetugas(),rdkTempRealm.getPoktan(),rdkTempRealm.getIrigasi(),
                    rdkTempRealm.getIntensifikasi(), rdkTempRealm.getRencana(), rdkTempRealm.getKegiatan(),
                    rdkTempRealm.getTanggal(), rdkTempRealm.getLuasSawah(), rdkTempRealm.getKeterangan(),
                    rdkTempRealm.getHashIdIrigasi(), rdkTempRealm.getNama(), rdkTempRealm.getDeskripsiIrigasi(),
                    rdkTempRealm.getHashIdJadwal(), rdkTempRealm.getKegiatanJK(), rdkTempRealm.getTanggalJK(),
                    rdkTempRealm.getDeskripsiJK(), rdkTempRealm.getHashIdRencana(), rdkTempRealm.getPaketTeknologi(),
                    rdkTempRealm.getPolaTanam(), rdkTempRealm.getJadwalTanam(), rdkTempRealm.getKomoditasRU(),
                    rdkTempRealm.getVarietas(), rdkTempRealm.getSumberBenih(), rdkTempRealm.getTabunganAnggota(),
                    rdkTempRealm.getIuranAnggota(), rdkTempRealm.getPemupukanModal(), rdkTempRealm.getHashIdSasaran(),
                    rdkTempRealm.getKomoditasSI(), rdkTempRealm.getTarget(), rdkTempRealm.getTargetHasilPerHa(),
                    rdkTempRealm.getIdDesa());

            Log.e("rdk service",rdkBody.toString());
            Call<ResponseSaveData> call = sisApi.insertRdk(WebServiceModule.ACCESS_TOKEN_TEMP,rdkBody);
            call.enqueue(new Callback<ResponseSaveData>() {
                @Override
                public void onResponse(Call<ResponseSaveData> call, Response<ResponseSaveData> response) {
                    if(response.isSuccessful()){
                        if(response.body().isSuccess()){

                            controller.saveDataSuccess("Success",rdkTempRealm);
                        }else {
                            controller.saveDataFailed("Failed"+response.body().getMessage());
                        }

                    }else{
                        Log.e("rdk service","Error3"+response.toString());
                        controller.saveDataFailed("Failed");
                    }
                }

                @Override
                public void onFailure(Call<ResponseSaveData> call, Throwable t) {
                    Log.e("rdk service","error server"+t.getMessage());
                    controller.saveDataFailed("Failed"+t.getMessage());
                    t.printStackTrace();
                }
            });
        }
    }

}