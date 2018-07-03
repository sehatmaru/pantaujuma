package teknodesa.devlops.pantaujuma.components.penduduk;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.PendudukRealm;
import teknodesa.devlops.pantaujuma.utils.Pesan;

public class PendudukController implements PendudukContract.Controller<PendudukRealm> {
    PendudukContract.View mView;
    PendudukContract.Repository<PendudukRealm> mRepository;

    public PendudukController(PendudukContract.View mView){
        this.mView = mView;
        this.mRepository = new PendudukRepository(this);
    }

    @Override
    public void addItem(PendudukRealm item) {
        mRepository.addItem(item);
    }

    @Override
    public void updateItem(int idItem, PendudukRealm item) {
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
