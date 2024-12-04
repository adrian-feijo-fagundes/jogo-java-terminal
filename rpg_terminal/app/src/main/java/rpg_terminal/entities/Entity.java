package rpg_terminal.entities;

public abstract class Entity {
    private final String id;

    public Entity(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

}
