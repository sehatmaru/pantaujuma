package teknodesa.devlops.pantaujuma.dependencies.models.pojos;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PoktanBody {
    private String hashId;

    private String nama;
    private String desa;
    private String kecamatan;
    private String tanggalDidirikan;
    private String alamat;
    private String noHP;
    private String noTelp;
    private String deskripsi;
    private String statusPoktan;

    private int idDesa;

    public PoktanBody() {
    }

    public PoktanBody(PoktanBody poktanRealm) {
        this.hashId = poktanRealm.getHashId();
        this.nama = poktanRealm.getNama();
        this.desa = poktanRealm.getDesa();
        this.kecamatan = poktanRealm.getKecamatan();
        this.tanggalDidirikan = poktanRealm.getTanggalDidirikan();
        this.alamat = poktanRealm.getAlamat();
        this.noHP = poktanRealm.getNoHP();
        this.noTelp = poktanRealm.getNoTelp();
        this.deskripsi = poktanRealm.getDeskripsi();
        this.idDesa = poktanRealm.getIdDesa();
    }

    public PoktanBody(String hashId, String nama, String desa, String kecamatan, String tanggalDidirikan, String alamat, String noHP, String noTelp, String deskripsi, String statusPoktan, int idDesa) {
        this.hashId = hashId;
        this.nama = nama;
        this.desa = desa;
        this.kecamatan = kecamatan;
        this.tanggalDidirikan = tanggalDidirikan;
        this.alamat = alamat;
        this.noHP = noHP;
        this.noTelp = noTelp;
        this.deskripsi = deskripsi;
        this.statusPoktan = statusPoktan;
        this.idDesa = idDesa;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
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

    public String getStatusPoktan() {
        return statusPoktan;
    }

    public void setStatusPoktan(String statusPoktan) {
        this.statusPoktan = statusPoktan;
    }

    public int getIdDesa() {
        return idDesa;
    }

    public void setIdDesa(int idDesa) {
        this.idDesa = idDesa;
    }
}
