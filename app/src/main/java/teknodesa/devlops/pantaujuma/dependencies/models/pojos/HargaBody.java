package teknodesa.devlops.pantaujuma.dependencies.models.pojos;

public class HargaBody {
    private String hashId;
    private String hashKomoditas;
    private String hashPasar;
    private String tanggal;
    private String nilai;
    private String satuan;
    private String namaPasar;
    private String alamat;
    private String kecamatan;
    private String kabupaten;

    public HargaBody() {
    }

    public HargaBody(String hashId, String hashKomoditas, String hashPasar, String tanggal, String nilai, String satuan, String namaPasar, String alamat, String kecamatan, String kabupaten) {
        this.hashId = hashId;
        this.hashKomoditas = hashKomoditas;
        this.hashPasar = hashPasar;
        this.tanggal = tanggal;
        this.nilai = nilai;
        this.satuan = satuan;
        this.namaPasar = namaPasar;
        this.alamat = alamat;
        this.kecamatan = kecamatan;
        this.kabupaten = kabupaten;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getHashKomoditas() {
        return hashKomoditas;
    }

    public void setHashKomoditas(String hashKomoditas) {
        this.hashKomoditas = hashKomoditas;
    }

    public String getHashPasar() {
        return hashPasar;
    }

    public void setHashPasar(String hashPasar) {
        this.hashPasar = hashPasar;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    public String getNamaPasar() {
        return namaPasar;
    }

    public void setNamaPasar(String namaPasar) {
        this.namaPasar = namaPasar;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getKabupaten() {
        return kabupaten;
    }

    public void setKabupaten(String kabupaten) {
        this.kabupaten = kabupaten;
    }
}
