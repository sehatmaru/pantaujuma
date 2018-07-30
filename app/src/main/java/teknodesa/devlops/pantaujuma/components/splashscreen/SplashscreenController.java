package teknodesa.devlops.pantaujuma.components.splashscreen;

import android.support.annotation.NonNull;
import org.greenrobot.eventbus.EventBus;
import javax.inject.Inject;

import io.realm.Realm;
import teknodesa.devlops.pantaujuma.components.profile.AkunFragment;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.UserDB;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.PromoService;

/**
 * Created by Marthin on 2/11/2018.
 */

public class SplashscreenController implements SplashscreenContract.Controller {

    @Inject
    PromoService mService;

    @Inject
    EventBus mBus;

    @Inject
    Realm realm;

    private SplashscreenContract.View views;

    //private FirebaseAuth mAuth;
    public SplashscreenController(@NonNull AppComponent appComponent) {
        appComponent.inject(this);
    }

    public void setView(SplashscreenContract.View view){
        views = view;
    }



    @Override
    public void checkSession() {
        realm.beginTransaction();
        UserDB user =realm.where(UserDB.class).findFirst();
        realm.commitTransaction();
        if(user == null){
            views.sessionUser(false);
        }else{
            AkunFragment.desaUser = user.getNamaDesa();
            AkunFragment.kabupatenKotaUser = user.getKabupatenKota();
            AkunFragment.provinsiUser =user.getProvinsi();
            AkunFragment.kecamatanUser = user.getKecamatan();
            AkunFragment.idDesa = Integer.valueOf(user.getAttributeValue());
            views.sessionUser(true);
        }
    }

    @Override
    public void getPromotion() {
        mService.instanceClass(this);
        mService.getPromotion();
    }

    @Override
    public void resultPromotion(String message) {
        views.resultPromotion(message);
    }
}
