package teknodesa.devlops.pantaujuma.dependencies.models.pojos.rdk;

public class Identitas {
    private String hashId;
    private int idDesa;
    private String petugas;
    private String poktan;
    private String irigasi;
    private String intensifikasi;
    private String rencana;
    private String kegiatan;
    private String tanggal;
    private String luasSawah;
    private String 	keterangan;

    public Identitas() {
    }

    public Identitas(String hashId, int idDesa, String petugas, String poktan, String irigasi, String intensifikasi, String rencana, String kegiatan, String tanggal, String luasSawah, String keterangan) {
        this.hashId = hashId;
        this.idDesa = idDesa;
        this.petugas = petugas;
        this.poktan = poktan;
        this.irigasi = irigasi;
        this.intensifikasi = intensifikasi;
        this.rencana = rencana;
        this.kegiatan = kegiatan;
        this.tanggal = tanggal;
        this.luasSawah = luasSawah;
        this.keterangan = keterangan;
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

    public String getPetugas() {
        return petugas;
    }

    public void setPetugas(String petugas) {
        this.petugas = petugas;
    }

    public String getPoktan() {
        return poktan;
    }

    public void setPoktan(String poktan) {
        this.poktan = poktan;
    }

    public String getIrigasi() {
        return irigasi;
    }

    public void setIrigasi(String irigasi) {
        this.irigasi = irigasi;
    }

    public String getIntensifikasi() {
        return intensifikasi;
    }

    public void setIntensifikasi(String intensifikasi) {
        this.intensifikasi = intensifikasi;
    }

    public String getRencana() {
        return rencana;
    }

    public void setRencana(String rencana) {
        this.rencana = rencana;
    }

    public String getKegiatan() {
        return kegiatan;
    }

    public void setKegiatan(String kegiatan) {
        this.kegiatan = kegiatan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getLuasSawah() {
        return luasSawah;
    }

    public void setLuasSawah(String luasSawah) {
        this.luasSawah = luasSawah;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
