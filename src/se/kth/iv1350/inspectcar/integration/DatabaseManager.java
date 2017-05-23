package se.kth.iv1350.inspectcar.integration;

import java.lang.Exception;
import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.inspectcar.model.Vehicle;
import se.kth.iv1350.inspectcar.integration.OperationFailedException;

/**
 * This class is responsible for database calls. This is the only place the database is called.
 */
public class DatabaseManager {
    private List<InspectionItem> dummyInspectionList;
    private List<InspectionItem> anotherDummyInspectionList;
    public List<InspectionItem> resultList;

    /**
     * Creates a new instance, which uses a hard coded list of inspections instead of calling a
     * database.
     */
    public DatabaseManager() {
        createDummyInspections();
        createResultList();
    }

    /**
     * Searches the database for inspections to be performed on the specified vehicle. This dummy
     * implementation returns hard coded inspections for some vehicles.
     *
     * @param vehicle The vehicle to inspect.
     * @return A list of <code>InspectionItem</code>s, where each element describes one particular
     *         control.
     * @throws se.kth.iv1350.inspectcar.integration.NoExistingVehicleException
     */
    /*
    public List<InspectionItem> findInspectionsByVehicle(Vehicle vehicle) throws NoExistingVehicleException {
            if (vehicle.getRegNo().equals("ABC123")) {
                return dummyInspectionList;
        }
        return null;
    }*/
    
   
    public List<InspectionItem> findInspectionsByVehicle(Vehicle vehicle) {
            
        if (vehicle.getRegNo().equals("ABC123")) {
            return dummyInspectionList; 
        }
        if (vehicle.getRegNo().equals("DEF111")) {
            return anotherDummyInspectionList; 
        }
        return null;
    }

    private void createDummyInspections() {
        dummyInspectionList = new ArrayList<>();
        dummyInspectionList.add(new InspectionItem("brakes", 10));
        dummyInspectionList.add(new InspectionItem("suspension", 20));
        dummyInspectionList.add(new InspectionItem("stearing", 30));
        
        anotherDummyInspectionList = new ArrayList<>();
        anotherDummyInspectionList.add(new InspectionItem("back light", 200));
        anotherDummyInspectionList.add(new InspectionItem("stearing", 150));
        anotherDummyInspectionList.add(new InspectionItem("window", 75));
        anotherDummyInspectionList.add(new InspectionItem("back light", 200));
        anotherDummyInspectionList.add(new InspectionItem("front wheel", 350));
        
    }
    private void createResultList() {
        resultList = new ArrayList<>();
    }
    public List<InspectionItem> getDummyInsp(){
     return dummyInspectionList;
    }
    
    public void storeResult(InspectionItem part){
        //part.setResult(true);
        resultList.add(part);
    }
    public void clearResultsList() {
        resultList.clear();
    }
    
}
