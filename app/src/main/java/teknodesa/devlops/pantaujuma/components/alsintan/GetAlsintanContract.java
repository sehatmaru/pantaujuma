package teknodesa.devlops.pantaujuma.components.alsintan;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.alsintan.AlsintanRealm;

/**
 * Created by Marthin on 7/10/2018.
 */

public class GetAlsintanContract {
    public interface View {
        void getAllAlsintanSuccess(List<AlsintanRealm> allAlsintan);
        void getAllAlsintanFailed(String message);
        void saveDataSuccess(String message);
        void saveDataFailed(String message);
    }

    public interface Controller {
        void getAllAlsintan();
        void saveData(List<AlsintanRealm> allPen);
        void getAllAlsintanSuccess(List<AlsintanRealm> allAlsintan);
        void getAllAlsintanFailed(String message);
        void saveDataSuccess(String message, AlsintanRealm alsintanTempRealm);
        void saveDataFailed(String message);
        void updateDataRealm(AlsintanRealm alsintanTempRealm);
    }

    public interface Repository{
        void getAllAlsintan();
        void saveData(List<AlsintanRealm> allPen);
    }
}
