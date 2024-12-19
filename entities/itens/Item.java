/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package terminalrpg.entities.itens;

import terminalrpg.entities.Entity;

/**
 *
 * @author Adrian
 */
public class Item extends Entity {
    private int bonus;

    public Item(String name) {
        super(name);
    }

    public int getBonus() {
        return bonus;
    }
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
    public String getInfo() {
        return String.format(this.getName());
    }
}
