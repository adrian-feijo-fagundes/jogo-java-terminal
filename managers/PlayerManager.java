package terminalrpg.managers;

import java.util.List;
import java.util.Scanner;

import terminalrpg.entities.creatures.Player;
import terminalrpg.entities.creatures.playable.Archer;
import terminalrpg.entities.creatures.playable.Mage;
import terminalrpg.entities.creatures.playable.Warrior;
import terminalrpg.entities.scene.Scene;
import terminalrpg.utils.Dice;
import terminalrpg.utils.Message;
import terminalrpg.utils.Screen;

public class PlayerManager {
    public Player player;

    public PlayerManager(Scanner sc) {
        player = createPlayer(sc);
    }

    // Metodo para criar o jogador
    public Player createPlayer(Scanner sc) {
        Scene startAdventure = new Scene("Nova Aventura");
        System.out.println("\n");
        startAdventure.showMessages(sc, List.of(
            "Ah, ola! Finalmente você chegou. Este e o inicio da\nsua jornada como aventureiro, não é? Que emocionante! ",
            "Voce esta prestes a se registrar na famosa Guilda dos\nAventureiros, um lugar onde grandes historias tem inicio\ne onde bravos herois encontram seu destino.",
            "Mas antes de começar sua jornada, precisamos cuidar de\nalgumas formalidades. Afinal, todo grande aventureiro \nprecisa estar devidamente preparado, certo?",
            "Venha, vamos entrar. Logo, voce estara\npronto para enfrentar desafios e criar sua propria lenda!"

        ));
        Screen.clear();
        System.out.println("Recepcionista:");
        System.out.println("\nOla, bem-vindo a Guilda dos Aventureiros!\nAqui que as maiores historias começam. \n\nPosso saber o seu nome?");
        System.out.print("Digite seu nome: ");
        String name = sc.nextLine();

        System.out.printf("\nMuito prazer, %s! Antes de seguirmos, preciso saber qual e a sua proficiência.\nVocê pode escolher entre:", name);
        System.out.println("\n1. Mago");
        System.out.println("2. Guerreiro");
        System.out.println("3. Arqueiro");

        System.out.print("Qual delas melhor descreve você? ");
        int choice = sc.nextInt();
        while (choice < 1 || choice > 3) {
            System.out.println("Escolha uma opção válida");
            choice = sc.nextInt();
        }
        Screen.clear();
        System.out.println("Interessante! Agora, faremos um breve teste mágico para avaliar \nsuas capacidades. Por favor, toque nesta esfera e mantenha sua mente focada no seu potencial.");

        System.out.println("\nROLAGEM DE DADOS");
        sc.nextLine();
        System.out.println("Rolando dados para o HP (vida)");
        int life = Dice.roll(sc, 3, 6);
        System.out.println("Rolando dados para o MP (mana)");
        int mana = Dice.roll(sc, 3, 6);
        System.out.println("Rolando dados para o ATK (ataque)");
        int attack = Dice.roll(sc, 2, 6);
        System.out.println("Rolando dados para o SPD (velocidade)");
        int speed = Dice.roll(sc, 2, 6);
        System.out.println("Rolando dados para o LUCK (sorte)");
        int luck = Dice.roll(sc, 2, 6);
        Player player = switch (choice) {
            case 1 -> new Mage(mana, life, attack, speed, luck, name);
            case 2 -> new Warrior(mana, life, attack, speed, luck, name);
            case 3 -> new Archer(mana, life, attack, speed, luck, name);
            default -> null;
        };
        Screen.clear();
        startAdventure.showMessages(sc, List.of(
            "Para concluir seu cadastro na Guilda e se tornar oficialmente \num aventureiro, precisará realizar um desafio. Não se preocupe, é uma tarefa simples, \nmas importante para provar sua capacidade.",
            "Você será direcionado ao local do desafio. \nLá, encontrará as instruções necessárias para superá-lo. \nMostre-nos do que é capaz!"
        ));
        Screen.clear();
        return player;
    }

    public void menu(Scanner sc, String message) {
        this.player.getInfo();
        Message.enter("");
        sc.nextLine();
        System.out.println("\n" + message);
    }
}
