package teknodesa.devlops.pantaujuma.components.harga;

import android.support.annotation.NonNull;
import android.widget.Toast;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;
import teknodesa.devlops.pantaujuma.components.CRUActivity;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.harga.HargaRealm;

public class HargaRepository implements HargaContract.Repository<HargaRealm> {
    @Inject
    Realm realm;

    private HargaContract.Controller mController;

    public HargaRepository(HargaContract.Controller mController, @NonNull AppComponent appComponent) {
        this.mController = mController;
        appComponent.inject(this);
    }

    @Override
    public void addItem(HargaRealm item) {
        realm.beginTransaction();
        realm.executeTransactionAsync(realmIns -> {
            realmIns.insertOrUpdate(item);
        }, () -> {
            mController.responseCRUD(true, "create");
        },(Throwable throwable)->{
            Toast.makeText(CRUActivity.mContext, throwable.getMessage().toString(), Toast.LENGTH_SHORT).show();
            mController.responseCRUD(false, "create");
        });
        realm.commitTransaction();
    }

    @Override
    public void updateItem(String idItem, HargaRealm item) {
        realm.executeTransactionAsync(bgRealm -> {
            bgRealm.insertOrUpdate(item);
        }, () -> {
            // Transaction was a success.
            mController.responseCRUD(true, "update");
        }, error -> {
            // Transaction failed and was automatically canceled.
            mController.responseCRUD(false, "update");
        });
    }

    @Override
    public void deleteItem(String idItem) {
        // obtain the results of a query
        final RealmResults<HargaRealm> results = realm.where(HargaRealm.class).equalTo("hashId", idItem).findAll();

        // All changes to data must happen in a transaction
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                // remove single match
                results.deleteFirstFromRealm();
            }
        });
    }

    @Override
    public void setItemDeleted(String idItem) {
        HargaRealm deletedItem = realm.where(HargaRealm.class).equalTo("hashId", idItem).findFirst();
    }
}
