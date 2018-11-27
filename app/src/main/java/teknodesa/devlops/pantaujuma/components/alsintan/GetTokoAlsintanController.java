package teknodesa.devlops.pantaujuma.components.alsintan;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.alsintan.TokoAlsintanRealm;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.GetTokoAlsintanService;

/**
 * Created by Marthin on 7/10/2018.
 */

public class GetTokoAlsintanController implements GetTokoAlsintanContract.Controller {

    @Inject
    GetTokoAlsintanService mService;

    private GetTokoAlsintanContract.View views;

    public GetTokoAlsintanController(@NonNull AppComponent appComponent) {
        appComponent.inject(this);
    }

    public void setView(GetTokoAlsintanContract.View view){
        mService.instanceClass(this);
        views = view;
    }

    @Override
    public void getAllTokoAlsintan() {
        mService.getAllTokoAlsintan();
    }

    @Override
    public void getAllTokoAlsintanSuccess(List<TokoAlsintanRealm> allTokoAlsintan) {
        views.getAllTokoAlsintanSuccess(allTokoAlsintan);
    }

    @Override
    public void getAllTokoAlsintanFailed(String message) {
        views.getAllTokoAlsintanFailed(message);
    }

}