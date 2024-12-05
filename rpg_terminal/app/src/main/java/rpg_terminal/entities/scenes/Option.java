package rpg_terminal.entities.scenes;

public class Option {
    private String description;
    private Scene nextScene;
    private String firstMessage;
    private String message;

    public Option(String description, Scene nextScene, String firstMessage, String message) {
        this.description = description;
        this.nextScene = nextScene;
        this.firstMessage = firstMessage;
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public Scene getNextScene() {
        return nextScene;
    }

    public String getFirstMessage() {
        return firstMessage;
    }

    public String getMessage() {
        return message;
    }
}
