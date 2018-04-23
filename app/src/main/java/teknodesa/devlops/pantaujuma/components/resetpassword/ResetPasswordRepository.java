package teknodesa.devlops.pantaujuma.components.resetpassword;

import android.app.Activity;
import android.content.Context;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Marthin on 2/10/2018.
 */

public class ResetPasswordRepository implements ResetPasswordContract.Repository {
    private ResetPasswordContract.Controller resetController;
    private FirebaseAuth mAuth;

    public ResetPasswordRepository(ResetPasswordContract.Controller resetController) {
        this.resetController = resetController;
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void resetPassword(Context context, String email) {
        mAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener((Activity)context, task -> {
                    if (task.isSuccessful()) {
                        resetController.resetResult(true,"Silahkan Cek Email untuk reset Password");
                    } else {
                        resetController.resetResult(false,task.getException().getMessage().toString());
                    }
                });
    }
}
