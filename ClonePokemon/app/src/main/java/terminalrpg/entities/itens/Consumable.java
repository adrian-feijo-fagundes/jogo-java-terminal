/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package terminalrpg.entities.itens;

import terminalrpg.entities.creatures.Player;

/**
 *
 * @author Adrian
 */
public class Consumable extends Item {
    private int quantity;
    private String bonusType;
    public Consumable(String name, String bonusType, int bonus) {
        super(name, "Consumivel");
        this.setBonus(bonus);
        this.quantity = 1;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void use(Player player) {
        System.out.print("Voce usou " + this.getName());
        switch (bonusType) {
            case "life" -> {
                System.out.println("Voce aumentou sua vida em " + this.getBonus() + " pontos.");
                player.setLife(player.getLife() + this.getBonus());
            }
            case "mana" -> {
                System.out.println("Voce aumentou sua mana em " + this.getBonus() + " pontos.");
                player.setMana(player.getMana() + this.getBonus());
            }
        }
    }
    
    @Override
    public String getInfo() {
        return this.getName() + "   bonus: " + this.bonusType + "  +" + this.getBonus() + " qtd:" + this.quantity; 
    }
}
