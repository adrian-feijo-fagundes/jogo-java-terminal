package rpg_terminal;

public abstract class Screen {
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
