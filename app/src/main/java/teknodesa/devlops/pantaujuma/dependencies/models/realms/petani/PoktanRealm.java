package teknodesa.devlops.pantaujuma.dependencies.models.realms.petani;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PoktanRealm extends RealmObject {
    @PrimaryKey
    private int idPoktan;
    private String nama;
    private String desa;
    private String kecamatan;
    private String tanggalDidirikan;
    private String alamat;
    private String noHP;
    private String noTelp;
    private String deskripsi;
    private int status;

    public PoktanRealm() {
    }

    public PoktanRealm(int idPoktan, String nama, String desa, String kecamatan, String tanggalDidirikan, String alamat, String noHP, String noTelp, String deskripsi, int status) {
        this.idPoktan = idPoktan;
        this.nama = nama;
        this.desa = desa;
        this.kecamatan = kecamatan;
        this.tanggalDidirikan = tanggalDidirikan;
        this.alamat = alamat;
        this.noHP = noHP;
        this.noTelp = noTelp;
        this.deskripsi = deskripsi;
        this.status = status;
    }

    public int getIdPoktan() {
        return idPoktan;
    }

    public void setIdPoktan(int idPoktan) {
        this.idPoktan = idPoktan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDesa() {
        return desa;
    }

    public void setDesa(String desa) {
        this.desa = desa;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getTanggalDidirikan() {
        return tanggalDidirikan;
    }

    public void setTanggalDidirikan(String tanggalDidirikan) {
        this.tanggalDidirikan = tanggalDidirikan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoHP() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
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
