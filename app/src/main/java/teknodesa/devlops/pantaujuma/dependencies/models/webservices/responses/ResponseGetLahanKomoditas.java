package teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.LahanRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.RiwayatLahanRealm;

/**
 * Created by Marthin on 8/2/2018.
 */

public class ResponseGetLahanKomoditas {
    private boolean success;
    private String message;
    private List<LahanRealm> lahan;

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

    public List<LahanRealm> getLahan() {
        return lahan;
    }

    public void setLahan(List<LahanRealm> lahan) {
        this.lahan = lahan;
    }
}
