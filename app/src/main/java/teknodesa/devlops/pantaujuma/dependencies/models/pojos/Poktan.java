package teknodesa.devlops.pantaujuma.dependencies.models.pojos;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.PoktanRealm;

public class Poktan implements Parcelable {
    private String hashId;

    private String nama;
    private String desa;
    private String kecamatan;
    private String tanggalDidirikan;
    private String alamat;
    private String noHP;
    private String noTelp;
    private String deskripsi;
    private String statusPoktan;

    private int idDesa;
    private int isSync;

    public Poktan() {
    }

    public Poktan(PoktanRealm poktanRealm) {
        this.hashId = poktanRealm.getHashId();
        this.nama = poktanRealm.getNama();
        this.desa = poktanRealm.getDesa();
        this.kecamatan = poktanRealm.getKecamatan();
        this.tanggalDidirikan = poktanRealm.getTanggalDidirikan();
        this.alamat = poktanRealm.getAlamat();
        this.noHP = poktanRealm.getNoHP();
        this.noTelp = poktanRealm.getNoTelp();
        this.deskripsi = poktanRealm.getDeskripsi();
        this.statusPoktan = poktanRealm.getStatusPoktan();
        this.idDesa = poktanRealm.getIdDesa();
        this.isSync = poktanRealm.getIsSync();
    }

    public Poktan(String hashId, String nama, String desa, String kecamatan, String tanggalDidirikan, String alamat, String noHP, String noTelp, String deskripsi, String statusPoktan, int idDesa, int isSync) {
        this.hashId = hashId;
        this.nama = nama;
        this.desa = desa;
        this.kecamatan = kecamatan;
        this.tanggalDidirikan = tanggalDidirikan;
        this.alamat = alamat;
        this.noHP = noHP;
        this.noTelp = noTelp;
        this.deskripsi = deskripsi;
        this.statusPoktan = statusPoktan;
        this.idDesa = idDesa;
        this.isSync = isSync;
    }

    protected Poktan(Parcel in) {
        hashId = in.readString();
        nama = in.readString();
        desa = in.readString();
        kecamatan = in.readString();
        tanggalDidirikan = in.readString();
        alamat = in.readString();
        noHP = in.readString();
        noTelp = in.readString();
        deskripsi = in.readString();
        statusPoktan = in.readString();
        idDesa = in.readInt();
        isSync = in.readInt();
    }

    public static final Creator<Poktan> CREATOR = new Creator<Poktan>() {
        @Override
        public Poktan createFromParcel(Parcel in) {

            return new Poktan(in);
        }

        @Override
        public Poktan[] newArray(int size) {
            return new Poktan[size];
        }
    };

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDesa() {
        return desa;
    }

    public void setDesa(String desa) {
        this.desa = desa;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getTanggalDidirikan() {
        return tanggalDidirikan;
    }

    public void setTanggalDidirikan(String tanggalDidirikan) {
        this.tanggalDidirikan = tanggalDidirikan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoHP() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getStatusPoktan() {
        return statusPoktan;
    }

    public void setStatusPoktan(String statusPoktan) {
        this.statusPoktan = statusPoktan;
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
        if (!(o instanceof Poktan)) return false;
        Poktan poktan = (Poktan) o;
        return idDesa == poktan.idDesa &&
                isSync == poktan.isSync &&
                Objects.equals(hashId, poktan.hashId) &&
                Objects.equals(nama, poktan.nama) &&
                Objects.equals(desa, poktan.desa) &&
                Objects.equals(kecamatan, poktan.kecamatan) &&
                Objects.equals(tanggalDidirikan, poktan.tanggalDidirikan) &&
                Objects.equals(alamat, poktan.alamat) &&
                Objects.equals(noHP, poktan.noHP) &&
                Objects.equals(noTelp, poktan.noTelp) &&
                Objects.equals(deskripsi, poktan.deskripsi) &&
                Objects.equals(statusPoktan, poktan.statusPoktan);
    }

    @Override
    public int hashCode() {

        return Objects.hash(hashId, nama, desa, kecamatan, tanggalDidirikan, alamat, noHP, noTelp, deskripsi, statusPoktan, idDesa, isSync);
    }

    @Override
    public String toString() {
        return "Poktan{" +
                "hashId='" + hashId + '\'' +
                ", nama='" + nama + '\'' +
                ", desa='" + desa + '\'' +
                ", kecamatan='" + kecamatan + '\'' +
                ", tanggalDidirikan='" + tanggalDidirikan + '\'' +
                ", alamat='" + alamat + '\'' +
                ", noHP='" + noHP + '\'' +
                ", noTelp='" + noTelp + '\'' +
                ", deskripsi='" + deskripsi + '\'' +
                ", statusPoktan='" + statusPoktan + '\'' +
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
        parcel.writeString(nama);
        parcel.writeString(desa);
        parcel.writeString(kecamatan);
        parcel.writeString(tanggalDidirikan);
        parcel.writeString(alamat);
        parcel.writeString(noHP);
        parcel.writeString(noTelp);
        parcel.writeString(deskripsi);
        parcel.writeString(statusPoktan);
        parcel.writeInt(idDesa);
        parcel.writeInt(isSync);
    }
}
