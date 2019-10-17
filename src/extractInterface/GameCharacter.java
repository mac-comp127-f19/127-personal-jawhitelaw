package extractInterface;

import java.util.Random;

public class GameCharacter {
    private static final Random rand = new Random();

    private final String name;
    private int hitPoints, mana;
    private Sword sword;
    private Fireball fireball;



    public GameCharacter(String name, int hitPoints, Sword s) {
        this.name = name;
        this.hitPoints = hitPoints;
        sword = s;
    }
    public GameCharacter(String name, int hitPoints, int mana, Fireball f) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.mana = mana;
        fireball = f;
    }

        public String attack(GameCharacter target) {
            if(this.useMana(fireball.getFireballManaRequired())&&fireball!=null){
                return this.getName() + fireball.attack(target);
            }
            else {
                return this.getName() + sword.attack(target);
            }
        }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getMana() {
        return mana;
    }

    public void takeDamage(int damage) {
        hitPoints = Math.max(0, hitPoints - damage);
    }

    public boolean useMana(int amount) {
        if (mana >= amount) {
            mana -= amount;
            return true;
        } else {
            return false;
        }
    }
}
