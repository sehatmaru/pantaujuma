package teknodesa.devlops.pantaujuma.dependencies.models.pojos;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.PengurusPoktanRealm;

public class PengurusPoktan implements Parcelable {
    private String hashId;

    private String poktanPengurus;
    private String petaniPengurus;
    private String jabatan;
    private String periode;
    private int statusPengurus;

    private int idDesa;
    private int isSync;

    public PengurusPoktan() {
    }

    public PengurusPoktan(PengurusPoktanRealm anggotaPoktanRealm) {
        this.hashId = anggotaPoktanRealm.getHashId();
        this.poktanPengurus = anggotaPoktanRealm.getPoktanPengurus();
        this.petaniPengurus = anggotaPoktanRealm.getPetaniPengurus();
        this.jabatan = anggotaPoktanRealm.getJabatan();
        this.periode = anggotaPoktanRealm.getPeriode();
        this.statusPengurus = anggotaPoktanRealm.getStatusPengurus();
        this.idDesa = anggotaPoktanRealm.getIdDesa();
        this.isSync = anggotaPoktanRealm.getIsSync();
    }

    protected PengurusPoktan(Parcel in) {
        hashId = in.readString();
        poktanPengurus = in.readString();
        petaniPengurus = in.readString();
        jabatan = in.readString();
        periode = in.readString();
        statusPengurus = in.readInt();
        idDesa = in.readInt();
        isSync = in.readInt();
    }

    public static final Creator<PengurusPoktan> CREATOR = new Creator<PengurusPoktan>() {
        @Override
        public PengurusPoktan createFromParcel(Parcel in) {

            return new PengurusPoktan(in);
        }

        @Override
        public PengurusPoktan[] newArray(int size) {
            return new PengurusPoktan[size];
        }
    };

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getPoktanPengurus() {
        return poktanPengurus;
    }

    public void setPoktanPengurus(String poktanPengurus) {
        this.poktanPengurus = poktanPengurus;
    }

    public String getPetaniPengurus() {
        return petaniPengurus;
    }

    public void setPetaniPengurus(String petaniPengurus) {
        this.petaniPengurus = petaniPengurus;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public int getStatusPengurus() {
        return statusPengurus;
    }

    public void setStatusPengurus(int statusPengurus) {
        this.statusPengurus = statusPengurus;
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
        if (!(o instanceof PengurusPoktan)) return false;
        PengurusPoktan poktan = (PengurusPoktan) o;
        return idDesa == poktan.idDesa &&
                isSync == poktan.isSync &&
                Objects.equals(hashId, poktan.hashId) &&
                Objects.equals(poktanPengurus, poktan.poktanPengurus) &&
                Objects.equals(petaniPengurus, poktan.petaniPengurus) &&
                Objects.equals(jabatan, poktan.jabatan) &&
                Objects.equals(periode, poktan.periode) &&
                Objects.equals(statusPengurus, poktan.statusPengurus);
    }

    @Override
    public int hashCode() {

        return Objects.hash(hashId, poktanPengurus, petaniPengurus, jabatan, periode, statusPengurus, idDesa, isSync);
    }

    @Override
    public String toString() {
        return "PengurusPoktan{" +
                "hashId='" + hashId + '\'' +
                ", poktanPengurus='" + poktanPengurus + '\'' +
                ", petaniPengurus='" + petaniPengurus + '\'' +
                ", jabatan='" + jabatan + '\'' +
                ", periode='" + periode + '\'' +
                ", statusPengurus='" + statusPengurus + '\'' +
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
        parcel.writeString(poktanPengurus);
        parcel.writeString(petaniPengurus);
        parcel.writeString(jabatan);
        parcel.writeString(periode);
        parcel.writeInt(statusPengurus);
        parcel.writeInt(idDesa);
        parcel.writeInt(isSync);
    }
}
