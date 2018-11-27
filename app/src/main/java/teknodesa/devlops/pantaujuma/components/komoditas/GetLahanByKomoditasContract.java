package teknodesa.devlops.pantaujuma.components.komoditas;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.pojos.BodyGetLahan;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.LahanRealm;

/**
 * Created by Marthin on 7/10/2018.
 */

public class GetLahanByKomoditasContract {
    public interface View {
        void getAllLahanByKomoditasSuccess(List<LahanRealm> lahan);
        void getAllLahanByKomoditasFailed(String message);
    }

    public interface Controller {
        void getAllLahanByKomoditas(BodyGetLahan getLahan);
        void getAllLahanByKomoditasSuccess(List<LahanRealm> lahan);
        void getAllLahanByKomoditasFailed(String message);
    }

    public interface Repository {
        void getAllLahanByKomoditas(BodyGetLahan getLahan);
    }
}
