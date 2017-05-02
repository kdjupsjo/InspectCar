package se.kth.iv1350.inspectcar.startup;

import se.kth.iv1350.inspectcar.controller.Controller;
import se.kth.iv1350.inspectcar.integration.DatabaseManager;
import se.kth.iv1350.inspectcar.integration.Garage;
import se.kth.iv1350.inspectcar.view.View;
import se.kth.iv1350.inspectcar.integration.Printer;
/**
 * Starts the application.
 */
public class Main {
    /**
     * This is the application's main method, which starts the entire car inspection system.
     * 
     * @param args The are no command line parameters.
     */
    public static void main(String[] args) {
        DatabaseManager dbMgr = new DatabaseManager();
        //Garage garage = new Garage();
        Controller contr = new Controller(dbMgr, garage);
        View view = new View(contr);
        view.sampleExecution();
        
        Printer printer= new Printer();
    }
}
