package teknodesa.devlops.pantaujuma.components.poktan;

import android.support.annotation.NonNull;
import java.util.List;
import javax.inject.Inject;
import io.realm.Realm;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.UserDB;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.PengurusPoktanRealm;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.GetPengurusPoktanService;

/**
 * Created by Marthin on 7/10/2018.
 */

public class GetPengurusPoktanController implements GetPengurusPoktanContract.Controller {

    @Inject
    GetPengurusPoktanService mService;

    @Inject
    Realm realm;


    private GetPengurusPoktanContract.View views;

    public GetPengurusPoktanController(@NonNull AppComponent appComponent) {
        appComponent.inject(this);
    }

    public void setView(GetPengurusPoktanContract.View view){
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
    public void getAllPengurusPoktan() {

        int res = getIdDesa();
        if(res ==0 ){
            views.getAllPengurusPoktanFailed("Terjadi Kesalahan, Silahkan Logout dan login kembali");
        }else{
            mService.getAllPengurusPoktan(res);
        }
    }

    @Override
    public void saveData(List<PengurusPoktanRealm> allPen) {
        mService.saveData(allPen);
    }

    @Override
    public void getAllPengurusPoktanSuccess(List<PengurusPoktanRealm> allPengurusPoktan) {
        views.getAllPengurusPoktanSuccess(allPengurusPoktan);
    }

    @Override
    public void getAllPengurusPoktanFailed(String message) {
        views.getAllPengurusPoktanFailed(message);
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
    public void updateDataRealm(PengurusPoktanRealm pengurusPoktanTempRealm) {

    }

}