package teknodesa.devlops.pantaujuma.dependencies.models.realms.rktp;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import teknodesa.devlops.pantaujuma.components.rktp.RKTPContract;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.petugas.PetugasRealm;

public class RKTPRealm extends RealmObject {
    @PrimaryKey
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
    private int isSync;

    public RKTPRealm() {
    }

    public RKTPRealm(RKTPRealm rktpRealm, int isSync) {
        this.hashId = rktpRealm.getHashId();
        this.idUser = rktpRealm.getIdUser();
        this.idDesa = rktpRealm.getIdDesa();
        this.poktan = rktpRealm.getPoktan();
        this.tahun = rktpRealm.getTahun();
        this.tujuan = rktpRealm.getTujuan();
        this.masalah = rktpRealm.getMasalah();
        this.sasaran = rktpRealm.getSasaran();
        this.materi = rktpRealm.getMateri();
        this.metode = rktpRealm.getMetode();
        this.volume = rktpRealm.getVolume();
        this.lokasi = rktpRealm.getLokasi();
        this.waktu = rktpRealm.getWaktu();
        this.sumberBiaya = rktpRealm.getSumberBiaya();
        this.penanggungJawab = rktpRealm.getPenanggungJawab();
        this.pelaksana = rktpRealm.getPelaksana();
        this.keterangan = rktpRealm.getKeterangan();
        this.isSync = isSync;
    }

    public RKTPRealm(String hashId, String idUser, int idDesa, String poktan, String tahun, String tujuan, String masalah, String sasaran, String materi, String metode, String volume, String lokasi, String waktu, String sumberBiaya, String penanggungJawab, String pelaksana, String keterangan, int isSync) {
        this.hashId = hashId;
        this.idUser = idUser;
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
        this.isSync = isSync;
    }

    public int getIsSync() {
        return isSync;
    }

    public void setIsSync(int isSync) {
        this.isSync = isSync;
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

    @Override
    public String toString() {
        return "RKTPRealm{" +
                "hashId='" + hashId + '\'' +
                ", idUser='" + idUser + '\'' +
                ", idDesa=" + idDesa +
                ", poktan='" + poktan + '\'' +
                ", tahun='" + tahun + '\'' +
                ", tujuan='" + tujuan + '\'' +
                ", masalah='" + masalah + '\'' +
                ", sasaran='" + sasaran + '\'' +
                ", materi='" + materi + '\'' +
                ", metode='" + metode + '\'' +
                ", volume='" + volume + '\'' +
                ", lokasi='" + lokasi + '\'' +
                ", waktu='" + waktu + '\'' +
                ", sumberBiaya='" + sumberBiaya + '\'' +
                ", penanggungJawab='" + penanggungJawab + '\'' +
                ", pelaksana='" + pelaksana + '\'' +
                ", keterangan='" + keterangan + '\'' +
                ", isSync=" + isSync +
                '}';
    }
}