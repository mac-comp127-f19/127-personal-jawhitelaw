package extractInterface;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameCharacterTest {

    private Fireball fireball = new Fireball(2,10);
    private Sword sword = new Sword (2, 10);
    private GameCharacter
        sally  = new GameCharacter("Sally", 100, 50, fireball),
        marvin = new GameCharacter("Marvin", 50, sword);

    @Test
    void fireballAttack() {
        assertEquals(
            "Sally hit Marvin with a fireball for 15 points of damage",
            sally.attack(marvin));
        assertEquals(3, sally.getMana());
        assertEquals(35, marvin.getHitPoints());
        assertEquals(100, sally.getHitPoints());
    }

    @Test
    void fireballAttackNotEnoughMana() {
        sally.useMana(5);
        assertEquals(5, sally.getMana());

        assertEquals(
            "Sally did not have enough mana for a fireball attack",
            sally.attack(marvin));
        assertEquals(5, sally.getMana());
        assertEquals(50, marvin.getHitPoints());
        assertEquals(100, sally.getHitPoints());
    }

    @Test
    void fireballAttackToZero() {
        marvin.takeDamage(49);
        assertEquals(1, marvin.getHitPoints());

        assertEquals(
            "Sally hit Marvin with a fireball for 15 points of damage",
            sally.attack(marvin));
        assertEquals(3, sally.getMana());
        assertEquals(0, marvin.getHitPoints());
        assertEquals(100, sally.getHitPoints());
    }

    @Test
    void swordAttack() {
        String message = marvin.attack(sally);
        assertTrue(
            message.matches("Marvin struck Sally with a sword for \\d+ points of damage"));
        assertTrue(sally.getHitPoints() <= 95);
        assertTrue(sally.getHitPoints() >= 90);
        assertEquals(50, marvin.getHitPoints());
    }


    @Test
    void swordAttackToZero() {
        sally.takeDamage(98);
        assertEquals(2, sally.getHitPoints());

        String message = marvin.attack(sally);
        assertTrue(
            message.matches("Marvin struck Sally with a sword for \\d+ points of damage"));
        assertEquals(0, sally.getHitPoints());
        assertEquals(50, marvin.getHitPoints());
    }
}
