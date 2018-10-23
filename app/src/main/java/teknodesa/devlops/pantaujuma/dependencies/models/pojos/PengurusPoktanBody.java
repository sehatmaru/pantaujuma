package teknodesa.devlops.pantaujuma.dependencies.models.pojos;

public class PengurusPoktanBody {

    private String hashId;

    private String poktanPengurus = null;
    private String petaniPengurus = null;
    private String jabatan = "-";
    private String periode = "-";
    private String statusPengurus = "-";

    private int idDesa = 0;

    public PengurusPoktanBody() {
    }

    public PengurusPoktanBody(String hashId, String poktanPengurus, String petaniPengurus, String jabatan, String periode, String statusPengurus, int idDesa) {
        this.hashId = hashId;
        this.poktanPengurus = poktanPengurus;
        this.petaniPengurus = petaniPengurus;
        this.jabatan = jabatan;
        this.periode = periode;
        this.statusPengurus = statusPengurus;
        this.idDesa = idDesa;
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

    public String getStatusPengurus() {
        return statusPengurus;
    }

    public void setStatusPengurus(String statusPengurus) {
        this.statusPengurus = statusPengurus;
    }

    public int getIdDesa() {
        return idDesa;
    }

    public void setIdDesa(int idDesa) {
        this.idDesa = idDesa;
    }
}
