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
public class Item extends Entity{
    private String description;
    private final String type;
    private int bonus;
    
    public Item(String name, String type) {
        super(name);
        this.type = type;
        this.description = "";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public String getType() {
        return type;
    }
    
    public String getInfo() {
        return String.format("%s %s", this.getName(), this.getType());
    }
}
