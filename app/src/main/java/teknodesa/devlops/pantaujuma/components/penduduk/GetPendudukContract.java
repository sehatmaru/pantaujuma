package teknodesa.devlops.pantaujuma.components.penduduk;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.PendudukRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.penduduk.PendudukTempRealm;

/**
 * Created by Marthin on 7/10/2018.
 */

public class GetPendudukContract {
    public interface View {
        void getAllPendudukSuccess(List<PendudukRealm> allPenduduk);
        void getAllPendudukFailed(String message);

        void saveDataSuccess(String message);
        void saveDataFailed(String message);
    }

    public interface Controller {
        void getAllPenduduk();
        void saveData(List<PendudukTempRealm> allPen);
        void getAllPendudukSuccess(List<PendudukRealm> allPenduduk);
        void getAllPendudukFailed(String message);
        void saveDataSuccess(String message, PendudukTempRealm pendudukTempRealm);
        void saveDataFailed(String message);
        void deleteFromRealm(PendudukTempRealm pendudukTempRealm);
    }

    public interface Repository{
        void getAllPenduduk(int idDesa);
        void saveData(List<PendudukTempRealm> allPen);
    }
}
