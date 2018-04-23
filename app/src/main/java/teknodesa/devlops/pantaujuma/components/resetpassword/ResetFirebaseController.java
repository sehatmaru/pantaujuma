package teknodesa.devlops.pantaujuma.components.resetpassword;

import android.content.Context;

/**
 * Created by Marthin on 2/10/2018.
 */

public class ResetFirebaseController implements ResetPasswordContract.Controller {

    private ResetPasswordContract.View mView;
    ResetPasswordContract.Repository mRepository;


    public ResetFirebaseController(ResetPasswordContract.View mView) {
        this.mView = mView;
        mRepository = new ResetPasswordRepository(this);
    }

    @Override
    public void resetPassword(Context context, String email) {
        mRepository.resetPassword(context, email);
    }

    @Override
    public void resetResult(boolean result, String message) {
        mView.resetResult(result, message);
    }
}
