package extractInterface;

import java.util.Random;

public class Sword implements Weapon {

    private final int swordMinDamage, swordMaxDamage;
    private final Random rand = new Random();


    public Sword(int min, int max){
        swordMinDamage = min;
        swordMaxDamage = max;
    }

    @Override
    public String attack(GameCharacter target){
        int damage = rand.nextInt(swordMaxDamage - swordMinDamage + 1) + swordMinDamage;
        target.takeDamage(damage);
        return " struck " + target.getName() + " with a sword for "
                + damage + " points of damage";
    }
}