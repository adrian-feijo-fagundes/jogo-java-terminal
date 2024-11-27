package scenario;

import java.util.Scanner;

import entities.Entity;

public class Combat extends Scene {
    
    public Combat(String description) {
        super(description);
    }
    
    @Override
    public void startEvent(Scanner sc, Entity[] objects) {
        System.out.println("Combate Iniciou");
        boolean combat = true;
        do {
            //System.out.println("Sua Vida: " + player.life);
            //System.out.println("Inimigo Vida: " + enemy.life);
            System.out.println("O que vc deseja fazer?");
            System.out.println("1.Atacar");
            System.out.println("2.Usar habilidade");
            System.out.println("3.Usar item");
            System.out.println("4.fugir");
            switch (sc.nextInt()) {
                case 1:
                    System.out.println("Atacou"); 
                    break;
                case 2:    
                    System.out.println("Usou habilidade");
                    break;
                case 3:
                    System.out.println("Usou item");
                    //player.useItem();
                    //enemy.attack(player);
                    break;
                case 4:
                    System.out.println("Fugiu!");
                    //if (player.run()) combat = false;      
                    break;
                default:
                    System.out.println("Escolha uma opção valida");                
                    break;
            }
        } while (combat);
    }
}
