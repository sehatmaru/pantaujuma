package teknodesa.devlops.pantaujuma.components.rdk;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.rdk.RDKRealm;

/**
 * Created by Marthin on 7/10/2018.
 */

public class GetRDKContract {
    public interface View {
        void getAllRDKSuccess(List<RDKRealm> allRDK);
        void getAllRDKFailed(String message);
        void saveDataSuccess(String message);
        void saveDataFailed(String message);
    }

    public interface Controller {
        void getAllRDK();
        void saveData(List<RDKRealm> allPen);
        void getAllRDKSuccess(List<RDKRealm> allRDK);
        void getAllRDKFailed(String message);
        void saveDataSuccess(String message, RDKRealm rdkTempRealm);
        void saveDataFailed(String message);
        void updateDataRealm(RDKRealm rdkTempRealm);
    }

    public interface Repository{
        void getAllRDK(int idDesa);
        void saveData(List<RDKRealm> allPen);
    }
}
