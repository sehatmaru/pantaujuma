package teknodesa.devlops.pantaujuma.components.petani;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;
import teknodesa.devlops.pantaujuma.contracts.CRUDSelectContract;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.petani.PetaniRealm;

public class ListPetaniRepository implements CRUDSelectContract.Repository<PetaniRealm> {
    private ListPetaniController mController;

    @Inject
    Realm realm;

    public ListPetaniRepository(ListPetaniController mController, @NonNull AppComponent appComponent) {
        this.mController = mController;
        appComponent.inject(this);
    }

    @Override
    public void addItem(PetaniRealm item) {

    }

    @Override
    public void updateItem(int idItem, PetaniRealm item) {

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
    public RealmResults getSingleItemById(int idItem) {
        realm.beginTransaction();
        RealmResults<PetaniRealm> items = realm.where(PetaniRealm.class).equalTo("idPetani", idItem).findAll();
        realm.commitTransaction();
        if (items.isEmpty()) {
            return null;
        } else {
            return items;
        }
    }
}
