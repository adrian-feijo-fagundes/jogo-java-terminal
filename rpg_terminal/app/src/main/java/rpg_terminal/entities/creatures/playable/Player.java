package rpg_terminal.entities.creatures.playable;

import rpg_terminal.entities.creatures.Creature;

//import java.util.ArrayList;
//import java.util.List;

public class Player extends Creature {
    // private List<String> playerInventory;
    private String type;

    public Player(
            String name,
            String type,
            int life,
            int attack,
            int mana,
            int speed,
            int luck) {
        super(
                name,
                life,
                attack,
                mana,
                speed,
                luck);
        this.type = type;

        // playerInventory = new ArrayList<>();
    }

    public void openInventory() {
    }

    @Override
    public String getInfo() {
        return String.format(
                "\nClasse: %s\nNome: %s\nHP: %d\nAtaque: %d\nMana: %d \nVelocidade: %d\nSorte: %d",
                this.type,
                this.getId(),
                this.life,
                this.attack,
                this.mana,
                this.speed,
                this.luck);
    }
}