package teknodesa.devlops.pantaujuma.dependencies.models.realms.petani;

import android.os.Parcel;
import android.os.Parcelable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.PendudukRealm;

public class PetaniRealm extends RealmObject implements Parcelable {
    @PrimaryKey
    private int idPetani;
    private PendudukRealm biodata;
    private String foto;
    private String deskripsi;
    private int status;

    public PetaniRealm() {
    }

    public PetaniRealm(int idPetani, PendudukRealm biodata, String foto, String deskripsi, int status) {
        this.idPetani = idPetani;
        this.biodata = biodata;
        this.foto = foto;
        this.deskripsi = deskripsi;
        this.status = status;
    }

    protected PetaniRealm(Parcel in) {
        idPetani = in.readInt();
        foto = in.readString();
        deskripsi = in.readString();
        status = in.readInt();
    }

    public static final Creator<PetaniRealm> CREATOR = new Creator<PetaniRealm>() {
        @Override
        public PetaniRealm createFromParcel(Parcel in) {
            return new PetaniRealm(in);
        }

        @Override
        public PetaniRealm[] newArray(int size) {
            return new PetaniRealm[size];
        }
    };

    public int getIdPetani() {
        return idPetani;
    }

    public void setIdPetani(int idPetani) {
        this.idPetani = idPetani;
    }

    public PendudukRealm getBiodata() {
        return biodata;
    }

    public void setBiodata(PendudukRealm biodata) {
        this.biodata = biodata;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.idPetani);
        parcel.writeValue(biodata);
        parcel.writeString(foto);
        parcel.writeString(deskripsi);
        parcel.writeInt(status);

    }
}
