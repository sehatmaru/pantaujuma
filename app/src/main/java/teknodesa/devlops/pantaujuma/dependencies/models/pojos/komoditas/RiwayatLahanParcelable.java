package teknodesa.devlops.pantaujuma.dependencies.models.pojos.komoditas;

import android.os.Parcel;
import android.os.Parcelable;

import io.realm.annotations.PrimaryKey;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.LahanRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.RiwayatLahanRealm;

public class RiwayatLahanParcelable implements Parcelable {
    @PrimaryKey
    private String hashId;

    private String idKomoditas;
    private int idDesa;
    private String idLahan;
    private String namaPemilikLahan;
    private String alamat;
    private String tanggalMulai;
    private String tanggalAkhir;
    private String masaKegiatan;
    private String gambar;
    private String cara;
    private int luas;
    private int hasil;
    private int jumlah;
    private String sumber;
    private String pupuk;
    private int jumlahPupuk;
    private double longitude;
    private double latitude;

    private int isSync;

    public RiwayatLahanParcelable(RiwayatLahanRealm realm) {
        this.hashId = realm.getHashId();
        this.idDesa = realm.getIdDesa();
        this.idKomoditas = realm.getIdKomoditas();
        this.idLahan = realm.getIdLahan();
        this.namaPemilikLahan = realm.getNamaPemilikLahan();
        this.alamat = realm.getAlamat();
        this.tanggalMulai = realm.getTanggalMulai();
        this.tanggalAkhir = realm.getTanggalAkhir();
        this.masaKegiatan = realm.getMasaKegiatan();
        this.gambar = realm.getGambar();
        this.cara = realm.getCara();
        this.luas = realm.getLuas();
        this.hasil = realm.getHasil();
        this.jumlah = realm.getJumlah();
        this.sumber = realm.getSumber();
        this.jumlahPupuk = realm.getJumlahPupuk();
        this.longitude = realm.getLongitude();
        this.latitude = realm.getLatitude();
        this.isSync = realm.getIsSync();
    }

    protected RiwayatLahanParcelable(Parcel in) {
        hashId = in.readString();
        idDesa = in.readInt();
        idKomoditas = in.readString();
        idLahan = in.readString();
        namaPemilikLahan = in.readString();
        alamat = in.readString();
        tanggalMulai = in.readString();
        tanggalAkhir = in.readString();
        masaKegiatan = in.readString();
        gambar = in.readString();
        cara = in.readString();
        luas = in.readInt();
        hasil = in.readInt();
        jumlah = in.readInt();
        sumber = in.readString();
        jumlahPupuk = in.readInt();
        longitude = in.readDouble();
        latitude = in.readDouble();
        isSync = in.readInt();
    }

    public static final Creator<RiwayatLahanParcelable> CREATOR = new Creator<RiwayatLahanParcelable>() {
        @Override
        public RiwayatLahanParcelable createFromParcel(Parcel in) {
            return new RiwayatLahanParcelable(in);
        }

        @Override
        public RiwayatLahanParcelable[] newArray(int size) {
            return new RiwayatLahanParcelable[size];
        }
    };

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getIdKomoditas() {
        return idKomoditas;
    }

    public void setIdKomoditas(String idKomoditas) {
        this.idKomoditas = idKomoditas;
    }

    public int getIdDesa() {
        return idDesa;
    }

    public void setIdDesa(int idDesa) {
        this.idDesa = idDesa;
    }

    public String getIdLahan() {
        return idLahan;
    }

    public void setIdLahan(String idLahan) {
        this.idLahan = idLahan;
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

    public String getTanggalMulai() {
        return tanggalMulai;
    }

    public void setTanggalMulai(String tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
    }

    public String getTanggalAkhir() {
        return tanggalAkhir;
    }

    public void setTanggalAkhir(String tanggalAkhir) {
        this.tanggalAkhir = tanggalAkhir;
    }

    public String getMasaKegiatan() {
        return masaKegiatan;
    }

    public void setMasaKegiatan(String masaKegiatan) {
        this.masaKegiatan = masaKegiatan;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getCara() {
        return cara;
    }

    public void setCara(String cara) {
        this.cara = cara;
    }

    public int getLuas() {
        return luas;
    }

    public void setLuas(int luas) {
        this.luas = luas;
    }

    public int getHasil() {
        return hasil;
    }

    public void setHasil(int hasil) {
        this.hasil = hasil;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getSumber() {
        return sumber;
    }

    public void setSumber(String sumber) {
        this.sumber = sumber;
    }

    public String getPupuk() {
        return pupuk;
    }

    public void setPupuk(String pupuk) {
        this.pupuk = pupuk;
    }

    public int getJumlahPupuk() {
        return jumlahPupuk;
    }

    public void setJumlahPupuk(int jumlahPupuk) {
        this.jumlahPupuk = jumlahPupuk;
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

    public int getIsSync() {
        return isSync;
    }

    public void setIsSync(int isSync) {
        this.isSync = isSync;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(hashId);
        parcel.writeString(idKomoditas);
        parcel.writeInt(idDesa);
        parcel.writeString(idLahan);
        parcel.writeString(namaPemilikLahan);
        parcel.writeString(alamat);
        parcel.writeString(tanggalMulai);
        parcel.writeString(tanggalAkhir);
        parcel.writeString(masaKegiatan);
        parcel.writeString(gambar);
        parcel.writeString(cara);
        parcel.writeInt(luas);
        parcel.writeInt(hasil);
        parcel.writeInt(jumlah);
        parcel.writeString(sumber);
        parcel.writeString(pupuk);
        parcel.writeInt(jumlahPupuk);
        parcel.writeDouble(longitude);
        parcel.writeDouble(latitude);
        parcel.writeInt(isSync);
    }
}
