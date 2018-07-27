package teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses;

/**
 * Created by Marthin on 7/10/2018.
 */

public class ResponseSaveData {
    private boolean success;
    private String message;

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
}
