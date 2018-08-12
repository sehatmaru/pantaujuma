package teknodesa.devlops.pantaujuma.dependencies.models.pojos.rdk;

public class Irigasi {
    private String hashId;
    private String nama;
    private String deskripsiIrigasi;

    public Irigasi() {

    }

    public Irigasi(String hashId, String nama, String deskripsiIrigasi) {
        this.hashId = hashId;
        this.nama = nama;
        this.deskripsiIrigasi = deskripsiIrigasi;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsiIrigasi() {
        return deskripsiIrigasi;
    }

    public void setDeskripsiIrigasi(String deskripsiIrigasi) {
        this.deskripsiIrigasi = deskripsiIrigasi;
    }
}
