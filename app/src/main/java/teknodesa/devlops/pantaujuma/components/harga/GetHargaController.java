package teknodesa.devlops.pantaujuma.components.harga;

import android.support.annotation.NonNull;
import java.util.List;
import javax.inject.Inject;
import io.realm.Realm;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.harga.HargaRealm;
import teknodesa.devlops.pantaujuma.dependencies.webservices.services.GetHargaService;

/**
 * Created by Marthin on 7/10/2018.
 */

public class GetHargaController implements GetHargaContract.Controller {

    @Inject
    GetHargaService mService;
    @Inject
    Realm realm;

    private GetHargaContract.View views;

    public GetHargaController(@NonNull AppComponent appComponent) {
        appComponent.inject(this);
    }

    public void setView(GetHargaContract.View view){
        mService.instanceClass(this);
        views = view;
    }

    @Override
    public void getAllHarga() {
        mService.instanceClass(this);
        mService.getAllHarga();
    }

    @Override
    public void saveData(List<HargaRealm> allPen) {
        mService.saveData(allPen);
    }

    @Override
    public void getAllHargaSuccess(List<HargaRealm> allHarga) {
        views.getAllHargaSuccess(allHarga);
    }

    @Override
    public void getAllHargaFailed(String message) {
        views.getAllHargaFailed(message);
    }

    @Override
    public void saveDataSuccess(String message,HargaRealm hargaTempRealm) {
        realm.beginTransaction();
        realm.executeTransactionAsync(realmuser -> {
            realmuser.insertOrUpdate(hargaTempRealm);
        });
        realm.commitTransaction();

        views.saveDataSuccess(message);
    }

    @Override
    public void saveDataFailed(String message) {
        views.saveDataFailed(message);
    }

    @Override
    public void updateDataRealm(HargaRealm hargaTempRealm) {

    }

}