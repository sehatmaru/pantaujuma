package teknodesa.devlops.pantaujuma.components.penduduk;

import android.support.annotation.NonNull;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.PendudukRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.UserDB;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.penduduk.PendudukTempRealm;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.GetPendudukService;

/**
 * Created by Marthin on 7/10/2018.
 */

public class GetPendudukController implements GetPendudukContract.Controller {

    @Inject
    GetPendudukService mService;

    @Inject
    Realm realm;

    @Inject
    EventBus mBus;

    private GetPendudukContract.View views;

    public GetPendudukController(@NonNull AppComponent appComponent) {
        appComponent.inject(this);
    }


    public void onResume() {
        mBus.register(this);
    }
    public void onPause(){
        mBus.unregister(this);
    }

    public void setView(GetPendudukContract.View view){
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
    public void getAllPenduduk() {

        int res = getIdDesa();
        if(res ==0 ){
            views.getAllPendudukFailed("Terjadi Kesalahan, Silahkan Logout dan login kembali");
        }else{

            mService.getAllPenduduk(res);
        }
    }

    @Override
    public void saveData(List<PendudukTempRealm> allPen) {
        mService.saveData(allPen);
    }

    @Override
    public void getAllPendudukSuccess(List<PendudukRealm> allPenduduk) {
        views.getAllPendudukSuccess(allPenduduk);
    }

    @Override
    public void getAllPendudukFailed(String message) {
        views.getAllPendudukFailed(message);
    }

    @Override
    public void saveDataSuccess(String message,PendudukTempRealm pendudukTempRealm) {
        realm.beginTransaction();
        pendudukTempRealm.deleteFromRealm();
        realm.commitTransaction();

        views.saveDataSuccess(message);
    }

    @Override
    public void saveDataFailed(String message) {
        views.saveDataFailed(message);
    }

    @Override
    public void deleteFromRealm(PendudukTempRealm pendudukTempRealm) {
        realm.beginTransaction();
        pendudukTempRealm.deleteFromRealm();
        realm.commitTransaction();
    }


}
