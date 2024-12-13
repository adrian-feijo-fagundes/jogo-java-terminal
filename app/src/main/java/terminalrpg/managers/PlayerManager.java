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

public class PlayerManager {
    public Player player;

    public PlayerManager(Scanner sc) {
        player = createPlayer(sc);
    }

    // Metodo para criar o jogador
    public Player createPlayer(Scanner sc) {
        Scene startAdventure = new Scene("Nova Aventura");
        startAdventure.showMessages(sc, List.of(
            "Ah, olá! Finalmente você chegou. Este é o início da sua jornada como aventureiro, não é? Que emocionante! ",
            "Você está prestes a se registrar na famosa Guilda dos Aventureiros, um lugar onde grandes histórias têm início e onde bravos heróis encontram seu destino.",
            "Mas antes de começar sua jornada, precisamos cuidar de algumas formalidades. Afinal, todo grande aventureiro precisa estar devidamente preparado, certo?",
            "Venha, vamos entrar. Logo, você estará pronto para enfrentar desafios e criar sua própria lenda!"

        ));
        System.out.println("Recepcionista:");
        System.out.println("Olá, bem-vindo à Guilda dos Aventureiros! É aqui que as maiores histórias começam. Posso saber o seu nome?");
        System.out.print("Digite seu nome: ");
        String name = sc.nextLine();

        System.out.printf("\nMuito prazer, %s! Antes de seguirmos, preciso saber qual é a sua proficiência. Você pode escolher entre", name);
        System.out.println("\n1. Mago");
        System.out.println("2. Guerreiro");
        System.out.println("3. Arqueiro");

        System.out.println("Qual delas melhor descreve você?");
        int choice = sc.nextInt();
        while (choice < 1 || choice > 3) {
            System.out.println("Escolha uma opção válida");
            choice = sc.nextInt();
        }
        System.out.println("Interessante! Agora, faremos um breve teste mágico para avaliar suas capacidades. Por favor, toque nesta esfera e mantenha sua mente focada no seu potencial.");

        System.out.println("\nAgora vamos rolar os dados para calcular os atributos do seu personagem");
        sc.nextLine();
        System.out.println("\nRolando dados para o HP (vida)");
        int life = Dice.roll(sc, 3, 6);
        System.out.println("\nRolando dados para o MP (mana)");
        int mana = Dice.roll(sc, 3, 6);
        System.out.println("\nRolando dados para o ATK (ataque)");
        int attack = Dice.roll(sc, 2, 6);
        System.out.println("\nRolando dados para o SPD (velocidade)");
        int speed = Dice.roll(sc, 2, 6);
        System.out.println("\nRolando dados para o LUCK (sorte)");
        int luck = Dice.roll(sc, 2, 6);
        Player player = switch (choice) {
            case 1 -> new Mage(mana, life, attack, speed, luck, name);
            case 2 -> new Warrior(mana, life, attack, speed, luck, name);
            case 3 -> new Archer(mana, life, attack, speed, luck, name);
            default -> null;
        };

        sc.nextLine();
        startAdventure.showMessages(sc, List.of(
            "Agora, para concluir seu cadastro na Guilda e se tornar oficialmente um aventureiro, precisará realizar um desafio. Não se preocupe, é uma tarefa simples, mas importante para provar sua capacidade.",
            "Você será direcionado ao local do desafio. Lá, encontrará as instruções necessárias para superá-lo. Mostre-nos do que é capaz!"
        ));

        return player;
    }

    public void menu(Scanner sc, String message) {
        this.player.getInfo();
        Message.enter("para voltar");
        sc.nextLine();
        sc.nextLine();
        System.out.println(message);
    }
}
