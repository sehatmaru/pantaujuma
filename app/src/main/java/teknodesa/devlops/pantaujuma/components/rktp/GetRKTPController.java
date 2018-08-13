package teknodesa.devlops.pantaujuma.components.rktp;

import android.support.annotation.NonNull;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.UserDB;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.rktp.RKTPRealm;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.GetRKTPService;

public class GetRKTPController implements GetRKTPContract.Controller {

    @Inject
    GetRKTPService mService;

    @Inject
    Realm realm;

    @Inject
    EventBus mBus;

    private GetRKTPContract.View views;

    public GetRKTPController(@NonNull AppComponent appComponent) {
        appComponent.inject(this);
    }


    public void onResume() {
        mBus.register(this);
    }
    public void onPause(){
        mBus.unregister(this);
    }

    public void setView(GetRKTPContract.View view){
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
    public void getAllRKTP() {

        int res = getIdDesa();
        if(res ==0 ){
            views.getAllRKTPFailed("Terjadi Kesalahan, Silahkan Logout dan login kembali");
        }else{

            mService.getAllRKTP(res);
        }
    }

    @Override
    public void saveData(List<RKTPRealm> allRktp) {
        mService.saveData(allRktp);
    }

    @Override
    public void getAllRKTPSuccess(List<RKTPRealm> allRKTP) {
        views.getAllRKTPSuccess(allRKTP);
    }

    @Override
    public void getAllRKTPFailed(String message) {
        views.getAllRKTPFailed(message);
    }

    @Override
    public void saveDataSuccess(String message,RKTPRealm targetTemp) {
        realm.beginTransaction();
        realm.executeTransactionAsync(realmuser -> {
            realmuser.insertOrUpdate(targetTemp);
        });
        realm.commitTransaction();

        views.saveDataSuccess(message);
    }

    @Override
    public void saveDataFailed(String message) {
        views.saveDataFailed(message);
    }

    @Override
    public void updateDataRealm(RKTPRealm targetTemp) {

    }



}
