package teknodesa.devlops.pantaujuma.dependencies.models.pojos;

public class PetaniBody {
    private String hashId;
    private String biodata;
    private String deskripsi;
    private String status;
    private String idDesa;

    public PetaniBody() {
    }

    public PetaniBody(String hashId, String biodata, String deskripsi, String status, String idDesa) {
        this.hashId = hashId;
        this.biodata = biodata;
        this.deskripsi = deskripsi;
        this.status = status;
        this.idDesa = idDesa;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getBiodata() {
        return biodata;
    }

    public void setBiodata(String biodata) {
        this.biodata = biodata;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
