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
public class GarageDoor {

    private boolean openDoor;               

    GarageDoor() {                          //Creates a door, cloesed by default
        openDoor = false;
    }

    void openDoor() {
        openDoor = true;
    }

    void closeDoor() {
        openDoor = false;
    }

}
