package se.kth.iv1350.inspectcar.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.lang.Exception;
import java.util.List;
import se.kth.iv1350.inspectcar.integration.DatabaseManager;
import se.kth.iv1350.inspectcar.integration.InspectionItem;
import se.kth.iv1350.inspectcar.integration.NoExistingVehicleException;
import se.kth.iv1350.inspectcar.integration.OperationFailedException;

/**
 * Represents an inspection of a vehicle.
 */
public class Inspection {
    private final Vehicle vehicle;
    private List<InspectionItem> inspections;

    /**
     * Creates a new instance, representing an inspection of the specified vehicle.
     *
     * @param vehicle The vehicle that is inspected.
     * @param dbMgr   The database manager to use when searching for inspections for the specified
     *                vehicle.
     * @throws se.kth.iv1350.inspectcar.integration.NoExistingVehicleException
     * @throws se.kth.iv1350.inspectcar.integration.OperationFailedException
     * @throws java.io.FileNotFoundException
     */
    public Inspection(Vehicle vehicle, DatabaseManager dbMgr) {
        this.vehicle = vehicle;
 
        this.inspections = dbMgr.findInspectionsByVehicle(vehicle);
        
    }

    /**
     * @return The cost of this inspection.
     */
    public int getCost() {
        int totalCost = 0;
        if (inspections == null) {
            return 0;
        }
        for (InspectionItem inspItem : inspections) {
            totalCost = totalCost + inspItem.getCost();
        }
        return totalCost;
    }
}
