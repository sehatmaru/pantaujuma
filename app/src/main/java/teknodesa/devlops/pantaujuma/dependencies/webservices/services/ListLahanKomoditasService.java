package teknodesa.devlops.pantaujuma.dependencies.webservices.services;

import android.util.Log;

import javax.inject.Inject;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teknodesa.devlops.pantaujuma.components.lahan.ListLahanKomoditasContract;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.BodyGetLahan;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseGetLahanKomoditas;
import teknodesa.devlops.pantaujuma.dependencies.modules.WebServiceModule;
import teknodesa.devlops.pantaujuma.dependencies.webservices.PantauJumaAPI;

/**
 * Created by Marthin on 8/2/2018.
 */

public class ListLahanKomoditasService implements ListLahanKomoditasContract.Repository {

    @Inject
    PantauJumaAPI pjApi;

    @Inject
    Realm realm;

    public ListLahanKomoditasService(AppComponent appComponent) {
        appComponent.inject(this);
    }

    public ListLahanKomoditasContract.Controller controller;

    public void instanceClass(ListLahanKomoditasContract.Controller controller){
        this.controller = controller;
    }

    @Override
    public void getLahanKomoditas(BodyGetLahan bodyGetLahan) {
        Call<ResponseGetLahanKomoditas> call = pjApi.getLahanByKomoditas(WebServiceModule.ACCESS_TOKEN_TEMP,bodyGetLahan);
        call.enqueue(new Callback<ResponseGetLahanKomoditas>() {
            @Override
            public void onResponse(Call<ResponseGetLahanKomoditas> call, Response<ResponseGetLahanKomoditas> response) {
                if(response.isSuccessful()){
                    if(response.body().isSuccess()){

                        realm.beginTransaction();
                        realm.executeTransactionAsync(realm -> {
                            realm.insertOrUpdate(response.body().getLahan());
                        });
                        realm.commitTransaction();

                        realm.beginTransaction();
                        realm.executeTransactionAsync(realm -> {
                            realm.insertOrUpdate(response.body().getData());
                        });
                        realm.commitTransaction();
                        controller.getLahanKomoditasSuccess(response.body().getData());
                    }else
                        controller.getLahanKomoditasFailed(response.body().getMessage());
                }else{
                    controller.getLahanKomoditasFailed("Something Wrong: "+response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseGetLahanKomoditas> call, Throwable t) {
                Log.e("Failure", "onFailure");
                controller.getLahanKomoditasFailed(t.getMessage());
                t.printStackTrace();
            }
        });
    }
}
