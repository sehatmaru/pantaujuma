package teknodesa.devlops.pantaujuma.components.home;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.Promotion;

/**
 * Created by Marthin on 7/26/2018.
 */

public class HomeContract {
    public interface View {
        void resultPromotion(boolean status, List<Promotion> item);
    }

    public interface Controller {
        void getPromotion();
    }
}
