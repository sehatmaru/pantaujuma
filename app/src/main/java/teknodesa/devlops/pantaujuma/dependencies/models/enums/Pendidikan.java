package teknodesa.devlops.pantaujuma.dependencies.models.enums;

import java.util.HashMap;
import java.util.Map;

public enum Pendidikan {
    CHOOSE("Pendidikan"),
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
    private static final Map<String, Pendidikan> map = new HashMap<>();
    static {
        for (Pendidikan en : values()) {
            map.put(en.toString(), en);
        }
    }

    public static Pendidikan valueFor(String name) {
        return map.get(name);
    }

    Pendidikan(String opsi) {
        this.opsi = opsi;
    }

    @Override
    public String toString() {
        return opsi;
    }
}
