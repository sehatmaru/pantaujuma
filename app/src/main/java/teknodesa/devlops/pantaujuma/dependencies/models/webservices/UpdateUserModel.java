package teknodesa.devlops.pantaujuma.dependencies.models.webservices;

/**
 * Created by Marthin on 3/28/2018.
 */

public class UpdateUserModel {
    private String idUser;
    private String namaLengkap;
    private String phoneNumber;
    private String profileImage;

    public UpdateUserModel() {

    }

    public UpdateUserModel(String idUser,String namaLengkap, String phoneNumber, String profileImage) {
        this.idUser =  idUser;
        this.namaLengkap = namaLengkap;
        this.phoneNumber = phoneNumber;
        this.profileImage = profileImage;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
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

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
}
