package teknodesa.devlops.pantaujuma.dependencies.models.webservices.responses;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.alsintan.AlsintanRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.alsintan.PengecerPupukRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.alsintan.PengecerRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.alsintan.PupukRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.lahan.LahanRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.lahan.RiwayatLahanRealm;

/**
 * Created by Marthin on 8/2/2018.
 */

public class ResponseGetAlsintan {
    private boolean success;
    private String message;
    private List<AlsintanRealm> alat_pertanian;
    private List<PupukRealm> pupuk;
    private List<PengecerPupukRealm> pengecer_pupuk;
    private List<PengecerRealm> pengecer;

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

    public List<AlsintanRealm> getAlat_pertanian() {
        return alat_pertanian;
    }

    public void setAlat_pertanian(List<AlsintanRealm> alat_pertanian) {
        this.alat_pertanian = alat_pertanian;
    }

    public List<PupukRealm> getPupuk() {
        return pupuk;
    }

    public void setPupuk(List<PupukRealm> pupuk) {
        this.pupuk = pupuk;
    }

    public List<PengecerPupukRealm> getPengecer_pupuk() {
        return pengecer_pupuk;
    }

    public void setPengecer_pupuk(List<PengecerPupukRealm> pengecer_pupuk) {
        this.pengecer_pupuk = pengecer_pupuk;
    }

    public List<PengecerRealm> getPengecer() {
        return pengecer;
    }

    public void setPengecer(List<PengecerRealm> pengecer) {
        this.pengecer = pengecer;
    }
}
