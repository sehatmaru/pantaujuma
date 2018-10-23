package teknodesa.devlops.pantaujuma.dependencies.models.realms.lahan;

import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;

public class DetailRiwayatPertanianRealm extends RealmObject {
    @PrimaryKey
    private String hashId;
    private String riwayat;
    private int idDesa;
    private String tanggalMulaiKegiatan;
    private String tanggalAkhirKegiatan;
    private String masaKegiatan;
    private String kelompokKegiatan;
    private String hashKegiatan;
    private String deskripsi;
    private String gambar;
    private int isSync;

    public DetailRiwayatPertanianRealm() {
    }

    public DetailRiwayatPertanianRealm(String hashId, String riwayat, int idDesa, String tanggalMulaiKegiatan, String tanggalAkhirKegiatan, String masaKegiatan, String kelompokKegiatan, String hashKegiatan, String deskripsi, String gambar, int isSync) {
        this.hashId = hashId;
        this.riwayat = riwayat;
        this.idDesa = idDesa;
        this.tanggalMulaiKegiatan = tanggalMulaiKegiatan;
        this.tanggalAkhirKegiatan = tanggalAkhirKegiatan;
        this.masaKegiatan = masaKegiatan;
        this.kelompokKegiatan = kelompokKegiatan;
        this.hashKegiatan = hashKegiatan;
        this.deskripsi = deskripsi;
        this.gambar = gambar;
        this.isSync = isSync;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getRiwayat() {
        return riwayat;
    }

    public void setRiwayat(String riwayat) {
        this.riwayat = riwayat;
    }

    public int getIdDesa() {
        return idDesa;
    }

    public void setIdDesa(int idDesa) {
        this.idDesa = idDesa;
    }

    public String getTanggalMulaiKegiatan() {
        return tanggalMulaiKegiatan;
    }

    public void setTanggalMulaiKegiatan(String tanggalMulaiKegiatan) {
        this.tanggalMulaiKegiatan = tanggalMulaiKegiatan;
    }

    public String getTanggalAkhirKegiatan() {
        return tanggalAkhirKegiatan;
    }

    public void setTanggalAkhirKegiatan(String tanggalAkhirKegiatan) {
        this.tanggalAkhirKegiatan = tanggalAkhirKegiatan;
    }

    public String getMasaKegiatan() {
        return masaKegiatan;
    }

    public void setMasaKegiatan(String masaKegiatan) {
        this.masaKegiatan = masaKegiatan;
    }

    public String getKelompokKegiatan() {
        return kelompokKegiatan;
    }

    public void setKelompokKegiatan(String kelompokKegiatan) {
        this.kelompokKegiatan = kelompokKegiatan;
    }

    public String getHashKegiatan() {
        return hashKegiatan;
    }

    public void setHashKegiatan(String hashKegiatan) {
        this.hashKegiatan = hashKegiatan;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public int getIsSync() {
        return isSync;
    }

    public void setIsSync(int isSync) {
        this.isSync = isSync;
    }

    @Override
    public String toString() {
        return "DetailRiwayatPertanianRealm{" +
                "hashId='" + hashId + '\'' +
                ", riwayat='" + riwayat + '\'' +
                ", idDesa=" + idDesa +
                ", tanggalMulaiKegiatan='" + tanggalMulaiKegiatan + '\'' +
                ", tanggalAkhirKegiatan='" + tanggalAkhirKegiatan + '\'' +
                ", masaKegiatan='" + masaKegiatan + '\'' +
                ", kelompokKegiatan='" + kelompokKegiatan + '\'' +
                ", hashKegiatan='" + hashKegiatan + '\'' +
                ", deskripsi='" + deskripsi + '\'' +
                ", gambar='" + gambar + '\'' +
                ", isSync=" + isSync +
                '}';
    }
}
