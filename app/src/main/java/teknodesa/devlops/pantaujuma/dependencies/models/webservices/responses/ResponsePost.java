package teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.PostRealm;

public class ResponsePost {
    private boolean success;
    private String message;
    private List<PostRealm> data;

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

    public List<PostRealm> getData() {
        return data;
    }

    public void setData(List<PostRealm> data) {
        this.data = data;
    }
}
