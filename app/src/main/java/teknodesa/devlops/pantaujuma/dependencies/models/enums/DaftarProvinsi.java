package teknodesa.devlops.pantaujuma.dependencies.models.enums;

import java.util.HashMap;
import java.util.Map;

public enum DaftarProvinsi {
    CHOOSE("Pilih salah satu"),
    NAD("Nanggroe Aceh Darussalam"),
    SUMUT("Sumatera Utara");

    private String opsi;
    private static final Map<String, DaftarProvinsi> map = new HashMap<>();
    static {
        for (DaftarProvinsi en : values()) {
            map.put(en.toString(), en);
        }
    }

    public static DaftarProvinsi valueFor(String name) {
        return map.get(name);
    }

    DaftarProvinsi(String opsi) {
        this.opsi = opsi;
    }

    @Override
    public String toString() {
        return opsi;
    }
}
