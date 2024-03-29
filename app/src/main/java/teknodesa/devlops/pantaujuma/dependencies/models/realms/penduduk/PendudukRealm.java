package teknodesa.devlops.pantaujuma.dependencies.models.realms.penduduk;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Roy Deddy Tobing on 4/4/2018.
 */

public class PendudukRealm extends RealmObject {
    @PrimaryKey
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
    private int isSync;


    public PendudukRealm() {
    }

    public PendudukRealm(PendudukRealm pendudukRealm, int isSync) {
        this.hashId = pendudukRealm.getHashId();
        this.NIK = pendudukRealm.getNIK();
        this.foto = pendudukRealm.getFoto();
        this.namaDepan = pendudukRealm.getNamaDepan();
        this.namaBelakang = pendudukRealm.getNamaBelakang();
        this.jenisKelamin = pendudukRealm.getJenisKelamin();
        this.tempatLahir = pendudukRealm.getTempatLahir();
        this.tanggalLahir = pendudukRealm.getTanggalLahir();
        this.agama = pendudukRealm.getAgama();
        this.golonganDarah = pendudukRealm.getGolonganDarah();
        this.pekerjaan = pendudukRealm.getPekerjaan();
        this.pendidikan = pendudukRealm.getPendidikan();
        this.alamat = pendudukRealm.getAlamat();
        this.rt = pendudukRealm.getRt();
        this.rw = pendudukRealm.getRw();
        this.dusun = pendudukRealm.getDusun();
        this.desa = pendudukRealm.getDesa();
        this.kecamatan = pendudukRealm.getKecamatan();
        this.datiII = pendudukRealm.getDatiII();
        this.provinsi = pendudukRealm.getProvinsi();
        this.noHP = pendudukRealm.getNoHP();
        this.noTelp = pendudukRealm.getNoTelp();
        this.status = pendudukRealm.getStatus();
        this.kodePos = pendudukRealm.getKodePos();
        this.email = pendudukRealm.getEmail();
        this.idDesa = pendudukRealm.getIdDesa();
        this.isSync = isSync;
    }

    public PendudukRealm(String hashId, String NIK, String foto, String namaDepan, String namaBelakang, String jenisKelamin, String tempatLahir, String tanggalLahir, String agama, String golonganDarah, String pekerjaan, String pendidikan, String alamat, String rt, String rw, String dusun, String desa, String kecamatan, String datiII, String provinsi, String noHP, String noTelp, String status, int kodePos, String email, int idDesa) {
        this.hashId = hashId;
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
        this.alamat = alamat;
        this.rt = rt;
        this.rw = rw;
        this.dusun = dusun;
        this.desa = desa;
        this.kecamatan = kecamatan;
        this.datiII = datiII;
        this.provinsi = provinsi;
        this.noHP = noHP;
        this.noTelp = noTelp;
        this.status = status;
        this.kodePos = kodePos;
        this.email = email;
        this.idDesa = idDesa;
    }

    public int getIsSync() {
        return isSync;
    }

    public void setIsSync(int isSync) {
        this.isSync = isSync;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public int getIdDesa() {
        return idDesa;
    }

    public void setIdDesa(int idDesa) {
        this.idDesa = idDesa;
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


    @Override
    public String toString() {
        return "PendudukRealm{" +
                "hashId=" + hashId +
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
                ", isSync=" + isSync+
                '}';
    }
}
