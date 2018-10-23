package teknodesa.devlops.pantaujuma.components.signin;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import io.realm.Realm;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.UserDB;

/**
 * Created by Marthin on 10/23/2018.
 */

public class UserRealmController {

    @Inject
    Realm realm;

    public UserRealmController(@NonNull AppComponent appComponent) {
        appComponent.inject(this);
    }

    public UserDB getUser() {
        realm.beginTransaction();
        UserDB user = realm.where(UserDB.class).findFirst();
        realm.commitTransaction();

        if (user == null) {
            return null;
        } else {
            return user;
        }
    }
}
