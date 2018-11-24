package teknodesa.devlops.pantaujuma.dependencies.webservices.services;

import android.util.Log;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teknodesa.devlops.pantaujuma.components.komoditas.GetLahanByKomoditasContract;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.BodyGetLahan;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.LahanRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.RiwayatLahanRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseGetLahanKomoditas;
import teknodesa.devlops.pantaujuma.dependencies.modules.WebServiceModule;
import teknodesa.devlops.pantaujuma.dependencies.webservices.PantauJumaAPI;

/**
 * Created by Marthin on 7/10/2018.
 */

public class GetLahanByKomoditasService implements GetLahanByKomoditasContract.Repository {
    @Inject
    PantauJumaAPI sisApi;

    @Inject
    Realm realm;

    public GetLahanByKomoditasService(AppComponent appComponent) {
        appComponent.inject(this);
    }

    public GetLahanByKomoditasContract.Controller controller;

    public void instanceClass(GetLahanByKomoditasContract.Controller controller){
        this.controller = controller;
    }

    @Override
    public void getAllLahanByKomoditas(BodyGetLahan getLahan){
        Call<ResponseGetLahanKomoditas> call = sisApi.getLahanByKomoditas(WebServiceModule.ACCESS_TOKEN_TEMP, getLahan);
        Log.e("body", getLahan.toString());
        call.enqueue(new Callback<ResponseGetLahanKomoditas>() {
            @Override
            public void onResponse(Call<ResponseGetLahanKomoditas> call, Response<ResponseGetLahanKomoditas> response) {
                if(response.isSuccessful()){
                    if(response.body().isSuccess()){
                        realm.beginTransaction();
                        RealmResults<LahanRealm> allAlsintans = realm.where(LahanRealm.class).findAll();
                        Log.e("deletesize", allAlsintans.size()+"");
                        Log.e("indelete", allAlsintans.toString());
                        allAlsintans.deleteAllFromRealm();
                        realm.commitTransaction();

                        realm.beginTransaction();
                        realm.executeTransactionAsync(realmkelompok -> realmkelompok.insertOrUpdate(response.body().getLahan()));
                        realm.commitTransaction();

                        Log.e("get", response.body().getLahan().size()+"");
                        Log.e("hasilget", response.body().getLahan().toString());
                        controller.getAllLahanByKomoditasSuccess(response.body().getLahan());
                    }else{
                        controller.getAllLahanByKomoditasFailed("Error "+response.message());
                    }
                }else{
                    controller.getAllLahanByKomoditasFailed("Server Error "+response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseGetLahanKomoditas> call, Throwable t) {
                Log.e("Failure", "onFailure");
                controller.getAllLahanByKomoditasFailed(t.getMessage());
                t.printStackTrace();
            }
        });
    }

//    @Override
//    public void getAllLahanByKomoditas(BodyGetLahan getLahan) {
//        Call<ResponseGetLahanKomoditas> call = sisApi.getLahanByKomoditas(WebServiceModule.ACCESS_TOKEN_TEMP, getLahan);
//        Log.e("bodyget", getLahan.toString());
//        call.enqueue(new Callback<ResponseGetLahanKomoditas>() {
//            @Override
//            public void onResponse(Call<ResponseGetLahanKomoditas> call, Response<ResponseGetLahanKomoditas> response) {
//                if(response.isSuccessful()){
//                    if(response.body().isSuccess()){
//                        realm.beginTransaction();
//                        RealmResults<LahanRealm> allLahans = realm.where(LahanRealm.class).findAll();
//                        allLahans.deleteAllFromRealm();
//                        realm.commitTransaction();
//
//                        realm.beginTransaction();
//                        realm.executeTransactionAsync(realmkelompok -> realmkelompok.insertOrUpdate(response.body().getLahan()));
//                        realm.commitTransaction();
//
//                        controller.getAllLahanByKomoditasSuccess(response.body().getLahan());
//                    }else{
//                        controller.getAllLahanByKomoditasFailed("Error "+response.message());
//                    }
//                }else{
//                    Log.e("error2", "checked");
//                    controller.getAllLahanByKomoditasFailed("Server Error "+response.message());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseGetLahanKomoditas> call, Throwable t) {
//                Log.e("Failure", "onFailure");
//                controller.getAllLahanByKomoditasFailed(t.getMessage());
//                t.printStackTrace();
//            }
//        });
//    }

}