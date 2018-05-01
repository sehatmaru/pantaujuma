package teknodesa.devlops.pantaujuma.dependencies.models.realms.lahan;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Data;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.KomoditasRealm;

public @Data class KegiatanPemanenanRealm extends RealmObject {
    @PrimaryKey
    private int idKegiatanPemanenan;
    private KomoditasRealm komoditas;
    private String tanggalMulai;
    private String tanggalAkhir;
    private String masaKegiatan;
    private String gambar;
    private String cara;
    private float luas;
    private float hasil;
}
