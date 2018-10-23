package teknodesa.devlops.pantaujuma.components.rdkk;

import android.support.annotation.NonNull;
import java.util.List;
import javax.inject.Inject;
import io.realm.Realm;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.UserDB;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.rdkk.RDKKPupukSubsidiRealm;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.GetRDKKService;

public class GetRDKKController implements GetRDKKContract.Controller {
    @Inject
    GetRDKKService mService;

    @Inject
    Realm realm;


    private GetRDKKContract.View views;

    public GetRDKKController(@NonNull AppComponent appComponent) {
        appComponent.inject(this);
    }


    public void setView(GetRDKKContract.View view){
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
    public void getAllRDKK() {

        int res = getIdDesa();
        if(res ==0 ){
            views.getAllRDKKFailed("Terjadi Kesalahan, Silahkan Logout dan login kembali");
        }else{

            mService.getAllRDKK(res);
        }
    }

    @Override
    public void saveData(List<RDKKPupukSubsidiRealm> allPen) {
        mService.saveData(allPen);
    }

    @Override
    public void getAllRDKKSuccess(List<RDKKPupukSubsidiRealm> allRDKK) {
        views.getAllRDKKSuccess(allRDKK);
    }

    @Override
    public void getAllRDKKFailed(String message) {
        views.getAllRDKKFailed(message);
    }

    @Override
    public void saveDataSuccess(String message,RDKKPupukSubsidiRealm rdkkTempRealm) {
        realm.beginTransaction();
        realm.executeTransactionAsync(realmuser -> {
            realmuser.insertOrUpdate(rdkkTempRealm);
        });
        realm.commitTransaction();

        views.saveDataSuccess(message);
    }

    @Override
    public void saveDataFailed(String message) {
        views.saveDataFailed(message);
    }

    @Override
    public void updateDataRealm(RDKKPupukSubsidiRealm rdkkTempRealm) {

    }
}
