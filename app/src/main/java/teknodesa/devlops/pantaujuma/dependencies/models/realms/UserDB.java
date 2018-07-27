package teknodesa.devlops.pantaujuma.dependencies.models.realms;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Marthin on 7/3/2018.
 */

public class UserDB extends RealmObject {
    @PrimaryKey
    private String id;
    private String username;
    private String namaLengkap;
    private String phoneNumber;
    private String profilImage;
    private String namaDesa;
    private String email;
    private String roleName;
    private String keyRole;
    private String attributeTable;
    private String attributeValue;

    public UserDB() {
    }

    public UserDB(String id, String username, String namaLengkap, String phoneNumber, String profilImage,
                  String namaDesa, String email, String roleName, String keyRole, String attributeTable, String attributeValue) {
        this.id = id;
        this.username = username;
        this.namaLengkap = namaLengkap;
        this.phoneNumber = phoneNumber;
        this.profilImage = profilImage;
        this.namaDesa = namaDesa;
        this.email = email;
        this.roleName = roleName;
        this.keyRole = keyRole;
        this.attributeTable = attributeTable;
        this.attributeValue = attributeValue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProfilImage() {
        return profilImage;
    }

    public void setProfilImage(String profilImage) {
        this.profilImage = profilImage;
    }

    public String getNamaDesa() {
        return namaDesa;
    }

    public void setNamaDesa(String namaDesa) {
        this.namaDesa = namaDesa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getKeyRole() {
        return keyRole;
    }

    public void setKeyRole(String keyRole) {
        this.keyRole = keyRole;
    }

    public String getAttributeTable() {
        return attributeTable;
    }

    public void setAttributeTable(String attributeTable) {
        this.attributeTable = attributeTable;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }
}
