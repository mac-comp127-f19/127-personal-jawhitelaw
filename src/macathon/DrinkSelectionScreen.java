package macathon;

import comp127graphics.GraphicsGroup;
import comp127graphics.Image;
import comp127graphics.ui.Button;

public class DrinkSelectionScreen extends GraphicsGroup {

    private Button beer, wine, hardLiquor, other, back;
    private Image beercan, wineglass, shotglass, questionmark;

    public DrinkSelectionScreen(){

        beercan = new Image(50,20, "budlight.jpg");
        this.add(beercan);

        wineglass = new Image (300 ,20, "wineglass.jpg");
        this.add(wineglass);

        shotglass = new Image (0, 400, "shotglass.jpg");
        this.add(shotglass);

        questionmark = new Image (300, 400, "questionmark.jpg");
        this.add(questionmark);

        beer = new Button("Beer");
        beer.setPosition(25, 330);
        this.add(beer);

        wine = new Button("Wine");
        wine.setPosition(325, 330);
        this.add(wine);

        hardLiquor = new Button("Hard Liquor");
        hardLiquor.setPosition(25, 720);
        this.add(hardLiquor);

        other = new Button("Other");
        other.setPosition(325, 720);
        this.add(other);

        back = new Button ("Back");
        back.setPosition(0,0);
        this.add(back);
    }

    public Button getBackButton(){
        return back;
    }

    public Button getBeerButton(){
        return beer;
    }

    public Button getHardLiquorButton(){
        return hardLiquor;
    }

    public Button getWineButton(){
        return wine;
    }
}
