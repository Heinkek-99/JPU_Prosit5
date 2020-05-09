package fr.exia.InsaneVehicles.model.element.motionless;

import fr.exia.InsaneVehicles.model.element.Permeability;
import fr.exia.InsaneVehicles.model.element.Sprite;

/**
 * @author Heidy Kengne
 *
 */

class Obstacle extends MotionlessElement {

    private static final Sprite SPRITE = new Sprite('X', "Obstacle.jpg");

    Obstacle() {
        super(SPRITE, Permeability.BLOCKING);
    }
}
