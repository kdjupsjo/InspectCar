/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.inspectcar.model;

/**
 *
 * @author masaralmosawi
 */
public class creditCard {

    private int CVC;
    private String number;
    private String Cholder;
    private String expDate;

    public creditCard(int CVC, String number, String Cholder, String expdate) {
        this.CVC = CVC;
        this.Cholder = Cholder;
        this.expDate = expDate;
        this.number = number;
    }

    public void setCVC(int CVC) {
        this.CVC = CVC;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCholder(String Cholder) {
        this.Cholder = Cholder;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }
    
    

}
