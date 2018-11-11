package teknodesa.devlops.pantaujuma.dependencies.models.pojos.lahan;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.lahan.LahanRealm;

public class LahanBody {
    private String hashId;
    private int idDesa;
    private String pemilik;
    private String namaPemilikLahan;
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

    public LahanBody() {
    }

    public LahanBody(LahanRealm data) {
        this.hashId = data.getHashId();
        this.idDesa = data.getIdDesa();
        this.pemilik = data.getPemilik();
        this.namaPemilikLahan = data.getNamaPemilikLahan();
        this.alamat = data.getAlamat();
        this.rt = data.getRt();
        this.rw = data.getRw();
        this.dusun = data.getDusun();
        this.desa = data.getDesa();
        this.namaKecamatan = data.getNamaKecamatan();
        this.datiII = data.getDatiII();
        this.provinsi = data.getProvinsi();
        this.longitude = data.getLongitude();
        this.latitude = data.getLatitude();
        this.luas = data.getLuas();
        this.batasTimur = data.getBatasTimur();
        this.batasBarat = data.getBatasBarat();
        this.batasSelatan = data.getBatasSelatan();
        this.batasUtara = data.getBatasUtara();
        this.deskripsi = data.getDeskripsi();
        this.status = 1;
        this.gambar = "";
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

    public String getPemilik() {
        return pemilik;
    }

    public void setPemilik(String pemilik) {
        this.pemilik = pemilik;
    }

    public String getNamaPemilikLahan() {
        return namaPemilikLahan;
    }

    public void setNamaPemilikLahan(String namaPemilikLahan) {
        this.namaPemilikLahan = namaPemilikLahan;
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

    @Override
    public String toString() {
        return "LahanBody{" +
                "hashId='" + hashId + '\'' +
                ", idDesa=" + idDesa +
                ", pemilik='" + pemilik + '\'' +
                ", namaPemilikLahan='" + namaPemilikLahan + '\'' +
                ", alamat='" + alamat + '\'' +
                ", rt='" + rt + '\'' +
                ", rw='" + rw + '\'' +
                ", dusun='" + dusun + '\'' +
                ", desa='" + desa + '\'' +
                ", namaKecamatan='" + namaKecamatan + '\'' +
                ", datiII='" + datiII + '\'' +
                ", provinsi='" + provinsi + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", luas='" + luas + '\'' +
                ", batasTimur='" + batasTimur + '\'' +
                ", batasBarat='" + batasBarat + '\'' +
                ", batasSelatan='" + batasSelatan + '\'' +
                ", batasUtara='" + batasUtara + '\'' +
                ", deskripsi='" + deskripsi + '\'' +
                ", status=" + status +
                ", gambar='" + gambar + '\'' +
                '}';
    }
}
