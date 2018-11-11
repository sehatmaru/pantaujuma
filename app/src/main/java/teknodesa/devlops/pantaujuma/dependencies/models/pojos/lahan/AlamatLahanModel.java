package teknodesa.devlops.pantaujuma.dependencies.models.pojos.lahan;

/**
 * Created by Marthin on 11/11/2018.
 */

public class AlamatLahanModel {
    private String alamat;
    private String rt;
    private String rw;
    private String dusun;
    private String desa;
    private String namaKecamatan;
    private String datiII;
    private String provinsi;
    private double longitude;
    private double latitude;

    public AlamatLahanModel() {
    }

    public AlamatLahanModel(String alamat, String rt, String rw, String dusun, String desa,
                            String namaKecamatan, String datiII, String provinsi, double longitude, double latitude) {
        this.alamat = alamat;
        this.rt = rt;
        this.rw = rw;
        this.dusun = dusun;
        this.desa = desa;
        this.namaKecamatan = namaKecamatan;
        this.datiII = datiII;
        this.provinsi = provinsi;
        this.longitude = longitude;
        this.latitude = latitude;
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

    public String getNamaKecamatan() {
        return namaKecamatan;
    }

    public void setNamaKecamatan(String namaKecamatan) {
        this.namaKecamatan = namaKecamatan;
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

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
