package macathon;

import comp127graphics.GraphicsGroup;
import comp127graphics.ui.Button;

public class HomeScreen extends GraphicsGroup {

    private Button imDrinking, imDrinkingWith, resources;

    public HomeScreen(){
        imDrinking = new Button("I'm Drinking");
        imDrinking.changed(100,100);
    }
}
