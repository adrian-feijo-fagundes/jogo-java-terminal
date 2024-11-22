package entities;

public class Creature{
    private String nome;
    public int life;
    public int attack;
    public int mana;
    public int defense;
    public int speed;
    public int luck;

    public Creature(String nome,int life, int attack, int mana, int defense, int speed, int luck) {
        this.nome = nome;
        this.life = life;
        this.attack = attack;
        this.mana = mana;
        this.defense = defense;
        this.speed = speed;
        this.luck = luck;
    }
}