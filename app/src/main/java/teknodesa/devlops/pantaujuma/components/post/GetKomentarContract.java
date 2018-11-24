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
        void saveData(KomentarRealm komentar);
        void getAllKomentarSuccess(List<KomentarRealm> komentar);
        void getAllKomentarFailed(String message);
        void saveDataSuccess(String message);
        void saveDataFailed(String message);
    }

    public interface Repository{
        void getAllKomentar(String idPost);
        void saveData(KomentarRealm komentar);
    }
}
