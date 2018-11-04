package teknodesa.devlops.pantaujuma.components.rdkk;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.rdkk.RDKKPupukSubsidiRealm;

public class GetRDKKContract {
    public interface View {
        void getAllRDKKSuccess(List<RDKKPupukSubsidiRealm> allRDKK);
        void getAllRDKKFailed(String message);

        void saveDataSuccess(String message);
        void saveDataFailed(String message);
    }

    public interface Controller {
        void getAllRDKK();
        void saveData(List<RDKKPupukSubsidiRealm> allPen);
        void getAllRDKKSuccess(List<RDKKPupukSubsidiRealm> allRDKK);
        void getAllRDKKFailed(String message);
        void saveDataSuccess(String message);
        void saveDataFailed(String message);
        void updateDataRealm(RDKKPupukSubsidiRealm rdkkTempRealm);
    }

    public interface Repository{
        void getAllRDKK(int idDesa);
        void saveData(List<RDKKPupukSubsidiRealm> allPen);
    }
}
