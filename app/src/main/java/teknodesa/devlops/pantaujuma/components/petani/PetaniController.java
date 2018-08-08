package teknodesa.devlops.pantaujuma.components.petani;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import io.realm.Realm;
import teknodesa.devlops.pantaujuma.dependencies.component.AppComponent;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.petani.PetaniRealm;
import teknodesa.devlops.pantaujuma.utils.Pesan;

public class PetaniController implements PetaniContract.Controller<PetaniRealm> {
    @Inject
    Realm realm;

    PetaniContract.View mView;
    PetaniContract.Repository<PetaniRealm> mRepository;

    public PetaniController(PetaniContract.View mView, @NonNull AppComponent appComponent){
        appComponent.inject(this);
        this.mView = mView;
        this.mRepository = new PetaniRepository(this, appComponent);
    }

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
