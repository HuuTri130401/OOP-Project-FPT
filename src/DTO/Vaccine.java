/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Admin
 */
public class Vaccine {
    private String idVc;
    private String nameVc;

    public Vaccine() {
    }

    public Vaccine(String idVc, String nameVc) {
        this.idVc = idVc;
        this.nameVc = nameVc;
    }

    public String getIdVc() {
        return idVc;
    }

    public String getNameVc() {
        return nameVc;
    }

    public void setNameVc(String nameVc) {
        this.nameVc = nameVc;
    }
    
    public void displayInforVc() {
        System.out.printf("|%-14s|%-21s\n", idVc, nameVc);
    }
    
    @Override
    public String toString() {
        return String.format("|%-14s|%-21s",idVc , nameVc);
    }
    
}
