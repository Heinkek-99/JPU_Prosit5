package fr.exia.InsaneVehicles.model.element.motionless;

import fr.exia.InsaneVehicles.model.element.Permeability;
import fr.exia.InsaneVehicles.model.element.Sprite;

/**
 * @author Heidy Kengne
 *
 */

class DitchLeft extends MotionlessElement {

    private static final Sprite SPRITE = new Sprite('[', "DitchLeft.jpg");

    DitchLeft() {
        super(SPRITE, Permeability.BLOCKING);
    }
}
