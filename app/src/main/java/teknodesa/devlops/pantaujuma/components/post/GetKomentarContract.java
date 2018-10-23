package teknodesa.devlops.pantaujuma.components.post;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.KomentarRealm;

public class GetKomentarContract {
    public interface View {
        void getAllKomentarSuccess(List<KomentarRealm> allKomentar);
        void getAllKomentarFailed(String message);

        void saveDataSuccess(String message);
        void saveDataFailed(String message);
    }

    public interface Controller {
        void getAllKomentar(String idPost);
        void saveData(List<KomentarRealm> allKomentar);
        void getAllKomentarSuccess(List<KomentarRealm> allKomentar);
        void getAllKomentarFailed(String message);
        void saveDataSuccess(String message, KomentarRealm targetTemp);
        void saveDataFailed(String message);
        void updateDataRealm(KomentarRealm targetTemp);
    }

    public interface Repository{
        void getAllKomentar(String idPost);
        void saveData(List<KomentarRealm> allKomentar);
    }
}
