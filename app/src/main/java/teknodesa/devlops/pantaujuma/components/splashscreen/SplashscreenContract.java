package teknodesa.devlops.pantaujuma.components.splashscreen;


import lombok.NonNull;

/**
 * Created by Marthin on 2/11/2018.
 */

public class SplashscreenContract {
    public interface View {
        void sessionUser(boolean result);
    }

    public interface Controller {
        void checkSession();
    }
    public interface Repository {
    }
}
