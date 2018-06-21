package teknodesa.devlops.pantaujuma.components.petani;

import android.util.Log;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.petani.PetaniRealm;

public class PetaniRepository implements PetaniContract.Repository<PetaniRealm> {
    @Inject
    Realm realm;

    private PetaniContract.Controller mController;

    public PetaniRepository(PetaniContract.Controller mController) {
        this.mController = mController;
    }

    @Override
    public void addItem(PetaniRealm item) {
        Log.e("Error", "Masuk addItem success");
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                PetaniRealm PetaniRealm = bgRealm.copyToRealm(item);
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
    public void updateItem(int idItem, PetaniRealm item) {
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
        final RealmResults<PetaniRealm> results = realm.where(PetaniRealm.class).equalTo("idPenduduk", idItem).findAll();

    // All changes to data must happen in a transaction
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                // remove single match
                results.deleteFirstFromRealm();
            }
        });
    }
}
