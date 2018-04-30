package teknodesa.devlops.pantaujuma.components;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import teknodesa.devlops.pantaujuma.R;
import teknodesa.devlops.pantaujuma.components.home.HomeFragment;
import teknodesa.devlops.pantaujuma.components.penduduk.AddPendudukFragment;

public class MainActivity extends AppCompatActivity {
    /*@BindView(R.id.message)
    TextView mTextMessage;*/
    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    HomeFragment homeFragment;
    AddPendudukFragment addPendudukFragment;

    private boolean doubleBackToExitPressedOnce = false;

    public static Intent createIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);
                    replaceFragment(homeFragment);
                    return true;
                case R.id.navigation_juma:
                    //mTextMessage.setText(R.string.title_juma);
                    replaceFragment(addPendudukFragment);
                    return true;
                case R.id.navigation_post:
                    //mTextMessage.setText(R.string.title_post);
                    return true;
                case R.id.navigation_profil:
                    //mTextMessage.setText(R.string.title_profil);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        setupTabLayout();
    }

    private void setupTabLayout() {
        homeFragment = new HomeFragment();
        addPendudukFragment = new AddPendudukFragment ();
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.content, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {

            super.onBackPressed();
            return;
        }
        if (navigation.getSelectedItemId() == R.id.navigation_home) {
            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Press BACK again to exit", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(() -> doubleBackToExitPressedOnce = false, 1500);
        } else {
            replaceFragment(homeFragment);
        }
    }
}
