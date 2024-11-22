package entities;
import java.util.ArrayList;
import java.util.List;

public class Player extends Creature implements Character{
    private List<String> itensBag;
    private double gold;
    public Player(String nome, int life, int attack, int mana, int defense, int speed, int luck) {
        super(nome, life, attack, mana, defense, speed, luck);
        gold = 0;
        itensBag = new ArrayList<>();
    }

    public void getGold() {}
    public void setGold() {}
    public void openInventory() {}
    @Override
    public void attack() {}
    @Override
    public void specialAttack() {}
}