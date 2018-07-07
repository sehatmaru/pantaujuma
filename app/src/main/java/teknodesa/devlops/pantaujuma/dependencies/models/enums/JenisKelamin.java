package teknodesa.devlops.pantaujuma.dependencies.models.enums;

import java.util.HashMap;
import java.util.Map;

public enum JenisKelamin {
    CHOOSE("Jenis Kelamin"),
    LAKI("Laki-laki"),
    PEREMPUAN("Perempuan");

    private String opsi;
    private static final Map<String, JenisKelamin> map = new HashMap<>();
    static {
        for (JenisKelamin en : values()) {
            map.put(en.toString(), en);
        }
    }

    public static JenisKelamin valueFor(String name) {
        return map.get(name);
    }

    JenisKelamin(String opsi) {
        this.opsi = opsi;
    }
        
    @Override
    public String toString() {
        return opsi;
    }
}