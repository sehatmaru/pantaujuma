package teknodesa.devlops.pantaujuma.dependencies.models.pojos;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.PoktanRealm;

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
    private int statusPoktan;

    private int idDesa;

    public PoktanBody() {
    }

    public PoktanBody(PoktanRealm poktanRealm) {
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

    public int getStatusPoktan() {
        return statusPoktan;
    }

    public void setStatusPoktan(int statusPoktan) {
        this.statusPoktan = statusPoktan;
    }

    public int getIdDesa() {
        return idDesa;
    }

    public void setIdDesa(int idDesa) {
        this.idDesa = idDesa;
    }

    @Override
    public String toString() {
        return "PoktanBody{" +
                "hashId='" + hashId + '\'' +
                ", nama='" + nama + '\'' +
                ", desa='" + desa + '\'' +
                ", kecamatan='" + kecamatan + '\'' +
                ", tanggalDidirikan='" + tanggalDidirikan + '\'' +
                ", alamat='" + alamat + '\'' +
                ", noHP='" + noHP + '\'' +
                ", noTelp='" + noTelp + '\'' +
                ", deskripsi='" + deskripsi + '\'' +
                ", statusPoktan='" + statusPoktan + '\'' +
                ", idDesa=" + idDesa +
                '}';
    }
}
