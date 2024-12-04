package rpg_terminal.entities.scenes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import rpg_terminal.entities.creatures.Creature;
import rpg_terminal.utils.Screen;

public class Scene {
    private final List<String> messages;
    private final List<String> firstMessages;
    private final List<Option> options;

    public Scene() {
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

    public void addOption(String optionDescription, Scene nextScene) {
        this.options.add(new Option(optionDescription, nextScene));
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

    public Scene startEvent(Scanner sc, Creature player) {
        // Exibe mensagens
        for (String message : this.messages) {
            Screen.clear();
            System.out.println(message);
            if (message != this.messages.get(this.messages.size() - 1)) {
                System.out.println("\nPRESSIONE ENTER PARA CONTINUAR");
                sc.nextLine(); // Aguarda o jogador pressionar Enter
            }
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
