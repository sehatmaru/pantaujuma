package teknodesa.devlops.pantaujuma.dependencies.webservices.services;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teknodesa.devlops.pantaujuma.components.post.GetPostContract;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.PostBody;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.PostRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponsePost;
import teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses.ResponseSaveData;
import teknodesa.devlops.pantaujuma.dependencies.modules.WebServiceModule;
import teknodesa.devlops.pantaujuma.dependencies.webservices.PantauJumaAPI;

public class GetPostService implements GetPostContract.Repository {
    @Inject
    PantauJumaAPI sisApi;

    @Inject
    Realm realm;

    public GetPostService(AppComponent appComponent) {
        appComponent.inject(this);
    }

    public GetPostContract.Controller controller;

    public void instanceClass(GetPostContract.Controller controller) {
        this.controller = controller;
    }


    private boolean res = false;

    @Override
    public void getAllPost() {
        Call<ResponsePost> call = sisApi.getAllPost(WebServiceModule.ACCESS_TOKEN_TEMP);
        call.enqueue(new Callback<ResponsePost>() {
            @Override
            public void onResponse(Call<ResponsePost> call, Response<ResponsePost> response) {
                if(response.isSuccessful()){
                    if(response.body().isSuccess()){
                        realm.beginTransaction();
                        realm.executeTransactionAsync(realm -> {
                            realm.insertOrUpdate(response.body().getData());
                        });
                        realm.commitTransaction();
                        controller.getAllPostSuccess(response.body().getData());
                    }else
                        controller.getAllPostFailed(response.body().getMessage());
                }else{
                    controller.getAllPostFailed("Something Wrong: "+response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponsePost> call, Throwable t) {
                Log.e("Failure", "onFailure");
                controller.getAllPostFailed(t.getMessage());
                t.printStackTrace();
            }
        });
    }

    @Override
    public void saveData(List<PostRealm> allTar) {
        for (int i = 0; i < allTar.size(); i++) {
            PostRealm postTempRealm = allTar.get(i);
            realm.beginTransaction();
            postTempRealm.setIsSync(1);
            realm.commitTransaction();
            PostBody postPetugasBody = new PostBody(postTempRealm.getHashId(), postTempRealm.getIdUser(),postTempRealm.getNamaUser(), postTempRealm.getJudul(), postTempRealm.getIsi(), postTempRealm.getTanggal(),
                    postTempRealm.getWaktu(), postTempRealm.getTipePost(), postTempRealm.getViewCount(), postTempRealm.getLikes(), postTempRealm.getDislike(), postTempRealm.getThumbnail(),
                    postTempRealm.getIdDesa());

            Log.e("post service", postPetugasBody.toString());
            Call<ResponseSaveData> call = sisApi.insertPost(WebServiceModule.ACCESS_TOKEN_TEMP, postPetugasBody);
            call.enqueue(new Callback<ResponseSaveData>() {
                @Override
                public void onResponse(Call<ResponseSaveData> call, Response<ResponseSaveData> response) {
                    if (response.isSuccessful()) {
                        if (response.body().isSuccess()) {

                            controller.saveDataSuccess("Success", postTempRealm);
                        } else {
                            controller.saveDataFailed("Failed" + response.body().getMessage());
                        }

                    } else {
                        Log.e("post service", "Error3" + response.toString());
                        controller.saveDataFailed("Failed");
                    }
                }

                @Override
                public void onFailure(Call<ResponseSaveData> call, Throwable t) {
                    Log.e("post service", "error server" + t.getMessage());
                    controller.saveDataFailed("Failed" + t.getMessage());
                    t.printStackTrace();
                }
            });
        }
    }
}
