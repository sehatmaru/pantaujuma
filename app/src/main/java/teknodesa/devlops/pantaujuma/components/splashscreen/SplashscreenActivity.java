package teknodesa.devlops.pantaujuma.components.splashscreen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import teknodesa.devlops.pantaujuma.MainActivity;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.base.BaseActivity;


public class SplashscreenActivity extends BaseActivity implements SplashscreenContract.View{
    @Inject
    SplashscreenController splashController;

    @BindView(R.id.activity_splash_screen)
    RelativeLayout relativeLayout;

    public static Intent createIntent(Context context) {
        return new Intent(context, SplashscreenActivity.class);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        ((MainApplication) getApplication())
                .getComponent()
                .inject(this);
        ButterKnife.bind(this);
        splashController.setView(this);
        checkSesion();
    }
    private void checkSesion(){

        if(isNetworkConnected()){
            showLoading();
           // splashController.getPromotion();
        }else{
            onError(getString(R.string.network_error));
        }

    }

    @Override
    public void sessionUser(boolean result) {
        //false means user is not login
        hideLoading();
        if (result)
            startActivity(MainActivity.createIntent(getApplicationContext()));
        else
            startActivity(LoginActivity.createIntent(getApplicationContext()));
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


}