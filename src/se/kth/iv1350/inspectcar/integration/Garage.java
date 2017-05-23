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
public class Garage {

    private GarageDoor door;
    private Display display;
    private int queNo = 0;
    
    public Garage() {                               //Create a garage
        door = new GarageDoor();
        display = new Display();
        this.queNo = 0;
    }

    public void nextInspection() {                  //Starts new Inspection and increase the quenumber
       queNo = queNo + 1;
       display.displayNumber(queNo);
       door.openDoor();
        
    }

    public void closeDoor() {                   //close garage door
        door.closeDoor();
    }
    
    public int getQueNumber(){                  //Retrieves the quenumbers
        return queNo; 
    } 
}
