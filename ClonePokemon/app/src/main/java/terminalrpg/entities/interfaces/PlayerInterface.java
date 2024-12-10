/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package terminalrpg.entities.interfaces;

import terminalrpg.entities.itens.Item;

/**
 *
 * @author Adrian
 */
public interface PlayerInterface {
    public void useItem(Item item);

    public void useSpecialAbility();

    public boolean flee();
}
