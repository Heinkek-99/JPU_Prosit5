package fr.exia.InsaneVehicles.model.element.motionless;

import fr.exia.InsaneVehicles.model.element.Permeability;
import fr.exia.InsaneVehicles.model.element.Sprite;

/**
 * @author Heidy Kengne
 *
 */

class DitchRightTurnRight extends MotionlessElement {

    private static final Sprite SPRITE = new Sprite(')', "DitchRightTurnRight.jpg");

    DitchRightTurnRight() {
        super(SPRITE, Permeability.BLOCKING);
    }
}
