package macathon;

import comp127graphics.GraphicsGroup;
import comp127graphics.GraphicsText;
import comp127graphics.Line;
import comp127graphics.ui.Button;

public class StatsScreen extends GraphicsGroup {

    private Line yaxis, xaxis, upslope, downslope;
    private GraphicsText title, fun, nofun, sober, drunk, previousdrinks, you;
    private Button arrow;

    public StatsScreen(){

        yaxis = new Line(50, 75, 50, 350);
        this.add(yaxis);

        xaxis = new Line (50, 350, 525, 350);
        this.add(xaxis);

        upslope = new Line (50, 150, 150, 100);
        this.add(upslope);

        downslope = new Line (150, 100, 500, 350);
        this.add(downslope);

        title = new GraphicsText("The Fun Curve");
        title.setFontSize(50);
        title.setCenter(350, 40);
        this.add(title);

        fun = new GraphicsText("Fun");
        fun.setFontSize(20);
        fun.setCenter(25, 75);
        this.add(fun);

        nofun = new GraphicsText("No Fun");
        nofun.setFontSize(13);
        nofun.setCenter(25, 350);
        this.add(nofun);

        sober = new GraphicsText("Sober");
        sober.setFontSize(20);
        sober.setCenter(60, 375);
        this.add(sober);

        drunk = new GraphicsText("Blackout Drunk");
        drunk.setFontSize(20);
        drunk.setCenter(500, 375);
        this.add(drunk);

        you = new GraphicsText("you");
        you.setFontSize(20);
        you.setCenter(40,150);
        this.add(you);

        previousdrinks = new GraphicsText("Previous Drinks");
        previousdrinks.setFontSize(50);
        previousdrinks.setCenter(200, 425);
        this.add(previousdrinks);

        arrow = new Button("--->");
        arrow.setPosition(500, 400);
        this.add(arrow);
    }

    public Button getArrowButton(){
        return arrow;
    }

    public void moveYou(double x){
        if (x<100){
            you.setCenter(50 + x, 150 - x/2);
        }
        else {
            you.setCenter(50 + x, 100 + x/2);
        }
    }


}
