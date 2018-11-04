package teknodesa.devlops.pantaujuma.components.poktan;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.PoktanRealm;

/**
 * Created by Marthin on 7/10/2018.
 */

public class GetPoktanContract {
    public interface View {
        void getAllPoktanSuccess(List<PoktanRealm> allPoktan);
        void getAllPoktanFailed(String message);
        void saveDataSuccess(String message);
        void saveDataFailed(String message);
    }

    public interface Controller {
        void getAllPoktan();
        void saveData(List<PoktanRealm> allPen);
        void getAllPoktanSuccess(List<PoktanRealm> allPoktan);
        void getAllPoktanFailed(String message);
        void saveDataSuccess(String message);
        void saveDataFailed(String message);
        void updateDataRealm(PoktanRealm poktanTempRealm);
    }

    public interface Repository{
        void getAllPoktan(int idDesa);
        void saveData(List<PoktanRealm> allPen);
    }
}
