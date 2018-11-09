package teknodesa.devlops.pantaujuma.dependencies.models.pojos.rdk;

public class RencanaUmum {
    //    private String hashId;
    private String paketTeknologi;
    private String polaTanam;
    private String jadwalTanam;
    private String komoditasRU;
    private String varietas;
    private String sumberBenih;
    private String tabunganAnggota;
    private String iuranAnggota;
    private String pemupukanModal;

    public RencanaUmum() {
    }

    public RencanaUmum(String paketTeknologi, String polaTanam, String jadwalTanam, String komoditasRU, String varietas, String sumberBenih, String tabunganAnggota, String iuranAnggota, String pemupukanModal) {
//        this.hashId = hashId;
        this.paketTeknologi = paketTeknologi;
        this.polaTanam = polaTanam;
        this.jadwalTanam = jadwalTanam;
        this.komoditasRU = komoditasRU;
        this.varietas = varietas;
        this.sumberBenih = sumberBenih;
        this.tabunganAnggota = tabunganAnggota;
        this.iuranAnggota = iuranAnggota;
        this.pemupukanModal = pemupukanModal;
    }
//
//    public String getHashId() {
//        return hashId;
//    }
//
//    public void setHashId(String hashId) {
//        this.hashId = hashId;
//    }

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
}
