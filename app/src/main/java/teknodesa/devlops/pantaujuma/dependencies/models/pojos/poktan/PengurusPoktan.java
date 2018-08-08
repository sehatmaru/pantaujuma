package teknodesa.devlops.pantaujuma.dependencies.models.pojos.poktan;


public class PengurusPoktan  {

    private String poktan = null;
    private String petani = null;
    private String jabatan = "-";
    private String periode = "-";

    public PengurusPoktan() {
    }

    public PengurusPoktan(String poktan, String petani, String jabatan, String periode) {
        this.poktan = poktan;
        this.petani = petani;
        this.jabatan = jabatan;
        this.periode = periode;
    }

    public PengurusPoktan(String petani, String jabatan, String periode) {
        this.petani = petani;
        this.jabatan = jabatan;
        this.periode = periode;
    }

    public String getPoktan() {
        return poktan;
    }

    public void setPoktan(String poktan) {
        this.poktan = poktan;
    }

    public String getPetani() {
        return petani;
    }

    public void setPetani(String petani) {
        this.petani = petani;
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


}
