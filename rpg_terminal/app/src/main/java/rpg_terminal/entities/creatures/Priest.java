package rpg_terminal.entities.creatures;

public class Priest extends Player {
    public Priest(
            String name,
            int life,
            int attack,
            int mana,
            int speed,
            int luck) {
        super(
                name,
                "Sacerdote",
                40 + life * 1,
                8 + (int) (attack * 0.8),
                50 + (int) (mana * 1.5),
                12 + (int) (speed * 1.3),
                10 + (int) (luck * 1.2));
    }
}
