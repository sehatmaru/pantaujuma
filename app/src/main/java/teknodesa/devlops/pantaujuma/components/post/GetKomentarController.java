package teknodesa.devlops.pantaujuma.components.post;

import android.support.annotation.NonNull;
import java.util.List;
import javax.inject.Inject;
import io.realm.Realm;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.KomentarRealm;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.GetKomentarService;

public class GetKomentarController implements GetKomentarContract.Controller {

    @Inject
    GetKomentarService mService;

    @Inject
    Realm realm;

    private GetKomentarContract.View views;

    public GetKomentarController(@NonNull AppComponent appComponent) {
        appComponent.inject(this);
    }


    public void setView(GetKomentarContract.View view){
        mService.instanceClass(this);
        views = view;
    }

    @Override
    public void getAllKomentar(String idPost) {

        if(idPost ==null ){
            views.getAllKomentarFailed("Terjadi Kesalahan, Silahkan Logout dan login kembali");
        }else{

        mService.getAllKomentar(idPost);
        }
    }

    @Override
    public void saveData(List<KomentarRealm> allKomentar) {
        mService.saveData(allKomentar);
    }

    @Override
    public void getAllKomentarSuccess(List<KomentarRealm> allKomentar) {
        views.getAllKomentarSuccess(allKomentar);
    }

    @Override
    public void getAllKomentarFailed(String message) {
        views.getAllKomentarFailed(message);
    }

    @Override
    public void saveDataSuccess(String message,KomentarRealm posttemp) {
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
    public void updateDataRealm(KomentarRealm posttemp) {

    }
}
