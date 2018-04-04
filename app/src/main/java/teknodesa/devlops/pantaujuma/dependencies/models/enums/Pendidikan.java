package deltechs.devlops.infodes.models.enums;

public enum Pendidikan {
    BELUM_SEKOLAH("Tidak/Belum Sekolah"),
    BELUM_SD("Belum Tamat SD/Sederajat"),
    SD("Tamat SD/Sederajat"),
    SLTP("SLTP/Sederajat"),
    SLTA("SLTA/Sederajat"),
    DIPLOMA_I_OR_II("Diploma I/II"),
    DIPLOMA_III("Akademi/Diploma III/Sarjana Muda"),
    DIPLOMA_IV_OR_S_I("Diploma IV/Strata I"),
    STRATA_II("Strata II"),
    STRATA_III("Strata III");

    private String opsi;

    Pendidikan(String opsi) {
        this.opsi = opsi;
    }

    @Override
    public String toString() {
        return opsi;
    }
}
