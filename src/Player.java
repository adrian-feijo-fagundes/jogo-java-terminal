import java.util.ArrayList;
import java.util.List;

public class MainCharacter extends Criatura {
    private List<String> itensBag;
    private double gold;
    public MainCharacter(int[] attributes) {
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