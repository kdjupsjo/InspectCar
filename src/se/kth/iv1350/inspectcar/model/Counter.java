/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.inspectcar.model;

import static java.lang.Integer.MAX_VALUE;

/**
 *
 * @author Kristoffer
 */
public class Counter {
    private int balance; 
    private final int counterLimit =MAX_VALUE;
    private int customerPayment = 0; 
    
    public Counter(int balance) {                   //Create Counter with a specific balance
        this.balance = balance; 
    }
    
    public int getBalance() {                       //Return balance
        return balance; 
    }
    public void addBalance() {
         
        if(balance > 0.5*counterLimit) {
        System.out.println("Limit exceeded");       //If balance exceeds the counter limit
        return;
        } 
        balance = balance + customerPayment;
        customerPayment = 0;
    }
    public void addPayment(int cost) {
        customerPayment += cost;
    }
    public int getPayment(){
        return customerPayment;
    }
}
