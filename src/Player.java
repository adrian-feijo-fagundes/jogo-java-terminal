import java.util.ArrayList;
import java.util.List;

public class Player extends Criatura {
    private List<String> itensBag;
    private double gold;
    public Player(int[] attributes) {
        super(attributes);
        gold = 0;
        itensBag = new ArrayList<>();
    }

    public void getGold() {}
    public void setGold() {}
    public void attack() {}
    public void openInventory() {}
    public void specialAttack() {}
}