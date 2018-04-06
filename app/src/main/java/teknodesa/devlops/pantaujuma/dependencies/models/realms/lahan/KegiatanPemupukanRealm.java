package teknodesa.devlops.pantaujuma.dependencies.models.realms.lahan;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Data;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.alsintan.PupukRealm;

public @Data class KegiatanPemupukanRealm extends RealmObject {
    @PrimaryKey
    private int idKegiatanPemanenan;
    private String tanggalMulai;
    private String tanggalAkhir;
    private String masaKegiatan;
    private String gambar;
    private String cara;
    private float luas;
    private PupukRealm pupuk;
    private float jumlahPupuk;
}
