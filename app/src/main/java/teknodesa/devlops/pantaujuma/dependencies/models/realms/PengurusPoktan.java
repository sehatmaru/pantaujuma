package teknodesa.devlops.pantaujuma.dependencies.models.realms;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PengurusPoktan  extends RealmObject {
    @PrimaryKey
    private int idPengurusPoktan;
    private PoktanRealm poktan;
    private PetaniRealm petani;
    private String jabatan;
    private String periode;
    private int status;

    public PengurusPoktan() {
    }

    public PengurusPoktan(int idPengurusPoktan, PoktanRealm poktan, PetaniRealm petani, String jabatan, String periode, int status) {
        this.idPengurusPoktan = idPengurusPoktan;
        this.poktan = poktan;
        this.petani = petani;
        this.jabatan = jabatan;
        this.periode = periode;
        this.status = status;
    }

    public int getIdPengurusPoktan() {
        return idPengurusPoktan;
    }

    public void setIdPengurusPoktan(int idPengurusPoktan) {
        this.idPengurusPoktan = idPengurusPoktan;
    }

    public PoktanRealm getPoktan() {
        return poktan;
    }

    public void setPoktan(PoktanRealm poktan) {
        this.poktan = poktan;
    }

    public PetaniRealm getPetani() {
        return petani;
    }

    public void setPetani(PetaniRealm petani) {
        this.petani = petani;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
