package teknodesa.devlops.pantaujuma.dependencies.webservices.services;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
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


    private boolean res = false;
    @Override
    public void getAllPenduduk(int idDesa) {
        Log.e("send","data comehere"+idDesa);
        Call<ResponsePenduduk> call = sisApi.getAllPenduduk(WebServiceModule.ACCESS_TOKEN_TEMP,idDesa);
        call.enqueue(new Callback<ResponsePenduduk>() {
            @Override
            public void onResponse(Call<ResponsePenduduk> call, Response<ResponsePenduduk> response) {
                if(response.isSuccessful()){
                    if(response.body().isSuccess()){
                        Log.e("hasilpenduduk",response.body().getPenduduk().size()+" ini");
                        realm.executeTransactionAsync(bgRealm -> bgRealm.insertOrUpdate(response.body().getPenduduk()), () -> {
                            controller.getAllPendudukSuccess(response.body().getPenduduk());
                        }, error -> {
                            Log.e("getpendudukeror",error.getMessage());
                        });
                    }else
                        controller.getAllPendudukFailed(response.body().getMessage());
                }else{
                    controller.getAllPendudukFailed("Server Error");
                }
            }

            @Override
            public void onFailure(Call<ResponsePenduduk> call, Throwable t) {
                Log.e("Failure", "onFailure");
                controller.getAllPendudukFailed(t.getMessage());
                t.printStackTrace();
            }
        });
    }

    @Override
    public void saveData(List<PendudukRealm> allPen) {
        for(int i=0; i < allPen.size();i++ ){
            PendudukRealm pendudukTempRealm = allPen.get(i);
            realm.beginTransaction();
            pendudukTempRealm.setIsSync(1);
            realm.commitTransaction();
            PendudukBody pendudukBody = new PendudukBody(pendudukTempRealm.getHashId(),pendudukTempRealm.getNIK(),"",
                    pendudukTempRealm.getNamaDepan(),pendudukTempRealm.getNamaBelakang(),pendudukTempRealm.getJenisKelamin(),
                    pendudukTempRealm.getTempatLahir(),pendudukTempRealm.getTanggalLahir(),pendudukTempRealm.getAgama(),
                    pendudukTempRealm.getGolonganDarah(),pendudukTempRealm.getPekerjaan(),pendudukTempRealm.getPendidikan(),
                    pendudukTempRealm.getAlamat(),pendudukTempRealm.getRt(),pendudukTempRealm.getRw(),pendudukTempRealm.getDusun(),
                    pendudukTempRealm.getDesa(),pendudukTempRealm.getKecamatan(),pendudukTempRealm.getDatiII(),pendudukTempRealm.getProvinsi(),
                    pendudukTempRealm.getNoHP(),pendudukTempRealm.getNoTelp(),pendudukTempRealm.getStatus(),pendudukTempRealm.getKodePos(),
                    pendudukTempRealm.getEmail(),pendudukTempRealm.getIdDesa());

            Log.e("penduduk service",pendudukBody.toString());
            Call<ResponseSaveData> call = sisApi.insertPenduduk(WebServiceModule.ACCESS_TOKEN_TEMP,pendudukBody);
            call.enqueue(new Callback<ResponseSaveData>() {
                @Override
                public void onResponse(Call<ResponseSaveData> call, Response<ResponseSaveData> response) {
                    if(response.isSuccessful()){
                        if(response.body().isSuccess()){

                            controller.saveDataSuccess("Success",pendudukTempRealm);
                        }else {
                            controller.saveDataFailed("Failed"+response.body().getMessage());
                        }

                    }else{
                        Log.e("penduduk service","Error3"+response.toString());
                        controller.saveDataFailed("Failed");
                    }
                }

                @Override
                public void onFailure(Call<ResponseSaveData> call, Throwable t) {
                    Log.e("penduduk service","error server"+t.getMessage());
                    controller.saveDataFailed("Failed"+t.getMessage());
                    t.printStackTrace();
                }
            });
        }
    }

}