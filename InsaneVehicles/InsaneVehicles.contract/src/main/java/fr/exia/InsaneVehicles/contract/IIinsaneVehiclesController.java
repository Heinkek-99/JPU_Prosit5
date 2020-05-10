/**
 * 
 */
package fr.exia.InsaneVehicles.contract;

import fr.exia.InsaneVehicles.controller.IOrderPerformer;

/**
 * @author Heidy Kengne
 *
 */
public interface IIinsaneVehiclesController {

	void play() throws InterruptedException;
	 
    IOrderPerformer getOrderPeformer();

}
