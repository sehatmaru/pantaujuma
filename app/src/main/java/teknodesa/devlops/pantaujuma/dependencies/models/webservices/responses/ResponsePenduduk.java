package teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.penduduk.PendudukRealm;

/**
 * Created by Marthin on 7/10/2018.
 */

public class ResponsePenduduk {
    private boolean success;
    private String message;
    private List<PendudukRealm> data;

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

    public List<PendudukRealm> getData() {
        return data;
    }

    public void setData(List<PendudukRealm> data) {
        this.data = data;
    }
}
