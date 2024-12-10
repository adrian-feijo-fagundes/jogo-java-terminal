/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package terminalrpg.entities.itens;

/**
 *
 * @author Adrian
 */
public class Equipable extends Item {
    private String equipType;


    public Equipable(String name) {
        super(name, "Equipamento");
    }

    public String getEquipType() {
        return equipType;
    }

    public void setType(String equipType) {
        this.equipType = equipType;
    }



}
