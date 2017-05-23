/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.inspectcar.integration;
import java.lang.Exception;
/**
 *
 * @author Kristoffer
 */
public class OperationFailedException extends Exception {
    
    public OperationFailedException(String msg, Exception cause){
        super(msg, cause); 
    }
}
