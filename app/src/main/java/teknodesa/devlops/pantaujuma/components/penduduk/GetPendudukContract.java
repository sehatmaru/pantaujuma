package teknodesa.devlops.pantaujuma.components.penduduk;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.penduduk.PendudukRealm;

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
        void saveData(List<PendudukRealm> allPen);
        void getAllPendudukSuccess(List<PendudukRealm> allPenduduk);
        void getAllPendudukFailed(String message);
        void saveDataSuccess(String message, PendudukRealm pendudukTempRealm);
        void saveDataFailed(String message);
        void updateDataRealm(PendudukRealm pendudukTempRealm);
    }

    public interface Repository{
        void getAllPenduduk(int idDesa);
        void saveData(List<PendudukRealm> allPen);
    }
}
