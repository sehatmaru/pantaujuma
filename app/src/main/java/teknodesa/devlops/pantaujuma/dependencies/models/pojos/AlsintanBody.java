package teknodesa.devlops.pantaujuma.dependencies.models.pojos;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class AlsintanBody {
    private String hashId;
    private String namaAlat;
    private String deskripsi;
    private String gambar;
    private int idDesa;

    public AlsintanBody() {
    }

    public AlsintanBody(String hashId, String namaAlat, String deskripsi, String gambar, int idDesa) {
        this.hashId = hashId;
        this.namaAlat = namaAlat;
        this.deskripsi = deskripsi;
        this.gambar = gambar;
        this.idDesa = idDesa;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getNamaAlat() {
        return namaAlat;
    }

    public void setNamaAlat(String namaAlat) {
        this.namaAlat = namaAlat;
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

    public int getIdDesa() {
        return idDesa;
    }

    public void setIdDesa(int idDesa) {
        this.idDesa = idDesa;
    }
}
