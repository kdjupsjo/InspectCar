/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InspectionItem;



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
public class InspectionItemTest {
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
    public void testUnmarkedInspectionParts() {
        ArrayList<InspectionItem> testList = new ArrayList<>();
        testList.add(new InspectionItem("Test1",1));
        testList.add(new InspectionItem("Test2",2));
        testList.add(new InspectionItem("Test3",20));
        
        testList.get(0).setResult(true);
        testList.get(2).setResult(false);
        boolean result= false;
        boolean expResult= testList.get(1).getResult();
        
        assertEquals("The program do not assume unmarked results as unrepaired", expResult, result);
    }
}
