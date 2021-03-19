import java.util.List;

public class Bubble {
    /**
     * Sorts the inputted array by the bubble method
     * Compares adjacent elements and swaps them if they are in the wrong order.
     * The pass through the list is repeated until the list is sorted
     *
     * @param arr The inputted array list
     * @return returns the sorted array
     */
    protected static List<Integer> bubble(List<Integer> arr) {
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
        return arr;
    }
}
