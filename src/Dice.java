public abstract class Dice {
    public static int roll(int timesToRoll, int sides) {
        int total = 0;
        for (int i = 0; i < timesToRoll; i++) {
            total += (int) (Math.random() * sides) + 1;
        }

        return total; 
    }
}
