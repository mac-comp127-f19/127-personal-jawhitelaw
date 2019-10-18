package train;

import comp127graphics.CanvasWindow;
import comp127graphics.Ellipse;
import comp127graphics.Line;
import comp127graphics.Rectangle;

import java.awt.*;


/*
 * File: TrainDrawer.java
 * --------------------
 * This program draws a three-car train consisting on an engine,
 * a boxcar, and a caboose.  This implementation of the program,
 * however, is incomplete, and contains only the methods given
 * in the text.
 */

public class TrainDrawer {

    public static final int SCALE = 1;
    
	/* Private constants */

    /* Dimensions of the frame of a train car */
    public static final double CAR_WIDTH = 75*SCALE;
    public static final double CAR_HEIGHT = 36*SCALE;

    /* Distance from the bottom of a train car to the track below it */
    public static final double CAR_BASELINE = 10*SCALE;

    /* Width of the connector, which overlaps between successive cars */
    public static final double CONNECTOR = 6*SCALE;


    // Instance variable for the canvas that you can add shapes to in order to have them be drawn.
    private CanvasWindow canvas;


    public static void main(String[] args) {
        TrainDrawer drawer = new TrainDrawer();
    }

    public TrainDrawer(){
        //Create a window and canvas to draw on
        canvas = new CanvasWindow("Train", 800, 500);

        double trainWidth = 3 * CAR_WIDTH + 4 * CONNECTOR;
        double x = (canvas.getWidth() - trainWidth) / 2;
        double y = canvas.getHeight();
        double dx = CAR_WIDTH + CONNECTOR;
        //drawEngine(x, y);
        //drawBoxcar(x + dx, y, Color.GREEN);
        //drawCaboose(x + 2 * dx, y);

        Engine engine = new Engine(Color.BLACK);
        canvas.add(engine, 10,engine.getCarHeight());

        Boxcar boxcar = new Boxcar(Color.GREEN);
        canvas.add(boxcar, 10 + engine.getCarWidth() + 2*engine.getConnectorLength(), boxcar.getCarHeight());

        Caboose caboose = new Caboose(Color.RED);
        canvas.add(caboose, 10 + engine.getCarWidth() + boxcar.getCarWidth() + 4*boxcar.getConnectorLength(), caboose.getCarHeight());

    }

}