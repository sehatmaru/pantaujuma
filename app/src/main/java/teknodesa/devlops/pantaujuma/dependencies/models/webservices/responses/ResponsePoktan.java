package teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.PoktanRealm;

/**
 * Created by Marthin on 7/10/2018.
 */

public class ResponsePoktan {
    private boolean success;
    private String message;
    private List<PoktanRealm> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<PoktanRealm> getData() {
        return data;
    }

    public void setData(List<PoktanRealm> data) {
        this.data = data;
    }
}
