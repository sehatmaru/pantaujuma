package teknodesa.devlops.pantaujuma.components.petani;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.petani.PetaniRealm;

/**
 * Created by Marthin on 7/10/2018.
 */

public class GetPetaniContract {
    public interface View {
        void getAllPetaniSuccess(List<PetaniRealm> allPetani);
        void getAllPetaniFailed(String message);
        void saveDataSuccess(String message);
        void saveDataFailed(String message);
    }

    public interface Controller {
        void getAllPetani();
        void saveData(List<PetaniRealm> allPen);
        void getAllPetaniSuccess(List<PetaniRealm> allPetani);
        void getAllPetaniFailed(String message);
        void saveDataSuccess(String message);
        void saveDataFailed(String message);
        void updateDataRealm(PetaniRealm petaniTempRealm);
    }

    public interface Repository{
        void getAllPetani(int idDesa);
        void saveData(List<PetaniRealm> allPen);
    }
}
