package teknodesa.devlops.pantaujuma.dependencies.models.pojos;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.poktan.PengurusPoktanRealm;

public class PengurusPoktanBody {

    private String hashId;

    private String poktanPengurus = null;
    private String petaniPengurus = null;
    private String jabatan = "-";
    private String periode = "-";
    private int statusPengurus;

    private int idDesa = 0;

    public PengurusPoktanBody() {
    }

    public PengurusPoktanBody(PengurusPoktanRealm data) {
        this.hashId = data.getHashId();
        this.poktanPengurus = data.getPoktanPengurus();
        this.petaniPengurus = data.getPetaniPengurus();
        this.jabatan = data.getJabatan();
        this.periode = data.getPeriode();
        this.statusPengurus = data.getStatusPengurus();
        this.idDesa = data.getIdDesa();
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getPoktanPengurus() {
        return poktanPengurus;
    }

    public void setPoktanPengurus(String poktanPengurus) {
        this.poktanPengurus = poktanPengurus;
    }

    public String getPetaniPengurus() {
        return petaniPengurus;
    }

    public void setPetaniPengurus(String petaniPengurus) {
        this.petaniPengurus = petaniPengurus;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public int getStatusPengurus() {
        return statusPengurus;
    }

    public void setStatusPengurus(int statusPengurus) {
        this.statusPengurus = statusPengurus;
    }

    public int getIdDesa() {
        return idDesa;
    }

    public void setIdDesa(int idDesa) {
        this.idDesa = idDesa;
    }

    @Override
    public String toString() {
        return "PengurusPoktanBody{" +
                "hashId='" + hashId + '\'' +
                ", poktanPengurus='" + poktanPengurus + '\'' +
                ", petaniPengurus='" + petaniPengurus + '\'' +
                ", jabatan='" + jabatan + '\'' +
                ", periode='" + periode + '\'' +
                ", statusPengurus=" + statusPengurus +
                ", idDesa=" + idDesa +
                '}';
    }
}
