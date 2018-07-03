package teknodesa.devlops.pantaujuma.components.lahan;

import teknodesa.devlops.pantaujuma.contracts.CRUDContract;

public class LahanContract {
    public interface View extends CRUDContract.View{

    }

    public interface ViewController<U> extends CRUDContract.ViewController<U>{}

    public interface Controller<U> extends CRUDContract.Controller<U>{
    }

    public interface Repository<U> extends CRUDContract.Repository<U>{

    }
}
