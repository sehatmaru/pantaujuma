package teknodesa.devlops.pantaujuma.components.poktan;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.PengurusPoktanRealm;

/**
 * Created by Marthin on 7/10/2018.
 */

public class GetPengurusPoktanContract {
    public interface View {
        void getAllPengurusPoktanSuccess(List<PengurusPoktanRealm> allPengurusPoktan);
        void getAllPengurusPoktanFailed(String message);
        void saveDataSuccess(String message);
        void saveDataFailed(String message);
    }

    public interface Controller {
        void getAllPengurusPoktan();
        void saveData(List<PengurusPoktanRealm> allPen);
        void getAllPengurusPoktanSuccess(List<PengurusPoktanRealm> allPengurusPoktan);
        void getAllPengurusPoktanFailed(String message);
        void saveDataSuccess(String message);
        void saveDataFailed(String message);
        void updateDataRealm(PengurusPoktanRealm pengurusPoktanTempRealm);
    }

    public interface Repository{
        void getAllPengurusPoktan(int idDesa);
        void saveData(List<PengurusPoktanRealm> allPen);
    }
}
