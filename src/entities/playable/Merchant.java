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
            life,
            attack,
            mana,
            defense,
            speed,
            luck
        );
    }
}
