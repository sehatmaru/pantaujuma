package teknodesa.devlops.pantaujuma.components.lahan;

import android.util.Log;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.lahan.LahanRealm;

public class LahanRepository implements LahanContract.Repository<LahanRealm> {
    @Inject
    Realm realm;

    private LahanContract.Controller mController;

    public LahanRepository(LahanContract.Controller mController) {
        this.mController = mController;
    }

    @Override
    public void addItem(LahanRealm item) {
        Log.e("Error", "Masuk addItem success");
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                LahanRealm LahanRealm = bgRealm.copyToRealm(item);
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
    public void updateItem(int idItem, LahanRealm item) {
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
        final RealmResults<LahanRealm> results = realm.where(LahanRealm.class).equalTo("idLahan", idItem).findAll();

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
    public void setItemDeleted(int idItem) {
        Log.e("Error", "Masuk setItemDeleted success");
        LahanRealm deletedItem = realm.where(LahanRealm.class).equalTo("idPetani", idItem).findFirst();

        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                //deletedItem.setDeleted(true);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                // Transaction was a success.
                mController.responseCRUD(true, "delete");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                // Transaction failed and was automatically canceled.
                mController.responseCRUD(false, "delete");
            }
        });
    }
}
