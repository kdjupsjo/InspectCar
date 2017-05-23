/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueueNu;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import se.kth.iv1350.inspectcar.controller.Controller;
import se.kth.iv1350.inspectcar.integration.DatabaseManager;
import se.kth.iv1350.inspectcar.integration.Garage;


import se.kth.iv1350.inspectcar.integration.PaymentAuthorization;
import se.kth.iv1350.inspectcar.model.Counter;
/**
 *
 * @author Kristoffer
 */
public class QueueNuTest {
    private DatabaseManager dbMgr; 
    private Controller contr;
    private Garage garage = new Garage();
    private PaymentAuthorization auth = new PaymentAuthorization(); 
    private Counter counter = new Counter(750);
    
    @Before
    public void setUp() {
        dbMgr = new DatabaseManager();
        contr = new Controller(dbMgr, garage, auth, counter);
    }
    @After
    public void tearDown() {
        dbMgr = null;
        contr = null;
    }
    @Test
    public void testQueNumber() {
    contr.newInspection();
    int result = contr.newInspection();
    
    int expResult = 2;
    
    assertEquals("Quenumber skipping numbers", expResult, result);   
    }

}
