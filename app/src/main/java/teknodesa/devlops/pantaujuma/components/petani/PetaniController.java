package teknodesa.devlops.pantaujuma.components.petani;

import io.realm.RealmResults;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.petani.PetaniRealm;
import teknodesa.devlops.pantaujuma.utils.Pesan;

public class PetaniController implements PetaniContract.Controller<PetaniRealm> {
    PetaniContract.View mView;
    PetaniContract.Repository<PetaniRealm> mRepository;

    public PetaniController(PetaniContract.View mView){
        this.mView = mView;
        this.mRepository = new PetaniRepository(this);
    }

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
    public void responseCRUD(boolean status, String type) {
        if (status == true) {
            switch (type) {
                case "create":
                    mView.showNotification(Pesan.DIALOG_INFO, Pesan.HEADER_NEW_ITEM, Pesan.DATA_SAVED);
                    break;
                case "update":
                    mView.showNotification(Pesan.DIALOG_INFO, Pesan.HEADER_NEW_ITEM, Pesan.DATA_UPDATED);
                    break;
                case "delete":
                    mView.showNotification(Pesan.DIALOG_INFO, Pesan.HEADER_NEW_ITEM, Pesan.DATA_DELETED);
                    break;
            }
        } else {
            switch (type) {
                case "create":
                    mView.showNotification(Pesan.DIALOG_INFO, Pesan.HEADER_NEW_ITEM, Pesan.DATA_FAIL_TO_BE_SAVED);
                    break;
                case "update":
                    mView.showNotification(Pesan.DIALOG_INFO, Pesan.HEADER_NEW_ITEM, Pesan.DATA_FAIL_TO_BE_UPDATED);
                    break;
                case "delete":
                    mView.showNotification(Pesan.DIALOG_INFO, Pesan.HEADER_NEW_ITEM, Pesan.DATA_FAIL_TO_BE_DELETED);
                    break;
            }
        }
    }
}
