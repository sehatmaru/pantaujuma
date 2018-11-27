package teknodesa.devlops.pantaujuma.components.petugas;

import android.support.annotation.NonNull;
import android.widget.Toast;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;
import teknodesa.devlops.pantaujuma.components.CRUActivity;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.petugas.TargetPetugas;

public class TargetRepository implements TargetContract.Repository<TargetPetugas> {
    @Inject
    Realm realm;

    private TargetContract.Controller mController;

    public TargetRepository(TargetContract.Controller mController, @NonNull AppComponent appComponent) {
        this.mController = mController;
        appComponent.inject(this);
    }

    @Override
    public void addItem(TargetPetugas item) {
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
    public void updateItem(String idItem, TargetPetugas item) {
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
        final RealmResults<TargetPetugas> results = realm.where(TargetPetugas.class).equalTo("hashId", idItem).findAll();

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
        TargetPetugas deletedItem = realm.where(TargetPetugas.class).equalTo("hashId", idItem).findFirst();
    }
}
