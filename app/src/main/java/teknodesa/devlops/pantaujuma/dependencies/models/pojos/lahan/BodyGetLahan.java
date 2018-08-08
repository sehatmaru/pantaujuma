package teknodesa.devlops.pantaujuma.dependencies.models.pojos.lahan;

/**
 * Created by Marthin on 8/2/2018.
 */

public class BodyGetLahan {
    private int idKomoditas;
    private int idDesa;

    public BodyGetLahan() {
    }

    public BodyGetLahan(int idKomoditas, int idDesa) {
        this.idKomoditas = idKomoditas;
        this.idDesa = idDesa;
    }

    public int getIdKomoditas() {
        return idKomoditas;
    }

    public void setIdKomoditas(int idKomoditas) {
        this.idKomoditas = idKomoditas;
    }

    public int getIdDesa() {
        return idDesa;
    }

    public void setIdDesa(int idDesa) {
        this.idDesa = idDesa;
    }
}
