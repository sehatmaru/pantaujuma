package teknodesa.devlops.pantaujuma.dependencies.models.pojos.rdk;

public class JadwalKegiatan {
    private String hashId;
    private String kegiatanJK;
    private String tanggalJK;
    private String deskripsiJK;

    public JadwalKegiatan() {
    }

    public JadwalKegiatan(String hashId, String kegiatanJK, String tanggalJK, String deskripsiJK) {
        this.hashId = hashId;
        this.kegiatanJK = kegiatanJK;
        this.tanggalJK = tanggalJK;
        this.deskripsiJK = deskripsiJK;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getKegiatanJK() {
        return kegiatanJK;
    }

    public void setKegiatanJK(String kegiatanJK) {
        this.kegiatanJK = kegiatanJK;
    }

    public String getTanggalJK() {
        return tanggalJK;
    }

    public void setTanggalJK(String tanggalJK) {
        this.tanggalJK = tanggalJK;
    }

    public String getDeskripsiJK() {
        return deskripsiJK;
    }

    public void setDeskripsiJK(String deskripsiJK) {
        this.deskripsiJK = deskripsiJK;
    }
}
