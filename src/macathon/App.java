package macathon;

import comp127graphics.CanvasWindow;
import comp127graphics.GraphicsGroup;
import comp127graphics.GraphicsText;
import comp127graphics.ui.Button;

import java.util.ArrayList;


public class App {

    private static CanvasWindow canvas;
    private PersonInfo personInfo;
    private InfoScreen infoScreen;
    private HomeScreen homeScreen;
    private AddDrinkScreen addDrinkScreen;
    private DrinkSelectionScreen drinkSelectionScreen;
    private BeerSizeScreen beerSizeScreen;
    private StatsScreen statsScreen;
    private HardLiquorSizeScreen hardLiquorSizeScreen;
    private WineSizeScreen wineSizeScreen;
    private Button startButton;

    private double onedrink;
    private double total;

    private GraphicsText warning;

    private ArrayList<String> previousDrinks;
    private GraphicsGroup pDrinks;


    public App(){
        canvas = new CanvasWindow("BeerHive", 600, 800);
        personInfo = new PersonInfo();
        infoScreen = new InfoScreen(personInfo);
        homeScreen = new HomeScreen();
        addDrinkScreen = new AddDrinkScreen();
        drinkSelectionScreen = new DrinkSelectionScreen();
        beerSizeScreen = new BeerSizeScreen();
        hardLiquorSizeScreen = new HardLiquorSizeScreen();
        wineSizeScreen = new WineSizeScreen();
        statsScreen = new StatsScreen();
        previousDrinks = new ArrayList<String>();
        warning = new GraphicsText();
        pDrinks = new GraphicsGroup();
        startButton = new Button("");
        canvas.add(startButton);
        startButton.onClick(() ->{
            canvas.remove(startButton);
            canvas.add(infoScreen);
        });
        infoScreen.getSubmitButton().onClick(() -> {
            canvas.remove(infoScreen);
            canvas.add(homeScreen);
        });
        homeScreen.getImDrinkingButton().onClick(() -> {
            canvas.remove(homeScreen);
            canvas.add(addDrinkScreen);
            if (total>120){
                warning.setText("You should stop drinking!");
                warning.setFontSize(30);
                warning.setPosition(100, 40);
                canvas.add(warning);
            }
            else if(total>80){
                warning.setText("You should slow down!");
                warning.setFontSize(30);
                warning.setPosition(100, 40);
                canvas.add(warning);
            }
        });
        addDrinkScreen.getBackButton().onClick(() -> {
            canvas.remove(addDrinkScreen);
            if (total>80){
                canvas.remove(warning);
            }
            canvas.add(homeScreen);
        });
        addDrinkScreen.getAddDrinkButton().onClick(() -> {
            canvas.remove(addDrinkScreen);
            if (total>80){
                canvas.remove(warning);
            }
            canvas.add(drinkSelectionScreen);
        });
        addDrinkScreen.getArrowButton().onClick(() -> {
            canvas.remove(addDrinkScreen);
            if (total>80){
                canvas.remove(warning);
            }
            canvas.add(statsScreen);
            canvas.add(pDrinks);
            if (total>120){
                warning.setText("You should stop drinking!");
                warning.setFontSize(30);
                warning.setPosition(200, 100);
                canvas.add(warning);
            }
            else if(total>80){
                warning.setText("You should slow down");
                warning.setFontSize(30);
                warning.setPosition(200, 100);
                canvas.add(warning);
            }
        });
        drinkSelectionScreen.getBackButton().onClick(() -> {
            canvas.remove(drinkSelectionScreen);
            canvas.add(addDrinkScreen);
            if (total>120){
                warning.setText("You should stop drinking!");
                warning.setFontSize(30);
                warning.setPosition(100, 40);
                canvas.add(warning);
            }
            else if(total>80){
                warning.setText("You should slow down");
                warning.setFontSize(30);
                warning.setPosition(100, 40);
                canvas.add(warning);
            }
        });
        drinkSelectionScreen.getBeerButton().onClick(() -> {
            canvas.remove(drinkSelectionScreen);
            canvas.add(beerSizeScreen);
            onedrink+=10;
        });
        drinkSelectionScreen.getHardLiquorButton().onClick(() -> {
            canvas.remove(drinkSelectionScreen);
            canvas.add(hardLiquorSizeScreen);
            onedrink+=40;
        });
        drinkSelectionScreen.getWineButton().onClick(() -> {
            canvas.remove(drinkSelectionScreen);
            canvas.add(wineSizeScreen);
            onedrink+=20;
        });
        beerSizeScreen.getBackButton().onClick(() -> {
            canvas.remove(beerSizeScreen);
            canvas.add(drinkSelectionScreen);
        });
        beerSizeScreen.getFullCanButton().onClick(() -> {
            canvas.remove(beerSizeScreen);
            canvas.add(statsScreen);
            canvas.add(pDrinks);
            onedrink = onedrink * 1.5;
            total += onedrink;
            onedrink=0;
            statsScreen.moveYou(total);
            previousDrinks.add("1 Can of Beer");
            for (int i=0; i<previousDrinks.size(); i++){
                GraphicsText t = new GraphicsText(previousDrinks.get(i));
                t.setPosition(15, 460 + 15*i);
                pDrinks.add(t);
            }
            if (total>120){
                warning.setText("You should stop drinking!");
                warning.setFontSize(30);
                warning.setPosition(200, 100);
                canvas.add(warning);
            }
            else if(total>80){
                warning.setText("You should slow down");
                warning.setFontSize(30);
                warning.setPosition(200, 100);
                canvas.add(warning);
            }
        });
        beerSizeScreen.getHalfCanButton().onClick(() -> {
            canvas.remove(beerSizeScreen);
            canvas.add(statsScreen);
            canvas.add(pDrinks);
            onedrink = onedrink * 1.5 * .5;
            total += onedrink;
            onedrink=0;
            statsScreen.moveYou(total);
            previousDrinks.add("1/2 Can of Beer");
            for (int i=0; i<previousDrinks.size(); i++){
                GraphicsText t = new GraphicsText(previousDrinks.get(i));
                t.setPosition(15, 460 + 15*i);
                pDrinks.add(t);
            }
            if (total>120){
                warning.setText("You should stop drinking!");
                warning.setFontSize(30);
                warning.setPosition(200, 100);
                canvas.add(warning);
            }
            else if(total>80){
                warning.setText("You should slow down");
                warning.setFontSize(30);
                warning.setPosition(200, 100);
                canvas.add(warning);
            }
        });
        beerSizeScreen.getFullPintButton().onClick(() -> {
            canvas.remove(beerSizeScreen);
            canvas.add(statsScreen);
            canvas.add(pDrinks);
            onedrink = onedrink * 2;
            total += onedrink;
            onedrink=0;
            statsScreen.moveYou(total);
            previousDrinks.add("1 Pint of Beer");
            for (int i=0; i<previousDrinks.size(); i++){
                GraphicsText t = new GraphicsText(previousDrinks.get(i));
                t.setPosition(15, 460 + 15*i);
                pDrinks.add(t);
            }
            if (total>120){
                warning.setText("You should stop drinking!");
                warning.setFontSize(30);
                warning.setPosition(200, 100);
                canvas.add(warning);
            }
            else if(total>80){
                warning.setText("You should slow down");
                warning.setFontSize(30);
                warning.setPosition(200, 100);
                canvas.add(warning);
            }
        });
        beerSizeScreen.getHalfPintButton().onClick(() -> {
            canvas.remove(beerSizeScreen);
            canvas.add(statsScreen);
            canvas.add(pDrinks);
            onedrink = onedrink * 1;
            total += onedrink;
            onedrink=0;
            statsScreen.moveYou(total);
            previousDrinks.add("1/2 Pint of Beer");
            for (int i=0; i<previousDrinks.size(); i++){
                GraphicsText t = new GraphicsText(previousDrinks.get(i));
                t.setPosition(15, 460 + 15*i);
                pDrinks.add(t);
            }
            if (total>120){
                warning.setText("You should stop drinking!");
                warning.setFontSize(30);
                warning.setPosition(200, 100);
                canvas.add(warning);
            }
            else if(total>80){
                warning.setText("You should slow down");
                warning.setFontSize(30);
                warning.setPosition(200, 100);
                canvas.add(warning);
            }
        });
        hardLiquorSizeScreen.getBackButton().onClick(() -> {
            canvas.remove(hardLiquorSizeScreen);
            canvas.add(drinkSelectionScreen);
        });
        hardLiquorSizeScreen.getShotButton().onClick(() -> {
            canvas.remove(hardLiquorSizeScreen);
            canvas.add(statsScreen);
            canvas.add(pDrinks);
            onedrink = onedrink * 1.25;
            total += onedrink;
            onedrink=0;
            statsScreen.moveYou(total);
            previousDrinks.add("1 Shot of Hard Liquor");
            for (int i=0; i<previousDrinks.size(); i++){
                GraphicsText t = new GraphicsText(previousDrinks.get(i));
                t.setPosition(15, 460 + 15*i);
                pDrinks.add(t);
            }
            if (total>120){
                warning.setText("You should stop drinking!");
                warning.setFontSize(30);
                warning.setPosition(200, 100);
                canvas.add(warning);
            }
            else if(total>80){
                warning.setText("You should slow down");
                warning.setFontSize(30);
                warning.setPosition(200, 100);
                canvas.add(warning);
            }
        });
        hardLiquorSizeScreen.getHalfShotButton().onClick(() -> {
            canvas.remove(hardLiquorSizeScreen);
            canvas.add(statsScreen);
            canvas.add(pDrinks);
            onedrink = onedrink * .65;
            total += onedrink;
            onedrink=0;
            statsScreen.moveYou(total);
            previousDrinks.add("1/2 Shot of Hard Liquor");
            for (int i=0; i<previousDrinks.size(); i++){
                GraphicsText t = new GraphicsText(previousDrinks.get(i));
                t.setPosition(15, 460 + 15*i);
                pDrinks.add(t);
            }
            if (total>120){
                warning.setText("You should stop drinking!");
                warning.setFontSize(30);
                warning.setPosition(200, 100);
                canvas.add(warning);
            }
            else if(total>80){
                warning.setText("You should slow down");
                warning.setFontSize(30);
                warning.setPosition(200, 100);
                canvas.add(warning);
            }
        });
        hardLiquorSizeScreen.getHalfPartyCupButton().onClick(() -> {
            canvas.remove(hardLiquorSizeScreen);
            canvas.add(statsScreen);
            canvas.add(pDrinks);
            onedrink = onedrink * 4.5;
            total += onedrink;
            onedrink=0;
            statsScreen.moveYou(total);
            previousDrinks.add("1/2 Party Cup of Hard Liquor");
            for (int i=0; i<previousDrinks.size(); i++){
                GraphicsText t = new GraphicsText(previousDrinks.get(i));
                t.setPosition(15, 460 + 15*i);
                pDrinks.add(t);
            }
            if (total>120){
                warning.setText("You should stop drinking!");
                warning.setFontSize(30);
                warning.setPosition(200, 100);
                canvas.add(warning);
            }
            else if(total>80){
                warning.setText("You should slow down");
                warning.setFontSize(30);
                warning.setPosition(200, 100);
                canvas.add(warning);
            }
        });
        hardLiquorSizeScreen.getQuarterPartyCupButton().onClick(() -> {
            canvas.remove(hardLiquorSizeScreen);
            canvas.add(statsScreen);
            canvas.add(pDrinks);
            onedrink = onedrink * 2.5;
            total += onedrink;
            onedrink=0;
            statsScreen.moveYou(total);
            previousDrinks.add("1/4 Party Cup of Hard Liquor");
            for (int i=0; i<previousDrinks.size(); i++){
                GraphicsText t = new GraphicsText(previousDrinks.get(i));
                t.setPosition(15, 460 + 15*i);
                pDrinks.add(t);
            }
            if (total>120){
                warning.setText("You should stop drinking!");
                warning.setFontSize(30);
                warning.setPosition(200, 100);
                canvas.add(warning);
            }
            else if(total>80){
                warning.setText("You should slow down");
                warning.setFontSize(30);
                warning.setPosition(200, 100);
                canvas.add(warning);
            }
        });
        wineSizeScreen.getBackButton().onClick(() -> {
            canvas.remove(wineSizeScreen);
            canvas.add(drinkSelectionScreen);
        });
        wineSizeScreen.getFullWineGlassButton().onClick(() -> {
            canvas.remove(wineSizeScreen);
            canvas.add(statsScreen);
            canvas.add(pDrinks);
            onedrink = onedrink * 1.25;
            total += onedrink;
            onedrink=0;
            statsScreen.moveYou(total);
            previousDrinks.add("1 Glass of Wine");
            for (int i=0; i<previousDrinks.size(); i++){
                GraphicsText t = new GraphicsText(previousDrinks.get(i));
                t.setPosition(15, 460 + 15*i);
                pDrinks.add(t);
            }
            if (total>120){
                warning.setText("You should stop drinking!");
                warning.setFontSize(30);
                warning.setPosition(200, 100);
                canvas.add(warning);
            }
            else if(total>80){
                warning.setText("You should slow down");
                warning.setFontSize(30);
                warning.setPosition(200, 100);
                canvas.add(warning);
            }
        });
        wineSizeScreen.getHalfWineGlassButton().onClick(() -> {
            canvas.remove(wineSizeScreen);
            canvas.add(statsScreen);
            canvas.add(pDrinks);
            onedrink = onedrink * .65;
            total += onedrink;
            onedrink=0;
            statsScreen.moveYou(total);
            previousDrinks.add("1/2 Glass of Wine");
            for (int i=0; i<previousDrinks.size(); i++){
                GraphicsText t = new GraphicsText(previousDrinks.get(i));
                t.setPosition(15, 460 + 15*i);
                pDrinks.add(t);
            }
            if (total>120){
                warning.setText("You should stop drinking!");
                warning.setFontSize(30);
                warning.setPosition(200, 100);
                canvas.add(warning);
            }
            else if(total>80){
                warning.setText("You should slow down");
                warning.setFontSize(30);
                warning.setPosition(200, 100);
                canvas.add(warning);
            }
        });
        wineSizeScreen.getHalfWineBottleButton().onClick(() -> {
            canvas.remove(wineSizeScreen);
            canvas.add(statsScreen);
            canvas.add(pDrinks);
            onedrink = onedrink * 4.5;
            total += onedrink;
            onedrink=0;
            statsScreen.moveYou(total);
            previousDrinks.add("1/2 Bottle of Wine");
            for (int i=0; i<previousDrinks.size(); i++){
                GraphicsText t = new GraphicsText(previousDrinks.get(i));
                t.setPosition(15, 460 + 15*i);
                pDrinks.add(t);
            }
            if (total>120){
                warning.setText("You should stop drinking!");
                warning.setFontSize(30);
                warning.setPosition(200, 100);
                canvas.add(warning);
            }
            else if(total>80){
                warning.setText("You should slow down");
                warning.setFontSize(30);
                warning.setPosition(200, 100);
                canvas.add(warning);
            }
        });
        wineSizeScreen.getQuarterWineBottleButton().onClick(() -> {
            canvas.remove(wineSizeScreen);
            canvas.add(statsScreen);
            canvas.add(pDrinks);
            onedrink = onedrink * 2.5;
            total += onedrink;
            onedrink=0;
            statsScreen.moveYou(total);
            previousDrinks.add("1/4 Bottle of Wine");
            for (int i=0; i<previousDrinks.size(); i++){
                GraphicsText t = new GraphicsText(previousDrinks.get(i));
                t.setPosition(15, 460 + 15*i);
                pDrinks.add(t);
            }
            if (total>120){
                warning.setText("You should stop drinking!");
                warning.setFontSize(30);
                warning.setPosition(200, 100);
                canvas.add(warning);
            }
            else if(total>80){
                warning.setText("You should slow down");
                warning.setFontSize(30);
                warning.setPosition(200, 100);
                canvas.add(warning);
            }
        });
        statsScreen.getArrowButton().onClick(() -> {
            canvas.remove(statsScreen);
            canvas.remove(pDrinks);
            canvas.add(addDrinkScreen);
            if (total>120){
                warning.setText("You should stop drinking!");
                warning.setFontSize(30);
                warning.setPosition(100, 40);
                canvas.add(warning);
            }
            else if(total>80){
                warning.setText("You should slow down!");
                warning.setFontSize(30);
                warning.setPosition(100, 40);
                canvas.add(warning);if (total>100){
                    canvas.remove(warning);
                }
            }
            if (total>80){
                canvas.remove(warning);
            }
        });
        canvas.draw();
    }

    public static void main(String[] args) {
        new App();
    }

    public double getTotal(){
        return total;
    }

}
