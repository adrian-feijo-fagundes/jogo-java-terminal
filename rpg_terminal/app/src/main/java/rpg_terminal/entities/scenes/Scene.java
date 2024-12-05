package rpg_terminal.entities.scenes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import rpg_terminal.entities.Entity;
import rpg_terminal.entities.creatures.Creature;
import rpg_terminal.utils.GameState;
import rpg_terminal.utils.Screen;

public class Scene extends Entity {
    private final List<String> messages;
    private final List<String> firstMessages;
    private final List<Option> options;

    public Scene(String id) {
        super(id);
        this.messages = new ArrayList<>();
        this.firstMessages = new ArrayList<>();
        this.options = new ArrayList<>();
    }

    public List<String> getMessages() {
        return messages;
    }

    public List<String> getFirstMessages() {
        return firstMessages;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void addOption(String optionDescription, Scene nextScene, String firstMessage, String message) {
        this.options.add(new Option(optionDescription, nextScene, firstMessage, message));
    }

    public void addMessages(String[] newMessages) {
        for (String message : newMessages) {
            this.messages.add(message);
        }
    }

    public void addFirstMessages(String[] newFirstMessages) {
        for (String message : newFirstMessages) {
            this.firstMessages.add(message);
        }
    }

    public Scene startEvent(Scanner sc, Creature player, GameState gameState) {
        // Verifica se esta cena já foi visitada no GameState
        boolean isFirstVisit = !gameState.hasVisited(this.getId());
        List<String> currentMessages = isFirstVisit ? this.firstMessages : this.messages;

        for (int i = 0; i < currentMessages.size(); i++) {
            Screen.clear();
            if (i < currentMessages.size() - 1) {
                System.out.println(currentMessages.get(i));
                System.out.println("\nPRESSIONE ENTER PARA CONTINUAR");
                sc.nextLine();// Aguarda o jogador pressionar Enter
            } else {
                System.out.println(currentMessages.get(i));
            }
        }

        // Marca a cena como visitada no GameState
        if (isFirstVisit) {
            gameState.addToVisited(this.getId());
        }

        // Exibe as opções disponíveis
        if (!this.options.isEmpty()) {
            System.out.println("\nO que você deseja fazer?");
            for (int i = 0; i < this.options.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, this.options.get(i).getDescription());
            }

            // Captura e valida a escolha do jogador
            int escolha = -1;
            while (escolha < 1 || escolha > this.options.size()) {
                System.out.print("\nEscolha uma opção: ");
                try {
                    escolha = sc.nextInt();
                    sc.nextLine();
                } catch (Exception e) {
                    sc.nextLine(); // Limpa a entrada inválida
                    System.out.println("Por favor, insira um número válido.");
                }
            }

            // Retorna a próxima cena conforme a escolha
            return this.options.get(escolha - 1).getNextScene();
        }

        // Caso não haja opções
        System.out.println("\nNão há mais opções nesta cena. Fim de jogo.");
        return null;
    }

}
