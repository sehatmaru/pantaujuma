package teknodesa.devlops.pantaujuma.dependencies.models.pojos;

/**
 * Created by Sehat MT Samosir on 11/26/2018.
 */

public class TokoAlsintanBody {
    private String id;
    private String id_alat;
    private String namaAlat;
    private String alamat;
    private String deskripsi_toko;
    private double latitude;
    private double longitude;
    private String harga;
    private String no_hp;
    private String nama_contact;
    private int stok;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_alat() {
        return id_alat;
    }

    public void setId_alat(String id_alat) {
        this.id_alat = id_alat;
    }

    public String getNamaAlat() {
        return namaAlat;
    }

    public void setNamaAlat(String namaAlat) {
        this.namaAlat = namaAlat;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getDeskripsi_toko() {
        return deskripsi_toko;
    }

    public void setDeskripsi_toko(String deskripsi_toko) {
        this.deskripsi_toko = deskripsi_toko;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getNama_contact() {
        return nama_contact;
    }

    public void setNama_contact(String nama_contact) {
        this.nama_contact = nama_contact;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
}
