package teknodesa.devlops.pantaujuma.dependencies.models.enums;

import java.util.HashMap;
import java.util.Map;

public enum Status {
    CHOOSE("Pilih salah satu"),
    AKTIF("Aktif"),
    NONAKTIF("Non-Aktif");

    private String opsi;
    private static final Map<String, Status> map = new HashMap<>();
    static {
        for (Status en : values()) {
            map.put(en.toString(), en);
        }
    }

    public static Status valueFor(String name) {
        return map.get(name);
    }

    Status(String opsi) {
        this.opsi = opsi;
    }

    @Override
    public String toString() {
        return opsi;
    }
}
