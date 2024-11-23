package entities.playable;

public class Priest extends Player {
    public Priest(
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
            "Sacerdote",
            40 + life,
            8 + attack,
            50 + mana,
            10 + defense,
            12 + speed,
            10 + luck
        );
    }
}
