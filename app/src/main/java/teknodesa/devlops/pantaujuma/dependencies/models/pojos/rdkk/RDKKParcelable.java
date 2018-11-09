package teknodesa.devlops.pantaujuma.dependencies.models.pojos.rdkk;

import android.os.Parcel;
import android.os.Parcelable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.rdkk.RDKKPupukSubsidiRealm;

public class RDKKParcelable implements Parcelable {
    @PrimaryKey
    private String hashId;
    private int idDesa;
    private String idUser;
    private String poktan;
    private String petani;
    private String komoditas;
    private String pupuk;
    private int butuhJanuari;
    private int butuhFebruari;
    private int butuhMaret;
    private int butuhApril;
    private int butuhMei;
    private int butuhJuni;
    private int butuhJuli;
    private int butuhAgustus;
    private int butuhSeptember;
    private int butuhOktober;
    private int butuhNovember;
    private int butuhDesember;
    private int isSync;

    public RDKKParcelable() {
    }

    public RDKKParcelable(RDKKPupukSubsidiRealm rdkkPupukSubsidiRealm) {
        this.hashId = rdkkPupukSubsidiRealm.getHashId();
        this.idDesa = rdkkPupukSubsidiRealm.getIdDesa();
        this.idUser = rdkkPupukSubsidiRealm.getIdUser();
        this.poktan = rdkkPupukSubsidiRealm.getPoktan();
        this.petani = rdkkPupukSubsidiRealm.getPetani();
        this.komoditas = rdkkPupukSubsidiRealm.getKomoditas();
        this.pupuk = rdkkPupukSubsidiRealm.getPupuk();
        this.butuhJanuari = rdkkPupukSubsidiRealm.getButuhJanuari();
        this.butuhFebruari = rdkkPupukSubsidiRealm.getButuhFebruari();
        this.butuhMaret = rdkkPupukSubsidiRealm.getButuhMaret();
        this.butuhApril = rdkkPupukSubsidiRealm.getButuhApril();
        this.butuhMei = rdkkPupukSubsidiRealm.getButuhMei();
        this.butuhJuni = rdkkPupukSubsidiRealm.getButuhJuni();
        this.butuhJuli = rdkkPupukSubsidiRealm.getButuhJuli();
        this.butuhAgustus = rdkkPupukSubsidiRealm.getButuhAgustus();
        this.butuhSeptember = rdkkPupukSubsidiRealm.getButuhSeptember();
        this.butuhOktober = rdkkPupukSubsidiRealm.getButuhOktober();
        this.butuhNovember = rdkkPupukSubsidiRealm.getButuhNovember();
        this.butuhDesember = rdkkPupukSubsidiRealm.getButuhDesember();
        this.isSync = rdkkPupukSubsidiRealm.getIsSync();
    }

    protected RDKKParcelable(Parcel in) {
        hashId = in.readString();
        idDesa = in.readInt();
        idUser = in.readString();
        poktan = in.readString();
        petani = in.readString();
        komoditas = in.readString();
        pupuk = in.readString();
        butuhJanuari = in.readInt();
        butuhFebruari = in.readInt();
        butuhMaret = in.readInt();
        butuhApril = in.readInt();
        butuhMei = in.readInt();
        butuhJuni = in.readInt();
        butuhJuli = in.readInt();
        butuhAgustus = in.readInt();
        butuhSeptember = in.readInt();
        butuhOktober = in.readInt();
        butuhNovember = in.readInt();
        butuhDesember = in.readInt();
        isSync = in.readInt();
    }

    public static final Creator<RDKKParcelable> CREATOR = new Creator<RDKKParcelable>() {
        @Override
        public RDKKParcelable createFromParcel(Parcel in) {
            return new RDKKParcelable(in);
        }

        @Override
        public RDKKParcelable[] newArray(int size) {
            return new RDKKParcelable[size];
        }
    };

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public int getIdDesa() {
        return idDesa;
    }

    public void setIdDesa(int idDesa) {
        this.idDesa = idDesa;
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

    public String getPetani() {
        return petani;
    }

    public void setPetani(String petani) {
        this.petani = petani;
    }

    public String getKomoditas() {
        return komoditas;
    }

    public void setKomoditas(String komoditas) {
        this.komoditas = komoditas;
    }

    public String getPupuk() {
        return pupuk;
    }

    public void setPupuk(String pupuk) {
        this.pupuk = pupuk;
    }

    public int getButuhJanuari() {
        return butuhJanuari;
    }

    public void setButuhJanuari(int butuhJanuari) {
        this.butuhJanuari = butuhJanuari;
    }

    public int getButuhFebruari() {
        return butuhFebruari;
    }

    public void setButuhFebruari(int butuhFebruari) {
        this.butuhFebruari = butuhFebruari;
    }

    public int getButuhMaret() {
        return butuhMaret;
    }

    public void setButuhMaret(int butuhMaret) {
        this.butuhMaret = butuhMaret;
    }

    public int getButuhApril() {
        return butuhApril;
    }

    public void setButuhApril(int butuhApril) {
        this.butuhApril = butuhApril;
    }

    public int getButuhMei() {
        return butuhMei;
    }

    public void setButuhMei(int butuhMei) {
        this.butuhMei = butuhMei;
    }

    public int getButuhJuni() {
        return butuhJuni;
    }

    public void setButuhJuni(int butuhJuni) {
        this.butuhJuni = butuhJuni;
    }

    public int getButuhJuli() {
        return butuhJuli;
    }

    public void setButuhJuli(int butuhJuli) {
        this.butuhJuli = butuhJuli;
    }

    public int getButuhAgustus() {
        return butuhAgustus;
    }

    public void setButuhAgustus(int butuhAgustus) {
        this.butuhAgustus = butuhAgustus;
    }

    public int getButuhSeptember() {
        return butuhSeptember;
    }

    public void setButuhSeptember(int butuhSeptember) {
        this.butuhSeptember = butuhSeptember;
    }

    public int getButuhOktober() {
        return butuhOktober;
    }

    public void setButuhOktober(int butuhOktober) {
        this.butuhOktober = butuhOktober;
    }

    public int getButuhNovember() {
        return butuhNovember;
    }

    public void setButuhNovember(int butuhNovember) {
        this.butuhNovember = butuhNovember;
    }

    public int getButuhDesember() {
        return butuhDesember;
    }

    public void setButuhDesember(int butuhDesember) {
        this.butuhDesember = butuhDesember;
    }

    public int getIsSync() {
        return isSync;
    }

    public void setIsSync(int isSync) {
        this.isSync = isSync;
    }

    @Override
    public String toString() {
        return "RDKKPupukSubsidiRealm{" +
                "hashId='" + hashId + '\'' +
                ", idDesa=" + idDesa +
                ", idUser='" + idUser + '\'' +
                ", poktan='" + poktan + '\'' +
                ", petani='" + petani + '\'' +
                ", komoditas='" + komoditas + '\'' +
                ", pupuk='" + pupuk + '\'' +
                ", butuhJanuari=" + butuhJanuari +
                ", butuhFebruari=" + butuhFebruari +
                ", butuhMaret=" + butuhMaret +
                ", butuhApril=" + butuhApril +
                ", butuhMei=" + butuhMei +
                ", butuhJuni=" + butuhJuni +
                ", butuhJuli=" + butuhJuli +
                ", butuhAgustus=" + butuhAgustus +
                ", butuhSeptember=" + butuhSeptember +
                ", butuhOktober=" + butuhOktober +
                ", butuhNovember=" + butuhNovember +
                ", butuhDesember=" + butuhDesember +
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
        parcel.writeInt(idDesa);
        parcel.writeString(idUser);
        parcel.writeString(poktan);
        parcel.writeString(petani);
        parcel.writeString(komoditas);
        parcel.writeString(pupuk);
        parcel.writeInt(butuhJanuari);
        parcel.writeInt(butuhFebruari);
        parcel.writeInt(butuhMaret);
        parcel.writeInt(butuhApril);
        parcel.writeInt(butuhMei);
        parcel.writeInt(butuhJuni);
        parcel.writeInt(butuhJuli);
        parcel.writeInt(butuhAgustus);
        parcel.writeInt(butuhSeptember);
        parcel.writeInt(butuhOktober);
        parcel.writeInt(butuhNovember);
        parcel.writeInt(butuhDesember);
        parcel.writeInt(isSync);
    }
}
