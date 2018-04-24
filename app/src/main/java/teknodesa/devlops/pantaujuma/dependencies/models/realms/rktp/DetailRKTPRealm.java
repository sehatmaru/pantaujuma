package teknodesa.devlops.pantaujuma.dependencies.models.realms.rktp;

import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;

public class DetailRKTPRealm extends RealmObject{
    @PrimaryKey
    private int idDetailRKTP;

    @LinkingObjects("detailRKTP")
    public final RealmResults<RKTPRealm> rktp = null;

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

    public DetailRKTPRealm() {
    }

    public DetailRKTPRealm(int idDetailRKTP, String tujuan, String masalah, String sasaran, String materi, String metode, String volume, String lokasi, String waktu, String sumberBiaya, String penanggungJawab, String pelaksana, String keterangan) {
        this.idDetailRKTP = idDetailRKTP;
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

    public int getIdDetailRKTP() {
        return idDetailRKTP;
    }

    public void setIdDetailRKTP(int idDetailRKTP) {
        this.idDetailRKTP = idDetailRKTP;
    }

    public RealmResults<RKTPRealm> getRktp() {
        return rktp;
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
