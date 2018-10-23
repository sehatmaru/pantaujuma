package teknodesa.devlops.pantaujuma.dependencies.models.pojos;

import android.os.Parcel;
import android.os.Parcelable;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.penduduk.PendudukRealm;

public class PendudukParcelable implements Parcelable {
    private String hashId;
    private String NIK;
    private String foto;
    private String namaDepan;
    private String namaBelakang;
    private String jenisKelamin;
    private String tempatLahir;
    private String tanggalLahir;
    private String agama;
    private String golonganDarah;
    private String pekerjaan;
    private String pendidikan;
    private String alamat;
    private String rt;
    private String rw;
    private String dusun;
    private String desa;
    private String kecamatan;
    private String datiII;
    private String provinsi;
    private String noHP;
    private String noTelp;
    private String status;
    private int kodePos;
    private String email;
    private int idDesa;

    public PendudukParcelable() {
    }

    public PendudukParcelable(String hashId, String NIK, String foto, String namaDepan, String namaBelakang, String jenisKelamin, String tempatLahir, String tanggalLahir, String agama, String golonganDarah, String pekerjaan, String pendidikan, String alamat, String rt, String rw, String dusun, String desa, String kecamatan, String datiII, String provinsi, String noHP, String noTelp) {
        this.hashId = hashId;
        this.NIK = NIK;
        this.foto = foto;
        this.namaDepan = namaDepan;
        this.namaBelakang = namaBelakang;
        this.jenisKelamin = jenisKelamin;
        this.tempatLahir = tempatLahir;
        this.tanggalLahir = tanggalLahir;
        this.agama = agama;
        this.golonganDarah = golonganDarah;
        this.pekerjaan = pekerjaan;
        this.pendidikan = pendidikan;
        this.alamat = alamat;
        this.rt = rt;
        this.rw = rw;
        this.dusun = dusun;
        this.desa = desa;
        this.kecamatan = kecamatan;
        this.datiII = datiII;
        this.provinsi = provinsi;
        this.noHP = noHP;
        this.noTelp = noTelp;
    }
    public PendudukParcelable (PendudukRealm penduduk){
        this.hashId = penduduk.getHashId();
        this.NIK = penduduk.getNIK();
        this.foto = String.valueOf(penduduk.getFoto());
        this.namaDepan = penduduk.getNamaDepan();
        this.namaBelakang = penduduk.getNamaBelakang();
        this.jenisKelamin = penduduk.getJenisKelamin();
        this.tempatLahir = penduduk.getTempatLahir();
        this.tanggalLahir = penduduk.getTanggalLahir();

        this.agama = penduduk.getAgama();
        this.golonganDarah = penduduk.getGolonganDarah();
        this.pekerjaan = penduduk.getPekerjaan();
        this.pendidikan = penduduk.getPendidikan();

        this.alamat = penduduk.getAlamat();
        this.rt = penduduk.getRt();
        this.rw = penduduk.getRw();

        this.dusun = penduduk.getDusun();
        this.desa = penduduk.getDesa();
        this.kecamatan = penduduk.getKecamatan();
        this.datiII = penduduk.getDatiII();
        this.provinsi = penduduk.getProvinsi();

        this.noHP = penduduk.getNoHP();
        this.noTelp = penduduk.getNoTelp();
        this.status = penduduk.getStatus();
        this.kodePos = penduduk.getKodePos();
        this.email = penduduk.getEmail();
        this.idDesa = penduduk.getIdDesa();

    }


    protected PendudukParcelable(Parcel in) {
        hashId = in.readString();
        NIK = in.readString();
        foto = in.readString();
        namaDepan = in.readString();
        namaBelakang = in.readString();
        jenisKelamin = in.readString();
        tempatLahir = in.readString();
        tanggalLahir = in.readString();
        agama = in.readString();
        golonganDarah = in.readString();
        pekerjaan = in.readString();
        pendidikan = in.readString();
        alamat = in.readString();
        rt = in.readString();
        rw = in.readString();
        dusun = in.readString();
        desa = in.readString();
        kecamatan = in.readString();
        datiII = in.readString();
        provinsi = in.readString();
        noHP = in.readString();
        noTelp = in.readString();
        status = in.readString();
        kodePos = in.readInt();
        email = in.readString();
        idDesa = in.readInt();
    }

    public static final Creator<PendudukParcelable> CREATOR = new Creator<PendudukParcelable>() {
        @Override
        public PendudukParcelable createFromParcel(Parcel in) {
            return new PendudukParcelable(in);
        }

        @Override
        public PendudukParcelable[] newArray(int size) {
            return new PendudukParcelable[size];
        }
    };

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getNIK() {
        return NIK;
    }

    public void setNIK(String NIK) {
        this.NIK = NIK;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNamaDepan() {
        return namaDepan;
    }

    public void setNamaDepan(String namaDepan) {
        this.namaDepan = namaDepan;
    }

    public String getNamaBelakang() {
        return namaBelakang;
    }

    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getGolonganDarah() {
        return golonganDarah;
    }

    public void setGolonganDarah(String golonganDarah) {
        this.golonganDarah = golonganDarah;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getPendidikan() {
        return pendidikan;
    }

    public void setPendidikan(String pendidikan) {
        this.pendidikan = pendidikan;
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

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getKodePos() {
        return kodePos;
    }

    public void setKodePos(int kodePos) {
        this.kodePos = kodePos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdDesa() {
        return idDesa;
    }

    public void setIdDesa(int idDesa) {
        this.idDesa = idDesa;
    }

    @Override
    public String toString() {
        return "PendudukParcelable{" +
                "hashId='" + hashId + '\'' +
                ", NIK='" + NIK + '\'' +
                ", foto='" + foto + '\'' +
                ", namaDepan='" + namaDepan + '\'' +
                ", namaBelakang='" + namaBelakang + '\'' +
                ", jenisKelamin='" + jenisKelamin + '\'' +
                ", tempatLahir='" + tempatLahir + '\'' +
                ", tanggalLahir='" + tanggalLahir + '\'' +
                ", agama='" + agama + '\'' +
                ", golonganDarah='" + golonganDarah + '\'' +
                ", pekerjaan='" + pekerjaan + '\'' +
                ", pendidikan='" + pendidikan + '\'' +
                ", alamat='" + alamat + '\'' +
                ", rt='" + rt + '\'' +
                ", rw='" + rw + '\'' +
                ", dusun='" + dusun + '\'' +
                ", desa='" + desa + '\'' +
                ", kecamatan='" + kecamatan + '\'' +
                ", datiII='" + datiII + '\'' +
                ", provinsi='" + provinsi + '\'' +
                ", noHP='" + noHP + '\'' +
                ", noTelp='" + noTelp + '\'' +
                ", status='" + status + '\'' +
                ", kodePos=" + kodePos +
                ", email='" + email + '\'' +
                ", idDesa=" + idDesa +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(hashId);
        parcel.writeString(NIK);
        parcel.writeString(foto);
        parcel.writeString(namaDepan);
        parcel.writeString(namaBelakang);
        parcel.writeString(jenisKelamin);
        parcel.writeString(tempatLahir);
        parcel.writeString(tanggalLahir);
        parcel.writeString(agama);
        parcel.writeString(golonganDarah);
        parcel.writeString(pekerjaan);
        parcel.writeString(pendidikan);
        parcel.writeString(alamat);
        parcel.writeString(rt);
        parcel.writeString(rw);
        parcel.writeString(dusun);
        parcel.writeString(desa);
        parcel.writeString(kecamatan);
        parcel.writeString(datiII);
        parcel.writeString(provinsi);
        parcel.writeString(noHP);
        parcel.writeString(noTelp);
        parcel.writeString(status);
        parcel.writeInt(kodePos);
        parcel.writeString(email);
        parcel.writeInt(idDesa);
    }
}
