package teknodesa.devlops.pantaujuma.dependencies.models.pojos.rdk;

public class JadwalKegiatan {
    private String kegiatanJK;
    private String tanggalJK;
    private String deskripsiJK;

    public JadwalKegiatan() {
    }

    public JadwalKegiatan(String kegiatanJK, String tanggalJK, String deskripsiJK) {
        this.kegiatanJK = kegiatanJK;
        this.tanggalJK = tanggalJK;
        this.deskripsiJK = deskripsiJK;
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
