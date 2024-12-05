package rpg_terminal.entities.scenes;

public record Option(String description, Scene nextScene, String firstMessage, String message) {
}
