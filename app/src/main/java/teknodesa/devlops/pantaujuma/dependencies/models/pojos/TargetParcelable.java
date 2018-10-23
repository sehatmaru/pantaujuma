package teknodesa.devlops.pantaujuma.dependencies.models.pojos;

import android.os.Parcel;
import android.os.Parcelable;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.petugas.TargetPetugas;

public class TargetParcelable implements Parcelable {
    private String hashId;
    private String idUser;
    private int idDesa;
    private int tahun;
    private String komoditas;
    private float luasTanam;
    private float luasPanen;
    private float sasaranProduksi;
    private float sasaranProduktifitas;
    private String keterangan;

    public TargetParcelable() {

    }

    public TargetParcelable(String hashId, String idUser, int idDesa, int tahun, String komoditas, float luasTanam, float luasPanen, float sasaranProduksi, float sasaranProduktifitas, String keterangan) {
        this.hashId = hashId;
        this.idUser = idUser;
        this.idDesa = idDesa;
        this.tahun = tahun;
        this.komoditas = komoditas;
        this.luasTanam = luasTanam;
        this.luasPanen = luasPanen;
        this.sasaranProduksi = sasaranProduksi;
        this.sasaranProduktifitas = sasaranProduktifitas;
        this.keterangan = keterangan;
    }

    public TargetParcelable(TargetPetugas targetPetugas){
        this.hashId = targetPetugas.getHashId();
        this.idUser = targetPetugas.getIdUser();
        this.idDesa = targetPetugas.getIdDesa();
        this.tahun = targetPetugas.getTahun();
        this.komoditas = targetPetugas.getKomoditas();
        this.luasTanam = targetPetugas.getLuasTanam();
        this.luasPanen = targetPetugas.getLuasPanen();
        this.sasaranProduksi = targetPetugas.getSasaranProduksi();
        this.sasaranProduktifitas = targetPetugas.getSasaranProduktifitas();
        this.keterangan = targetPetugas.getKeterangan();
    }

    protected TargetParcelable(Parcel in) {
        hashId = in.readString();
        idUser = in.readString();
        idDesa = in.readInt();
        tahun = in.readInt();
        komoditas = in.readString();
        luasTanam = in.readFloat();
        luasPanen = in.readFloat();
        sasaranProduksi = in.readFloat();
        sasaranProduktifitas = in.readFloat();
        keterangan = in.readString();
    }

    public static final Creator<TargetParcelable> CREATOR = new Creator<TargetParcelable>() {
        @Override
        public TargetParcelable createFromParcel(Parcel in) {
            return new TargetParcelable(in);
        }

        @Override
        public TargetParcelable[] newArray(int size) {
            return new TargetParcelable[size];
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

    public int getIdDesa() {
        return idDesa;
    }

    public void setIdDesa(int idDesa) {
        this.idDesa = idDesa;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public String getKomoditas() {
        return komoditas;
    }

    public void setKomoditas(String komoditas) {
        this.komoditas = komoditas;
    }

    public float getLuasTanam() {
        return luasTanam;
    }

    public void setLuasTanam(float luasTanam) {
        this.luasTanam = luasTanam;
    }

    public float getLuasPanen() {
        return luasPanen;
    }

    public void setLuasPanen(float luasPanen) {
        this.luasPanen = luasPanen;
    }

    public float getSasaranProduksi() {
        return sasaranProduksi;
    }

    public void setSasaranProduksi(float sasaranProduksi) {
        this.sasaranProduksi = sasaranProduksi;
    }

    public float getSasaranProduktifitas() {
        return sasaranProduktifitas;
    }

    public void setSasaranProduktifitas(float sasaranProduktifitas) {
        this.sasaranProduktifitas = sasaranProduktifitas;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(hashId);
        parcel.writeString(idUser);
        parcel.writeInt(idDesa);
        parcel.writeInt(tahun);
        parcel.writeString(komoditas);
        parcel.writeFloat(luasTanam);
        parcel.writeFloat(luasPanen);
        parcel.writeFloat(sasaranProduksi);
        parcel.writeFloat(sasaranProduktifitas);
        parcel.writeString(keterangan);
    }

    @Override
    public String toString() {
        return "TargetParcelable{" +
                "hashId='" + hashId + '\'' +
                ", idUser='" + idUser + '\'' +
                ", idDesa=" + idDesa +
                ", tahun=" + tahun +
                ", komoditas='" + komoditas + '\'' +
                ", luasTanam=" + luasTanam +
                ", luasPanen=" + luasPanen +
                ", sasaranProduksi=" + sasaranProduksi +
                ", sasaranProduktifitas=" + sasaranProduktifitas +
                ", keterangan='" + keterangan + '\'' +
                '}';
    }
}
