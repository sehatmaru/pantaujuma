package teknodesa.devlops.pantaujuma.components.petugas;

import android.support.annotation.NonNull;
import java.util.List;
import javax.inject.Inject;
import io.realm.Realm;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.UserDB;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.petugas.TargetPetugas;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.GetTargetService;

public class GetTargetController implements GetTargetContract.Controller {

    @Inject
    GetTargetService mService;

    @Inject
    Realm realm;

    private GetTargetContract.View views;

    public GetTargetController(@NonNull AppComponent appComponent) {
        appComponent.inject(this);
    }


    public void setView(GetTargetContract.View view){
        mService.instanceClass(this);
        views = view;
    }

    public int getIdDesa() {
        realm.beginTransaction();
        UserDB user =realm.where(UserDB.class).findFirst();
        realm.commitTransaction();
        if(user == null){
            return 0;
        }else{
            return Integer.valueOf(user.getAttributeValue());
        }
    }

    @Override
    public void getAllTarget() {

        int res = getIdDesa();
        if(res ==0 ){
            views.getAllTargetFailed("Terjadi Kesalahan, Silahkan Logout dan login kembali");
        }else{

            mService.getAllTarget(res);
        }
    }

    @Override
    public void saveData(List<TargetPetugas> allTar) {
        mService.saveData(allTar);
    }

    @Override
    public void getAllTargetSuccess(List<TargetPetugas> allTarget) {
        views.getAllTargetSuccess(allTarget);
    }

    @Override
    public void getAllTargetFailed(String message) {
        views.getAllTargetFailed(message);
    }

    @Override
    public void saveDataSuccess(String message) {
        views.saveDataSuccess(message);
    }

    @Override
    public void saveDataFailed(String message) {
        views.saveDataFailed(message);
    }

    @Override
    public void updateDataRealm(TargetPetugas targetTemp) {

    }



}

