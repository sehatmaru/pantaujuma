package teknodesa.devlops.pantaujuma.dependencies.models.realms.lahan;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.PendudukRealm;

public class LahanRealm extends RealmObject {
    @PrimaryKey
    private int idLahan;

    @LinkingObjects("daftarLahan")
    public final RealmResults<PendudukRealm> pemilik = null;
    private String nama;
    private String alamat;
    private String rt;
    private String rw;
    private String dusun;
    private String desa;
    private String kecamatan;
    private String datiII;
    private String provinsi;
    private String longitude;
    private String latitude;
    private String luas;
    private String batasTimur;
    private String batasBarat;
    private String batasSelatan;
    private String batasUtara;
    private String deskripsi;
    private int status;
    private String gambar;
    public RealmList<RiwayatLahanRealm> riwayatLahan;

    public LahanRealm() {
    }

    public LahanRealm(int idLahan, String nama, String alamat, String rt, String rw, String dusun, String desa, String kecamatan, String datiII, String provinsi, String longitude, String latitude, String luas, String batasTimur, String batasBarat, String batasSelatan, String batasUtara, String deskripsi, int status, String gambar, RealmList<RiwayatLahanRealm> riwayatLahan) {
        this.idLahan = idLahan;
        this.nama = nama;
        this.alamat = alamat;
        this.rt = rt;
        this.rw = rw;
        this.dusun = dusun;
        this.desa = desa;
        this.kecamatan = kecamatan;
        this.datiII = datiII;
        this.provinsi = provinsi;
        this.longitude = longitude;
        this.latitude = latitude;
        this.luas = luas;
        this.batasTimur = batasTimur;
        this.batasBarat = batasBarat;
        this.batasSelatan = batasSelatan;
        this.batasUtara = batasUtara;
        this.deskripsi = deskripsi;
        this.status = status;
        this.gambar = gambar;
        this.riwayatLahan = riwayatLahan;
    }

    public int getIdLahan() {
        return idLahan;
    }

    public void setIdLahan(int idLahan) {
        this.idLahan = idLahan;
    }

    public RealmResults<PendudukRealm> getPemilik() {
        return pemilik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getRt() {
        return rt;
    }

    public void setRt(String rt) {
        this.rt = rt;
    }

    public String getRw() {
        return rw;
    }

    public void setRw(String rw) {
        this.rw = rw;
    }

    public String getDusun() {
        return dusun;
    }

    public void setDusun(String dusun) {
        this.dusun = dusun;
    }

    public String getDesa() {
        return desa;
    }

    public void setDesa(String desa) {
        this.desa = desa;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getDatiII() {
        return datiII;
    }

    public void setDatiII(String datiII) {
        this.datiII = datiII;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLuas() {
        return luas;
    }

    public void setLuas(String luas) {
        this.luas = luas;
    }

    public String getBatasTimur() {
        return batasTimur;
    }

    public void setBatasTimur(String batasTimur) {
        this.batasTimur = batasTimur;
    }

    public String getBatasBarat() {
        return batasBarat;
    }

    public void setBatasBarat(String batasBarat) {
        this.batasBarat = batasBarat;
    }

    public String getBatasSelatan() {
        return batasSelatan;
    }

    public void setBatasSelatan(String batasSelatan) {
        this.batasSelatan = batasSelatan;
    }

    public String getBatasUtara() {
        return batasUtara;
    }

    public void setBatasUtara(String batasUtara) {
        this.batasUtara = batasUtara;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public RealmList<RiwayatLahanRealm> getRiwayatLahan() {
        return riwayatLahan;
    }

    public void setRiwayatLahan(RealmList<RiwayatLahanRealm> riwayatLahan) {
        this.riwayatLahan = riwayatLahan;
    }
}
