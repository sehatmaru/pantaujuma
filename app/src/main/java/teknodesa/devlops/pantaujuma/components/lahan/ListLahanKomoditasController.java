package teknodesa.devlops.pantaujuma.components.lahan;

import android.support.annotation.NonNull;
import java.util.List;
import javax.inject.Inject;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.BodyGetLahan;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.LahanRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.RiwayatLahanRealm;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.ListLahanKomoditasService;

/**
 * Created by Marthin on 7/31/2018.
 */

public class ListLahanKomoditasController implements ListLahanKomoditasContract.Controller{

    @Inject
    ListLahanKomoditasService mService;

    private ListLahanKomoditasContract.View views;

    public ListLahanKomoditasController(@NonNull AppComponent appComponent) {
        appComponent.inject(this);
    }

    public void setView(ListLahanKomoditasContract.View view){
        views = view;
    }


    @Override
    public void getLahanKomoditas(BodyGetLahan bodyGetLahan) {

    }

    @Override
    public void getLahanKomoditasSuccess(List<LahanRealm> lahan) {
        views.getLahanKomoditasSuccess(lahan);
    }

    @Override
    public void getLahanKomoditasFailed(String message) {
        views.getLahanKomoditasFailed(message);
    }
}
