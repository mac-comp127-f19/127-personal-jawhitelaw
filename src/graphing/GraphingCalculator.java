package graphing;

import comp127graphics.CanvasWindow;
import comp127graphics.Line;
import comp127graphics.Point;
import comp127graphics.events.AbstractEvent;
import comp127graphics.events.ModifierKey;
import comp127graphics.ui.Button;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GraphingCalculator {
    private final CanvasWindow canvas;
    private final List<FunctionPlot> plots;
    private Point origin;
    private double scale;
    private double xmin, xmax, step;  // computed from origin + scale + size
    private double animationParameter;
    private Line xaxis, yaxis;
    private Button zoomIn, zoomOut;
    private boolean isAnimating;
    private double animationSpeed;
    private boolean shiftPress;

    /**
     * Creates a new graphing calculator with its own window.
     *
     * @param width   Window width
     * @param height  Window height
     */
    public GraphingCalculator(int width, int height) {
        canvas = new CanvasWindow("Graphing Calculator", width, height);
        plots = new ArrayList<>();

        origin = canvas.getCenter();
        scale = Math.min(width, height) / 4.0;

        xaxis = createAxisLine();
        yaxis = createAxisLine();

        zoomIn = new Button("Zoom In");
        zoomIn.onClick(() -> setScale(getScale() * 1.5));
        canvas.add(zoomIn);
        zoomOut = new Button("Zoom Out");
        zoomOut.onClick(() -> setScale(getScale() * 0.5));
        zoomOut.setCenter(140, 14);
        canvas.add(zoomOut);

        coordinatesChanged();

        isAnimating=true;
        animationSpeed=.01;
        shiftPress=false;

        canvas.onDrag(event -> {
            setAnimationParameter(
                    getAnimationParameter() + event.getDelta().getX() / width);
            isAnimating = false;
            animationSpeed = animationSpeed+event.getDelta().getX()/(width*2);
            if (event.getModifiers().contains(ModifierKey.SHIFT)){

            }
        });

        canvas.onMouseUp(event -> {
            isAnimating=true;
        });

       canvas.animate(() ->{
           if (isAnimating){
            setAnimationParameter(
                getAnimationParameter() + animationSpeed);}});
    }

    /**
     * Shows the given function in the graphing calculator, treating y as a function of x.
     */
    public void show(SimpleFunction function) {
        show((x, n) -> function.evaluate(x));
    }

    /**
     * Shows the given function in the graphing calculator. The first parameter of the function is
     * x, and the second parameter is a parametric variable that can change over time to animate
     * the equation.
     */
    public void show(ParametricFunction function) {
        FunctionPlot plot = new FunctionPlot(function);
        plots.add(plot);
        canvas.add(plot.getGraphics());

        recolorPlots();
        recalculate(plot);
    }

    /**
     * The second parameter passed to all ParametricFunctions this calculator is showing.
     */
    public double getAnimationParameter() {
        return animationParameter;
    }

    /**
     * Changes the second parameter passed to all ParametricFunctions in this calculator.
     * Immediately recomputes and redraws all the functions.
     */
    public void setAnimationParameter(double animationParameter) {
        this.animationParameter = animationParameter;
        recalculateAll();
    }

    /**
     * The position within the window of (0,0) in function plot space.
     */
    public Point getOrigin() {
        return origin;
    }

    public void setOrigin(Point origin) {
        this.origin = origin;
        coordinatesChanged();
    }

    /**
     * The number of pixels in the window for a distance of 1 in function plot space.
     */
    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
        coordinatesChanged();
    }

    private Line createAxisLine() {
        Line axis = new Line(0, 0, 0, 0);
        axis.setStrokeWidth(0.25);
        axis.setStrokeColor(new Color(0xA1A1A1));
        canvas.add(axis);
        return axis;
    }

    private void coordinatesChanged() {
        xaxis.setStartPosition(0, origin.getY());
        xaxis.setEndPosition(canvas.getWidth(), origin.getY());
        yaxis.setStartPosition(origin.getX(), 0);
        yaxis.setEndPosition(origin.getX(), canvas.getHeight());

        xmin = convertToEquationCoordinates(Point.ORIGIN).getX();
        xmax = convertToEquationCoordinates(new Point(canvas.getWidth(), 0)).getX();
        step = 2 / scale;

        recalculateAll();
    }

    private void recalculateAll() {
        plots.forEach(this::recalculate);
    }

    private void recalculate(FunctionPlot plot) {
        plot.recalculate(animationParameter, xmin, xmax, step, this::convertToScreenCoordinates);
    }

    private Point convertToScreenCoordinates(Point equationPoint) {
        return equationPoint.scale(scale, -scale).add(origin);
    }

    private Point convertToEquationCoordinates(Point screenPoint) {
        return screenPoint.subtract(origin).scale(1 / scale, -1 / scale);
    }

    private void recolorPlots() {
        int index = 0;
        for (FunctionPlot plot : plots) {
            plot.setColor(index, plots.size());
            index++;
        }
    }

    public static void main(String[] args) {
        GraphingCalculator calc = new GraphingCalculator(800, 600);
/*        calc.show(zargle -> zargle * zargle);
        calc.show(x -> x*x*x);
        calc.show(x -> Math.sqrt(x));
        calc.show(Math::sin);
        calc.show((x, n) -> Math.atan(x / Math.sin(n)));
        calc.show((x,n) -> Math.acos(x/Math.tan(n)));
        calc.show(Math::pow);


        calc.show((x, n) -> {

        double result = 0;
            for (int i = 1; i < 20; i++) {
                result += Math.sin(x * Math.pow(3, i) + n * i)
                        / Math.pow(2.5, i);
            }
            return result;
        });

        calc.show((x, n) -> {

            double result = 0;
            for (int i = 1; i < 20; i++) {
                result += Math.cos(x * Math.pow(x, i) + n * i)
                        / Math.pow(2.5*x, i);
            }
            return result;
        });
*/
        for (int n = 1; n < 12; n++) {
            double base = n * 0.1 + 1.5;
            calc.show((x, t) -> {
                double result = 0;
                for (int i = 1; i < 20; i++) {
                    result += Math.sin(x * Math.pow(base, i) - t * i * 3)
                            / Math.pow(base, i);
                }
                return result;
            });
        }


    }
}
