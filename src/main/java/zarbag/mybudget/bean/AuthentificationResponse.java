package zarbag.mybudget.bean;

import java.io.Serializable;

public class AuthentificationResponse implements Serializable {
    private String jwt;

    public AuthentificationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }


}
