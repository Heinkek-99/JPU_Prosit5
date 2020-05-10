/**
 * 
 */
package fr.exia.InsaneVehicles.contract;

import fr.exia.InsaneVehicles.model.IRoad;
import fr.exia.InsaneVehicles.model.element.mobile.IMobile;

/**
 * @author Heidy Kengne
 *
 */
public interface IInsaneVehiclesModel {

    IRoad getRoad();

	
    IMobile getMyVehicle();

}
