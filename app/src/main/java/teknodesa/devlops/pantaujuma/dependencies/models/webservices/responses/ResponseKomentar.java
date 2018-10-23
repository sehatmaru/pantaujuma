package teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.KomentarRealm;

public class ResponseKomentar {
    private boolean success;
    private String message;
    private List<KomentarRealm> data;

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

    public List<KomentarRealm> getData() {
        return data;
    }

    public void setData(List<KomentarRealm> data) {
        this.data = data;
    }
}
