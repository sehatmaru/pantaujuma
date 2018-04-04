package teknodesa.devlops.pantaujuma.dependencies.models.realms.alsintan;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PengecerPupukRealm extends RealmObject {
    @PrimaryKey
    private int idPengecerPupuk;
    private PupukRealm pupuk;
    private String harga;
    private String deskripsi;

    public PengecerPupukRealm() {
    }

    public PengecerPupukRealm(int idPengecerPupuk, PupukRealm pupuk, String harga, String deskripsi) {
        this.idPengecerPupuk = idPengecerPupuk;
        this.pupuk = pupuk;
        this.harga = harga;
        this.deskripsi = deskripsi;
    }

    public int getIdPengecerPupuk() {
        return idPengecerPupuk;
    }

    public void setIdPengecerPupuk(int idPengecerPupuk) {
        this.idPengecerPupuk = idPengecerPupuk;
    }

    public PupukRealm getPupuk() {
        return pupuk;
    }

    public void setPupuk(PupukRealm pupuk) {
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
