package teknodesa.devlops.pantaujuma.components.penduduk;

import teknodesa.devlops.pantaujuma.contracts.CRUDContract;

public class PendudukContract {
    interface View extends CRUDContract.View{

    }

    interface ViewController<U> extends CRUDContract.ViewController<U>{}

    interface Controller<U> extends CRUDContract.Controller<U>{
    }

    interface Repository<U> extends CRUDContract.Repository<U>{

    }
}
