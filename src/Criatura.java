public class Criatura extends Entidade {
    public int vida;
    public int forca;
    public int mana;
    public int defesa;
    public int velocidade;
    public int sorte;
    
    public Criatura(int[] posicao, int[] atributos) {
        super(posicao[0], posicao[1]);
        this.vida = atributos[0];
        this.forca = atributos[1];
        this.mana = atributos[2];
        this.defesa = atributos[3];
        this.velocidade = atributos[4];
        this.sorte = atributos[5];
    }

}