/**
 * 
 */
package fr.exia.InsaneVehicles.model.element.mobile;

import java.io.IOException;

import fr.exia.InsaneVehicles.model.IRoad;
import fr.exia.InsaneVehicles.model.element.Permeability;
import fr.exia.InsaneVehicles.model.element.Sprite;

/**
 * @author Heidy Kengne
 *
 */
public class MyVehicle extends Mobile{

    private static final Sprite sprite          = new Sprite('H', "MyVehicle.png");

    private static final Sprite spriteTurnLeft  = new Sprite('H', "MyVehicleLeft.png");

    private static final Sprite spriteTurnRight = new Sprite('H', "MyVehicleRight.png");

    private static final Sprite spriteExplode   = new Sprite('H', "MyVehicleExplode.png");

    public MyVehicle(final int x, final int y, final IRoad road) throws IOException {
        super(x, y, sprite, road, Permeability.BLOCKING);
        spriteTurnLeft.loadImage();
        spriteTurnRight.loadImage();
        spriteExplode.loadImage();
    }

    public final void moveLeft() {
        super.moveLeft();
        this.setSprite(spriteTurnLeft);
    }

    public final void moveRight() {
        super.moveRight();
        this.setSprite(spriteTurnRight);
    }

    protected final void die() {
        super.die();
        this.setSprite(spriteExplode);
    }

    public final void doNothing() {
        super.doNothing();
        this.setSprite(sprite);
    }
}
