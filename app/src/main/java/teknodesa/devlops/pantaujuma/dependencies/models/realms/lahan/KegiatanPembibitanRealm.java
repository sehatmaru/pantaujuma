package teknodesa.devlops.pantaujuma.dependencies.models.realms.lahan;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Data;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.KomoditasRealm;

public class KegiatanPembibitanRealm extends RealmObject {
    @PrimaryKey
    private int hashId;
    private String tanggalMulai;
    private String tanggalAkhir;
    private String masaKegiatan;
    private String gambar;
    private KomoditasRealm komoditas;
    private float jumlah;
    private float sumber;


    public int getHashId() {
        return hashId;
    }

    public void setHashId(int hashId) {
        this.hashId = hashId;
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

    public KomoditasRealm getKomoditas() {
        return komoditas;
    }

    public void setKomoditas(KomoditasRealm komoditas) {
        this.komoditas = komoditas;
    }

    public float getJumlah() {
        return jumlah;
    }

    public void setJumlah(float jumlah) {
        this.jumlah = jumlah;
    }

    public float getSumber() {
        return sumber;
    }

    public void setSumber(float sumber) {
        this.sumber = sumber;
    }
}
