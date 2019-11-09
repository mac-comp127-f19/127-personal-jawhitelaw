package macathon;

import comp127graphics.GraphicsGroup;
import comp127graphics.GraphicsText;
import comp127graphics.ui.Button;
import comp127graphics.ui.TextField;
import marsh.inheritance2.B;


public class InfoScreen extends GraphicsGroup {

    PersonInfo personInfo;
    private TextField username, age, weight, height;
    private Button male, female;
    private GraphicsText appTitle, sexLabel, usernameLabel, ageLabel, weightLabel, heightLabel;

    public InfoScreen(PersonInfo personInfo){
        appTitle = new GraphicsText();
        appTitle.setText("App Title");
        appTitle.setFontSize(100);
        this.add(appTitle, 100,100);

        usernameLabel = new GraphicsText();
        usernameLabel.setText("Username:");
        this.add(usernameLabel, 200, 200);

        username = new TextField();
        username.onChange((text) -> personInfo.setUsername(text));
        this.add(username, 200,200);

        ageLabel = new GraphicsText();
        ageLabel.setText("Age:");
        this.add(ageLabel, 200, 250);

        age = new TextField();
        age.onChange((text) -> {
            int a = Integer.parseInt(text);
            personInfo.setAge(a);
        });
        this.add(age, 200, 250);

        weightLabel = new GraphicsText();
        weightLabel.setText("Weight:");
        this.add(weightLabel, 200, 300);

        weight = new TextField();
        weight.onChange((text) -> {
            int a = Integer.parseInt(text);
            personInfo.setWeight(a);
        });
        this.add(weight, 200, 300);

        heightLabel = new GraphicsText();
        heightLabel.setText("Height:");
        this.add(heightLabel, 200, 350);

        height = new TextField();
        height.onChange((text) -> {
            int a = Integer.parseInt(text);
            personInfo.setHeight(a);
        });
        this.add(height, 200, 350);

        sexLabel = new GraphicsText();
        sexLabel.setText("Sex:");
        this.add(sexLabel, 200, 400);

        male = new Button("male");
        male.onClick(() -> personInfo.setSex(true));
        this.add(male, 200, 400);

        female = new Button("female");
        female.onClick(() -> personInfo.setSex(false));
        this.add(female, 275, 400);
    }
}
