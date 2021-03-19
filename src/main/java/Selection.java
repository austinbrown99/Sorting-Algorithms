import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Selection {
    /**
     * Sorts the inputted array by the selection method
     * finding the minimum element and adds it to the beginning
     * The algorithm maintains two subarrays in a given array.
     * <p>
     * I'm sure that the way I implemented this isn't technically correct.
     * But I maintain the idea of finding the smallest number and adding it to the beginning
     *
     * @param arr The given unsorted list array
     * @return returns the sorted array
     */
    protected static List<Integer> selection(List<Integer> arr) {
        List<Integer> sortedArr = new ArrayList<>();
        while (arr.size() != 0) {
            sortedArr.add(Collections.min(arr));
            arr.remove(Collections.min(arr));
        }
        return sortedArr;
    }
}
