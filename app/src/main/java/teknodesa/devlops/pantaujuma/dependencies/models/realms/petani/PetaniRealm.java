package teknodesa.devlops.pantaujuma.dependencies.models.realms.petani;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PetaniRealm extends RealmObject {
    @PrimaryKey
    private String hashId;
    private String biodata;
    private String deskripsi;
    private String status;
    private String idDesa;
    private String foto;
    private int isSync;

    public PetaniRealm() {
    }

    public PetaniRealm(PetaniRealm petaniRealm) {
        this.hashId = petaniRealm.getHashId();
        this.biodata = petaniRealm.getBiodata();
        this.deskripsi = petaniRealm.getDeskripsi();
        this.status = petaniRealm.getStatus();
        this.foto = petaniRealm.getFoto();
        this.isSync = petaniRealm.getIsSync();
    }

    public PetaniRealm(String hashId, String biodata, String deskripsi, String status, String idDesa, String foto, int isSync) {
        this.hashId = hashId;
        this.biodata = biodata;
        this.deskripsi = deskripsi;
        this.status = status;
        this.idDesa = idDesa;
        this.foto = foto;
        this.isSync = isSync;
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

    public int getIsSync() {
        return isSync;
    }

    public void setIsSync(int isSync) {
        this.isSync = isSync;
    }

    @Override
    public String toString() {
        return "PetaniRealm{" +
                "hashId='" + hashId + '\'' +
                ", biodata='" + biodata + '\'' +
                ", deskripsi='" + deskripsi + '\'' +
                ", status='" + status + '\'' +
                ", idDesa='" + idDesa + '\'' +
                ", foto='" + foto + '\'' +
                ", isSync=" + isSync +
                '}';
    }
}
