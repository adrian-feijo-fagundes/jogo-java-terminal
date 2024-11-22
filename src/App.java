import java.util.Scanner;

import entities.playable.Player;
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
        System.out.println("Qual o nome do seu Personagem?");

        System.out.println("Você deseja escolher qual classe para o seu personagem?");
        System.out.println("1. Mercador");
        System.out.println("2. Mercador");
        System.out.println("3. Mercador");
        System.out.println("4. Mercador");
        
        
        
        Player player = new Warrior(null, 0, 0, 0, 0, 0, 0);
        return player;      
    }
}