package se.kth.iv1350.inspectcar.controller;

import java.util.List;
import se.kth.iv1350.inspectcar.integration.DatabaseManager;
import se.kth.iv1350.inspectcar.integration.Garage;
import se.kth.iv1350.inspectcar.integration.InspectionItem;
import se.kth.iv1350.inspectcar.integration.Printer;
import se.kth.iv1350.inspectcar.model.Inspection;
import se.kth.iv1350.inspectcar.model.Vehicle;
import se.kth.iv1350.inspectcar.integration.PaymentAuthorization;
import se.kth.iv1350.inspectcar.model.Counter;
import se.kth.iv1350.inspectcar.integration.NoExistingVehicleException;
import se.kth.iv1350.inspectcar.integration.OperationFailedException;
/**
 * This is the application's single controller. All calls to the model pass through here.
 */
public class Controller {
    private DatabaseManager dbMgr;
    private Garage          garage;
    private PaymentAuthorization auth; 
    private Counter counter; 

    /**
     * Creates a new instance using the specified database manager.
     *
     * @param dbMgr The database manager used for all database calls.
     * @param garage The garage manages to open/close the door and display Queue
     */
    public Controller(DatabaseManager dbMgr, Garage garage, PaymentAuthorization auth, Counter counter) {
        this.dbMgr = dbMgr;
        this.garage= garage;
        this.auth = auth; 
        this.counter = counter;
    }  
    public int newInspection(){
        garage.nextInspection();
        dbMgr.clearResultsList();
        return garage.getQueNumber();
    }
    public void closeDoor() {
        garage.closeDoor();
    }
    public List <InspectionItem> getInspecion(){
    // InspectionItem car= new InspectionItem();
     List<InspectionItem> inspecL= dbMgr.getDummyInsp();
     
     return inspecL;
    }
    
    public List<InspectionItem> findInspectionByVehicle(String regNo) {
        Vehicle vehicle = new Vehicle(regNo);
        return dbMgr.findInspectionsByVehicle(vehicle);
    }
    
    public int enterRegNo(String regNo) {
        Vehicle vehicle = new Vehicle(regNo);

        Inspection inspection = new Inspection(vehicle, dbMgr);
        return inspection.getCost();
        
    }
    
    public void storeResult(InspectionItem part){
        
        dbMgr.storeResult(part);
    }
   
    public void printResult(List<InspectionItem> inspectionList, int cost){
        Printer printer = new Printer();
        
        printer.printResult(inspectionList, cost); 
    }
    public boolean authorize(){
        return auth.authorize();
    }
    public int getBalance() {
        return counter.getBalance();
    }
    public void addBalance() {
        counter.addBalance();
    }
    public void addPayment(int cost) {
        counter.addPayment(cost);
    }
    public int getPayment(){
        return counter.getPayment();
    } 
}   
