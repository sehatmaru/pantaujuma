package teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PengurusPoktanRealm extends RealmObject {

    @PrimaryKey
    private String hashId;

    private String poktanPengurus = null;
    private String petaniPengurus = null;
    private String jabatan = "-";
    private String periode = "-";
    private int statusPengurus;

    private int idDesa = 0;
    private int isSync = 0;

    public PengurusPoktanRealm() {
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getPoktanPengurus() {
        return poktanPengurus;
    }

    public void setPoktanPengurus(String poktanPengurus) {
        this.poktanPengurus = poktanPengurus;
    }

    public String getPetaniPengurus() {
        return petaniPengurus;
    }

    public void setPetaniPengurus(String petaniPengurus) {
        this.petaniPengurus = petaniPengurus;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public int getStatusPengurus() {
        return statusPengurus;
    }

    public void setStatusPengurus(int statusPengurus) {
        this.statusPengurus = statusPengurus;
    }

    public int getIdDesa() {
        return idDesa;
    }

    public void setIdDesa(int idDesa) {
        this.idDesa = idDesa;
    }

    public int getIsSync() {
        return isSync;
    }

    public void setIsSync(int isSync) {
        this.isSync = isSync;
    }

    @Override
    public String toString() {
        return "PengurusPoktanRealm{" +
                "hashId='" + hashId + '\'' +
                ", poktanPengurus='" + poktanPengurus + '\'' +
                ", petaniPengurus='" + petaniPengurus + '\'' +
                ", jabatan='" + jabatan + '\'' +
                ", periode='" + periode + '\'' +
                ", statusPengurus=" + statusPengurus +
                ", idDesa=" + idDesa +
                ", isSync=" + isSync +
                '}';
    }
}
