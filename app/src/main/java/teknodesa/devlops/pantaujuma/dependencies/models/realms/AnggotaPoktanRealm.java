package teknodesa.devlops.pantaujuma.dependencies.models.realms;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class AnggotaPoktanRealm extends RealmObject {
    @PrimaryKey
    private int idAnggotaPoktan;
    private PoktanRealm poktan;
    private PetaniRealm petani;
    private String tanggalMasuk;
    private int status;

    public AnggotaPoktanRealm() {
    }

    public AnggotaPoktanRealm(int idAnggotaPoktan, PoktanRealm poktan, PetaniRealm petani, String tanggalMasuk, int status) {
        this.idAnggotaPoktan = idAnggotaPoktan;
        this.poktan = poktan;
        this.petani = petani;
        this.tanggalMasuk = tanggalMasuk;
        this.status = status;
    }

    public int getIdAnggotaPoktan() {
        return idAnggotaPoktan;
    }

    public void setIdAnggotaPoktan(int idAnggotaPoktan) {
        this.idAnggotaPoktan = idAnggotaPoktan;
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

    public String getTanggalMasuk() {
        return tanggalMasuk;
    }

    public void setTanggalMasuk(String tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
