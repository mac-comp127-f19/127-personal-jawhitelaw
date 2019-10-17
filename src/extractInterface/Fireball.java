package extractInterface;

public class Fireball implements Weapon {

    private final int fireballManaRequired;
    private final int fireballDamage;


    public Fireball(int mana, int damage) {
        fireballManaRequired = mana;
        fireballDamage = damage;
    }

    @Override
    public String attack(GameCharacter target) {
        if (fireballDamage > 0) {
            target.takeDamage(fireballDamage);
            return " hit " + target.getName() + " with a fireball for "
                    + fireballDamage + " points of damage";
        } else {
            return "Your fireball does no damage";
        }
    }

    public int getFireballManaRequired(){
        return fireballManaRequired;
    }
}