package teknodesa.devlops.pantaujuma.dependencies.models.realms.rdkk;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RDKKPupukSubsidiRealm extends RealmObject {
    @PrimaryKey
    private String hashId;
    private int idDesa;
    private String idUser;
    private String poktan;
    private String petani;
    private String komoditas;
    private String pupuk;
    private int butuhJanuari;
    private int butuhFebruari;
    private int butuhMaret;
    private int butuhApril;
    private int butuhMei;
    private int butuhJuni;
    private int butuhJuli;
    private int butuhAgustus;
    private int butuhSeptember;
    private int butuhOktober;
    private int butuhNovember;
    private int butuhDesember;
    private int isSync;

    public RDKKPupukSubsidiRealm() {
    }

    public RDKKPupukSubsidiRealm(String hashId, int idDesa, String idUser, String poktan, String petani, String komoditas, String pupuk, int butuhJanuari, int butuhFebruari, int butuhMaret, int butuhApril, int butuhMei, int butuhJuni, int butuhJuli, int butuhAgustus, int butuhSeptember, int butuhOktober, int butuhNovember, int butuhDesember, int isSync) {
        this.hashId = hashId;
        this.idDesa = idDesa;
        this.idUser = idUser;
        this.poktan = poktan;
        this.petani = petani;
        this.komoditas = komoditas;
        this.pupuk = pupuk;
        this.butuhJanuari = butuhJanuari;
        this.butuhFebruari = butuhFebruari;
        this.butuhMaret = butuhMaret;
        this.butuhApril = butuhApril;
        this.butuhMei = butuhMei;
        this.butuhJuni = butuhJuni;
        this.butuhJuli = butuhJuli;
        this.butuhAgustus = butuhAgustus;
        this.butuhSeptember = butuhSeptember;
        this.butuhOktober = butuhOktober;
        this.butuhNovember = butuhNovember;
        this.butuhDesember = butuhDesember;
        this.isSync = isSync;
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

    public int getButuhJanuari() {
        return butuhJanuari;
    }

    public void setButuhJanuari(int butuhJanuari) {
        this.butuhJanuari = butuhJanuari;
    }

    public int getButuhFebruari() {
        return butuhFebruari;
    }

    public void setButuhFebruari(int butuhFebruari) {
        this.butuhFebruari = butuhFebruari;
    }

    public int getButuhMaret() {
        return butuhMaret;
    }

    public void setButuhMaret(int butuhMaret) {
        this.butuhMaret = butuhMaret;
    }

    public int getButuhApril() {
        return butuhApril;
    }

    public void setButuhApril(int butuhApril) {
        this.butuhApril = butuhApril;
    }

    public int getButuhMei() {
        return butuhMei;
    }

    public void setButuhMei(int butuhMei) {
        this.butuhMei = butuhMei;
    }

    public int getButuhJuni() {
        return butuhJuni;
    }

    public void setButuhJuni(int butuhJuni) {
        this.butuhJuni = butuhJuni;
    }

    public int getButuhJuli() {
        return butuhJuli;
    }

    public void setButuhJuli(int butuhJuli) {
        this.butuhJuli = butuhJuli;
    }

    public int getButuhAgustus() {
        return butuhAgustus;
    }

    public void setButuhAgustus(int butuhAgustus) {
        this.butuhAgustus = butuhAgustus;
    }

    public int getButuhSeptember() {
        return butuhSeptember;
    }

    public void setButuhSeptember(int butuhSeptember) {
        this.butuhSeptember = butuhSeptember;
    }

    public int getButuhOktober() {
        return butuhOktober;
    }

    public void setButuhOktober(int butuhOktober) {
        this.butuhOktober = butuhOktober;
    }

    public int getButuhNovember() {
        return butuhNovember;
    }

    public void setButuhNovember(int butuhNovember) {
        this.butuhNovember = butuhNovember;
    }

    public int getButuhDesember() {
        return butuhDesember;
    }

    public void setButuhDesember(int butuhDesember) {
        this.butuhDesember = butuhDesember;
    }

    public int getIsSync() {
        return isSync;
    }

    public void setIsSync(int isSync) {
        this.isSync = isSync;
    }

    @Override
    public String toString() {
        return "RDKKPupukSubsidiRealm{" +
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
                ", isSync=" + isSync +
                '}';
    }
}
