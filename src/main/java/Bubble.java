import java.util.List;

public class Bubble {
    protected static List<Integer> bubble(List<Integer> arr) {
        System.out.println("Input Array: " + arr);
        boolean makingChanges = true;
        while (makingChanges) {
            makingChanges = false;
            for (int i = 0; i < (arr.size() - 1); i++) {
                int first = arr.get(i);
                int second = arr.get(i + 1);
                if (arr.get(i) > arr.get(i + 1)) {
                    arr.set(i, second);
                    arr.set(i + 1, first);
                    makingChanges = true;
                }
            }
        }
        System.out.println("Sorted Array" + arr);
        return arr;
    }
}
