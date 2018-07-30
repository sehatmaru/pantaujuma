package teknodesa.devlops.pantaujuma.dependencies.models.pojos.penduduk;

/**
 * Created by Roy Deddy Tobing on 4/4/2018.
 */

public class BiodataPenduduk {
    private String NIK;
    private String foto;
    private String namaDepan;
    private String namaBelakang;
    private String jenisKelamin;
    private String tempatLahir;
    private String tanggalLahir;
    private String agama;
    private String golonganDarah;
    private String pekerjaan;
    private String pendidikan;
    private String status;


    public BiodataPenduduk() {
    }

    public BiodataPenduduk(String NIK, String foto, String namaDepan, String namaBelakang, String jenisKelamin,
                           String tempatLahir, String tanggalLahir, String agama, String golonganDarah, String pekerjaan,
                           String pendidikan, String status) {
        this.NIK = NIK;
        this.foto = foto;
        this.namaDepan = namaDepan;
        this.namaBelakang = namaBelakang;
        this.jenisKelamin = jenisKelamin;
        this.tempatLahir = tempatLahir;
        this.tanggalLahir = tanggalLahir;
        this.agama = agama;
        this.golonganDarah = golonganDarah;
        this.pekerjaan = pekerjaan;
        this.pendidikan = pendidikan;
        this.status = status;
    }

    public String getNIK() {
        return NIK;
    }

    public void setNIK(String NIK) {
        this.NIK = NIK;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNamaDepan() {
        return namaDepan;
    }

    public void setNamaDepan(String namaDepan) {
        this.namaDepan = namaDepan;
    }

    public String getNamaBelakang() {
        return namaBelakang;
    }

    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getGolonganDarah() {
        return golonganDarah;
    }

    public void setGolonganDarah(String golonganDarah) {
        this.golonganDarah = golonganDarah;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getPendidikan() {
        return pendidikan;
    }

    public void setPendidikan(String pendidikan) {
        this.pendidikan = pendidikan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
