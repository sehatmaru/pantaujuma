package teknodesa.devlops.pantaujuma.components.poktan;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import io.realm.Realm;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.PengurusPoktanRealm;
import teknodesa.devlops.pantaujuma.utils.Pesan;

public class PengurusPoktanController implements PoktanContract.Controller<PengurusPoktanRealm> {
    @Inject
    Realm realm;

    PoktanContract.View mView;
    PoktanContract.Repository<PengurusPoktanRealm> mRepository;

    public PengurusPoktanController(PoktanContract.View mView, @NonNull AppComponent appComponent){
        appComponent.inject(this);
        this.mView = mView;
        this.mRepository = new PengurusPoktanRepository(this, appComponent);
    }

    @Override
    public void addItem(PengurusPoktanRealm item) {
        mRepository.addItem(item);
    }

    @Override
    public void updateItem(String idItem, PengurusPoktanRealm item) {
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
