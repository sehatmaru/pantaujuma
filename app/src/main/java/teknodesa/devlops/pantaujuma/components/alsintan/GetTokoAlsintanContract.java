package teknodesa.devlops.pantaujuma.components.alsintan;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.alsintan.TokoAlsintanRealm;

/**
 * Created by Marthin on 7/10/2018.
 */

public class GetTokoAlsintanContract {
    public interface View {
        void getAllTokoAlsintanSuccess(List<TokoAlsintanRealm> allTokoAlsintan);
        void getAllTokoAlsintanFailed(String message);
    }

    public interface Controller {
        void getAllTokoAlsintan();
        void getAllTokoAlsintanSuccess(List<TokoAlsintanRealm> allTokoAlsintan);
        void getAllTokoAlsintanFailed(String message);
    }

    public interface Repository{
        void getAllTokoAlsintan();
    }
}
