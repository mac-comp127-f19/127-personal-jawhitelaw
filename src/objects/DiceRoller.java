package objects;

public class DiceRoller {
    public static void main(String[] args) {
        Die die1 = new Die();
        for(int i=1; i<11; i++){
            die1.roll();
            System.out.println("Roll " + i + " generated a " + die1.toString());
        }

        Die die2 = new Die();
        int numMatches=0;
        for(int i=0; i<1000000; i++){
            die1.roll();
            die2.roll();
            if (die1.getValue()==die2.getValue()){
                numMatches++;
            }
        }

        System.out.println("In 1,000,000 rolls, the two dice agreed " + numMatches + " times");

    }
}
