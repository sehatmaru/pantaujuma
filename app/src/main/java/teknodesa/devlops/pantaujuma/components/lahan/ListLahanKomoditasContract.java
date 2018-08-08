package teknodesa.devlops.pantaujuma.components.lahan;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.pojos.lahan.BodyGetLahan;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.lahan.RiwayatLahanRealm;

/**
 * Created by Marthin on 7/31/2018.
 */

public class ListLahanKomoditasContract {
    public interface View {
        void getLahanKomoditasSuccess(List<RiwayatLahanRealm> riwayatLahanRealms);
        void getLahanKomoditasFailed(String message);
    }

    public interface Controller {
        void getLahanKomoditas(BodyGetLahan bodyGetLahan);
        void getLahanKomoditasSuccess(List<RiwayatLahanRealm> riwayatLahanRealms);
        void getLahanKomoditasFailed(String message);
    }

    public interface Repository{
        void getLahanKomoditas(BodyGetLahan bodyGetLahan);
    }
}
