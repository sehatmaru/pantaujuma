package teknodesa.devlops.pantaujuma.dependencies.models.realms;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PostRealm extends RealmObject {
    @PrimaryKey
    private int idPost;
    private PenggunaRealm pengguna;
    private String judul;
    private String isi;
    private String tanggal;
    private String waktu;
    private String tipePost;
    private String viewCount;
    private String like;
    private String dislike;
    private String komentar;

    public PostRealm() {
    }

    public PostRealm(int idPost, PenggunaRealm pengguna, String judul, String isi, String tanggal, String waktu, String tipePost, String viewCount, String like, String dislike, String komentar) {
        this.idPost = idPost;
        this.pengguna = pengguna;
        this.judul = judul;
        this.isi = isi;
        this.tanggal = tanggal;
        this.waktu = waktu;
        this.tipePost = tipePost;
        this.viewCount = viewCount;
        this.like = like;
        this.dislike = dislike;
        this.komentar = komentar;
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public PenggunaRealm getPengguna() {
        return pengguna;
    }

    public void setPengguna(PenggunaRealm pengguna) {
        this.pengguna = pengguna;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getTipePost() {
        return tipePost;
    }

    public void setTipePost(String tipePost) {
        this.tipePost = tipePost;
    }

    public String getViewCount() {
        return viewCount;
    }

    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getDislike() {
        return dislike;
    }

    public void setDislike(String dislike) {
        this.dislike = dislike;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }
}
