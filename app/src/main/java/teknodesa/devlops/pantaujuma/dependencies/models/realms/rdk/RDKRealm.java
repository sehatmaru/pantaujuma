package teknodesa.devlops.pantaujuma.dependencies.models.realms.rdk;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.petugas.PetugasRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.PoktanRealm;

public class RDKRealm extends RealmObject {
    @PrimaryKey
    private int idRDK;
    private PetugasRealm petugas;
    private PoktanRealm poktan;
    private RealmList<IrigasiRDKRealm> irigasi;
    private RealmList<SasaranIntensifikasiRDKRealm> intensifikasi;
    private RealmList<RencanaUmumRDKRealm> rencana;
    private RealmList<JadwalKegiatanRDKRealm> kegiatan;
    private String tanggal;
    private float luasSawah;
    private String keterangan;

    public RDKRealm() {
    }

    public RDKRealm(int idRDK, PetugasRealm petugas, PoktanRealm poktan, RealmList<IrigasiRDKRealm> irigasi, RealmList<SasaranIntensifikasiRDKRealm> intensifikasi, RealmList<RencanaUmumRDKRealm> rencana, RealmList<JadwalKegiatanRDKRealm> kegiatan, String tanggal, float luasSawah, String keterangan) {
        this.idRDK = idRDK;
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

    public int getIdRDK() {
        return idRDK;
    }

    public void setIdRDK(int idRDK) {
        this.idRDK = idRDK;
    }

    public PetugasRealm getPetugas() {
        return petugas;
    }

    public void setPetugas(PetugasRealm petugas) {
        this.petugas = petugas;
    }

    public PoktanRealm getPoktan() {
        return poktan;
    }

    public void setPoktan(PoktanRealm poktan) {
        this.poktan = poktan;
    }

    public RealmList<IrigasiRDKRealm> getIrigasi() {
        return irigasi;
    }

    public void setIrigasi(RealmList<IrigasiRDKRealm> irigasi) {
        this.irigasi = irigasi;
    }

    public RealmList<SasaranIntensifikasiRDKRealm> getIntensifikasi() {
        return intensifikasi;
    }

    public void setIntensifikasi(RealmList<SasaranIntensifikasiRDKRealm> intensifikasi) {
        this.intensifikasi = intensifikasi;
    }

    public RealmList<RencanaUmumRDKRealm> getRencana() {
        return rencana;
    }

    public void setRencana(RealmList<RencanaUmumRDKRealm> rencana) {
        this.rencana = rencana;
    }

    public RealmList<JadwalKegiatanRDKRealm> getKegiatan() {
        return kegiatan;
    }

    public void setKegiatan(RealmList<JadwalKegiatanRDKRealm> kegiatan) {
        this.kegiatan = kegiatan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public float getLuasSawah() {
        return luasSawah;
    }

    public void setLuasSawah(float luasSawah) {
        this.luasSawah = luasSawah;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
