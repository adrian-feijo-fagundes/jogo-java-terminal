/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package terminalrpg.entities.creatures;

import terminalrpg.entities.interfaces.CreatureInterface;
import terminalrpg.entities.itens.Equipable;
import terminalrpg.utils.Dice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import terminalrpg.entities.Entity;

/**
 *
 * @author Adrian
 */
public class Creature extends Entity implements CreatureInterface {
    private String type;
    private int life;
    private int attack;
    private int speed;
    private int luck;
    private int mana;
    private int totalDefense;
    private int totalAttack;
    private int totalSpeed;
    private int totalLuck;
    private int totalMana;
    private List<Equipable> equipment;

    public Creature(
            int mana,
            String type,
            int life,
            int attack,
            int speed,
            int luck,
            String name) {
        super(name);
        this.mana       = mana;
        this.type       = type;
        this.life       = life;
        this.attack     = attack;
        this.speed      = speed;
        this.luck       = luck;
        totalAttack     = attack;
        totalDefense    = 0;
        totalLuck       = luck;
        totalMana       = mana;
        totalSpeed      = speed;
        this.equipment  = new ArrayList<>();
    }
    
    public String  getType()             { return type;                         }
    public String  getTypeName()         { return type + " " + this.getName();  }
    public int     getMana()             { return mana;                         }
    public void    setMana(int mana)     { this.mana = mana;                    }
    public int     getTotalMana()        { return totalMana;                    }
    public int     getLife()             { return life;                         }
    public void    setLife(int life)     { this.life = life;                    }
    public int     getAttack()           { return attack;                       }
    public void    setAttack(int attack) { this.attack = attack;                }
    public int     getTotalAttack()      { return totalAttack;                  }
    public int     getSpeed()            { return speed;                        }
    public void    setSpeed(int speed)   { this.speed = speed;                  }
    public int     getTotalSpeed()       { return totalSpeed;                   }
    public int     getLuck()             { return luck;                         }
    public void    setLuck(int luck)     { this.luck = luck;                    }
    public int     getTotalLuck()        { return totalLuck;                    }
    public int     getTotalDefense()     { return totalDefense;                 }

    public boolean isDead() {
        return this.getLife() < 0;
    }
    public boolean hasEquipment() {
        return this.equipment.size() > 0;
    }
    public void addEquipment(Equipable equipment) {
        this.equipment.add(equipment);
    }
    

    public Map <String, Integer> calcBonusStatus() {
        int bonusAttack = 0;
        int bonusDefense = 0;
        int bonusMana = 0;
        int bonusSpeed = 0;
        int bonusLuck = 0;

        if (hasEquipment()) {
            for (Equipable equipment : this.equipment) {
                bonusAttack += equipment.getBonusAttack();
                bonusDefense += equipment.getBonusDefense();
                bonusMana += equipment.getBonusMana();
                bonusSpeed += equipment.getBonusSpeed();
                bonusLuck += equipment.getBonusLuck();
            }
        }

        Map<String, Integer> totBonusStatus = new HashMap<>();
        totBonusStatus.put("bATK", bonusAttack);
        totBonusStatus.put("bDEF", bonusDefense);
        totBonusStatus.put("bMANA", bonusMana);
        totBonusStatus.put("bSPD", bonusSpeed);
        totBonusStatus.put("bLUCK", bonusLuck);

        return totBonusStatus;
    }

    public void calcTotalStatus() {
        Map<String, Integer> bonusStatus = calcBonusStatus();
        
        totalAttack = this.attack + bonusStatus.get("bATK");
        totalDefense = bonusStatus.get("bDEF") ;
        totalMana = this.mana + bonusStatus.get("bMANA");
        totalSpeed = this.speed + bonusStatus.get("bSPD");
        totalLuck = this.luck + bonusStatus.get("bLUCK");
    }
    @Override
    public boolean evade(int difficult) {
        int dodgeChance = 100 - (((int) (this.totalLuck * 0.4)) + ((int) (this.totalSpeed * 0.6)) - difficult);

        System.out.println("Para desviar do golpe é necessário conseguir pelo menos " + dodgeChance + " pontos");

        int result = Dice.percent();

        boolean dodge = result >= dodgeChance;

        if (dodge) {
            System.out.println(this.getTypeName() + "Conseguiu esquivar!");
        } else {
            System.out.println(this.getTypeName() + "Não conseguiu esquivar!");
        }
        return dodge;
    }

    @Override
    public int criticalHit() {
        int randomValue = Dice.percent();

        if (randomValue <= this.totalLuck) {
            return 2; // Multiplicador crítico
        }
        return 1; // Ataque normal
    }

    public boolean attackPriority(Creature other) {
        return this.totalSpeed > other.getTotalSpeed();
    }

    private int calcDifficult() {
        return ((int) (this.totalLuck * 0.5)) + ((int) (this.totalSpeed * 0.5));
    }
 
    @Override
    public void attack(Creature other) {
       
        int critical = this.criticalHit();

        // Verifica se o oponente esquivou
        if (other.evade(this.calcDifficult())) {
            return;
        }
        if (critical > 1) {
            System.out.println("Acertou um ataque crítico");
        }

        int damage = (this.totalAttack * critical) - other.getTotalDefense();
        System.out.println("O dano total é de: " +  damage);
        int newLife = other.getLife() -  damage;
        System.out.println("A vida de " + other.getName() + "foi de " + other.getLife() + " para " + newLife);

        other.setLife(newLife);
        
    }

    
}
