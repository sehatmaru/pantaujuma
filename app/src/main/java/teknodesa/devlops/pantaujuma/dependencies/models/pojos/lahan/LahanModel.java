package teknodesa.devlops.pantaujuma.dependencies.models.pojos.lahan;

/**
 * Created by Marthin on 11/11/2018.
 */

public class LahanModel {
    private String pemilik;
    private String namaPemilikLahan;
    private String luas;
    private String batasTimur;
    private String batasBarat;
    private String batasSelatan;
    private String batasUtara;
    private String deskripsi;

    public LahanModel() {
    }

    public LahanModel(String pemilik, String namaPemilikLahan, String luas, String batasTimur, String batasBarat,
                      String batasSelatan, String batasUtara, String deskripsi) {
        this.pemilik = pemilik;
        this.namaPemilikLahan = namaPemilikLahan;
        this.luas = luas;
        this.batasTimur = batasTimur;
        this.batasBarat = batasBarat;
        this.batasSelatan = batasSelatan;
        this.batasUtara = batasUtara;
        this.deskripsi = deskripsi;
    }

    public String getPemilik() {
        return pemilik;
    }

    public void setPemilik(String pemilik) {
        this.pemilik = pemilik;
    }

    public String getNamaPemilikLahan() {
        return namaPemilikLahan;
    }

    public void setNamaPemilikLahan(String namaPemilikLahan) {
        this.namaPemilikLahan = namaPemilikLahan;
    }

    public String getLuas() {
        return luas;
    }

    public void setLuas(String luas) {
        this.luas = luas;
    }

    public String getBatasTimur() {
        return batasTimur;
    }

    public void setBatasTimur(String batasTimur) {
        this.batasTimur = batasTimur;
    }

    public String getBatasBarat() {
        return batasBarat;
    }

    public void setBatasBarat(String batasBarat) {
        this.batasBarat = batasBarat;
    }

    public String getBatasSelatan() {
        return batasSelatan;
    }

    public void setBatasSelatan(String batasSelatan) {
        this.batasSelatan = batasSelatan;
    }

    public String getBatasUtara() {
        return batasUtara;
    }

    public void setBatasUtara(String batasUtara) {
        this.batasUtara = batasUtara;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
