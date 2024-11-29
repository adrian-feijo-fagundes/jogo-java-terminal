package rpg_terminal;

public class Option {
    private String optionDescription;
    private Scene nextScene;

    public Option(String optionDescription, Scene nextScene) {
        this.optionDescription = optionDescription;
        this.nextScene = nextScene;
    }

    public String getOptionDescription() {
        return optionDescription;
    }
    
    public Scene getNextScene() {
        return nextScene;
    }

}
