package teknodesa.devlops.pantaujuma.dependencies.models.realms.rktp;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.petugas.PetugasRealm;

public class RKTPRealm extends RealmObject {
    @PrimaryKey
    private int idRKTP;
    private PetugasRealm petugas;
    private String tahun;
    public RealmList<DetailRKTPRealm> detailRKTP;

    public RKTPRealm() {
    }

    public RKTPRealm(int idRKTP, PetugasRealm petugas, String tahun, RealmList<DetailRKTPRealm> detailRKTP) {
        this.idRKTP = idRKTP;
        this.petugas = petugas;
        this.tahun = tahun;
        this.detailRKTP = detailRKTP;
    }

    public int getIdRKTP() {
        return idRKTP;
    }

    public void setIdRKTP(int idRKTP) {
        this.idRKTP = idRKTP;
    }

    public PetugasRealm getPetugas() {
        return petugas;
    }

    public void setPetugas(PetugasRealm petugas) {
        this.petugas = petugas;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public RealmList<DetailRKTPRealm> getDetailRKTP() {
        return detailRKTP;
    }

    public void setDetailRKTP(RealmList<DetailRKTPRealm> detailRKTP) {
        this.detailRKTP = detailRKTP;
    }
}
