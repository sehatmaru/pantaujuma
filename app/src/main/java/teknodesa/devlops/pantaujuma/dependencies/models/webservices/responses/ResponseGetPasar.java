package teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.pasar.PasarRealm;

/**
 * Created by Sehat MT Samosir on 8/20/2018.
 */

public class ResponseGetPasar {
    private boolean success;
    private String message;
    private List<PasarRealm> data;

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

    public List<PasarRealm> getData() {
        return data;
    }

    public void setData(List<PasarRealm> data) {
        this.data = data;
    }
}
