/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.inspectcar.integration;

/**
 *
 * @author Kristoffer
 
 */
public class PaymentAuthorization {
    private boolean authorize = true;           
    
    public PaymentAuthorization() {                 //Creates Payment Authorization that always returns true (dummy Implementation)
        this.authorize = true; 
    }
    
    public boolean authorize() {
        return authorize; 
    }
}
