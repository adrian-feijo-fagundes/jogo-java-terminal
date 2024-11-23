package entities.playable;

public class Hunter extends Player {
    public Hunter(
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
            "Caçador",
            45 + life,
            15 + attack,
            30 + mana,
            15 + defense,
            12 + speed,
            10 + luck
        );
    }
}
