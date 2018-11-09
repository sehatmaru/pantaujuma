package teknodesa.devlops.pantaujuma.dependencies.models.pojos.rdk;

public class SasaranIntensifikasi {
    private String komoditasSI;
    private String target;
    private String targetHasilPerHa;

    public SasaranIntensifikasi() {
    }

    public SasaranIntensifikasi(String komoditasSI, String target, String targetHasilPerHa) {
        this.komoditasSI = komoditasSI;
        this.target = target;
        this.targetHasilPerHa = targetHasilPerHa;
    }

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
