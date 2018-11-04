package teknodesa.devlops.pantaujuma.components.poktan;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.AnggotaPoktanRealm;

/**
 * Created by Marthin on 7/10/2018.
 */

public class GetAnggotaPoktanContract {
    public interface View {
        void getAllAnggotaPoktanSuccess(List<AnggotaPoktanRealm> allAnggotaPoktan);
        void getAllAnggotaPoktanFailed(String message);
        void saveDataSuccess(String message);
        void saveDataFailed(String message);
    }

    public interface Controller {
        void getAllAnggotaPoktan();
        void saveData(List<AnggotaPoktanRealm> allPen);
        void getAllAnggotaPoktanSuccess(List<AnggotaPoktanRealm> allAnggotaPoktan);
        void getAllAnggotaPoktanFailed(String message);
        void saveDataSuccess(String message);
        void saveDataFailed(String message);
        void updateDataRealm(AnggotaPoktanRealm anggotaPoktanTempRealm);
    }

    public interface Repository{
        void getAllAnggotaPoktan(int idDesa);
        void saveData(List<AnggotaPoktanRealm> allPen);
    }
}
