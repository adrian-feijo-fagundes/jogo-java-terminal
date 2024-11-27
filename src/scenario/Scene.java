package scenario;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Creature;


public class Scene {
    private String description;
    private List<Option> options;

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

    public void startEvent() {
        System.out.println(description);
    }

    
}
