package objects;

public class Die {

    private int numberShowing = -1;

    public Die(){
    }

    public void roll(){
        numberShowing = (int) (Math.random()*6)+1;
    }

    public int getValue(){
        return numberShowing;
    }

    @Override
    public String toString(){
        if(numberShowing==1){
            return "one";
        }
        else if(numberShowing==2){
            return "two";
        }
        else if(numberShowing==3){
            return "three";
        }
        else if(numberShowing==4){
            return "four";
        }
        else if(numberShowing==5){
            return "five";
        }
        else if(numberShowing==6){
            return "six";
        }
        else {
            return "The die has not been rolled yet";
        }
    }
}
