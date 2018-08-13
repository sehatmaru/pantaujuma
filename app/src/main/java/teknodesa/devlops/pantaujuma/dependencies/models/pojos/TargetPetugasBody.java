package teknodesa.devlops.pantaujuma.dependencies.models.pojos;

public class TargetPetugasBody {
    private String hashId;
    private String petugas;
    private int idDesa;
    private int tahun;
    private String komoditas;
    private float luasTanam;
    private float luasPanen;
    private float sasaranProduksi;
    private float sasaranProduktifitas;
    private String keterangan;

    public TargetPetugasBody(){

    }

    public TargetPetugasBody(String hashId, String petugas, int idDesa, int tahun, String komoditas, float luasTanam, float luasPanen, float sasaranProduksi, float sasaranProduktifitas, String keterangan) {
        this.hashId = hashId;
        this.petugas = petugas;
        this.idDesa = idDesa;
        this.tahun = tahun;
        this.komoditas = komoditas;
        this.luasTanam = luasTanam;
        this.luasPanen = luasPanen;
        this.sasaranProduksi = sasaranProduksi;
        this.sasaranProduktifitas = sasaranProduktifitas;
        this.keterangan = keterangan;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getPetugas() {
        return petugas;
    }

    public void setPetugas(String petugas) {
        this.petugas = petugas;
    }

    public int getIdDesa() {
        return idDesa;
    }

    public void setIdDesa(int idDesa) {
        this.idDesa = idDesa;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public String getKomoditas() {
        return komoditas;
    }

    public void setKomoditas(String komoditas) {
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

    @Override
    public String toString() {
        return "TargetPetugasBody{" +
                "hashId='" + hashId + '\'' +
                ", petugas='" + petugas + '\'' +
                ", idDesa=" + idDesa +
                ", tahun=" + tahun +
                ", komoditas='" + komoditas + '\'' +
                ", luasTanam=" + luasTanam +
                ", luasPanen=" + luasPanen +
                ", sasaranProduksi=" + sasaranProduksi +
                ", sasaranProduktifitas=" + sasaranProduktifitas +
                ", keterangan='" + keterangan + '\'' +
                '}';
    }
}
