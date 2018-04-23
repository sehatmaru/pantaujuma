package teknodesa.devlops.pantaujuma.components.resetpassword;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.signin.LoginActivity;

public class ResetPasswordActivity extends AppCompatActivity implements ResetPasswordContract.View{

    ResetFirebaseController resetFirebaseController;

    private ProgressDialog progressdialog;
    @BindView(R.id.email)
    TextInputEditText email;
    @BindView(R.id.btn_reset_password)
    Button btnReset;

    @OnClick(R.id.btn_reset_password)
    void resetClicked(){
        if(TextUtils.isEmpty(email.getText().toString())){
            Toast.makeText(this, getString(R.string.error_email), Toast.LENGTH_SHORT).show();
        }else{
            progressdialog.setMessage(getString(R.string.judul_pd));
            progressdialog.show();
            progressdialog.setCancelable(false);
            progressdialog.setCanceledOnTouchOutside(false);
            resetFirebaseController.resetPassword(this, email.getText().toString());
        }

    }
    @BindView(R.id.btn_back)
    Button btnBack;
    @OnClick(R.id.btn_back)
    void backClicked(){
        finish();
    }
    public static Intent createIntent(Context context) {
        return new Intent(context, ResetPasswordActivity.class);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        ButterKnife.bind(this);
        resetFirebaseController = new ResetFirebaseController(this);
        progressdialog = new ProgressDialog(ResetPasswordActivity.this);
    }

    @Override
    public void resetResult(boolean result, String message) {
        progressdialog.dismiss();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        startActivity(LoginActivity.createIntent(getApplicationContext()));
    }
}
