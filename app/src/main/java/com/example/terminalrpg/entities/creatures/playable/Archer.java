/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.terminalrpg.entities.creatures.playable;

import com.example.terminalrpg.entities.creatures.Player;

/**
 *
 * @author Adrian
 */
public class Archer extends Player {

    public Archer(
            int mana,
            String type,
            int life,
            int attack,
            int speed,
            int luck,
            String id,
            String name) {

        super(
                mana,
                type,
                life,
                attack,
                speed,
                luck,
                id,
                name);
    }

}
