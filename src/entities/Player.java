package entities;
import java.util.ArrayList;
import java.util.List;

public class Player extends Criatura implements Character{
    private List<String> itensBag;
    private double gold;
    public Player(int[] attributes) {
        super(attributes);
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