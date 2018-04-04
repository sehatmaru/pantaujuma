package deltechs.devlops.infodes.models.enums;

public enum Agama{
    ISLAM("Islam"),
    KATOLIK("Katolik"),
    PROTESTAN("Protestan"),
    HINDU("Hindu"),
    BUDHA("Budha"),
    LAINNYA("Lainnya");

    private String opsi;

    Agama(String opsi) {
        this.opsi = opsi;
    }
        
    @Override
    public String toString() {
        return opsi;
    }
}