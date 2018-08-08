package teknodesa.devlops.pantaujuma.dependencies.models.realms.lahan;

import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;

public class DetailRiwayatPertanianRealm extends RealmObject {
    @PrimaryKey
    private int idDetailRiwayatPertanian;

    private String tanggalMulaiKegiatan;
    private String tanggalAkhirKegiatan;
    private String masaKegiatan; //PRATANAM, TANAM, PANEN, PASCAPANEN
    private String kelompokKegiatan; //PEMBIBITAN, PENANAMAN, DLL
    private int idKegiatan; //id dari kelompok kegiatan
    private String deskripsi;
    private String gambar;

    public DetailRiwayatPertanianRealm() {
    }

    public DetailRiwayatPertanianRealm(int idDetailRiwayatPertanian, String tanggalMulaiKegiatan, String tanggalAkhirKegiatan, String masaKegiatan, String kelompokKegiatan, int idKegiatan, String deskripsi, String gambar) {
        this.idDetailRiwayatPertanian = idDetailRiwayatPertanian;
        this.tanggalMulaiKegiatan = tanggalMulaiKegiatan;
        this.tanggalAkhirKegiatan = tanggalAkhirKegiatan;
        this.masaKegiatan = masaKegiatan;
        this.kelompokKegiatan = kelompokKegiatan;
        this.idKegiatan = idKegiatan;
        this.deskripsi = deskripsi;
        this.gambar = gambar;
    }

    public int getIdDetailRiwayatPertanian() {
        return idDetailRiwayatPertanian;
    }

    public void setIdDetailRiwayatPertanian(int idDetailRiwayatPertanian) {
        this.idDetailRiwayatPertanian = idDetailRiwayatPertanian;
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

    public int getIdKegiatan() {
        return idKegiatan;
    }

    public void setIdKegiatan(int idKegiatan) {
        this.idKegiatan = idKegiatan;
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
}
