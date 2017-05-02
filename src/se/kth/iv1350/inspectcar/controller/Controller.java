package se.kth.iv1350.inspectcar.controller;

import java.util.List;
import se.kth.iv1350.inspectcar.integration.DatabaseManager;
import se.kth.iv1350.inspectcar.integration.Garage;
import se.kth.iv1350.inspectcar.integration.InspectionItem;
import se.kth.iv1350.inspectcar.integration.Printer;
import se.kth.iv1350.inspectcar.model.Inspection;
import se.kth.iv1350.inspectcar.model.Vehicle;

/**
 * This is the application's single controller. All calls to the model pass through here.
 */
public class Controller {
    private DatabaseManager dbMgr;
    private Garage          garage;

    /**
     * Creates a new instance using the specified database manager.
     *
     * @param dbMgr The database manager used for all database calls.
     * @param garage The garage manages to open/close the door and display Queue
     */
    public Controller(DatabaseManager dbMgr, Garage garage) {
        this.dbMgr = dbMgr;
        this.garage= garage;
    }
    
    public void newInspection(){
       garage.nextInspection();

    }
    
    public void closeDoor() {
        garage.closeDoor();
    }
    
    public List <InspectionItem> getInspecion(){
    // InspectionItem car= new InspectionItem();
     List<InspectionItem> inspecL= dbMgr.getDummyInsp();
     
     return inspecL;
    }
    
    

    /**
     * Verifies that there are inspections to perform for the vehicle with the specified
     * registration number. If there are inspections, returns the total cost for the inspections.
     * Returns 0 if there are no inspections to perform. This will instead be indicated with an
     * exception in a future version.
     *
     * @param regNo The registration number of the vehicle to inspect.
     * @return The total cost for the inspections, or 0 if there are no inspections to perform.
     */
    public int enterRegNo(String regNo) {
        Vehicle vehicle = new Vehicle(regNo);
        Inspection inspection = new Inspection(vehicle, dbMgr);
        return inspection.getCost();
    }
    
    public void storeResult(InspectionItem part){
        
        dbMgr.storeResult(part);
    }
   
    public void printResult(List<InspectionItem> inspectionList){
        Printer printer = new Printer();
        
        printer.printResult(inspectionList);
        
    }
}   
