package teknodesa.devlops.pantaujuma.components.penduduk;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;
import teknodesa.devlops.pantaujuma.MainApplication;
import teknodesa.devlops.pantaujuma.components.CRUActivity;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.pojos.Penduduk;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.PendudukRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.petani.PetaniRealm;

public class PendudukRepository implements PendudukContract.Repository<Penduduk> {
    @Inject
    Realm realm;

    private PendudukContract.Controller mController;

    public PendudukRepository(PendudukContract.Controller mController, @NonNull AppComponent appComponent) {
        this.mController = mController;
        appComponent.inject(this);
    }

    @Override
    public void addItem(Penduduk item) {
        Log.e("Error", "Masuk addItem success");
        realm.beginTransaction();
        realm.executeTransactionAsync(realmIns -> {
            Number currentIdNum = realmIns.where(PendudukRealm.class).max("idPenduduk");
            int nextId;
            if(currentIdNum == null) {
                nextId = 1;
            } else {
                nextId = currentIdNum.intValue() + 1;
            }
//            PendudukRealm newData = new PendudukRealm(item);
//            newData.setHashId(nextId);
//            realmIns.insertOrUpdate(newData);
        }, () -> {
            mController.responseCRUD(true, "create");
        },(Throwable throwable)->{
            Toast.makeText(CRUActivity.mContext, throwable.getMessage().toString(), Toast.LENGTH_SHORT).show();
            mController.responseCRUD(false, "create");
        });
        realm.commitTransaction();
    }

    @Override
    public void updateItem(int idItem, Penduduk item) {
        Log.e("Error", "Masuk updateItem success");
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
//                PendudukRealm updatedData = new PendudukRealm(item);
//                bgRealm.insertOrUpdate(updatedData);
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
