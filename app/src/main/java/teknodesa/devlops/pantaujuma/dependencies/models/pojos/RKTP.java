package teknodesa.devlops.pantaujuma.dependencies.models.pojos;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.rktp.RKTPRealm;

public class RKTP implements Parcelable {
    private String hashId;
    private String idUser;
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
    private int idDesa;
    private int isSync;

    public RKTP() {
    }

    public RKTP(RKTPRealm rktpRealm) {
        this.hashId = rktpRealm.getHashId();
        this.idUser = rktpRealm.getIdUser();
        this.poktan = rktpRealm.getPoktan();
        this.masalah = rktpRealm.getMasalah();
        this.tahun = rktpRealm.getTahun();
        this.tujuan = rktpRealm.getTujuan();
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
        this.idDesa = rktpRealm.getIdDesa();
        this.isSync = rktpRealm.getIsSync();
    }

    public RKTP(String hashId, String idUser, String poktan, String tahun, String tujuan, String masalah, String sasaran, String materi, String metode, String volume, String lokasi, String waktu, String sumberBiaya, String penanggungJawab, String pelaksana, String keterangan, int idDesa, int isSync) {
        this.hashId = hashId;
        this.idUser = idUser;
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
        this.idDesa = idDesa;
        this.isSync = isSync;
    }

    protected RKTP(Parcel in) {
        hashId = in.readString();
        idUser = in.readString();
        poktan = in.readString();
        tahun = in.readString();
        tujuan = in.readString();
        masalah = in.readString();
        sasaran = in.readString();
        materi = in.readString();
        metode = in.readString();
        volume = in.readString();
        lokasi = in.readString();
        waktu = in.readString();
        sumberBiaya = in.readString();
        penanggungJawab = in.readString();
        pelaksana = in.readString();
        keterangan = in.readString();
        idDesa = in.readInt();
        isSync = in.readInt();
    }

    public static final Creator<RKTP> CREATOR = new Creator<RKTP>() {
        @Override
        public RKTP createFromParcel(Parcel in) {

            return new RKTP(in);
        }

        @Override
        public RKTP[] newArray(int size) {
            return new RKTP[size];
        }
    };

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RKTP)) return false;
        RKTP rktp = (RKTP) o;
        return idDesa == rktp.idDesa &&
                isSync == rktp.isSync &&
                Objects.equals(hashId, rktp.hashId) &&
                Objects.equals(idUser, rktp.idUser) &&
                Objects.equals(poktan, rktp.poktan) &&
                Objects.equals(tahun, rktp.tahun) &&
                Objects.equals(tujuan, rktp.tujuan) &&
                Objects.equals(masalah, rktp.masalah) &&
                Objects.equals(sasaran, rktp.sasaran) &&
                Objects.equals(materi, rktp.materi) &&
                Objects.equals(metode, rktp.metode) &&
                Objects.equals(volume, rktp.volume) &&
                Objects.equals(lokasi, rktp.lokasi) &&
                Objects.equals(waktu, rktp.waktu) &&
                Objects.equals(sumberBiaya, rktp.sumberBiaya) &&
                Objects.equals(penanggungJawab, rktp.penanggungJawab) &&
                Objects.equals(pelaksana, rktp.pelaksana) &&
                Objects.equals(keterangan, rktp.keterangan);
    }

    @Override
    public int hashCode() {

        return Objects.hash(hashId, idUser, poktan, tahun, tujuan, masalah, sasaran, materi, metode, volume, lokasi, waktu, sumberBiaya, penanggungJawab, pelaksana, keterangan, idDesa, isSync);
    }

    @Override
    public String toString() {
        return "RKTP{" +
                "hashId='" + hashId + '\'' +
                ", idUser='" + idUser + '\'' +
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
                ", idDesa=" + idDesa +
                ", isSync=" + isSync +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(hashId);
        parcel.writeString(idUser);
        parcel.writeString(poktan);
        parcel.writeString(tahun);
        parcel.writeString(tujuan);
        parcel.writeString(masalah);
        parcel.writeString(sasaran);
        parcel.writeString(materi);
        parcel.writeString(metode);
        parcel.writeString(volume);
        parcel.writeString(lokasi);
        parcel.writeString(waktu);
        parcel.writeString(sumberBiaya);
        parcel.writeString(penanggungJawab);
        parcel.writeString(pelaksana);
        parcel.writeString(keterangan);
        parcel.writeInt(idDesa);
        parcel.writeInt(isSync);
    }
}
