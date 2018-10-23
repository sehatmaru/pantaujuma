package teknodesa.devlops.pantaujuma.dependencies.webservices.services;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teknodesa.devlops.pantaujuma.components.harga.GetHargaContract;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.HargaBody;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.harga.HargaRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseHarga;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseSaveData;
import teknodesa.devlops.pantaujuma.dependencies.modules.WebServiceModule;
import teknodesa.devlops.pantaujuma.dependencies.webservices.PantauJumaAPI;

/**
 * Created by Marthin on 7/10/2018.
 */

public class GetHargaService implements GetHargaContract.Repository {
    @Inject
    PantauJumaAPI sisApi;

    @Inject
    Realm realm;

    public GetHargaService(AppComponent appComponent) {
        appComponent.inject(this);
    }

    public GetHargaContract.Controller controller;

    public void instanceClass(GetHargaContract.Controller controller){
        this.controller = controller;
    }


    private boolean res = false;
    @Override
    public void getAllHarga() {
        Log.e("send","data comehere");
        Call<ResponseHarga> call = sisApi.getAllHarga(WebServiceModule.ACCESS_TOKEN_TEMP);
        call.enqueue(new Callback<ResponseHarga>() {
            @Override
            public void onResponse(Call<ResponseHarga> call, Response<ResponseHarga> response) {
                if(response.isSuccessful()){
                    if(response.body().isSuccess()){
                        Log.e("hasilharga",response.body().getData().size()+" ini");
                        realm.executeTransactionAsync(bgRealm -> bgRealm.insertOrUpdate(response.body().getData()), () -> {
                            controller.getAllHargaSuccess(response.body().getData());
                        }, error -> {
                            Log.e("gethargaeror",error.getMessage());
                        });
                    }else
                        controller.getAllHargaFailed(response.body().getMessage());
                }else{
                    controller.getAllHargaFailed("Server Error");
                }
            }

            @Override
            public void onFailure(Call<ResponseHarga> call, Throwable t) {
                Log.e("Failure", "onFailure");
                controller.getAllHargaFailed(t.getMessage());
                t.printStackTrace();
            }
        });
    }

    @Override
    public void saveData(List<HargaRealm> allTar) {
        for(int i=0; i < allTar.size();i++ ){
            HargaRealm hargaTempRealm = allTar.get(i);
            realm.beginTransaction();
            hargaTempRealm.setIsSync(1);
            realm.commitTransaction();
            HargaBody hargaBody = new HargaBody(hargaTempRealm.getHashId(), hargaTempRealm.getHashKomoditas(),
                    hargaTempRealm.getHashPasar(), hargaTempRealm.getTanggal(), hargaTempRealm.getNilai(),
                    hargaTempRealm.getSatuan(), hargaTempRealm.getNamaPasar(), hargaTempRealm.getAlamat(),
                    hargaTempRealm.getKecamatan(), hargaTempRealm.getKabupaten());

            Log.e("harga service",hargaBody.toString());
            Call<ResponseSaveData> call = sisApi.insertHarga(WebServiceModule.ACCESS_TOKEN_TEMP,hargaBody);
            call.enqueue(new Callback<ResponseSaveData>() {
                @Override
                public void onResponse(Call<ResponseSaveData> call, Response<ResponseSaveData> response) {
                    if(response.isSuccessful()){
                        if(response.body().isSuccess()){

                            controller.saveDataSuccess("Success",hargaTempRealm);
                        }else {
                            controller.saveDataFailed("Failed"+response.body().getMessage());
                        }

                    }else{
                        Log.e("harga service","Error3"+response.toString());
                        controller.saveDataFailed("Failed");
                    }
                }

                @Override
                public void onFailure(Call<ResponseSaveData> call, Throwable t) {
                    Log.e("harga service","error server"+t.getMessage());
                    controller.saveDataFailed("Failed"+t.getMessage());
                    t.printStackTrace();
                }
            });
        }
    }

}