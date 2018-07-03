package teknodesa.devlops.pantaujuma.components.penduduk;

import android.support.annotation.NonNull;
import android.util.Log;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.PendudukRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.petani.PetaniRealm;

public class PendudukRepository implements PendudukContract.Repository<PendudukRealm> {
    @Inject
    Realm realm;

    private PendudukContract.Controller mController;

    public PendudukRepository(PendudukContract.Controller mController, @NonNull AppComponent appComponent) {
        this.mController = mController;
        appComponent.inject(this);
    }

    @Override
    public void addItem(PendudukRealm item) {
        Log.e("Error", "Masuk addItem success");
        realm.beginTransaction();
        realm.executeTransactionAsync(realmIns -> {
                realmIns.insertOrUpdate(item);
        }, () -> {
            mController.responseCRUD(true, "create");
        },(Throwable throwable)->{
            Log.e("eror",throwable.getMessage().toString());
            mController.responseCRUD(false, "create");
        });
        realm.commitTransaction();
    }

    @Override
    public void updateItem(int idItem, PendudukRealm item) {
        Log.e("Error", "Masuk updateItem success");
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                bgRealm.insertOrUpdate(item);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                // Transaction was a success.
                mController.responseCRUD(true, "update");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                // Transaction failed and was automatically canceled.
                mController.responseCRUD(false, "update");
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
    public void setItemDeleted(int idItem) {
        Log.e("Error", "Masuk setItemDeleted success");
        PendudukRealm deletedItem = realm.where(PendudukRealm.class).equalTo("idPenduduk", idItem).findFirst();

        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                deletedItem.setDeleted(true);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                // Transaction was a success.
                mController.responseCRUD(true, "delete");
                deletedItem.toString();
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
