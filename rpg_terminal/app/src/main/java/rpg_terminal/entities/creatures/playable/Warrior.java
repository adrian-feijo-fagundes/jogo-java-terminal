package rpg_terminal.entities.creatures.playable;

public class Warrior extends Player {
    public Warrior(
            String name,
            int life,
            int attack,
            int mana,
            int speed,
            int luck) {
        super(
                name,
                "Guerreiro",
                60 + (int) (life * 1.5),
                20 + (int) (attack * 1.4),
                10 + (int) (mana * 0.5),
                10 + speed,
                5 + (int) (luck * 0.8));
    }
}
