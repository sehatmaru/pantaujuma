package teknodesa.devlops.pantaujuma.dependencies.models.pojos.komoditas;

import android.os.Parcel;
import android.os.Parcelable;

import io.realm.annotations.PrimaryKey;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.LahanRealm;

public class LahanParcelable implements Parcelable {
    @PrimaryKey
    private String hashId;

    private String pemilik;
    private String namaPemilikLahan;
    private String alamat;
    private String rt;
    private String rw;
    private String dusun;
    private String desa;
    private String namaKecamatan;
    private String datiII;
    private String provinsi;
    private double longitude;
    private double latitude;
    private String luas;
    private String batasTimur;
    private String batasBarat;
    private String batasSelatan;
    private String batasUtara;
    private String deskripsi;
    private int status;
    private String gambar;

    private int isSync;

    public LahanParcelable(LahanRealm realm) {
        this.hashId = realm.getHashId();
        this.pemilik = realm.getPemilik();
        this.namaPemilikLahan = realm.getNamaPemilikLahan();
        this.alamat = realm.getAlamat();
        this.rt = realm.getRt();
        this.rw = realm.getRw();
        this.dusun = realm.getDusun();
        this.desa = realm.getDesa();
        this.namaKecamatan = realm.getNamaKecamatan();
        this.datiII = realm.getDatiII();
        this.provinsi = realm.getProvinsi();
        this.longitude = realm.getLongitude();
        this.latitude = realm.getLatitude();
        this.luas = realm.getLuas();
        this.batasTimur = realm.getBatasTimur();
        this.batasBarat = realm.getBatasBarat();
        this.batasSelatan = realm.getBatasSelatan();
        this.batasUtara = realm.getBatasUtara();
        this.deskripsi = realm.getDeskripsi();
        this.status = realm.getStatus();
        this.gambar = realm.getGambar();
        this.isSync = realm.getIsSync();
    }

    protected LahanParcelable(Parcel in) {
        hashId = in.readString();
        pemilik = in.readString();
        namaPemilikLahan = in.readString();
        alamat = in.readString();
        rt = in.readString();
        rw = in.readString();
        dusun = in.readString();
        desa = in.readString();
        namaKecamatan = in.readString();
        datiII = in.readString();
        provinsi = in.readString();
        longitude = in.readDouble();
        latitude = in.readDouble();
        luas = in.readString();
        batasTimur = in.readString();
        batasBarat = in.readString();
        batasSelatan = in.readString();
        batasUtara = in.readString();
        deskripsi = in.readString();
        status = in.readInt();
        gambar = in.readString();
        isSync = in.readInt();
    }

    public static final Creator<LahanParcelable> CREATOR = new Creator<LahanParcelable>() {
        @Override
        public LahanParcelable createFromParcel(Parcel in) {
            return new LahanParcelable(in);
        }

        @Override
        public LahanParcelable[] newArray(int size) {
            return new LahanParcelable[size];
        }
    };

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getPemilik() {
        return pemilik;
    }

    public void setPemilik(String pemilik) {
        this.pemilik = pemilik;
    }

    public String getNamaPemilikLahan() {
        return namaPemilikLahan;
    }

    public void setNamaPemilikLahan(String namaPemilikLahan) {
        this.namaPemilikLahan = namaPemilikLahan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getRt() {
        return rt;
    }

    public void setRt(String rt) {
        this.rt = rt;
    }

    public String getRw() {
        return rw;
    }

    public void setRw(String rw) {
        this.rw = rw;
    }

    public String getDusun() {
        return dusun;
    }

    public void setDusun(String dusun) {
        this.dusun = dusun;
    }

    public String getDesa() {
        return desa;
    }

    public void setDesa(String desa) {
        this.desa = desa;
    }

    public String getNamaKecamatan() {
        return namaKecamatan;
    }

    public void setNamaKecamatan(String namaKecamatan) {
        this.namaKecamatan = namaKecamatan;
    }

    public String getDatiII() {
        return datiII;
    }

    public void setDatiII(String datiII) {
        this.datiII = datiII;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getLuas() {
        return luas;
    }

    public void setLuas(String luas) {
        this.luas = luas;
    }

    public String getBatasTimur() {
        return batasTimur;
    }

    public void setBatasTimur(String batasTimur) {
        this.batasTimur = batasTimur;
    }

    public String getBatasBarat() {
        return batasBarat;
    }

    public void setBatasBarat(String batasBarat) {
        this.batasBarat = batasBarat;
    }

    public String getBatasSelatan() {
        return batasSelatan;
    }

    public void setBatasSelatan(String batasSelatan) {
        this.batasSelatan = batasSelatan;
    }

    public String getBatasUtara() {
        return batasUtara;
    }

    public void setBatasUtara(String batasUtara) {
        this.batasUtara = batasUtara;
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

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public int getIsSync() {
        return isSync;
    }

    public void setIsSync(int isSync) {
        this.isSync = isSync;
    }

    @Override
    public String toString() {
        return "LahanParcelable{" +
                "hashId='" + hashId + '\'' +
                ", pemilik='" + pemilik + '\'' +
                ", namaPemilikLahan='" + namaPemilikLahan + '\'' +
                ", alamat='" + alamat + '\'' +
                ", rt='" + rt + '\'' +
                ", rw='" + rw + '\'' +
                ", dusun='" + dusun + '\'' +
                ", desa='" + desa + '\'' +
                ", namaKecamatan='" + namaKecamatan + '\'' +
                ", datiII='" + datiII + '\'' +
                ", provinsi='" + provinsi + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", luas='" + luas + '\'' +
                ", batasTimur='" + batasTimur + '\'' +
                ", batasBarat='" + batasBarat + '\'' +
                ", batasSelatan='" + batasSelatan + '\'' +
                ", batasUtara='" + batasUtara + '\'' +
                ", deskripsi='" + deskripsi + '\'' +
                ", status=" + status +
                ", gambar='" + gambar + '\'' +
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
        parcel.writeString(pemilik);
        parcel.writeString(namaPemilikLahan);
        parcel.writeString(alamat);
        parcel.writeString(rt);
        parcel.writeString(rw);
        parcel.writeString(dusun);
        parcel.writeString(desa);
        parcel.writeString(namaKecamatan);
        parcel.writeString(datiII);
        parcel.writeString(provinsi);
        parcel.writeString(String.valueOf(longitude));
        parcel.writeString(String.valueOf(latitude));
        parcel.writeString(luas);
        parcel.writeString(batasTimur);
        parcel.writeString(batasBarat);
        parcel.writeString(batasSelatan);
        parcel.writeString(batasUtara);
        parcel.writeString(deskripsi);
        parcel.writeString(String.valueOf(status));
        parcel.writeString(gambar);
        parcel.writeInt(isSync);
    }
}
