package teknodesa.devlops.pantaujuma.dependencies.models.realms.petugas;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.KomoditasRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.PenggunaRealm;

public class TargetPetugas extends RealmObject {
    @PrimaryKey
    private int idTargetPetugas;
    private PenggunaRealm pengguna;
    private int tahun;
    private KomoditasRealm komoditas;
    private float luasTanam;
    private float luasPanen;
    private float sasaranProduksi;
    private float sasaranProduktifitas;
    private String keterangan;

    public TargetPetugas() {
    }

    public TargetPetugas(int idTargetPetugas, PenggunaRealm pengguna, int tahun, KomoditasRealm komoditas, float luasTanam, float luasPanen, float sasaranProduksi, float sasaranProduktifitas, String keterangan) {
        this.idTargetPetugas = idTargetPetugas;
        this.pengguna = pengguna;
        this.tahun = tahun;
        this.komoditas = komoditas;
        this.luasTanam = luasTanam;
        this.luasPanen = luasPanen;
        this.sasaranProduksi = sasaranProduksi;
        this.sasaranProduktifitas = sasaranProduktifitas;
        this.keterangan = keterangan;
    }

    public int getIdTargetPetugas() {
        return idTargetPetugas;
    }

    public void setIdTargetPetugas(int idTargetPetugas) {
        this.idTargetPetugas = idTargetPetugas;
    }

    public PenggunaRealm getPengguna() {
        return pengguna;
    }

    public void setPengguna(PenggunaRealm pengguna) {
        this.pengguna = pengguna;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public KomoditasRealm getKomoditas() {
        return komoditas;
    }

    public void setKomoditas(KomoditasRealm komoditas) {
        this.komoditas = komoditas;
    }

    public float getLuasTanam() {
        return luasTanam;
    }

    public void setLuasTanam(float luasTanam) {
        this.luasTanam = luasTanam;
    }

    public float getLuasPanen() {
        return luasPanen;
    }

    public void setLuasPanen(float luasPanen) {
        this.luasPanen = luasPanen;
    }

    public float getSasaranProduksi() {
        return sasaranProduksi;
    }

    public void setSasaranProduksi(float sasaranProduksi) {
        this.sasaranProduksi = sasaranProduksi;
    }

    public float getSasaranProduktifitas() {
        return sasaranProduktifitas;
    }

    public void setSasaranProduktifitas(float sasaranProduktifitas) {
        this.sasaranProduktifitas = sasaranProduktifitas;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
