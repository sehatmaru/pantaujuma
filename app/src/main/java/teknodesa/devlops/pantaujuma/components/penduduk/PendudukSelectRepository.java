package teknodesa.devlops.pantaujuma.components.penduduk;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.penduduk.PendudukRealm;

public class PendudukSelectRepository implements PendudukSelectContract.Repository<PendudukRealm> {
    @Inject
    Realm realm;

    private PendudukSelectContract.Controller mController;

    public PendudukSelectRepository(PendudukSelectContract.Controller mController) {
        this.mController = mController;
    }

    @Override
    public RealmResults<PendudukRealm> getAllItem() {
        // Or alternatively do the same all at once (the "Fluent interface"):
        RealmResults<PendudukRealm> results = realm.where(PendudukRealm.class)
                .findAll();

        return results;
    }

    @Override
    public PendudukRealm getSingleItemById(int idItem) {
        realm.beginTransaction();
        PendudukRealm item = realm.where(PendudukRealm.class).equalTo("idPenduduk", idItem).findFirst();
        realm.commitTransaction();
        if (item == null) {
            return null;
        } else {
            return item;
        }
    }

    @Override
    public PendudukRealm getSingleItemByNIK(String nik) {
        realm.beginTransaction();
        PendudukRealm item = realm.where(PendudukRealm.class).equalTo("NIK", nik).findFirst();
        realm.commitTransaction();
        if (item == null) {
            return null;
        } else {
            return item;
        }
    }
}
