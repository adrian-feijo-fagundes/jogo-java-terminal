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
            45 + life * 1,
            15 + attack * 1,
            30 + mana * 1,
            15 + defense * 1,
            12 + speed * 1,
            10 + luck * 1
        );
    }
}
