package teknodesa.devlops.pantaujuma.components.alsintan;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.alsintan.AlsintanRealm;

/**
 * Created by Marthin on 7/10/2018.
 */

public class GetAlsintanContract {
    public interface View {
        void getAllAlsintanSuccess(List<AlsintanRealm> allAlsintan);
        void getAllAlsintanFailed(String message);
    }

    public interface Controller {
        void getAllAlsintan();
        void getAllAlsintanSuccess(List<AlsintanRealm> allAlsintan);
        void getAllAlsintanFailed(String message);
    }

    public interface Repository{
        void getAllAlsintan();
    }
}
