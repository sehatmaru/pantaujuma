package teknodesa.devlops.pantaujuma.dependencies.models.pojos;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.petani.PetaniRealm;

public class PetaniBody {
    private String hashId;
    private String biodata;
    private String deskripsi;
    private String status;
    private String idDesa;
    private String foto;

    public PetaniBody() {
    }


    public PetaniBody(PetaniRealm data) {
        this.hashId = data.getHashId();
        this.biodata = data.getBiodata();
        this.deskripsi = data.getDeskripsi();
        this.status = data.getStatus();
        this.idDesa = data.getIdDesa();
        this.foto = data.getFoto();
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

    public String getIdDesa() {
        return idDesa;
    }

    public void setIdDesa(String idDesa) {
        this.idDesa = idDesa;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "PetaniBody{" +
                "hashId='" + hashId + '\'' +
                ", biodata='" + biodata + '\'' +
                ", deskripsi='" + deskripsi + '\'' +
                ", status='" + status + '\'' +
                ", idDesa='" + idDesa + '\'' +
                ", foto='" + foto + '\'' +
                '}';
    }
}
