package teknodesa.devlops.pantaujuma.components.komoditas;

import android.support.annotation.NonNull;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.KomoditasRealm;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.KomoditasService;

/**
 * Created by Marthin on 7/30/2018.
 */

public class KomoditasController implements KomoditasContract.Controller {

    @Inject
    KomoditasService mService;

    @Inject
    EventBus mBus;

    private KomoditasContract.View views;

    public KomoditasController(@NonNull AppComponent appComponent) {
        appComponent.inject(this);
    }

    public void setView(KomoditasContract.View view){
        views = view;
    }

    @Override
    public void getAllKomoditas() {
        mService.instanceClass(this);
        mService.getAllKomoditas();
    }

    @Override
    public void getAllKomoditasSuccess(List<KomoditasRealm> allKomoditas) {
        views.getAllKomoditasSuccess(allKomoditas);
    }

    @Override
    public void getAllKomoditasFailed(String message) {
        views.getAllKomoditasFailed(message);
    }
}
