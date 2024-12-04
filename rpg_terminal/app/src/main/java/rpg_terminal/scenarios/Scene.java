package rpg_terminal.scenarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import rpg_terminal.Screen;
import rpg_terminal.entities.playable.Creature;

public class Scene {
    private final List<String> messages;
    private final List<Option> options;

    public Scene(List<String> messages) {
        this.messages = new ArrayList<>(messages);
        this.options = new ArrayList<>();
    }

    public List<String> getMessages() {
        return messages;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void addOption(String optionDescription, Scene nextScene) {
        this.options.add(new Option(optionDescription, nextScene));
    }

    public void startEvent(Scanner sc, Creature player) {
        // Ainda vou utilizar o "player" para iterações futuras
        // Muito provavelmente vou ir dividindo o código para ficar mais organizado está
        // ainda é uma versão inicial
        // Mostrar mensagens
        for (String message : this.messages) {
            Screen.clear();
            System.out.println(message);
            if (message != this.messages.get(this.messages.size() - 1)) {
                System.out.println("\nPRESSIONE ENTER PARA CONTINUAR");
                sc.nextLine();
            }
        }
        System.out.println("\nO que fazer?");
        // Vou inserir as opções aqui
        sc.nextInt();
    }

}
