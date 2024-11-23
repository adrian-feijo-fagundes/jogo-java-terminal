import java.util.Scanner;

import entities.playable.Hunter;
import entities.playable.Merchant;
import entities.playable.Player;
import entities.playable.Priest;
import entities.playable.Warrior;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Player player = createPlayer(sc);
        // Perguntar nome do personagem
        System.out.println(player.getInfo());

        // Perguntar classe do personagem
        // Calcular o poder do personagem rolando os dados
        //
        // 
        //

    }
    public static Player createPlayer(Scanner sc) {
        System.out.println("\nQual o nome do seu Personagem?");

        String name = sc.nextLine();
        System.out.println("\nVocê deseja escolher qual classe para o seu personagem?");
        System.out.println("1. Caçador");
        System.out.println("2. Sacerdorte");
        System.out.println("3. Guerreiro");
        System.out.println("4. Mercador");
        System.out.println("Digite sua escolha"); 
        int choice = sc.nextInt();
        
        System.out.println("\n Agora vamos rolar os dados para calcular os atributos do seu personagem");
        System.out.println("\n Rolando dados para o HP (vida)");
        int life = Dice.roll(sc, 3, 6);
        System.out.println("\n Rolando dados para o MP (mana)");
        int mana = Dice.roll(sc, 3, 6);
        System.out.println("\n Rolando dados para o ATK (ataque)");
        int attack = Dice.roll(sc, 2, 6);
        System.out.println("\n Rolando dados para o DEF (defesa)");
        int defense = Dice.roll(sc, 2, 6);
        System.out.println("\n Rolando dados para o SPD (velocidade)");
        int speed = Dice.roll(sc, 2, 6);
        System.out.println("\n Rolando dados para o LUCK (sorte)");
        int luck = Dice.roll(sc, 2, 6);
        do {
            switch (choice) {
                case 1:
                    return new Hunter(name, life, attack, mana, defense, speed, luck);
                case 2:
                    return new Priest(name, life, attack, mana, defense, speed, luck);
                case 3:
                    return new Warrior(name, life, attack, mana, defense, speed, luck);
                case 4:
                    return new Merchant(name, life, attack, mana, defense, speed, luck);
                default:
                    System.out.println("Escolha uma opção válida");
                    break;
            }    
        } while (true);     
    }
}