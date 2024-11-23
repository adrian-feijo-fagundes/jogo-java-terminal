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
            40 + life * 1,
            8 + attack * 1,
            50 + mana * 1,
            10 + defense * 1,
            12 + speed * 1,
            10 + luck * 1
        );
    }
}
