package train;

import comp127graphics.Rectangle;

import java.awt.*;

public class Boxcar extends TrainCar {

    /* Dimensions of the door panels on the boxcar */
    public static final double DOOR_WIDTH = 18*SCALE;
    public static final double DOOR_HEIGHT = 32*SCALE;

    public Boxcar(Color color){
        super(color);
        drawBoxcar(0,this.getCarHeight());
    }
    /* Draws a boxcar in the specified color */
    public void drawBoxcar(double x, double y) {
        double xRight = x + CONNECTOR + CAR_WIDTH / 2;
        double xLeft = xRight - DOOR_WIDTH;
        double yDoor = y - CAR_BASELINE - DOOR_HEIGHT;
        this.add(new comp127graphics.Rectangle(xLeft, yDoor, DOOR_WIDTH, DOOR_HEIGHT));
        this.add(new Rectangle(xRight, yDoor, DOOR_WIDTH, DOOR_HEIGHT));
    }
}
