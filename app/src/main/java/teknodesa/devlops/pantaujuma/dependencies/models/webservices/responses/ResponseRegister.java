package teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses;

/**
 * Created by Marthin on 2/23/2018.
 */

public class ResponseRegister {
    private boolean success;
    private String message;

    public ResponseRegister() {
    }

    public ResponseRegister(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

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
