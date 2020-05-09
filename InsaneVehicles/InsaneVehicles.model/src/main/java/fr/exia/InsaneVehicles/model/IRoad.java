/**
 * 
 */
package fr.exia.InsaneVehicles.model;

import java.util.Observable;

import fr.exia.InsaneVehicles.model.element.IElement;

/**
 * @author Heidy Kengne
 *
 */
public interface IRoad {

    int getWidth();

    int getHeight();

    IElement getOnTheRoadXY(int x, int y);

    void setMobileHasChanged();

    Observable getObservable();

}
