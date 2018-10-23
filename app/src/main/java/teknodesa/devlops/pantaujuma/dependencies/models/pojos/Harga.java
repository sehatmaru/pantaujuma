package teknodesa.devlops.pantaujuma.dependencies.models.pojos;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.harga.HargaRealm;

public class Harga implements Parcelable {
    private String hashId;
    private String hashKomoditas;
    private String hashPasar;
    private String tanggal;
    private String nilai;
    private String satuan;
    private String namaPasar;
    private String alamat;
    private String kecamatan;
    private String kabupaten;
    private int isSync;

    public Harga() {
    }

    public Harga(HargaRealm hargaRealm) {
        this.hashId = hargaRealm.getHashId();
        this.hashKomoditas = hargaRealm.getHashKomoditas();
        this.hashPasar = hargaRealm.getHashPasar();
        this.tanggal = hargaRealm.getTanggal();
        this.nilai = hargaRealm.getNilai();
        this.satuan = hargaRealm.getSatuan();
        this.namaPasar = hargaRealm.getNamaPasar();
        this.alamat = hargaRealm.getAlamat();
        this.kecamatan = hargaRealm.getKecamatan();
        this.kabupaten = hargaRealm.getKabupaten();
        this.isSync = hargaRealm.getIsSync();
    }

    public Harga(String hashId, String hashKomoditas, String hashPasar, String tanggal, String nilai, String satuan, String namaPasar, String alamat, String kecamatan, String kabupaten, int isSync) {
        this.hashId = hashId;
        this.hashKomoditas = hashKomoditas;
        this.hashPasar = hashPasar;
        this.tanggal = tanggal;
        this.nilai = nilai;
        this.satuan = satuan;
        this.namaPasar = namaPasar;
        this.alamat = alamat;
        this.kecamatan = kecamatan;
        this.kabupaten = kabupaten;
        this.isSync = isSync;
    }

    protected Harga(Parcel in) {
        hashId = in.readString();
        hashKomoditas = in.readString();
        hashPasar = in.readString();
        tanggal = in.readString();
        nilai = in.readString();
        satuan = in.readString();
        namaPasar = in.readString();
        alamat = in.readString();
        kecamatan = in.readString();
        kabupaten = in.readString();
        isSync = in.readInt();
    }

    public static final Creator<Harga> CREATOR = new Creator<Harga>() {
        @Override
        public Harga createFromParcel(Parcel in) {

            return new Harga(in);
        }

        @Override
        public Harga[] newArray(int size) {
            return new Harga[size];
        }
    };

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getHashKomoditas() {
        return hashKomoditas;
    }

    public void setHashKomoditas(String hashKomoditas) {
        this.hashKomoditas = hashKomoditas;
    }

    public String getHashPasar() {
        return hashPasar;
    }

    public void setHashPasar(String hashPasar) {
        this.hashPasar = hashPasar;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public String getNamaPasar() {
        return namaPasar;
    }

    public void setNamaPasar(String namaPasar) {
        this.namaPasar = namaPasar;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getKabupaten() {
        return kabupaten;
    }

    public void setKabupaten(String kabupaten) {
        this.kabupaten = kabupaten;
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
        if (!(o instanceof Harga)) return false;
        Harga harga = (Harga) o;
        return isSync == harga.isSync &&
                Objects.equals(hashId, harga.hashId) &&
                Objects.equals(hashKomoditas, harga.hashKomoditas) &&
                Objects.equals(hashPasar, harga.hashPasar) &&
                Objects.equals(tanggal, harga.tanggal) &&
                Objects.equals(nilai, harga.nilai) &&
                Objects.equals(satuan, harga.satuan) &&
                Objects.equals(namaPasar, harga.namaPasar) &&
                Objects.equals(alamat, harga.alamat) &&
                Objects.equals(kecamatan, harga.kecamatan) &&
                Objects.equals(kabupaten, harga.kabupaten);
    }

    @Override
    public int hashCode() {

        return Objects.hash(hashId, hashKomoditas, hashPasar, tanggal, nilai, satuan, namaPasar, alamat, kecamatan, kabupaten, isSync);
    }

    @Override
    public String toString() {
        return "Harga{" +
                "hashId='" + hashId + '\'' +
                ", hashKomoditas='" + hashKomoditas + '\'' +
                ", hashPasar='" + hashPasar + '\'' +
                ", tanggal='" + tanggal + '\'' +
                ", nilai='" + nilai + '\'' +
                ", satuan='" + satuan + '\'' +
                ", namaPasar='" + namaPasar + '\'' +
                ", alamat='" + alamat + '\'' +
                ", kecamatan='" + kecamatan + '\'' +
                ", kabupaten='" + kabupaten + '\'' +
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
        parcel.writeString(hashKomoditas);
        parcel.writeString(hashPasar);
        parcel.writeString(tanggal);
        parcel.writeString(nilai);
        parcel.writeString(satuan);
        parcel.writeString(namaPasar);
        parcel.writeString(alamat);
        parcel.writeString(kecamatan);
        parcel.writeString(kabupaten);
        parcel.writeInt(isSync);
    }
}
