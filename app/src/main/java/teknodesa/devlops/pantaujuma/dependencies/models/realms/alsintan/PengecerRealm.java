package teknodesa.devlops.pantaujuma.dependencies.models.realms.alsintan;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Sehat MT Samosir on 8/20/2018.
 */

public class PengecerRealm extends RealmObject {
    @PrimaryKey
    private String hashId;
    private String nama;
    private String jenisPengecer;
    private String alamat;
    private String noTelp;
    private String noHP;
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

    public String getJenisPengecer() {
        return jenisPengecer;
    }

    public void setJenisPengecer(String jenisPengecer) {
        this.jenisPengecer = jenisPengecer;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getNoHP() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
