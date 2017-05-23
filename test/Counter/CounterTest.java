/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Counter;


import static java.lang.Integer.MAX_VALUE;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import se.kth.iv1350.inspectcar.controller.Controller;
import se.kth.iv1350.inspectcar.integration.DatabaseManager;
import se.kth.iv1350.inspectcar.integration.Garage;
import se.kth.iv1350.inspectcar.integration.InspectionItem;

import se.kth.iv1350.inspectcar.integration.PaymentAuthorization;
import se.kth.iv1350.inspectcar.model.Counter;
/**
 *
 * @author Kristoffer
 */
public class CounterTest {
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
    public void testIfpaymentIfMaxInteger() {
        int max= MAX_VALUE;
        int expResult = contr.getBalance(); 
        
        contr.addPayment(max);
        contr.addPayment(max);
        contr.addBalance();
        
        int result = contr.getBalance();
        assertEquals("Counter can't be negative if postive funds are added", expResult, result);
    }
}
