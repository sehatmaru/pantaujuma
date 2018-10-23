package teknodesa.devlops.pantaujuma.dependencies.models.pojos;

/**
 * Created by Marthin on 8/2/2018.
 */

public class BodyGetLahan {
    private String idKomoditas;
    private String idDesa;

    public BodyGetLahan() {
    }

    public BodyGetLahan(String idKomoditas, String idDesa) {
        this.idKomoditas = idKomoditas;
        this.idDesa = idDesa;
    }

    public String getIdKomoditas() {
        return idKomoditas;
    }

    public void setIdKomoditas(String idKomoditas) {
        this.idKomoditas = idKomoditas;
    }

    public String getIdDesa() {
        return idDesa;
    }

    public void setIdDesa(String idDesa) {
        this.idDesa = idDesa;
    }
}
