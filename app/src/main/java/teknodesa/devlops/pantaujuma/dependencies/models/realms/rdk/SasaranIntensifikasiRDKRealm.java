package teknodesa.devlops.pantaujuma.dependencies.models.realms.rdk;

import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.KomoditasRealm;

public class SasaranIntensifikasiRDKRealm extends RealmObject {
    @PrimaryKey
    private int idSasaranIntensifikasiRDK;

    @LinkingObjects("intensifikasi")
    private final RealmResults<RDKRealm> rdk = null;

    private KomoditasRealm komoditas;
    private String target;
    private String targetHasilPerHa;

    public SasaranIntensifikasiRDKRealm() {
    }

    public SasaranIntensifikasiRDKRealm(int idSasaranIntensifikasiRDK, KomoditasRealm komoditas, String target, String targetHasilPerHa) {
        this.idSasaranIntensifikasiRDK = idSasaranIntensifikasiRDK;
        this.komoditas = komoditas;
        this.target = target;
        this.targetHasilPerHa = targetHasilPerHa;
    }

    public int getIdSasaranIntensifikasiRDK() {
        return idSasaranIntensifikasiRDK;
    }

    public void setIdSasaranIntensifikasiRDK(int idSasaranIntensifikasiRDK) {
        this.idSasaranIntensifikasiRDK = idSasaranIntensifikasiRDK;
    }

    public RealmResults<RDKRealm> getRdk() {
        return rdk;
    }

    public KomoditasRealm getKomoditas() {
        return komoditas;
    }

    public void setKomoditas(KomoditasRealm komoditas) {
        this.komoditas = komoditas;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getTargetHasilPerHa() {
        return targetHasilPerHa;
    }

    public void setTargetHasilPerHa(String targetHasilPerHa) {
        this.targetHasilPerHa = targetHasilPerHa;
    }
}
