package user;

public class UserDTO {
    private String id;
    private String password;
    private String name;
    private String schoolEmail;
    private String bankName;
    private String bankAccount;
    private boolean isActive;

    public UserDTO() {
    }

    public UserDTO(String id, String password, String name, String schoolEmail, String bankName, String bankAccount) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.schoolEmail = schoolEmail;
        this.bankName = bankName;
        this.bankAccount = bankAccount;
        this.isActive = true;
    }

    public UserDTO(String id, String password, String name, String schoolEmail, String bankName, String bankAccount, boolean isActive) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.schoolEmail = schoolEmail;
        this.bankName = bankName;
        this.bankAccount = bankAccount;
        this.isActive = isActive;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchoolEmail() {
        return schoolEmail;
    }

    public void setSchoolEmail(String schoolEmail) {
        this.schoolEmail = schoolEmail;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", schoolEmail='" + schoolEmail + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
