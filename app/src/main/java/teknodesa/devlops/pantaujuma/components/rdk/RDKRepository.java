package teknodesa.devlops.pantaujuma.components.rdk;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;
import teknodesa.devlops.pantaujuma.components.CRUActivity;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.rdk.RDKRealm;

public class RDKRepository implements RDKContract.Repository<RDKRealm> {
    @Inject
    Realm realm;

    private RDKContract.Controller mController;

    public RDKRepository(RDKContract.Controller mController, @NonNull AppComponent appComponent) {
        this.mController = mController;
        appComponent.inject(this);
    }

    @Override
    public void addItem(RDKRealm item) {
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
    public void updateItem(String idItem, RDKRealm item) {
        Log.e("Error", "Masuk updateItem success");
        realm.executeTransactionAsync(bgRealm -> {
                bgRealm.insertOrUpdate(item);
        }, () -> {
            Log.e("rdkmodul","sukses");
            // Transaction was a success.
            mController.responseCRUD(true, "update");
        }, error -> {
            Log.e("rdkmodul","error");
            // Transaction failed and was automatically canceled.
            mController.responseCRUD(false, "update");
        });
    }

    @Override
    public void deleteItem(String idItem) {
    // obtain the results of a query
        final RealmResults<RDKRealm> results = realm.where(RDKRealm.class).equalTo("hashId", idItem).findAll();

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
        RDKRealm deletedItem = realm.where(RDKRealm.class).equalTo("hashId", idItem).findFirst();
    }
}