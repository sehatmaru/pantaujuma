package teknodesa.devlops.pantaujuma.components.harga;

import teknodesa.devlops.pantaujuma.contracts.CRUDContract;

public class HargaContract {
    public interface View extends CRUDContract.View{

    }

    public interface ViewController<U> extends CRUDContract.ViewController<U>{}

    public interface Controller<U> extends CRUDContract.Controller<U>{
    }

    public interface Repository<U> extends CRUDContract.Repository<U>{

    }
}
