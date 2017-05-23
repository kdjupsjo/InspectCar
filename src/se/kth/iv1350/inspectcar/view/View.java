package se.kth.iv1350.inspectcar.view;

import java.util.List;
import java.util.Scanner;
import se.kth.iv1350.inspectcar.controller.Controller;
import se.kth.iv1350.inspectcar.integration.InspectionItem;


/**
 * This class is a placeholder for the view.
 */
public class View {

    private final Controller contr;
    private final Scanner sc = new Scanner(System.in);
    private boolean partPassed; 
    private int queNo;
    /**
     * Creates a new instance that will use the specified controller for all
     * system operations.
     *
     * @param contr The controller to use for system operations.
     */
    public View(Controller contr) {
        this.contr = contr;

    }

    /**
     * Calls all system operations and prints the result to
     * <code>System.out</code>.
     */
    public void sampleExecution() {
        queNo = contr.newInspection();                                      //Start new Inspection
                                  
        System.out.println("Enter Regnumber of Vehicle:");
        String regNoOfVehicleToInspect = sc.nextLine(); 
        if(regNoOfVehicleToInspect.equals("Exit")){ }
        contr.enterRegNo(regNoOfVehicleToInspect);

        System.out.println("Quenumber: " + queNo);                              //Display QueNumber 

        List<InspectionItem> reginspec = contr.findInspectionByVehicle(regNoOfVehicleToInspect);
        
        int i = 0;
        for(InspectionItem e : reginspec) {
            System.out.println(e.getName());
            partPassed = sc.nextBoolean();
            
            if(partPassed) {
                e.setResult(true);
                contr.addPayment(e.getCost());
            } else { e.setResult(false); }
            
            contr.storeResult(reginspec.get(i));  
            i++;
        }

        if (contr.authorize()) {
            contr.printResult(reginspec, contr.getPayment());
            contr.addBalance();
            System.out.println("Current value in counter is now: " + contr.getBalance()+" Kr"); //Update counter
        }
        
        System.out.println("Starting next Inspection...");
        
        String nextInsp = sc.nextLine();
        if (nextInsp.equals("a")) {
            System.exit(0);
        }
        contr.closeDoor();
}
}