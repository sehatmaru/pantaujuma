package teknodesa.devlops.pantaujuma.dependencies.models.realms;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class KomentarRealm extends RealmObject{
    @PrimaryKey
    private String hashId;
    private String hashPost;
    private String idUser;
    private String namaUser;
    private String nama;
    private String waktu;
    private String tanggal;
    private String deskripsi;
    private int idDesa;
    private int isSync;

    public KomentarRealm() {
    }

    public KomentarRealm(String hashId, String hashPost, String idUser, String namaUser, String nama, String waktu, String tanggal, String deskripsi, int idDesa, int isSync) {
        this.hashId = hashId;
        this.hashPost = hashPost;
        this.idUser = idUser;
        this.namaUser = namaUser;
        this.nama = nama;
        this.waktu = waktu;
        this.tanggal = tanggal;
        this.deskripsi = deskripsi;
        this.idDesa = idDesa;
        this.isSync = isSync;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getHashPost() {
        return hashPost;
    }

    public void setHashPost(String hashPost) {
        this.hashPost = hashPost;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNamaUser() {
        return namaUser;
    }

    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
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
        return "KomentarRealm{" +
                "hashId='" + hashId + '\'' +
                ", hashPost='" + hashPost + '\'' +
                ", idUser='" + idUser + '\'' +
                ", namaUser='" + namaUser + '\'' +
                ", nama='" + nama + '\'' +
                ", waktu='" + waktu + '\'' +
                ", tanggal='" + tanggal + '\'' +
                ", deskripsi='" + deskripsi + '\'' +
                ", idDesa=" + idDesa +
                ", isSync=" + isSync +
                '}';
    }
}
