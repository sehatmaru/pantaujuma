package teknodesa.devlops.pantaujuma.dependencies.models.realms.rdk;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RDKRealm extends RealmObject {
    @PrimaryKey
    private String hashId;

    private String idUser;
    private String poktan;
    private String irigasi;
    private String intensifikasi;
    private String rencana;
    private String kegiatan;
    private String tanggal;
    private String luasSawah;
    private String keterangan;

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

    private int isSync;
    private int idDesa;

    public RDKRealm() {
    }

    public RDKRealm(RDKRealm data, int isSync) {
        this.hashId = data.getHashId();
        this.idUser = data.getIdUser();
        this.poktan = data.getPoktan();
        this.irigasi = data.getIrigasi();
        this.intensifikasi = data.getIntensifikasi();
        this.rencana = data.getRencana();
        this.kegiatan = data.getKegiatan();
        this.tanggal = data.getTanggal();
        this.luasSawah = data.getLuasSawah();
        this.keterangan = data.getKeterangan();
        this.hashIdIrigasi = data.getHashIdIrigasi();
        this.nama = data.getNama();
        this.deskripsiIrigasi = data.getDeskripsiIrigasi();
        this.hashIdJadwal = data.getHashIdJadwal();
        this.kegiatanJK = data.getKegiatanJK();
        this.tanggalJK = data.getTanggalJK();
        this.deskripsiJK = data.getDeskripsiJK();
        this.hashIdRencana = data.getHashIdRencana();
        this.paketTeknologi = data.getPaketTeknologi();
        this.polaTanam = data.getPolaTanam();
        this.jadwalTanam = data.getJadwalTanam();
        this.komoditasRU = data.getKomoditasRU();
        this.varietas = data.getVarietas();
        this.sumberBenih = data.getSumberBenih();
        this.tabunganAnggota = data.getTabunganAnggota();
        this.iuranAnggota = data.getIuranAnggota();
        this.pemupukanModal = data.getPemupukanModal();
        this.hashIdSasaran = data.getHashIdSasaran();
        this.komoditasSI = data.getKomoditasSI();
        this.target = data.getTarget();
        this.targetHasilPerHa = data.getTargetHasilPerHa();
        this.isSync = isSync;
        this.idDesa = data.getIdDesa();
    }

    public RDKRealm(String hashId, String idUser, String poktan, String irigasi, String intensifikasi, String rencana, String kegiatan, String tanggal, String luasSawah, String keterangan, String hashIdIrigasi, String nama, String deskripsiIrigasi, String hashIdJadwal, String kegiatanJK, String tanggalJK, String deskripsiJK, String hashIdRencana, String paketTeknologi, String polaTanam, String jadwalTanam, String komoditasRU, String varietas, String sumberBenih, String tabunganAnggota, String iuranAnggota, String pemupukanModal, String hashIdSasaran, String komoditasSI, String target, String targetHasilPerHa, int isSync, int idDesa) {
        this.hashId = hashId;
        this.idUser = idUser;
        this.poktan = poktan;
        this.irigasi = irigasi;
        this.intensifikasi = intensifikasi;
        this.rencana = rencana;
        this.kegiatan = kegiatan;
        this.tanggal = tanggal;
        this.luasSawah = luasSawah;
        this.keterangan = keterangan;
        this.hashIdIrigasi = hashIdIrigasi;
        this.nama = nama;
        this.deskripsiIrigasi = deskripsiIrigasi;
        this.hashIdJadwal = hashIdJadwal;
        this.kegiatanJK = kegiatanJK;
        this.tanggalJK = tanggalJK;
        this.deskripsiJK = deskripsiJK;
        this.hashIdRencana = hashIdRencana;
        this.paketTeknologi = paketTeknologi;
        this.polaTanam = polaTanam;
        this.jadwalTanam = jadwalTanam;
        this.komoditasRU = komoditasRU;
        this.varietas = varietas;
        this.sumberBenih = sumberBenih;
        this.tabunganAnggota = tabunganAnggota;
        this.iuranAnggota = iuranAnggota;
        this.pemupukanModal = pemupukanModal;
        this.hashIdSasaran = hashIdSasaran;
        this.komoditasSI = komoditasSI;
        this.target = target;
        this.targetHasilPerHa = targetHasilPerHa;
        this.isSync = isSync;
        this.idDesa = idDesa;
    }

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

    public int getIsSync() {
        return isSync;
    }

    public void setIsSync(int isSync) {
        this.isSync = isSync;
    }

    public int getIdDesa() {
        return idDesa;
    }

    public void setIdDesa(int idDesa) {
        this.idDesa = idDesa;
    }

    @Override
    public String toString() {
        return "RDKRealm{" +
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
                ", isSync=" + isSync +
                ", idDesa=" + idDesa +
                '}';
    }
}