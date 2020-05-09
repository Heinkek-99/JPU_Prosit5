package fr.exia.InsaneVehicles.model.element.motionless;

import fr.exia.InsaneVehicles.model.element.Permeability;
import fr.exia.InsaneVehicles.model.element.Sprite;

/**
 * @author Heidy Kengne
 *
 */

class DitchLeftTurnRight extends MotionlessElement {

    private static final Sprite SPRITE = new Sprite('{', "DitchLeftTurnRight.jpg");

    DitchLeftTurnRight() {
        super(SPRITE, Permeability.BLOCKING);
    }
}
