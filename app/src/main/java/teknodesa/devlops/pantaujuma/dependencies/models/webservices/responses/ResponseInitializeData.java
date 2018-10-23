package teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.Promotion;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.alsintan.PupukRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.pasar.PasarRealm;


/**
 * Created by Marthin on 2/23/2018.
 */

public class ResponseInitializeData {
    private boolean success;
    private String message;
    private List<Promotion> slider;
    private List<PupukRealm> pupuk;
    private List<PasarRealm> pasar;

    public List<Promotion> getSlider() {
        return slider;
    }

    public void setSlider(List<Promotion> slider) {
        this.slider = slider;
    }

    public List<PupukRealm> getPupuk() {
        return pupuk;
    }

    public void setPupuk(List<PupukRealm> pupuk) {
        this.pupuk = pupuk;
    }

    public List<PasarRealm> getPasar() {
        return pasar;
    }

    public void setPasar(List<PasarRealm> pasar) {
        this.pasar = pasar;
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
