/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.terminalrpg.entities.creatures;

import com.example.terminalrpg.entities.interfaces.EnemyInterface;
import com.example.terminalrpg.entities.itens.Item;


/**
 *
 * @author Adrian
 */
public class Enemy extends Creature implements EnemyInterface {
    private Item drop;

    public Enemy(

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
        this.drop = null;
    }

    public Item getDrop() {
        return drop;
    }

    public void setDrop(Item drop) {
        this.drop = drop;
    }

    @Override
    public Item drop() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
