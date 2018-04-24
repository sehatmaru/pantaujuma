package teknodesa.devlops.pantaujuma.components.signin;

import teknodesa.devlops.pantaujuma.dependencies.models.webservices.LoginModel;

/**
 * Created by Marthin on 2/11/2018.
 */

public class LoginContract {
    public interface View {
        void loginSuccess(String message);
        void loginFailed(String message);
    }

    public interface Controller {
        void loginUser(LoginModel loginModel); //dipanggil oleh event input control, mis. onClick
        void loginSuccess(String message);
        void loginFailed(String message);

    }
    public interface Repository {
        void loginUser(LoginModel loginModel);
    }
}
