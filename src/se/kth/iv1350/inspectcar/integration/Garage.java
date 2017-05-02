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
    private QueueNu queue;

    Garage() {
        door = new GarageDoor();
        display = new Display();
        queue = new QueueNu();
    }

    public void nextInspection() {
        int number = queue.incrment();
        display.displayNumber(number);
        door.openDoor();
    }

    public void closeDoor() {

    }
}
