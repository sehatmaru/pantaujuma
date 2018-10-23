package teknodesa.devlops.pantaujuma.components.poktan;

import android.support.annotation.NonNull;
import java.util.List;
import javax.inject.Inject;
import io.realm.Realm;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.UserDB;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.AnggotaPoktanRealm;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.GetAnggotaPoktanService;

/**
 * Created by Marthin on 7/10/2018.
 */

public class GetAnggotaPoktanController implements GetAnggotaPoktanContract.Controller {

    @Inject
    GetAnggotaPoktanService mService;

    @Inject
    Realm realm;

    private GetAnggotaPoktanContract.View views;

    public GetAnggotaPoktanController(@NonNull AppComponent appComponent) {
        appComponent.inject(this);
    }


    public void setView(GetAnggotaPoktanContract.View view){
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
    public void getAllAnggotaPoktan() {

        int res = getIdDesa();
        if(res ==0 ){
            views.getAllAnggotaPoktanFailed("Terjadi Kesalahan, Silahkan Logout dan login kembali");
        }else{
            mService.getAllAnggotaPoktan(res);
        }
    }

    @Override
    public void saveData(List<AnggotaPoktanRealm> allPen) {
        mService.saveData(allPen);
    }

    @Override
    public void getAllAnggotaPoktanSuccess(List<AnggotaPoktanRealm> allAnggotaPoktan) {
        views.getAllAnggotaPoktanSuccess(allAnggotaPoktan);
    }

    @Override
    public void getAllAnggotaPoktanFailed(String message) {
        views.getAllAnggotaPoktanFailed(message);
    }

    @Override
    public void saveDataSuccess(String message,AnggotaPoktanRealm poktanTempRealm) {
        realm.beginTransaction();
        realm.executeTransactionAsync(realmuser -> {
            realmuser.insertOrUpdate(poktanTempRealm);
        });
        realm.commitTransaction();

        views.saveDataSuccess(message);
    }

    @Override
    public void saveDataFailed(String message) {
        views.saveDataFailed(message);
    }

    @Override
    public void updateDataRealm(AnggotaPoktanRealm anggotaPoktanTempRealm) {

    }

}