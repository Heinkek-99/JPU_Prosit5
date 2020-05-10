/**
 * 
 */

package fr.exia.InsaneVehicles.main;

import java.io.IOException;

import fr.exia.InsaneVehicles.contract.IIinsaneVehiclesController;
import fr.exia.InsaneVehicles.contract.IInsaneVehiclesModel;
import fr.exia.InsaneVehicles.controller.InsaneVehiclesController;	
import fr.exia.InsaneVehicles.model.InsaneVehiclesModel;
import fr.exia.InsaneVehicles.view.InsaneVehiclesView;

/**
 * @author Heidy Kengne
 *
 */
public class InsaneVehicles {

	private static final int startX = 5;

	private static final int startY = 0;
/**
 * @param args
 */
	 public static void main(final String[] args) throws IOException, InterruptedException {
	// TODO Auto-generated method stub
	/**
	 * 
	 */	
	final IInsaneVehiclesModel model = new InsaneVehiclesModel("road.txt", startX, startY);
	final InsaneVehiclesView view = new InsaneVehiclesView(model.getRoad(), model.getMyVehicle());
	final IIinsaneVehiclesController controller = new InsaneVehiclesController(view, model);
	view.setOrderPerformer(controller.getOrderPeformer());

		      controller.play();
		}


}
