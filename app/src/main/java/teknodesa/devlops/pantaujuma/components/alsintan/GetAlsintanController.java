package teknodesa.devlops.pantaujuma.components.alsintan;

import android.support.annotation.NonNull;
import java.util.List;
import javax.inject.Inject;
import io.realm.Realm;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.UserDB;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.alsintan.AlsintanRealm;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.GetAlsintanService;

/**
 * Created by Marthin on 7/10/2018.
 */

public class GetAlsintanController implements GetAlsintanContract.Controller {

    @Inject
    GetAlsintanService mService;

    @Inject
    Realm realm;


    private GetAlsintanContract.View views;

    public GetAlsintanController(@NonNull AppComponent appComponent) {
        appComponent.inject(this);
    }



    public void setView(GetAlsintanContract.View view){
        mService.instanceClass(this);
        views = view;
    }

    public int getIdDesa() {
        realm.beginTransaction();
        UserDB user =realm.where(UserDB.class).findFirst();
        realm.commitTransaction();
        if(user == null){
            return 0;
        }else{
            return Integer.valueOf(user.getAttributeValue());
        }
    }

    @Override
    public void getAllAlsintan() {
        mService.getAllAlsintan();
    }

    @Override
    public void getAllAlsintanSuccess(List<AlsintanRealm> allAlsintan) {
        views.getAllAlsintanSuccess(allAlsintan);
    }

    @Override
    public void getAllAlsintanFailed(String message) {
        views.getAllAlsintanFailed(message);
    }
}