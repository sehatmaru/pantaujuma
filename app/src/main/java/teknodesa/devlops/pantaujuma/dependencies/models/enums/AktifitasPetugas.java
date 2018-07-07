package teknodesa.devlops.pantaujuma.dependencies.models.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Roy Deddy Tobing on 4/4/2018.
 */

public enum AktifitasPetugas {
	TAMBAH_RIWAYAT_PEMBIBITAN(50),
    TAMBAH_RIWAYAT_PANEN(20);

    //AktifitasPetugas.valueOf("TAMBAH_RIWAYAT_PEMBIBITAN")

    private int poin;
    private static final Map<String, AktifitasPetugas> map = new HashMap<>();
    static {
        for (AktifitasPetugas en : values()) {
            map.put(en.toString(), en);
        }
    }

    public static AktifitasPetugas valueFor(String name) {
        return map.get(name);
    }

    AktifitasPetugas(int poin) {
        this.poin = poin;
    }
        
    public int getValue() {
        return poin;
    }
}
