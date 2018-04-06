package teknodesa.devlops.pantaujuma.dependencies.models.realms;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.alsintan.PupukRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.petani.PetaniRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.petani.PoktanRealm;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.petugas.PetugasRealm;

public class RDKKPupukSubsidiRealm extends RealmObject {
    @PrimaryKey
    private int idRDKKPupukSubsidi;
    private PetugasRealm petugas;
    private PoktanRealm poktan;
    private PetaniRealm petani;
    private KomoditasRealm komoditas;
    private PupukRealm pupuk;
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

    public RDKKPupukSubsidiRealm() {
    }

    public RDKKPupukSubsidiRealm(int idRDKKPupukSubsidi, PetugasRealm petugas, PoktanRealm poktan, PetaniRealm petani, KomoditasRealm komoditas, PupukRealm pupuk, float butuhJanuari, float butuhFebruari, float butuhMaret, float butuhApril, float butuhMei, float butuhJuni, float butuhJuli, float butuhAgustus, float butuhSeptember, float butuhOktober, float butuhNovember, float butuhDesember) {
        this.idRDKKPupukSubsidi = idRDKKPupukSubsidi;
        this.petugas = petugas;
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
    }

    public int getIdRDKKPupukSubsidi() {
        return idRDKKPupukSubsidi;
    }

    public void setIdRDKKPupukSubsidi(int idRDKKPupukSubsidi) {
        this.idRDKKPupukSubsidi = idRDKKPupukSubsidi;
    }

    public PetugasRealm getPetugas() {
        return petugas;
    }

    public void setPetugas(PetugasRealm petugas) {
        this.petugas = petugas;
    }

    public PoktanRealm getPoktan() {
        return poktan;
    }

    public void setPoktan(PoktanRealm poktan) {
        this.poktan = poktan;
    }

    public PetaniRealm getPetani() {
        return petani;
    }

    public void setPetani(PetaniRealm petani) {
        this.petani = petani;
    }

    public KomoditasRealm getKomoditas() {
        return komoditas;
    }

    public void setKomoditas(KomoditasRealm komoditas) {
        this.komoditas = komoditas;
    }

    public PupukRealm getPupuk() {
        return pupuk;
    }

    public void setPupuk(PupukRealm pupuk) {
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
}
