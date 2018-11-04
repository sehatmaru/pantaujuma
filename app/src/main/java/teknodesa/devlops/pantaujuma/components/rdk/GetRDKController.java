package teknodesa.devlops.pantaujuma.components.rdk;

import android.support.annotation.NonNull;
import java.util.List;
import javax.inject.Inject;
import io.realm.Realm;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.UserDB;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.rdk.RDKRealm;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.GetRDKService;

public class GetRDKController implements GetRDKContract.Controller {
    @Inject
    GetRDKService mService;

    @Inject
    Realm realm;

    private GetRDKContract.View views;

    public GetRDKController(@NonNull AppComponent appComponent) {
        appComponent.inject(this);
    }


    public void setView(GetRDKContract.View view){
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
    public void getAllRDK() {

        int res = getIdDesa();
        if(res ==0 ){
            views.getAllRDKFailed("Terjadi Kesalahan, Silahkan Logout dan login kembali");
        }else{

            mService.getAllRDK(res);
        }
    }

    @Override
    public void saveData(List<RDKRealm> allPen) {
        mService.saveData(allPen);
    }

    @Override
    public void getAllRDKSuccess(List<RDKRealm> allRDK) {
        views.getAllRDKSuccess(allRDK);
    }

    @Override
    public void getAllRDKFailed(String message) {
        views.getAllRDKFailed(message);
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
    public void updateDataRealm(RDKRealm rdkTempRealm) {

    }

}
