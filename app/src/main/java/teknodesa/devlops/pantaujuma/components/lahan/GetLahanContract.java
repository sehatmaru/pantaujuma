package teknodesa.devlops.pantaujuma.components.lahan;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.LahanRealm;

/**
 * Created by Marthin on 7/10/2018.
 */

public class GetLahanContract {
    public interface View {
        void getAllLahanSuccess(List<LahanRealm> allLahan);
        void getAllLahanFailed(String message);

        void saveDataSuccess(String message);
        void saveDataFailed(String message);
    }

    public interface Controller {
        void getAllLahan();
        void saveData(List<LahanRealm> allPen);
        void getAllLahanSuccess(List<LahanRealm> allLahan);
        void getAllLahanFailed(String message);
        void saveDataSuccess(String message, LahanRealm lahanTempRealm);
        void saveDataFailed(String message);
        void updateDataRealm(LahanRealm lahanTempRealm);
    }

    public interface Repository{
        void getAllLahan(int idDesa);
        void saveData(List<LahanRealm> allPen);
    }
}
