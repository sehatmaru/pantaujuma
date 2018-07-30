package teknodesa.devlops.pantaujuma.dependencies.models.realms.rdk;

import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.komoditas.KomoditasRealm;

public class RencanaUmumRDKRealm extends RealmObject {
    @PrimaryKey
    private int idRencanaUmumRDK;

    @LinkingObjects("rencana")
    private final RealmResults<RDKRealm> rdk = null;

    private String paketTeknologi;
    private String polaTanam;
    private String jadwalTanam;
    private KomoditasRealm komoditas;
    private String varietas;
    private String sumberBenih;
    private String tabunganAnggota;
    private String iuranAnggota;
    private String pemupukanModal;

    public RencanaUmumRDKRealm() {
    }

    public RencanaUmumRDKRealm(int idRencanaUmumRDK, String paketTeknologi, String polaTanam, String jadwalTanam, KomoditasRealm komoditas, String varietas, String sumberBenih, String tabunganAnggota, String iuranAnggota, String pemupukanModal) {
        this.idRencanaUmumRDK = idRencanaUmumRDK;
        this.paketTeknologi = paketTeknologi;
        this.polaTanam = polaTanam;
        this.jadwalTanam = jadwalTanam;
        this.komoditas = komoditas;
        this.varietas = varietas;
        this.sumberBenih = sumberBenih;
        this.tabunganAnggota = tabunganAnggota;
        this.iuranAnggota = iuranAnggota;
        this.pemupukanModal = pemupukanModal;
    }

    public int getIdRencanaUmumRDK() {
        return idRencanaUmumRDK;
    }

    public void setIdRencanaUmumRDK(int idRencanaUmumRDK) {
        this.idRencanaUmumRDK = idRencanaUmumRDK;
    }

    public RealmResults<RDKRealm> getRdk() {
        return rdk;
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

    public KomoditasRealm getKomoditas() {
        return komoditas;
    }

    public void setKomoditas(KomoditasRealm komoditas) {
        this.komoditas = komoditas;
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
