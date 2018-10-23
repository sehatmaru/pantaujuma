package teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.harga.HargaRealm;

/**
 * Created by Marthin on 7/10/2018.
 */

public class ResponseHarga {
    private boolean success;
    private String message;
    private List<HargaRealm> data;

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

    public List<HargaRealm> getData() {
        return data;
    }

    public void setData(List<HargaRealm> data) {
        this.data = data;
    }
}
