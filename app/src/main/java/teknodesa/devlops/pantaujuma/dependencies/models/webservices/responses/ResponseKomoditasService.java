package teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.KomoditasRealm;

/**
 * Created by Marthin on 7/30/2018.
 */

public class ResponseKomoditasService {

    private boolean success;
    private String message;
    private List<KomoditasRealm> data;

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

    public List<KomoditasRealm> getData() {
        return data;
    }

    public void setData(List<KomoditasRealm> data) {
        this.data = data;
    }
}
