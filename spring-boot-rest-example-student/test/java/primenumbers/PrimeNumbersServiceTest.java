package primenumbers;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Pavel Zeger
 * @implNote irm-example
 * @since 09/04/2021
 */
class PrimeNumbersServiceTest {

    @Test
    void testGetPrimeNumbers() {
        int[] testNumbers = IntStream.rangeClosed(0, 22).toArray();
        int[] expectedNumbers = {0, 1, 2, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21};
        int[] actualNumbers = PrimeNumbersService.getPrimeNumbers(testNumbers);
        assertArrayEquals(expectedNumbers, actualNumbers);
    }
}