package teknodesa.devlops.pantaujuma.dependencies.models.realms;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class KomoditasRealm extends RealmObject {
    @PrimaryKey
    private int idKomoditas;
    private String nama;
    private String kategori;
    private String deskripsi;
    private String gambar;

    public KomoditasRealm() {
    }

    public KomoditasRealm(int idKomoditas, String nama, String kategori, String deskripsi, String gambar) {
        this.idKomoditas = idKomoditas;
        this.nama = nama;
        this.kategori = kategori;
        this.deskripsi = deskripsi;
        this.gambar = gambar;
    }

    public int getIdKomoditas() {
        return idKomoditas;
    }

    public void setIdKomoditas(int idKomoditas) {
        this.idKomoditas = idKomoditas;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }
}
