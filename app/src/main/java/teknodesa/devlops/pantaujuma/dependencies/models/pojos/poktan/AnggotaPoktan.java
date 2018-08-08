package teknodesa.devlops.pantaujuma.dependencies.models.pojos.poktan;

public class AnggotaPoktan {

    private String poktan = null;
    private String petani = null;
    private String tanggalMasuk = "-";

    public AnggotaPoktan() {
    }

    public AnggotaPoktan(String poktan, String petani, String tanggalMasuk) {
        this.poktan = poktan;
        this.petani = petani;
        this.tanggalMasuk = tanggalMasuk;
    }

    public AnggotaPoktan(String petani, String tanggalMasuk) {
        this.petani = petani;
        this.tanggalMasuk = tanggalMasuk;
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

    public String getTanggalMasuk() {
        return tanggalMasuk;
    }

    public void setTanggalMasuk(String tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }
}
