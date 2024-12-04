package rpg_terminal.entities.playable;

//import java.util.ArrayList;
//import java.util.List;

public class Player extends Creature {
    // private List<String> playerInventory;
    private String type;
    private double gold;

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
        gold = 0;
        // playerInventory = new ArrayList<>();
    }

    public double getGold() {
        return this.gold;
    }

    public void setGold(double gold) {
        this.gold = gold;
    }

    public void openInventory() {
    }

    @Override
    public String getInfo() {
        String info = String.format(
                "\nClasse: %s\nNome: %s\nHP: %d\nAtaque: %d\nMana: %d \nVelocidade: %d\nSorte: %d",
                this.type,
                this.getName(),
                this.life,
                this.attack,
                this.mana,
                this.speed,
                this.luck);
        return info;
    }
}