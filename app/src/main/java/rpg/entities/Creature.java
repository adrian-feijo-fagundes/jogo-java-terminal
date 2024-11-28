package rpg.entities;

import utils.Dice;
import utils.Entity;
import rpg.interfaces.Character;


public class Creature extends Entity implements Character{
    public int life;
    public int attack;
    public int mana;
    public int defense;
    public int speed;
    public int luck;

    public Creature(
        String name,
        int life,
        int attack,
        int mana,
        int defense,
        int speed,
        int luck
    ) {
        super(name);
        this.life = life;
        this.attack = attack;
        this.mana = mana;
        this.defense = defense;
        this.speed = speed;
        this.luck = luck;
    } 
    @Override
    public void specialAttack() {

    }
    
    public void useItem() {

    }

    public boolean run() {
        return false;
    }
    // Metodo encarregado de "Medir" quanto os atributos do inimigo influenciam na chance de esquiva do mesmo
    public int calcDifficult() {
        return ((int) (this.luck * 0.5)) + ((int) (this.speed * 0.5));
    }

    // Calcula se a esquiva aconteceu
    public boolean dodge(int difficulty) {
        int dodgeChance = 100 - (((int) (this.luck * 0.4)) + ((int) (this.speed * 0.6)) - difficulty);

        int result = Dice.simpleRoll(10) * 10;
        System.out.println("O dado foi jogado e o resultado obtido foi " + result + " pontos (resultado do dado multiplicado por 10)");
        System.out.println("Para desviar do golpe era necessário conseguir pelo menos "+ dodgeChance + " pontos");
        
        boolean dodge = result >= dodgeChance;

        if (dodge) {
            System.out.println(this.getName() + "Conseguiu esquivar!");
        } else {
            System.out.println(this.getName() + "Não conseguiu esquivar!");
        }
        return dodge;
    }


    public int criticalHit() {
        //if (this.hasCriticalBonusItem()) { // Exemplo: item ou buff que aumenta a chance
        //        criticalChance += 15; // Aumenta a chance em 15% (ajuste conforme necessário)
        //}
        int randomValue = (int) (Math.random() * 100) + 1;
        
        if (randomValue <= this.luck) {
            return 2; // Multiplicador crítico
        }
        return 1; // Ataque normal
    }
        

    @Override
    public void attack(Creature other) {
        int critical = this.criticalHit();
        
        // Verifica se o oponente esquivou
        if (other.dodge(this.calcDifficult())) return;
        
        other.life -= (this.attack * this.criticalHit());
        
        if (critical > 1) {
            System.out.println("Acertou um ataque crítico");
        }
    }
    public String getInfo() {
        return "";
    }
}