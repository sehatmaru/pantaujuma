package teknodesa.devlops.pantaujuma.dependencies.models.enums;

import java.util.HashMap;
import java.util.Map;

public enum Pekerjaan {
    CHOOSE("Pekerjaan"),
    BELUM_BEKERJA("Belum / Tidak Bekerja"),
    MENGURUS_RUMAH_TANGGA("Mengurus Rumah Tangga"),
    PELAJAR_OR_MAHASISWA("Pelajar / Mahasiswa"),
    PENSIUNAN("Pensiunan"),
    PNS("Pegawai Negeri Sipil"),
    TNI("Tentara Nasional Indonesia"),
    POLISI("Kepolisian RI"),
    PERDAGANGAN("Perdagangan"),
    PETANI_OR_PEKEBUN("Petani / Pekebun"),
    PETERNAK("Peternak"),
    NELAYAN_OR_PERIKANAN("Nelayan / Perikanan"),
    INDUSTRI("Industri"),
    KONSTRUKSI("Konstruksi"),
    TRANSPORTASI("Transportasi"),
    KARYAWAN_SWASTA("Karyawan Swasta"),
    KARYAWAN_BUMN("Karyawan BUMN"),
    KARYAWAN_BUMD("Karyawan BUMD"),
    KARYAWAN_HONORER("Karyawan Honorer"),
    BURUH_HARIAN_LEPAS("Buruh Harian Lepas"),
    BURUH_TANI_OR_PERKEBUNAN("Buruh Tani / Perkebunan"),
    BURUH_NELAYAN_OR_PERIKANAN("Buruh Nelayan / Perikanan"),
    BURUH_PETERNAKAN("Buruh Peternakan"),
    PEMBANTU_RUMAH_TANGGA("Pembantu Rumah Tangga"),
    TUKANG_CUKUR("Tukang Cukur"),
    TUKANG_LISTRIK("Tukang Listrik"),
    TUKANG_BATU("Tukang Batu"),
    TUKANG_KAYU("Tukang Kayu"),
    TUKANG_SOL_SEPATU("Tukang Sol Sepatu"),
    TUKANG_LAS_OR_PANDAI_BESI("Tukang Las / Pandai Besi"),
    TUKANG_JAHIT("Tukang Jahit"),
    PENATA_RAMBUT("Penata Rambut"),
    PENATA_RIAS("Penata Rias"),
    PENATA_BUSANA("Penata Busana"),
    MEKANIK("Mekanik"),
    TUKANG_GIGI("Tukang Gigi"),
    SENIMAN("Seniman"),
    TABIB("Tabib"),
    PARAJI("Paraji"),
    PERANCANG_BUSANA("Perancang Busana"),
    PENTERJEMAH("Penterjemah"),
    IMAM_MASJID("Imam Masjid"),
    PENDETA("Pendeta"),
    PASTUR("Pastur"),
    WARTAWAN("Wartawan"),
    USTADZ_OR_MUBALIGH("Ustadz / Mubaligh"),
    JURU_MASAK("Juru Masak"),
    PROMOTOR_ACARA("Promotor Acara"),
    ANGGOTA_DPR_RI("Anggota DPR-RI"),
    ANGGOTA_DPD("Anggota DPD"),
    ANGGOTA_BPK("Anggota BPK"),
    PRESIDEN("Presiden"),
    WAKIL_PRESIDEN("Wakil Presiden"),
    ANGGOTA_MAHKAMAT_KONSTITUSI("Anggota Mahkamah Konstitusi"),
    ANGGOTA_KABINET_OR_KEMENTERIAN("Anggota Kabinet / Kementerian"),
    DUTA_BESAR("Duta Besar"),
    GUBERNUR("Gubernur"),
    WAKIL_GUBERNUR("Wakil Gubernur"),
    BUPATI("Bupati"),
    WAKIL_BUPATI("Wakil Bupati"),
    WALIKOTA("Walikota"),
    WAKIL_WALIKOTA("Wakil Walikota"),
    ANGGOTA_DPRD_PROPINSI("Anggota DPRD Propinsi"),
    ANGGOTA_DPRD_KABUPATEN_OR_KOTA("Anggota DPRD Kabupaten / Kota"),
    DOSEN("Dosen"),
    GURU("Guru"),
    PILOT("Pilot"),
    PENGACARA("Pengacara"),
    NOTARIS("Notaris"),
    ARSITEK("Arsitek"),
    AKUNTAN("Akuntan"),
    KONSULTAN("Konsultan"),
    DOKTER("Dokter"),
    BIDAN("Bidan"),
    PERAWAT("Perawat"),
    APOTEKER("Apoteker"),
    PSIKIATER_OR_PSIKOLOG("Psikiater / Psikolog"),
    PENYIAR_TELEVISI("Penyiar Televisi"),
    PENYIAR_RADIO("Penyiar Radio"),
    PELAUT("Pelaut"),
    PENELITI("Peneliti"),
    SOPIR("Sopir"),
    PIALANG("Pialang"),
    PARANORMAL("Paranormal"),
    PEDAGANG("Pedagang"),
    PERANGKAT_DESA("Perangkat Desa"),
    KEPALA_DESA("Kepala Desa"),
    BIARAWATI("Biarawati"),
    WIRASWASTA("Wiraswasta"),
    LAINNYA("Lainnya");

    private String opsi;
    private static final Map<String, Pekerjaan> map = new HashMap<>();
    static {
        for (Pekerjaan en : values()) {
            map.put(en.toString(), en);
        }
    }

    public static Pekerjaan valueFor(String name) {
        return map.get(name);
    }

    Pekerjaan(String opsi) {
        this.opsi = opsi;
    }

    @Override
    public String toString() {
        return opsi;
    }
}
