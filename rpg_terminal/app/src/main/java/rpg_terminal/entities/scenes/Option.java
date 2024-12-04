package rpg_terminal.entities.scenes;

public class Option {
    private String description;
    private Scene nextScene;

    public Option(String description, Scene nextScene) {
        this.description = description;
        this.nextScene = nextScene;
    }

    public String getDescription() {
        return description;
    }

    public Scene getNextScene() {
        return nextScene;
    }

}
