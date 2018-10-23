package teknodesa.devlops.pantaujuma.dependencies.models.pojos;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.AnggotaPoktanRealm;

public class AnggotaPoktan implements Parcelable {
    private String hashId;

    private String poktanAnggota;
    private String petaniAnggota;
    private String tanggalMasuk;
    private String statusAnggota;

    private int idDesa;
    private int isSync;

    public AnggotaPoktan() {
    }

    public AnggotaPoktan(AnggotaPoktanRealm anggotaPoktanRealm) {
        this.hashId = anggotaPoktanRealm.getHashId();
        this.poktanAnggota = anggotaPoktanRealm.getPoktanAnggota();
        this.petaniAnggota = anggotaPoktanRealm.getPetaniAnggota();
        this.tanggalMasuk = anggotaPoktanRealm.getTanggalMasuk();
        this.statusAnggota = anggotaPoktanRealm.getStatusAnggota();
        this.idDesa = anggotaPoktanRealm.getIdDesa();
        this.isSync = anggotaPoktanRealm.getIsSync();
    }

    public AnggotaPoktan(String hashId, String poktanAnggota, String petaniAnggota, String tanggalMasuk, String statusAnggota, int idDesa, int isSync) {
        this.hashId = hashId;
        this.poktanAnggota = poktanAnggota;
        this.petaniAnggota = petaniAnggota;
        this.tanggalMasuk = tanggalMasuk;
        this.statusAnggota = statusAnggota;
        this.idDesa = idDesa;
        this.isSync = isSync;
    }

    protected AnggotaPoktan(Parcel in) {
        hashId = in.readString();
        poktanAnggota = in.readString();
        petaniAnggota = in.readString();
        tanggalMasuk = in.readString();
        statusAnggota = in.readString();
        idDesa = in.readInt();
        isSync = in.readInt();
    }

    public static final Creator<AnggotaPoktan> CREATOR = new Creator<AnggotaPoktan>() {
        @Override
        public AnggotaPoktan createFromParcel(Parcel in) {

            return new AnggotaPoktan(in);
        }

        @Override
        public AnggotaPoktan[] newArray(int size) {
            return new AnggotaPoktan[size];
        }
    };

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getNama() {
        return poktanAnggota;
    }

    public void setNama(String poktanAnggota) {
        this.poktanAnggota = poktanAnggota;
    }

    public String getDesa() {
        return petaniAnggota;
    }

    public void setDesa(String petaniAnggota) {
        this.petaniAnggota = petaniAnggota;
    }

    public String getKecamatan() {
        return tanggalMasuk;
    }

    public void setKecamatan(String tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }

    public String getTanggalDidirikan() {
        return statusAnggota;
    }

    public void setTanggalDidirikan(String statusAnggota) {
        this.statusAnggota = statusAnggota;
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
        if (!(o instanceof AnggotaPoktan)) return false;
        AnggotaPoktan poktan = (AnggotaPoktan) o;
        return idDesa == poktan.idDesa &&
                isSync == poktan.isSync &&
                Objects.equals(hashId, poktan.hashId) &&
                Objects.equals(poktanAnggota, poktan.poktanAnggota) &&
                Objects.equals(petaniAnggota, poktan.petaniAnggota) &&
                Objects.equals(tanggalMasuk, poktan.tanggalMasuk) &&
                Objects.equals(statusAnggota, poktan.statusAnggota);
    }

    @Override
    public int hashCode() {

        return Objects.hash(hashId, poktanAnggota, petaniAnggota, tanggalMasuk, statusAnggota, idDesa, isSync);
    }

    @Override
    public String toString() {
        return "Poktan{" +
                "hashId='" + hashId + '\'' +
                ", poktanAnggota='" + poktanAnggota + '\'' +
                ", petaniAnggota='" + petaniAnggota + '\'' +
                ", tanggalMasuk='" + tanggalMasuk + '\'' +
                ", statusAnggota='" + statusAnggota + '\'' +
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
        parcel.writeString(poktanAnggota);
        parcel.writeString(petaniAnggota);
        parcel.writeString(tanggalMasuk);
        parcel.writeString(statusAnggota);
        parcel.writeInt(idDesa);
        parcel.writeInt(isSync);
    }
}
