/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package terminalrpg.entities.interfaces;

import terminalrpg.entities.creatures.Creature;

/**
 *
 * @author Adrian
 */
public interface CreatureInterface {
    public void attack(Creature other);

    public boolean evade(int difficult);

    public int criticalHit();
}