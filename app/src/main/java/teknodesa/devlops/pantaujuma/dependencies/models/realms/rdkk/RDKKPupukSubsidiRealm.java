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
    private int isSync;

    public RDKKPupukSubsidiRealm() {
    }

    public RDKKPupukSubsidiRealm(String hashId, int idDesa, String idUser, String poktan, String petani, String komoditas, String pupuk, float butuhJanuari, float butuhFebruari, float butuhMaret, float butuhApril, float butuhMei, float butuhJuni, float butuhJuli, float butuhAgustus, float butuhSeptember, float butuhOktober, float butuhNovember, float butuhDesember, int isSync) {
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
