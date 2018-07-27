package teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.Promotion;


/**
 * Created by Marthin on 2/23/2018.
 */

public class ResponsePromo {
    private boolean success;
    private String message;
    private List<Promotion> data;

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

    public List<Promotion> getData() {
        return data;
    }

    public void setData(List<Promotion> data) {
        this.data = data;
    }
}
