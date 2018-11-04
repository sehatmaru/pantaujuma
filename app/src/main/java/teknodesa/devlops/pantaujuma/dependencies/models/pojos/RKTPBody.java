package teknodesa.devlops.pantaujuma.dependencies.models.pojos;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.rktp.RKTPRealm;

public class RKTPBody {
    private String hashId;
    private String idUser;
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

    public RKTPBody(RKTPRealm data) {
        this.hashId = data.getHashId();
        this.idUser = data.getIdUser();
        this.idDesa = data.getIdDesa();
        this.poktan = data.getPoktan();
        this.tahun = data.getTahun();
        this.tujuan = data.getTujuan();
        this.masalah = data.getMasalah();
        this.sasaran = data.getSasaran();
        this.materi = data.getMateri();
        this.metode = data.getMetode();
        this.volume = data.getVolume();
        this.lokasi = data.getLokasi();
        this.waktu = data.getWaktu();
        this.sumberBiaya = data.getSumberBiaya();
        this.penanggungJawab = data.getPenanggungJawab();
        this.pelaksana = data.getPelaksana();
        this.keterangan = data.getKeterangan();
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
