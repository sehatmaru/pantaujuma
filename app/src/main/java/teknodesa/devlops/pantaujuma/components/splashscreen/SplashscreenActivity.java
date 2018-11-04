package teknodesa.devlops.pantaujuma.components.splashscreen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.MainActivity;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.components.base.BaseActivity;
import teknodesa.devlops.pantaujuma.components.signin.LoginActivity;


public class SplashscreenActivity extends BaseActivity implements SplashscreenContract.View{
    @Inject
    SplashscreenController splashController;

    public static Intent createIntent(Context context) {
        return new Intent(context, SplashscreenActivity.class);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MainApplication) getApplication())
                .getComponent()
                .inject(this);
        splashController.setView(this);
        checkNetwork();
    }
    private void checkNetwork(){
        if(isNetworkConnected()){
            showLoading();
            splashController.getInitializeData();
        }else{
            onError(getString(R.string.network_error));
        }
    }

    @Override
    public void sessionUser(boolean result) {
        hideLoading();
        if (result){
            startActivity(MainActivity.createIntent(getApplicationContext()));
        }else{
            startActivity(LoginActivity.createIntent(getApplicationContext()));
        }
    }

    @Override
    public void getInitializeDataSuccess(String message) {
        splashController.checkSession();
    }

    @Override
    public void getInitializeDataFailed(String message) {
        splashController.checkSession();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
