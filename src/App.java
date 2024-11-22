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
        do {
            switch (sc.nextInt()) {
                case 1:
                    return new Hunter(name, 0,0,0,0,0,0);
                case 2:
                    return new Priest(name, 0,0,0,0,0,0);
                case 3:
                    return new Warrior(name, 0,0,0,0,0,0);
                case 4:
                    return new Merchant(name, 0,0,0,0,0,0);
                default:
                    System.out.println("Escolha uma opção válida");
                    break;
            }    
        } while (true);     
    }
}