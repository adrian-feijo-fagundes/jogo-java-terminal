/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package terminalrpg.entities.interfaces;

import java.util.Scanner;

import terminalrpg.entities.creatures.Creature;
import terminalrpg.entities.itens.Consumable;

/**
 *
 * @author Adrian
 */
public interface PlayerInterface {
    public void useItem(Scanner sc);

    public void useSpecialAbility(Creature other);

    public boolean flee();
}
