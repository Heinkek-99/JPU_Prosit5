package fr.exia.InsaneVehicles.model.element.motionless;

import fr.exia.InsaneVehicles.model.element.Permeability;
import fr.exia.InsaneVehicles.model.element.Sprite;

/**
 * @author Heidy Kengne
 *
 */

class Tree extends MotionlessElement {

    private static final Sprite SPRITE = new Sprite('^', "Tree.jpg");

    Tree() {
        super(SPRITE, Permeability.BLOCKING);
    }
}
