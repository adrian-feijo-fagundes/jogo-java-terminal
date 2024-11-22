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
            40,
            8,
            50,
            10,
            12,
            10
        );
    }
}
