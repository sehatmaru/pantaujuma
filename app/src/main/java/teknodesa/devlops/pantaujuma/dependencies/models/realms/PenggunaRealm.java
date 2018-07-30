package teknodesa.devlops.pantaujuma.dependencies.models.realms;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.penduduk.PendudukRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.petugas.PetugasRealm;

public class PenggunaRealm extends RealmObject {
    @PrimaryKey
    private int idPengguna;
    private PendudukRealm biodata;
    private PetugasRealm petugas;
    private String username;
    private String email;

    public PenggunaRealm() {
    }

    public PenggunaRealm(int idPengguna, PendudukRealm biodata, PetugasRealm petugas, String username, String email) {
        this.idPengguna = idPengguna;
        this.biodata = biodata;
        this.petugas = petugas;
        this.username = username;
        this.email = email;
    }

    public int getIdPengguna() {
        return idPengguna;
    }

    public void setIdPengguna(int idPengguna) {
        this.idPengguna = idPengguna;
    }

    public PendudukRealm getBiodata() {
        return biodata;
    }

    public void setBiodata(PendudukRealm biodata) {
        this.biodata = biodata;
    }

    public PetugasRealm getPetugas() {
        return petugas;
    }

    public void setPetugas(PetugasRealm petugas) {
        this.petugas = petugas;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
