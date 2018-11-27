package teknodesa.devlops.pantaujuma.dependencies.models.realms.alsintan;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Sehat MT Samosir on 11/26/2018.
 */

public class TokoAlsintanRealm extends RealmObject {
    @PrimaryKey
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

    public TokoAlsintanRealm() {
    }

    public TokoAlsintanRealm(TokoAlsintanRealm toko) {
        this.id = toko.getId();
        this.id_alat = toko.getId_alat();
        this.namaAlat = toko.getNamaAlat();
        this.alamat = toko.getAlamat();
        this.deskripsi_toko = toko.getDeskripsi_toko();
        this.latitude = toko.getLatitude();
        this.longitude = toko.getLongitude();
        this.harga = toko.getHarga();
        this.no_hp = toko.getNo_hp();
        this.nama_contact = toko.getNama_contact();
        this.stok = toko.getStok();
    }

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

    @Override
    public String toString() {
        return "TokoAlsintanRealm{" +
                "id='" + id + '\'' +
                ", id_alat='" + id_alat + '\'' +
                ", namaAlat='" + namaAlat + '\'' +
                ", alamat='" + alamat + '\'' +
                ", deskripsi_toko='" + deskripsi_toko + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", harga='" + harga + '\'' +
                ", no_hp='" + no_hp + '\'' +
                ", nama_contact='" + nama_contact + '\'' +
                ", stok=" + stok +
                '}';
    }
}
