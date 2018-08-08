package teknodesa.devlops.pantaujuma.dependencies.models.realms.lahan;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class LahanRealm extends RealmObject {
    @PrimaryKey
    private String hashId;
    private String pemilik;
    private String nama;
    private String alamat;
    private String rt;
    private String rw;
    private String dusun;
    private String desa;
    private String namaKecamatan;
    private String datiII;
    private String provinsi;
    private double longitude;
    private double latitude;
    private String luas;
    private String batasTimur;
    private String batasBarat;
    private String batasSelatan;
    private String batasUtara;
    private String deskripsi;
    private int status;
    private String gambar;

    public LahanRealm() {
    }

    public LahanRealm(String hashId, String pemilik, String nama, String alamat, String rt, String rw, String dusun,
                      String desa, String namaKecamatan, String datiII, String provinsi, double longitude, double latitude,
                      String luas, String batasTimur, String batasBarat, String batasSelatan, String batasUtara, String deskripsi,
                      int status, String gambar) {
        this.hashId = hashId;
        this.pemilik = pemilik;
        this.nama = nama;
        this.alamat = alamat;
        this.rt = rt;
        this.rw = rw;
        this.dusun = dusun;
        this.desa = desa;
        this.namaKecamatan = namaKecamatan;
        this.datiII = datiII;
        this.provinsi = provinsi;
        this.longitude = longitude;
        this.latitude = latitude;
        this.luas = luas;
        this.batasTimur = batasTimur;
        this.batasBarat = batasBarat;
        this.batasSelatan = batasSelatan;
        this.batasUtara = batasUtara;
        this.deskripsi = deskripsi;
        this.status = status;
        this.gambar = gambar;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getPemilik() {
        return pemilik;
    }

    public void setPemilik(String pemilik) {
        this.pemilik = pemilik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
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

    public String getNamaKecamatan() {
        return namaKecamatan;
    }

    public void setNamaKecamatan(String namaKecamatan) {
        this.namaKecamatan = namaKecamatan;
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

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getLuas() {
        return luas;
    }

    public void setLuas(String luas) {
        this.luas = luas;
    }

    public String getBatasTimur() {
        return batasTimur;
    }

    public void setBatasTimur(String batasTimur) {
        this.batasTimur = batasTimur;
    }

    public String getBatasBarat() {
        return batasBarat;
    }

    public void setBatasBarat(String batasBarat) {
        this.batasBarat = batasBarat;
    }

    public String getBatasSelatan() {
        return batasSelatan;
    }

    public void setBatasSelatan(String batasSelatan) {
        this.batasSelatan = batasSelatan;
    }

    public String getBatasUtara() {
        return batasUtara;
    }

    public void setBatasUtara(String batasUtara) {
        this.batasUtara = batasUtara;
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

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }
}
