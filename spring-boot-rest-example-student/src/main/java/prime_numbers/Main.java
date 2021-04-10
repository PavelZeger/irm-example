package prime_numbers;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author Pavel Zeger
 * @implNote irm-example
 * @since 09/04/2021
 */
public class Main {

    public static void main(String[] args) {
        int[] numbers = IntStream.rangeClosed(0, 100).toArray();
        int[] primeNumbers = PrimeNumbersService.getPrimeNumbers(numbers);
        Arrays.stream(primeNumbers).forEach(System.out::println);
    }

}
