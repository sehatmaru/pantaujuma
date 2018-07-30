package teknodesa.devlops.pantaujuma.components.penduduk;

import io.realm.RealmResults;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.penduduk.PendudukRealm;

public class PendudukSelectController implements PendudukSelectContract.Controller<PendudukRealm> {
    PendudukSelectContract.View mView;
    PendudukSelectContract.Repository<PendudukRealm> mRepository;

    public PendudukSelectController(PendudukSelectContract.View mView){
        this.mView = mView;
        this.mRepository = new PendudukSelectRepository(this);
    }

    @Override
    public RealmResults<PendudukRealm> getAllItem() {
        return mRepository.getAllItem();
    }

    @Override
    public PendudukRealm getSingleItemById(int idItem) {
        return mRepository.getSingleItemById(idItem);
    }

    @Override
    public PendudukRealm getSingleItemByNIK(String nik) {
        return mRepository.getSingleItemByNIK(nik);
    }
}
