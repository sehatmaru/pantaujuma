package teknodesa.devlops.pantaujuma.dependencies.models.realms.lahan;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;

public class RiwayatLahanRealm extends RealmObject {
    @PrimaryKey
    private String hashId;
    private String idKomoditas;
    private int idDesa;
    private String idLahan;
    @SerializedName("nama")
    private String namaPemilikLahan;
    private String alamat;
    private String tanggalMulai;
    private String tanggalAkhir;
    private String masaKegiatan;
    private String gambar;
    private String cara;
    private double luas;
    private double hasil;
    private double jumlah;
    private String sumber;
    private String pupuk;
    private String jumlahPupuk;

    public RiwayatLahanRealm() {
    }

    public RiwayatLahanRealm(String hashId, String idKomoditas, int idDesa, String idLahan, String namaPemilikLahan,
                             String alamat, String tanggalMulai, String tanggalAkhir, String masaKegiatan, String gambar,
                             String cara, double luas, double hasil, double jumlah, String sumber, String pupuk, String jumlahPupuk) {
        this.hashId = hashId;
        this.idKomoditas = idKomoditas;
        this.idDesa = idDesa;
        this.idLahan = idLahan;
        this.namaPemilikLahan = namaPemilikLahan;
        this.alamat = alamat;
        this.tanggalMulai = tanggalMulai;
        this.tanggalAkhir = tanggalAkhir;
        this.masaKegiatan = masaKegiatan;
        this.gambar = gambar;
        this.cara = cara;
        this.luas = luas;
        this.hasil = hasil;
        this.jumlah = jumlah;
        this.sumber = sumber;
        this.pupuk = pupuk;
        this.jumlahPupuk = jumlahPupuk;
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

    public double getLuas() {
        return luas;
    }

    public void setLuas(double luas) {
        this.luas = luas;
    }

    public double getHasil() {
        return hasil;
    }

    public void setHasil(double hasil) {
        this.hasil = hasil;
    }

    public double getJumlah() {
        return jumlah;
    }

    public void setJumlah(double jumlah) {
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

    public String getJumlahPupuk() {
        return jumlahPupuk;
    }

    public void setJumlahPupuk(String jumlahPupuk) {
        this.jumlahPupuk = jumlahPupuk;
    }
}
