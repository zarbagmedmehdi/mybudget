package zarbag.mybudget.z.bean;

public class ResetPassword {
    private String oldPass;
    private String newPass;
    private String newRPass;
    private String token;

    public ResetPassword() {
    }

    public String getOldPass() {
        return oldPass;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }

    public String getNewRPass() {
        return newRPass;
    }

    public void setNewRPass(String newRPass) {
        this.newRPass = newRPass;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
