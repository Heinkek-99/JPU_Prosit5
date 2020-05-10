/**
 * 
 */
package fr.exia.InsaneVehicles.model;

import java.io.IOException;

import fr.exia.InsaneVehicles.contract.IInsaneVehiclesModel;
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

	/**
	 * @return the road
	 */
	public IRoad getRoad() {
		return road;
	}

	/**
	 * @param road the road to set
	 */
	public void setRoad(IRoad road) {
		this.road = road;
	}

	/**
	 * @return the myVehicle
	 */
	public IMobile getMyVehicle() {
		return myVehicle;
	}

	/**
	 * @param myVehicle the myVehicle to set
	 */
	public void setMyVehicle(IMobile myVehicle) {
		this.myVehicle = myVehicle;
	}

}
