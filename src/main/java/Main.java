import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    private static final List<Integer> arr = new ArrayList<>();

    public static void main(String[] args) {
        new paintWindow();
    }

    public static List<Integer> createArray(int sets) {
        for (int i = 0; i < sets + 1; i++) {
            arr.add(ThreadLocalRandom.current().nextInt(0, 11));
        }
        return arr;
    }
}
