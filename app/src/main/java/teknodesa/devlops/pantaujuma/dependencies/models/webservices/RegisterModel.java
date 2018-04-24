package teknodesa.devlops.pantaujuma.dependencies.models.webservices;

/**
 * Created by Marthin on 2/23/2018.
 */

public class RegisterModel {
    private String namaLengkap;
    private String password;
    private String email;
    private String phoneNumber;

    public RegisterModel() {
    }

    public RegisterModel(String namaLengkap, String email, String password,String phoneNumber) {
        this.namaLengkap = namaLengkap;
        this.password = password;
        this.email = email;
        this.phoneNumber =phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
