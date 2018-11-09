package teknodesa.devlops.pantaujuma.dependencies.models.pojos.rdk;

public class SasaranIntensifikasi {
    //    private String hashId;
    private String komoditasSI;
    private String target;
    private String targetHasilPerHa;

    public SasaranIntensifikasi() {
    }

    public SasaranIntensifikasi(String komoditasSI, String target, String targetHasilPerHa) {
//        this.hashId = hashId;
        this.komoditasSI = komoditasSI;
        this.target = target;
        this.targetHasilPerHa = targetHasilPerHa;
    }
//
//    public String getHashId() {
//        return hashId;
//    }
//
//    public void setHashId(String hashId) {
//        this.hashId = hashId;
//    }

    public String getKomoditasSI() {
        return komoditasSI;
    }

    public void setKomoditasSI(String komoditasSI) {
        this.komoditasSI = komoditasSI;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getTargetHasilPerHa() {
        return targetHasilPerHa;
    }

    public void setTargetHasilPerHa(String targetHasilPerHa) {
        this.targetHasilPerHa = targetHasilPerHa;
    }
}
