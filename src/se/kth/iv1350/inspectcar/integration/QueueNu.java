/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.inspectcar.integration;

/**
 *
 * @author masaralmosawi
 */
public class QueueNu {

    private int queuenumber;

    QueueNu() {

        queuenumber = 0;

    }
    
    public int incrment(){
        queuenumber++;
        return queuenumber; 
                
    }

}
