package macathon;

import comp127graphics.GraphicsGroup;
import comp127graphics.ui.Button;

public class AddDrinkScreen extends GraphicsGroup {

    private Button addDrink, sos, arrow, back;

    public AddDrinkScreen(){

        addDrink = new Button("Add Drink");
        addDrink.setPosition(100, 100);
        this.add(addDrink);

        sos = new Button ("SOS");
        sos.setPosition(100, 600);
        this.add(sos);

        arrow = new Button("<--- to stats");
        arrow.setPosition(0, 350);
        this.add(arrow);

        back = new Button ("Back");
        back.setPosition(0,0);
        this.add(back);
    }

    public Button getBackButton(){
        return back;
    }

    public Button getAddDrinkButton(){
        return addDrink;
    }

    public Button getArrowButton(){
        return arrow;
    }
}
