package macathon;

import comp127graphics.GraphicsGroup;
import comp127graphics.Image;
import comp127graphics.ui.Button;

public class HardLiquorSizeScreen extends GraphicsGroup {

    private Image shot, shothalf, partycuphalf, partycupquarter;
    private Button fullshot, halfshot, halfpartycup, quarterpartycup, back;

    public HardLiquorSizeScreen(){

        shot = new Image(50,20, "shotglass.jpg");
        this.add(shot);

        shothalf = new Image (300 ,160, "halfshotglass.jpg");
        this.add(shothalf);

        partycuphalf = new Image (25, 540, "halfpartycup.jpg");
        this.add(partycuphalf);

        partycupquarter = new Image (325, 610, "quarterpartycup.jpg");
        this.add(partycupquarter);

        fullshot = new Button("1 Full Shot");
        fullshot.setPosition(25, 330);
        this.add(fullshot);

        halfshot = new Button("1/2 Shot");
        halfshot.setPosition(325, 330);
        this.add(halfshot);

        halfpartycup = new Button("1/2 Party Cup");
        halfpartycup.setPosition(25, 720);
        this.add(halfpartycup);

        quarterpartycup = new Button("1/4 Party Cup");
        quarterpartycup.setPosition(325, 720);
        this.add(quarterpartycup);

        back = new Button ("Back");
        back.setPosition(0,0);
        this.add(back);
    }

    public Button getBackButton(){
        return back;
    }

    public Button getShotButton(){
        return fullshot;
    }
    public Button getHalfShotButton(){
        return halfshot;
    }
    public Button getHalfPartyCupButton(){
        return halfpartycup;
    }
    public Button getQuarterPartyCupButton(){
        return quarterpartycup;
    }
}
