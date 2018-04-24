package teknodesa.devlops.pantaujuma.components.signup;

import teknodesa.devlops.pantaujuma.dependencies.models.webservices.RegisterModel;


/**
 * Created by Marthin on 2/10/2018.
 */

public class RegisterContract {

    public interface View {
        void registerSuccess(String message);
        void registerFailed(String message);
    }

    public interface Controller{
        void registerUser(RegisterModel registerModel);
        void registerSuccess(String message);
        void registerFailed(String message);

    }
    public interface Repository {
        void registerUser(RegisterModel registerModel);
    }
}
