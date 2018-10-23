package teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.lahan.LahanRealm;

public class ResponseLahan {
    private boolean success;
    private String message;
    private List<LahanRealm> data;

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

    public List<LahanRealm> getData() {
        return data;
    }

    public void setData(List<LahanRealm> data) {
        this.data = data;
    }
}
