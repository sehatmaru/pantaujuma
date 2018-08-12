package teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.rktp.RKTPRealm;

public class ResponseRKTP {
    private boolean success;
    private String message;
    private List<RKTPRealm> data;

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

    public List<RKTPRealm> getData() {
        return data;
    }

    public void setData(List<RKTPRealm> data) {
        this.data = data;
    }
}
