package teknodesa.devlops.pantaujuma.components.penduduk;

import teknodesa.devlops.pantaujuma.contracts.CRUDSelectContract;

public class PendudukContract {
    interface View extends CRUDSelectContract.View{

    }

    interface Controller<U> extends CRUDSelectContract.Controller<U>{

    }

    interface Repository<U> extends CRUDSelectContract.Repository<U>{

    }
}
