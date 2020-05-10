/**
 * 
 */
package fr.exia.InsaneVehicles.model.element.mobile;

import java.awt.Point;

import fr.exia.InsaneVehicles.model.element.IElement;
import fr.exia.showboard.IPawn;

/**
 * @author Heidy Kengne
 *
 */
public interface IMobile extends IPawn, IElement {

    void moveUp();

    void moveLeft();

    void moveDown();

    void moveRight();

    void doNothing();

    int getX();

    int getY();

    Boolean isAlive();

    Boolean isCrashed();

    Point getPosition();

}
