package teknodesa.devlops.pantaujuma.components.rktp;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.rktp.RKTPRealm;

public class GetRKTPContract {
    public interface View {
        void getAllRKTPSuccess(List<RKTPRealm> allRKTP);
        void getAllRKTPFailed(String message);

        void saveDataSuccess(String message);
        void saveDataFailed(String message);
    }

    public interface Controller {
        void getAllRKTP();
        void saveData(List<RKTPRealm> allRktp);
        void getAllRKTPSuccess(List<RKTPRealm> allRKTP);
        void getAllRKTPFailed(String message);
        void saveDataSuccess(String message);
        void saveDataFailed(String message);
        void updateDataRealm(RKTPRealm targetTemp);
    }

    public interface Repository{
        void getAllRKTP(int idDesa);
        void saveData(List<RKTPRealm> allRktp);
    }
}
