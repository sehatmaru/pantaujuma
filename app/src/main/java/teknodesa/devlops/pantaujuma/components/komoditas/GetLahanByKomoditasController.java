package teknodesa.devlops.pantaujuma.components.komoditas;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import teknodesa.devlops.pantaujuma.components.petani.GetPetaniContract;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.BodyGetLahan;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.UserDB;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.LahanRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.RiwayatLahanRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.petani.PetaniRealm;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.GetLahanByKomoditasService;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.GetPetaniService;

/**
 * Created by Marthin on 7/10/2018.
 */

public class GetLahanByKomoditasController implements GetLahanByKomoditasContract.Controller {

    @Inject
    GetLahanByKomoditasService mService;

    @Inject
    Realm realm;


    private GetLahanByKomoditasContract.View views;

    public GetLahanByKomoditasController(@NonNull AppComponent appComponent) {
        appComponent.inject(this);
    }


    public void setView(GetLahanByKomoditasContract.View view){
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
    public void getAllLahanByKomoditas(BodyGetLahan getLahan) {

        if(getLahan == null){
            views.getAllLahanByKomoditasFailed("Terjadi Kesalahan, Silahkan Logout dan login kembali");
        }else{
            mService.getAllLahanByKomoditas(getLahan);
        }
    }

    @Override
    public void getAllLahanByKomoditasSuccess(List<LahanRealm> lahan) {
        views.getAllLahanByKomoditasSuccess(lahan);
    }

    @Override
    public void getAllLahanByKomoditasFailed(String message) {
        views.getAllLahanByKomoditasFailed(message);
    }

}