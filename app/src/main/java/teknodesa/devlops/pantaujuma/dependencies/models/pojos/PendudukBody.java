package teknodesa.devlops.pantaujuma.dependencies.models.pojos;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.penduduk.PendudukRealm;

/**
 * Created by Marthin on 7/11/2018.
 */

public class PendudukBody {
    private String hashId;
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
    private String alamat;
    private String rt;
    private String rw;
    private String dusun;
    private String desa;
    private String kecamatan;
    private String datiII;
    private String provinsi;
    private String noHP;
    private String noTelp;
    private String status;
    private int kodePos;
    private String email;
    private int idDesa;

    public PendudukBody() {
    }



    public PendudukBody(PendudukRealm data) {
        this.hashId = data.getHashId();
        this.NIK = data.getNIK();
        this.foto = data.getFoto();
        this.namaDepan = data.getNamaDepan();
        this.namaBelakang = data.getNamaBelakang();
        this.jenisKelamin = data.getJenisKelamin();
        this.tempatLahir = data.getTempatLahir();
        this.tanggalLahir = data.getTanggalLahir();
        this.agama = data.getAgama();
        this.golonganDarah = data.getGolonganDarah();
        this.pekerjaan = data.getPekerjaan();
        this.pendidikan = data.getPendidikan();
        this.alamat = data.getAlamat();
        this.rt = data.getRt();
        this.rw = data.getRw();
        this.dusun = data.getDusun();
        this.desa = data.getDesa();
        this.kecamatan = data.getKecamatan();
        this.datiII = data.getDatiII();
        this.provinsi = data.getProvinsi();
        this.noHP = data.getNoHP();
        this.noTelp = data.getNoTelp();
        this.status = data.getStatus();
        this.kodePos = data.getKodePos();
        this.email = data.getEmail();
        this.idDesa = data.getIdDesa();
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
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

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getRt() {
        return rt;
    }

    public void setRt(String rt) {
        this.rt = rt;
    }

    public String getRw() {
        return rw;
    }

    public void setRw(String rw) {
        this.rw = rw;
    }

    public String getDusun() {
        return dusun;
    }

    public void setDusun(String dusun) {
        this.dusun = dusun;
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

    public String getDatiII() {
        return datiII;
    }

    public void setDatiII(String datiII) {
        this.datiII = datiII;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getKodePos() {
        return kodePos;
    }

    public void setKodePos(int kodePos) {
        this.kodePos = kodePos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdDesa() {
        return idDesa;
    }

    public void setIdDesa(int idDesa) {
        this.idDesa = idDesa;
    }

    @Override
    public String toString() {
        return "PendudukBody{" +
                "hashId='" + hashId + '\'' +
                ", NIK='" + NIK + '\'' +
                ", foto='" + foto + '\'' +
                ", namaDepan='" + namaDepan + '\'' +
                ", namaBelakang='" + namaBelakang + '\'' +
                ", jenisKelamin='" + jenisKelamin + '\'' +
                ", tempatLahir='" + tempatLahir + '\'' +
                ", tanggalLahir='" + tanggalLahir + '\'' +
                ", agama='" + agama + '\'' +
                ", golonganDarah='" + golonganDarah + '\'' +
                ", pekerjaan='" + pekerjaan + '\'' +
                ", pendidikan='" + pendidikan + '\'' +
                ", alamat='" + alamat + '\'' +
                ", rt='" + rt + '\'' +
                ", rw='" + rw + '\'' +
                ", dusun='" + dusun + '\'' +
                ", desa='" + desa + '\'' +
                ", kecamatan='" + kecamatan + '\'' +
                ", datiII='" + datiII + '\'' +
                ", provinsi='" + provinsi + '\'' +
                ", noHP='" + noHP + '\'' +
                ", noTelp='" + noTelp + '\'' +
                ", status='" + status + '\'' +
                ", kodePos=" + kodePos +
                ", email='" + email + '\'' +
                ", idDesa=" + idDesa +
                '}';
    }
}
