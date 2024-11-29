package rpg_terminal.scenarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import rpg_terminal.entities.creatures.Creature;

public class Scene {
    private final String description;
    private final List<Option> options;

    public Scene(String description) {
        this.description = description;
        this.options = new ArrayList<>();
    }

    public String getDescription() {
        return description;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void addOption(String optionDescription, Scene nextScene) {
        this.options.add(new Option(optionDescription, nextScene));
    }

    public void startEvent(Scanner sc, Creature player) {
        System.out.println(description);
    }

}
