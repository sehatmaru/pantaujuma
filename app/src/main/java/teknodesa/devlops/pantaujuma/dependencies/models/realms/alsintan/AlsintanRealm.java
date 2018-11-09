package teknodesa.devlops.pantaujuma.dependencies.models.realms.alsintan;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class AlsintanRealm extends RealmObject {
    @PrimaryKey
    private String hashId;
    private String namaAlat;
    private String deskripsi;
    private String gambar;
    private int idDesa;
    private int isSync;

    public AlsintanRealm() {
    }

    public AlsintanRealm(AlsintanRealm alsintanRealm) {
        this.hashId = alsintanRealm.getHashId();
        this.namaAlat = alsintanRealm.getNamaAlat();
        this.deskripsi = alsintanRealm.getDeskripsi();
        this.gambar = alsintanRealm.getGambar();
        this.idDesa = alsintanRealm.getIdDesa();
        this.isSync = alsintanRealm.getIsSync();
    }

    public AlsintanRealm(String hashId, String namaAlat, String deskripsi, String gambar, int idDesa, int isSync) {
        this.hashId = hashId;
        this.namaAlat = namaAlat;
        this.deskripsi = deskripsi;
        this.gambar = gambar;
        this.idDesa = idDesa;
        this.isSync = isSync;
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

    public int getIsSync() {
        return isSync;
    }

    public void setIsSync(int isSync) {
        this.isSync = isSync;
    }

    @Override
    public String toString() {
        return "AlsintanRealm{" +
                "hashId='" + hashId + '\'' +
                ", namaAlat='" + namaAlat + '\'' +
                ", deskripsi='" + deskripsi + '\'' +
                ", gambar='" + gambar + '\'' +
                ", idDesa='" + idDesa + '\'' +
                ", isSync=" + isSync +
                '}';
    }
}
