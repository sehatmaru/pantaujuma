package teknodesa.devlops.pantaujuma.components.home;

import android.support.annotation.NonNull;
import java.util.List;
import javax.inject.Inject;
import io.realm.Realm;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.Promotion;

/**
 * Created by Marthin on 2/12/2018.
 */

public class HomeController implements HomeContract.Controller {


    @Inject
    Realm realm;
    private HomeContract.View views;
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;

    public HomeController(@NonNull AppComponent appComponent) {
        appComponent.inject(this);

    }

    public void setView(HomeContract.View view){
        views = view;
    }

    @Override
    public void getPromotion() {
        realm.beginTransaction();
        List<Promotion> allData = realm.where(Promotion.class).findAll();
        realm.commitTransaction();
        if(allData.size()>0){
            views.resultPromotion(true,allData);
        }else {
            views.resultPromotion(false,allData);
        }

    }


}