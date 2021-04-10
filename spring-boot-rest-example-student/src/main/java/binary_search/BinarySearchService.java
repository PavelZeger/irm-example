package binary_search;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Pavel Zeger
 * @implNote irm-example
 * @since 10/04/2021
 */
public final class BinarySearchService {

    private BinarySearchService() {

    }

    public static int iterativeBinarySearch(int[] array, int key) {
        Arrays.sort(array);
        int low = 0;
        int high = array.length;
        int index = Integer.MAX_VALUE;
        while (low <= high) {
            int median = (low + high) / 2;
            if (array[median] < key) {
                low = median + 1;
            } else if (array[median] > key) {
                high = median - 1;
            } else if (array[median] == key) {
                index = median;
                break;
            }
        }
        return index;
    }

    public static int recursiveBinarySearch(int[] array, int key, int low, int high) {
        Arrays.sort(array);
        int median = (low + high) / 2;
        if (high < low) {
            return -1;
        }
        if (key == array[median]) {
            return median;
        } else if (key < array[median]) {
            return recursiveBinarySearch(array, key, low, median - 1);
        } else {
            return recursiveBinarySearch(array, key, median + 1, high);
        }
    }

    public static int utilBinarySearch(int[] array, int key) {
        Arrays.sort(array);
        return Arrays.binarySearch(array, key);
    }


    public static int collectionsBinarySearch(int[] array, int key) {
        List<Integer> list = Arrays.stream(array).boxed().sorted().collect(Collectors.toList());
        return Collections.binarySearch(list, key);
    }

}
