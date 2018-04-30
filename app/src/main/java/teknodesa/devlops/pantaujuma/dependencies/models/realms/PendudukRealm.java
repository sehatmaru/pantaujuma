package teknodesa.devlops.pantaujuma.dependencies.models.realms;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Data;
import teknodesa.devlops.pantaujuma.dependencies.models.realms.lahan.LahanRealm;

/**
 * Created by Roy Deddy Tobing on 4/4/2018.
 */

public @Data class PendudukRealm extends RealmObject {
    @PrimaryKey
    private int idPenduduk;
    private String NIK;
    private String foto;
    private String namaDepan;
    private String namaBelakang;
    private String jenisKelamin;
    private String tempatLahir;
    private String tanggalLahir;
    private String agama;
    private String golonganDarah;
    private String pekerjaan;
    private String pendidikan;
    private String alamat;
    private String rt;
    private String rw;
    private String dusun;
    private String desa;
    private String kecamatan;
    private String datiII;
    private String provinsi;
    private String noHP;
    private String noTelp;
    public RealmList<LahanRealm> daftarLahan;
    private int status;
    private int kodePos;
    private String email;
}
