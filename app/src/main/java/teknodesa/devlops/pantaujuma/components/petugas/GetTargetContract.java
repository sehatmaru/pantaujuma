package teknodesa.devlops.pantaujuma.components.petugas;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.petugas.TargetPetugas;

public class GetTargetContract {
    public interface View {
        void getAllTargetSuccess(List<TargetPetugas> allTarget);
        void getAllTargetFailed(String message);

        void saveDataSuccess(String message);
        void saveDataFailed(String message);
    }

    public interface Controller {
        void getAllTarget();
        void saveData(List<TargetPetugas> allTar);
        void getAllTargetSuccess(List<TargetPetugas> allTarget);
        void getAllTargetFailed(String message);
        void saveDataSuccess(String message);
        void saveDataFailed(String message);
        void updateDataRealm(TargetPetugas targetTemp);
    }

    public interface Repository{
        void getAllTarget(int idDesa);
        void saveData(List<TargetPetugas> allTar);
    }
}
