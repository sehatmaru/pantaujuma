package teknodesa.devlops.pantaujuma.components.post;

import android.support.annotation.NonNull;
import java.util.List;
import javax.inject.Inject;
import io.realm.Realm;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.PostRealm;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.GetPostService;

public class GetPostController implements GetPostContract.Controller {

    @Inject
    GetPostService mService;

    @Inject
    Realm realm;

    private GetPostContract.View views;

    public GetPostController(@NonNull AppComponent appComponent) {
        appComponent.inject(this);
    }

    public void setView(GetPostContract.View view){
        mService.instanceClass(this);
        views = view;
    }

    public int getIdPost() {
        realm.beginTransaction();
        PostRealm post =realm.where(PostRealm.class).findFirst();
        realm.commitTransaction();
        if(post == null){
            return 0;
        }else{
            return Integer.valueOf(post.getHashId());
        }
    }

    @Override
    public void getAllPost() {
        mService.getAllPost();
    }

    @Override
    public void saveData(List<PostRealm> allPost) {
        mService.saveData(allPost);
    }

    @Override
    public void getAllPostSuccess(List<PostRealm> allPost) {
        views.getAllPostSuccess(allPost);
    }

    @Override
    public void getAllPostFailed(String message) {
        views.getAllPostFailed(message);
    }

    @Override
    public void saveDataSuccess(String message,PostRealm posttemp) {
        realm.beginTransaction();
        realm.executeTransactionAsync(realmuser -> {
            realmuser.insertOrUpdate(posttemp);
        });
        realm.commitTransaction();

        views.saveDataSuccess(message);
    }

    @Override
    public void saveDataFailed(String message) {
        views.saveDataFailed(message);
    }

    @Override
    public void updateDataRealm(PostRealm posttemp) {

    }
}
