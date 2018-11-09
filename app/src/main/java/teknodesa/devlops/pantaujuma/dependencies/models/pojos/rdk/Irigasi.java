package teknodesa.devlops.pantaujuma.dependencies.models.pojos.rdk;

public class Irigasi {
    private String nama;
    private String deskripsiIrigasi;

    public Irigasi() {

    }

    public Irigasi(String nama, String deskripsiIrigasi) {
//        this.hashId = hashId;
        this.nama = nama;
        this.deskripsiIrigasi = deskripsiIrigasi;
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
