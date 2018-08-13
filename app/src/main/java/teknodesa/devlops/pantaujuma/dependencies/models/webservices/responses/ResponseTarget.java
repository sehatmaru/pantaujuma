package teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.petugas.TargetPetugas;

public class ResponseTarget {
    private boolean success;
    private String message;
    private List<TargetPetugas> data;

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

    public List<TargetPetugas> getData() {
        return data;
    }

    public void setData(List<TargetPetugas> data) {
        this.data = data;
    }
}
