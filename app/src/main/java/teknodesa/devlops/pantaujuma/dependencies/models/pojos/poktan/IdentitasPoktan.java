package teknodesa.devlops.pantaujuma.dependencies.models.pojos.poktan;

/**
 * Created by Sehat MT Samosir on 8/2/2018.
 */

public class IdentitasPoktan {

    private String nama;
    private String desa;
    private String kecamatan;
    private String tanggalDidirikan;
    private String alamat;
    private String noHp;
    private String noTelp;
    private String deskripsi;
    private String statusPoktan;

    public IdentitasPoktan() {
    }

    public IdentitasPoktan(String nama, String desa, String kecamatan, String tanggalDidirikan, String alamat, String noHp, String noTelp, String deskripsi, String statusPoktan) {
        this.nama = nama;
        this.desa = desa;
        this.kecamatan = kecamatan;
        this.tanggalDidirikan = tanggalDidirikan;
        this.alamat = alamat;
        this.noHp = noHp;
        this.noTelp = noTelp;
        this.deskripsi = deskripsi;
        this.statusPoktan = statusPoktan;
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

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
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
}
