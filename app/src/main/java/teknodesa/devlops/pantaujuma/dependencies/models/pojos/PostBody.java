package teknodesa.devlops.pantaujuma.dependencies.models.pojos;

public class PostBody {
    private String hashId;
    private String idUser;
    private String namaUser;
    private String judul;
    private String isi;
    private String tanggal;
    private String waktu;
    private String tipePost;
    private int viewCount;
    private int likes;
    private int dislike;
    private String thumbnail;
    private int idDesa;

    public PostBody() {
    }

    public PostBody(String hashId, String idUser, String namaUser, String judul, String isi, String tanggal, String waktu, String tipePost, int viewCount, int likes, int dislike, String thumbnail, int idDesa) {
        this.hashId = hashId;
        this.idUser = idUser;
        this.namaUser = namaUser;
        this.judul = judul;
        this.isi = isi;
        this.tanggal = tanggal;
        this.waktu = waktu;
        this.tipePost = tipePost;
        this.viewCount = viewCount;
        this.likes = likes;
        this.dislike = dislike;
        this.thumbnail = thumbnail;
        this.idDesa = idDesa;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
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

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getIdDesa() {
        return idDesa;
    }

    public void setIdDesa(int idDesa) {
        this.idDesa = idDesa;
    }

    @Override
    public String toString() {
        return "PostBody{" +
                "hashId='" + hashId + '\'' +
                ", idUser='" + idUser + '\'' +
                ", namaUser='" + namaUser + '\'' +
                ", judul='" + judul + '\'' +
                ", isi='" + isi + '\'' +
                ", tanggal='" + tanggal + '\'' +
                ", waktu='" + waktu + '\'' +
                ", tipePost='" + tipePost + '\'' +
                ", viewCount=" + viewCount +
                ", likes=" + likes +
                ", dislike=" + dislike +
                ", thumbnail='" + thumbnail + '\'' +
                ", idDesa=" + idDesa +
                '}';
    }
}
