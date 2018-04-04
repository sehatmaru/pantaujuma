package teknodesa.devlops.pantaujuma.dependencies.models.realms.rdk;

import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;

public class IrigasiRDKRealm extends RealmObject {
    @PrimaryKey
    private int idIrigasiRDK;

    @LinkingObjects("irigasi")
    private final RealmResults<RDKRealm> rdk = null;

    private String nama;
    private String deskripsi;

    public IrigasiRDKRealm() {
    }

    public IrigasiRDKRealm(int idIrigasiRDK, String nama, String deskripsi) {
        this.idIrigasiRDK = idIrigasiRDK;
        this.nama = nama;
        this.deskripsi = deskripsi;
    }

    public int getIdIrigasiRDK() {
        return idIrigasiRDK;
    }

    public void setIdIrigasiRDK(int idIrigasiRDK) {
        this.idIrigasiRDK = idIrigasiRDK;
    }

    public RealmResults<RDKRealm> getRdk() {
        return rdk;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
