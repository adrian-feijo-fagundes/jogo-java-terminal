package rpg_terminal.entities.creatures;

public class Merchant extends Player {
    public Merchant(
            String name,
            int life,
            int attack,
            int mana,
            int speed,
            int luck) {
        super(
                name,
                "Mercador",
                50 + life * 1,
                10 + (int) (attack * 1.2),
                50 + mana * 1,
                8 + (int) (speed * 1.3),
                15 + (int) (luck * 1.5));
    }
}
