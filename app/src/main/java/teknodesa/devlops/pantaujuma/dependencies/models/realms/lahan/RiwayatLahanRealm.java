package teknodesa.devlops.pantaujuma.dependencies.models.realms.lahan;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;

public class RiwayatLahanRealm extends RealmObject {
    @PrimaryKey
    private int idRiwayatLahan;

    @LinkingObjects("riwayatLahan")
    public final RealmResults<LahanRealm> lahan = null;

    public RealmList<DetailRiwayatPertanianRealm> detailKegiatan;
    private String tanggalAwal;
    private String tanggalAkhir;
    private int status;

    public RiwayatLahanRealm() {
    }

    public RiwayatLahanRealm(int idRiwayatLahan, RealmList<DetailRiwayatPertanianRealm> detailKegiatan, String tanggalAwal, String tanggalAkhir, int status) {
        this.idRiwayatLahan = idRiwayatLahan;
        this.detailKegiatan = detailKegiatan;
        this.tanggalAwal = tanggalAwal;
        this.tanggalAkhir = tanggalAkhir;
        this.status = status;
    }

    public int getIdRiwayatLahan() {
        return idRiwayatLahan;
    }

    public void setIdRiwayatLahan(int idRiwayatLahan) {
        this.idRiwayatLahan = idRiwayatLahan;
    }

    public RealmResults<LahanRealm> getLahan() {
        return lahan;
    }

    public RealmList<DetailRiwayatPertanianRealm> getDetailKegiatan() {
        return detailKegiatan;
    }

    public void setDetailKegiatan(RealmList<DetailRiwayatPertanianRealm> detailKegiatan) {
        this.detailKegiatan = detailKegiatan;
    }

    public String getTanggalAwal() {
        return tanggalAwal;
    }

    public void setTanggalAwal(String tanggalAwal) {
        this.tanggalAwal = tanggalAwal;
    }

    public String getTanggalAkhir() {
        return tanggalAkhir;
    }

    public void setTanggalAkhir(String tanggalAkhir) {
        this.tanggalAkhir = tanggalAkhir;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
