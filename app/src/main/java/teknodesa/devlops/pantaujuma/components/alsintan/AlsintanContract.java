package teknodesa.devlops.pantaujuma.components.alsintan;

import teknodesa.devlops.pantaujuma.contracts.CRUDContract;

public class AlsintanContract {
    interface View extends CRUDContract.View{

    }

    interface ViewController<U> extends CRUDContract.ViewController<U>{}

    interface Controller<U> extends CRUDContract.Controller<U>{
    }

    interface Repository<U> extends CRUDContract.Repository<U>{

    }
}
