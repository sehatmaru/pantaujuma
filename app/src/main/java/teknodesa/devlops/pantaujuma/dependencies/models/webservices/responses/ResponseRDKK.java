package teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.rdkk.RDKKPupukSubsidiRealm;

public class ResponseRDKK {
    private boolean success;
    private String message;
    private List<RDKKPupukSubsidiRealm> data;

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

    public List<RDKKPupukSubsidiRealm> getData() {
        return data;
    }

    public void setData(List<RDKKPupukSubsidiRealm> data) {
        this.data = data;
    }
}
