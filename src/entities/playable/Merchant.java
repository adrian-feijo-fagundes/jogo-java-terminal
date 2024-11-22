package entities.playable;

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
            50,
            10,
            50,
            10,
            8,
            15
        );
    }
}
