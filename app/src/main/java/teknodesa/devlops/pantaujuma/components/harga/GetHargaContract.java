package teknodesa.devlops.pantaujuma.components.harga;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.harga.HargaRealm;

public class GetHargaContract {
    public interface View {
        void getAllHargaSuccess(List<HargaRealm> allHarga);
        void getAllHargaFailed(String message);

        void saveDataSuccess(String message);
        void saveDataFailed(String message);
    }

    public interface Controller {
        void getAllHarga();
        void saveData(List<HargaRealm> allTar);
        void getAllHargaSuccess(List<HargaRealm> allHarga);
        void getAllHargaFailed(String message);
        void saveDataSuccess(String message);
        void saveDataFailed(String message);
        void updateDataRealm(HargaRealm hargaTemp);
    }

    public interface Repository{
        void getAllHarga();
        void saveData(List<HargaRealm> allTar);
    }
}
