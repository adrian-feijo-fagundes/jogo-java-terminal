package entities.playable;

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
            life,
            attack,
            mana,
            defense,
            speed,
            luck
        );
    }
    @Override
    public String getInfo() {
        String info = String.format(
            "Classe: Guerreiro\nNome: %s\nHP: %d\nAtaque: %d\nMana: %d\nDefesa: %d\nVelocidade: %d\nSorte: %d",
            this.name,
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
