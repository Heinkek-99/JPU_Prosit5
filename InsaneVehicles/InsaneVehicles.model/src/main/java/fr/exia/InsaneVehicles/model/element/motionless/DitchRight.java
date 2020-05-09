package fr.exia.InsaneVehicles.model.element.motionless;

import fr.exia.InsaneVehicles.model.element.Permeability;
import fr.exia.InsaneVehicles.model.element.Sprite;

/**
 * @author Heidy Kengne
 *
 */

class DitchRight extends MotionlessElement {

    private static final Sprite SPRITE = new Sprite(']', "DitchRight.jpg");

  
    DitchRight() {
        super(SPRITE, Permeability.BLOCKING);
    }
}
