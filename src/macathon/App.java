package macathon;

import comp127graphics.CanvasWindow;
import comp127graphics.GraphicsGroup;
import comp127graphics.ui.Button;

public class App {

    private CanvasWindow canvas;
    private PersonInfo personInfo;
    private InfoScreen infoScreen;
    private Button submitButton;

    public App(){
        canvas = new CanvasWindow("App Title", 600, 800);
        personInfo = new PersonInfo();
        infoScreen = new InfoScreen(personInfo);
        submitButton = new Button("Submit");
        canvas.add(submitButton, 200, 450);
        submitButton.onClick(() -> {
            canvas.remove(infoScreen);
            canvas.remove(submitButton);
        });
        canvas.add(infoScreen);
        canvas.draw();
    }

    public static void main(String[] args) {
        new App();
    }

}
