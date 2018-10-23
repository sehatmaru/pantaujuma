package teknodesa.devlops.pantaujuma.dependencies.models.realms.alsintan;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Sehat MT Samosir on 8/20/2018.
 */

public class AlatRealm extends RealmObject {
    @PrimaryKey
    private String hashId;
    private String namaAlat;
    private String deskripsi;
    private String gambar;

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
}
