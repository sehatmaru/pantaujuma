package teknodesa.devlops.pantaujuma.components.profile;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.UserDB;

/**
 * Created by Marthin on 3/28/2018.
 */

public class ProfileContract {
    public interface View {
        void getProfileUserSuccess(UserDB userRealm);
        void getProfileUserFailed(String message);
    }

    public interface Controller {
        void getProfileUser();

    }

    public interface Repository{

    }
}
