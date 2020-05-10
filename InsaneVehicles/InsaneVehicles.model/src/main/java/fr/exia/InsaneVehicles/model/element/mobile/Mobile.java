/**
 * 
 */
package fr.exia.InsaneVehicles.model.element.mobile;

import java.awt.Point;

import fr.exia.InsaneVehicles.model.IRoad;
import fr.exia.InsaneVehicles.model.element.Element;
import fr.exia.InsaneVehicles.model.element.Permeability;
import fr.exia.InsaneVehicles.model.element.Sprite;
import fr.exia.showboard.IBoard;

/**
 * @author Heidy Kengne
 *
 */
public abstract class Mobile extends Element implements IMobile{

	private Point   position;

    private Boolean alive = true;

    private IRoad   road;

    private IBoard  board;


    Mobile(final Sprite sprite, final IRoad road, final Permeability permeability) {
        super(sprite, permeability);
        this.setRoad(road);
        this.position = new Point();
    }


    Mobile(final int x, final int y, final Sprite sprite, final IRoad road, final Permeability permeability) {
        this(sprite, road, permeability);
        this.setX(x);
        this.setY(y);
    }

    public void moveUp() {
        this.setY(this.getY() - 1);
        this.setHasMoved();
    }

    public void moveLeft() {
        this.setX(this.getX() - 1);
        this.setHasMoved();
    }

    public void moveDown() {
        this.setY(this.getY() + 1);
        this.setHasMoved();
    }

    public void moveRight() {
        this.setX(this.getX() + 1);
        this.setHasMoved();
    }

    public void doNothing() {
        this.setHasMoved();
    }

    private void setHasMoved() {
        this.getRoad().setMobileHasChanged();
    }

    public final int getX() {
        return this.getPosition().x;
    }

    public final void setX(final int x) {
        this.getPosition().x = x;
        if (this.isCrashed()) {
            this.die();
        }
    }

    public final int getY() {
        return this.getPosition().y;
    }

    public final void setY(final int y) {
        this.getPosition().y = (y + this.getRoad().getHeight()) % this.getRoad().getHeight();
        if (this.isCrashed()) {
            this.die();
        }
    }

    public IRoad getRoad() {
        return this.road;
    }

    private void setRoad(final IRoad road) {
        this.road = road;
    }

    public Boolean isAlive() {
        return this.alive;
    }

    protected void die() {
        this.alive = false;
        this.setHasMoved();
    }

    public Boolean isCrashed() {
        return this.getRoad().getOnTheRoadXY(this.getX(), this.getY()).getPermeability() == Permeability.BLOCKING;
    }

    public Point getPosition() {
        return this.position;
    }

    public void setPosition(final Point position) {
        this.position = position;
    }

    protected IBoard getBoard() {
        return this.board;
    }

}
