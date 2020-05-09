/**
 * 
 */
package fr.exia.InsaneVehicles.model;

import java.io.IOException;

import fr.exia.InsaneVehicles.model.element.mobile.IMobile;
import fr.exia.InsaneVehicles.model.element.mobile.MyVehicle;

/**
 * @author Heidy Kengne
 *
 */
public class InsaneVehiclesModel implements IInsaneVehiclesModel {

    private IRoad   road;

    private IMobile myVehicle;

    public InsaneVehiclesModel(final String fileName, final int myVehicleStartX, final int myVehicleStartY)
            throws IOException {
        this.setRoad(new Road(fileName));
        this.setMyVehicle(new MyVehicle(myVehicleStartX, myVehicleStartY, this.getRoad()));
    }
    
    public final IRoad getRoad() {
        return this.road;
    }
    
    private void setRoad(final IRoad road) {
        this.road = road;
    }
    
    public final IMobile getMyVehicle() {
        return this.myVehicle;
    }
    
    private void setMyVehicle(final IMobile myVehicle) {
        this.myVehicle = myVehicle;
    }
}
