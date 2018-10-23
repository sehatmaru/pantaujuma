package teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.alsintan.PupukRealm;

/**
 * Created by Sehat MT Samosir on 8/20/2018.
 */

public class ResponseGetPupuk {
    private boolean success;
    private String message;
    private List<PupukRealm> data;

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

    public List<PupukRealm> getData() {
        return data;
    }

    public void setData(List<PupukRealm> data) {
        this.data = data;
    }
}
