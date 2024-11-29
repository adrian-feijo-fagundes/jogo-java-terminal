package rpg;

public class Merchant extends Player {
    public Merchant(
        String name,
        int life,
        int attack,
        int mana,
        int defense,
        int speed,
        int luck
    ) {
        super(
            name,
            "Mercador",
            50 + life * 1,
            10 + (int) (attack * 1.2),
            50 + mana * 1,
            10 + (int) (defense * 1.1),
            8  + (int) (speed * 1.3),
            15 + (int) (luck * 1.5)
        );
    }
}
