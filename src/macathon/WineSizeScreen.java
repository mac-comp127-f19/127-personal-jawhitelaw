package macathon;

import comp127graphics.GraphicsGroup;
import comp127graphics.Image;
import comp127graphics.ui.Button;

public class WineSizeScreen extends GraphicsGroup {

    private Image glass, halfglass, halfbottle, quarterbottle;
    private Button fullwineglass, halfwineglass, halfwinebottle, quarterwinebottle, back;

    public WineSizeScreen(){

        glass = new Image(50,20, "wineglass.jpg");
        this.add(glass);

        halfglass = new Image (300 ,160, "halfwineglass.jpg");
        this.add(halfglass);

        halfbottle = new Image (25, 540, "halfwinebottle.jpg");
        this.add(halfbottle);

        quarterbottle = new Image (325, 610, "quarterwinebottle.jpg");
        this.add(quarterbottle);

        fullwineglass = new Button("1 Full Wine Glass");
        fullwineglass.setPosition(25, 330);
        this.add(fullwineglass);

        halfwineglass = new Button("1/2 Wine Glass");
        halfwineglass.setPosition(325, 330);
        this.add(halfwineglass);

        halfwinebottle = new Button("1/2 Wine Bottle");
        halfwinebottle.setPosition(25, 720);
        this.add(halfwinebottle);

        quarterwinebottle = new Button("1/4 Wine Bottle");
        quarterwinebottle.setPosition(325, 720);
        this.add(quarterwinebottle);

        back = new Button ("Back");
        back.setPosition(0,0);
        this.add(back);
    }

    public Button getBackButton(){
        return back;
    }

    public Button getFullWineGlassButton(){
        return fullwineglass;
    }
    public Button getHalfWineGlassButton(){
        return halfwineglass;
    }
    public Button getHalfWineBottleButton(){
        return halfwinebottle;
    }
    public Button getQuarterWineBottleButton(){
        return quarterwinebottle;
    }
}
