package teknodesa.devlops.pantaujuma.dependencies.models.realms.pasar;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Sehat MT Samosir on 8/20/2018.
 */

public class PasarRealm extends RealmObject {
    @PrimaryKey
    private String hashIdPasar;

    private String namaPasar;
    private String alamat;
    private String kecamatan;
    private String kabupaten;

    public String getHashId() {
        return hashIdPasar;
    }

    public void setHashId(String hashId) {
        this.hashIdPasar = hashId;
    }

    public String getNamaPasar() {
        return namaPasar;
    }

    public void setNamaPasar(String namaPasar) {
        this.namaPasar = namaPasar;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getKabupaten() {
        return kabupaten;
    }

    public void setKabupaten(String kabupaten) {
        this.kabupaten = kabupaten;
    }
}
