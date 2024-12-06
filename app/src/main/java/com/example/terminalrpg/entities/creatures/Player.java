/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.terminalrpg.entities.creatures;

import com.example.terminalrpg.entities.interfaces.Item;
import com.example.terminalrpg.entities.interfaces.PlayerInterface;
import java.util.ArrayList;
import java.util.List;

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
            String id,
            String name) {

        super(
                type,
                life,
                attack,
                speed,
                luck,
                id,
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

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
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
