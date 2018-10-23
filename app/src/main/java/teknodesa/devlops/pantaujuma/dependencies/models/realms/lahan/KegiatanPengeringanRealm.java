package teknodesa.devlops.pantaujuma.dependencies.models.realms.lahan;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class KegiatanPengeringanRealm extends RealmObject {
    @PrimaryKey
    private int idKegiatanPemanenan;
    private String tanggalMulai;
    private String tanggalAkhir;
    private String masaKegiatan;
    private String gambar;
    private String cara;
    private float jumlah;

    public int getIdKegiatanPemanenan() {
        return idKegiatanPemanenan;
    }

    public void setIdKegiatanPemanenan(int idKegiatanPemanenan) {
        this.idKegiatanPemanenan = idKegiatanPemanenan;
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

    public float getJumlah() {
        return jumlah;
    }

    public void setJumlah(float jumlah) {
        this.jumlah = jumlah;
    }
}
