package teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.alsintan.AlsintanRealm;

/**
 * Created by Marthin on 8/2/2018.
 */

public class ResponseGetAlsintan {
    private boolean success;
    private String message;
    private List<AlsintanRealm> data;

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

    public List<AlsintanRealm> getData() {
        return data;
    }

    public void setData(List<AlsintanRealm> data) {
        this.data = data;
    }
}
