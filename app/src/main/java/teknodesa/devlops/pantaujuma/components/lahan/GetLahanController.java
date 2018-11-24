package teknodesa.devlops.pantaujuma.components.lahan;

import android.support.annotation.NonNull;
import java.util.List;
import javax.inject.Inject;
import io.realm.Realm;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.UserDB;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.LahanRealm;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.GetLahanService;

/**
 * Created by Marthin on 7/10/2018.
 */

public class GetLahanController implements GetLahanContract.Controller {

    @Inject
    GetLahanService mService;

    @Inject
    Realm realm;


    private GetLahanContract.View views;

    public GetLahanController(@NonNull AppComponent appComponent) {
        appComponent.inject(this);
    }


    public void setView(GetLahanContract.View view){
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
    public void getAllLahan() {

        int res = getIdDesa();
        if(res ==0 ){
            views.getAllLahanFailed("Terjadi Kesalahan, Silahkan Logout dan login kembali");
        }else{
            mService.getAllLahan(res);
        }
    }

    @Override
    public void saveData(List<LahanRealm> allPen) {
        mService.saveData(allPen);
    }

    @Override
    public void getAllLahanSuccess(List<LahanRealm> allLahan) {
        views.getAllLahanSuccess(allLahan);
    }

    @Override
    public void getAllLahanFailed(String message) {
        views.getAllLahanFailed(message);
    }

    @Override
    public void saveDataSuccess(String message,LahanRealm lahanTempRealm) {
        realm.beginTransaction();
        realm.executeTransactionAsync(realmuser -> {
            realmuser.insertOrUpdate(lahanTempRealm);
        });
        realm.commitTransaction();

        views.saveDataSuccess(message);
    }

    @Override
    public void saveDataFailed(String message) {
        views.saveDataFailed(message);
    }

    @Override
    public void updateDataRealm(LahanRealm lahanTempRealm) {

    }



}
