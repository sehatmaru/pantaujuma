package teknodesa.devlops.pantaujuma.components.petani;

import io.realm.RealmResults;
import teknodesa.devlops.pantaujuma.contracts.CRUDSelectContract;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.petani.PetaniRealm;

public class ListPetaniController implements CRUDSelectContract.Controller<PetaniRealm>{
    private CRUDSelectContract.View<PetaniRealm> mView;
    private CRUDSelectContract.Repository mRepository;

    @Override
    public void addItem(PetaniRealm item) {
        mRepository.addItem(item);
    }

    @Override
    public void updateItem(int idItem, PetaniRealm item) {
        mRepository.updateItem(idItem, item);
    }

    @Override
    public void deleteItem(int idItem) {
        mRepository.deleteItem(idItem);
    }

    @Override
    public RealmResults<PetaniRealm> getAllItem() {
        return mRepository.getAllItem();
    }

    @Override
    public RealmResults getSingleItemById(int idItem) {
        return mRepository.getSingleItemById(idItem);
    }

    @Override
    public void responseCRUD(boolean status, String type) {
        mView.showNotification("title", "header", "berhasil");
    }
}
