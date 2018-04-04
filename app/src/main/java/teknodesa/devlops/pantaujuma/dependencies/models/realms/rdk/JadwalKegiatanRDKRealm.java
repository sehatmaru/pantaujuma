package teknodesa.devlops.pantaujuma.dependencies.models.realms.rdk;

import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;

public class JadwalKegiatanRDKRealm extends RealmObject {
    @PrimaryKey
    private int idJadwalKegiatanRDK;

    @LinkingObjects("kegiatan")
    private final RealmResults<RDKRealm> rdk = null;

    private String kegiatan;
    private String tanggal;
    private String deskripsi;

    public JadwalKegiatanRDKRealm() {
    }

    public JadwalKegiatanRDKRealm(int idJadwalKegiatanRDK, String kegiatan, String tanggal, String deskripsi) {
        this.idJadwalKegiatanRDK = idJadwalKegiatanRDK;
        this.kegiatan = kegiatan;
        this.tanggal = tanggal;
        this.deskripsi = deskripsi;
    }

    public int getIdJadwalKegiatanRDK() {
        return idJadwalKegiatanRDK;
    }

    public void setIdJadwalKegiatanRDK(int idJadwalKegiatanRDK) {
        this.idJadwalKegiatanRDK = idJadwalKegiatanRDK;
    }

    public RealmResults<RDKRealm> getRdk() {
        return rdk;
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

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
