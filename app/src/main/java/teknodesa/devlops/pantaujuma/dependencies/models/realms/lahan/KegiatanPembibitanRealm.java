package teknodesa.devlops.pantaujuma.dependencies.models.realms.lahan;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Data;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.KomoditasRealm;

public @Data class KegiatanPembibitanRealm extends RealmObject {
    @PrimaryKey
    private int idKegiatanPemanenan;
    private String tanggalMulai;
    private String tanggalAkhir;
    private String masaKegiatan;
    private String gambar;
    private KomoditasRealm komoditas;
    private float jumlah;
    private float sumber;
}
