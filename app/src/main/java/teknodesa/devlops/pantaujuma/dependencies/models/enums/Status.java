package teknodesa.devlops.pantaujuma.dependencies.models.enums;

public enum Status {
    CHOOSE("Pilih salah satu"),
    AKTIF("Aktif"),
    NONAKTIF("Non-Aktif");

    private String opsi;

    Status(String opsi) {
        this.opsi = opsi;
    }

    @Override
    public String toString() {
        return opsi;
    }
}
