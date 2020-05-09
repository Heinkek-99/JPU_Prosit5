package fr.exia.InsaneVehicles.model.element.motionless;

import fr.exia.InsaneVehicles.model.element.Permeability;
import fr.exia.InsaneVehicles.model.element.Sprite;

/**
 * @author Heidy Kengne
 *
 */
class Macadam extends MotionlessElement {

    private static final Sprite SPRITE = new Sprite(' ', "Macadam.jpg");

    Macadam() {
        super(SPRITE, Permeability.PENETRABLE);
    }
}
