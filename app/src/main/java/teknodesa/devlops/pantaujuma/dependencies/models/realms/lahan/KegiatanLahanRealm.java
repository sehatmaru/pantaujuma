package teknodesa.devlops.pantaujuma.dependencies.models.realms.lahan;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class KegiatanLahanRealm extends RealmObject {
    @PrimaryKey
    private String hashId;
    private String idKomoditas;
    private int idDesa;
    private String idLahan;
    private String tanggalMulai;
    private String tanggalAkhir;
    private String masaKegiatan;
    private String gambar;
    private String cara;
    private float luas;
    private float hasil;
    private float jumlah;
    private String sumber;
    private String pupuk;
    private float jumlahPupuk;
    private int isSync;

    public KegiatanLahanRealm() {
    }

    public KegiatanLahanRealm(String hashId, String idKomoditas, int idDesa, String idLahan, String tanggalMulai, String tanggalAkhir, String masaKegiatan, String gambar, String cara, float luas, float hasil, float jumlah, String sumber, String pupuk, float jumlahPupuk, int isSync) {
        this.hashId = hashId;
        this.idKomoditas = idKomoditas;
        this.idDesa = idDesa;
        this.idLahan = idLahan;
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
        this.isSync = isSync;
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

    public float getLuas() {
        return luas;
    }

    public void setLuas(float luas) {
        this.luas = luas;
    }

    public float getHasil() {
        return hasil;
    }

    public void setHasil(float hasil) {
        this.hasil = hasil;
    }

    public float getJumlah() {
        return jumlah;
    }

    public void setJumlah(float jumlah) {
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

    public float getJumlahPupuk() {
        return jumlahPupuk;
    }

    public void setJumlahPupuk(float jumlahPupuk) {
        this.jumlahPupuk = jumlahPupuk;
    }

    public int getIsSync() {
        return isSync;
    }

    public void setIsSync(int isSync) {
        this.isSync = isSync;
    }

    @Override
    public String toString() {
        return "KegiatanLahanRealm{" +
                "hashId='" + hashId + '\'' +
                ", idKomoditas='" + idKomoditas + '\'' +
                ", idDesa=" + idDesa +
                ", idLahan='" + idLahan + '\'' +
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
                '}';
    }
}
