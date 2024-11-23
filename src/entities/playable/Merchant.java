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
            50 + life,
            10 + attack,
            50 + mana,
            10 + defense,
            8 + speed,
            15 + luck
        );
    }
}
