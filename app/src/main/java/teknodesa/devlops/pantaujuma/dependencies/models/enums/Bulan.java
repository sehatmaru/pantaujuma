package teknodesa.devlops.pantaujuma.dependencies.models.enums;

public enum Bulan {
    CHOOSE("Pilih salah satu"),
    JANUARI("Januari"),
    FEBRUARI("Februari"),
    MARET("Maret"),
    APRIL("April"),
    MEI("Mei"),
    JUNI("Juni"),
    JULI("Juli"),
    AGUSTUS("Agustus"),
    SEPTEMBER("September"),
    OKTOBER("Oktober"),
    NOVEMBER("November"),
    DESEMBER("Desember");

    private String opsi;

    Bulan(String opsi) {
        this.opsi = opsi;
    }

    @Override
    public String toString() {
        return opsi;
    }
}
