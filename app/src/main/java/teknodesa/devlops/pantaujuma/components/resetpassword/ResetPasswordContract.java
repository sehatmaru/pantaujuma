package teknodesa.devlops.pantaujuma.components.resetpassword;

import android.content.Context;

/**
 * Created by Marthin on 2/10/2018.
 */

public class ResetPasswordContract {
    public interface View {
        void resetResult(boolean result, String message);
    }

    public interface Controller{
        //Reset Password
        void resetPassword(Context context, String email);
        void resetResult(boolean result, String message);

    }
    public interface Repository{
        void resetPassword(Context context, String email);
    }
}
