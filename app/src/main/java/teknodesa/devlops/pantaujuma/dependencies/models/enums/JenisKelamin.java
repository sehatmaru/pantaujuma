package teknodesa.devlops.pantaujuma.dependencies.models.enums;

public enum JenisKelamin {
    CHOOSE("Jenis Kelamin"),
    LAKI("Laki-laki"),
    PEREMPUAN("Perempuan");

    private String opsi;

    JenisKelamin(String opsi) {
        this.opsi = opsi;
    }
        
    @Override
    public String toString() {
        return opsi;
    }
}