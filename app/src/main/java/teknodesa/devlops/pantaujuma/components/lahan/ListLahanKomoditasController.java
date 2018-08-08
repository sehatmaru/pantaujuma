package teknodesa.devlops.pantaujuma.components.lahan;

import android.support.annotation.NonNull;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.lahan.BodyGetLahan;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.lahan.RiwayatLahanRealm;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.ListLahanKomoditasService;

/**
 * Created by Marthin on 7/31/2018.
 */

public class ListLahanKomoditasController implements ListLahanKomoditasContract.Controller{

    @Inject
    ListLahanKomoditasService mService;

    @Inject
    EventBus mBus;

    private ListLahanKomoditasContract.View views;

    public ListLahanKomoditasController(@NonNull AppComponent appComponent) {
        appComponent.inject(this);
    }

    public void setView(ListLahanKomoditasContract.View view){
        views = view;
    }

    @Override
    public void getLahanKomoditas(BodyGetLahan bodyGetLahan) {
        mService.instanceClass(this);
        mService.getLahanKomoditas(bodyGetLahan);
    }

    @Override
    public void getLahanKomoditasSuccess(List<RiwayatLahanRealm> riwayatLahanRealms) {
        views.getLahanKomoditasSuccess(riwayatLahanRealms);
    }

    @Override
    public void getLahanKomoditasFailed(String message) {
        views.getLahanKomoditasFailed(message);
    }
}
