package teknodesa.devlops.pantaujuma.dependencies.models.pojos.petani;

import android.os.Parcel;
import android.os.Parcelable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.petani.PetaniRealm;

public class PetaniParcelable implements Parcelable {
    @PrimaryKey
    private String hashId;
    private String biodata;
    private String deskripsi;
    private String status;
    private String idDesa;
    private String foto;
    private int isSync;

    public PetaniParcelable(PetaniRealm petaniRealm) {
        this.hashId = petaniRealm.getHashId();
        this.biodata = petaniRealm.getBiodata();
        this.deskripsi = petaniRealm.getDeskripsi();
        this.status = petaniRealm.getStatus();
        this.idDesa = petaniRealm.getIdDesa();
        this.foto = petaniRealm.getFoto();
        this.isSync = petaniRealm.getIsSync();
    }

    public PetaniParcelable(String hashId, String biodata, String deskripsi, String status, String idDesa, String foto, int isSync) {
        this.hashId = hashId;
        this.biodata = biodata;
        this.deskripsi = deskripsi;
        this.status = status;
        this.idDesa = idDesa;
        this.foto = foto;
        this.isSync = isSync;
    }

    protected PetaniParcelable(Parcel in) {
        hashId = in.readString();
        biodata = in.readString();
        deskripsi = in.readString();
        status = in.readString();
        idDesa = in.readString();
        foto = in.readString();
        isSync = in.readInt();
    }

    public static final Creator<PetaniParcelable> CREATOR = new Creator<PetaniParcelable>() {
        @Override
        public PetaniParcelable createFromParcel(Parcel in) {
            return new PetaniParcelable(in);
        }

        @Override
        public PetaniParcelable[] newArray(int size) {
            return new PetaniParcelable[size];
        }
    };

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getBiodata() {
        return biodata;
    }

    public void setBiodata(String biodata) {
        this.biodata = biodata;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdDesa() {
        return idDesa;
    }

    public void setIdDesa(String idDesa) {
        this.idDesa = idDesa;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getIsSync() {
        return isSync;
    }

    public void setIsSync(int isSync) {
        this.isSync = isSync;
    }

    @Override
    public String toString() {
        return "PetaniRealm{" +
                "hashId='" + hashId + '\'' +
                ", biodata='" + biodata + '\'' +
                ", deskripsi='" + deskripsi + '\'' +
                ", status='" + status + '\'' +
                ", idDesa='" + idDesa + '\'' +
                ", foto='" + foto + '\'' +
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
        parcel.writeString(biodata);
        parcel.writeString(deskripsi);
        parcel.writeString(status);
        parcel.writeString(idDesa);
        parcel.writeString(foto);
        parcel.writeInt(isSync);
    }
}
