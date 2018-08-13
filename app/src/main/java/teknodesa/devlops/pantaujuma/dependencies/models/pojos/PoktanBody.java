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

    private String poktanAnggota;
    private String petaniAnggota;
    private String tanggalMasuk;
    private String statusAnggota;

    private String poktanPengurus;
    private String petaniPengurus;
    private String jabatan;
    private String periode;
    private String statusPengurus;

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
        this.poktanAnggota = poktanRealm.getPoktanAnggota();
        this.petaniAnggota = poktanRealm.getPetaniAnggota();
        this.tanggalMasuk = poktanRealm.getTanggalMasuk();
        this.poktanPengurus = poktanRealm.getPoktanPengurus();
        this.petaniPengurus = poktanRealm.getPetaniPengurus();
        this.jabatan = poktanRealm.getJabatan();
        this.periode = poktanRealm.getPeriode();
        this.idDesa = poktanRealm.getIdDesa();
        this.statusAnggota = poktanRealm.getStatusAnggota();
        this.statusPengurus = poktanRealm.getStatusPengurus();
        this.statusPengurus = poktanRealm.getStatusPengurus();
    }

    public PoktanBody(String hashId, String nama, String desa, String kecamatan, String tanggalDidirikan, String alamat, String noHP, String noTelp, String deskripsi, String statusPoktan, String poktanAnggota, String petaniAnggota, String tanggalMasuk, String statusAnggota, String poktanPengurus, String petaniPengurus, String jabatan, String periode, String statusPengurus, int idDesa) {
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
        this.poktanAnggota = poktanAnggota;
        this.petaniAnggota = petaniAnggota;
        this.tanggalMasuk = tanggalMasuk;
        this.statusAnggota = statusAnggota;
        this.poktanPengurus = poktanPengurus;
        this.petaniPengurus = petaniPengurus;
        this.jabatan = jabatan;
        this.periode = periode;
        this.statusPengurus = statusPengurus;
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

    public String getPoktanAnggota() {
        return poktanAnggota;
    }

    public void setPoktanAnggota(String poktanAnggota) {
        this.poktanAnggota = poktanAnggota;
    }

    public String getPetaniAnggota() {
        return petaniAnggota;
    }

    public void setPetaniAnggota(String petaniAnggota) {
        this.petaniAnggota = petaniAnggota;
    }

    public String getTanggalMasuk() {
        return tanggalMasuk;
    }

    public void setTanggalMasuk(String tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }

    public String getStatusAnggota() {
        return statusAnggota;
    }

    public void setStatusAnggota(String statusAnggota) {
        this.statusAnggota = statusAnggota;
    }

    public String getPoktanPengurus() {
        return poktanPengurus;
    }

    public void setPoktanPengurus(String poktanPengurus) {
        this.poktanPengurus = poktanPengurus;
    }

    public String getPetaniPengurus() {
        return petaniPengurus;
    }

    public void setPetaniPengurus(String petaniPengurus) {
        this.petaniPengurus = petaniPengurus;
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

    public String getStatusPengurus() {
        return statusPengurus;
    }

    public void setStatusPengurus(String statusPengurus) {
        this.statusPengurus = statusPengurus;
    }

    public int getIdDesa() {
        return idDesa;
    }

    public void setIdDesa(int idDesa) {
        this.idDesa = idDesa;
    }
}
