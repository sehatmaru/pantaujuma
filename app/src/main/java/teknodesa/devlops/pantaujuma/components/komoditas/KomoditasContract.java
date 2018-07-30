package teknodesa.devlops.pantaujuma.components.komoditas;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.KomoditasRealm;

/**
 * Created by Marthin on 7/30/2018.
 */

public class KomoditasContract {
    public interface View {
        void getAllKomoditasSuccess(List<KomoditasRealm> allKomoditas);
        void getAllKomoditasFailed(String message);
    }

    public interface Controller {
        void getAllKomoditas();
        void getAllKomoditasSuccess(List<KomoditasRealm> allKomoditas);
        void getAllKomoditasFailed(String message);
    }

    public interface Repository{
        void getAllKomoditas();
    }
}
