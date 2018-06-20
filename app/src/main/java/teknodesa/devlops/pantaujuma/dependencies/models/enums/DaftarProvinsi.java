package teknodesa.devlops.pantaujuma.dependencies.models.enums;

public enum DaftarProvinsi {
    CHOOSE("Pilih salah satu"),
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
