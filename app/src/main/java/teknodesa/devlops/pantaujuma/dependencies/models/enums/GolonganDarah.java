package teknodesa.devlops.pantaujuma.dependencies.models.enums;

public enum GolonganDarah {
    CHOOSE("Golongan Darah"),
    A("A"),
    B("B"),
    AB("AB"),
    O("O"),
    A_POSITIF("A+"),
    A_MINUS("A-"),
    B_POSITIF("B+"),
    B_MINUS("B-"),
    AB_POSITIF("AB+"),
    AB_MINUS("AB-"),
    O_POSITIF("O+"),
    O_MINUS("O-"),
    TIDAK_TAHU("Tidak Tahu");

    private String opsi;

    GolonganDarah(String opsi) {
        this.opsi = opsi;
    }

    @Override
    public String toString() {
        return opsi;
    }
}
