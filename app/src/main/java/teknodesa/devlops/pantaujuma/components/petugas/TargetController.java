package teknodesa.devlops.pantaujuma.components.petugas;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import io.realm.Realm;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.petugas.TargetPetugas;
import teknodesa.devlops.pantaujuma.utils.Pesan;

public class TargetController implements TargetContract.Controller<TargetPetugas> {
    @Inject
    Realm realm;

    TargetContract.View mView;
    TargetContract.Repository<TargetPetugas> mRepository;

    public TargetController(TargetContract.View mView, @NonNull AppComponent appComponent){
        appComponent.inject(this);
        this.mView = mView;
        this.mRepository = new TargetRepository(this, appComponent);
    }

    @Override
    public void addItem(TargetPetugas item) {
        mRepository.addItem(item);
    }

    @Override
    public void updateItem(String idItem, TargetPetugas item) {
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
