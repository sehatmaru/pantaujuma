package teknodesa.devlops.pantaujuma.components.petani;

import io.realm.RealmResults;
import teknodesa.devlops.pantaujuma.contracts.CRUDContract;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.petani.PetaniRealm;

public class ListPetaniController implements CRUDContract.Controller<PetaniRealm>{
    private CRUDContract.View<PetaniRealm> mView;
    private CRUDContract.Repository<PetaniRealm> mRepository;

    @Override
    public void addItem(PetaniRealm item) {
        mRepository.addItem(item);
    }

    @Override
    public void updateItem(String idItem, PetaniRealm item) {
        mRepository.updateItem(idItem, item);
    }

    @Override
    public void deleteItem(String idItem) {
        mRepository.deleteItem(idItem);
    }

    @Override
    public void setItemDeleted(String idItem) {
        mRepository.setItemDeleted(idItem);
    }

    @Override
    public void responseCRUD(boolean status, String type) {
        mView.showNotification("title", "header", "berhasil");
    }
}
