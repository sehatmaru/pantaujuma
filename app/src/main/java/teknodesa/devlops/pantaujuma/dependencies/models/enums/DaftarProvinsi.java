package deltechs.devlops.infodes.models.enums;

public enum DaftarProvinsi {
    NAD("Nanggroe Aceh Darussalam"),
    SUMUT("Sumatera Utara");

    private String opsi;

    DaftarProvinsi(String opsi) {
        this.opsi = opsi;
    }

    @Override
    public String toString() {
        return opsi;
    }
}
