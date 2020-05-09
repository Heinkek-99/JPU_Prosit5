/**
 * 
 */
package fr.exia.InsaneVehicles.view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import fr.exia.InsaneVehicles.contract.IInsaneVehiclesView;
import fr.exia.InsaneVehicles.model.IRoad;
import fr.exia.InsaneVehicles.model.element.mobile.IMobile;
import fr.exia.showboard.BoardFrame;

/**
 * @author Heidy Kengne
 *
 */
public class InsaneVehiclesView implements Runnable,KeyListener, IInsaneVehiclesView {

    private static final int roadView   = 10;

    private static final int squareSize = 50;

    private Rectangle        closeView;

    private IRoad            road;

    private IMobile          myVehicle;

    private int              view;

    private IOrderPerformer  orderPerformer;

    public InsaneVehiclesView(final IRoad road, final IMobile myVehicle) throws IOException {
        this.setView(roadView);
        this.setRoad(road);
        this.setMyVehicle(myVehicle);
        this.getMyVehicle().getSprite().loadImage();
        this.setCloseView(new Rectangle(0, this.getMyVehicle().getY(), this.getRoad().getWidth(), roadView));
        SwingUtilities.invokeLater(this);
    }
    
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    
    public final void run() {
        final BoardFrame boardFrame = new BoardFrame("Close view");
        boardFrame.setDimension(new Dimension(this.getRoad().getWidth(), this.getRoad().getHeight()));
        boardFrame.setDisplayFrame(this.closeView);
        boardFrame.setSize(this.closeView.width * squareSize, this.closeView.height * squareSize);
        boardFrame.setHeightLooped(true);
        boardFrame.addKeyListener(this);
        boardFrame.setFocusable(true);
        boardFrame.setFocusTraversalKeysEnabled(false);

        for (int x = 0; x < this.getRoad().getWidth(); x++) {
            for (int y = 0; y < this.getRoad().getHeight(); y++) {
                boardFrame.addSquare(this.road.getOnTheRoadXY(x, y), x, y);
            }
        }
        boardFrame.addPawn(this.getMyVehicle());

        this.getRoad().getObservable().addObserver(boardFrame.getObserver());
        this.followMyVehicle();

        boardFrame.setVisible(true);
    }
    
    public final void show(final int yStart) {
        int y = yStart % this.getRoad().getHeight();
        for (int view = 0; view < this.getView(); view++) {
            for (int x = 0; x < this.getRoad().getWidth(); x++) {
                if ((x == this.getMyVehicle().getX()) && (y == yStart)) {
                    System.out.print(this.getMyVehicle().getSprite().getConsoleImage());
                } else {
                    System.out.print(this.getRoad().getOnTheRoadXY(x, y).getSprite().getConsoleImage());
                }
            }
            y = (y + 1) % this.getRoad().getHeight();
            System.out.print("\n");
        }
    }
    
    private static UserOrder keyCodeToUserOrder(final int keyCode) {
        UserOrder userOrder;
        switch (keyCode) {
            case KeyEvent.VK_RIGHT:
                userOrder = UserOrder.RIGHT;
                break;
            case KeyEvent.VK_LEFT:
                userOrder = UserOrder.LEFT;
                break;
            default:
                userOrder = UserOrder.NOP;
                break;
        }
        return userOrder;
    }
    
    public void keyTyped(final KeyEvent keyEvent) {
        // Nop
    }
    
    public final void keyPressed(final KeyEvent keyEvent) {
        try {
            this.getOrderPerformer().orderPerform(keyCodeToUserOrder(keyEvent.getKeyCode()));
        } catch (final IOException exception) {
            exception.printStackTrace();
        }
    }
    
    public void keyReleased(final KeyEvent keyEvent) {
        // Nop
    }
    
    
    public final void followMyVehicle() {
        this.getCloseView().y = this.getMyVehicle().getY() - 1;
    }
    
    private void setRoad(final IRoad road) throws IOException {
        this.road = road;
        for (int x = 0; x < this.getRoad().getWidth(); x++) {
            for (int y = 0; y < this.getRoad().getHeight(); y++) {
                this.getRoad().getOnTheRoadXY(x, y).getSprite().loadImage();
            }
        }
    }
    
    private IMobile getMyVehicle() {
        return this.myVehicle;
    }
    
    private void setMyVehicle(final IMobile myVehicle) {
        this.myVehicle = myVehicle;
    }
    
    private int getView() {
        return this.view;
    }
    
    private void setView(final int view) {
        this.view = view;
    }
    
    private Rectangle getCloseView() {
        return this.closeView;
    }
    
    private void setCloseView(final Rectangle closeView) {
        this.closeView = closeView;
    }
    
    private IOrderPerformer getOrderPerformer() {
        return this.orderPerformer;
    }
    
    public final void setOrderPerformer(final IOrderPerformer orderPerformer) {
        this.orderPerformer = orderPerformer;
    }
    
}
