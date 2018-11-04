package teknodesa.devlops.pantaujuma.dependencies.models.pojos;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.AnggotaPoktanRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.PengurusPoktanRealm;

public class AnggotaPoktanBody {

    private String hashId;

    private String poktanAnggota = null;
    private String petaniAnggota = null;
    private String tanggalMasuk;
    private int statusAnggota;
    private int idDesa = 0;

    public AnggotaPoktanBody() {
    }

    public AnggotaPoktanBody(AnggotaPoktanRealm data) {
        this.hashId = data.getHashId();
        this.poktanAnggota = data.getPoktanAnggota();
        this.petaniAnggota = data.getPetaniAnggota();
        this.tanggalMasuk = data.getTanggalMasuk();
        this.statusAnggota = data.getStatusAnggota();
        this.idDesa = data.getIdDesa();
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getPoktanAnggota() {
        return poktanAnggota;
    }

    public void setPoktanAnggota(String poktanAnggota) {
        this.poktanAnggota = poktanAnggota;
    }

    public String getPetaniAnggota() {
        return petaniAnggota;
    }

    public void setPetaniAnggota(String petaniAnggota) {
        this.petaniAnggota = petaniAnggota;
    }

    public String getTanggalMasuk() {
        return tanggalMasuk;
    }

    public void setTanggalMasuk(String tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }

    public int getStatusAnggota() {
        return statusAnggota;
    }

    public void setStatusAnggota(int statusAnggota) {
        this.statusAnggota = statusAnggota;
    }

    public int getIdDesa() {
        return idDesa;
    }

    public void setIdDesa(int idDesa) {
        this.idDesa = idDesa;
    }

    @Override
    public String toString() {
        return "AnggotaPoktanBody{" +
                "hashId='" + hashId + '\'' +
                ", poktanAnggota='" + poktanAnggota + '\'' +
                ", petaniAnggota='" + petaniAnggota + '\'' +
                ", tanggalMasuk='" + tanggalMasuk + '\'' +
                ", statusAnggota=" + statusAnggota +
                ", idDesa=" + idDesa +
                '}';
    }
}
