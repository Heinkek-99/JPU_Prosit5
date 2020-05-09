package fr.exia.InsaneVehicles.model.element.motionless;

import fr.exia.InsaneVehicles.model.element.Permeability;
import fr.exia.InsaneVehicles.model.element.Sprite;

/**
 * @author Heidy Kengne
 *
 */

class DitchRightTurnLeft extends MotionlessElement {

    private static final Sprite SPRITE = new Sprite('}', "DitchRightTurnLeft.jpg");

    
    DitchRightTurnLeft() {
        super(SPRITE, Permeability.BLOCKING);
    }
}
