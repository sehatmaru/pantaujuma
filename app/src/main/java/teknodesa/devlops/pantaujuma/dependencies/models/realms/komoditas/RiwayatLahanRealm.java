package teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RiwayatLahanRealm extends RealmObject {
    @PrimaryKey
    private String hashId;

    private String idKomoditas;
    private int idDesa;
    private String idLahan;
    private String namaPemilikLahan;
    private String alamat;
    private String tanggalMulai;
    private String tanggalAkhir;
    private String masaKegiatan;
    private String gambar;
    private String cara;
    private int luas;
    private int hasil;
    private int jumlah;
    private String sumber;
    private String pupuk;
    private int jumlahPupuk;
    private double longitude;
    private double latitude;

    private int isSync;

    public RiwayatLahanRealm() {
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getIdKomoditas() {
        return idKomoditas;
    }

    public void setIdKomoditas(String idKomoditas) {
        this.idKomoditas = idKomoditas;
    }

    public int getIdDesa() {
        return idDesa;
    }

    public void setIdDesa(int idDesa) {
        this.idDesa = idDesa;
    }

    public String getIdLahan() {
        return idLahan;
    }

    public void setIdLahan(String idLahan) {
        this.idLahan = idLahan;
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

    public String getTanggalMulai() {
        return tanggalMulai;
    }

    public void setTanggalMulai(String tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
    }

    public String getTanggalAkhir() {
        return tanggalAkhir;
    }

    public void setTanggalAkhir(String tanggalAkhir) {
        this.tanggalAkhir = tanggalAkhir;
    }

    public String getMasaKegiatan() {
        return masaKegiatan;
    }

    public void setMasaKegiatan(String masaKegiatan) {
        this.masaKegiatan = masaKegiatan;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getCara() {
        return cara;
    }

    public void setCara(String cara) {
        this.cara = cara;
    }

    public int getLuas() {
        return luas;
    }

    public void setLuas(int luas) {
        this.luas = luas;
    }

    public int getHasil() {
        return hasil;
    }

    public void setHasil(int hasil) {
        this.hasil = hasil;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getSumber() {
        return sumber;
    }

    public void setSumber(String sumber) {
        this.sumber = sumber;
    }

    public String getPupuk() {
        return pupuk;
    }

    public void setPupuk(String pupuk) {
        this.pupuk = pupuk;
    }

    public int getJumlahPupuk() {
        return jumlahPupuk;
    }

    public void setJumlahPupuk(int jumlahPupuk) {
        this.jumlahPupuk = jumlahPupuk;
    }

    public int getIsSync() {
        return isSync;
    }

    public void setIsSync(int isSync) {
        this.isSync = isSync;
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

    @Override
    public String toString() {
        return "RiwayatLahanRealm{" +
                "hashId='" + hashId + '\'' +
                ", idKomoditas='" + idKomoditas + '\'' +
                ", idDesa=" + idDesa +
                ", idLahan='" + idLahan + '\'' +
                ", namaPemilikLahan='" + namaPemilikLahan + '\'' +
                ", alamat='" + alamat + '\'' +
                ", tanggalMulai='" + tanggalMulai + '\'' +
                ", tanggalAkhir='" + tanggalAkhir + '\'' +
                ", masaKegiatan='" + masaKegiatan + '\'' +
                ", gambar='" + gambar + '\'' +
                ", cara='" + cara + '\'' +
                ", luas=" + luas +
                ", hasil=" + hasil +
                ", jumlah=" + jumlah +
                ", sumber='" + sumber + '\'' +
                ", pupuk='" + pupuk + '\'' +
                ", jumlahPupuk=" + jumlahPupuk +
                ", isSync=" + isSync +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
