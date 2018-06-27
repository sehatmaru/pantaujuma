package teknodesa.devlops.pantaujuma.components.lahan;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.lahan.LahanRealm;
import teknodesa.devlops.pantaujuma.utils.Pesan;

public class LahanController implements LahanContract.Controller<LahanRealm> {
    LahanContract.View mView;
    LahanContract.Repository<LahanRealm> mRepository;

    public LahanController(LahanContract.View mView){
        this.mView = mView;
        this.mRepository = new LahanRepository(this);
    }

    @Override
    public void addItem(LahanRealm item) {
        mRepository.addItem(item);
    }

    @Override
    public void updateItem(int idItem, LahanRealm item) {
        mRepository.updateItem(idItem, item);
    }

    @Override
    public void deleteItem(int idItem) {
        mRepository.deleteItem(idItem);
    }

    @Override
    public void setItemDeleted(int idItem) {
        mRepository.setItemDeleted(idItem);
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
