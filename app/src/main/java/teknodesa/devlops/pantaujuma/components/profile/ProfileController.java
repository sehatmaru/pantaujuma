package teknodesa.devlops.pantaujuma.components.profile;

import android.support.annotation.NonNull;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import io.realm.Realm;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.UserDB;

/**
 * Created by Marthin on 3/28/2018.
 */

public class ProfileController implements ProfileContract.Controller {


    @Inject
    Realm realm;
    @Inject
    EventBus mBus;

    private ProfileContract.View views;


    public ProfileController(@NonNull AppComponent appComponent) {
        appComponent.inject(this);

    }


    public void onResume() {
        mBus.register(this);
    }
    public void onPause(){
        mBus.unregister(this);
    }

    public void setView(ProfileContract.View view){
        views = view;
    }




    @Override
    public void getProfileUser() {
        realm.beginTransaction();
        UserDB user =realm.where(UserDB.class).findFirst();
        realm.commitTransaction();
        if(user == null){
            views.getProfileUserFailed("0");
        }else{
            views.getProfileUserSuccess(user);
        }
    }



}
