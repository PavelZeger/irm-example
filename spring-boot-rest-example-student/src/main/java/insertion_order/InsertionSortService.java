package insertion_order;

/**
 * @author Pavel Zeger
 * @implNote irm-example
 * @since 10/04/2021
 */
public class InsertionSortService {

    /**
     * Complexity: O(n^2)
     */
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > current) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = current;
        }
    }
}
