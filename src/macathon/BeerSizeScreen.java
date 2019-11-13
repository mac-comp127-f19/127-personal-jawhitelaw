package macathon;

import comp127graphics.GraphicsGroup;
import comp127graphics.Image;
import comp127graphics.ui.Button;

public class BeerSizeScreen extends GraphicsGroup {

    private Image canbeer, halfcanbeer, pintbeer, halfpintbeer;
    private Button fullcan, halfcan, fullpint, halfpint, back;

    public BeerSizeScreen(){

        canbeer = new Image(50,20, "canofbeer.jpg");
        this.add(canbeer);

        halfcanbeer = new Image (300 ,160, "halfcanofbeer.jpg");
        this.add(halfcanbeer);

        pintbeer = new Image (0, 400, "pintofbeer.jpg");
        this.add(pintbeer);

        halfpintbeer = new Image (300, 540, "halfpintofbeer.jpg");
        this.add(halfpintbeer);

        fullcan = new Button("1 Full Can");
        fullcan.setPosition(25, 330);
        this.add(fullcan);

        halfcan = new Button("1/2 Can");
        halfcan.setPosition(325, 330);
        this.add(halfcan);

        fullpint = new Button("1 Full Pint");
        fullpint.setPosition(25, 720);
        this.add(fullpint);

        halfpint = new Button("1/2 Pint");
        halfpint.setPosition(325, 720);
        this.add(halfpint);

        back = new Button ("Back");
        back.setPosition(0,0);
        this.add(back);
    }

    public Button getBackButton(){
        return back;
    }

    public Button getFullCanButton(){
        return fullcan;
    }
    public Button getHalfCanButton(){
        return halfcan;
    }
    public Button getFullPintButton(){
        return fullpint;
    }
    public Button getHalfPintButton(){
        return halfpint;
    }

}
