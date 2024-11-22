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
            life,
            attack,
            mana,
            defense,
            speed,
            luck
        );
    }
}
