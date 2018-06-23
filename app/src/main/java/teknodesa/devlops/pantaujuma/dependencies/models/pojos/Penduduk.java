package teknodesa.devlops.pantaujuma.dependencies.models.pojos;

import java.util.Objects;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.PendudukRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.lahan.LahanRealm;

/**
 * Created by Roy Deddy Tobing on 4/4/2018.
 */

public class Penduduk extends RealmObject{
    @PrimaryKey
    private int idPenduduk;
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
    public RealmList<LahanRealm> daftarLahan;
    private String status;
    private int kodePos;
    private String email;

    public Penduduk() {
    }

    public Penduduk(String NIK, String foto, String namaDepan, String namaBelakang, String jenisKelamin, String tempatLahir, String tanggalLahir, String agama, String golonganDarah, String pekerjaan, String pendidikan, String alamat, String rt, String rw, String dusun, String desa, String kecamatan, String datiII, String provinsi, String noHP, String noTelp, RealmList<LahanRealm> daftarLahan, String status, int kodePos, String email) {
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
        this.daftarLahan = daftarLahan;
        this.status = status;
        this.kodePos = kodePos;
        this.email = email;
    }

    public Penduduk(String NIK, String foto, String namaDepan, String namaBelakang, String jenisKelamin, String tempatLahir, String tanggalLahir, String agama, String golonganDarah, String pekerjaan, String pendidikan, String status) {
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

    public Penduduk (PendudukRealm penduduk){
        this.idPenduduk = penduduk.getIdPenduduk();
        this.NIK = penduduk.getNIK();
        this.foto = String.valueOf(penduduk.getFoto());
        this.namaDepan = penduduk.getNamaDepan();
        this.namaBelakang = penduduk.getNamaBelakang();
        this.jenisKelamin = penduduk.getJenisKelamin();
        this.tempatLahir = penduduk.getTempatLahir();
        this.tanggalLahir = penduduk.getTanggalLahir();

        this.agama = penduduk.getAgama();
        this.golonganDarah = penduduk.getGolonganDarah();
        this.pekerjaan = penduduk.getPekerjaan();
        this.pendidikan = penduduk.getPendidikan();

        this.alamat = penduduk.getAlamat();
        this.rt = penduduk.getRt();
        this.rw = penduduk.getRw();

        this.dusun = penduduk.getDusun();
        this.desa = penduduk.getDesa();
        this.kecamatan = penduduk.getKecamatan();
        this.datiII = penduduk.getDatiII();
        this.provinsi = penduduk.getProvinsi();

        this.noHP = noHP;
        this.noTelp = noTelp;
        this.status = status;
        this.kodePos = kodePos;
        this.email = email;

        this.noHP = penduduk.getNoHP();
        this.noTelp = penduduk.getNoTelp();
        this.status = penduduk.getStatus();
        this.kodePos = penduduk.getKodePos();
        this.email = penduduk.getEmail();
    }

    public int getIdPenduduk() {
        return idPenduduk;
    }

    public void setIdPenduduk(int idPenduduk) {
        this.idPenduduk = idPenduduk;
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

    public RealmList<LahanRealm> getDaftarLahan() {
        return daftarLahan;
    }

    public void setDaftarLahan(RealmList<LahanRealm> daftarLahan) {
        this.daftarLahan = daftarLahan;
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
                "idPenduduk=" + idPenduduk +
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
                ", daftarLahan=" + daftarLahan +
                ", status='" + status + '\'' +
                ", kodePos=" + kodePos +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Penduduk penduduk = (Penduduk) o;
        return idPenduduk == penduduk.idPenduduk &&
                kodePos == penduduk.kodePos &&
                Objects.equals(NIK, penduduk.NIK) &&
                Objects.equals(foto, penduduk.foto) &&
                Objects.equals(namaDepan, penduduk.namaDepan) &&
                Objects.equals(namaBelakang, penduduk.namaBelakang) &&
                Objects.equals(jenisKelamin, penduduk.jenisKelamin) &&
                Objects.equals(tempatLahir, penduduk.tempatLahir) &&
                Objects.equals(tanggalLahir, penduduk.tanggalLahir) &&
                Objects.equals(agama, penduduk.agama) &&
                Objects.equals(golonganDarah, penduduk.golonganDarah) &&
                Objects.equals(pekerjaan, penduduk.pekerjaan) &&
                Objects.equals(pendidikan, penduduk.pendidikan) &&
                Objects.equals(alamat, penduduk.alamat) &&
                Objects.equals(rt, penduduk.rt) &&
                Objects.equals(rw, penduduk.rw) &&
                Objects.equals(dusun, penduduk.dusun) &&
                Objects.equals(desa, penduduk.desa) &&
                Objects.equals(kecamatan, penduduk.kecamatan) &&
                Objects.equals(datiII, penduduk.datiII) &&
                Objects.equals(provinsi, penduduk.provinsi) &&
                Objects.equals(noHP, penduduk.noHP) &&
                Objects.equals(noTelp, penduduk.noTelp) &&
                Objects.equals(daftarLahan, penduduk.daftarLahan) &&
                Objects.equals(status, penduduk.status) &&
                Objects.equals(email, penduduk.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPenduduk, NIK, foto, namaDepan, namaBelakang, jenisKelamin, tempatLahir, tanggalLahir, agama, golonganDarah, pekerjaan, pendidikan, alamat, rt, rw, dusun, desa, kecamatan, datiII, provinsi, noHP, noTelp, daftarLahan, status, kodePos, email);
    }
}
