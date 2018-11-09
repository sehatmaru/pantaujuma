package teknodesa.devlops.pantaujuma.components.splashscreen;

/**
 * Created by Marthin on 2/11/2018.
 */

public class SplashscreenContract {
    public interface View {
        void sessionUser(boolean result);
        void getInitializeDataSuccess(String message);
        void getInitializeDataFailed(String message);
    }

    public interface Controller {
        void checkSession();
        void getInitializeData();
        void getInitializeDataSuccess(String message);
        void getInitializeDataFailed(String message);
    }
    public interface Repository {
        void getInitializeData();
    }
}
