/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.inspectcar.integration;

import java.lang.Exception;
import se.kth.iv1350.inspectcar.model.Vehicle;

/**
 *
 * @author Kristoffer
 */
public class NoExistingVehicleException extends Exception{
    private Vehicle noExistingVehicle; 
    
    public NoExistingVehicleException(Vehicle noExistingVehicle) {
        
        super("Can not find Vehicle with registrationNo:" + noExistingVehicle.getRegNo() + "in the vehicle database");
        this.noExistingVehicle = noExistingVehicle;
    }
    
    public Vehicle NoExistingVehicle() {
        return noExistingVehicle; 
    }
}
