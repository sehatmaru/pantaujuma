package teknodesa.devlops.pantaujuma.components.lahan;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.pojos.BodyGetLahan;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.LahanRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.RiwayatLahanRealm;

/**
 * Created by Marthin on 7/31/2018.
 */

public class ListLahanKomoditasContract {
    public interface View {
        void getLahanKomoditasSuccess(List<LahanRealm> lahan);
        void getLahanKomoditasFailed(String message);
    }

    public interface Controller {
        void getLahanKomoditas(BodyGetLahan bodyGetLahan);
        void getLahanKomoditasSuccess(List<LahanRealm> lahan);
        void getLahanKomoditasFailed(String message);
    }

    public interface Repository{
        void getLahanKomoditas(BodyGetLahan bodyGetLahan);
    }
}
