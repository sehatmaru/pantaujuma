package teknodesa.devlops.pantaujuma.components.petani;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;
import teknodesa.devlops.pantaujuma.contracts.CRUDContract;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.petani.PetaniRealm;

public class ListPetaniRepository implements CRUDContract.Repository<PetaniRealm> {
    private ListPetaniController mController;

    @Inject
    Realm realm;

    public ListPetaniRepository(ListPetaniController mController, @NonNull AppComponent appComponent) {
        this.mController = mController;
        appComponent.inject(this);
    }

    @Override
    public void addItem(PetaniRealm item) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                PetaniRealm newItem = realm.copyToRealm(item);
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
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                PetaniRealm updatedItem = realm.where(PetaniRealm.class).equalTo("idPetani", idItem).findFirst();
                updatedItem.setBiodata(item.getBiodata());
                updatedItem.setFoto(item.getFoto());
                updatedItem.setDeskripsi(item.getDeskripsi());
                updatedItem.setStatus(item.getStatus());
            }
        });
    }

    @Override
    public void deleteItem(int idItem) {
        // obtain the results of a query
        final RealmResults<PetaniRealm> results = realm.where(PetaniRealm.class).equalTo("idPetani", idItem).findAll();

        // All changes to data must happen in a transaction
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                // remove single match
                if (results.deleteFirstFromRealm()) {
                    mController.responseCRUD(true, "create");
                } else {
                    mController.responseCRUD(false, "create");
                }

            }
        });
    }

    @Override
    public RealmResults<PetaniRealm> getAllItem() {
        realm.beginTransaction();
        RealmResults<PetaniRealm> items = realm.where(PetaniRealm.class).findAll();
        realm.commitTransaction();
        if (items.isEmpty()) {
            return null;
        } else {
            return items;
        }
    }

    @Override
    public PetaniRealm getSingleItemById(int idItem) {
        realm.beginTransaction();
        PetaniRealm item = realm.where(PetaniRealm.class).equalTo("idPetani", idItem).findFirst();
        realm.commitTransaction();
        if (item == null) {
            return null;
        } else {
            return item;
        }
    }
}
