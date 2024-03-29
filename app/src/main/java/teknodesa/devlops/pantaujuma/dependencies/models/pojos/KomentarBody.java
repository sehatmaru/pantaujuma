package teknodesa.devlops.pantaujuma.dependencies.models.pojos;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.KomentarRealm;

public class KomentarBody {
    private String hashId;
    private String hashPost;
    private String idUser;
    private String namaUser;
    private String waktu;
    private String tanggal;
    private String deskripsi;
    private int idDesa;

    public KomentarBody() {
    }

    public KomentarBody(KomentarRealm komentar){
        this.hashId = komentar.getHashId();
        this.hashPost = komentar.getHashPost();
        this.idUser = komentar.getIdUser();
        this.namaUser = komentar.getNamaUser();
        this.waktu = komentar.getWaktu();
        this.tanggal = komentar.getTanggal();
        this.deskripsi = komentar.getDeskripsi();
        this.idDesa = komentar.getIdDesa();
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

    @Override
    public String toString() {
        return "KomentarBody{" +
                "hashId='" + hashId + '\'' +
                ", hashPost='" + hashPost + '\'' +
                ", idUser='" + idUser + '\'' +
                ", namaUser='" + namaUser + '\'' +
                ", waktu='" + waktu + '\'' +
                ", tanggal='" + tanggal + '\'' +
                ", deskripsi='" + deskripsi + '\'' +
                ", idDesa=" + idDesa +
                '}';
    }
}
