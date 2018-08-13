package teknodesa.devlops.pantaujuma.dependencies.models.pojos;

public class RKTPBody {
    private String hashId;
    private String petugas;
    private int idDesa;
    private String poktan;
    private String tahun;
    private String tujuan;
    private String masalah;
    private String sasaran;
    private String materi;
    private String metode;
    private String volume;
    private String lokasi;
    private String waktu;
    private String sumberBiaya;
    private String penanggungJawab;
    private String pelaksana;
    private String keterangan;

    public RKTPBody() {
    }

    public RKTPBody(String hashId, String petugas, int idDesa, String poktan, String tahun, String tujuan, String masalah, String sasaran, String materi, String metode, String volume, String lokasi, String waktu, String sumberBiaya, String penanggungJawab, String pelaksana, String keterangan) {
        this.hashId = hashId;
        this.petugas = petugas;
        this.idDesa = idDesa;
        this.poktan = poktan;
        this.tahun = tahun;
        this.tujuan = tujuan;
        this.masalah = masalah;
        this.sasaran = sasaran;
        this.materi = materi;
        this.metode = metode;
        this.volume = volume;
        this.lokasi = lokasi;
        this.waktu = waktu;
        this.sumberBiaya = sumberBiaya;
        this.penanggungJawab = penanggungJawab;
        this.pelaksana = pelaksana;
        this.keterangan = keterangan;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getPetugas() {
        return petugas;
    }

    public void setPetugas(String petugas) {
        this.petugas = petugas;
    }

    public int getIdDesa() {
        return idDesa;
    }

    public void setIdDesa(int idDesa) {
        this.idDesa = idDesa;
    }

    public String getPoktan() {
        return poktan;
    }

    public void setPoktan(String poktan) {
        this.poktan = poktan;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public String getMasalah() {
        return masalah;
    }

    public void setMasalah(String masalah) {
        this.masalah = masalah;
    }

    public String getSasaran() {
        return sasaran;
    }

    public void setSasaran(String sasaran) {
        this.sasaran = sasaran;
    }

    public String getMateri() {
        return materi;
    }

    public void setMateri(String materi) {
        this.materi = materi;
    }

    public String getMetode() {
        return metode;
    }

    public void setMetode(String metode) {
        this.metode = metode;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getSumberBiaya() {
        return sumberBiaya;
    }

    public void setSumberBiaya(String sumberBiaya) {
        this.sumberBiaya = sumberBiaya;
    }

    public String getPenanggungJawab() {
        return penanggungJawab;
    }

    public void setPenanggungJawab(String penanggungJawab) {
        this.penanggungJawab = penanggungJawab;
    }

    public String getPelaksana() {
        return pelaksana;
    }

    public void setPelaksana(String pelaksana) {
        this.pelaksana = pelaksana;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
