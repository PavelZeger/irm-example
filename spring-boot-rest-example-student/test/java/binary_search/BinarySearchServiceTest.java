package binary_search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static binary_search.BinarySearchService.*;

/**
 * @author Pavel Zeger
 * @implNote irm-example
 * @since 10/04/2021
 */
class BinarySearchServiceTest {

    @Test
    void testBinarySearch() {
        int[] actualArray = {1, 109, 235, 325, 487, 526, 918};
        int actualKey = 325;
        int expectedResult = 3;
        int actualIterativeResult = iterativeBinarySearch(actualArray, actualKey);
        int actualRecursiveResult = recursiveBinarySearch(actualArray, actualKey, 0, actualArray.length);
        int actualUtilResult = utilBinarySearch(actualArray, actualKey);
        int actualCollectionsResult = collectionsBinarySearch(actualArray, actualKey);
        Assertions.assertEquals(expectedResult, actualIterativeResult);
        Assertions.assertEquals(expectedResult, actualRecursiveResult);
        Assertions.assertEquals(expectedResult, actualUtilResult);
        Assertions.assertEquals(expectedResult, actualCollectionsResult);
    }
}
