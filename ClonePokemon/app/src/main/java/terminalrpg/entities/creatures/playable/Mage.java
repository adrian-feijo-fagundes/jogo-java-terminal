/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package terminalrpg.entities.creatures.playable;

import terminalrpg.entities.creatures.Player;

/**
 *
 * @author Adrian
 */
public class Mage extends Player {

    public Mage(
            int mana,
            int life,
            int attack,
            int speed,
            int luck,
            String name) {

        super(
                mana,
                "Mage",
                life,
                attack,
                speed,
                luck,
                name);
    }

}
