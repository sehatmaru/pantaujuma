package teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.PendudukRealm;

/**
 * Created by Marthin on 7/10/2018.
 */

public class ResponsePenduduk {
    private boolean success;
    private String message;
    private List<PendudukRealm> penduduk;

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

    public List<PendudukRealm> getPenduduk() {
        return penduduk;
    }

    public void setPenduduk(List<PendudukRealm> penduduk) {
        this.penduduk = penduduk;
    }
}
