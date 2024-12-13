/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package terminalrpg.entities.creatures;

import terminalrpg.entities.interfaces.PlayerInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import terminalrpg.entities.itens.Consumable;
import terminalrpg.entities.itens.Equipable;
import terminalrpg.entities.itens.Item;
import terminalrpg.utils.Dice;

/**
 *
 * @author Adrian
 */
public class Player extends Creature implements PlayerInterface {
    private String specialHabilityDescription;
    private String specialHabilityName;
    private List<Consumable> consumables;
    private List<Item> inventory;
    private int totalAttack;
    private int totalLuck;
    private int totalMana;
    private List<Equipable> equipments;

    public Player(
            int mana,
            String type,
            int life,
            int attack,
            int speed,
            int luck,
            String name) {

        super(
                mana,
                type,
                life,
                attack,
                speed,
                luck,
                name);
        totalAttack = attack;
        totalLuck = luck;
        totalMana = mana;
        this.equipments = new ArrayList<>();

        this.inventory = new ArrayList<>();
        this.consumables = new ArrayList<>();
    }

    public int getTotalMana() {
        return totalMana;
    }

    public int getTotalAttack() {
        return totalAttack;
    }

    public int getTotalLuck() {
        return totalLuck;
    }

    public void setSpecialHabilityDescription(String description) {
        this.specialHabilityDescription = description;
    }

    public String getSpecialHabilityDescription() {
        return this.specialHabilityDescription;
    }

    public void setSpecialHabilityName(String name) {
        this.specialHabilityName = name;
    }

    public String getSpecialHabilityName() {
        return this.specialHabilityName;
    }

    public void listEquipments() {
        for (Equipable equipment : this.equipments) {
            System.out.println(" " + equipment.getName());
        }
    }

    public boolean hasEquipment() {
        return this.equipments.size() > 0;
    }

    public void addEquipment(Equipable equipment) {
        this.equipments.add(equipment);
    }

    public Map<String, Integer> calcBonusStatus() {
        int bonusAttack = 0;
        int bonusDefense = 0;
        int bonusMana = 0;
        int bonusSpeed = 0;
        int bonusLuck = 0;

        if (!hasEquipment()) {
            for (Equipable equipment : this.equipments) {
                bonusAttack += equipment.getBonusAttack();
                bonusDefense += equipment.getBonusDefense();
                bonusMana += equipment.getBonusMana();
                bonusSpeed += equipment.getBonusSpeed();
                bonusLuck += equipment.getBonusLuck();
            }
        }

        Map<String, Integer> totBonusStatus = new HashMap<>();
        totBonusStatus.put("bATK", bonusAttack);
        totBonusStatus.put("bDEF", bonusDefense);
        totBonusStatus.put("bMANA", bonusMana);
        totBonusStatus.put("bSPD", bonusSpeed);
        totBonusStatus.put("bLUCK", bonusLuck);

        return totBonusStatus;
    }

    public void calcTotalStatus() {
        Map<String, Integer> bonusStatus = calcBonusStatus();

        totalAttack = this.getAttack() + bonusStatus.get("bATK");
        setTotalDefense(bonusStatus.get("bDEF"));
        totalMana = this.getMana() + bonusStatus.get("bMANA");
        setTotalSpeed(bonusStatus.get("bSPD"));
        totalLuck = this.getLuck() + bonusStatus.get("bLUCK");
    }

    public void listInventory() {
        for (Item item : this.inventory) {
            System.out.println(" " + item.getName());
        }
    }

    public boolean hasItens() {
        return inventory.size() > 0;
    }

    public Item getItem(String name) {
        for (Item item : this.inventory) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public void addConsumable(Consumable item) {
        this.consumables.add(item);
    }

    public void listConsumables() {
        for (Consumable item : this.consumables) {
            System.out.println(" " + item.getInfo());
        }
    }

    public Consumable getConsumble(String name) {
        for (Consumable item : this.consumables) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public boolean hasConsumables() {
        return consumables.size() > 0;
    }

    public void addItem(Item item) {
        this.inventory.add(item);
    }

    public boolean hasMana(int cost) {
        return this.getMana() > cost;
    }

    public void clearConsumables() {
        for (Consumable item : this.consumables) {
            if (item.getQuantity() == 0) {
                consumables.remove(item);
            }
        }
    }

    @Override
    public void useItem(Scanner sc) {
        clearConsumables();
        int choice = -1;
        while (true) {
            System.out.println("\n Seus Itens ");
            for (int i = 0; i < this.consumables.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, this.consumables.get(i).getInfo());
            }
            System.out.print("\nEscolha uma opção: ");
            choice = sc.nextInt();

            if (choice > 0 && choice <= this.consumables.size()) {
                break;
            } else {
                System.out.println("Escolha uma opção válida");
            }
        }
        this.consumables.get(choice - 1).use(this);
    }

    @Override
    public void useSpecialAbility(Scanner sc, Creature other) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean flee(Scanner sc) {
        int fleeChance = 100 - this.getTotalSpeed() + this.getTotalLuck();
        System.out.println("Para fugir é necessário conseguir pelo menos " + fleeChance + " pontos");

        int result = Dice.percent(sc);

        return result >= fleeChance;
    }

    @Override
    public boolean evade(Scanner sc, int difficult) {
        int dodgeChance = 100 - (((int) (this.totalLuck * 0.4)) + ((int) (this.getTotalSpeed() * 0.6)) - difficult);

        System.out.println("Para desviar do golpe é necessário conseguir pelo menos " + dodgeChance + " pontos");

        int result = Dice.percent(sc);

        boolean dodge = result >= dodgeChance;

        if (dodge) {
            System.out.println(this.getTypeName() + "Conseguiu esquivar!");
        } else {
            System.out.println(this.getTypeName() + "Não conseguiu esquivar!");
        }
        return dodge;
    }

    @Override
    public int criticalHit(Scanner sc) {
        int randomValue = Dice.percent(sc);

        if (randomValue <= this.totalLuck) {
            return 2; // Multiplicador crítico
        }
        return 1; // Ataque normal
    }

    @Override
    public void attack(Scanner sc, Creature other) {
        System.out.println(this.getTypeName() + "Começou a atacar!\n");
        // Verifica se o oponente esquivou
        if (other.evade(sc, this.calcDifficult())) {
            return;
        }
        int critical = this.criticalHit(sc);

        if (critical > 1) {
            System.out.println("Acertou um ataque crítico");
        }

        int damage = (this.totalAttack * critical);
        System.out.println("O dano total é de: " + damage);
        int newLife = other.getLife() - damage;
        System.out.println("A vida de " + other.getTypeName() + " foi de " + other.getLife() + " para " + newLife);

        other.setLife(newLife);

    }

    public void getInfo() {
        Map<String, Integer> bonusStatus = calcBonusStatus();
        calcTotalStatus();
        System.out.println("\n------------------------------------------");
        System.out.println("Nome: " + this.getName());
        System.out.println("Tipo: " + this.getType());
        System.out.println("\n------------------------------------------");
        System.out.println(" Vida: " + this.getLife());
        System.out.println("                     base:   bonus:    total:");
        System.out.println(" Ataque                " + this.getAttack() + "       " + bonusStatus.get("bATK")
                + "       " + this.getTotalAttack());
        System.out.println(" Mana                  " + this.getMana() + "       " + bonusStatus.get("bMANA") + "       "
                + this.getTotalMana());
        System.out.println(" Velocidade            " + this.getSpeed() + "       " + bonusStatus.get("bSPD") + "       "
                + this.getTotalSpeed());
        System.out.println(" Sorte base            " + this.getLuck() + "       " + bonusStatus.get("bLUCK") + "       "
                + this.getTotalLuck());
        System.out.println(" Redução de dano:                       " + this.getTotalDefense());
        System.out.println("------------------------------------------");
        System.out.println(" Habilidade especial: " + this.getSpecialHabilityName());
        System.out.println(" Decrição:\n" + this.getSpecialHabilityDescription());
        System.out.println("------------------------------------------\n");

        if (hasConsumables()) {
            System.out.println(" Consumiveis:");
            listConsumables();
            System.out.println("------------------------------------------\n");
        }
        if (hasEquipment()) {
            System.out.println(" Equipamentos:");
            listEquipments();
            System.out.println("------------------------------------------\n");
        }
        if (hasItens()) {
            System.out.println(" Outros:");
            listEquipments();
            System.out.println("------------------------------------------\n");
        }
    }
}
