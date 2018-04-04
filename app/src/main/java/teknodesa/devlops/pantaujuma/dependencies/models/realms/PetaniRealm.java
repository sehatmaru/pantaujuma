package teknodesa.devlops.pantaujuma.dependencies.models.realms;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PetaniRealm extends RealmObject {
    @PrimaryKey
    private int idPetani;
    private PendudukRealm biodata;
    private String foto;
    private String deskripsi;
    private int status;

    public PetaniRealm() {
    }

    public PetaniRealm(int idPetani, PendudukRealm biodata, String foto, String deskripsi, int status) {
        this.idPetani = idPetani;
        this.biodata = biodata;
        this.foto = foto;
        this.deskripsi = deskripsi;
        this.status = status;
    }

    public int getIdPetani() {
        return idPetani;
    }

    public void setIdPetani(int idPetani) {
        this.idPetani = idPetani;
    }

    public PendudukRealm getBiodata() {
        return biodata;
    }

    public void setBiodata(PendudukRealm biodata) {
        this.biodata = biodata;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
