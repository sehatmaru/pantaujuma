package teknodesa.devlops.pantaujuma.dependencies.models.pojos.rdkk;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.rdkk.RDKKPupukSubsidiRealm;

public class RDKKBody {
    private String hashId;
    private int idDesa;
    private String idUser;
    private String poktan;
    private String petani;
    private String komoditas;
    private String pupuk;
    private float butuhJanuari;
    private float butuhFebruari;
    private float butuhMaret;
    private float butuhApril;
    private float butuhMei;
    private float butuhJuni;
    private float butuhJuli;
    private float butuhAgustus;
    private float butuhSeptember;
    private float butuhOktober;
    private float butuhNovember;
    private float butuhDesember;

    public RDKKBody() {
    }

    public RDKKBody(RDKKPupukSubsidiRealm data) {
        this.hashId = data.getHashId();
        this.idDesa = data.getIdDesa();
        this.idUser = data.getIdUser();
        this.poktan = data.getPoktan();
        this.petani = data.getPetani();
        this.komoditas = data.getKomoditas();
        this.pupuk = data.getPupuk();
        this.butuhJanuari = data.getButuhJanuari();
        this.butuhFebruari = data.getButuhFebruari();
        this.butuhMaret = data.getButuhMaret();
        this.butuhApril = data.getButuhApril();
        this.butuhMei = data.getButuhMei();
        this.butuhJuni = data.getButuhJuni();
        this.butuhJuli = data.getButuhJuli();
        this.butuhAgustus = data.getButuhAgustus();
        this.butuhSeptember = data.getButuhSeptember();
        this.butuhOktober = data.getButuhOktober();
        this.butuhNovember = data.getButuhNovember();
        this.butuhDesember = data.getButuhDesember();
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public int getIdDesa() {
        return idDesa;
    }

    public void setIdDesa(int idDesa) {
        this.idDesa = idDesa;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
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

    public String getKomoditas() {
        return komoditas;
    }

    public void setKomoditas(String komoditas) {
        this.komoditas = komoditas;
    }

    public String getPupuk() {
        return pupuk;
    }

    public void setPupuk(String pupuk) {
        this.pupuk = pupuk;
    }

    public float getButuhJanuari() {
        return butuhJanuari;
    }

    public void setButuhJanuari(float butuhJanuari) {
        this.butuhJanuari = butuhJanuari;
    }

    public float getButuhFebruari() {
        return butuhFebruari;
    }

    public void setButuhFebruari(float butuhFebruari) {
        this.butuhFebruari = butuhFebruari;
    }

    public float getButuhMaret() {
        return butuhMaret;
    }

    public void setButuhMaret(float butuhMaret) {
        this.butuhMaret = butuhMaret;
    }

    public float getButuhApril() {
        return butuhApril;
    }

    public void setButuhApril(float butuhApril) {
        this.butuhApril = butuhApril;
    }

    public float getButuhMei() {
        return butuhMei;
    }

    public void setButuhMei(float butuhMei) {
        this.butuhMei = butuhMei;
    }

    public float getButuhJuni() {
        return butuhJuni;
    }

    public void setButuhJuni(float butuhJuni) {
        this.butuhJuni = butuhJuni;
    }

    public float getButuhJuli() {
        return butuhJuli;
    }

    public void setButuhJuli(float butuhJuli) {
        this.butuhJuli = butuhJuli;
    }

    public float getButuhAgustus() {
        return butuhAgustus;
    }

    public void setButuhAgustus(float butuhAgustus) {
        this.butuhAgustus = butuhAgustus;
    }

    public float getButuhSeptember() {
        return butuhSeptember;
    }

    public void setButuhSeptember(float butuhSeptember) {
        this.butuhSeptember = butuhSeptember;
    }

    public float getButuhOktober() {
        return butuhOktober;
    }

    public void setButuhOktober(float butuhOktober) {
        this.butuhOktober = butuhOktober;
    }

    public float getButuhNovember() {
        return butuhNovember;
    }

    public void setButuhNovember(float butuhNovember) {
        this.butuhNovember = butuhNovember;
    }

    public float getButuhDesember() {
        return butuhDesember;
    }

    public void setButuhDesember(float butuhDesember) {
        this.butuhDesember = butuhDesember;
    }

    @Override
    public String toString() {
        return "RDKKBody{" +
                "hashId='" + hashId + '\'' +
                ", idDesa=" + idDesa +
                ", idUser='" + idUser + '\'' +
                ", poktan='" + poktan + '\'' +
                ", petani='" + petani + '\'' +
                ", komoditas='" + komoditas + '\'' +
                ", pupuk='" + pupuk + '\'' +
                ", butuhJanuari=" + butuhJanuari +
                ", butuhFebruari=" + butuhFebruari +
                ", butuhMaret=" + butuhMaret +
                ", butuhApril=" + butuhApril +
                ", butuhMei=" + butuhMei +
                ", butuhJuni=" + butuhJuni +
                ", butuhJuli=" + butuhJuli +
                ", butuhAgustus=" + butuhAgustus +
                ", butuhSeptember=" + butuhSeptember +
                ", butuhOktober=" + butuhOktober +
                ", butuhNovember=" + butuhNovember +
                ", butuhDesember=" + butuhDesember +
                '}';
    }
}
