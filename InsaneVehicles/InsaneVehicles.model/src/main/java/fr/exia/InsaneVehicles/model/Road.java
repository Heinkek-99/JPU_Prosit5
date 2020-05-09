/**
 * 
 */
package fr.exia.InsaneVehicles.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;

import fr.exia.InsaneVehicles.model.element.IElement;

/**
 * @author Heidy Kengne
 *
 */
public class Road extends Observable implements IRoad {

    private int          width;

    private int          height;

    private IElement[][] onTheRoad;

    Road(final String fileName) throws IOException {
        super();
        this.loadFile(fileName);
    }
    
    private void loadFile(final String fileName) throws IOException {
        final BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line;
        int y = 0;
        line = buffer.readLine();
        this.setWidth(Integer.parseInt(line));
        line = buffer.readLine();
        this.setHeight(Integer.parseInt(line));
        this.onTheRoad = new IElement[this.getWidth()][this.getHeight()];
        line = buffer.readLine();
        while (line != null) {
            for (int x = 0; x < line.toCharArray().length; x++) {
                this.setOnTheRoadXY(MotionlessElementsFactory.getFromFileSymbol(line.toCharArray()[x]), x, y);
            }
            line = buffer.readLine();
            y++;
        }
        buffer.close();
    }
    
    private void setWidth(final int width) {
        this.width = width;
    }
    
    public final int getHeight() {
        return this.height;
    }
    
    private void setHeight(final int height) {
        this.height = height;
    }
    
    public final IElement getOnTheRoadXY(final int x, final int y) {
        return this.onTheRoad[x][y];
    }
    
    private void setOnTheRoadXY(final IElement element, final int x, final int y) {
        this.onTheRoad[x][y] = element;
    }
    
    public final void setMobileHasChanged() {
        this.setChanged();
        this.notifyObservers();
    }
    
    public Observable getObservable() {
        return this;
    }
}
