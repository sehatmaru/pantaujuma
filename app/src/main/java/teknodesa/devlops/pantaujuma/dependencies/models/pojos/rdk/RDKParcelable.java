package teknodesa.devlops.pantaujuma.dependencies.models.pojos.rdk;

import android.os.Parcel;
import android.os.Parcelable;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.rdk.RDKRealm;

public class RDKParcelable implements Parcelable{
    private String hashId;

    private String idUser;
    private String poktan;
    private String irigasi;
    private String intensifikasi;
    private String rencana;
    private String kegiatan;
    private String tanggal;
    private String luasSawah;
    private String 	keterangan;

    //Irigasi
    private String hashIdIrigasi;
    private String nama;
    private String deskripsiIrigasi;

    // Jadwal Kegiatan
    private String hashIdJadwal;
    private String kegiatanJK;
    private String tanggalJK;
    private String deskripsiJK;

    //Rencana Umum
    private String hashIdRencana;
    private String paketTeknologi;
    private String polaTanam;
    private String jadwalTanam;
    private String komoditasRU;
    private String varietas;
    private String sumberBenih;
    private String tabunganAnggota;
    private String iuranAnggota;
    private String pemupukanModal;

    //Sasaran Intensifikasi
    private String hashIdSasaran;
    private String komoditasSI;
    private String target;
    private String targetHasilPerHa;

    private int idDesa;

    public RDKParcelable(RDKRealm realm) {
        this.hashId = realm.getHashId();
        this.idUser = realm.getIdUser();
        this.poktan = realm.getPoktan();
        this.irigasi = realm.getIrigasi();
        this.intensifikasi = realm.getIntensifikasi();
        this.rencana = realm.getRencana();
        this.kegiatan = realm.getKegiatan();
        this.tanggal = realm.getTanggal();
        this.luasSawah = realm.getLuasSawah();
        this.keterangan = realm.getKeterangan();
        this.hashIdIrigasi = realm.getHashIdIrigasi();
        this.nama = realm.getNama();
        this.deskripsiIrigasi = realm.getDeskripsiIrigasi();
        this.hashIdJadwal = realm.getHashIdJadwal();
        this.kegiatanJK = realm.getKegiatanJK();
        this.tanggalJK = realm.getTanggalJK();
        this.deskripsiJK = realm.getDeskripsiJK();
        this.hashIdRencana = realm.getHashIdRencana();
        this.paketTeknologi = realm.getPaketTeknologi();
        this.polaTanam = realm.getPolaTanam();
        this.jadwalTanam = realm.getJadwalTanam();
        this.komoditasRU = realm.getKomoditasRU();
        this.varietas = realm.getVarietas();
        this.sumberBenih = realm.getSumberBenih();
        this.tabunganAnggota = realm.getTabunganAnggota();
        this.iuranAnggota = realm.getIuranAnggota();
        this.pemupukanModal = realm.getPemupukanModal();
        this.hashIdSasaran = realm.getHashIdSasaran();
        this.komoditasSI = realm.getKomoditasSI();
        this.target = realm.getTarget();
        this.targetHasilPerHa = realm.getTargetHasilPerHa();
        this.idDesa = realm.getIdDesa();
    }

    protected RDKParcelable(Parcel in) {
        hashId = in.readString();
        idUser = in.readString();
        poktan = in.readString();
        irigasi = in.readString();
        intensifikasi = in.readString();
        rencana = in.readString();
        kegiatan = in.readString();
        tanggal = in.readString();
        luasSawah = in.readString();
        keterangan = in.readString();
        hashIdIrigasi = in.readString();
        nama = in.readString();
        deskripsiIrigasi = in.readString();
        hashIdJadwal = in.readString();
        kegiatanJK = in.readString();
        tanggalJK = in.readString();
        deskripsiJK = in.readString();
        hashIdRencana = in.readString();
        paketTeknologi = in.readString();
        polaTanam = in.readString();
        jadwalTanam = in.readString();
        komoditasRU = in.readString();
        varietas = in.readString();
        sumberBenih = in.readString();
        tabunganAnggota = in.readString();
        iuranAnggota = in.readString();
        pemupukanModal = in.readString();
        hashIdSasaran = in.readString();
        komoditasSI = in.readString();
        target = in.readString();
        targetHasilPerHa = in.readString();
        idDesa = in.readInt();
    }

    public static final Creator<RDKParcelable> CREATOR = new Creator<RDKParcelable>() {
        @Override
        public RDKParcelable createFromParcel(Parcel in) {
            return new RDKParcelable(in);
        }

        @Override
        public RDKParcelable[] newArray(int size) {
            return new RDKParcelable[size];
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

    public String getPoktan() {
        return poktan;
    }

    public void setPoktan(String poktan) {
        this.poktan = poktan;
    }

    public String getIrigasi() {
        return irigasi;
    }

    public void setIrigasi(String irigasi) {
        this.irigasi = irigasi;
    }

    public String getIntensifikasi() {
        return intensifikasi;
    }

    public void setIntensifikasi(String intensifikasi) {
        this.intensifikasi = intensifikasi;
    }

    public String getRencana() {
        return rencana;
    }

    public void setRencana(String rencana) {
        this.rencana = rencana;
    }

    public String getKegiatan() {
        return kegiatan;
    }

    public void setKegiatan(String kegiatan) {
        this.kegiatan = kegiatan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getLuasSawah() {
        return luasSawah;
    }

    public void setLuasSawah(String luasSawah) {
        this.luasSawah = luasSawah;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getHashIdIrigasi() {
        return hashIdIrigasi;
    }

    public void setHashIdIrigasi(String hashIdIrigasi) {
        this.hashIdIrigasi = hashIdIrigasi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsiIrigasi() {
        return deskripsiIrigasi;
    }

    public void setDeskripsiIrigasi(String deskripsiIrigasi) {
        this.deskripsiIrigasi = deskripsiIrigasi;
    }

    public String getHashIdJadwal() {
        return hashIdJadwal;
    }

    public void setHashIdJadwal(String hashIdJadwal) {
        this.hashIdJadwal = hashIdJadwal;
    }

    public String getKegiatanJK() {
        return kegiatanJK;
    }

    public void setKegiatanJK(String kegiatanJK) {
        this.kegiatanJK = kegiatanJK;
    }

    public String getTanggalJK() {
        return tanggalJK;
    }

    public void setTanggalJK(String tanggalJK) {
        this.tanggalJK = tanggalJK;
    }

    public String getDeskripsiJK() {
        return deskripsiJK;
    }

    public void setDeskripsiJK(String deskripsiJK) {
        this.deskripsiJK = deskripsiJK;
    }

    public String getHashIdRencana() {
        return hashIdRencana;
    }

    public void setHashIdRencana(String hashIdRencana) {
        this.hashIdRencana = hashIdRencana;
    }

    public String getPaketTeknologi() {
        return paketTeknologi;
    }

    public void setPaketTeknologi(String paketTeknologi) {
        this.paketTeknologi = paketTeknologi;
    }

    public String getPolaTanam() {
        return polaTanam;
    }

    public void setPolaTanam(String polaTanam) {
        this.polaTanam = polaTanam;
    }

    public String getJadwalTanam() {
        return jadwalTanam;
    }

    public void setJadwalTanam(String jadwalTanam) {
        this.jadwalTanam = jadwalTanam;
    }

    public String getKomoditasRU() {
        return komoditasRU;
    }

    public void setKomoditasRU(String komoditasRU) {
        this.komoditasRU = komoditasRU;
    }

    public String getVarietas() {
        return varietas;
    }

    public void setVarietas(String varietas) {
        this.varietas = varietas;
    }

    public String getSumberBenih() {
        return sumberBenih;
    }

    public void setSumberBenih(String sumberBenih) {
        this.sumberBenih = sumberBenih;
    }

    public String getTabunganAnggota() {
        return tabunganAnggota;
    }

    public void setTabunganAnggota(String tabunganAnggota) {
        this.tabunganAnggota = tabunganAnggota;
    }

    public String getIuranAnggota() {
        return iuranAnggota;
    }

    public void setIuranAnggota(String iuranAnggota) {
        this.iuranAnggota = iuranAnggota;
    }

    public String getPemupukanModal() {
        return pemupukanModal;
    }

    public void setPemupukanModal(String pemupukanModal) {
        this.pemupukanModal = pemupukanModal;
    }

    public String getHashIdSasaran() {
        return hashIdSasaran;
    }

    public void setHashIdSasaran(String hashIdSasaran) {
        this.hashIdSasaran = hashIdSasaran;
    }

    public String getKomoditasSI() {
        return komoditasSI;
    }

    public void setKomoditasSI(String komoditasSI) {
        this.komoditasSI = komoditasSI;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getTargetHasilPerHa() {
        return targetHasilPerHa;
    }

    public void setTargetHasilPerHa(String targetHasilPerHa) {
        this.targetHasilPerHa = targetHasilPerHa;
    }

    public int getIdDesa() {
        return idDesa;
    }

    public void setIdDesa(int idDesa) {
        this.idDesa = idDesa;
    }

    @Override
    public String toString() {
        return "RDKParcelable{" +
                "hashId='" + hashId + '\'' +
                ", idUser='" + idUser + '\'' +
                ", poktan='" + poktan + '\'' +
                ", irigasi='" + irigasi + '\'' +
                ", intensifikasi='" + intensifikasi + '\'' +
                ", rencana='" + rencana + '\'' +
                ", kegiatan='" + kegiatan + '\'' +
                ", tanggal='" + tanggal + '\'' +
                ", luasSawah='" + luasSawah + '\'' +
                ", keterangan='" + keterangan + '\'' +
                ", hashIdIrigasi='" + hashIdIrigasi + '\'' +
                ", nama='" + nama + '\'' +
                ", deskripsiIrigasi='" + deskripsiIrigasi + '\'' +
                ", hashIdJadwal='" + hashIdJadwal + '\'' +
                ", kegiatanJK='" + kegiatanJK + '\'' +
                ", tanggalJK='" + tanggalJK + '\'' +
                ", deskripsiJK='" + deskripsiJK + '\'' +
                ", hashIdRencana='" + hashIdRencana + '\'' +
                ", paketTeknologi='" + paketTeknologi + '\'' +
                ", polaTanam='" + polaTanam + '\'' +
                ", jadwalTanam='" + jadwalTanam + '\'' +
                ", komoditasRU='" + komoditasRU + '\'' +
                ", varietas='" + varietas + '\'' +
                ", sumberBenih='" + sumberBenih + '\'' +
                ", tabunganAnggota='" + tabunganAnggota + '\'' +
                ", iuranAnggota='" + iuranAnggota + '\'' +
                ", pemupukanModal='" + pemupukanModal + '\'' +
                ", hashIdSasaran='" + hashIdSasaran + '\'' +
                ", komoditasSI='" + komoditasSI + '\'' +
                ", target='" + target + '\'' +
                ", targetHasilPerHa='" + targetHasilPerHa + '\'' +
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
        parcel.writeString(idUser);
        parcel.writeString(poktan);
        parcel.writeString(irigasi);
        parcel.writeString(intensifikasi);
        parcel.writeString(rencana);
        parcel.writeString(kegiatan);
        parcel.writeString(tanggal);
        parcel.writeString(luasSawah);
        parcel.writeString(keterangan);
        parcel.writeString(hashIdIrigasi);
        parcel.writeString(nama);
        parcel.writeString(deskripsiIrigasi);
        parcel.writeString(hashIdJadwal);
        parcel.writeString(kegiatanJK);
        parcel.writeString(tanggalJK);
        parcel.writeString(deskripsiJK);
        parcel.writeString(hashIdRencana);
        parcel.writeString(paketTeknologi);
        parcel.writeString(polaTanam);
        parcel.writeString(jadwalTanam);
        parcel.writeString(komoditasRU);
        parcel.writeString(varietas);
        parcel.writeString(sumberBenih);
        parcel.writeString(tabunganAnggota);
        parcel.writeString(iuranAnggota);
        parcel.writeString(pemupukanModal);
        parcel.writeString(hashIdSasaran);
        parcel.writeString(komoditasSI);
        parcel.writeString(target);
        parcel.writeString(targetHasilPerHa);
        parcel.writeInt(idDesa);
    }
}