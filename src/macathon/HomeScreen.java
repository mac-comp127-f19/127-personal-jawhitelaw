package macathon;

import comp127graphics.GraphicsGroup;
import comp127graphics.GraphicsText;
import comp127graphics.ui.Button;

public class HomeScreen extends GraphicsGroup {

    private Button imDrinking, imDrinkingWith, resources, sos;
    private GraphicsText appTitle;

    public HomeScreen(){

        appTitle = new GraphicsText();
        appTitle.setText("BeerHive");
        appTitle.setFontSize(100);
        this.add(appTitle, 100,100);

        imDrinking = new Button("I'm Drinking");
        imDrinking.setPosition(50, 300);
        this.add(imDrinking);

        imDrinkingWith = new Button("I'm Drinking With");
        imDrinkingWith.setPosition(150, 200);
        this.add(imDrinkingWith);

        sos = new Button ("SOS");
        sos.setPosition(150, 450);
        this.add(sos);

        resources = new Button("Resources");
        resources.setPosition(175, 550);
        this.add(resources);
    }

    public Button getImDrinkingButton(){
        return imDrinking;
    }
}
