package entities.playable;
import java.util.ArrayList;
import java.util.List;

import entities.Character;
import entities.Creature;

public class Player extends Creature implements Character{
    private List<String> itensBag;
    private double gold;
    public Player(int[] attributes) {
        super(attributes);
        gold = 0;
        itensBag = new ArrayList<>();
    }

    public double getGold() {
        return this.gold;
    }
    public void setGold(double gold) {
        this.gold = gold;
    }
    public void openInventory() {}
    @Override
    public void attack() {}
    @Override
    public void specialAttack() {}
}