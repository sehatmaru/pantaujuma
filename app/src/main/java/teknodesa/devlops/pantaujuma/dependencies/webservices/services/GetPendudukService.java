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
import teknodesa.devlops.pantaujuma.dependencies.models.realms.penduduk.PendudukTempRealm;
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
                        realm.executeTransactionAsync(new Realm.Transaction() {
                            @Override
                            public void execute(Realm bgRealm) {
                                bgRealm.insertOrUpdate(response.body().getPenduduk());
                            }
                        }, new Realm.Transaction.OnSuccess() {
                            @Override
                            public void onSuccess() {
                                // Transaction was a success.
                                Log.e("getpenduduksukses","done");
                                controller.getAllPendudukSuccess(response.body().getPenduduk());
                            }
                        }, new Realm.Transaction.OnError() {
                            @Override
                            public void onError(Throwable error) {
                                // Transaction failed and was automatically canceled.
//                                mController.responseCRUD(false, "create");
                                Log.e("getpendudukeror",error.getMessage());
                            }
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
    public void saveData(List<PendudukTempRealm> allPen) {
        Log.e("penduduk service",allPen.size()+"size ");
        for(int i=0; i < allPen.size();i++ ){
            PendudukTempRealm pendudukTempRealm = allPen.get(i);

            PendudukBody pendudukBody = new PendudukBody(
                    pendudukTempRealm.getHashId(),pendudukTempRealm.getNIK(),pendudukTempRealm.getFoto(),
                    pendudukTempRealm.getNamaDepan(),pendudukTempRealm.getNamaBelakang(),pendudukTempRealm.getJenisKelamin(),
                    pendudukTempRealm.getTempatLahir(),pendudukTempRealm.getTanggalLahir(),pendudukTempRealm.getAgama(),
                    pendudukTempRealm.getGolonganDarah(),pendudukTempRealm.getPekerjaan(),pendudukTempRealm.getPendidikan(),
                    pendudukTempRealm.getAlamat(),pendudukTempRealm.getRt(),pendudukTempRealm.getRw(),pendudukTempRealm.getDusun(),
                    pendudukTempRealm.getDesa(), pendudukTempRealm.getKecamatan(),pendudukTempRealm.getDatiII(),
                    pendudukTempRealm.getProvinsi(),pendudukTempRealm.getNoHP(),pendudukTempRealm.getNoTelp(),
                    pendudukTempRealm.getStatus(),pendudukTempRealm.getKodePos(),pendudukTempRealm.getEmail(),
                    pendudukTempRealm.isDeleted(),pendudukTempRealm.getIdDesa());

            Log.e("penduduk service",pendudukBody.toString());
            Call<ResponseSaveData> call = sisApi.insertPenduduk(WebServiceModule.ACCESS_TOKEN_TEMP,pendudukBody);
            call.enqueue(new Callback<ResponseSaveData>() {
                @Override
                public void onResponse(Call<ResponseSaveData> call, Response<ResponseSaveData> response) {
                    if(response.isSuccessful()){
                        if(response.body().isSuccess()){
                            Log.e("penduduk service",allPen.size()+"true");
                            controller.saveDataSuccess("Success",pendudukTempRealm);
                        }else {
                            controller.saveDataFailed("Failed");
                        }

                    }else{
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
            //deleteData(allPen.get(i));
        }
        //controller.saveDataSuccess("Sinkronisasi data selesai");
    }

}