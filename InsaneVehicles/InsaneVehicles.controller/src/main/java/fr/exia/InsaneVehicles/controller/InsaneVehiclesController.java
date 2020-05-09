/**
 * 
 */
package fr.exia.InsaneVehicles.controller;

import fr.exia.InsaneVehicles.contract.IIinsaneVehiclesController;
import fr.exia.InsaneVehicles.contract.IInsaneVehiclesModel;
import fr.exia.InsaneVehicles.contract.IInsaneVehiclesView;

/**
 * @author Heidy Kengne
 *
 */
public class InsaneVehiclesController implements  IOrderPerformer, IIinsaneVehiclesController{

    private static final int     speed = 300;

    private IInsaneVehiclesView  view;

    private IInsaneVehiclesModel model;

    private UserOrder            stackOrder;

    public InsaneVehiclesController(final IInsaneVehiclesView view, final IInsaneVehiclesModel model) {
        this.setView(view);
        this.setModel(model);
        this.clearStackOrder(); 
    }
    
    private void clearStackOrder() {
        this.stackOrder = UserOrder.NOP;
		
	}

	public final void play() throws InterruptedException {
        while (this.getModel().getMyVehicle().isAlive()) {
            Thread.sleep(speed);
            switch (this.getStackOrder()) {
                case RIGHT:
                    this.getModel().getMyVehicle().moveRight();
                    break;
                case LEFT:
                    this.getModel().getMyVehicle().moveLeft();
                    break;
                case NOP:
                default:
                    this.getModel().getMyVehicle().doNothing();
                    break;
            }
            this.clearStackOrder();
            if (this.getModel().getMyVehicle().isAlive()) {
                this.getModel().getMyVehicle().moveDown();
            }
            this.getView().followMyVehicle();
        }
        this.getView().displayMessage("CRASH !!!!!!!!!.");
    }

	/**
	 * @return the view
	 */
	private IInsaneVehiclesView getView() {
		return view;
	}

	/**
	 * @param view the view to set
	 */
	private void setView(IInsaneVehiclesView view) {
		this.view = view;
	}

	/**
	 * @return the model
	 */
	private IInsaneVehiclesModel getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	private void setModel(IInsaneVehiclesModel model) {
		this.model = model;
	}

	/**
	 * @return the stackOrder
	 */
	private UserOrder getStackOrder() {
		return stackOrder;
	}

	/**
	 * @param stackOrder the stackOrder to set
	 */
	private void setStackOrder(UserOrder stackOrder) {
		this.stackOrder = stackOrder;
	}
    
    
    
}
