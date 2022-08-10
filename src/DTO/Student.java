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
public class Student{
    private String idST;
    private String nameST;

    public Student() {
    }
    
    public Student(String idST, String nameST) {
        this.idST = idST;
        this.nameST = nameST;
    }

    public String getIdST() {
        return idST;
    }

    public String getNameST() {
        return nameST;
    }

    public void setNameST(String nameST) {
        this.nameST = nameST;
    }

    public void displayInforSt() {
        System.out.printf("|%-16s|%-21s\n", idST, nameST);
    }
    
    @Override
    public String toString() {
        return String.format("|%-16s|%-21s", idST, nameST);
    }
    
}
