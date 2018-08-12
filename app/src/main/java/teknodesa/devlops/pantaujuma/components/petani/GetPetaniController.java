package teknodesa.devlops.pantaujuma.components.petani;

import android.support.annotation.NonNull;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.UserDB;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.petani.PetaniRealm;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.GetPetaniService;

/**
 * Created by Marthin on 7/10/2018.
 */

public class GetPetaniController implements GetPetaniContract.Controller {

    @Inject
    GetPetaniService mService;

    @Inject
    Realm realm;

    @Inject
    EventBus mBus;

    private GetPetaniContract.View views;

    public GetPetaniController(@NonNull AppComponent appComponent) {
        appComponent.inject(this);
    }

    public void onResume() {
        mBus.register(this);
    }
    public void onPause(){
        mBus.unregister(this);
    }

    public void setView(GetPetaniContract.View view){
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
    public void getAllPetani() {

        int res = getIdDesa();
        if(res ==0 ){
            views.getAllPetaniFailed("Terjadi Kesalahan, Silahkan Logout dan login kembali");
        }else{
            mService.getAllPetani(res);
        }
    }

    @Override
    public void saveData(List<PetaniRealm> allPen) {
        mService.saveData(allPen);
    }

    @Override
    public void getAllPetaniSuccess(List<PetaniRealm> allPetani) {
        views.getAllPetaniSuccess(allPetani);
    }

    @Override
    public void getAllPetaniFailed(String message) {
        views.getAllPetaniFailed(message);
    }

    @Override
    public void saveDataSuccess(String message,PetaniRealm petaniTempRealm) {
        realm.beginTransaction();
        realm.executeTransactionAsync(realmuser -> {
            realmuser.insertOrUpdate(petaniTempRealm);
        });
        realm.commitTransaction();

        views.saveDataSuccess(message);
    }

    @Override
    public void saveDataFailed(String message) {
        views.saveDataFailed(message);
    }

    @Override
    public void updateDataRealm(PetaniRealm petaniTempRealm) {

    }

}