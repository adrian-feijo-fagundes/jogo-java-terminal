package rpg_terminal.entities.creatures.playable;

public class Hunter extends Player {
    public Hunter(
            String name,
            int life,
            int attack,
            int mana,
            int speed,
            int luck) {
        super(
                name,
                "Caçador",
                45 + (int) (life * 1.1),
                15 + (int) (attack * 1.4),
                30 + mana * 1,
                12 + (int) (speed * 1.4),
                10 + (int) (luck * 1.1));
    }
}
