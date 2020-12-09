package zarbag.mybudget.z.bean;

import zarbag.mybudget.bean.Groupe;

public class Pourcentage {

    private double pour;
    private String groupe;

    public Pourcentage(double pour,String groupe) {
        this.pour = pour;
        this.groupe = groupe;
    }

    public double getPour() {
        return pour;
    }

    public void setPour(double pour) {
        this.pour = pour;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String  groupe) {
        this.groupe = groupe;
    }
}
