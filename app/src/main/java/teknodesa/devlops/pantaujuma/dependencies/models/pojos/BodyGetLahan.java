package teknodesa.devlops.pantaujuma.dependencies.models.pojos;

/**
 * Created by Marthin on 8/2/2018.
 */

public class BodyGetLahan {
    private String idKomoditas;
    private int idDesa;

    public BodyGetLahan() {
    }

    public BodyGetLahan(String idKomoditas, int idDesa) {
        this.idKomoditas = idKomoditas;
        this.idDesa = idDesa;
    }

    public String getIdKomoditas() {
        return idKomoditas;
    }

    public void setIdKomoditas(String idKomoditas) {
        this.idKomoditas = idKomoditas;
    }

    public int getIdDesa() {
        return idDesa;
    }

    public void setIdDesa(int idDesa) {
        this.idDesa = idDesa;
    }

    @Override
    public String toString() {
        return "BodyGetLahan{" +
                "idKomoditas='" + idKomoditas + '\'' +
                ", idDesa=" + idDesa +
                '}';
    }
}
