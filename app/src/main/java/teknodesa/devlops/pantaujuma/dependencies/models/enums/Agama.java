package teknodesa.devlops.pantaujuma.dependencies.models.enums;

import java.util.HashMap;
import java.util.Map;

public enum Agama{
    CHOOSE("Agama"),
    ISLAM("Islam"),
    KATOLIK("Katolik"),
    PROTESTAN("Protestan"),
    HINDU("Hindu"),
    BUDHA("Budha"),
    LAINNYA("Lainnya");

    private String opsi;
    private static final Map<String, Agama> map = new HashMap<>();
    static {
        for (Agama en : values()) {
            map.put(en.toString(), en);
        }
    }

    public static Agama valueFor(String name) {
        return map.get(name);
    }

    Agama(String opsi) {
        this.opsi = opsi;
    }
        
    @Override
    public String toString() {
        return opsi;
    }
}