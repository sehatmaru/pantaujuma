package teknodesa.devlops.pantaujuma.dependencies.models.realms.petugas;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.PendudukRealm;

public class PetugasRealm extends RealmObject {
    @PrimaryKey
    private int idPetugas;
    private PendudukRealm biodata;
    private String foto;
    private String desaTugas;
    private String kecamatanTugas;
    private String tanggalMulai;
    private String deskripsi;
    private int status;

    public PetugasRealm() {
    }

    public PetugasRealm(int idPetugas, PendudukRealm biodata, String foto, String desaTugas, String kecamatanTugas, String tanggalMulai, String deskripsi, int status) {
        this.idPetugas = idPetugas;
        this.biodata = biodata;
        this.foto = foto;
        this.desaTugas = desaTugas;
        this.kecamatanTugas = kecamatanTugas;
        this.tanggalMulai = tanggalMulai;
        this.deskripsi = deskripsi;
        this.status = status;
    }

    public int getIdPetugas() {
        return idPetugas;
    }

    public void setIdPetugas(int idPetugas) {
        this.idPetugas = idPetugas;
    }

    public PendudukRealm getBiodata() {
        return biodata;
    }

    public void setBiodata(PendudukRealm biodata) {
        this.biodata = biodata;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDesaTugas() {
        return desaTugas;
    }

    public void setDesaTugas(String desaTugas) {
        this.desaTugas = desaTugas;
    }

    public String getKecamatanTugas() {
        return kecamatanTugas;
    }

    public void setKecamatanTugas(String kecamatanTugas) {
        this.kecamatanTugas = kecamatanTugas;
    }

    public String getTanggalMulai() {
        return tanggalMulai;
    }

    public void setTanggalMulai(String tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
