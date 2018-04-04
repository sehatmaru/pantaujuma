package teknodesa.devlops.pantaujuma.dependencies.models.realms.alsintan;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PengecerRealm extends RealmObject {
    @PrimaryKey
    private int idPengecer;
    private String nama;
    private String jenisPengecer;
    private String alamat;
    private String noTelp;
    private String noHP;
    private String deskripsi;

    public PengecerRealm() {
    }

    public PengecerRealm(int idPengecer, String nama, String jenisPengecer, String alamat, String noTelp, String noHP, String deskripsi) {
        this.idPengecer = idPengecer;
        this.nama = nama;
        this.jenisPengecer = jenisPengecer;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.noHP = noHP;
        this.deskripsi = deskripsi;
    }

    public int getIdPengecer() {
        return idPengecer;
    }

    public void setIdPengecer(int idPengecer) {
        this.idPengecer = idPengecer;
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
