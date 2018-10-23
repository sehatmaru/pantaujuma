package teknodesa.devlops.pantaujuma.dependencies.models.realms.lahan;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;

public class RiwayatLahanRealm extends RealmObject {
    @PrimaryKey
    private String hashId;
    private String idKomoditas;
    private String idLahan;
    private String idPetani;
    private String idKegiatan;
    private int idDesa;
    private String tanggalAwal;
    private String tanggalAkhir;
    private String status;
    private int isSync;

    public RiwayatLahanRealm() {
    }

    public RiwayatLahanRealm(String hashId, String idKomoditas, String idLahan, String idPetani, String idKegiatan, int idDesa, String tanggalAwal, String tanggalAkhir, String status, int isSync) {
        this.hashId = hashId;
        this.idKomoditas = idKomoditas;
        this.idLahan = idLahan;
        this.idPetani = idPetani;
        this.idKegiatan = idKegiatan;
        this.idDesa = idDesa;
        this.tanggalAwal = tanggalAwal;
        this.tanggalAkhir = tanggalAkhir;
        this.status = status;
        this.isSync = isSync;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getIdKomoditas() {
        return idKomoditas;
    }

    public void setIdKomoditas(String idKomoditas) {
        this.idKomoditas = idKomoditas;
    }

    public String getIdLahan() {
        return idLahan;
    }

    public void setIdLahan(String idLahan) {
        this.idLahan = idLahan;
    }

    public String getIdPetani() {
        return idPetani;
    }

    public void setIdPetani(String idPetani) {
        this.idPetani = idPetani;
    }

    public String getIdKegiatan() {
        return idKegiatan;
    }

    public void setIdKegiatan(String idKegiatan) {
        this.idKegiatan = idKegiatan;
    }

    public int getIdDesa() {
        return idDesa;
    }

    public void setIdDesa(int idDesa) {
        this.idDesa = idDesa;
    }

    public String getTanggalAwal() {
        return tanggalAwal;
    }

    public void setTanggalAwal(String tanggalAwal) {
        this.tanggalAwal = tanggalAwal;
    }

    public String getTanggalAkhir() {
        return tanggalAkhir;
    }

    public void setTanggalAkhir(String tanggalAkhir) {
        this.tanggalAkhir = tanggalAkhir;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIsSync() {
        return isSync;
    }

    public void setIsSync(int isSync) {
        this.isSync = isSync;
    }

    @Override
    public String toString() {
        return "RiwayatLahanRealm{" +
                "hashId='" + hashId + '\'' +
                ", idKomoditas='" + idKomoditas + '\'' +
                ", idLahan='" + idLahan + '\'' +
                ", idPetani='" + idPetani + '\'' +
                ", idKegiatan='" + idKegiatan + '\'' +
                ", idDesa=" + idDesa +
                ", tanggalAwal='" + tanggalAwal + '\'' +
                ", tanggalAkhir='" + tanggalAkhir + '\'' +
                ", status='" + status + '\'' +
                ", isSync=" + isSync +
                '}';
    }
}
