package teknodesa.devlops.pantaujuma.dependencies.models.pojos;

public class AnggotaPoktanBody {

    private String hashId;

    private String poktanAnggota = null;
    private String petaniAnggota = null;
    private String tanggalMasuk = "-";
    private String statusAnggota = "-";
    private int idDesa = 0;

    public AnggotaPoktanBody() {
    }

    public AnggotaPoktanBody(String hashId, String poktanAnggota, String petaniAnggota, String tanggalMasuk, String statusAnggota, int idDesa) {
        this.hashId = hashId;
        this.poktanAnggota = poktanAnggota;
        this.petaniAnggota = petaniAnggota;
        this.tanggalMasuk = tanggalMasuk;
        this.statusAnggota = statusAnggota;
        this.idDesa = idDesa;
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

    public String getStatusAnggota() {
        return statusAnggota;
    }

    public void setStatusAnggota(String statusAnggota) {
        this.statusAnggota = statusAnggota;
    }

    public int getIdDesa() {
        return idDesa;
    }

    public void setIdDesa(int idDesa) {
        this.idDesa = idDesa;
    }
}
