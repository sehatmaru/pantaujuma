package teknodesa.devlops.pantaujuma.components.post;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;
import teknodesa.devlops.pantaujuma.components.CRUActivity;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.KomentarRealm;

public class KomentarRepository implements KomentarContract.Repository<KomentarRealm> {
    @Inject
    Realm realm;

    private KomentarContract.Controller mController;
    public KomentarRepository(AppComponent appComponent) {
        appComponent.inject(this);
    }

    public void instanceClass(KomentarContract.Controller mController){
        this.mController = mController;
    }
    @Override
    public void addItem(KomentarRealm item) {
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
    public void updateItem(String idItem, KomentarRealm item) {
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
    public void deleteItem(String idItem) {
        // obtain the results of a query
        final RealmResults<KomentarRealm> results = realm.where(KomentarRealm.class).equalTo("hashId", idItem).findAll();

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

    }
}
