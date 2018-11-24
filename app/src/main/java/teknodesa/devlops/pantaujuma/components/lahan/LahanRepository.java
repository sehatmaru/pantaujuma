package teknodesa.devlops.pantaujuma.components.lahan;

import android.util.Log;
import android.widget.Toast;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;
import teknodesa.devlops.pantaujuma.components.CRUActivity;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.LahanRealm;

public class LahanRepository implements LahanContract.Repository<LahanRealm> {
    @Inject
    Realm realm;

    private LahanContract.Controller mController;


    public LahanRepository(LahanContract.Controller mController, AppComponent appComponent) {
        this.mController = mController;
        appComponent.inject(this);
    }
    @Override
    public void addItem(LahanRealm item) {
        Log.e("Error", "Masuk addItem success");
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
    public void updateItem(String idItem, LahanRealm item) {
        Log.e("Error", "Masuk updateItem success");
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
        final RealmResults<LahanRealm> results = realm.where(LahanRealm.class).equalTo("hashId", idItem).findAll();

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
        Log.e("Error", "Masuk setItemDeleted success");
        LahanRealm deletedItem = realm.where(LahanRealm.class).equalTo("hashId", idItem).findFirst();
    }
}
