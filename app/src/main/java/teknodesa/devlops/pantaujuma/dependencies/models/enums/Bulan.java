package teknodesa.devlops.pantaujuma.dependencies.models.enums;

import java.util.HashMap;
import java.util.Map;

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
    private static final Map<String, Bulan> map = new HashMap<>();
    static {
        for (Bulan en : values()) {
            map.put(en.toString(), en);
        }
    }

    public static Bulan valueFor(String name) {
        return map.get(name);
    }

    Bulan(String opsi) {
        this.opsi = opsi;
    }

    @Override
    public String toString() {
        return opsi;
    }
}
