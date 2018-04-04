package teknodesa.devlops.pantaujuma.dependencies.models.enums;

/**
 * Created by Roy Deddy Tobing on 4/4/2018.
 */

public enum AktifitasPetugas {
	TAMBAH_RIWAYAT_PEMBIBITAN(50),
    TAMBAH_RIWAYAT_PANEN(20);

    //AktifitasPetugas.valueOf("TAMBAH_RIWAYAT_PEMBIBITAN")

    private int poin;

    AktifitasPetugas(int poin) {
        this.poin = poin;
    }
        
    public int getValue() {
        return poin;
    }
}
