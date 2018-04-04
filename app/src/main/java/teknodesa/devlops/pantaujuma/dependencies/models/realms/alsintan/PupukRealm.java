package teknodesa.devlops.pantaujuma.dependencies.models.realms.alsintan;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PupukRealm extends RealmObject {
    @PrimaryKey
    private int idPupuk;
    private String nama;
    private String jenis;
    private String deskripsi;

    public PupukRealm() {
    }

    public PupukRealm(int idPupuk, String nama, String jenis, String deskripsi) {
        this.idPupuk = idPupuk;
        this.nama = nama;
        this.jenis = jenis;
        this.deskripsi = deskripsi;
    }

    public int getIdPupuk() {
        return idPupuk;
    }

    public void setIdPupuk(int idPupuk) {
        this.idPupuk = idPupuk;
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
