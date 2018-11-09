package teknodesa.devlops.pantaujuma.dependencies.models.pojos.rdk;

public class Identitas {
    private String poktan;
    private String tanggal;
    private String luasSawah;
    private String 	keterangan;

    public Identitas() {
    }

    public Identitas(String poktan, String tanggal, String luasSawah, String keterangan) {
//        this.idUser = idUser;
        this.poktan = poktan;
        this.tanggal = tanggal;
        this.luasSawah = luasSawah;
        this.keterangan = keterangan;
    }
//
//    public String getIdUser() {
//        return idUser;
//    }
//
//    public void setIdUser(String idUser) {
//        this.idUser = idUser;
//    }

    public String getPoktan() {
        return poktan;
    }

    public void setPoktan(String poktan) {
        this.poktan = poktan;
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
