package teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.lahan.LahanRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.lahan.RiwayatLahanRealm;

/**
 * Created by Marthin on 8/2/2018.
 */

public class ResponseGetLahanKomoditas {
    private boolean success;
    private String message;
    private List<RiwayatLahanRealm> data;
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

    public List<RiwayatLahanRealm> getData() {
        return data;
    }

    public void setData(List<RiwayatLahanRealm> data) {
        this.data = data;
    }

    public List<LahanRealm> getLahan() {
        return lahan;
    }

    public void setLahan(List<LahanRealm> lahan) {
        this.lahan = lahan;
    }
}
