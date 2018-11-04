package teknodesa.devlops.pantaujuma.components.poktan;

import android.support.annotation.NonNull;
import java.util.List;
import javax.inject.Inject;
import io.realm.Realm;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.UserDB;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.PoktanRealm;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.GetPoktanService;

/**
 * Created by Marthin on 7/10/2018.
 */

public class GetPoktanController implements GetPoktanContract.Controller {

    @Inject
    GetPoktanService mService;

    @Inject
    Realm realm;

    private GetPoktanContract.View views;

    public GetPoktanController(@NonNull AppComponent appComponent) {
        appComponent.inject(this);
    }


    public void setView(GetPoktanContract.View view){
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
    public void getAllPoktan() {

        int res = getIdDesa();
        if(res ==0 ){
            views.getAllPoktanFailed("Terjadi Kesalahan, Silahkan Logout dan login kembali");
        }else{
            mService.getAllPoktan(res);
            mService.getAllAnggotaPoktan(res);
            mService.getAllPengurusPoktan(res);
        }
    }

    @Override
    public void saveData(List<PoktanRealm> allPen) {
        mService.saveData(allPen);
    }

    @Override
    public void getAllPoktanSuccess(List<PoktanRealm> allPoktan) {
        views.getAllPoktanSuccess(allPoktan);
    }

    @Override
    public void getAllPoktanFailed(String message) {
        views.getAllPoktanFailed(message);
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
    public void updateDataRealm(PoktanRealm poktanTempRealm) {

    }

}