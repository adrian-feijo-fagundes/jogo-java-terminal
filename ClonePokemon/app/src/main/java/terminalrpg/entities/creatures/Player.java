/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package terminalrpg.entities.creatures;

import terminalrpg.entities.interfaces.PlayerInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import terminalrpg.entities.itens.Consumable;
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

        this.inventory = new ArrayList<>();
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

    public void listInventory() {
        for (Item item : this.inventory) {
            System.out.println(item.getName());
        }
    }
    public Item getItem(String name) {
        for (Item item : this.inventory) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
    public void listConsumables() {
        for (Consumable item : this.consumables) {
            System.out.println(item.getName());
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
        this.consumables.get(choice -1).use(this);
    }

    @Override
    public void useSpecialAbility(Creature other) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean flee() {
        int fleeChance = 100 - this.getTotalSpeed() + this.getTotalLuck();
        System.out.println("Para fugir é necessário conseguir pelo menos " + fleeChance + " pontos");

        int result = Dice.percent();

        return result >= fleeChance;
    }

    public void getInfo() {
        Map<String, Integer> bonusStatus = calcBonusStatus();
        calcTotalStatus();
        System.out.println("\n------------------------------------------");
        System.out.println("Nome: " + this.getName());
        System.out.println("Tipo: " + this.getType());
        System.out.println("\n------------------------------------------");
        System.out.println(" Vida: " + this.getLife());
        System.out.println("                     base:   bonus:    total:" );
        System.out.println(" Ataque                " + this.getAttack() + "       " + bonusStatus.get("bATK")  + "       " + this.getTotalAttack());
        System.out.println(" Mana                  " + this.getMana()   + "       " + bonusStatus.get("bMANA") + "       " + this.getTotalMana());
        System.out.println(" Velocidade            " + this.getSpeed()  + "       " + bonusStatus.get("bSPD")  + "       " + this.getTotalSpeed());
        System.out.println(" Sorte base            " + this.getLuck()   + "       " + bonusStatus.get("bLUCK") + "       " + this.getTotalLuck());
        System.out.println(" Redução de dano:                       " + this.getTotalDefense());
        System.out.println("------------------------------------------");
        System.out.println("Habilidade especial: " + this.getSpecialHabilityName());
        System.out.println("Decrição:\n" + this.getSpecialHabilityDescription());
        System.out.println("------------------------------------------");
    }
}
