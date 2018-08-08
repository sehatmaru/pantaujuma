package teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.petani.PetaniRealm;

/**
 * Created by Marthin on 7/10/2018.
 */

public class ResponsePetani {
    private boolean success;
    private String message;
    private List<PetaniRealm> data;

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

    public List<PetaniRealm> getData() {
        return data;
    }

    public void setData(List<PetaniRealm> data) {
        this.data = data;
    }
}
