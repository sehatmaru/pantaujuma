package teknodesa.devlops.pantaujuma.dependencies.models.pojos;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.petugas.TargetPetugas;

public class TargetPetugasBody {
    private String hashId;
    private String idUser;
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

    public TargetPetugasBody(TargetPetugas data) {
        this.hashId = data.getHashId();
        this.idUser = data.getIdUser();
        this.idDesa = data.getIdDesa();
        this.tahun = data.getTahun();
        this.komoditas = data.getKomoditas();
        this.luasTanam = data.getLuasTanam();
        this.luasPanen = data.getLuasPanen();
        this.sasaranProduksi = data.getSasaranProduksi();
        this.sasaranProduktifitas = data.getSasaranProduktifitas();
        this.keterangan = data.getKeterangan();
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
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
                ", idUser='" + idUser + '\'' +
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
