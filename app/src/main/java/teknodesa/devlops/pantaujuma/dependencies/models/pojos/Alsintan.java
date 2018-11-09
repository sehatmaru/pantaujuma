package teknodesa.devlops.pantaujuma.dependencies.models.pojos;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.alsintan.AlsintanRealm;

public class Alsintan implements Parcelable {
    private String hashId;
    private String namaAlat;
    private String deskripsi;
    private String gambar;
    private int idDesa;
    private int isSync;

    public Alsintan() {
    }

    public Alsintan(AlsintanRealm alsintanRealm) {
        this.hashId = alsintanRealm.getHashId();
        this.namaAlat = alsintanRealm.getNamaAlat();
        this.deskripsi = alsintanRealm.getDeskripsi();
        this.gambar = alsintanRealm.getGambar();
        this.idDesa = alsintanRealm.getIdDesa();
        this.isSync = alsintanRealm.getIsSync();
    }

    public Alsintan(String hashId, String namaAlat, String deskripsi, String gambar, int idDesa, int isSync) {
        this.hashId = hashId;
        this.namaAlat = namaAlat;
        this.deskripsi = deskripsi;
        this.gambar = gambar;
        this.idDesa = idDesa;
        this.isSync = isSync;
    }

    protected Alsintan(Parcel in) {
        hashId = in.readString();
        namaAlat = in.readString();
        deskripsi = in.readString();
        gambar = in.readString();
        idDesa = in.readInt();
        isSync = in.readInt();
    }

    public static final Creator<Alsintan> CREATOR = new Creator<Alsintan>() {
        @Override
        public Alsintan createFromParcel(Parcel in) {

            return new Alsintan(in);
        }

        @Override
        public Alsintan[] newArray(int size) {
            return new Alsintan[size];
        }
    };

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getNamaAlat() {
        return namaAlat;
    }

    public void setNamaAlat(String namaAlat) {
        this.namaAlat = namaAlat;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
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
        if (!(o instanceof Alsintan)) return false;
        Alsintan alsintan = (Alsintan) o;
        return isSync == alsintan.isSync &&
                Objects.equals(hashId, alsintan.hashId) &&
                Objects.equals(namaAlat, alsintan.namaAlat) &&
                Objects.equals(deskripsi, alsintan.deskripsi) &&
                Objects.equals(gambar, alsintan.gambar) &&
                Objects.equals(idDesa, alsintan.idDesa);
    }

    @Override
    public int hashCode() {

        return Objects.hash(hashId, namaAlat, deskripsi, gambar, idDesa, isSync);
    }

    @Override
    public String toString() {
        return "Alsintan{" +
                "hashId='" + hashId + '\'' +
                ", namaAlat='" + namaAlat + '\'' +
                ", deskripsi='" + deskripsi + '\'' +
                ", gambar='" + gambar + '\'' +
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
        parcel.writeString(namaAlat);
        parcel.writeString(deskripsi);
        parcel.writeString(gambar);
        parcel.writeInt(idDesa);
        parcel.writeInt(isSync);
    }
}
