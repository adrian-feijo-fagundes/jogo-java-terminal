package rpg_terminal.entities.creatures;

public class Warrior extends Player {
    public Warrior(
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
            "Guerreiro",
            60 + (int) (life * 1.5),
            20 + (int) (attack * 1.4),
            10 + (int) (mana * 0.5),
            15 + (int) (defense * 1.2),
            10 + speed * 1,
            5  + (int) (luck * 0.8)
        );
    }
    @Override
    public String getInfo() {
        String info = String.format(
            "Classe: Guerreiro\nNome: %s\nHP: %d\nAtaque: %d\nMana: %d\nDefesa: %d\nVelocidade: %d\nSorte: %d",
            this.getName(),
            this.life,
            this.attack,
            this.mana,
            this.defense,
            this.speed,
            this.luck
        );
        return info; 
    }
}
