package entities.playable;
import java.util.ArrayList;
import java.util.List;

import entities.Character;
import entities.Creature;

public class Player extends Creature implements Character{
    private List<String> playerInventory;
    private double gold;
    public Player(
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
        gold = 0;
        playerInventory = new ArrayList<>();
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