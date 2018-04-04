package teknodesa.devlops.pantaujuma.dependencies.models.realms.petugas;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.PenggunaRealm;

public class AktifitasPetugasRealm extends RealmObject{
    @PrimaryKey
    private int idAktifitasPetugas;
    private PenggunaRealm pengguna;
    private String aktifitas;
    private String tanggal;
    private String detail;
    private int poin;

    public AktifitasPetugasRealm() {
    }

    public AktifitasPetugasRealm(int idAktifitasPetugas, PenggunaRealm pengguna, String aktifitas, String tanggal, String detail, int poin) {
        this.idAktifitasPetugas = idAktifitasPetugas;
        this.pengguna = pengguna;
        this.aktifitas = aktifitas;
        this.tanggal = tanggal;
        this.detail = detail;
        this.poin = poin;
    }

    public int getIdAktifitasPetugas() {
        return idAktifitasPetugas;
    }

    public void setIdAktifitasPetugas(int idAktifitasPetugas) {
        this.idAktifitasPetugas = idAktifitasPetugas;
    }

    public PenggunaRealm getPengguna() {
        return pengguna;
    }

    public void setPengguna(PenggunaRealm pengguna) {
        this.pengguna = pengguna;
    }

    public String getAktifitas() {
        return aktifitas;
    }

    public void setAktifitas(String aktifitas) {
        this.aktifitas = aktifitas;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getPoin() {
        return poin;
    }

    public void setPoin(int poin) {
        this.poin = poin;
    }
}
