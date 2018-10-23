package teknodesa.devlops.pantaujuma.dependencies.models.realms.alsintan;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Sehat MT Samosir on 8/20/2018.
 */

public class PupukRealm extends RealmObject {
    @PrimaryKey
    private String hashId;
    private String nama;
    private String jenis;
    private String deskripsi;

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
