package teknodesa.devlops.pantaujuma.dependencies.models.realms.alsintan;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Sehat MT Samosir on 8/20/2018.
 */

public class PengecerPupukRealm extends RealmObject {
    @PrimaryKey
    private String hashId;
    private String pupuk;
    private String harga;
    private String deskripsi;

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getPupuk() {
        return pupuk;
    }

    public void setPupuk(String pupuk) {
        this.pupuk = pupuk;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
