package teknodesa.devlops.pantaujuma.components.penduduk;

import teknodesa.devlops.pantaujuma.contracts.CRUDContract;
import teknodesa.devlops.pantaujuma.contracts.SelectContract;

public class PendudukSelectContract {
    interface View extends SelectContract.View{

    }

    interface Controller<U> extends SelectContract.Controller<U>{
        U getSingleItemByNIK(String nik);
    }

    interface Repository<U> extends SelectContract.Repository<U>{
        U getSingleItemByNIK(String nik);
    }
}
