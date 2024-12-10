/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package terminalrpg.entities.creatures;

import terminalrpg.entities.interfaces.PlayerInterface;
import java.util.ArrayList;
import java.util.List;

import terminalrpg.entities.itens.Item;

/**
 *
 * @author Adrian
 */
public class Player extends Creature implements PlayerInterface {
    private int mana;
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
                type,
                life,
                attack,
                speed,
                luck,
                name);
        this.mana = mana;
        this.inventory = new ArrayList<>();
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
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

    public void addItem(Item item) {
        this.inventory.add(item);
    }

    @Override
    public void useItem(Item item) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void useSpecialAbility() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean flee() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
