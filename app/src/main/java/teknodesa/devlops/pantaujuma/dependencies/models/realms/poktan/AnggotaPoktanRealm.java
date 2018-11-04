package teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class AnggotaPoktanRealm extends RealmObject {

    @PrimaryKey
    private String hashId;

    private String poktanAnggota = null;
    private String petaniAnggota = null;
    private String tanggalMasuk = "-";
    private int statusAnggota;
    private int idDesa = 0;
    private int isSync = 0;

    public AnggotaPoktanRealm() {
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getPoktanAnggota() {
        return poktanAnggota;
    }

    public void setPoktanAnggota(String poktanAnggota) {
        this.poktanAnggota = poktanAnggota;
    }

    public String getPetaniAnggota() {
        return petaniAnggota;
    }

    public void setPetaniAnggota(String petaniAnggota) {
        this.petaniAnggota = petaniAnggota;
    }

    public String getTanggalMasuk() {
        return tanggalMasuk;
    }

    public void setTanggalMasuk(String tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }

    public int getStatusAnggota() {
        return statusAnggota;
    }

    public void setStatusAnggota(int statusAnggota) {
        this.statusAnggota = statusAnggota;
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
        return "AnggotaPoktanRealm{" +
                "hashId='" + hashId + '\'' +
                ", poktanAnggota='" + poktanAnggota + '\'' +
                ", petaniAnggota='" + petaniAnggota + '\'' +
                ", tanggalMasuk='" + tanggalMasuk + '\'' +
                ", statusAnggota='" + statusAnggota + '\'' +
                ", idDesa=" + idDesa +
                ", isSync=" + isSync +
                '}';
    }
}
