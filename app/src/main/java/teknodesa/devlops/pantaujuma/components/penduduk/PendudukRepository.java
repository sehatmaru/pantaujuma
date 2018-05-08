package teknodesa.devlops.pantaujuma.components.penduduk;

import android.util.Log;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.PendudukRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.petani.PetaniRealm;

public class PendudukRepository implements PendudukContract.Repository<PendudukRealm> {
    @Inject
    Realm realm;

    private PendudukContract.Controller mController;

    public PendudukRepository(PendudukContract.Controller mController) {
        this.mController = mController;
    }

    @Override
    public void addItem(PendudukRealm item) {
        Log.e("Error", "Masuk addItem success");
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                PendudukRealm pendudukRealm = bgRealm.copyToRealm(item);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                // Transaction was a success.
                mController.responseCRUD(true, "create");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                // Transaction failed and was automatically canceled.
                mController.responseCRUD(false, "create");
            }
        });
    }

    @Override
    public void updateItem(int idItem, PendudukRealm item) {
        Log.e("Error", "Masuk addItem success");
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                bgRealm.insertOrUpdate(item);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                // Transaction was a success.
                mController.responseCRUD(true, "create");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                // Transaction failed and was automatically canceled.
                mController.responseCRUD(false, "create");
            }
        });
    }

    @Override
    public void deleteItem(int idItem) {
    // obtain the results of a query
        final RealmResults<PendudukRealm> results = realm.where(PendudukRealm.class).equalTo("idPenduduk", idItem).findAll();

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
    public RealmResults<PendudukRealm> getAllItem() {
        // Or alternatively do the same all at once (the "Fluent interface"):
        RealmResults<PendudukRealm> results = realm.where(PendudukRealm.class)
                .findAll();

        return results;
    }

    @Override
    public PetaniRealm getSingleItemById(int idItem) {
        // Or alternatively do the same all at once (the "Fluent interface"):
        RealmResults<PendudukRealm> results = realm.where(PendudukRealm.class)
                .equalTo("idPenduduk", idItem)
                .findAll();

        return results;
    }
}
